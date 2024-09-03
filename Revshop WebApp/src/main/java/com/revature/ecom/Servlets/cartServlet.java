package com.revature.ecom.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.revature.ecom.DAO.cartDAO;
import com.revature.ecom.DAO.productDAO;
import com.revature.ecom.Models.messageModel;
import com.revature.ecom.Utils.DatabaseUtil;

/**
 * Servlet implementation class cartServlet
 */
public class cartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		cartDAO cartDao = null;
		try {
			cartDao = new cartDAO(DatabaseUtil.getConnection());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		productDAO productDao = null;
		try {
			productDao = new productDAO(DatabaseUtil.getConnection());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int cid =Integer.parseInt(request.getParameter("cid"));
		int opt =Integer.parseInt(request.getParameter("opt"));
		
		int qty = cartDao.getQuantityById(cid);
		int pid = cartDao.getProductId(cid);
		int quantity = productDao.getProductQuantityById(pid);	
		
		if(opt == 1) {
			if(quantity > 0) {
				cartDao.updateQuantity(cid, qty+1);
				//updating(decreasing) quantity of product in database
				productDao.updateQuantity(pid, productDao.getProductQuantityById(pid) - 1);
				response.sendRedirect("cart.jsp");
				
			}else {
				HttpSession session = request.getSession();
				messageModel message = new messageModel("Product out of stock!", "error", "alert-danger");
				session.setAttribute("message", message);
				response.sendRedirect("cart.jsp");
			}
			
		}else if(opt == 2) {
			cartDao.updateQuantity(cid, qty-1);
			
			//updating(increasing) quantity of product in database
			productDao.updateQuantity(pid, productDao.getProductQuantityById(pid) + 1);
			response.sendRedirect("cart.jsp");
			
		}else if(opt == 3) {
			cartDao.removeProduct(cid);
			HttpSession session = request.getSession();
			messageModel message = new messageModel("Product removed from cart!", "success", "alert-success");
			session.setAttribute("message", message);
			
			//updating quantity of product in database
			//adding all the product qty back to database
			productDao.updateQuantity(pid, productDao.getProductQuantityById(pid) + qty);
			response.sendRedirect("cart.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}