package service;

import java.util.ArrayList;

import dao.MemberDAO;
import vo.MemberVO;

//회원 서비스 처리 담당 클래스
public class MemberService {

	private static MemberService service = new MemberService();
	public MemberDAO dao = MemberDAO.getInstance();

	private MemberService() {} // 외부에서 생성자 접근제어
	
	public static MemberService getInstance() {
		return service;
	}
	
	public void memberInsert(MemberVO member) {
		dao.memberInsert(member);
	}
	public MemberVO memberSearch(String id) {
		MemberVO member = dao.memberSearch(id);		//id 인자값으로 정보검색
		return member;
	}
	public void memberUpdate(MemberVO member) {
		dao.memberUpdate(member);
	}
	public void memberDelete(String id) {	//id 인자값으로 dao에 전달
		dao.memberDelete(id);
	}
	public ArrayList<MemberVO> memberList() {		// member테이블에서 모든 회원에 대한 정보 추출하여 ArrayList에 담아 컨트롤러로 전달
		ArrayList<MemberVO> list = dao.memberList();	//dao 호출
		return list;
	}
}
