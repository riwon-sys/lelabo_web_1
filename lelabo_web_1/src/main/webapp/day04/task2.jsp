<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
       
       <h3> DAY03 VISIT2 화면 구현 </h3>
       <div>
             <div> 방문록 작성 </div>
             내용 : <input class="contentInput"/> <br/>
             나이 : <input class="ageInput"/> <br/>
             <button onclick="visitWrite()" type="button" >  등록  </button>
       </div>
       <div>
             <div> 방문록 목록 </div>
             <table border="1">
                  <thead>
                        <tr>
                          <th> num     </th> 
                          <th> content </th> 
                          <th> age     </th> 
                          <th> etc     </th>
                        </tr>
                  </thead>
                  <tbody>
                  
                  <!-- JS가 InnerHTML HTML 넣을 예정  -->
                  
                  </tbody>
             </table>
        </div> 
       
       <script src="task2.js"></script> 
</body>
</html>