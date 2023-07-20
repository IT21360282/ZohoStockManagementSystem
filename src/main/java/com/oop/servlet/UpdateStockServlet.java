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


import com.oop.model.Stock;
import java.util.ArrayList;

/**
 * Servlet implementation class UpdateSupplierServlet
 */
@WebServlet("/UpdateStockServlet")
public class UpdateStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStockServlet() {
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
		ArrayList <Stock> stockDetails = new ArrayList<Stock>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoho", "root", "2002");
			
			String button = request.getParameter("update");
			
			if(button.equals("Update")){
				String S_Name = request.getParameter("S_Name");
				String S_Category = request.getParameter("S_Category");
				int S_Quantity = Integer.parseInt(request.getParameter("S_Quantity"));
				int Purchasing_Price = Integer.parseInt(request.getParameter("Purchasing_Price"));
				String Purchasing_date = request.getParameter("Purchasing_date");
				String Supplier_Name = request.getParameter("Supplier_Name");
				String S_ID = request.getParameter("S_ID");
				/*PrintWriter out = response.getWriter();
				out.println(S_name);
				out.println(S_Category);
				out.println(S_Quantity);
				out.println(Purchasing_Price);
				out.println(Purchasing_date);
				out.println(Supplier_Name);	
				out.println(S_ID);*/
				if(S_Name.equals("")) {
					
				}
				else {
					
					PreparedStatement ps1 = con.prepareStatement("update Stock_Details set S_Name=? where S_ID=?");
					ps1.setString(1,S_Name);
					ps1.setString(2, S_ID);
					ps1.executeUpdate();
				}
				
				if(S_Category.equals("")) {
					
				}
				else {
					
					PreparedStatement ps1 = con.prepareStatement("update Stock_Details set S_Category=? where S_ID=?");
					ps1.setString(1,S_Category);
					ps1.setString(2, S_ID);
					ps1.executeUpdate();
				}
				
				if(S_Quantity==0) {
					
				}
				else {
					
					PreparedStatement ps1 = con.prepareStatement("update Stock_Details set S_Quantity=? where S_ID=?");
					ps1.setInt(1, S_Quantity);
					ps1.setString(2, S_ID);
					ps1.executeUpdate();
				}
				
				if(Purchasing_Price ==0) {
					
				}
				else {
					
					PreparedStatement ps1 = con.prepareStatement("update Stock_Details set Purchasing_Price=? where S_ID=?");
					ps1.setInt(1, Purchasing_Price);
					ps1.setString(2, S_ID);
					ps1.executeUpdate();
				}
				if(Purchasing_date.equals("")) {
					
				}
				else {
					
					PreparedStatement ps1 = con.prepareStatement("update Stock_Details set Purchasing_date=? where S_ID=?");
					ps1.setString(1,Purchasing_date);
					ps1.setString(2, S_ID);
					ps1.executeUpdate();
				}
				if(Supplier_Name.equals("")) {
					
				}
				else {
					
					PreparedStatement ps1 = con.prepareStatement("update Stock_Details set Supplier_Name=? where S_ID=?");
					ps1.setString(1,Supplier_Name);
					ps1.setString(2, S_ID);
					ps1.executeUpdate();
				}
				PreparedStatement ps1 = con.prepareStatement("select * from Stock_Details"); 
				PreparedStatement ps2 = con.prepareStatement("SELECT COUNT(*) FROM Stock_Details"); 
				ResultSet rs1 = ps1.executeQuery();
				ResultSet rs2 = ps2.executeQuery();
				
				rs2.next();
				int tuple =rs2.getInt(1);
				
				request.setAttribute("tuple", tuple);
				request.setAttribute("value", "All Suppliers");
				
				
				
				while(rs1.next()) {
					Stock stock = new Stock();
					stock.setS_ID(rs1.getString(1));
					stock.setS_Name(rs1.getString(2));
					stock.setS_Category(rs1.getString(3));
					stock.setS_Quantity(rs1.getInt(4));
					stock.setPurchasing_Price(rs1.getInt(5));
					stock.setPurchasing_date(rs1.getString(6));
					stock.setSupplier_Name(rs1.getString(7));
					stockDetails.add(stock);
				}
				request.setAttribute("stockDetails", stockDetails);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AllStockDetails.jsp");
				dispatcher.forward(request, response);
			}
			
			else {
				request.setAttribute("button", button);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/UpdatedStockEnter.jsp");
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