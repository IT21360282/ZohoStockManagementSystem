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

import com.oop.model.Goods;
import com.oop.model.Orders;

/**
 * Servlet implementation class DisplayGoodsServlet
 */
@WebServlet("/DisplayGoodsServlet")
public class DisplayGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayGoodsServlet() {
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
		ArrayList <Goods> goodsDetails = new ArrayList<Goods>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoho", "root", "2001");
			
			String OrderID = request.getParameter("goods");
			
			PreparedStatement ps1 = con.prepareStatement("select * from purchased_goods where OrderID=? "); 
			PreparedStatement ps2 = con.prepareStatement("SELECT COUNT(*) FROM purchased_goods where OrderID=?"); 
			ps1.setString(1, OrderID);
			ps2.setString(1, OrderID);
			ResultSet rs1 = ps1.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
			rs2.next();
			
			int tuple =rs2.getInt(1);
			
			request.setAttribute("tuple", tuple);
			
			
			while(rs1.next()) {
				Goods goods = new Goods();
				goods.setOrderID(rs1.getString(1));
				goods.setGoodsName(rs1.getString(2));
				goods.setQty(rs1.getInt(3));
			
			
				goodsDetails.add(goods);
				request.setAttribute("value", rs1.getString(1));
			}
			
			request.setAttribute("goodsDetails", goodsDetails);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DisplayGoods.jsp");
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
