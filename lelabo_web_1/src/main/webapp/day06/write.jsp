<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      <jsp:include page="/day06/header.jsp"></jsp:include>
      <div>
             <h3> 게시물 작성 : 작성 후 등록버튼을 클릭하세요.</h3>
             작성자 : <input class="writeInput"/>
             비밀번호 : <input class ="pwdInput"/></br>
             제목 : <input class="contentInput" rows="10" cols="60"> </textarea><br/>
      </div>

</body>
</html>