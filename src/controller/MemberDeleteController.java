package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;

public class MemberDeleteController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//파라미터 추출
		String id = req.getParameter("id");
		//Service 객체 메소드 호출
		MemberService service = MemberService.getInstance();
		service.memberDelete(id);
		
		//Output View 페이지로 이동
		HttpUtil.forward(req, res, "/result/memberDeleteOutput.jsp");
		
	}

}
