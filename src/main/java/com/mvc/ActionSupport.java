package com.mvc;
import java.io.IOException;

import org.apache.log4j.Logger;

import jakarta.servlet.ServletException;
// -> *. 이런 요청에 대해서는 내가 다 받을게
// .ks 확장자가 ks로 끝나는 모든 요청에 대해서는 내가 가로챈다.
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ActionSupport extends HttpServlet {
	Logger log = Logger.getLogger(ActionSupport.class);
	
	@Override
	protected void service (HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
	// -> http://localhost:8000/dept/crudDept.ks
	// 도메인 뒤 폴더 이름을 업무 명으로 한다.
	// 슬래쉬 뒤에 오는 이름을 업무(입력/수정/삭제/조회)에 대한 메서드 이름으로 정한다.
	// 입력, 수정, 삭제의 return 타입은 int 이다.
		// 입력일 때: 메서드 名 -> deptInert(req, res): int
		// 수정일 때: 메서드 名 -> deptUpdate(req, res): int
		// 삭제일 때: 메서드 名 -> detpDelete(req, res): int
		// 단 건 조회 시 -> 名 deptDetail(req, res): Map or deptVO도 가능(But Map을 연습하자!! -> 빈도 多)
		// n 건 조회 시 -> 名 deptList(req, res): List<Map> 
		
	// -> http://localhost:8000/emp/crudEmp.ks
		// 입력일 때: 메서드 名 -> empInert(req, res): int
		// 수정일 때: 메서드 名 -> empUpdate(req, res): int
		// 삭제일 때: 메서드 名 -> empDelete(req, res): int
		// 단 건 조회 시 -> 名 empDetail(req, res): Map or deptVO도 가능(But Map을 연습하자!! -> 빈도 多)
		// n 건 조회 시 -> 名 empList(req,  res): List<Map> 
		
	// -> http://localhost:8000/member/crudMember.ks
		// 입력일 때: 메서드 名 -> memberInert(req, res): int
		// 수정일 때: 메서드 名 -> memberUpdate(req, res): int
		// 삭제일 때: 메서드 名 -> memberDelete(req, res): int
		// 단 건 조회 시 -> 名 memberDetail(req, res): Map or deptVO도 가능(But Map을 연습하자!! -> 빈도 多)
		// n 건 조회 시 -> 名 memberList(req,  res): List<Map> 
	
	log.info("ActionSupport service");
	String requestURI = req.getRequestURI();
	String contextPath = req.getContextPath(); // -> / or /dev-jsp
	log.info(contextPath); // -> / -> server.xml
	}
}
