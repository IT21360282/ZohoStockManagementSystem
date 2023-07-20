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

import com.oop.model.Suppliers;

/**
 * Servlet implementation class UpdateSupplierServlet
 */
@WebServlet("/UpdateSupplierServlet")
public class UpdateSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSupplierServlet() {
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
		ArrayList <Suppliers> supplierDetails = new ArrayList<Suppliers>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoho", "root", "2001");
			
			String button = request.getParameter("update");
			
			if(button.equals("Update")){
				String Sname = request.getParameter("Sname");
				String Saddress = request.getParameter("Saddress");
				String Semail = request.getParameter("Semail");
				String Sphone = request.getParameter("Sphone");
				String RegNo = request.getParameter("RegNo");
				/*PrintWriter out = response.getWriter();
				out.println(Sname);
				out.println(Saddress);
				out.println(Semail);
				out.println(Sphone);
				out.println(RegNo);*/
				if(Sname.equals("")) {
					
				}
				else {
					
					PreparedStatement ps1 = con.prepareStatement("update supplier set SupplierName=? where RegNo=?");
					ps1.setString(1,Sname);
					ps1.setString(2, RegNo);
					ps1.executeUpdate();
				}
				
				if(Saddress.equals("")) {
					
				}
				else {
					
					PreparedStatement ps1 = con.prepareStatement("update supplier set Address=? where RegNo=?");
					ps1.setString(1,Saddress);
					ps1.setString(2, RegNo);
					ps1.executeUpdate();
				}
				
				if(Semail.equals("")) {
					
				}
				else {
					
					PreparedStatement ps1 = con.prepareStatement("update supplier set email=? where RegNo=?");
					ps1.setString(1,Semail);
					ps1.setString(2, RegNo);
					ps1.executeUpdate();
				}
				
				if(Sphone.equals("")) {
					
				}
				else {
					
					PreparedStatement ps1 = con.prepareStatement("update supplier set Contact=? where RegNo=?");
					ps1.setString(1,Sphone);
					ps1.setString(2, RegNo);
					ps1.executeUpdate();
				}
				PreparedStatement ps1 = con.prepareStatement("select * from supplier"); 
				PreparedStatement ps2 = con.prepareStatement("SELECT COUNT(*) FROM supplier"); 
				ResultSet rs1 = ps1.executeQuery();
				ResultSet rs2 = ps2.executeQuery();
				
				rs2.next();
				int tuple =rs2.getInt(1);
				
				request.setAttribute("tuple", tuple);
				request.setAttribute("value", "All Suppliers");
				
				
				
				while(rs1.next()) {
					Suppliers suppliers = new Suppliers();
					suppliers.setSname(rs1.getString(1));
					suppliers.setRegNo(rs1.getString(2));
					suppliers.setSaddress(rs1.getString(3));
					suppliers.setSemail(rs1.getString(4));
					suppliers.setSphone(rs1.getString(5));
					supplierDetails.add(suppliers);
				}
				request.setAttribute("supplierDetails", supplierDetails);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DisplaySupplier.jsp");
				dispatcher.forward(request, response);
			}
			
			else {
				request.setAttribute("button", button);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/UpdateSupplier.jsp");
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
