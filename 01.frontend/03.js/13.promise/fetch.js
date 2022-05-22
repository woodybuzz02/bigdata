/**
 * XMLHttpRequest처럼 HTTP 요청 전송 기능을 지원하는 Web API
 * 사용법이 간편, Promise를 지원
 */

// 기본 프로토타입
// const fetchResponsePromise = fetch(resource [, init])
// https://developer.mozilla.org/en-US/docs/Web/API/fetch

// fetch()는 HTTP 응답(Respose)을 나타내는 respose 객체를 감싼 promise 객체를 반환
// fetch()의 첫 번째 인수로 HTTP요청을 전송할 URL을 작성하면 기본적으로 GET요청을 수행
// default값이 GET이라는 의미

const url = 'https://jsonplaceholder.typicode.com/posts/1';

// const promise = fetch(url)
// .then(response => console.log(response));
// console.log(promise);

fetch(url)
.then(response => response.json()) // json()을 사용하면 Response 객체에서 HTTP body(몸체)를 취득, 객체화(역직렬화)
.then(json => console.log(json));