package day03.task3;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet; // 2
import jakarta.servlet.http.HttpServlet; // 1
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/visit2")
public class VisitController extends HttpServlet{
	
	// 1. 방문록 등록 : post / body / {"content" : "안뇽" , "age" : 30}
	 // 1-2. application/json / true
	   // 1-3. url : http://localhost:8080/lelabo_web_1/day3/visit2
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//(1) http로부터 요청 받은 http header body(본문)을  dto로 파싱(변환)해서 가져와요.
		ObjectMapper mapper = new ObjectMapper();
		VisitDto visitDto = mapper.readValue(req.getReader(), VisitDto.class);
		
		//(2) dao를 처리해요
		boolean result = VisitDao.getInstance().write(visitDto);
		
		//(3)dao 결과를 http header body(본문)으로 응답(response)을 보내요
		resp.setContentType("application/json"); // 응답할 자료의 타입을 표시해요
		resp.getWriter().print(result); // 응답할 자료의 타입을 보내요
		
	} //fe
	
	
	// 2. 방문록 전체 조회 : get / 없어요
	 // 2-2. application/json / {"num" : 1 , "content" : "안뇽1" , "age" :30} , {"num" : 2 , "content" : "안뇽2" , "age" :35}
	  // 2-3. url : http://localhost:8080/lelabo_web_1/day3/visit2
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//(1) X
		//(2)DAO처리
		ArrayList<VisitDto> result = VisitDao.getInstance().findAll();
		//(3)dao 결과를 http header body(본문)으로 응답(response)을 보내요
		    // 자바객체(DTO) --> JSON 형식의 문자열 타입변환 
		    ObjectMapper mapper = new ObjectMapper();
	        String jsonResult = mapper.writeValueAsString(result);
	    
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
	} //fe 
	
	// 3. 방문록 수정 : put / body /  {"num" : 3 , "content" : "수정안뇽" , "age" : 40}
	 // 3-2. application/json / true
	  // 3-3. url : http://localhost:8080/lelabo_web_1/day3/visit2
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. HTTP로 부터 요청(request) 받은 HTTP HEADER BODY(본문) 를 DTO 파싱(변환) 가져오기.
		ObjectMapper mapper = new ObjectMapper();
		VisitDto visitDto = mapper.readValue(req.getReader() , VisitDto.class);
		//(2). DAO 처리
		boolean result = VisitDao.getInstance().update(visitDto);
		//(3). dao 결과를 http header body(본문)으로 응답(response)을 보내요
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}// fe
	
	
	// 4. 방문록 삭제 : delete / querystring / {?bnum=1}
	 // 4-2. application/json /true
	  // 4-3. url : http://localhost:8080/lelabo_web_1/day3/visit2?num=1
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//(1). http로부터 요청받은 http querystring 의 매개변수 가져오기
		int num = Integer.parseInt(req.getParameter("num"));
		
		//(2). DAO 처리
		boolean result = VisitDao.getInstance().delete(num);
		
		//(3). dao 결과를 http header body(본문)으로 응답(response)을 보내요
		resp.setContentType("application/json");
		resp.getWriter().print(result);

	}
	
}

/*
 * // 1. 방문록 등록 		: POST		, url : http://localhost:8080/tj2024b_web1/day03/visit2	
	// 매개변수 : BODY					, 매개변수 예] { "content":"안녕" , "age" : 30 }
	// 반환타입 : application/json 	, 매개변수 예] true/false
 
 
   // 2. 방문록 전체조회 	: GET		, url : http://localhost:8080/tj2024b_web1/day03/visit2	
	// 매개변수 : X
	// 반환타입 : application/json		, 매개변수 예] [ { "num" : 1 , "content":"안녕1" , "age" : 30 } , { "num" : 2 , "content":"안녕2" , "age" : 20 }  ]
	
   // 3. 방문록 수정 		: PUT 		, url : http://localhost:8080/tj2024b_web1/day03/visit2	
	// 매개변수 : BODY 				, 매개변수 예] { "num" : 3 , "content":"수정안녕" , "age" : 40 }
	// 반환타입 : application/json		, 매개변수 예] true
	
	
   // 4. 방문록 삭제 		: DELETE 	, url : http://localhost:8080/tj2024b_web1/day03/visit2?num=1
	// 매개변수 : queryString 			, 매개변수 예] ?num=1
	// 반환타입 : application/json		, 매개변수 예] true
  
*/