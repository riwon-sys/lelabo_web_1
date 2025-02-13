package day03.task2;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 컨트롤러 : 뷰와 다오 사이의 가교 역활을 해요! 그리고 서블릿을 이용한 매핑/연결 역할도 같이해요!

@WebServlet("/day3/waiting") // [2] 매핑 주소를 정의해요.
public class WaitingController extends HttpServlet { // [1] 상속을 받아요.
	
	// [3] 메소드 들을 재정의 해봐요.
	
	// 1. 웨이팅 등록을 해봐요! C , doPost
	@Override
	// HTTP POST BODY : http://localhost:8080/lelabo_web_1/day3/waiting
	// // Content-Type : application/json , body : {"content": "안뇽! 방문록 남기고 갑니다.", "age": 40}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1.
		ObjectMapper mapper = new ObjectMapper();
		
		// 2. 
		WaitingDto waitingDto = mapper.readValue(req.getReader(), WaitingDto.class);
		System.out.println(waitingDto);
		
		// 3.
		boolean result = WaitingDao.getInstance().write( waitingDto );
		System.out.println(result);
		
		
		
	}// fe
	
	// 2. 웨이팅 삭제를 해봐요! D , doDelete
	@Override
	// HTTP DELETE QUERYSTRING : http://localhost:8080/lelabo_web_1/day3/waiting
	
		protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 
		int num = Integer.parseInt(req.getParameter("num")); // 문자타입을 정수타입으로 변환해요!
		System.out.println("num : " + num);
		// 2. 
		boolean result = WaitingDao.getInstance().delete(num);
		System.out.println( result );
		
		
	} // fe

} // ce
