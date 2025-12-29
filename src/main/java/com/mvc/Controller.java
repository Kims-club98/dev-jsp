package com.mvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
	// 스프링에서 ModeAndView는 컨트롤러 클래스가 Dispatcher Servlet에게 웅답으로 전달하는 객치이다.
	public ModelAndView excute(HttpServletRequest req, HttpServletResponse res)
			throws Exception;
	public String execute (HttpServletRequest req,
						   HttpServletResponse res, String viewName)
	throws Exception;
}
