package com.mvc;
import java.io.IOException;

import org.apache.log4j.Logger;

import jakarta.servlet.RequestDispatcher;
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
	log.info(requestURI); // -> dept/deptInsert.ks
	String contextPath = req.getContextPath(); // -> / or /dev-jsp
	log.info(contextPath); // -> / -> server.xml
	// URL 요청을 활용하여 업무이름과 메서드 이름을 알아낸다.
	// dept앞에 "/" 제거함 -> "/"기준으로 문자열을 잘라서 배열에 담기
	String command = requestURI.substring(contextPath.length()+1);
	int end = command.lastIndexOf(".");
	// -> dept/deptInsert.ks
	log.info("end : "+end); //15
	command = command.substring(0,end);
	log.info(command); // -> dept/deptInsert
	// 요청받은 내용을 해당 업무에 대응되는 XXXController 전달하고 응답처리를 위한 후처리를 해야 한다.
	Object obj = null;// ModelAndView & String
	// viewName -> return "redirect:./deptInsertOk.jsp"
	// viewName -> return "forward:./deptInsertOk.jsp"
	// viewName -> return new ModelAndView()
	// >> insert here - HandlerMapping 연결하기
	obj = HandlerMapping.getController(command);
	String [] pageMove = null;
	if(obj != null) {
		ModelAndView mav = null;
		//Object에는 2가지 Type이 있음. String(Insert, Update, Delete), ModelAndView(slect)
		if(obj instanceof String) {
			log.info("return 타입이 String 일때 ▼");
			if(((String)obj).contains("/")) {
				log.info("내 안에 콜론(:)이 있다.");
				PageMove = obj.toString().split("/");
				}
			else {
				log.info("내 안에 슬래쉬(/)도 업고 콜론(:)도 없음");
			}
			} // Controller 요청 메서드의 return 타입이 String인 경우 end	
			else if(obj instanceof ModelAndView) {
				log.info("return 타입이 ModelAndView 일때 ▼");
				
				mav = (ModelAndView)obj;
				pageMove = new String[2];
				pageMove [0] = "modelAndView";
				pageMove [1] = mav.getViewName();
			}//컨트롤러 요청 메서드의 리턴 타입이 ModelAndView인 경우 end
		}// end of obj가 Null이 아닐 때 ==> NullPointException을 예방하기 위한 Code!
	//////////////////////////////////////////////////////////////////
	/// /////////////////////[[ ViewResolver ]] //////////////////////
	if(pageMove != null && pageMove.length == 2) {
		log.info("pageMove 배열의 원소 갯수가 2개일 때");
		String path = pageMove[1]; // 각 Controller 클래싕 메서드가 정한 페이지의 이름
		if("redirect".equals(pageMove[0])) {
			res.sendRedirect(pageMove[1])){
				RequestDispatcher view = req.getRequestDispatcher("/"+path+".jsp");
									req.getRequestDispatcher("/WEB-INF/views/"+path+".jsp");
					view.forward(req, res);				
			}
			// Spring boot 에서 요청에 대한 응답 URL를 완성해주는 ViewResolver클래스가 제공됨.
		}
	}
	
	
	}
}
