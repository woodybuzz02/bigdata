// Web API인 DOM 활용
const countValue = document.getElementById('value'); // count의 값을 담는 변수
let countButtons = document.getElementsByClassName('btn'); // HTMLCollection, 유사배열
// 배열처럼 동작은 하나, 배열 타입은 아님

//배열 타입으로 변환(casting)
countButtons = Array.from(countButtons);
const isTrue = Array.isArray(countButtons); // 변수 네이밍 컨벤션 : is it True ? "true"

// function myFunc() {};
// countButtons.forEach(myFunc);

// count값, count값에 따른 폰트 색 변경 값 저장용 변수
let count = 0;
let countValueColor = '';

// forEach() : Array 객체(클래스)가 제공하는 함수(메서드)
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/forEach

// forEach()의 인자값으로 화살표 함수를 전달했고,
// 화살표 함수의 인자값으로 button 변수를 전달했음.
countButtons.forEach((button) => {
    // console.log(button); // button 객체
    // 각 button에 click event 추가.

    // https://developer.mozilla.org/en-US/docs/Web/API/EventTarget/addEventListener

    // addEventListener에 등록된 콜백함수(화살표 함수 형태)를 이벤트 핸들러라고 함.
    // 이벤트 핸들러란? 사용자가 click 이벤트를 발생시켰을 때 그 처리를 담당할 담당자(핸들러)
    button.addEventListener('click', (event) => {
        // console.log(event); // 화살표 함수의 첫 번째 인자값으로 이벤트와 관련된 다양한 정보를 가지고 있는 객체, e라고 써도 상관없음.
        const curTarget = event.currentTarget; // 이벤트 핸들러에 바인딩된 DOM 객체
        const styles = curTarget.classList[1]; // html element에 작성한 class의 이름을 가져오기 위한 프로퍼티

        // if(styles === 'decrease') {
        //     --count;
        // } else {
        //     ++count;
        // }

        // Ternay operator
        // count = (styles === 'decrease') ? --count : ++count;

        // +, -, *, /, %, =, .(dot, 객체의 프로퍼티 참조 연산자), 
        
        count = styles !== 'reset' ? (styles === 'decrease' ? --count : ++count) : 0;
        
        // count의 값이 0이면 grey, 양수면 green, 음수면 red
        countValueColor = count !== 0 ? (countValueColor = count > 0 ? 'green' : 'red') : 'grey';
        console.log(countValueColor);

        // 변경할 값(count값, count값의 색)을 실제 화면에 적용하는 부분
        countValue.textContent = count;
        countValue.style.color = countValueColor;
    }); // addEventListener() 끝
}); // forEach() 끝

// Array.prototype.forEach
// 화살표 함수를 forEach() 함수의 인자값으로 전달함.
// 그때 전달된 화살표 함수를 콜백 함수(callback function)라고 함.

// const myArr = [ 1,2,3,4, 'ff', { id: 1, title: '노인과 바다'} ];
// console.log(myArr);

// fruits = ['apple', 'banana', 'kiwi'];
// fruits.forEach((item) => { // fruit, item, element
//     console.log(item);
// });