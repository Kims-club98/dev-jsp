<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hello JSP!
	<%
	// 스크립틀릿 - 자바 변수선언이나 제어문을 쓸 수 있는 영역이다!(JS 코드와 JAVA 코드를 섞어 쓸 수 있다)
	// 스크립틀릿에서 선언한 변수는 모두 지변(지역변수) 이다.
	// service메서드 안에 선언되므로 지역변수이다!
	//1) jsp-api.jar, 2) servlet-api.jar
	// 확장자가 html이 아닌데 어떻게 웹 브라우저에서 출력이 되나요?
	// JAVA(서블릿)클래스 내부에
	// 서블릿에서 doGet(req,res), doPost(req,res), doPutv, doDelete(req,res)
	// 메서드 파라미터 자리는 선언하는 자리 => 타입과 변수 이름만 있음.
	// but 메서드 호출이나 속성 호출 시 NullPointerException이 발생하지 않는가?
	// 이러한 요청객체와 응답객체는 개발자가 직접 인스턴스화 하지 않음 -> 외부에서 주입해준다!(언제 주입해주는가?)
	// index.jsp -> index_jsp.java -> index.jsp.class
	String msg = "안녕";
	%>
	<!-- html 주석 
	 하단 Script 익스프레션
	 -->
	<%=msg %>

</body>
</html>