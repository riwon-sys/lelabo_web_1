console.log('chatting.js open');
// [2] 클라이언트(JS) 소켓(객체)만들기 , 서버 소켓에 접속시도
let clientSocKet = new WebSocket('ws://localhost:8080/lelabo_web_1/chatsocket');

// [3-2] 클라이언트 소켓이 서버소켓에게 메시지 전송 , .send()
const onMsgSend=()=>{
	// [6-1] 접속된 클라이언트 소켓들과 메시지를 주고 받기 구현
		// [6-1] chatting.js코드에 onMsgSend 코드 수정 
	// clientSocKet.send('서버 소켓님 안녕하수꽈!');
	// (1) 입력받은 값 가져오기
	const msginput = document.querySelector('.msginput');
	const msg = msginput.value;
	// (2) 서버소켓에게 값 보내기
	clientSocKet.send(msg);
    

} // fe

// [4] 서버 소켓이 클라이언트 소켓으로부터 메시지를 보냈을때 , onMessage 속성 
clientSocKet.onmessage =(msgEvent) => {
	console.log(clientSocKet);
	console.log('서버소켓으로부터 메시지 왔수다!!!');
	console.log(msgEvent);
	console.log(msgEvent.data);
	// [6-1] 접속된 클라이언트 소켓들과 메시지를 주고 받기 구현
	// [6-1] (1)받은 메시지를 html에 출력하기
	// [6-1] (1) 1. 어디에
	const msgbox = document.querySelector('.msgbox');
	// [6-1] (1) 2. 무엇을
	let html = `<div> ${msgEvent.data} </div>`;
	// [6-1] (1) 3. 출력 , =대입(기존값사라짐) ,+=(기존값연결); 앞전 내용과 연결하기 위해서 사용
	msgbox.innerHTML+=html;
	

}