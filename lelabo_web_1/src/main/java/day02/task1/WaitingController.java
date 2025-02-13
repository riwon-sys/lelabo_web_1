package day02.task1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 컨트롤러 : 뷰와 다오 사이의 가교 역활을 해요! 그리고 서블릿을 이용한 매핑/연결 역할도 같이해요!

@WebServlet("/day2/waiting") // [2] 매핑 주소를 정의해요.
public class WaitingController extends HttpServlet { // [1] 상속을 받아요.
	
	// [3] 메소드 들을 재정의 해봐요.
	
	// 1. 웨이팅 등록을 해봐요! C , doPost
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. URL 상의 쿼리스티링 매개변수를 가져와요. (연락처 , 인원수)
		String phone = req.getParameter("phone");
		int count = Integer.parseInt(req.getParameter("count"));
		
		// 2. 매개변수를 DAO에게 전달하고 결과를 받아요.
		boolean result = WaitingDao.getInstance().write(phone, count);
		System.out.println(result);
	}// fe
	
	// 2. 웨이팅 삭제를 해봐요! D , doDelete
	@Override
		protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. URL 상의 쿼리스티링 매개변수를 가져와요. (삭제할 번호PK)
		int num = Integer.parseInt(req.getParameter("num")); // 문자타입을 정수타입으로 변환해요!
		// 2. 매개변수를 DAO에게 전달하고 결과를 받아요.
		boolean result = WaitingDao.getInstance().delete(num);
		System.out.println( result );
	} // fe

} // ce
