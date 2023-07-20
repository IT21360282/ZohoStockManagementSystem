package com.oop.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Payment;


@WebServlet("/DisplayPaymentServlet")
public class DisplayPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayPaymentServlet() {
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
		ArrayList <Payment> paymentDetails = new ArrayList<Payment>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoho", "root", "2001");
			
			String button = request.getParameter("payment");
			
			if(button.equals("SpecPay")) {
				String PayID = request.getParameter("PayID");
				
				PreparedStatement ps1 = con.prepareStatement("select * from payment_details where PID=? "); 
				ps1.setString(1, PayID);
				ResultSet rs1 = ps1.executeQuery();
				int tuple =1;
				
				request.setAttribute("tuple", tuple);
				
				
				while(rs1.next()) {
					Payment payment = new Payment();
					payment.setPID(rs1.getString(1));
					payment.setReason(rs1.getString(2));
					payment.setUsedCard(rs1.getString(3));
					payment.setAmount(rs1.getDouble(4));
					payment.setPaidDate(rs1.getString(5));
				
					paymentDetails.add(payment);
					request.setAttribute("value", rs1.getString(1));
				}
				
				request.setAttribute("paymentDetails", paymentDetails);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DisplayPayment.jsp");
				dispatcher.forward(request, response);
				
			}
			else if(button.equals("AllPay")) {				
				PreparedStatement ps1 = con.prepareStatement("select * from payment_details "); 
				PreparedStatement ps2 = con.prepareStatement("SELECT COUNT(*) FROM payment_details"); 
				ResultSet rs1 = ps1.executeQuery();
				ResultSet rs2 = ps2.executeQuery();
				
				rs2.next();
				int tuple =rs2.getInt(1);
				
				request.setAttribute("tuple", tuple);
				request.setAttribute("value", "All Payment");
				
				
				
				while(rs1.next()) {
					Payment payment = new Payment();
					payment.setPID(rs1.getString(1));
					payment.setReason(rs1.getString(2));
					payment.setUsedCard(rs1.getString(3));
					payment.setAmount(rs1.getDouble(4));
					payment.setPaidDate(rs1.getString(5));
				
					paymentDetails.add(payment);
				}
				request.setAttribute("paymentDetails", paymentDetails);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DisplayPayment.jsp");
				dispatcher.forward(request, response);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
