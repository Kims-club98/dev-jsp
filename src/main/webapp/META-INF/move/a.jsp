<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//a.jsp페이지에서 저장해둔 상태값 강감찬이 b.jsp에서도 유지되나요?
	request.setAttribute("name","강감찬");
	//스크립틀릿 - 자바코드
	//여기는 서버에서 실행되고 실행결과를 응답으로 내보낸다.
	response.sendRedirect("b.jsp");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a.jsp</title>
</head>
<body>
a.jsp 본문
</body>
</html>
<!-- 
	http://localhost:8000/move/b.jsp Enter 시 a.jsp를 볼 수 없음
	-> 왜냐 하면 이미 http://localhost:8000/move/b.jsp로 바뀜
		(기존 요청은 끊어지고 새로운 요청이 발생함)
		==> 결론: 상태값이 유지되지 않음
		쿠키/세션-> 데이터 영속성은 오라클
		a.jsp가진 제어권이 b.jsp로 넘어감
		응답처리에 대한 책임이 b.jsp로 넘어감.
 -->