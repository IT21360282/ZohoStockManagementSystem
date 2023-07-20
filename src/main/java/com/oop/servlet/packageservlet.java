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

import com.oop.model.Package;
import java.util.ArrayList;

@WebServlet("/packageservlet")
public class packageservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public packageservlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList <Package> PackageDetails = new ArrayList<Package>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoho", "root", "2001");

		
				
				PreparedStatement ps1 = con.prepareStatement("select * from Package_Details"); 
				PreparedStatement ps2 = con.prepareStatement("SELECT COUNT(*) FROM Package_Details"); 
				ResultSet rs1 = ps1.executeQuery();
				ResultSet rs2 = ps2.executeQuery();
				
				rs2.next();
				int tuple =rs2.getInt(1);
				
				request.setAttribute("tuple", tuple);
				request.setAttribute("value", "All Packages");
				
				
				
				while(rs1.next()) {
					Package pack = new Package();
					pack.setP_ID(rs1.getString(1));
					pack.setP_Type(rs1.getString(2));
					pack.setP_Height(rs1.getString(3));
					pack.setP_Weight(rs1.getString(4));
					pack.setP_Lenght(rs1.getString(5));
					pack.setLabel_Color(rs1.getString(6));
					
					
					PackageDetails.add(pack);
				}
				request.setAttribute("packDetails", PackageDetails);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DisplayPackageDetails.jsp");
				dispatcher.forward(request, response);
				
		}
		
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}