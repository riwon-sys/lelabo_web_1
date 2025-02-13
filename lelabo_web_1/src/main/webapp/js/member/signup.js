console.log('signup.js open');

// [1] 회원가입 요청 함수
const onSignUp = () => {
	
	//1. form 자체를 한번에 가져와요. application/json ---> multipart/form-data( 첨부파일 )
	     // [*] form-data 로 전송할 경우에는 속성명을 'name' 속성으로 사용된다.
	
   const signupform = document.querySelector('#signupform'); // form 전체 가져오기
         console.log(signupform);
	
	     // [*]. fetch 함수를 이용한 'multipart/form-data' 타입으로 전송하는 방법
		       // (1) 전송 할 폼을 바이트(바이너리) 데이터로 변환, Formdata 클래스 , new FormData (폼DOM);
			   const signupformData = new FormData (signupform);
			         console.log(signupform);
					 // signupformData.append("속성명" , "값"); // 만일 html 폼에 없는 데이터를 폼데이터에 추가하는 방법
				// (2) fetch 옵션 ,
				const option = { 
					method : 'POST',
					// headers : {'Content-Type' : '' } // 생략한다.
					body : signupformData // JSON.stringfy() : 폼 전송은 json 형식이 아니므로 생략한다.
				}	 
	   	 	    // (3) fetch // 엑셀 11번 코드가 있어야 적용 가능
				fetch('/lelabo_web_1/member/signup' ,option)
				.then (response => response.json()) // 응답 자료를 'application/json'타입으로 변환
	            .then (data => {
					if(data ==true){alert('회원가입 성공'); location.href="login.jsp";} // 회원가입 성공시 메세지 안내 후 로그인페이지로 이동처리
					else{alert('회원가입 실패');}	
				})
				.catch(error => {console.log(error);}) // fetch 통신 간 오류발생시
				
	
} // fe