const [decreaseButton, resetButton, increaseButton] = document.getElementsByClassName('btn');
const countResult = document.querySelector('#count_result');
// console.log(decreaseButton);
// console.log(resetButton);
// console.log(countResult);



function commonHandler(number) {
    // 1단계 => 값 받아서 넘버 타입으로 바꾸기
    let count = Number.parseInt(countResult.innerText); // string => number 0
    console.log(count);
    if(number == 1) {
        count++;
    }
    else if(number ==-1) {
        count--;
    }
    else count = 0;

    countResult.innerText = count;
        
    if(count > 0) countResult.style.color = 'green';
    else if(count == 0) countResult.style.color = 'grey';
    else countResult.style.color = 'red';
}

decreaseButton.addEventListener('click', () => commonHandler(-1));
resetButton.addEventListener('click', () => commonHandler(0));
increaseButton.addEventListener('click',() => commonHandler(1));


// countResult 태그를 객체화 시킬 때 handler()함수 내에서 굳이 반복해서 선언할 필요 없이, 값이 실시간으로 바뀌어도 맨 위에 먼저 객체화를 시켜도 상관없다.
// 초기에는 버튼마다 callback_function을 선언하여 버튼을 누를 때마다 각각 호출하도록 했다가 반복되는 코드가 많아서, 콜백함수를 하나로 만들면 좋겠다고 생각해서 파라미터 값을 받는 콜백함수로 만들게 됨.
// callback_funtion(paramer)선언 할 때: () => callback_function(parameter) 형식으로 만들어야한다는 것을 알게 됨.
// 원래는 count를 판단하는 함수가 따로 있었으나, 콜백함수를 하나로 합치게 되면서 반복사용 되지 않는 이유로 판단함수를 없애고 if문을 그냥 적음.
// 한줄복사 alt shift 아래키
// 탭 종료 : Ctrl + W
// 탭 전체 종료 : Ctrl + W + K
// 방금 종료한 탭 재실행 : Ctrl + Shift + T
// 탭 이동 : Ctrl + Page Up/Down
// 다중 커서 :  Ctrl + alt + 방향키
// 좋은 코드를 작성하는 것은 효율적으로 코드를 작성하는 것같다.
// refactoring

fruits =['apple','banana','orange'];
fruits.forEach((fruit) => {console.log(fruit);})