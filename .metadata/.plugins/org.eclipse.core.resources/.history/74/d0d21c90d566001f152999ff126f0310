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

/**
 * Servlet implementation class updateUserServlet
 */
public class updateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateUserServlet() {
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
		String op = request.getParameter("operation");
		HttpSession session = request.getSession();
		userModel oldUser = (userModel) session.getAttribute("activeUser");
		userDAO userDao = null;
		try {
			userDao = new userDAO(DatabaseUtil.getConnection());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (op.trim().equals("changeAddress")) {
			try {
				String userAddress = request.getParameter("user_address");
				String userCity = request.getParameter("city");
				String userPincode = request.getParameter("pincode");
				String userState = request.getParameter("state");

				userModel user = new userModel();
				user.setUserId(oldUser.getUserId());
				user.setUserName(oldUser.getUserName());
				user.setUserEmail(oldUser.getUserEmail());
				user.setUserPassword(oldUser.getUserPassword());
				user.setUserPhone(oldUser.getUserPhone());
				user.setUserGender(oldUser.getUserGender());
				user.setDateTime(oldUser.getDateTime());
				user.setUserAddress(userAddress);
				user.setUserCity(userCity);
				user.setUserPincode(userPincode);
				user.setUserState(userState);

				userDao.updateUserAddresss(user);
				session.setAttribute("activeUser", user);
				response.sendRedirect("checkout.jsp");

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (op.trim().equals("updateUser")) {
			try {
				String userName = request.getParameter("name");
				String userEmail = request.getParameter("email");
				String userPhone = request.getParameter("mobile_no");
				String userGender = request.getParameter("gender");
				String userAddress = request.getParameter("address");
				String userCity = request.getParameter("city");
				String userPincode = request.getParameter("pincode");
				String userState = request.getParameter("state");

				userModel user = new userModel(userName, userEmail, userPhone, userGender, userAddress, userCity, userPincode,
						userState);
				user.setUserId(oldUser.getUserId());
				user.setUserPassword(oldUser.getUserPassword());
				user.setDateTime(oldUser.getDateTime());

				userDao.updateUser(user);
				session.setAttribute("activeUser", user);
				messageModel message = new messageModel("User information updated successfully!!", "success", "alert-success");
				session.setAttribute("message", message);
				response.sendRedirect("profile.jsp");

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (op.trim().equals("deleteUser")) {
			int uid = Integer.parseInt(request.getParameter("uid"));
			userDao.deleteUser(uid);
			response.sendRedirect("display_users.jsp");
		}

	}

}
