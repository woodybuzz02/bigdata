// 콜백 함수 - 기본

// name : parameter(매개변수), argument(인자값)
function greeting(name) {
    console.log(`hello ${name}`);
}

// 함수 호출부s)
// greeting('you'); // 인자값(argument)

function processUserInput(name, callbackFn) { //callbackFn: 콜백 함수
    callbackFn(name);
}

const buttonHandler = function() {
    console.log('버튼 이벤트 처리용 핸들러 항수');
}

const buttonHandler2 = () => console.log('버튼 이벤트 처리용 핸들러 항수');
// console.log(buttonHandler);
// buttonHandler(); // 변수에 들어있는 값이 함수일 경우, 변수명 뒤에 ()를 추가하여 호출 가능.

processUserInput('YOO', greeting);
// 그 다음 코드

// 쿠팡에서 물건이 도착하면 옆집 아주머니에게 전달
function waitCoupang(pkg, callback) {
    console.log(`쿠팡에서 ${pkg}가 도착했다.`);

    callback();
}

function bringToNeighbor(){
    console.log('옆집 아주머니에게 전달 완료!');
}

waitCoupang('모니터',bringToNeighbor);


document.querySelector('button').addEventListener('click', () => {
    console.log('button clicked!');
});