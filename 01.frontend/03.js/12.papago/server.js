//npm init 명령어는 새로운 프로젝트나 패키지를 만들 때 사용하며, 프로젝트 및 패키지의 기본 정보를 담고 있는 package.json 파일을 생성
//package.json 파일이 만들어졌다면, 익스프레스(Express)를 설치 npm install express
//Node.js는 자바스크립트를 브라우저외에서도 실행하는데 사용되는 자바스크립트 플랫폼
//에디터에서도 실행가능, 자바스크립트 문법을 가지고 '서버'를 만들 수 있다.
//웹 API : DOM, XMLHttpRequest
//Express는 Node.js의 웹 서버 기능 위에 올라가는 상대적으로 작은 프레임워크
//Express는 Node.js로 웹 애플리케이션을 더 쉽게 만들게 한다.


const express = require('express'); // express 모듈을 불러와 express 변수에 담는다.
const app = express(); // express 모듈을 호출(실행)하여 app 객체 생성

// API Key를 별도로 관리 : dot(.)env 활용, .env라는 파일에 key를 보관하고, dotenv

const dotenv= require('dotenv');
dotenv.config();
const clientId = process.env.CLIENT_ID
const clientSecret = process.env.CLIENT_SECRET

const request = require('request'); // request 패키지 import
// request은 url에 요청을 보내고 response를 받는 모듈

// express의 static 미들웨어 활용. 미들웨어(작은 핸들러 함수)
// express에게 static(정적인 파일) 관련 자원은 public 폴더 내에 있음을 명시.
app.use(express.static('public'));


// expressjs에서 웹 서비스를 제작 했을때, json으로 이루어진 Request Body를 받았을 경우, 요청값을 제대로 받아오지 못하는 문제가 발생한다.
// expressjs에서는 이러한 문제를 해결하는 방법으로 express.json() 사용.
// express의 json 미들웨어 활용.
// express에게 json 파싱을 위임

app.use(express.json());

// localhost:3000/ -> 요청을 받으면 해당 함수 호출
app.get('/', (request, response) => {
    // console.log(__dirname);
    //__dirname는 현재 실행 중인 폴더 경로.
    response.sendFile(__dirname, 'index.html');
});

// 브라우저로부터 감지할 언어의 텍스트를 받아서, Naver 서버로 전송(요청) 및 결과 응답
app.post('/detectLangs', (req, res) => {
   // 127.0.0.1:3000/detectLangs로 요청했을 때 objectToJson가 파싱후 req로 옴.
   console.log(typeof req.body, req.body); //object {text: , targetLanguage: 'en'}
   const { text:query, targetLanguage } = req.body;
   //console.log(query, targetLanguage);
   
   const url = 'https://openapi.naver.com/v1/papago/detectLangs'; //언어 감지 API 레퍼런스

   const options = {
       url, // 언어감지 네이버 서버의 주소
       form: { query }, // form이라는 property에 우리가 보낼 데이터를 객체의 형태로 전송
       headers: {
           "X-Naver-Client-Id": clientId,
           "X-Naver-Client-Secret": clientSecret,
       },
   };

// request.post('요청에 필요한 데이터 동봉', '요청에 따른 응답 정보를 확인하는 콜백함수');
// options에 요청에 필요한 데이터들을 보관
// () => {}: 요청에 따른 응답 정보 확인
// 언어감지 요청 부분
    request.post(options, (error, response, body) => {//options 요청메시지로 보면 된다.
        if(!error && response.statusCode === 200) {
            const parsedBody = JSON.parse(body); //{ "langCode" : "ko" } <- body
            // {langCode: 'ko'} <- parsedBody

            // papago 번역 url로 재요청(redirect), querystring활용
            res.redirect(`translate?lang=${parsedBody['langCode']}&targetLanguage=${targetLanguage}&query=${query}`);
            // localhost:3000/translate?lang=ko&targetLanguage=en&query=안녕
        } else {
            console.log(`error = ${response.statusCode}`);
        }
    });
});

// papago 번역 요청 부분.
app.get('/translate', (req, res) => {
    console.log('translate', req.query); //res.redirect했던 것 req.query로 옴.
    
    // Papago 번역 url 작성
    const url = 'https://openapi.naver.com/v1/papago/n2mt';
    // 서버에 보낼 데이터 동봉
    const options = {
        url, //요청 URL
        form: { //요청 파라미터
            source: req.query['lang'],
            target: req.query['targetLanguage'],
            text: req.query['query'],
        },
        headers: { //client id와 secret 값
            "X-Naver-Client-Id": clientId,
            "X-Naver-Client-Secret": clientSecret,
        }
    };
    // 요청 전송 및 응답 결과 확인
    request.post(options, (error, response, body) => { // 응답정보(response message) = response
        if (!error && response.statusCode == 200) {
            //console.log(body);
            res.setHeader('Content-Type', 'application/json');
            res.send(body); //브라우저한테 응답 메시지(결과) 전송
        } else {
            console.log(`error = ${response.statusCode}`);
        }   
        });
});

app.listen(3000, () => {
    console.log('http://127.0.0.1:3000/ app listening on port 3000!');
});