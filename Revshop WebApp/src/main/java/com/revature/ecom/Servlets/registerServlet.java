package com.revature.ecom.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.revature.ecom.DAO.userDAO;
import com.revature.ecom.Models.messageModel;
import com.revature.ecom.Models.userModel;
import com.revature.ecom.Utils.DatabaseUtil;
import com.revature.ecom.Utils.mailMessage;

/**
 * Servlet implementation class registerServlet
 */
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
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
		try {
			String userName = request.getParameter("user_name");
			String userEmail = request.getParameter("user_email");
			String userPassword = request.getParameter("user_password");
			String userPhone = request.getParameter("user_mobile_no");
			String userGender = request.getParameter("gender");
			String userAddress = request.getParameter("user_address");
			String userCity = request.getParameter("city");
			String userPincode = request.getParameter("pincode");
			String userState = request.getParameter("state");

			userModel user = new userModel(userName, userEmail, userPassword, userPhone, userGender, userAddress, userCity, userPincode, userState);
			userDAO userDao = new userDAO(DatabaseUtil.getConnection());
			boolean flag = userDao.saveUser(user);

			HttpSession session = request.getSession();
			messageModel message;
			if (flag) {
				message = new messageModel("Registration Successful !!", "success", "alert-success");
				mailMessage.successfullyRegister(userName, userEmail);
			} else {
				message = new messageModel("Something went wrong! Try again!!", "error", "alert-danger");
			}
			session.setAttribute("message", message);
			response.sendRedirect("register.jsp");
			return;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
