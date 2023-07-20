package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QualityValidationServlet
 */
@WebServlet("/QualityValidationServlet")
public class QualityValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QualityValidationServlet() {
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
		String[] QualityValid = request.getParameterValues("quality");
		int y = QualityValid.length;
		
		//String Condition="";
		if(y<=2) {
			String Condition = "Very low quality package, You cannot ship this and make package again";
			String button = "<a href=\"quality1.jsp\"><input type=\"button\" class=\"func\" style=\"width:3.5cm; height:0.8cm;\" value=\"Back Validation\"></a>";
			request.setAttribute("button", button);
			request.setAttribute("condition", Condition);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewCondition.jsp");
			dispatcher.forward(request, response);
		}
		
		else if(y<=4) {
			String Condition = "Low quality package, You cannot ship this and make package again";
			String button = "<a href=\"quality1.jsp\"><input type=\"button\" class=\"func\" style=\"width:3.5cm; height:0.8cm;\" value=\"Back Validation\"></a>";
			request.setAttribute("button", button);
			request.setAttribute("condition", Condition);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewCondition.jsp");
			dispatcher.forward(request, response);
		}
		
		else if(y<=6) {
			String Condition = "Good quality package, You can ship this or make package again in perfect quality";
			String button = "<a href=\"quality1.jsp\"><input type=\"button\" class=\"func\" style=\"width:3.5cm; height:0.8cm;\" value=\"Back Validation\"></a><br><br><a href=\"vehicle.jsp\"><input type=\"button\" class=\"func\" style=\"width:3.5cm; height:0.8cm;\" value=\"Confirm to ship\"></a>";
			request.setAttribute("button", button);
			request.setAttribute("condition", Condition);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewCondition.jsp");
			dispatcher.forward(request, response);
		}
		
		else if(y<=8) {
			String Condition = "Perfect quality package, You can ship this";
			String button = "<a href=\"vehicle.jsp\"><input type=\"button\" class=\"func\" style=\"width:3.5cm; height:0.8cm;\" value=\"Confirm to ship\"></a>";
			request.setAttribute("button", button);
			request.setAttribute("condition", Condition);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewCondition.jsp");
			dispatcher.forward(request, response);
		}
		/*request.setAttribute("condition", Condition);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewCondition.jsp");
		dispatcher.forward(request, response);*/
	}

}
