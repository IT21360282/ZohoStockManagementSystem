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

import com.oop.model.Harbour;


@WebServlet("/DisplayHarbourServlet")
public class DisplayHarbourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayHarbourServlet() {
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
		ArrayList <Harbour> harDetails = new ArrayList<Harbour>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoho", "root", "2001");
			
			String button = request.getParameter("harbour");
			
			if(button.equals("Sp")) {
				String PID = request.getParameter("P_ID");
				
				PreparedStatement ps1 = con.prepareStatement("select * from Harbour_details where P_ID=? "); 
				ps1.setString(1, PID);
				ResultSet rs1 = ps1.executeQuery();
				int tuple =1;
				
				request.setAttribute("tuple", tuple);
				
				
				while(rs1.next()) {
					Harbour har = new Harbour();
					har.setP_ID(rs1.getString(1));
					har.setProvince(rs1.getString(2));
					har.setShip_ID(rs1.getString(3));
					har.setHarbour_Name(rs1.getString(4));
					
				
					harDetails.add(har);
					request.setAttribute("value", rs1.getString(1));
				}
				
				request.setAttribute("harbourDetails", harDetails);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/findplace2.jsp");
				dispatcher.forward(request, response);
				
			}
			else if(button.equals("Allhar")) {				
				PreparedStatement ps1 = con.prepareStatement("select * from Harbour_details "); 
				PreparedStatement ps2 = con.prepareStatement("SELECT COUNT(*) FROM Harbour_details"); 
				ResultSet rs1 = ps1.executeQuery();
				ResultSet rs2 = ps2.executeQuery();
				
				rs2.next();
				int tuple =rs2.getInt(1);
				
				request.setAttribute("tuple", tuple);
				request.setAttribute("value", "All Harbour");
				
				
				
				while(rs1.next()) {
					Harbour har = new Harbour();
					har.setP_ID(rs1.getString(1));
					har.setProvince(rs1.getString(2));
					har.setShip_ID(rs1.getString(3));
					har.setHarbour_Name(rs1.getString(4));
					
				
					harDetails.add(har);
				}
				request.setAttribute("harDetails", harDetails);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DisplayHarbour.jsp");
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
