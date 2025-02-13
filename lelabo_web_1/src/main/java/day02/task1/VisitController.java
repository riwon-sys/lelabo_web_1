package day02.task1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 컨트롤러 : 뷰 와 다오 사이의 가교 역할 , 서블릿을 이용한 매핑 역할을 할 거에요!

@WebServlet("/day02/visit") //[2] 주소 정의하기
public class VisitController extends HttpServlet { //[1] 상속
	
	//[3] 메소드 재 정 의
	
	// 1. 방문록 등록 ( 쿼리 스트링을 활용한 !) : C , doPost
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//1. url 상의 쿼리 스트링 매개변수를 가져와요 (내용과 작성자만 가져와요; 익명 작은 게시판을 만들 거예요)
		String content = req.getParameter("content");
		// int age = = req.getParameter("age"); 오류 발생 ! 이유는 ! getParameter(___) 함수는 무조건 String 반환 해요!
		int array = Integer.parseInt(req.getParameter("array"));
		// Integer.parseInt("문자열 타입자료") : 문자열타입 --> int 타입자료 변환 함수에요
		//2. 매개변수 DAO에게 전달하고 결과를 받아요
		boolean result = VisitDao.getInstance().write(content, array);
		System.out.println(result);
	} // fe
	
	// 2. 방문록 조회 는 할 예정             : R  doGET
	 
 	// 3. 방문록 수정 는 할 예정             : U  doput
	 
	// 4. 방문록 삭제 ( 쿼리 스트링을 활용한 !) : D , dodelete
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    //1. url 상의 쿼리 스트링 매개변수를 가져와요. (삭제할 식별번호 pk를 가져와요)
		int num = Integer.parseInt(req.getParameter("num")); // 문자타입 --> 정수타입
		//2. 매개변수를 DAO에게 전달하고 결과를 받는다.
		boolean result = VisitDao.getInstance().delete(num);
		System.out.println( result );
	} // fe


 
} // ce
