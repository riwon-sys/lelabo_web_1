// [1] 게시물 등록
 const boardWrite =() =>{
	//1. input dom 가져오기
	let writerInput = document.querySelector('.writerInput')
	let pwdInput = document.querySelector('.pwdInput')
	let titleInput = document.querySelector('.titleInput')
	let contentInput = document.querySelector('.contentInput')
	
	//2. dom 에서 value 가져오기
	let bwriter = writerInput.value;
	let bpwd = pwdInput.value;
	let btitle = titleInput.value;
	let bcontent = contentInput.value;
	
	//3. 객체화
	let dataObj = {
		bwriter : bwriter , bpwd : bpwd , btitle : btitle , bcontent : bcontent }
	
	//4. 옵션
	const option ={
		method:'POST' ,
		Headers :{'Content-Type' : 'application/son' },
		body:JSON.stringify( dataObj )
	}
	//5 fetch
	fetch('/lelabo_web_1/day05/board' , option )
	.then( response => response.json() )
	.then( data => {
		if( data == true ){alert ('글쓰기 성공!'); location.href="/lelabo_web_1/day05/board.jsp";}
		else{alert('글쓰기 실패'); }
	})
	.catch (error => {alert('시스템 오류 : 관리자에게 문의'); console.log(error);})
	
} // fe