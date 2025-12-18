package lab.ch01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//서블릿도 브라우저의 URL요청으로 호출을 할 수 있다.
@WebServlet("/crudDept")//@Controller + @RequestMapping
public class CrudDeptServlet extends HttpServlet {
	// trace > debug > info >,,,
	Logger log = Logger.getLogger(CrudDeptServlet.class);
	//삭제하기 구현
	/****************************************************************
	 * DELETE FROM dept
	 *  WHERE deptno = ?
	 * @param deptno 10, 20, 30
	 * @return int 1이면 삭제 성공 0이면 삭제 실패
	 ****************************************************************/		
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("doDelete");
		resp.sendRedirect("detp/detpDeleteOk.jsp");
	}//end of doDelete
	//조회,상세조회 - 주문조회, 로그인
	/****************************************************************
	 * SELECT deptno, dname, loc FROM dept
	 * @return List<Map>, List<DeptVO>
	 ****************************************************************/		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("doGet");
		// insert here - 조회결과를 쥐고 있음
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
		list.add(map);
		map=new HashMap<>();
		map.put("deptno",30);
		map.put("dname","운영부");
		map.put("loc","제주");
		list.add(map);
		// 요청이 유지되는 동안에는 이 주소번지로 공유가 가능함!(if 공유가 안된다면 NullPointerException 오류 발생 -> runtime에러)
		req.setAttribute("list", list);
		// jsp 호출하기 - forward 로 해야 함(Because servlet과 jsp가 요청이 계속 유지되고 있다고 생각)
		// 공유가 안되면 NullPointException -> 500 -> Runtime 에러 발생.
		// setAttribute의 소유주는 요청 객체이다.
		// setAttribute의 파라미터는 2개지이다.
		
		// jsp 페이지 호출하기 - forward로 해야 함
		// Because servlet과 jsp가 요청이 계속 유지되고 있다 라고 생각하기 때문
		// ==> 유지가 되지 않는다.
		// 기존 요청 URL이 그대로인데 실제 화면은 /dept/deptList.jsp가 출력된다.
		// * 비상태 프로토콜: 요청 URL이 바뀌면 기존 요청이 끊어지고 새로운 요청이 발생(유지 不可)
		//☆★☆★☆★ 암기 - Select 이면 forward ☆★☆★☆★
		RequestDispatcher view = req.getRequestDispatcher("/dept/deptList.jsp"); // 404번이 뜨면 =61번 확인(링크연결이 오류인 것)
		view.forward(req, resp);
		
	}//end of doGet
	//입력, 저장, 파일업로드, 조회인데 보안상 값이 노출되지 않도록 할 때
	/****************************************************************
	 * INSERT INTO dept(deptno, dname, loc)
	 *           VALUES(:deptno,:dname,:loc)
	 *  @param 사용자가 선택한 부서번호 - deptno
	 *  @param 사용자가 입력한 부서명 - dname
	 *  @param 사용자가 입력한 지역명 - loc
	 *  주의사항 > 브라우저의 URL을 통해서 Post방식을 테스트 할 수 없다(IF 요청을 해보면 조회가 된다. But 원하는 결과가 아님 -> 입력)
	 *  반드시 postman, swagger, javascript
	 ****************************************************************/	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("doPost");
		resp.sendRedirect("/dept/deptInsertOk.jsp");
	}//end of doPost
	//수정하기 구현
	/****************************************************************
	 * UPDATE dept(집합이름)
	 *    SET dname = 수정할 부서명(1)
	 *       ,loc = 수정할 지역명(2)
	 *  WHERE deptno = 수정할 부서번호(pk)(3)
	 *  @param 사용자가 입력한 부서명 - dname
	 *  @param 사용자가 입력한 지역명 - loc
	 *  @param 사용자가 선택한 부서번호 - deptno
	 *  @return int 1 이면 수정 성공 & 0이면 수정 실패
	 *  Q. doput 메서드 리턴타입은 void 1 -> 1 또는 0을 어떻게 jsp페이지를 전달 가능한가?
	 *  	1) query String을 이용한다.
	 *  	2) request scope를 이용한다.
	 *  	jsp 페이지에 1또는 0을 넘겨야 하는가?
	 *  => 1이면 Client에게 수정을 성공했습니다. or 0이면 실패했습니다. ==> 후처리 必要
	 ****************************************************************/
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("doPut");
		//1.입력-청취 -> req.getParameter("dname");
		//1.입력-청취 -> req.getParameter("loc");
		//1.입력-청취 -> req.getParameter("deptno");
		resp.sendRedirect("detp/detpUpdateOk.jsp");
		
	}

}
