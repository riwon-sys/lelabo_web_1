package day03.task4;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet; // 2.
import jakarta.servlet.http.HttpServlet; // 1.
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet
public class WaitingController extends HttpServlet {

	// 1. 대기번호 개별 등록 : post / body / {"content" : "안뇽" , "age" : 30}
    // 1-2. application/json / true
	   // 1-3. url : http://localhost:8080/lelabo_web_1/day3/visit2
	
	// ================================
    // 1. 대기번호 개별 등록 (POST) - Body
    // ================================
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. HTTP로부터 요청(request) 받은 본문(HTTP HEADER BODY)을 DTO로 가져와요!
		ObjectMapper mapper = new ObjectMapper();
		WaitingDto waitingDto = mapper.readValue(req.getReader(), WaitingDto.class);
		// 2. DAO를 처리해요!
		boolean result = WaitingDao.getInstance().write(waitingDto);
		// 3. DAO 결과를 본문(HTTP HEADER BODY)으로 응답(response)을 보내요!
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
	} //fe
		   
		   
    // 2. 대기번호 전체 조회 : get / 없어요
	  // 2-2. application/json / {"num" : 1 , "content" : "안뇽1" , "age" :30} , {"num" : 2 , "content" : "안뇽2" , "age" :35}
	    // 2-3. url : http://localhost:8080/lelabo_web_1/day3/visit2
    // ================================
    // 2. 대기 전체 조회 (GET) - QueryString X
    // ================================
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. x
		// 2. DAO를 처리해요!
		ArrayList<WaitingDto> result = WaitingDao.getInstance().findAll();
		// 3. DAO 결과를 본문(HTTP HEADER BODY)으로 응답(response)을 보내요!
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	
	} // fe
	
	
	 // 3. 대기번호 개별 수정 : put / body /  {"num" : 3 , "content" : "수정안뇽" , "age" : 40}
	   // 3-2. application/json /true
	    // 3-3. url : http://localhost:8080/lelabo_web_1/day3/visit2
    // =================================
    // 3. 대기 개별 수정 (PUT) - Body
    // =================================
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. HTTP로부터 요청(request) 받은 본문(HTTP HEADER BODY)을 DTO로 가져와요!
		ObjectMapper mapper = new ObjectMapper();
		WaitingDto waitingDto = mapper.readValue(req.getReader(), WaitingDto.class);
		// 2. DAO 처리해요!
		boolean result = WaitingDao.getInstance().update(waitingDto);
		// 3. DAO 결과를 본문(HTTP HEADER BODY)으로 응답(response)을 보내요!
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	
	} //fe
	    
	 // 4. 대기번호 개별 삭제 : delete / querystring / {?bnum=1}
	  // 4-2. application/json /true
	   // 4-3. url : http://localhost:8080/lelabo_web_1/day3/visit2?num=1
	// -------------------------------------------------
    // 4. 방문록 개별 삭제 (DELETE)
    // -------------------------------------------------
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. HTTP로 부터 요청(request) 받은 HTTP qureyString 의 매개변수 가져와요 !
		int num = Integer.parseInt(req.getParameter("num"));
		// 2. DAO 처리해요!
		boolean result = WaitingDao.getInstance().delete(num);
		// 3. DAO 결과를 본문(HTTP HEADER BODY)으로 응답(response)을 보내요!
		resp.setContentType("appplication/json");
		resp.getWriter().print(result);
	}
	
}
