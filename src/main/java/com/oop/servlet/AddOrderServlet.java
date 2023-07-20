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
 * Servlet implementation class AddOrderServlet
 */
@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderServlet() {
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
			
			String OrderID = request.getParameter("OrderID");
			String OrderCat = request.getParameter("OrderCat");
			String Supplier = request.getParameter("Supplier");
			String Date = request.getParameter("Date");
			double Total = Double.parseDouble(request.getParameter("Total"));
			String GoodName1 = request.getParameter("GoodName1");
			int GoodQty1= Integer.parseInt(request.getParameter("GoodQty1"));
			String GoodName2 = request.getParameter("GoodName2");
			int GoodQty2= Integer.parseInt(request.getParameter("GoodQty2"));
			String GoodName3 = request.getParameter("GoodName3");
			int GoodQty3= Integer.parseInt(request.getParameter("GoodQty3"));
			
			PreparedStatement ps3 = con.prepareStatement("insert into pendingorder values(?,?,?,?,?)"); 
			ps3.setString(1, OrderID);
			ps3.setString(2, OrderCat);
			ps3.setString(3, Supplier);
			ps3.setString(4, Date);
			ps3.setDouble(5, Total);
			ps3.executeUpdate(); 
			
			if(GoodName1.equals("")) {
				
			}
			else {
				PreparedStatement ps4 = con.prepareStatement("insert into purchased_goods values(?,?,?,?,?)"); 
				ps4.setString(1, OrderID);
				ps4.setString(2, GoodName1);
				ps4.setInt(3, GoodQty1);
				ps4.setDouble(4, 0);
				ps4.setDouble(5, Total);
				ps4.executeUpdate();
			}
			
			if(GoodName2.equals("")) {
				
			}
			else {
				PreparedStatement ps5 = con.prepareStatement("insert into purchased_goods values(?,?,?,?,?)"); 
				ps5.setString(1, OrderID);
				ps5.setString(2, GoodName2);
				ps5.setInt(3, GoodQty2);
				ps5.setDouble(4, 0);
				ps5.setDouble(5, Total);
				ps5.executeUpdate();
			}
			
			if(GoodName3.equals("")) {
				
			}
			else {
				PreparedStatement ps6 = con.prepareStatement("insert into purchased_goods values(?,?,?,?,?)"); 
				ps6.setString(1, OrderID);
				ps6.setString(2, GoodName3);
				ps6.setInt(3, GoodQty3);
				ps6.setDouble(4, 0);
				ps6.setDouble(5, Total);
				ps6.executeUpdate();
			}
			
			PreparedStatement ps1 = con.prepareStatement("select * from PendingOrder"); 
			PreparedStatement ps2 = con.prepareStatement("SELECT COUNT(*) FROM PendingOrder"); 
			ResultSet rs1 = ps1.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
			
			rs2.next();
			int tuple =rs2.getInt(1);
			
			request.setAttribute("tuple", tuple);
			request.setAttribute("value", "All Pending Orders");
			
			
			
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
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/PenOrder.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
