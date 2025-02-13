<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!-- [3-2] 클라이언트 소켓이 서버소켓에게 메시지 전송 , .send() -->
        <jsp:include page="/header.jsp"></jsp:include>
        <div>
                 <!--[6-1] 접속된 클라이언트 소켓들과 메시지를 주고 받기 구현-->
                 <!--[6-1] chatting.jsp 에 class 부여하기 -->
                <div class="msgbox"> </div>
                <textarea class="msginput" ></textarea>
                <button 
                        onclick="onMsgSend()" 
                        type="button">전송</button>
        </div>
        
        <script src="/lelabo_web_1/js/chatting/chatting.js"></script>

</body>
</html>