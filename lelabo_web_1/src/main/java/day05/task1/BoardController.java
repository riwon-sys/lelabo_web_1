package day05.task1;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day05/board")
public class BoardController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("TEST1");
		// 1. http body 로 요청된 데이터들을 josn-->dto로 변환
		ObjectMapper mapper = new ObjectMapper();
		BoardDto boardDto = mapper.readValue(req.getReader(), BoardDto.class);
		// 2. dao
		boolean result = BoardDao.getInstance().boardWrite(boardDto);
		// 3. dao 응답 
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
	} // CE1

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("TEST2");
		// 1. x
		// 2. dao
		ArrayList<BoardDto>result = BoardDao.getInstance().findAll();
		// 3. 응답
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("TEST3");
		// 1. http 요청의 body 본문을 dto로 변환하기
		// -json 타입을 dto 타입으로 변환해주는 'ObjectMapper' 인스턴스 생성
		// -readValue() 를 이용한 body(본문) 정보를 DTO 로 변환 함수
		ObjectMapper mapper = new ObjectMapper();
		BoardDto boardDto
		= mapper.readValue(req.getReader(), BoardDto.class); // mapper.readValue(__,__) 입력후 BoardDto 입력대입
		
		// 2. dao
		// - dto 로 변환된 body를 dao에게 전달하고 sql 처리 결과받기
		boolean result = BoardDao.getInstance().update(boardDto);
		// 3. 결과를 http 응답 하기
		// - http 응답 할 content-type 설정
		// http 응답 자료를 보내기
	resp.setContentType("application/json");
	resp.getWriter().print(result);
	}//fe
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("TEST4");
		
		// 1. http 요청의 쿼리스티링 매개변수 가져오기
		int bno = Integer.parseInt( req.getParameter("bno") ); //- 쿼리스트링의 bno 라는 매개변수 값 반환 req.getParameter("bno");  후 getParameter("bno") 입력 
		// 2. dao
		boolean result = BoardDao.getInstance().delete(bno);
		// 3. 결과를 http 응답 하기
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
	} //fe
	
} // ce
