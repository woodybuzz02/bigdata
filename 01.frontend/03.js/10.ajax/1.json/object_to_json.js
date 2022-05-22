/**
 * JSON : 클라이언트와 서버 간 HTTP 통신을 위한 텍스트(string) 데이터 포맷 방식
 * JavaScript에 종속되지 않는 독립적인 데이터 포맷
 * 대부분의 프로그래밍 언어에서 사용 가능
 */

// JSON 작성 방식 : JavaScript의 객체 작성 방식과 유사


// Javascript Object
const book = {
    title: "노인과 바다",
    author: "헤밍웨이",
    isSold: false,
    genere: ["소설", "비극"],
};

// JSON, key(property)값을 ""( 쌍따옴표, double quote )로 작성, ( '(single quote)는 사용 불가 )
// {
//     "title": "노인과 바다",
//     "author": "헤밍웨이",
//     "isSold": false,
//     "genere": ["소설", "비극"], 
// }

const jsonData = JSON.stringify(book);
console.log(typeof jsonData);
console.log(jsonData);
console.log(book);

console.log(jsonData.title); // 문자열 타입이기 때문에 프로퍼티 참조 불가.
console.log(book.title); // 객체이기 때문에 프로퍼티값을 참조 가능.

/**
 * JSON.stringify()는 Client 측에서 서버로 데이터(일반적으로 객체)를 전송하기 위해 객체를 문자열화해야함.
 * 문자열화를 직렬화(Serialization)라고 함.
 */

const books = [
    { id: 1, title: '하농', author: '하농', isSold: false },
    { id: 2, title: '체르니', author: '체르니', isSold: true},
    { id: 3, title: '부르크뮐러', authro: '부르크뮐러', isSold: true},
];

// 배열을 JSON 포맷의 문자열로 변환
const jsonData2 = JSON.stringify(books);
console.log(typeof jsonData2, jsonData2);
