package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import service.MemberService;
import vo.MemberVO;

public class MemberSearchController implements Controller{	//컨트롤러 상속

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	//execute 구현
		
		//Parameter 추출
		String id = req.getParameter("id");
		String job = req.getParameter("job");
		String path =null;
		
		//작업값 확인
		if(job.equals("search"))
			path="/memberSearch.jsp";
		else if(job.equals("update"))
			path = "/memberUpdate.jsp";
		else if(job.equals("delete"))
			path ="/memberDelete.jsp";
		
		//유효성 체크
		if(id.isEmpty()) {
			req.setAttribute("error", "ID를 입력해주시기 바랍니다.");	//error 메세지
			HttpUtil.forward(req, res, path);
			return;
		}
		
		// Service 객체의 메소드 호출
		MemberService service = MemberService.getInstance();
		MemberVO member = service.memberSearch(id);
		
		//Output View 페이지로 이동
		if(member==null) req.setAttribute("result", "검색된 정보가 없습니다.");	//일치하는 id가 없는 경우
		req.setAttribute("member", member);	//출력뷰 이동
		if(job.equals("search")) path="/result/memberSearchOutput.jsp";		//작업값 search일때 SearchOutput 이동
		HttpUtil.forward(req, res, path);
		
	}

}
