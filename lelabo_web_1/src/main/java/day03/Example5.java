package day03;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet; // 1
import jakarta.servlet.http.HttpServlet; // 2
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example5")
public class Example5 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean result = true; // 1. 응답 자료 준비해요.
		
		resp.setContentType("application/json");                        // 2. http를 이용한 응답 헤더 정보 추가 setContentType( )
		
		
		
		resp.getWriter().print(result); // 3. http를 이용한 요청에 따른 응답 자료를 보내요.
	} //fe
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result = "Java";
		resp.setContentType("application/json"); // ("text/plain") ,("text/html")
		
		resp.getWriter().print(result);
	} //fe
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int result = 30;
        resp.setContentType("application/json");
        resp.getWriter().print(result);
	} // fe
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DataDto result = new DataDto("유재석" , 40);
		// dto를 json으로 변환 해보아요!
		  //(1). ObjectMapper
		  ObjectMapper mapper = new ObjectMapper();
		  String JsonResult = mapper.writeValueAsString(result);
		
		resp.setContentType("application/json"); // 오류발생 : dto 를 json으로 타입 변환 불가해요
		
		resp.getWriter().print(JsonResult);
	} // fe
	

} //ce
