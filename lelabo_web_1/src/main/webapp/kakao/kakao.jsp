<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Kakao 지도 시작하기 </title>
</head>
<body>

<jsp:include page="/header.jsp"></jsp:include>

<div id="map" style="width:100%;height:890px;"></div>
	
	
<button style="display :none;"
class="btn btn-primary 사이드바" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
  Button with data-bs-target
</button>

<div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
  <div class="offcanvas-header">
    <h5 class="offcanvas-title" id="offcanvasExampleLabel">약국 상세정보</h5>
    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
  </div>
  <div class="offcanvas-body">
    
    <div class="약국명"></div>
    <div class="전화번호"></div>
    <div class="주소"></div>
      
    
  </div>
</div>
	
	
	
	
	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script> 
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9de317c732064c1126976684204e693a&libraries=clusterer"></script>
	
	<script src="kakao.js"> </script>

</body>
</html>