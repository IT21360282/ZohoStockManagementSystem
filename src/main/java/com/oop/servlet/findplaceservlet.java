package com.oop.servlet;
import java.sql.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class findplaceservlet
 */
@WebServlet("/findplaceservlet")
public class findplaceservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findplaceservlet() {
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
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoho", "root", "2001");
		
		String PackageID = request.getParameter("place");
		
		PreparedStatement id = con.prepareStatement("select * from Harbourdetails where packageID=? ");
		PreparedStatement hd1 = con.prepareStatement("select DestinationType  from Harbourdetails where packageID=? ");
		PreparedStatement hd2 = con.prepareStatement("select ShipId  from Habourdetails where packageID=? ");
		PreparedStatement hd3 = con.prepareStatement("select HarbourName  from Habourdetails where packageID=? ");
		PreparedStatement hd4 = con.prepareStatement("select Location  from Habourdetails where packageID=? ");
	
	    id.setString(1,PackageID);
	    hd1.setString(1,PackageID);
	    hd2.setString(1,PackageID);
	    hd3.setString(1,PackageID);
	    hd4.setString(1,PackageID);
	    
	    ResultSet pid = id.executeQuery();
	    ResultSet hdes = hd1.executeQuery();
	    ResultSet hsi = hd2.executeQuery();
	    ResultSet hsn = hd3.executeQuery();
	    ResultSet hl = hd4.executeQuery();
	    
	    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/findplace2.jsp");
	    dispatcher.forward(request,response);
	    request.setAttribute("value1",  pid);
	    request.setAttribute("value2", hdes);
	    request.setAttribute("value3", hsi);
	    request.setAttribute("value4", hsn);
	    request.setAttribute("value5", hl);
	    
	    
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	}

}

