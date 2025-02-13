package day02;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 🌟 서블릿을 만들기 위한 3단계 과정 🌟
// 1단계: HttpServlet 클래스를 상속받아요! (extends HttpServlet)
// 2단계: 클래스 선언 위에 @WebServlet("요청 경로")로 매핑을 설정해요!
//         예시) @WebServlet("/day02/example2") → '/day02/example2' 경로로 요청이 오면 이 서블릿이 실행돼요.
// 3단계: 필요에 따라 doGet, doPost, doPut, doDelete 메서드를 재정의하여 요청을 처리해요! 😊

@WebServlet("/day02/example2")  // 클라이언트가 '/day02/example2'로 요청하면 이 서블릿이 실행돼요!
public class Example2 extends HttpServlet {
    // http://localhost:8080/lelabo_web_1/day02/example2
    
    // 예시로 GET 요청을 처리하고 싶다면 아래와 같이 작성해요:
  
	// 1. doget
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" 1] 사용자가 서버로부터 get 메소드로 요청 했습니다.");
	

		// 쿼리스트링의 매개변수를 가져와요
		   // .getParameter("URL 경로상의 매개변수명") // 매개변수명의 값(String타입) 변환 함수 , 없으면 null !
		// http://localhost:8080/lelabo_web_1/servlet/day02.Example2?name=유재석
		System.out.print("1]URL ? 뒤에 'name' 이라는 매개변수명을 가진 변수의 값을 가져와요");
		System.out.println( req.getParameter("name"));
		
		System.out.print("1]URL ? 뒤에 'age' 이라는 매개변수명을 가진 변수의 값을 가져와요");
		System.out.println( req.getParameter("age"));
		
	}
	
	// 2. dopost 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" 2] 사용자가 서버로부터 post 메소드로 요청 했습니다.");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.printf("name : %s , age : %s " , name ,age );
	}
	
	// 3. doPut
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" 3] 사용자가 서버로부터 put 메소드로 요청 했습니다.");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.printf("name : %s , age : %s" , name ,age );
	}
	
	//4. doDelete 
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" 4] 사용자가 서버로부터 delete 메소드로 요청 했습니다.");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.printf("name : %s , age : %s" , name ,age );
	}

} // 클래스 끝!