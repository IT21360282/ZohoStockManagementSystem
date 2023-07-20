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


import com.oop.model.transport;
import java.util.ArrayList;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/addtransportservlet")
public class addtransportservlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addtransportservlet() {
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
		

			String V_ID = request.getParameter("V_ID");
			String V_Type = request.getParameter("V_Type");
			String V_Code = request.getParameter("V_Code");
			String Driver_Name = request.getParameter("Driver_Name");
			String Departure_Date = request.getParameter("Departure_Date");
			

			PreparedStatement ob2 = con.prepareStatement("insert into Vehicle_Details values(?,?,?,?,?)");
		
			ob2.setString(1, V_ID); 
			ob2.setString(2, V_Type);
			ob2.setString(3, V_Code);
			ob2.setString(4, Driver_Name);
			ob2.setString(5, Departure_Date);
			ob2.executeUpdate();			
			
			PreparedStatement v1 = con.prepareStatement("select * from Vehicle_Details"); 
			PreparedStatement v2 = con.prepareStatement("SELECT COUNT(*) FROM Vehicle_Details"); 
			ResultSet ab1 = v1.executeQuery();
			ResultSet ab2 = v2.executeQuery();
			
			ab2.next();
			int tuple =ab2.getInt(1);
			
			request.setAttribute("tuple", tuple);
			request.setAttribute("value", "All Vehicles");
			
			
			
			while(ab1.next()) {
				transport vehi = new transport();
				vehi.setV_ID(ab1.getString(1));
				vehi.setV_Type(ab1.getString(2));
				vehi.setV_Code(ab1.getString(3));
				vehi.setDriver_Name(ab1.getString(4));
				vehi.setDeparture_Date(ab1.getString(5));
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
