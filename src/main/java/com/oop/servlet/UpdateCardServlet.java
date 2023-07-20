package com.oop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class UpdateCardServlet
 */
@WebServlet("/UpdateCardServlet")
public class UpdateCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCardServlet() {
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
			
			String button = request.getParameter("update");
			
			if(button.equals("Update")){
				String CardNum = request.getParameter("CardNum");
				String ExMonth = request.getParameter("ExMonth");
				String CVC = request.getParameter("CVC");
				String PaymentNet = request.getParameter("PaymentNet");
				String bankName = request.getParameter("bankName");
				/*PrintWriter out = response.getWriter();
				/*out.println(CardNum);
				out.println(ExMonth);
				out.println(CVC);
				out.println(PaymentNet);
				out.println(bankName);*/
				if(CardNum.equals("")) {
					
				}
				else {
					
					PreparedStatement ps1 = con.prepareStatement("update carddetails set CardNum=? where CardNum=?");
					ps1.setString(1,CardNum);
					ps1.setString(2, CardNum);
					ps1.executeUpdate();
				}
				
				if(ExMonth.equals("")) {
					
				}
				else {
					
					PreparedStatement ps1 = con.prepareStatement("update carddetails set ExMonth=? where CardNum=?");
					ps1.setString(1,ExMonth);
					ps1.setString(2, CardNum);
					ps1.executeUpdate();
				}
				
				if(CVC.equals("")) {
					
				}
				else {
					
					PreparedStatement ps1 = con.prepareStatement("update carddetails set CVC=? where CardNum=?");
					ps1.setString(1,CVC);
					ps1.setString(2, CardNum);
					ps1.executeUpdate();
				}
				
				if(PaymentNet.equals("")) {
					
				}
				else {
					
					PreparedStatement ps1 = con.prepareStatement("update carddetails set PaymentNet=? where CardNum=?");
					ps1.setString(1,PaymentNet);
					ps1.setString(2, CardNum);
					ps1.executeUpdate();
				}
				if(bankName.equals("")) {
					
				}
				else {
					
					PreparedStatement ps1 = con.prepareStatement("update carddetails set bankName=? where CardNum=?");
					ps1.setString(1,bankName);
					ps1.setString(2, CardNum);
					ps1.executeUpdate();
				}
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
			else {
				request.setAttribute("button", button);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/UpdateCardNum.jsp");
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
