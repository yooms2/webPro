package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Quiz1")
public class Quiz1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] dan = request.getParameterValues("dan");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link href=\"../css/quiz1.css\" rel=\"stylesheet\">");
		out.println("</head>");
		out.println("<body>");
		if(dan!=null) {
			for(int i=0 ; i<dan.length ; i++) {
				out.println(dan[i] + "단<br>");
				int dansu = Integer.parseInt(dan[i]);
				for(int j=1 ; j<10 ; j++) {
					out.println("<h5>" + dansu + " * " + j + " = " + dansu*j + "</h5>");
				}
			}
		} else {
			out.println("<h2>단을 선택하지 않았습니다</h2>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
