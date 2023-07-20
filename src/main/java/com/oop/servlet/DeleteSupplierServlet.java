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

@WebServlet("/DeleteSupplierServlet")
public class DeleteSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteSupplierServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList <Suppliers> supplierDetails = new ArrayList<Suppliers>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoho", "root", "2001");
			
			String RegNo = request.getParameter("delete");
			
			PreparedStatement ps3 = con.prepareStatement("delete from supplier where RegNo=?"); 
			ps3.setString(1, RegNo);
		
			ps3.executeUpdate(); 
			
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
		
			
			con.close();  
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
