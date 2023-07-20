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

import com.oop.model.Card;
import com.oop.model.Payment;

/**
 * Servlet implementation class DisplayCardServlet
 */
@WebServlet("/DisplayCardServlet")
public class DisplayCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayCardServlet() {
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
		ArrayList <Card> cardDetails = new ArrayList<Card>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoho", "root", "2001");
			
			String button = request.getParameter("card");
			
			if(button.equals("SpecCard")) {
				String CardNo = request.getParameter("CardNo");
				
				PreparedStatement ps1 = con.prepareStatement("select * from CardDetails where CardNum=? "); 
				ps1.setString(1, CardNo);
				ResultSet rs1 = ps1.executeQuery();
				int tuple =1;
				
				request.setAttribute("tuple", tuple);
				
				
				while(rs1.next()) {
					Card card = new Card();
					card.setCardNum(rs1.getString(1));
					card.setExMonth(rs1.getString(2));
					card.setCVC(rs1.getString(3));
					card.setPaymentNet(rs1.getString(4));
					card.setBankName(rs1.getString(5));
				
					cardDetails.add(card);
					request.setAttribute("value", rs1.getString(1));
				}
				
				request.setAttribute("cardDetails", cardDetails);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DisplayCardDetails.jsp");
				dispatcher.forward(request, response);
				
			}
			else if(button.equals("AllCard")) {				
				PreparedStatement ps1 = con.prepareStatement("select * from CardDetails"); 
				PreparedStatement ps2 = con.prepareStatement("SELECT COUNT(*) FROM CardDetails"); 
				ResultSet rs1 = ps1.executeQuery();
				ResultSet rs2 = ps2.executeQuery();
				
				rs2.next();
				int tuple =rs2.getInt(1);
				
				request.setAttribute("tuple", tuple);
				request.setAttribute("value", "All Debit Cards");
				
				
				
				while(rs1.next()) {
					Card card = new Card();
					card.setCardNum(rs1.getString(1));
					card.setExMonth(rs1.getString(2));
					card.setCVC(rs1.getString(3));
					card.setPaymentNet(rs1.getString(4));
					card.setBankName(rs1.getString(5));
					cardDetails.add(card);
				}
				request.setAttribute("cardDetails", cardDetails);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DisplayCardDetails.jsp");
				dispatcher.forward(request, response);
			}
			
			else if(button.equals("Payment")) {
				PreparedStatement ps1 = con.prepareStatement("select * from CardDetails"); 
				PreparedStatement ps2 = con.prepareStatement("SELECT COUNT(*) FROM CardDetails"); 
				ResultSet rs1 = ps1.executeQuery();
				ResultSet rs2 = ps2.executeQuery();
				
				rs2.next();
				int tuple =rs2.getInt(1);
				request.setAttribute("tuple", tuple);
				while(rs1.next()) {
					Card card = new Card();
					card.setCardNum(rs1.getString(1));
					cardDetails.add(card);
				}
				request.setAttribute("cardDetails", cardDetails);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Payment.jsp");
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
