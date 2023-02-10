package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Quiz5")
public class Quiz5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String text = request.getParameter("text");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link href=\"css/quiz5.css\" rel=\"stylesheet\">");
		out.println("</head>");
		out.println("<body>");
			out.println("<table>");
				out.println("<tr>");
					out.println("<td colspan=\"2\">");
						out.println("<h2>반갑습니다 " + name + "님</h2>");
					out.println("</td>");
				out.println("</tr>");
				out.println("<tr>");
					out.println("<td>");
						out.println("<h2>글제목</h2>");
					out.println("</td>");
					out.println("<td>");
						out.println(title);
					out.println("</td>");
				out.println("</tr>");
				out.println("<tr>");
					out.println("<td>");
						out.println("<h2>글내용</h2>");
					out.println("</td>");
					out.println("<td>");
						out.println("<pre>");
							out.println(text);
						out.println("</pre>");
					out.println("</td>");
				out.println("</tr>");
			out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
