package controller;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import service.MemberService;
import vo.MemberVO;

public class MemberListController implements Controller{
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		MemberService service = MemberService.getInstance();
		ArrayList<MemberVO> list = service.memberList();//member 테이블 하나의 레코드가 하나의 회원정보이므로 MemberVO객체를 생성하여 바인딩후 ArrayList에 담아 반환
		
		req.setAttribute("list", list);		//list 이름으로 ArrayList 등록, 전달
		HttpUtil.forward(req, res, "/result/memberListOutput.jsp");
	}

}
