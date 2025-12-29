package com.mvc;

import org.apache.log4j.Logger;

public class HandlerMapping {
	Logger log = Logger.getLogger(HandlerMapping.class);
	/*******************************************************
	 * 
	 * @param command - dept/deptInsert, emp/empDelete
	 * 					,member/memberUpdate...
	 * @return
	 ******************************************************/
	public static Controller getController(String command) {
		Controller controller = null;
		String commands[] = command.split("/");
		// commands [0] = emp, dept, member 가 O
		// commands [1] = empInsert, deptInsert, memberInsert 가 O
		if(commands.length == 2) {
			String work = commands [0];
			String methodName = commands[1];
			// 부서관리와 같은 경우
			if("dept".equals(work)) {
				controller = new DeptController();
			}
			// 사원 관리인가?
			else if("emp".equals(work)) {
				controller = new EmpController();
			}
			// 회원관리인가?
			else if("member".equals(work)) {
				controller = new MemberController();
			}
		}
		
		return controller;
		}
	}