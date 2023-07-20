package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BackDescriptionServlet
 */
@WebServlet("/BackDescriptionServlet")
public class BackDescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackDescriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button = request.getParameter("button");
		String output="";
		if(button.equals("DBH")) {
			output="Welcome Back Mr. Jayathilake (Database Handler)";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DescriptionDBH.jsp");
			request.setAttribute("value", output);
			dispatcher.forward(request, response);
		}
		
		if(button.equals("PM")) {
			output="Welcome Back Mr. Perera (Purchasing Manager)";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DescriptionPM.jsp");
			request.setAttribute("value", output);
			dispatcher.forward(request, response);
		}

		if(button.equals("SM")) {
			output="Welcome Back Mr. Tennakoon (Shipping Manager)";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DescriptionSM.jsp");
			request.setAttribute("value", output);
			dispatcher.forward(request, response);
		}
	}

}
