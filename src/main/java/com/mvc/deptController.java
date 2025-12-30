package com.mvc;

import org.apache.log4j.Logger;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeptController implements Controller{
	Logger log = Logger.getLogger(DeptController.class);
	public DeptController() {
		log.info("DeptController 디폴트생성자 호출");
	}
	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		log.info("execute():ModelAndView");
		return null;
	}

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res, String viewName) throws Exception {
		log.info("execute():String");
		return null;
	}
	@Override
	public Object deptInsert(HttpServletRequest req, HttpServletResponse res){
		// TODO Auto-generated method stub
		log.info("deptInsert");
		int result =-1;
		return "redirect:./deptCRUDResult.jsp?gubun=insert";
	}
	@Override
	public Object deptUpdate(HttpServletRequest req, HttpServletResponse res){
		// TODO Auto-generated method stub
		log.info("deptUpdate");
		int result =-1;
		return "redirect:./deptCRUDResult.jsp?gubun=update";
	}
	@Override
	public Object deptDelete(HttpServletRequest req, HttpServletResponse res){
		// TODO Auto-generated method stub
		log.info("deptDelete");
		int result =-1;
		return "redirect:./deptCRUDResult.jsp?gubun=delete";
	}
	@Override
	public Object deptDetail(HttpServletRequest req, HttpServletResponse res){
		// TODO Auto-generated method stub
		log.info("deptDetail");
		return null;
	}
	@Override
	public Object deptList(HttpServletRequest req, HttpServletResponse res){
		// TODO Auto-generated method stub
		log.info("deptList");
		int result =-1;
		return "redirect:./deptCRUDResult.jsp";
	}
	@Override
	public Object jsonDeptList(HttpServletRequest req, HttpServletResponse res){
		log.info("jsonDeptList");
		int result =-1;
		return "redirect:./deptCRUDResult.jsp";
	}
}
