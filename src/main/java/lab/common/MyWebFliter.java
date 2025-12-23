package lab.common;


import java.io.IOException;

import org.apache.log4j.Logger;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
/*
 * 컨트롤마다 중복적으로 넣기 싫은 공통 기능(로깅/인증/인코딩 등)을 필터에서 한번에 처리
 * 필터에서 한번에 처리
 * Filter는 JSP/서블릿 기반 웹서비스에서 최적화(성능/자원/응답크기/캐시/보안)를 위한 앞단 공통 도구로 활용
 * 근거... -> DispatchrServlet 이전에 모든 요청/응답을 가로챌 수 있다.
 * 즉 jsp가 실행되기 전에 전/후 요청, 응답을 통제할 수 있다.
 * 최적화 포인트를 넣기 좋다.
 * 
 * */
@WebFilter(urlPatterns="/*")//모든 요청에 대해 MYWebFilter적용할거야
public class MyWebFliter implements Filter {
	Logger log = Logger.getLogger(MyWebFliter.class);

	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		// 1. 전처리과정
		long startTime = System.currentTimeMillis();
		try {
			HttpServletRequest httpReq = (HttpServletRequest)req;
			log.info("[IN]"+httpReq.getMethod()+", "+httpReq.getRequestURL());
			// 다음 필터로 연결 -> 다음 단계로 진행 되어야 함.
			// 파라미터로 요청객체(req)와 응답객체(res)를 넘긴다 -> 원본 -> 하나의 스레드(얕은 복사)
			filterChain.doFilter(req, res);
		}catch(Exception e){
			log.info("Exception : "+e.toString());
		}finally {
			// 예외가 발생하더라도 항상 실행되어 처리시간을 출력한다...
			long endTime = System.currentTimeMillis();
			if(req instanceof HttpServletRequest httpReq) {
				String uri = httpReq.getRequestURI();
				long elapsed = endTime - startTime;
				log.info("[OUT]["+uri+"] time="+elapsed+"ms");
			}else {
				log.info("[non-http-request] time="+(endTime-startTime)+"ms");
			};// end of if...else
			
		}; // end of try...catch...finally
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		log.info("init()");
	}// end of init
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		log.info("destory()");
	}// end of destory

}
