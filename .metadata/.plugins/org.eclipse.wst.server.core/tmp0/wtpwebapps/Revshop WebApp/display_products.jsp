<%@page import="com.revature.ecom.Models.messageModel"%>
<%@page import="com.revature.ecom.DAO.userDAO"%>
<%@page import="com.revature.ecom.Models.productModel"%>
<%@page import="com.revature.ecom.DAO.productDAO"%>
<%@page errorPage="error_exception.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
adminModel activeAdmin = (adminModel) session.getAttribute("activeAdmin");
if (activeAdmin == null) {
    messageModel message = new messageModel("You are not logged in! Login first!!", "error", "alert-danger");
    session.setAttribute("message", message);
    response.sendRedirect("adminlogin.jsp");
    return;
}

userDAO userDao = new userDAO(DatabaseUtil.getConnection());
productDAO productDao = new productDAO(DatabaseUtil.getConnection());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Products</title>
<%@include file="Components/common_css_js.jsp"%>
<style>
    .product-table {
        margin-top: 30px;
        background-color: #f8f9fa;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    .product-table th, .product-table td {
        padding: 15px;
        text-align: center;
        vertical-align: middle;
    }

    .product-table th {
        background-color: #007bff;
        color: white;
    }

    .product-table img {
        width: 60px;
        height: 60px;
        object-fit: cover;
        border-radius: 8px;
    }

    .btn-action {
        margin-right: 10px;
    }

    .btn-action:last-child {
        margin-right: 0;
    }

    .container {
        max-width: 800px;
        margin: -22px auto;
        padding: 20px;
    }

    .alert-message {
        margin-top: 20px;
    }
</style>
</head>
<body>
    <!-- Navbar -->
    <div class="mb-3">
        <%@include file="Components/navbar.jsp"%>
    </div>

    <!-- Alert Message -->
    <div class="container alert-message">
        <%@include file="Components/alert_message.jsp"%>
    </div>

    <!-- Product Table -->
    <div class="container">
        <div class="product-table">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Image</th>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Discount</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    List<productModel> productList = productDao.getAllProducts();
                    for (productModel prod : productList) {
                        String category = catDao.getCategoryName(prod.getCategoryId());
                    %>
                    <tr>
                        <td><img src="Product_imgs/<%=prod.getProductImages()%>" alt="<%=prod.getProductName()%>"></td>
                        <td><%=prod.getProductName()%></td>
                        <td><%=category%></td>
                        <td>&#8377;<%=prod.getProductPriceAfterDiscount()%></td>
                        <td><%=prod.getProductQunatity()%></td>
                        <td><%=prod.getProductDiscount()%>%</td>
                        <td>
                            <a href="update_product.jsp?pid=<%=prod.getProductId()%>" role="button" class="btn btn-secondary btn-action">Update</a>
                            <a href="add?pid=<%=prod.getProductId()%>&operation=deleteProduct" class="btn btn-danger btn-action" role="button">Delete</a>
                        </td>
                    </tr>
                    <%
                    }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
