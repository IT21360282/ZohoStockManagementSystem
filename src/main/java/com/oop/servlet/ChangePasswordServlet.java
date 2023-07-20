package com.oop.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/ChangePasswordkServlet")
public class ChangePasswordServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePasswordServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoho", "root", "2001");
		

			String User_ID = request.getParameter("User_ID");
			String Password = request.getParameter("Password");
		
		PreparedStatement ps3 = con.prepareStatement("UPDATE Username SET Password=? WHERE user_ID");
		
		ps3.setString(1, User_ID); 
		ps3.setString(2, Password);
		ps3.executeUpdate();
		
		
		

	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AllStockDetails.jsp");
	dispatcher.forward(request, response);

}
catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}}