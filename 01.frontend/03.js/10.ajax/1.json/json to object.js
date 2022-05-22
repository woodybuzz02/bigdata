const book = {
    title:"노인과 바다",
    author: "해밍웨이",
    isSold: false,
    genere: ["소설","비극"],
};

const responeData = JSON.stringift(book);

console.log(responeData);

const responseParsing = JSON.parse(responeData);
console.log(responseParsing);
console.log(responseParsing.title);
console.log(responseParsing.author);
console.log(responseParsing.isSold);
console.log(responseParsing.genere);

const books = [
    { id: 1, title: '하농', author: '하농', isSold: false },
    { id: 2, title: '체르니', author: '체르니', isSold: true},
    { id: 3, title: '부르크뮐러', authro: '부르크뮐러', isSold: true},
];

//서버에서 응답한 데이터라고 가정.
const responeData2 = JSON.stringift(books);
console.log(responeData2);

//JSON 포맷의 문자열을 배열로 변환(역직렬화, deSerialization)
const parseData = JSON.parse(responeData2);
//parseData : 파싱처리가 완료된 데이터.

console.log(typeof parseData, parseData);
