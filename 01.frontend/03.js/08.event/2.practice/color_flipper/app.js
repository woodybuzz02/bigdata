const btn=document.getElementById('btn');
console.log(btn);

const color = document.querySelector('.color');
console.dir(color);


//버튼 한 번 클릭했을 때 'button clicked!'
//addEventListener 활용, 화살표 함수를 콜백함수로 직접 작성
// btn.addEventListener('이벤트 동작', 콜백 함수);
// btn.addEventListener('click', ()=>{});
btn.addEventListener('click', () => {
    //console.log('button clicked!');
    
    const randomRGBArray = getRandomNumber(0, 255); //이렇게만 쓰면 한번 실행하고 끝남. 
    const [r,g,b] = randomRGBArray;
    // 한줄로 작성
    // const [r,g,b] = getRandomNumber(0, 255); // de structure ing

    // const book = {};
    // console.log(typeof book);

    //배열확인할때는 isArray typeof하면 object나옴. 콘솔만 보면 배열인지 객체인지 구분이 안됨.


    // const r = randomRGBArray[0];
    // const g = randomRGBArray[1];
    // const b = randomRGBArray[2];

    const rgbcolor = `rgba(${r},${g},${b})`;
    //템플릿 리터럴 문자열로 만듬

    //실제 값 바인딩, 매핑
    color.textContent = rgbcolor;//hard coded
    // console.log(typeof `${r},${g},${b}`);
    // console.dir(color);

    color.style.color = rgbcolor;

    const body = document.querySelector('body');
    body.style.backgroundColor = rgbcolor;
    


    const book = {
        id: 1,
        author: '해밍웨이',
        pub:{
            pubName: '위키북스',
            pubOwner : '위키맨'
        }
    }

    console.log(book.pub.pubName);

});

btn.addEventListener('mouseover', () => {
    // 랜덤값 추출(0 ~ 455) 함수 호출
});

function getRandomNumber(min, max){
    //rgb 랜덤값 추출
    let randomRGBArray = [];
    console.log(Array.isArray(randomRGBArray));

    for (let i = 0; i<3; i++){
        const randomnumber = Math.floor(Math.random() * (max - min + 1)) + min;
        randomRGBArray.push(randomnumber);
    }

    return randomRGBArray;
   
}

// Math.random이란 0~1(1은 미포함) 구간에서 부동소수점의 난수를 생성
// Math.floor() 함수는 소수점 1번째 자리를 버림하여 정수를 리턴하는 함수

