package day02;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 자바 클래스를 서블릿 클래스로 만들기 위한 방법
// 1. 클래스명 뒤에 extends HttpServlet을 작성해요.
// 2. 클래스명 위에 @WebServlet("HTTP의 주소 경로")를 추가해요.
//    예시)
//    - 절대경로: @WebServlet("http://localhost:8080/lelabo_web_1/day02/example1")
//    - 상대경로: @WebServlet("/day02/example1")

@WebServlet("/day02/example1")  // 클라이언트가 '/day02/example1' 경로로 요청하면 이 서블릿이 실행돼요!
public class Example1 extends HttpServlet {
    // 이클립스에서는 코드가 수정되면 서버에 자동으로 반영돼요!
    // 1. 서블릿 코드를 변경하면 자동으로 리로드되어 ctrl + F11을 다시 누를 필요 없어요.
    // 2. 새로운 서블릿이나 매핑 주소 추가 시 서버를 수동으로 재시작해야 해요.

    // RESTful 방식에서는 HTTP 요청 방식에 따라 동작을 나눌 수 있어요.
    // 1. GET  2. POST  3. PUT  4. DELETE
    
    // 1. POST 방식 요청 처리
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("1] HTTP 프로토콜 통신이 POST 방식으로 요청되었습니다. (코드 수정 완료)");
    }
    
    // 2. GET 방식 요청 처리
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("2] HTTP 프로토콜 통신이 GET 방식으로 요청되었습니다. (코드 수정 완료)");
    }

    // 3. PUT 방식 요청 처리
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("3] HTTP 프로토콜 통신이 PUT 방식으로 요청되었습니다. (코드 수정 완료)");
    }
    
    // 4. DELETE 방식 요청 처리
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("4] HTTP 프로토콜 통신이 DELETE 방식으로 요청되었습니다. (코드 수정 완료)");
    }
    
    // 이렇게 다양한 HTTP 요청 방식을 처리하는 방식을 RESTful 방식이라고 해요! 😊
} // 클래스 끝!
