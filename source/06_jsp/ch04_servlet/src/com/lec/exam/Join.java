package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
//		String pw = SHA256.encodeSha256(pw);
		String pwChk = request.getParameter("pwChk");
		String birth = request.getParameter("birth");
		String[] hobby = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String[] mailSend = request.getParameterValues("mailSend");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("body {width:400px; height:600px; border:1px solid #A47160}");
		out.println("h2:nth-child(1), hr {color:#A47160; text-align:center;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>회원가입정보</h2>");
		out.println("<hr>");
		out.println("<h2>이름 : " + name +"</h2>");
		out.println("<h2>아이디 : " + id +"</h2>");
		out.println("<h2>비번 : " + pw +"</h2>");
		out.println("<h2>생년월일 : " + birth +"</h2>");
		for(int i=0 ; i<hobby.length ; i++) {
			out.println("<h2>취미 : " + hobby[i] +"</h2>");
		}
		out.println("<h2>성별 : " + gender +"</h2>");
		out.println("<h2>이메일 : " + email +"</h2>");
		for(int i=0 ; i<mailSend.length ; i++) {
			out.println("<h2>메일수신동의 : " + mailSend[i] +"</h2>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
