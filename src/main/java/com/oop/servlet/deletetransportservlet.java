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


import com.oop.model.*;
import java.util.ArrayList;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/deletetransportservlet")
public class deletetransportservlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public deletetransportservlet() {
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

		ArrayList <transport> VehicleDetails = new ArrayList<transport>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoho", "root", "2001");
		

			String V_ID = request.getParameter("delete");

			PreparedStatement ps3 = con.prepareStatement("DELETE FROM Vehicle_Details WHERE V_ID = ?");
		
			ps3.setString(1, V_ID); 
			ps3.executeUpdate();
			
			PreparedStatement ps1 = con.prepareStatement("select * from Vehicle_Details"); 
			PreparedStatement ps2 = con.prepareStatement("SELECT COUNT(*) FROM Vehicle_Details"); 
			ResultSet rs1 = ps1.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
			
			rs2.next();
			int tuple =rs2.getInt(1);
			
			request.setAttribute("tuple", tuple);
			//request.setAttribute("value", "All Vehicles");
			
			
			
			while(rs1.next()) {
				transport vehi = new transport();
				vehi.setV_ID(rs1.getString(1));
				vehi.setV_Type(rs1.getString(2));
				vehi.setV_Code(rs1.getString(3));
				vehi.setDriver_Name(rs1.getString(4));
				vehi.setDeparture_Date(rs1.getString(5));
				
				
				VehicleDetails.add(vehi);
			}
			request.setAttribute("vehiDetails", VehicleDetails);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DisplayVehicle.jsp");
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
	
}
}

