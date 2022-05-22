// const book = {
//     id: 1,
//     name:'노인과 바다',
//     checkStock: function(){
//         console.log('재고 없어!');
//     }
// }

// console.log(book.checkStock); //출력하고 끝났는데 또 출력하라고 해서 undefined가 뜨는 거다.

// const checkBookStock = () => console.log('재고 없다고!');

// console.log(checkBookStock);

// //checkStock 프로퍼티

// //checkBookStock()

const xhr =  new XMLHttpRequest();

// 요청을 보낼 준비
// xhr.open(요청 메서드, 요청 URL);
xhr.open('GET','https://jsonplaceholder.typicode.com/todos'); // 'GET': 서버의 데이터를 조회하고 싶을 때
console.log(`OPENED, ${xhr.readyState}`); // OPENED, 1

// readState 프로퍼티의 값이 변경될 때마다 arrow fn 호출
xhr.onreadystatechange = () => {
    if(xhr.readyState == 2) {
        console.log(`HEADERS_RECEIVED ${xhr.readyState}`);
    }

    // 데이터 응답(로딩) 완료와 같음. == onload
    if(xhr.readyState == 4 && xhr.status == 200){
        console.log(`DONE, ${xhr.responseText}`);
        console.log(`response data: ${typeof xhr.responseText}`); //string json형식으로 데이터를 받았기때문이다.
    }
};

// 브라우저가 데이터를 받는 동안 주기적으로 발생
xhr.onprogress = () => console.log(`LOADING,  ${xhr.readyState}`);

// 데이터 응답(로딩)이 완료된 경우
xhr.onload = () => console.log(`DONE,${xhr.readyState}`);

xhr.send();



// XMLHttpRequest 객체의 프로퍼티와 메서드
// 참고사이트 : https://developer.mozilla.org/ko/docs/Web/API/XMLHttpRequest

// 1. readyState: HTTP 요청의 현재 상태를 가지고 있는 정수값.

// 0 - (UNSENT) - 초기화 전. open( ) 호출하기 전.
// 1 - (OPENED) - 열림. open( )를 호출했고, send( )는 호출하지 않은 상태
// 2 - (HEADERS_RECEIVED) - 보냄. send( )를 호출했지만 서버로부터 응답은 받지 못한 상태
// 3 - (LOADING) - 데이터 수신 중. 응답 데이터의 일부를 받고 있는 상태
// 4 - (DONE) - 완료. 응답 데이터를 모두 받은 상태.

// 2. status: HTTP 요청에 대한 응답의 성공 여부를 나타내는 정수값.
// ex) 200 (응답 성공), 404(요청 실패, 잘못된 경로)

// 3. statusText: HTTP 요청에 대한 응답 메시지를 나타내는 문자열
// ex) status가 200일 경우, "OK"

// 4. responseType: 응답한 데이터의 타입
// ex) document, json, text, blob

// 5. response: HTTP 요청에 대한 응답 몸체(body)

// 이벤트 핸들러와 관련된 프로퍼티
// onreadystatechange: readyState 프로퍼티의 값이 변경된 경우 발생

// 메서드
// 1. open( ): HTTP 요청 초기화(준비단계)
// 2. send( ): HTTP 요청 실제 전송

//xhr.open -> xhr.onreadystatechange -> xhr.send() 데이터 불러오기위해 필수.