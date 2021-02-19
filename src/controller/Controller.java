package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public interface Controller {

	//Controller 객체 작성시 execute()메소드에 기능 구현
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
	
}
