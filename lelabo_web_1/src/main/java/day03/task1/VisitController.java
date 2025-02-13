package day03.task1;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 컨트롤러 : 뷰 와 다오 사이의 가교 역할 , 서블릿을 이용한 매핑 역할을 할 거에요!

@WebServlet("/day03/visit") //[2] 주소 정의하기
public class VisitController extends HttpServlet { //[1] 상속
	
	// 1. 방문록 작성 : POST / content/age
	
	@Override
	// HTTP POST BODY http://localhost:8080/lelabo_web_1/day3/visit
	// // Content-Type : application/json , body : {"content: "안녕! 방문록 남기고 갑니다." , "age": "40"}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 
		ObjectMapper mapper = new ObjectMapper();
		// 2.
		VisitDto visitDto = mapper.readValue(req.getReader(), VisitDto.class);
		System.out.println(visitDto);
		// 3.
		boolean result = VisitDao.getInstance().write(visitDto);
		System.out.println(result);
		
	} // fe
	
	
	// 2. 방문록 삭제 : DELETE / QUERYSTRING
	@Override
		protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		System.out.println("num : " + num);
		
		boolean result = VisitDao.getInstance().delete( num );
		System.out.println(result);
		} // fe

}