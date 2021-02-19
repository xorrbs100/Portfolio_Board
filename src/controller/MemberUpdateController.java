package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import service.MemberService;
import vo.MemberVO;

public class MemberUpdateController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Parameter 추출
			String id = req.getParameter("id");
			String passwd = req.getParameter("passwd");
			String name = req.getParameter("name");
			String mail = req.getParameter("mail");
			
			//유효성 체크
			if(id.isEmpty()||passwd.isEmpty()||name.isEmpty()||mail.isEmpty()) {
				req.setAttribute("error", "모든값을 입력해주시기 바랍니다.");	//error 메세지
				HttpUtil.forward(req, res, "/memberUpdate.jsp");
				return;
			}
			//VO객체에 데이터 바인딩
			MemberVO member= new MemberVO();
			member.setId(id);
			member.setPasswd(passwd);
			member.setName(name);
			member.setMail(mail);
			
			// Service 객체의 메소드 호출
			MemberService service = MemberService.getInstance();
			service.memberUpdate(member);
			
			//Output View 페이지로 이동
			req.setAttribute("id", id);
			HttpUtil.forward(req, res, "/result/memberUpdateOutput.jsp");
		}

}
