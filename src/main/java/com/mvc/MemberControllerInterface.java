package com.mvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 회원 관련 컨트롤러 인터페이스
 * 회원 관리에 필요한 메서드만 정의
 */
public interface MemberControllerInterface {
	public Object memberInsert(HttpServletRequest req, HttpServletResponse res);	
	public Object memberUpdate(HttpServletRequest req, HttpServletResponse res);
	public Object memberDelete(HttpServletRequest req, HttpServletResponse res);
	public Object memberDetail(HttpServletRequest req, HttpServletResponse res);
	public Object memberList(HttpServletRequest req, HttpServletResponse res);	
	public Object jsonMemberList(HttpServletRequest req, HttpServletResponse res);	
}