package day03;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example4")
public class Example4 extends HttpServlet {
	
	@Override
	//http get 
	//url : http://localhost:8080/lelabo_web_1/day03/example4
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[http * GET 방식으로 요청이 왔어요.]");
		boolean result = true; // 1.
		resp.getWriter().print(result); // 2. .getWriter().print(보낼자료);
	    System.out.println("[http 로 자료를 응답 했어요.]");
	} //fe
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[http * POST 방식으로 요청이 왔어요.]");
		String result = "Java";
		resp.getWriter().print(result);
		System.out.println("[http 로 자료를 응답 했어요.]");
	} //fe
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[http * PUT 방식으로 요청이 왔어요.]");
		int result = 30;
		resp.getWriter().print(result);
		System.out.println("[http 로 자료를 응답 했어요.]");
	} //FE
	
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("[http * PUT 방식으로 요청이 왔어요.]");
    	DataDto result = new DataDto("유재석" , 40);
    	resp.getWriter().print(result);
    	System.out.println("[http 로 자료를 응답 했어요.]");
	} //FE

} //ce
