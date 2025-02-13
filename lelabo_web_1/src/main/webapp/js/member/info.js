console.log('info.js open');

// 1. 현재 로그인된 회원정보 요청 함수
const getMyInfo = () =>{
	
	//fecth 옵션
	const option = { method : 'GET'}; console.log('option');
	
	//fecth 실행
	fetch('/lelabo_web_1/member/info' , option) 
	     .then( r => r.json())
		 .then( data => {
			console.log(data);
			if(data !=null){ // 로그인 상태이면
				
				// 특정한 dom 에 정보대입하기
				document.querySelector('.mid').value=data.mid
				document.querySelector('.mname').value=data.mname
				document.querySelector('.mphone').value=data.mphone
				//  img 마크업에 이미지 경로 대입하는 방법 .src 속성 이용 
				document.querySelector('.mimg').src=`/lelabo_web_1/upload/${data.mimg}`
			}
		 })
		 .catch(e => {console.log(e)})
}// fe

getMyInfo(); // js가 열렸을때 최초1회 실행

// 2. 회원탈퇴
const onDelete = () =>{
	
	// alert : 알림창, confirm : 확인/취소 알림창 , prompt : 입력상자 알림창
	let result = confirm('정말 탈퇴 하실건가요?');
	if(result == false)return; // 만약에 취소버튼을 눌렀다면 탈퇴요청 취소 
	
	
	//fetch 옵션
	const option = {method : 'DELETE'}
	fetch('/lelaba_web_1/member/info',option)
	      .then(r => r.json())
		  .then(data => {
			if(data==true){
				alert(' 탈퇴 성공 '); location.href="/lelabo_web_1/index.jsp";
				}else{alert(' 탈퇴 실패 : 관리자에게 문의하십쇼 ');}
		  })
          .catch(e =>  {console.log(e)})
}// fe

// 3. 회원수정 페이지로 이동!
const onUpdate = () =>{
	location.href="./update.jsp"; // update.jsp 페이지로 이동
	// 게시판에서는 게시물번호가 세션이 없으므로 ?bno=3 해야한다. 하지만 수정할 회원번호(로그인된)가 세션이 있으므로 굳이 할 필요가 없다.
	// 현재 페이지와 이동할 페이지가 같은 폴더이면 지정 파일명 작성 , 만일 다른 폴더이면 프로젝트명 부터 작성 , ../ 상대경로 작성
}// fe

 
 	
// [4] 내 포인트 내역 조회 요청 
const getPointLog = ( ) => {
        // fetch 옵션 
        const option = { method : 'GET' }
        // fetch 실행 
        fetch( '/lelabo_web_1/point' , option )
                .then( r => r.json() )
                .then( data => { 
                        if( data != null ){ // 로그인 상태이면 
                                const tbody = document.querySelector('tbody');
                                
                                let html = ``;
                                
                                data.forEach(  (point) =>{
                                        html += `<tr>
                                                                <th> ${ point.pono} </th> 
                                                                <th> ${ point.pocomment } </th>
                                                                <th> ${ point.pocount } </th> 
                                                                <th> ${ point.podate } </th>
                                                        </tr>`
                                })
                                
                                tbody.innerHTML = html;
                        }
                })
                .catch( e => { console.log(e) } )
} // f end 
getPointLog();
