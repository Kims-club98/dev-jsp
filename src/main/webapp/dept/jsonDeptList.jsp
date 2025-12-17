<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
// ▼ java 작성 영역 - 변수, 제어문, 메서드 안됨, 전역변수 안됨.

	List<Map<String, Object>> list = new ArrayList<>();
	Map<String, Object> map = new HashMap<>();
	map.put("deptno",10);
	map.put("dname","총무부");
	map.put("loc","서울");
	list.add(map);
	map=new HashMap<>();
	map.put("deptno",20);
	map.put("dname","개발부");
	map.put("loc","부산");
	map=new HashMap<>();
	map.put("deptno",30);
	map.put("dname","운영부");
	map.put("loc","제주");
	list.add(map);
	com.google.gson.Gson g = new com.google.gson.Gson();
	String temp = g.toJson(list);
	out.print(temp);

%>