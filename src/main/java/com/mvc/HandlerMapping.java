package com.mvc;

import org.apache.log4j.Logger;

public class HandlerMapping {
	static Logger log = Logger.getLogger(HandlerMapping.class);
	/*******************************************************
	 * 
	 * @param command - dept/deptInsert, emp/empDelete
	 * 					,member/memberUpdate...
	 * @return
	 ******************************************************/
	public static Controller getController(String command) {
		Controller controller = null;
		Object obj = null;
		String commands[] = command.split("/");
		// commands [0] = emp, dept, member 가 O
		// commands [1] = empInsert, deptInsert, memberInsert 가 O
		if(commands.length == 2) {
			String work = commands [0];
			String methodName = commands[1];
			
			// 부서관리와 같은 경우
			// 개발자가 직접 코드로 인스턴스화
			// - 객체관리 책임 => 개발자에게 있음: 의존성 주입이 아님
			if("deptInsert".equals(work)) {
				controller = new DeptController();
				if("deptInsert".equals(methodName)) {
					log.info("deptInsert-부서등록");
				}
			}
			else if("deptUpdate".equals(work)) {
				controller = new DeptController();
				if("deptUpdate".equals(methodName)) {
					log.info("deptUpdate-부서수정");
				}
			}
			else if("deptDelete".equals(work)) {
				controller = new DeptController();
				if("deptDelete".equals(methodName)) {
					log.info("deptDelete-부서삭제");
				}
			}
			else if("deptDetail".equals(work)) {
				controller = new DeptController();
				if("deptDtail".equals(methodName)) {
					log.info("deptDetail-부서 1 건 조회");
				}
			}
			else if("deptList".equals(work)) {
				controller = new DeptController();
				if("deptList".equals(methodName)) {
					log.info("deptList-부서목록 n건 조회");
				}
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