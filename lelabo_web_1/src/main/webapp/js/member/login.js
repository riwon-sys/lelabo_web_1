console.log('login.js open')

// 1. 로그인 요청 함수 
const onLogin =()=> {
	//[1]. html input dom 가져오기
	const midinput = document.querySelector('.midinput');
	const mpwdinput = document.querySelector('.mpwdinput');
	//[2]. INPUT 입력값 가져오기
	const mid= midinput.value;
	const mpwd=mpwdinput.value;
	
	//[3]. 유효성검사
	//[4]. fetch 
	// [*] 보낼 데이터를 객체(json)화
	const obj = { mid : mid , mpwd : mpwd }
	// [*] 설정
	const option ={
		method : 'POST' ,
		headers : {'Content-Type' : 'application/json'}, // -요청할 http body 타입 요청
		body : JSON.stringify(obj) // -요청할 http 자료 , 자료를 json 형식의 문자열 타입으로 변환
	}
	// [*] fetch
	fetch('/lelabo_web_1/member/login' , option)
	.then (response => response.json())
	.then(data => {
		if(data >0){alert('로그인 성공');
			console.log(alarmSocket);
			// websocket 中 [3] . 로그인 성공했을때 , 클라이언트가 서버에 로그인한 상태를 메시지 보내요.
			// [3] . [*] login.js 의 경우에는 fetch 가 로그인 성공 응답을 가져오면 그때 서버에 로그인한 상태를 메시지 보내요.
			// [3] . [*] login.jsp 의 경우에는 header.jsp를 포함하고 있으므로 header.js 의 변수 내지 함수를 login.js에서 사용 가능해요.
			alarmSocket.send(`${mid}님 접속했습니다.`);
// ===================================================================================================================			
			location.href="../index.jsp";} // 상위 폴더로 이동이라는 뜻
	    else{alert('로그인 실패');}
	})
	.catch(error => {console.log(error)})
} //fe