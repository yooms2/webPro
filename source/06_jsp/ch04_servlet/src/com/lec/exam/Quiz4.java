package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Quiz4")
public class Quiz4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String[] colorSet = {"red", "orange", "yellow", "green", "blue", "navy", "violet"};
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String col = request.getParameter("col");
		int backcol = 0;
		for(backcol=0 ; backcol<colorSet.length ; backcol++) {
			if(colorSet[backcol].equals(col)) {
				break;
			}
		}
		int fontcol = (backcol==0)? 6 : backcol-1;
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("body {background-color: " + colorSet[backcol] + ";}");
		out.println("* {color: " + colorSet[fontcol] +";}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>GET방식 요청입니다</h2>");
		out.println("<h2>글자색은 " + colorSet[fontcol] + ", 배경색은 " + backcol +"입니다</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int backcol = Integer.parseInt(request.getParameter("backcol"));
		int fontcol = (backcol==0)? 6 : backcol-1;
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("body {background-color: " + colorSet[backcol] + ";}");
		out.println("* {color: " + colorSet[fontcol] +";}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>GET방식 요청입니다</h2>");
		out.println("<h2>글자색은 " + colorSet[fontcol] + ", 배경색은 " + colorSet[backcol] +"입니다</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
