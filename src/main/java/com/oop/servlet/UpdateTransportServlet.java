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

import com.oop.model.transport;

/**
 * Servlet implementation class UpdateSupplierServlet
 */
@WebServlet("/UpdateTransportServlet")
public class UpdateTransportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTransportServlet() {
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
		ArrayList <transport> VehicleDetails = new ArrayList<transport>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoho", "root", "2001");
			
			String button = request.getParameter("update");
			
			if(button.equals("Update")){
				String V_ID = request.getParameter("V_ID");
				String V_Type = request.getParameter("VType");
				String V_Code = request.getParameter("VCode");
				String Driver_Name = request.getParameter("DName");
				String Departure_Date = request.getParameter("DDate");
				/*PrintWriter out = response.getWriter();
				out.println(VType);
				out.println(VCode);
				out.println(DName);
				out.println(DDate);
				out.println(VID);*/
				if(V_Type.equals("")) {
					
				}
				else {
					
					PreparedStatement ps1 = con.prepareStatement("update vehicle_details set V_Type=? where V_ID=?");
					ps1.setString(1,V_Type);
					ps1.setString(2, V_ID);
					ps1.executeUpdate();
				}
				
				if(V_Code.equals("")) {
					
				}
				else {
					
					PreparedStatement ps1 = con.prepareStatement("update vehicle_details set V_code=? where V_ID=?");
					ps1.setString(1,V_Code);
					ps1.setString(2, V_ID);
					ps1.executeUpdate();
				}
				
				if(Driver_Name.equals("")) {
					
				}
				else {
					
					PreparedStatement ps1 = con.prepareStatement("update vehicle_details set Driver_Name=? where V_ID=?");
					ps1.setString(1,Driver_Name);
					ps1.setString(2, V_ID);
					ps1.executeUpdate();
				}
				
				if(Departure_Date.equals("")) {
					
				}
				else {
					
					PreparedStatement ps1 = con.prepareStatement("update vehicle_details set Departure_Date=? where V_ID=?");
					ps1.setString(1,Departure_Date);
					ps1.setString(2, V_ID);
					ps1.executeUpdate();
				}
				
				PreparedStatement v1 = con.prepareStatement("select * from Vehicle_Details"); 
				PreparedStatement v2 = con.prepareStatement("SELECT COUNT(*) FROM Vehicle_Details"); 
				ResultSet ab1 = v1.executeQuery();
				ResultSet ab2 = v2.executeQuery();
				
				ab2.next();
				int tuple =ab2.getInt(1);
				
				request.setAttribute("tuple", tuple);
				request.setAttribute("value", "All Vehicles");
				
				
				
				while(ab1.next()) {
					transport vehi = new transport();
					vehi.setV_ID(ab1.getString(1));
					vehi.setV_Type(ab1.getString(2));
					vehi.setV_Code(ab1.getString(3));
					vehi.setDriver_Name(ab1.getString(4));
					vehi.setDeparture_Date(ab1.getString(5));
					VehicleDetails.add(vehi);
				}
				request.setAttribute("vehiDetails", VehicleDetails);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DisplayVehicle.jsp");
			dispatcher.forward(request, response);
			}
			
			else {
				request.setAttribute("button", button);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/UpdateTransport.jsp");
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
