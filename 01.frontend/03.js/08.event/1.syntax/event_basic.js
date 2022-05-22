// 2. EventHandler property 방식 - HTML과 JS를 분리

// 가독성이 좋아야 된다.
const evPropButton = document.getElementById("btn-ev-prop");
console.log(evPropButton); //console.dir dir은 directory
// js와 java는 camelCase

// const book = {id : 1,author : '해밍웨이',title : '노인과바다'} //책이라는 object 생성
// //property로는 id, author, title
// console.log(book.title);

// js에서 함수는 일급객체이기 때문에, 객체는 값이고, 값은 프로퍼티에 할당할 수 있음
evPropButton.onclick = function() { // 익명함수 생성 및 할당
    console.log('called by event property');
}

console.log(evPropButton);
//하나의 이벤트 밖에 등록 불가 (화살표 함수 활용)
evPropButton.onclick = () => console.log('새롭게 등록된 이벤트 핸들러') // single line

//3.addEventlistener - EventHandler property(여기서는 onclick이라는 property에 영향을 미치지 않음.)

//on 접두사 생략
const addEvlsnerButton = document.getElementById('btn-add-ev-lsnr');
console.log(addEvlsnerButton);

//함수 선언문 방식으로 이벤트 핸들러 작성
function buttonHandler() {
    console.log('double clicked');
}

//addEventListener() 메서드의 인자값으로 함수를 넘겼습니다.
//그때 인자값으로 넘겨진 향수를 Callback function
//->어떤 함수의 인자값으로 함수를 넘겼을 때 넘겨진 함수
addEvlsnerButton.addEventListener('dblclick',buttonHandler);

// 콜백함수 Callback function

// 화살표 함수로 buttonHandle2라는 이름의 함수 작성
// 'mouseover'출력되도록
// 마우스를 버튼 위로 이동시켰을 때 발생하는 이벤트?

const buttonHandler2 = () => console.log('mouseover');

addEvlsnerButton.addEventListener('mouseover',buttonHandler2);

//click 이벤트 화살표 함수를 콜백함수 파라미터 자리에 직접 작성
// 'by addEventListener with arrow function' 출력되도록

addEvlsnerButton.addEventListener('click', () => {
    console.log("addEventListener with arrow function");
});

// 이벤트 핸들러 제거
// 1. EventHandler attribute 방식 : onclick attribute 코드 제거
// 2. EventHandler property 방식 :  해당 property에 null값 할당.
evPropButton.onclick = null;
// 3. addEventListner method 방식 : 별도의 이벤트 제거 함수 호출
addEvlsnerButton.removeEventListener('dblclick', buttonHandler);
addEvlsnerButton.removeEventListener('mouseover', buttonHandler2);

// click이벤트는 제거못한다.
// 익명함수(화살표 함수)니까 제거못한다.