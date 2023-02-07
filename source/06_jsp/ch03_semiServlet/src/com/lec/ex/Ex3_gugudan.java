package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex3")
public class Ex3_gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numStr = Integer.parseInt(request.getParameter("num"));
		response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<head>");
			out.print("<linck href=\"css/ex2.css\" rel=\"stylesheet\">");
			out.print("</head>");
			out.print("<body>");
			out.print("<h2>" + numStr + "단</h2>");
			for(int i=1 ; i<10 ; i++) {
				out.print("<h2>" + numStr + " * " + i + "=" + (numStr*i) + "</h2>");
			}
			out.print("</body>");
			out.print("</html>");
			out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
