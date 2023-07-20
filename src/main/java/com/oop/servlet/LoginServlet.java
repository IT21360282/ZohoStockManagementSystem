package com.oop.servlet;

import java.io.IOException;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoho", "root", "2001");
			
			String User = request.getParameter("As");
			String Pass = request.getParameter("pass");
			
			PreparedStatement ps1 = con.prepareStatement("select uname from Login where uname=? AND password=?"); 
			ps1.setString(1, User);
			ps1.setString(2, Pass);
			
			ResultSet rs1 = ps1.executeQuery();
			/*if(rs1.next()) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/DescriptionDBH.jsp");
				dispatcher.forward(request, response);
			}*/
			String output="";
			if(rs1.next()==true){
				if(rs1.getString(1).equals("DBHandler")) {
					output="Welcome Back Mr. Jayathilake (Database Handler)";
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DescriptionDBH.jsp");
					request.setAttribute("value", output);
					dispatcher.forward(request, response);
				}
			
				else if(rs1.getString(1).equals("PurchasingM")) {
					output="Welcome Back Mr. Perera (Purchasing Manager)";
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DescriptionPM.jsp");
					request.setAttribute("value", output);
					dispatcher.forward(request, response);
				}
			
				else if(rs1.getString(1).equals("ShippingM")) {
					output="Welcome Back Mr. Tennakoon (Shipping Manager)";
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DescriptionSM.jsp");
					request.setAttribute("value", output);
					dispatcher.forward(request, response);
				}
			}
			else{
				output="Password is incorrect, <u><a href='Login.jsp' style='color:Red;'>Try again</a></u>";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/LoginFail.jsp");
				request.setAttribute("value", output);
				dispatcher.forward(request, response);
			}
		
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
