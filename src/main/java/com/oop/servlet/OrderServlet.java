package com.oop.servlet;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.*;
import java.util.ArrayList;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList <Suppliers> supplierDetails = new ArrayList<Suppliers>();
		ArrayList <Orders> orderDetails = new ArrayList<Orders>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoho", "root", "2001");
		
			String button = request.getParameter("Order");
		
			if(button.equals("PlaceOrderqty")) {
				int qty = 3;
			
				request.setAttribute("value", qty);
		
				
				PreparedStatement ps1 = con.prepareStatement("select * from supplier"); 
				PreparedStatement ps2 = con.prepareStatement("SELECT COUNT(*) FROM supplier"); 
				ResultSet rs1 = ps1.executeQuery();
				ResultSet rs2 = ps2.executeQuery();
				
				rs2.next();
				int tuple =rs2.getInt(1);
				
				request.setAttribute("tuple", tuple);
				
				
				
				
				while(rs1.next()) {
					Suppliers suppliers = new Suppliers();
					suppliers.setSname(rs1.getString(1));
					supplierDetails.add(suppliers);
				}
				request.setAttribute("supplierDetails", supplierDetails);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/PlaceOrder.jsp");
				dispatcher.forward(request, response);
			}
			
			else if(button.equals("PrevSpecOrder")) {
				String PrevID = request.getParameter("PrevID");
				
				PreparedStatement ps1 = con.prepareStatement("select * from PrevOrder where OrderID=? "); 
				ps1.setString(1, PrevID);
				ResultSet rs1 = ps1.executeQuery();
				int tuple =1;
				
				request.setAttribute("tuple", tuple);
				
				
				while(rs1.next()) {
					Orders order = new Orders();
					order.setOrderID(rs1.getString(1));
					order.setCategory(rs1.getString(2));
					order.setSupplier(rs1.getString(3));
					order.setDate(rs1.getString(4));
					order.setSubTotal(rs1.getDouble(5));
				
					orderDetails.add(order);
					request.setAttribute("value", rs1.getString(1));
				}
				
				request.setAttribute("orderDetails", orderDetails);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/PrevOrder.jsp");
				dispatcher.forward(request, response);
				
			}
			else if(button.equals("PrevAllOrder")) {				
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
			}
		
			else if(button.equals("PenSpecOrder")) {
				String PenID = request.getParameter("PenID");
				
				PreparedStatement ps1 = con.prepareStatement("select * from PendingOrder where OrderID=? "); 
				ps1.setString(1, PenID);
				ResultSet rs1 = ps1.executeQuery();
				
				
				
				
				
				while(rs1.next()) {
					Orders order = new Orders();
					order.setOrderID(rs1.getString(1));
					order.setCategory(rs1.getString(2));
					order.setSupplier(rs1.getString(3));
					order.setDate(rs1.getString(4));
					order.setSubTotal(rs1.getDouble(5));
					orderDetails.add(order);
					request.setAttribute("value", rs1.getString(1));
				}
				int tuple = orderDetails.size();
				request.setAttribute("tuple", tuple);
				request.setAttribute("orderDetails", orderDetails);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/PenOrder.jsp");
				dispatcher.forward(request, response);
			}
		
			else if(button.equals("PenAllOrder")) {
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
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}

