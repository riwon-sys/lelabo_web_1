
 	
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

        <!--  부트스트랩 CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <!--  내가 만든 css -->
        <link href="/lelabo_web_1/css/index.css" rel="stylesheet">
</head>
<body>

        <nav class="navbar navbar-expand-lg"> <!-- bg-body-tertiary : 배경색   -->
          <div class="container"> <!--  container : 반응형(크기) 구역/박스 -->
            <a class="navbar-brand" href="/lelabo_web_1/index.jsp"> <!-- 로고 -->
                    <img class="header_logo" src="/lelabo_web_1/img/jspweblogo.jpg" />
            </a> 
            <!-- 반응형 토큰(버튼) : 디바이스가 작아지면 메뉴를 보여주는 버튼 활성화 -->
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            
            <!-- 메뉴박스 -->
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
            
                    <!-- 왼쪽 메뉴 목록  -->
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        
                                <!--  게시판 카테고리별 메뉴 항목 -->
                                <li class="nav-item"> <a class="nav-link" href="/lelabo_web_1/board/board.jsp?cno=1">뉴스</a> </li>
                                <li class="nav-item"> <a class="nav-link" href="/lelabo_web_1/board/board.jsp?cno=2">이벤트</a> </li>
                                <li class="nav-item"> <a class="nav-link" href="/lelabo_web_1/board/board.jsp?cno=3">FAQ</a> </li>
                                <li class="nav-item"> <a class="nav-link" href="/lelabo_web_1/board/board.jsp?cno=4">튜토리얼</a> </li>
                                <li class="nav-item"> <a class="nav-link" href="/lelabo_web_1/board/board.jsp?cno=5">사용자리뷰</a> </li>
  
                          
                          
                          <!-- 드롭다운  -->
                          <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                              제품
                            </a>
                            <ul class="dropdown-menu">
                              <li><a class="dropdown-item" href="#">Action</a></li>
                              <li><a class="dropdown-item" href="#">Another action</a></li>
                              <li><hr class="dropdown-divider"></li>
                              <li><a class="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                          </li>
                          
                        </ul>
                        
                        <!-- 오른쪽 메뉴 목록 -->
                        <ul class="navbar-nav me-end mb-2 mb-lg-0 loginmenu"> <!-- me-end : 오른쪽 정렬 -->

                        </ul>
                        
            </div>
          </div>
        </nav>
        
        <!--[6] . 부트스트랩 JS 中 토스트를 활용해보아요 -->
        <div class="alarmbox" style="position:fixed; bottom:10px; left:10px;" >
        
        </div>

        <!-- 부트스트랩 JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" ></script>
        <!-- header JS -->
        <script src="/lelabo_web_1/js/header.js"></script>
        
        
</body>
</html>





