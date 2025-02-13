
// [3] 게시물 개별 조회
const boardView = () => {
	//1. 현재 URL 의 쿼리스트링의 매개변수 가져온다. html/css/js day25 참고해요
	// [*] 내가 board.jsp 에서 클릭한 게시물 번호가 존재하면 쿼리스트링해요!
	// http://localhost:8080/lelabo_web_1/day05/view.jsp?bno=3
	// http://localhost:8080/lelabo_web_1/day05/view.jsp?bno=2
	// http://localhost:8080/lelabo_web_1/day05/view.jsp?bno=10
	let bno = new URL(location.href).searchParams.get('bno');
	
    //2. fetch 옵션
	const option ={method : 'GET' }
	//3. fetch 통신
	fetch(`/lelabo_web_1/day05/board/view?bno=${bno}` , option )
	.then( response => response.json())
	.then( data => {
		//4. fetch 출력
		document.querySelector('.bdatebox').innerHTML = `${data.bdate}`
		document.querySelector('.bwriterbox').innerHTML = `${data.bwriter}`
		document.querySelector('.bviewbox').innerHTML = `${data.bview}`
		document.querySelector('.btitlebox').innerHTML = `${data.btitle}`
		document.querySelector('.bcontentbox').innerHTML = `${data.bcontent}`
		//[-] 다른 함수에서 게시물 정보를 이용하기 위해 게시물 정보를 전역변수로 이동
		boardInfo=data; 
	})	
	.catch(error => {console.log(error)})
}// fe
boardView(); // js가 열릴때 최초 실행


// 게시물 정보 객체 전역변수
let boardInfo = null;


// [4] 게시물 개별 삭제
const boardDelete= () => {
  //1. 어떤 게시물을 삭제 할건가요? 쿼리스트링에 존재해요
  let bno = new URL(location.href).searchParams.get('bno');
	  
  //2. 삭제할 게시물의 비밀번호 검증
   let passwordCheck = prompt(' 게시물 비밀번호 : ')
   
      // 만약에 현재 게시물의 비밀번호가 일치하지 않으면
	  if(boardInfo.bpwd != passwordCheck){
		alert(' 비밀번호 불일치 !!! '); // 안내
		return;
	  }
   //3. 검증이 맞다면 fetch 이용한 삭제 요청!
   const option = {method :'DELETE'}
   fetch(`/lelabo_web_1/day05/board?bno=${bno}` , option)
   .then(response=> response.json())
   .then(data =>{
	if(data==true){
		alert('삭제 성공!');
		location.href="board.jsp";
	}else{alert('삭제실패');}
   })
   .catch(e => {console.log(e);})	  	  
} //fe

//- js에서 현재 페이지 쿼리스트링 매개변수 가져오기
//- new URL (locaation.href) : 현재 url 정보 가져오기
//- .searchParams : 쿼리스트링 매개변수들이에요.
//- .get ('매개변수명') : 매개변수들에서 특정한 매개변수의 값을 반환해요.


// [5] 게시물 수정 페이지 이동
const boardUpdate = () => {
	//1. 비밀번호 검증
	let passwordCheck = prompt('게시물 비밀번호 : ')
	if( boardInfo.bpwd != passwordCheck){
		alert(' 비밀번호 불일치 !!! ')
		return;
	}
	//2. 검증이 일치 하다면 수정 페이지로 이동
	   // -location.href="경로" : 페이지 이동 함수
	   location.href = `update.jsp?bno=${boardInfo.bno}`
} // fe