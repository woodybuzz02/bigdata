const getButton = document.getElementById('get-btn');
const postButton = document.getElementById('post-btn');
const [id,realname] = document.getElementsByTagName('p');
// console.log(id);
// console.log(realname);

//npx json-server --watch data.json
//npm strat


// XMLHttpRequest 객체(인스턴스) 생성
// const a =  new XMLHttpRequest();
// const b =  new XMLHttpRequest();

// console.log(a==b);

getButton.addEventListener('click', () => {
    const xhr =  new XMLHttpRequest();

    // 요청을 보낼 준비
    xhr.open('GET','/users'); 

    // 데이터가 로딩(응답)이 완료되었을 때, 핸들러 함수 호출
    xhr.onload = () => {
        if(xhr.status === 200){
            const resposeData = JSON.parse(xhr.response);
            console.log(resposeData);

            const firstData = resposeData[0]; 
            id.textContent = firstData.id;
            realname.textContent = firstData.name;
        }
    };

    xhr.send();



} ) ;

postButton.addEventListener('click', () => {
    const xhr =  new XMLHttpRequest();
    xhr.open('POST','/users');

    xhr.setRequestHeader('content-Type','application/json');//틀린 거 없는 것같은데 안되면 콘솔창 네트워크 헤더부분에 가서 어떤 형식으로 되어있는지 확인.
    //http://www.tcpschool.com/ajax/ajax_header_request
    
    xhr.onload = () => {          
        if(xhr.status === 200 || xhr.status === 201){
            console.log(xhr.respose);
        }
    };

    const newUser = {
        id: 11,
        name: 'hogu',
        username: 'tired',
        company : {
            id: 'c1',
            name: 'playdata'
        },
    };
    const jsonData = JSON.stringify(newUser);

    xhr.send(jsonData);//보낼 때는 send에 보낸다.

    


});