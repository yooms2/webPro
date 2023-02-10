package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Quiz3")
public class Quiz3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		response.setContentType("text/html; charset=utf-8");
			int sum = 0;
			for(int i=0 ; i<=num ; i++) {
				sum += i;
			}
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<link href=\"css/quiz3.css\" rel=\"stylesheet\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>" + "1부터 " + num + "까지 누적합은" + sum +"</h2>");
			out.println("</body>");
			out.println("</html>");
			out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
