// 비동기 방식(Aynchronous)

/**
 * 현재 실행 중인 작업(task)이 아직 끝나지 않은 상태라고 해도, 다음 작업을 곧바로 실행하는 방식
 */

 function firstWork(){
    console.log('첫 번째 작업 수행');
}

function secondWork(){
    console.log('두 번째 작업 수행');
}

// 비동기 처리를 수행해주는 몇가지 함수를 활용
// 타이머 함수(Timer), setTimeout()의 특징 중 하나는 블로킹(작업 중단)을 하지 않고,
// 비동기적으로 처리함.

setTimeout(firstWork, 3*1000); // 지정한 3*1000 이후에 콜백 함수 firstWork() 호출
secondWork();

/**
 * 비동기 처리 방식은 현재 실행 중인 작업(task)이 종료되지 않은 상태라고 해도,
 * 다음 작업(task)을 곧바로 수행하기 때문에 블로킹이 발생하지 않음(장점)
 * 단점 : 작업(task)의 실행 순서가 보장되지 않음.
 * 
 * 비동기 처리 방식으로는 동작하는 함수들 : setTimeout(), setInterval(), HTTP 요청, 이벤트 핸들러(Eventhandler)
 */


