package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import service.MemberService;
import vo.MemberVO;

//memberInsert.do 요청 처리 클래스
public class MemberInsertController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	//execute 메소드에 구현
		// 파라미터 추출
		String id = req.getParameter("id");
		String passwd= req.getParameter("passwd");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		
		// 유효성 검사
		if(id.isEmpty()||passwd.isEmpty()||name.isEmpty()||passwd.isEmpty()) {
			req.setAttribute("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다.");	//오류메세지 생성
			
			HttpUtil.forward(req, res, "/memberInsert.jsp");
			return;
		}
		
		// VO객체에 데이터 바인딩
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPasswd(passwd);
		member.setName(name);
		member.setMail(mail);
		
		// Service 객체의 메소드의 호출
		MemberService service = MemberService.getInstance();
		service.memberInsert(member);
		
		// Output View 페이지로 이동
		req.setAttribute("id", id);
		HttpUtil.forward(req, res, "/result/memberInsertOutput.jsp");
	}	
	
}
