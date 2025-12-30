package com.mvc;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HandlerMapping {
	static Logger log = Logger.getLogger(HandlerMapping.class);
	/***********************************************************
	 * 
	 * @param command - dept/deptInsert , emp/empDelete
	 *               , member/memberUpdate,,,
	 * @param res 
	 * @param req 
	 * @return String && ModeAndView
	 **********************************************************/
	public static Controller getController(String command, HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException
	{
		Object controller = null;
		Object obj = null;
		String commands[] = command.split("/");
		//commands[0] => emp, dept, member
		//commands[1] => empInsert, deptUpdate, memberDelete
		if(commands.length == 2) {
			String work = commands[0];
			String methodName = commands[1];
			// 예외처리
			try {
				
			}catch(Exception e) {
				log.error("메서드 호출 중 오류 발생! > "+e.getMessage());
				throw new ServletException("컨트롤러 메서드 호출 실패",e);
			}// end of 예외처리

			//부서관리인가?
			//개발자가 직접 코드로 인스턴스화를 하였다. 
			//- 객체관리 책임이 개발자에게 있다.: 의존성 주입이 아니다
			if("dept".equals(work)) {
				controller = new DeptController();
				if("deptInsert".equals(methodName)) {
					log.info("deptInsert-부서등록");
					//사용자가 입력한 값을 전달 하기 위해서 req, res가 필요함
					obj = invokMethod(controller,methodName,req,res);
				}
				else if("deptUpdate".equals(methodName)) {
					controller = new DeptController();
					obj = invokMethod(controller,methodName,req,res);
					log.info("deptUpdate-부서수정");
				}
				else if("deptDelete".equals(methodName)) {
					controller = new DeptController();
					obj = invokMethod(controller,methodName,req,res);
					log.info("deptDelete-부서삭제");
				}
				else if("deptDetail".equals(methodName)) {
					controller = new DeptController();
					obj = invokMethod(controller,methodName,req,res);
					log.info("deptDetail-부서정보 한 건 조회");
				}
				else if("deptList".equals(methodName)) {
					controller = new DeptController();
					obj = invokMethod(controller,methodName,req,res);
					log.info("deptList-부서목록 n건 조회");
				}				
			}
			//사원관리인가?
			else if("emp".equals(work)) {
				controller = new EmpController();
			}
			//회원관리인가?
			else if("member".equals(work)) {
				controller = new MemberController();
			}
		}
		return controller;
	}// end of getController
	/********************************************************
	 * Controller객체 안에 있는 methodName을 문자열로 찾아서 실행하는 메서드 구현(Reflection API를 구현)
	 * Reflection을 사용하여 동적으로 메서드를 호출한다.
	 * @param controller 실행 대상( ex. new DeptController())
	 * @param methodName 실행할 메서드 이름(예: deptInsert, deptList,,)
	 * @param request - 사용자가 보낸 요청 정보(parameter/section)
	 * @param response - 서버가 응답할 때 사용하는 객체(출력/Redirect 등)
	 * @return 각 메서드 실행 결과
	 *******************************************************/

	private static Object invokMethod(Object controller, String methodName,
			HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		log.info(methodName + "메서드호출");
/* ★ 메서드 찾기 단계
 * controller.getClass() : 컨트롤러 설계도(Class) 를 얻기
 * getMethod(...): public 메서드 중에서 이름이 methodName이고
 * 파라미터가 HttpServletRequest, HttpServletResponse인 메서드를 찾아 Method객체로 가져옴
 * 
 * */
		Method method = controller.getClass().getMethod(methodName, HttpServletRequest.class,
				HttpServletResponse.class);
		return method.invoke(controller, req, res);
	}// end of invokMethod
	
}
