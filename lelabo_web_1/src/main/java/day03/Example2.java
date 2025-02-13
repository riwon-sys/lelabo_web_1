package day03;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet; // 2
import jakarta.servlet.http.HttpServlet; // 1
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example2")
public class Example2 extends HttpServlet{
	
	// queryString 방식이 아닌 HTTP body(본문) 활용해요
	// !!! :  HTTP body(본문)는 Post Put METHOD 에서 사용을 지원해요.(GET ,DELETE 제외)
	@Override 
	// HTTP POST BODY : http://localhost:8080/day3/example2
	// Content-Type : application/json , body : 본문내용입니다1
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" [HTTP POST 방식으로 요청이 왔어요]");
		System.out.println(req.getReader()); // 요청을 할때마다 객체가 변경되요
		System.out.println(req.getReader().readLine()); // HTTP 본문의 내용들을 한줄 읽어서 반환하는 함수에요
		
	} //fe
	
	@Override
	// HTTP PUT BODY : http://localhost:8080/day3/example2
	// Content-Type : application/json , body : 본문내용입니다2
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" [HTTP PUT 방식으로 요청이 왔어요]");
		System.out.println(req.getReader()); // 요청을 할때마다 객체가 변경되요
		System.out.println(req.getReader().readLine()); // HTTP 본문의 내용들을 한줄 읽어서 반환하는 함수에요
	} //fe

} //CE
