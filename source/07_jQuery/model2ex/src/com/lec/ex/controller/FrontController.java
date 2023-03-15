package com.lec.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import com.lec.ex.service.*;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		if(command.equalsIgnoreCase("/main.do")) { // 첫화면
			viewPage = "main/main.jsp";
		/* * * * * * * * * * * * * * * * * * * * * * * * *	
		 * * * * * * * * * member 관련 요청 * * * * * * * * *		
		 * * * * * * * * * * * * * * * * * * * * * * * * */	
		} else if(command.equals("/joinView.do")) {
			viewPage = "member/join.jsp";
		} else if(command.equals("/idConfirm.do")) {
			service = new MidConfirmService();
			service.execute(request, response);
			viewPage = "member/idConfirm.jsp";
		} else if(command.equals("/emailConfirm.do")) {
			service = new MemailConfirmService();
			service.execute(request, response);
			viewPage = "member/emailConfirm.jsp";
		} else if(command.equals("/join.do")) {
			service = new JoinService();
			service.execute(request, response);
			viewPage = "loginView.do";
		} else if(command.equals("/loginView.do")) {
			viewPage = "member/login.jsp";
		/* * * * * * * * * * * * * * * * * * * * * * * * *	
		 * * * * * * * * * * admin 관련 요청 * * * * * * * * *		
		 * * * * * * * * * * * * * * * * * * * * * * * * */	
		} else if(command.equals("/adminLoginView.do")) {
			viewPage = "admin/adminLogin.jsp";
		} else if(command.equals("/adminLogin.do")) {
			service = new ALoginService();
			service.execute(request, response);
			viewPage = "allView.do";
		} else if(command.equals("/allView.do")) {
			service = new MAllViewService();
			service.execute(request, response);
			viewPage = "member/mAllView.jsp";
		}
		/* * * * * * * * * * * * * * * * * * * * * * * * *	
		 * * * * * * * * 파일첨부 게시판 관련 요청 * * * * * * * *		
		 * * * * * * * * * * * * * * * * * * * * * * * * */
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
