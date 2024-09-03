package com.revature.ecom.Servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.ecom.Models.messageModel;
import com.revature.ecom.Models.orderModel;
import com.revature.ecom.Models.orderedProductModel;
import com.revature.ecom.Models.userModel;
import com.revature.ecom.service.OrderService;
import com.revature.ecom.service.OrderedProductService;
import com.revature.ecom.serviceImpl.OrderServiceImpl;
import com.revature.ecom.serviceImpl.OrderedProductServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OrderService orderService;
    private OrderedProductService orderedProductService;

    public OrderServlet() throws ClassNotFoundException {
        super();
        orderService = new OrderServiceImpl();
        orderedProductService = new OrderedProductServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.print("In am in");
        HttpSession session = request.getSession();
        userModel activeUser = (userModel) session.getAttribute("activeUser");

        if (activeUser == null) {
            messageModel message = new messageModel("You are not logged in! Login first!!", "error", "alert-danger");
            session.setAttribute("message", message);
            response.sendRedirect("login.jsp");
            return;
        }

        List<orderModel> orderList = orderService.getAllOrdersByUserId(activeUser.getUserId());

        Map<Integer, List<orderedProductModel>> orderedProductsMap = new HashMap<>();
        for (orderModel order : orderList) {
            List<orderedProductModel> orderedProducts = orderedProductService.getAllOrderedProducts(order.getId());
            orderedProductsMap.put(order.getId(), orderedProducts);
        }
        System.out.print("In HERE");
        request.setAttribute("orderList", orderList);
        request.setAttribute("orderedProductsMap", orderedProductsMap);

        request.getRequestDispatcher("myOrders.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
