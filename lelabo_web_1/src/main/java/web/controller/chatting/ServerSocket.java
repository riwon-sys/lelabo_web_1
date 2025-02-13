package web.controller.chatting;

import java.util.List;
import java.util.Vector;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;

import jakarta.websocket.server.ServerEndpoint;

// 서블릿 클래스가 아닌 별도의 웹소켓이라는 클래스로 사용할 예정
// [*] 접속된 세션(접속성공한 클라이언트 소켓정보)저장 , list 컬렉션으로 여러개 Session을 저장하기
// [*] 세션이란? 네트워크 상의 정보를 저장하는 공간 , -@WebServlet HTTP VS -@ServerEndpoint WS

	
// [1] 서버 소켓 만들기 , @ServierEndpoin("/URL")
@ServerEndpoint("/chatsocket")
public class ServerSocket {
	
	// [5] 서버 소켓에 접속된 클라이언트들의 소켓들을 저장할 리스트(vector) 관리하기
	// [*] static 이란? 프로젝트 내 하나의 변수를 만들때 사용되는 키워드 , [전액변수]
	private static List < Session > 접속명단 = new Vector<>();
	
	// [3-1] 서버 소켓에 클라이언트 소켓들이 접속 했을때 @onOpen 이벤트
	@OnOpen
	public void onOpen(Session session) {
		// Session :[import]jakarta.websocket.Session
		System.out.println("클라이언트가 서버에 접속 성공 했수다!!!");
		System.out.println(session);
		// [5] 서버 소켓에 접속된 클라이언트들의 소켓들을 저장할 리스트(vector) 관리하기
		// [*] onOpen (클라이언트가 정상적으로 서버와 접속 성공했을때)
		// list 컬렉션에 접속 성공한 session 정보를 저장한다.
		접속명단.add(session);
	} // fe
	
	// [3-3] 클라이언트 소켓이 서버소켓에게 메시지를 전송을 받을때 @OnMessage
	@OnMessage
	public void onMessage( Session session , String message ) {
		System.out.println("클라이언트 소켓으로부터 메시지 왔수다!!!");
		System.out.println(message);
	
	// [3-4] 서버 소켓이 클라이언트 소켓에게 메시지 전송 , .getBasicRemote().sendText()
		
		// [*] 서버가 클라이언트에게 메시지 전송
		// try { session.getBasicRemote().sendText("클라이언트 소켓 안녕하수꽈!!!");
		//} catch (Exception e) {System.out.println(e);}
		// [6-1] 접속된 클라이언트 소켓들과 메시지를 주고 받기 구현
		// [6-1] (1) 받은 메세지를 접속된 모든 세션(클라이언트소켓)들에게 메시지 보내기.
		// [6-1] (2) 받은메시지 = 매개변수의 message
		// [6-1] (3) 접속명단 : private static List<Session> 접속명단 = new Vector<>();
		// [6-1] (4) 반복문 이용한 접속 명단 순회
		for (int index =0; index <= 접속명단.size()-1; index++) {
			// [6-1] (5) 접속된 명단의 index번째 세션(접속정보) 가져오기
			Session clientSoket = 접속명단.get(index);
			// [6-1] (6) index 번째 세션에 (서버가 받은) 메시지를 보내기 , 예외처리
			try { clientSoket.getBasicRemote().sendText(message);}
			 catch (Exception e) { System.out.println(e);}
		} // for e
	} // fe
	
	@OnClose
	public void onClose( Session session ) {
		
		// [5] 서버 소켓에 접속된 클라이언트들의 소켓들을 저장할 리스트(vector) 관리하기
		// 클라이언트 소켓과 연결이 닫혔을때 명단에서 제외
		// 접속이 닫힌 클라이언트 소켓을 리스트에서 제거
		접속명단.remove(session); // 
	}
	
} //ce
     