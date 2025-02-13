// [수정 전 정보 조회] 게시물 개별 조회
const boardView=()=>{
	let bno = new URL( location.href).searchParams.get('bno');
const option = {method : 'GET'}
fetch(`/lelabo_web_1/day05/board/view?bno=${bno}`,option )
.then(response => response.json())
.then(data => {
	document.querySelector('.titleInput').value =`${data.btitle}`
	document.querySelector('.contentInput').value =`${data.bcontent}`
})
.catch(error => {console.log(error)})
} //fe

boardView();

// [수정처리]
const boardUpdate = ()=>{
	//1.수정할 게시물 번호
	let bno = new URL( location.href).searchParams.get('bno');
	
	//2.input DOM 객체 가져오기
	let titleInput = document.querySelector('.titleInput')
	let contentInput = document.querySelector('.contentInput')
	
	//3. 가져온 DOM 객체로부터 value(입력값속성) 값 가져오기
	let btitle = titleInput.value;
	let bcontent =contentInput.value;
	
	//4. 객체화
	let dataObj={bno :bno , btitle:btitle , bcontent:bcontent }
	
	//5.fetch
	const option ={
		method : 'PUT',
		headers : {'Content-Type':'application/json'},
		body : JSON.stringify(dataObj)
	}// oe
    fetch(`/lelabo_web_1/day05/board` , option)
	.then(response => response.json())
	.then(data => {
		if(data ==true){
			alert('수정 성공')
			location.href=`view.jsp?bno=${bno}`;
		}else {alert('수정실패');}
	})
    .catch(e => {console.log(e);})
}//fe