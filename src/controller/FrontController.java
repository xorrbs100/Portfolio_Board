package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class FrontController extends HttpServlet{  //MVC2 모델구조		컨트롤러를 서블릿 구조로 개발

	private static final long serialVersionUID =1L;
	String charset = null;
	HashMap<String, Controller>list = null;
	
	@Override
	public void init(ServletConfig sc) throws ServletException {	// 서블릿 초기화 , 서브컨트롤러 실행
		charset = sc.getInitParameter("charset");			//param의 이름이 charset인 태그의 value값을 추출
		list = new HashMap<String, Controller>();
		list.put("/memberInsert.do",new MemberInsertController());
		list.put("/memberSearch.do",new MemberSearchController());
		list.put("/memberUpdate.do",new MemberUpdateController());
		list.put("/memberDelete.do",new MemberDeleteController());
		list.put("/memberList.do",new MemberListController());

	}
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	//클라리언트에서 요청이 들어올때마다 실행하는 메소드
		req.setCharacterEncoding(charset);
		
		//URL 에서 key 추출
		String url = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path= url.substring(contextPath.length());
				
		// subController execute메소드 실행		- 모든 Controller객체에서는 execute를 재정의하여 기능을 구현함
		Controller subController = list.get(path);
		subController.execute(req, res); 
		
	}
}
