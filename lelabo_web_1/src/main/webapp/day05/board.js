// [2]
const boardFindAll = () => {
	
	//1. 어디에
	let tbody = document.querySelector('tbody')
	
	//2. 무엇을
	let html ='';
	
	// [] 옵션
	const option = { method :'GET' }
	// [] fetch
	fetch( '/lelabo_web_1/day05/board' , option )
	.then(response => response.json() )
	.then( data => {
		data.forEach( board => {
			html += `<tr>
			          <td>${ board.bno }</td>
					   <td>
					      <a href ="view.jsp?bno=${ board.bno }">
						      ${board.btitle }
					      </a>
					   </td>
					   <td>${board.bdate}</td> 
					   <td>${board.bwriter}</td> 
					   <td>${board.bview}</td> 
					 </tr>`
		});
		//3.출력!
		tbody.innerHTML = html;
	})
	.catch(error => {console.log(error); })
};
boardFindAll(); // 최초 1회는 반드시 실행!