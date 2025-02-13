<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 썸머노트 라이브러리 사용 하기 위한 CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.9.1/summernote-bs5.min.css" />
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<div class="container">
		<form>
			<select class="cnoselect form-select">
				<!-- form-control 부트스트랩 클래스 -->
				<!-- option value 에는 카테고리명 대신 카테고리번호 인 식별자 넣어야 하는 이유 , 글 등록시 카테고리명이 아닌 카테고리번호 cno 가 필요하다. -->
				<option value="1">뉴스</option>
				<option value="2">이벤트</option>
				<option value="3">FAQ</option>
				<option value="4">튜토리얼</option>
				<option value="5">사용자 리뷰</option>
			</select> <input type="text" class=" titleinput form-control" />
			<textarea id="summernote" name="editordata"
				class=" contentinput form-control"></textarea>
			<button onclick="onWrite()" type="button" class="btn btn-primary">
				글 등록</button>
		</form>
	</div>
	<!--  JUQERY 라이브러리 JS  -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 썸머노트 라이브러리 사용 하기 위한 JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.9.1/summernote-bs5.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.9.1/lang/summernote-ko-KR.min.js"></script>
	<!-- 주의할점 : JS 불러오는 순서 존재 하므로 내가 만든 JS를 가장 아래에서 호출  -->
	<script src="/lelabo_web_1/js/board/write.js" type="text/javascript"></script>

</body>
</html>