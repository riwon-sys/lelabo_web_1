<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
       <jsp:include page="/header.jsp"></jsp:include>
  
  <!-- 부트스트랩 회원가입 폼 예시 -->
    <div class="container col-xl-10 col-xxl-8 px-4 py-5">
    <div class="row align-items-center g-lg-5 py-5">
      
      <!-- 왼쪽 문구 -->
      <div class="col-lg-7 text-center text-lg-start">
        <h1 class="display-4 fw-bold lh-1 text-body-emphasis mb-3">lelabo_web_1/signup page</h1>
        <p class="col-lg-10 fs-4">high quality service!</p>
      </div>
      
       <!-- 오른쪽 문구 -->
      <div class="col-md-10 mx-auto col-lg-5">
        
        <form id="signupform" class="p-4 p-md-5 border rounded-3 bg-body-tertiary">
          <!-- 아이디 -->
          <div class="form-floating mb-3">
            <input type="text" name="mid" class="form-control" id="floatingInput" placeholder="계정 아이디">
            <label for="floatingInput">계정 아이디</label>
          </div>
          
          <div class="form-floating mb-3">
            <input type="password" name="mpwd" class="form-control" id="floatingPassword" placeholder="계정 비밀번호">
            <label for="floatingPassword">계정 비밀번호</label>
          </div>
          
           <div class="form-floating mb-3">
            <input type="password" class="form-control" id="floatingPassword" placeholder="계정 비밀번호확인">
            <label for="floatingPassword">계정 비밀번호확인</label>
          </div>
          
          <div class="form-floating mb-3">
            <input type="text" name="mname" class="form-control" id="floatingInput" placeholder="닉네임">
            <label for="floatingInput">닉네임</label>
          </div>
          
          <div class="form-floating mb-3">
            <input type="text" name="memail" class="form-control" id="floatingInput" placeholder="이메일">
            <label for="floatingInput">이메일</label>
          </div>
          
          <div class="form-floating mb-3">
            <input type="file" name="uploadfile" class="form-control" id="floatingInput" placeholder="프로필">
            <label for="floatingInput">프로필</label>
          </div>
          
          
          <button class="w-100 btn btn-lg btn-primary" type="button" onclick="onSignUp()">회원가입 하기</button>
          <hr class="my-4">
          <small class="text-body-secondary"> <a class="nav-link" href="#">아이디 찾기</a> </small>
          <small class="text-body-secondary"> <a class="nav-link" href="#">비밀번호 찾기</a> </small>
        </form>
      </div>
    </div>
  </div>

	<script src="/lelabo_web_1/js/member/signup.js"></script>

</body>
</html>