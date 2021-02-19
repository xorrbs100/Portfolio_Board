package dao;

import java.sql.*;
import java.util.ArrayList;

import vo.MemberVO;

// DB 처리담당 클래스
public class MemberDAO {
	
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		return dao;
	}

	public Connection connect() { //커넥션 메소드 생성
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");	//Driver로딩
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/member","root","mysql");	//DB접속
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
	
	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {		// 자원해제 메소드
		if (rs!=null) {
			try {
				rs.close();
			}catch(Exception e) {
				System.out.println("오류 발생 : "+e);
			}
		}
		close(conn, ps);
	}//close
	
	public void close(Connection conn, PreparedStatement ps) {
		if(ps!=null) {
			try {
				ps.close();
			}catch(Exception e) {
				System.out.println("오류 발생 : "+e);
			}
		}
		if(conn!= null) {
			try {
				conn.close();
			}catch(Exception e) {
				System.out.println("오류 발생 : "+e);
			}
		}
	}//close
	
	public void memberInsert(MemberVO member) {		// MemberVO객체로 member테이블에 삽입하는 메소드
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into member values(?,?,?,?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getMail());
			pstmt.executeUpdate();		//SQL문 실행 레코드삽입
		}catch(Exception e) {
			System.out.println("오류 발생 : "+e);
		}finally {
			close(conn,pstmt);
		}
	}//insert
	
	public MemberVO memberSearch(String id) {	//Search 기능 메소드 memberVO객체에 담아서 반환
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberVO member = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from member where id = ?");
			pstmt.setString(1, id);		// id에 해당하는 레코드를 member테이블에서 추출하는 SQL문생성
			
			rs = pstmt.executeQuery();	//SQL문 실행후 rs에 저장
			
			if(rs.next()) {		//추출된 레코드가 있을때, member객체 생성후 getter로 컬럼값 추출, setter의 인자값으로 전달 MemberVO객체에 회원정보값 바인딩
				member= new MemberVO();
				member.setId(rs.getString(1));
				member.setPasswd(rs.getString(2));
				member.setName(rs.getString(3));
				member.setMail(rs.getString(4));
			}
		}catch(Exception e) {
			System.out.println("오류 발생 : "+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return member;		//member객체반환
	}
	
	public void memberUpdate(MemberVO member) {	//업데이트 기능 메소드
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("update member set passwd=?, name=?, mail=? where id=?");		//update query 문
			pstmt.setString(1, member.getPasswd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getMail());
			pstmt.setString(4, member.getId());
			pstmt.executeUpdate();	//update문 실행
		}catch(Exception e) {
			System.out.println("오류 발생 : "+e);
		}finally {
			close(conn, pstmt);
		}
	}
	public void memberDelete(String id) {	//삭제 기능 메소드
		Connection conn= null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("delete from member where id = ?");
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("오류 발생 : " +e);
		}finally {
			close(conn,pstmt);
		}
	}
	public ArrayList<MemberVO> memberList() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();	//memberVO 객체 저장 ArrayList
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberVO member = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from member");	//모두출력 query문
			rs = pstmt.executeQuery();
			while(rs.next()) {	//rs 가 true : 추출레코드 있음
				// 새로 생성한 memberVO객체의 rs컬럼값들을 getter 메소드로 추출-> setter 메소드를 이용 MemberVO객체에 정보 바인딩
				member = new MemberVO();
				member.setId(rs.getString(1));
				member.setPasswd(rs.getString(2));
				member.setName(rs.getString(3));
				member.setMail(rs.getString(4));
				//ArrayList 객체에 MemberVO객체 추가
				list.add(member);
			}
		}catch(Exception e) {
			System.out.println("오류 발생 : "+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
}
