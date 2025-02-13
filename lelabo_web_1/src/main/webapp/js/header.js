console.log('header.js open');
//[1] 로그인 정보 요청 함수 
const getLoginInfo = ( ) => {
        const option = { method : 'GET' } 
        
        let loginmenu = document.querySelector('.loginmenu'); // (1)로그인 메뉴를 출력할 구역 가져오기 
        
        let html = ``; // (2) html 변수 선언 
        
        fetch( '/lelabo_web_1/member/info' , option )
                .then( r => r.json() )
                .then( data =>{
                        console.log( data ); // 코드 변경후 서버가 자동 재실행이 되면 세션 초기화.
                        if( data == null ){console.log('비로그인상태');
                                // (3) 각 상태에 따라 로그인 메뉴 구성
                                html += `<li class="nav-item"> <a class="nav-link" href="/lelabo_web_1/member/login.jsp">로그인</a> </li>
                                                <li class="nav-item"> <a class="nav-link" href="/lelabo_web_1/member/signup.jsp">회원가입</a> </li>`
                        }
                        else{ console.log('로그인상태');
                                // (3) 각 상태에 따라 로그인 메뉴 구성
                                html += `<li class="nav-item dropdown">
                                                  <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                                    <img class="header_profile" src="/lelabo_web_1/upload/${ data.mimg }" /> ${ data.mid }님
                                                  </a>
                                                  <ul class="dropdown-menu">
                                                          <li class="nav-item"> <a class="nav-link" href="#"> ${ data.mpoint} POINT </a> </li>
                                                          <li class="nav-item"> <a class="nav-link" href="/lelabo_web_1/member/info.jsp">마이페이지</a> </li>
                                                          <li class="nav-item"> <a class="nav-link" href="#" onclick="onLogOut()">로그아웃</a> </li>
                                                  </ul>
                                                </li>
                                                `
                        }
                        // (4) 구성한 메뉴들을 innerHTML 한다.
                        loginmenu.innerHTML = html;
                })
                .catch( e => {console.log(e); })
}; // f end 
getLoginInfo(); // JS가 열렸을때 최초 1번 실행

// [2] 로그아웃 요청 함수 
const onLogOut = ( ) => {
        const option = { method : 'DELETE' }
        fetch( '/lelabo_web_1/member/login' , option )
                .then( response =>  response.json() )
                .then( data => {
                        if( data==true){ 
                                alert('로그아웃합니다.'); 
                                location.href="/lelabo_web_1/member/login.jsp"; 
                        }
                })
                .catch( e => {console.log(e); })
				
} // f end 

// [1] . > header.js 에서 클라이언트소켓을 서버소켓 주소로부터 연결해보아요.(이동)
// [3] 알람요청 함수
const alarmSocket= new WebSocket('ws://localhost:8080/lelabo_web_1/alarmsocket');

// [5] . 서버소켓으로 클라이언트 소켓이 메시지를 받았을 경우에요.
// [5] . [*] header.js : 메시지를 받는 행위는 모든 페이지에서 해야하므로.
alarmSocket.onmessage =(msgEvent)=>{
	console.log( msgEvent ); // 알람 메시지를 alert 띄우기
	
	// [6] . 부트스트랩 JS 中 토스트를 활용해보아요.
	// [6] . 1. 어디에
	const alarmbox = document.querySelector('.alarmbox');
	// [6] . 2. 무엇을
	let html =`<div class ="toast show" role="alert" aria-live="assertive" aria-atomic="true">
	           <div class ="toast-header">
			       <strong class="me-auto">${msgEvent.data}</strong>
				   <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="close"></button>
			   </div>
			   </div>`
	// [6] . 3. 출력
	alarmbox.innerHTML = html;
} //fe






















