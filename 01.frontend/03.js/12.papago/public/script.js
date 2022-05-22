//변수 네이밍 컨벤션, 도메인과 관련된 용어를 정의
//source : 번역할 텍스트와 관련된 명칭
//target : 번역된 결과와 관련된 명칭
const [sourceTextArea, targetTextArea] = document.getElementsByTagName("textarea");
//태그의 있는 div, li, p 와 같은 특정 태그명을 가지고 있는 element 의 집합을 가져오는 함수
//console.log(sourceTextArea,targetTextArea);

const [sourceSelect, targetSelect] = document.getElementsByTagName('select');
//console.log(sourceSelect, targetSelect);

// 번역할 언어의 기본 타입(en)
let targetLanguage = 'en';

//어떤 언어로 번역할 지 선택하는 targetbox의 option(선택지)의 값이 바뀔 때마다 이벤트가 발생.
targetSelect.addEventListener('change',() =>{
    const selectedIndex = targetSelect.selectedIndex;
    targetLanguage = targetSelect.options[selectedIndex].value;
});

let debouncer;  // debouncer 변수 선언
sourceTextArea.addEventListener('input', (event) => {
    // ㅇ(타이머 카운트 시작..0..1)ㅏㄴ(타이머 카운트 초기화, 다시시작 0..1..2) 녕(타이머 카운트 다시 초기화)
    if(debouncer){//debouncer에 TimerID값이 있으면 (카운팅 하고 있다는 의미)
        clearTimeout(debouncer)// 현재 타이머 카운트 초기화
    }

    debouncer = setTimeout(() => {
        const text = event.target.value;
        console.log(text);
        
        if(text) { // text 변수에 값이 있을 경우 true, ''(공백)일 경우 false
        // 비동기 요청을 도와주는  Web API 객체 생성
        const xhr = new XMLHttpRequest();
        // 현재 대부분의 주요 웹 브라우저는 서버에 데이터를 요청하기 위한 XMLHttpRequest 객체를 내장하고 있습니다.
        // XMLHttpRequest 객체는 서버로부터 XML 데이터를 전송받아 처리하는 데 사용됩니다.
        // 이 객체를 사용하면 웹 페이지가 전부 로딩된 후에도 서버에 데이터를 요청하거나 서버로부터 데이터를 전송받을 수 있습니다.
        // 즉, 웹 페이지 전체를 다시 로딩하지 않고 일부분만을 갱신할 수 있게 됩니다.    


        // node 서버의 특정 url 주소
        const url = '/detectLangs'

        //onreadystatechange 프로퍼티는 XMLHttpRequest 객체의 readyState 프로퍼티 값이 변할 때마다 자동으로 호출되는 함수를 설정합니다.
        //Ajax에서 서버로부터의 응답을 확인하기 위해 사용.
        xhr.onreadystatechange = () => {
            if(xhr.readyState === 4 && xhr.status === 200){
                //readyState 프로퍼티는 XMLHttpRequest 객체의 현재 상태
                //  1. UNSENT (숫자 0) : XMLHttpRequest 객체가 생성됨.
                //  2. OPENED (숫자 1) : open() 메소드가 성공적으로 실행됨.
                //  3. HEADERS_RECEIVED (숫자 2) : 모든 요청에 대한 응답이 도착함.
                //  4. LOADING (숫자 3) : 요청한 데이터를 처리 중임.
                //  5. DONE (숫자 4) : 요청한 데이터의 처리가 완료되어 응답할 준비가 완료됨.
                //status 프로퍼티
                // status 프로퍼티는 서버의 문서 상태를 나타냅니다.
                //  - 200 : 서버에 문서가 존재함.
                //  - 404 : 서버에 문서가 존재하지 않음.
                console.log(JSON.parse(xhr.responseText));
                const responseData = JSON.parse(xhr.responseText);
                
                const result = responseData['message']['result'];

                // 번역된 텍스트를 결과 화면에 입력
                targetTextArea.value = result['translatedText'];
            }
        };


        //요청 준비
        xhr.open('post',url); 
        //request를 보내고자하는 사이트의 url을 세팅하는 부분
        //const url = '/detectLangs' (언어감지)

        //Node 서버에 보낼 객체 형태의 JSON 데이터
        const requestData = { //typeof :object
            text,
            targetLanguage,

        };

        xhr.setRequestHeader('Content-type', 'application/json');
        //HTTP요청 헤더의 값을 설정
        //open()뒤에 호출, send()호출되기 전에 호출

        // JSON의 타입은 ? string 그래서 JavaScript 값이나 객체를 JSON 문자열로 변환.
        const objectToJson = JSON.stringify(requestData);

        //요청 전송 //detectLangs(node 서버)로 objectToJson를 보낸다.
        xhr.send(objectToJson);
        }
    }, 2000); //2초 후에 콜백 함수 호출.
});