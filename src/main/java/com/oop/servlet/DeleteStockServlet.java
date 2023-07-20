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
@WebServlet("/DeleteStockServlet")
public class DeleteStockServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteStockServlet() {
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

		ArrayList <Stock> StockDetails = new ArrayList<Stock>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoho", "root", "2001");
		

			String S_ID = request.getParameter("delete");

			PreparedStatement ps3 = con.prepareStatement("DELETE FROM Stock_Details WHERE S_ID = ?");
		
			ps3.setString(1, S_ID); 
			ps3.executeUpdate();
			
			PreparedStatement ps1 = con.prepareStatement("select * from Stock_Details"); 
			PreparedStatement ps2 = con.prepareStatement("SELECT COUNT(*) FROM Stock_Details"); 
			ResultSet rs1 = ps1.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
			
			rs2.next();
			int tuple =rs2.getInt(1);
			
			request.setAttribute("tuple", tuple);
			//request.setAttribute("value", "All Stocks");
			
			
			
			while(rs1.next()) {
				Stock stock = new Stock();
				stock.setS_ID(rs1.getString(1));
				stock.setS_Name(rs1.getString(2));
				stock.setS_Category(rs1.getString(3));
				stock.setS_Quantity(rs1.getInt(4));
				stock.setPurchasing_Price(rs1.getInt(5));
				stock.setPurchasing_date(rs1.getString(6));
				stock.setSupplier_Name(rs1.getString(7));
				
				StockDetails.add(stock);
			}
			request.setAttribute("stockDetails", StockDetails);
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
	
}
}
