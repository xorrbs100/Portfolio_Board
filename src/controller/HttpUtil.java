package controller;

import javax.servlet.*;
import javax.servlet.http.*;

//출력 뷰(OutPut)이동 처리 클래스
public class HttpUtil {
	public static void forward(HttpServletRequest req, HttpServletResponse res, String path) {	//사용자 정의 메소드 다른페이지로 이동하기 위한 기능
		try {
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);	//path에 저장된 URL경로 저장
			dispatcher.forward(req, res);	//경로로 이동
		}catch(Exception e){
			System.out.println("forward 오류 : "+e);
		}
	}
}
