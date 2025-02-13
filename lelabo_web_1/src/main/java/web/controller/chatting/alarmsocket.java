package web.controller.chatting;

import java.util.List;
import java.util.Vector;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
/*
 * 과제 : 누군가가 로그인 성공했을때 현재 홈페이지(모든페이지 포함)의 존재하는 모든 유저들에게 메시지 띄우기(알람 기능구현하기)
 * 0. 강의내용인 webjsp 내에서 진행해주세요.
 * 1. websocket 을 활용해주세요.
 * 2. 메시지 화면은 부트스트랩의 '토스트' 컴포넌트를 활용해주세요.
 * 3. 자 이제 시작!!!
 */

/*
 * js의 웹소켓을 어떠한 페이지에 만들면 좋을지 구상해보아요. => 모든페이지에 사용할 예정이니 header.jsp 와 header.js 에 만들면 좋겠어요.
 * 서버 소켓은 자바에서 1개의 클래스를 생성해야해요.
 * 서버소켓에 접속 성공한 클라이언트 소켓을 저장해요.
 */

// [1] . 서버소켓을 생성해보아요.
@ServerEndpoint("/alarmsocket")
public class alarmsocket {
	// [1] . > header.js 에서 클라이언트소켓을 서버소켓 주소로부터 연결해보아요.(이동)
	
// [2] . 서버소켓에 접속된 클라이언트 소켓들을 관리하기 위한 코드를 추가해요.	
	// 접속한 클라이언트 소켓 정보(session)들을 리스트에 저장하기 위해 리스트 선언을 해요.
	private static List<Session>connList = new Vector<>();
	
	// 클라이언트가 서버에 성공적으로 연동했을경우 자동으로 실행되요.(함수)
	@OnOpen
	public void onOpen(Session session) {
		connList.add(session); // 연결(연동,연접)된 클라이언트 소켓 정보(session)들을 리스트에 저장해요.
	}
	// 클라이언트와 서버가 연결이 닫혔을경우 자동으로 실행되요.(함수)
	@OnClose
	public void onClose(Session session) {
		connList.remove(session); // 연결이 닫혔을때 리스트에서 닫힌 클라이언트 소켓 정보(session)들을 리스트에서 제거해요.
		
	}
    
	// [4] . 로그인 성공했을때 , 클라이언트가 서버에 로그인한 상태를 메시지 보내요.
	@OnMessage // 클라이언트가 보낸 메시지를 서버가 정상적으로 받았을때 자동으로 실행되요.
	public void onMessage( Session session ,  String message ) {
		// - 현재 접속된 모든 클라이언트 소켓들에게 받은 메시지를 보내요 - 
		// for 문을 사용해 보아요.
		for( int i = 0; i<=connList.size()-1; i++) {
			Session client = connList.get(i);
			try {
				client.getBasicRemote().sendText(message);
			} catch (Exception e) {System.out.println(e);
				
			}
		}
	}
} // CE

