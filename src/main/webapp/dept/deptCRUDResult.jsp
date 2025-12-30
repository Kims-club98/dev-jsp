<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// insert, update, delete
	String gubun = request.getParameter("gubun");
	if("insert".equals(gubun)){
		out.print("부서 등록 성공");
	}
	String gubun = request.getParameter("gubun");
	if("update".equals(gubun)){
		out.print("부서 수정 성공");
	}	
	String gubun = request.getParameter("gubun");
	if("delete".equals(gubun)){
		out.print("부서 삭제 성공");
	}
%>
	<!--  String gubun = request.getParameter("gubun");
	if("delete".equals(gubun)){
		out.print("부서 삭제 성공");
	}else{
		out.print("부서 삭제 실패")
	}
	-->