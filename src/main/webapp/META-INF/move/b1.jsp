<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// a.jsp에서 주입된 객체와 b.jsp에서 주입된 request 객체는 서로 다름.\
	// name 속성에 해당하는 값을 참조할 수 없음!
	String a = new String("a");
	a = new String("a");
	String name = (String)request.getAttribute("name");
	out.print("a1.jsp에서 저장한 상태값"+name); //null
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[[b1.jsp]]</title>
</head>
<body>
[[b1.jsp]] 본문입니다...
</body>
</html>