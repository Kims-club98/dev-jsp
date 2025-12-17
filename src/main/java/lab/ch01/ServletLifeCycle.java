
package lab.ch01;
/*
 * 웹 요청을 받아서 JAVA 코드로 응답을 만드는 Server Program.
 * 역할: 1) 요청 수신 가능(사용자가 입력한 ID, PW를 청취가능), 2) Logic 처리 가능, 3) HTML/JSON 형태의 응답 생성 가능
 * 응답 처리 시 마임 Type이 중요 - application/json, text/html
 * JSP, Spring MVC도 내부적으로 서블릿 위에서 동작한다.
 * Spring에서 사용하는 서블릿 名 => DispatcherServlet
 * 
 * 서블릿은 언제 생성이 되며, 어떤 메서드가 몇 번 호출이 되는지 관찰해보기!
 * init() -> Service() -> destory()
 * init() - 서블릿이 최초 생성 시 - 단 1회 호출됨. - 싱글톤패턴이라서 하나만 가지고 공유한다.
 * service() - 요청을 할 때마다 호출됨. -> 여러 번 호출 됨
 * destroy() - 한 번만 호출됨.
 * 개발자는 Service()에 관련된 코드만 작성하면 됨!(그 외는 Container가 관리함)
 * */


import java.io.IOException;

import org.apache.log4j.Logger;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
// -> http://localhost:8000/life
// -> http://localhost:8000/dev-jsp/life-> 404번 발생

@WebServlet("/life")//@Controller + @RequestMapping
public class ServletLifeCycle extends HttpServlet {
	Logger log = Logger.getLogger(ServletLifeCycle.class);
	@Override
	public void init(ServletConfig config) throws ServletException {
		log.info("서블릿 초기화");
		//서블릿 객체 생성시 단 한 번 실행
		//DB연결, 설정, 자원준비
		//테스트방법: 새로고침(F5)해도 다시 호출되지 않음.
		//개발자가 호출하는 메서드가 아님
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.입력
		//2.처리
		//3.출력
		res.setContentType("text/html;charset=UTF-8");
		res.getWriter().println("<h2>서블릿라이프사이클 테스트</h2>");
		res.getWriter().println("<p>서블릿이 정상적으로 동작하고 있습니다.</p>");
	}

	@Override
	public void destroy() {
		log.info("ServletLifeCycle destroy");
	}




}
