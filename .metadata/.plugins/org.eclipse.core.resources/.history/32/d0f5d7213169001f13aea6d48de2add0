<%@page import="com.revature.ecom.Models.messageModel"%>
<%@page import="com.revature.ecom.DAO.userDAO"%>
<%@page errorPage="error_exception.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.revature.ecom.Models.orderedProductModel"%>
<%@page import="com.revature.ecom.Models.orderModel"%>
<%@page import="java.util.List"%>
<%@page import="com.revature.ecom.DAO.orderedProductDAO"%>
<%@page import="com.revature.ecom.DAO.orderDAO"%>
<%@page import="com.revature.ecom.Utils.DatabaseUtil"%>

<%
adminModel activeAdmin = (adminModel) session.getAttribute("activeAdmin");
if (activeAdmin == null) {
    messageModel message = new messageModel("You are not logged in! Login first!!", "error", "alert-danger");
    session.setAttribute("message", message);
    response.sendRedirect("adminlogin.jsp");
    return;
}
orderDAO orderDao = new orderDAO(DatabaseUtil.getConnection());
orderedProductDAO ordProdDao = new orderedProductDAO(DatabaseUtil.getConnection());
List<orderModel> orderList = orderDao.getAllOrder();
userDAO userDao = new userDAO(DatabaseUtil.getConnection());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Orders</title>
<%@include file="Components/common_css_js.jsp"%>
<style>
    .container-fluid {
        padding: 20px;
    }

    .table {
        background-color: #f8f9fa;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        margin-top: 20px;
    }

    .table th, .table td {
        padding: 15px;
        vertical-align: middle;
        text-align: center;
    }

    .table th {
        background-color: #007bff;
        color: white;
    }

    .table img {
        border-radius: 8px;
    }

    .form-select {
        max-width: 180px;
        margin: auto;
    }

    .disabled {
        pointer-events: none;
        opacity: 0.6;
    }

    .text-center {
        text-align: center;
    }

    .alert {
        margin-top: 20px;
    }
</style>
</head>
<body>
    <!-- Navbar -->
    <div class="mb-3">
        <%@include file="Components/navbar.jsp"%>
    </div>

    <!-- Order Details -->
    <div class="container-fluid px-3 py-3">
        <%
        if (orderList == null || orderList.isEmpty()) {
        %>
        <div class="container mt-5 mb-5 text-center">
            <img src="Images/empty-cart.png" style="max-width: 200px;" class="img-fluid">
            <h4 class="mt-3">Zero Orders found</h4>
        </div>
        <%
        } else {
        %>
        <div class="container-fluid">
            <table class="table table-hover">
                <thead>
                    <tr class="table-primary" style="font-size: 18px;">
                        <th class="text-center">Product</th>
                        <th>Order ID</th>
                        <th>Product Details</th>
                        <th>Delivery Address</th>
                        <th>Date & Time</th>
                        <th>Payment Type</th>
                        <th>Status</th>
                        <th colspan="2" class="text-center">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    for (orderModel order : orderList) {
                        List<orderedProductModel> ordProdList = ordProdDao.getAllOrderedProduct(order.getId());
                        for (orderedProductModel orderProduct : ordProdList) {
                    %>
                    <form action="updateorder?oid=<%=order.getId()%>" method="post">
                    <tr>
                        <td class="text-center">
                            <img src="Product_imgs/<%=orderProduct.getImage()%>" style="width: 50px; height: 50px; width: auto;">
                        </td>
                        <td><%=order.getOrderId()%></td>
                        <td>
                            <%=orderProduct.getName()%><br>
                            Quantity: <%=orderProduct.getQuantity()%><br>
                            Total Price: &#8377;<%=orderProduct.getPrice() * orderProduct.getQuantity()%>
                        </td>
                        <td>
                            <%=userDao.getUserName(order.getUserId())%><br>
                            Mobile No.: <%=userDao.getUserPhone(order.getUserId())%><br>
                            <%=userDao.getUserAddress(order.getUserId())%>
                        </td>
                        <td><%=order.getDate()%></td>
                        <td><%=order.getPayementType()%></td>
                        <td><%=order.getStatus()%></td>
                        <td>
                            <select id="operation" name="status" class="form-select">
                                <option>--Select Operation--</option>
                                <option value="Order Confirmed">Order Confirmed</option>
                                <option value="Shipped">Shipped</option>
                                <option value="Out For Delivery">Out For Delivery</option>
                                <option value="Delivered">Delivered</option>
                            </select>
                        </td>
                        <td>
                            <%
                            if (order.getStatus().equals("Delivered")) {
                            %>
                            <button type="submit" class="btn btn-success disabled">Update</button>
                            <%
                            } else {
                            %>
                            <button type="submit" class="btn btn-secondary">Update</button>
                            <%
                            }
                            %>
                        </td>
                    </tr>
                    </form>
                    <%
                        }
                    }
                    %>
                </tbody>
            </table>
        </div>
        <%
        }
        %>
    </div>
</body>
</html>