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

import com.oop.model.Orders;

/**
 * Servlet implementation class DeletePenOrderServlet
 */
@WebServlet("/DeletePenOrderServlet")
public class DeletePenOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePenOrderServlet() {
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
		ArrayList <Orders> orderDetails = new ArrayList<Orders>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoho", "root", "2001");
			
			String PenOrderID = request.getParameter("received");
			PreparedStatement ps4 = con.prepareStatement("select * from pendingorder where OrderId=?");
			ps4.setString(1, PenOrderID);
			ResultSet rs3= ps4.executeQuery() ;
			
		
			while(rs3.next()) {
				String OrderID = rs3.getString(1);
				String Category = rs3.getString(2);
				String Supplier = rs3.getString(3);
				String Date = rs3.getString(4);
				double SubTotal = rs3.getDouble(5);
				
				PreparedStatement ps5 = con.prepareStatement("insert into PrevOrder values(?,?,?,?,?)");
				ps5.setString(1, OrderID);
				ps5.setString(2, Category);
				ps5.setString(3, Supplier);
				ps5.setString(4, Date);
				ps5.setDouble(5, SubTotal);
				ps5.executeUpdate();
			
			}
			
			PreparedStatement ps3 = con.prepareStatement("delete from pendingorder where OrderID=?"); 
			ps3.setString(1, PenOrderID);
		
			ps3.executeUpdate(); 
			
			PreparedStatement ps1 = con.prepareStatement("select * from PrevOrder"); 
			PreparedStatement ps2 = con.prepareStatement("SELECT COUNT(*) FROM PrevOrder"); 
			ResultSet rs1 = ps1.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
			
			rs2.next();
			int tuple =rs2.getInt(1);
			
			request.setAttribute("tuple", tuple);
			request.setAttribute("value", "All Previous Orders");
			
			
			
			while(rs1.next()) {
				Orders order = new Orders();
				order.setOrderID(rs1.getString(1));
				order.setCategory(rs1.getString(2));
				order.setSupplier(rs1.getString(3));
				order.setDate(rs1.getString(4));
				order.setSubTotal(rs1.getDouble(5));
				orderDetails.add(order);
			}
			request.setAttribute("orderDetails", orderDetails);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/PrevOrder.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
