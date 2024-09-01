package com.revature.ecom.Servlets;

import jakarta.servlet.ServletException;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.revature.ecom.DAO.userDAO;
import com.revature.ecom.Models.messageModel;
import com.revature.ecom.Utils.DatabaseUtil;
import com.revature.ecom.Utils.mailMessage;

/**
 * Servlet implementation class updatePassServlet
 */
public class updatePassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatePassServlet() {
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
		String referrer = request.getHeader("referer");
		userDAO userDao = null;
		try {
			userDao = new userDAO(DatabaseUtil.getConnection());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		
		if(referrer.contains("forgot_password")) {
			String email = request.getParameter("email").trim();
			List<String> list = userDao.getAllEmail();
			if(list.contains(email)) {
				Random rand = new Random();
				int max = 99999, min = 10000;
				int otp = rand.nextInt(max - min + 1) + min;
				//System.out.println(otp);
				session.setAttribute("otp", otp);
				session.setAttribute("email", email);
				mailMessage.sendOtp(email, otp);
				
				messageModel message = new messageModel("We'ev sent a password reset code to "+email, "success", "alert-success");
				session.setAttribute("message", message);
				response.sendRedirect("otp_code.jsp");
			}else {
				messageModel message = new messageModel("Email not found! Try with another email!", "error", "alert-danger");
				session.setAttribute("message", message);
				response.sendRedirect("forgot_password.jsp");
				return;
			}
		}else if(referrer.contains("otp_code")) {
			int code = Integer.parseInt(request.getParameter("code"));
			int otp = (int)session.getAttribute("otp");
			if(code == otp) {
				session.removeAttribute("otp");
				response.sendRedirect("change_password.jsp");
			}else {
				messageModel message = new messageModel("Invalid verification code entered!", "error", "alert-danger");
				session.setAttribute("message", message);
				response.sendRedirect("otp_code.jsp");
				return;
			}
		}else if(referrer.contains("change_password")) {
			String password = request.getParameter("password");
			String email =(String)session.getAttribute("email");
			userDao.updateUserPasswordByEmail(password, email);
			session.removeAttribute("email");
			
			messageModel message = new messageModel("Password updated successfully!", "error", "alert-success");
			session.setAttribute("message", message);
			response.sendRedirect("login.jsp");
		}

	}

}
