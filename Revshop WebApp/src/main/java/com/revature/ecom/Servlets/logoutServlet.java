package com.revature.ecom.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.revature.ecom.Models.messageModel;

/**
 * Servlet implementation class logoutServlet
 */
public class logoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String user = request.getParameter("user");
		HttpSession session = request.getSession();
		if(user.trim().equals("user")) {
			session.removeAttribute("activeUser");
			messageModel message = new messageModel("Logout successfully!!", "success", "alert-success");
			session.setAttribute("message", message);
			response.sendRedirect("login.jsp");
		}else if(user.trim().equals("admin")) {
			session.removeAttribute("activeAdmin");
			messageModel message = new messageModel("Logout successfully!!", "success", "alert-success");
			session.setAttribute("message", message);
			response.sendRedirect("adminlogin.jsp");
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
