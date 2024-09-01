package com.revature.ecom.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.revature.ecom.DAO.wishlistDAO;
import com.revature.ecom.Models.wishlistModel;
import com.revature.ecom.Utils.DatabaseUtil;

/**
 * Servlet implementation class wishlistServlet
 */
public class wishlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wishlistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int uid = Integer.parseInt(request.getParameter("uid"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		String op = request.getParameter("op");

		wishlistDAO wishlistDao = null;
		try {
			wishlistDao = new wishlistDAO(DatabaseUtil.getConnection());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (op.trim().equals("add")) {
			wishlistModel wishlist = new wishlistModel(uid, pid);
			wishlistDao.addToWishlist(wishlist);
			response.sendRedirect("products.jsp");
		} else if (op.trim().equals("remove")) {
			wishlistDao.deleteWishlist(uid, pid);
			response.sendRedirect("products.jsp");
		}else if(op.trim().equals("delete")) {
			wishlistDao.deleteWishlist(uid, pid);
			response.sendRedirect("profile.jsp");
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
