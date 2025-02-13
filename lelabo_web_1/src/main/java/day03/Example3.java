package day03;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example3")
public class Example3 extends HttpServlet {
	@Override
	// HTTP POST BODY : http://localhost:8080/day3/example3
	// // Content-Type : application/json , body : {"data1" : "유재석" ,"data2" : "40"}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// * JSON 자료의 문자열 타입을 DTO 로 변환해보기(JSON은 JS언어에서 사용하는 타입 , JAVA는 DTO 를 사용)
		System.out.println(" [HTTP POST 방식으로 요청이 왔어요]");
		// .readLine() 은 한번 밖에 실행되지 않는다.
		// System.out.println(req.getReader().readLine()); 
		// 문자열  {"data1" : "유재석" ,"data2" : "40"} --> DTO[ JSON ]
		
		ObjectMapper mapper = new ObjectMapper();
		
		// req.getReader(), DataDto.class
		
		DataDto dataDto = mapper.readValue(req.getReader(), DataDto.class);
		System.out.println(dataDto);
		
	} // FE
	
	@Override
	// HTTP PUT BODY : http://localhost:8080/day3/example3
	// // Content-Type : application/json , body : {"data1" : "유재석" ,"data2" : "40"}
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" [HTTP PUT 방식으로 요청이 왔어요]");
		System.out.println(req.getReader().readLine());
		ObjectMapper mapper = new ObjectMapper();
		DataDto dataDto = mapper.readValue(req.getReader(), DataDto.class);
		System.out.println(dataDto);
	} // FE

} // CE {"data1" : "유재석" ,"data2" : 40}
