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

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.oop.model.Package;
import java.util.ArrayList;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/addpackageservlet")
public class addpackageservlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addpackageservlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList <Package> PackageDetails = new ArrayList<Package>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoho", "root", "2001");
		

			String P_ID = request.getParameter("PackageID");
			String P_Type = request.getParameter("packageType");
			String P_Height = request.getParameter("PackageHeight");
			String P_Weight = request.getParameter("Packageweight");
			String P_Length = request.getParameter("PackageLength");
			String Label_Color = request.getParameter("LabelColor");

			PreparedStatement ob1 = con.prepareStatement("insert into Package_Details values(?,?,?,?,?,?)");
		
			ob1.setString(1, P_ID); 
			ob1.setString(2, P_Type);
			ob1.setString(3, P_Height);
			ob1.setString(4, P_Weight);
			ob1.setString(5, P_Length);
			ob1.setString(6, Label_Color);
			ob1.executeUpdate();
			
			PreparedStatement p1 = con.prepareStatement("select * from Package_Details"); 
			PreparedStatement p2 = con.prepareStatement("SELECT COUNT(*) FROM Package_Details"); 
			ResultSet xy1 = p1.executeQuery();
			ResultSet xy2 = p2.executeQuery();
			
			xy2.next();
			int tuple =xy2.getInt(1);
			
			request.setAttribute("tuple", tuple);
			request.setAttribute("value", "All Package");
			
			
			
			while(xy1.next()) {
				Package pack = new Package();
				pack.setP_ID(xy1.getString(1));
				pack.setP_Type(xy1.getString(2));
				pack.setP_Height(xy1.getString(3));
				pack.setP_Weight(xy1.getString(4));
				pack.setP_Lenght(xy1.getString(5));
				pack.setLabel_Color(xy1.getString(6));
				
				PackageDetails.add(pack);
			}
			request.setAttribute("packDetails", PackageDetails);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DisplayPackageDetails.jsp");
		dispatcher.forward(request, response);
	
}
	catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		PrintWriter out = response.getWriter();
	      out.println(e);
}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		PrintWriter out = response.getWriter();
	      out.println(e);
}
	
}
}
