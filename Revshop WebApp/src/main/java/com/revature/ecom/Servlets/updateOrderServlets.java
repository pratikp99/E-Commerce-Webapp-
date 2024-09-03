package com.revature.ecom.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.revature.ecom.DAO.orderDAO;
import com.revature.ecom.DAO.userDAO;
import com.revature.ecom.Models.orderModel;
import com.revature.ecom.Utils.DatabaseUtil;
import com.revature.ecom.Utils.mailMessage;

/**
 * Servlet implementation class updateOrderServlets
 */
public class updateOrderServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateOrderServlets() {
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
		//doGet(request, response);
		int oid = Integer.parseInt(request.getParameter("oid"));
		String status = request.getParameter("status");
		orderDAO orderDao = null;
		try {
			orderDao = new orderDAO(DatabaseUtil.getConnection());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		orderDao.updateOrderStatus(oid, status);
		if (status.trim().equals("Shipped") || status.trim().equals("Out For Delivery")) {
			orderModel order = orderDao.getOrderById(oid);
			userDAO userDao = null;
			try {
				userDao = new userDAO(DatabaseUtil.getConnection());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mailMessage.orderShipped(userDao.getUserName(order.getUserId()), userDao.getUserEmail(order.getUserId()),
					order.getOrderId(), order.getDate().toString());
		}
		response.sendRedirect("display_orders.jsp");

	}

}