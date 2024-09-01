<%@page import="com.revature.ecom.Models.messageModel"%>
<%@page import="com.revature.ecom.DAO.userDAO"%>
<%@page import="com.revature.ecom.Models.productModel"%>
<%@page import="com.revature.ecom.DAO.productDAO"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page errorPage="error_exception.jsp"%>
<%
    adminModel activeAdmin = (adminModel) session.getAttribute("activeAdmin");
    if (activeAdmin == null) {
        messageModel message = new messageModel("You are not logged in! Login first!!", "error", "alert-danger");
        session.setAttribute("message", message);
        response.sendRedirect("adminlogin.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Admin Dashboard</title>
    <%@include file="Components/common_css_js.jsp"%>
    <style>
        /* Custom Styles */
        body {
            background-color: #f8f9fa;
        }

        #details img {
            border-radius: 50%;
            border: 3px solid #007bff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .card {
            border: none;
            border-radius: 15px;
            transition: all 0.3s ease-in-out;
        }

        .card:hover {
            transform: scale(1.05);
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
        }

        .card img {
            max-width: 60px;
            margin-bottom: 15px;
        }

        .card-title {
            font-weight: 600;
        }

        .modal-header {
            background-color: #007bff;
            color: #fff;
        }

        .modal-content {
            border-radius: 20px;
        }

        .modal-footer .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }

        .modal-footer .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }

        .welcome-section {
            background-image: linear-gradient(rgba(0, 0, 0, 0.6), rgba(0, 0, 0, 0.6)), url('Images/fashion-bg.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            padding: 3rem 1rem;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.3);
            margin-bottom: 30px; /* Added margin to create space between sections */
        }

        .welcome-section h1 {
            font-size: 3rem;
            font-weight: bold;
            margin-bottom: 1.5rem;
            color: #ffffff;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
        }

        .welcome-section p.lead {
            font-size: 1.5rem;
            margin-bottom: 1.5rem;
            color: #f8f9fa;
            text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.5);
        }

        .welcome-section p {
            font-size: 1.2rem;
            margin-bottom: 1.5rem;
            color: #f8f9fa;
            text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.5);
        }

        .welcome-section .btn-primary {
            background-color: #ff4081;
            border-color: #ff4081;
            padding: 0.75rem 1.5rem;
            font-size: 1.25rem;
            transition: background-color 0.3s ease;
        }

        .welcome-section .btn-primary:hover {
            background-color: #e73570;
            border-color: #e73570;
        }
    </style>
</head>
<body>
    <!-- Navbar -->
    <%@include file="Components/navbar.jsp"%>

    <!-- Admin Dashboard -->
    <div class="container py-5">
        <%@include file="Components/alert_message.jsp"%>
        
        <!-- Welcome Section -->
        <div class="container-fluid py-5 welcome-section">
            <div class="row justify-content-center">
                <div class="col-md-8 text-center text-black">
                    <h1 class="display-4">Welcome <%=activeAdmin.getName()%>!</h1>
                    <p class="lead">Manage your store with ease. At Revshop Seller Portal, you have all the tools you need to succeed.</p>
                    <p>Oversee your product listings, track your orders, and engage with customers all in one place. Our platform empowers you to grow your business by reaching new customers and optimizing your sales performance.</p>
                    <a href="display_products.jsp" class="btn btn-primary btn-lg mt-3">Manage Your Products</a>
                </div>
            </div>
        </div>

        <!-- Managing Boxes -->
        <div class="row text-center">
            <div class="col-lg-3 col-md-6 mb-4">
                <a href="display_category.jsp">
                    <div class="card text-center p-4 shadow-sm">
                        <h4 class="card-title mt-2">Manage Categories</h4>
                    </div>
                </a>
            </div>
            <div class="col-lg-3 col-md-6 mb-4">
                <a href="display_products.jsp">
                    <div class="card text-center p-4 shadow-sm">
                        <h4 class="card-title mt-2">Manage Products</h4>
                    </div>
                </a>
            </div>
            <div class="col-lg-3 col-md-6 mb-4">
                <a href="display_orders.jsp">
                    <div class="card text-center p-4 shadow-sm">
                        <h4 class="card-title mt-2">Manage Orders</h4>
                    </div>
                </a>
            </div>
            <div class="col-lg-3 col-md-6 mb-4">
                <a href="display_users.jsp">
                    <div class="card text-center p-4 shadow-sm">
                        <h4 class="card-title mt-2">Manage Users</h4>
                    </div>
                </a>
            </div>
        </div>
        
    </div>

    <!-- Add Category Modal -->
    <div class="modal fade" id="add-category" tabindex="-1" aria-labelledby="addCategoryModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header bg-primary text-white">
                <h5 class="modal-title" id="addCategoryModalLabel">Add New Category</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="add" method="post" enctype="multipart/form-data">
                <div class="modal-body">
                    <input type="hidden" name="operation" value="addCategory">

                    <!-- Category Name Section -->
                    <div class="mb-3">
                        <label for="category_name" class="form-label"><b>Category Name</b></label>
                        <input type="text" id="category_name" name="category_name" class="form-control" placeholder="Enter category name" required>
                    </div>

                    <!-- Category Image Section -->
                    <div class="mb-3">
                        <label for="category_img" class="form-label"><b>Category Image</b></label>
                        <input class="form-control" type="file" id="category_img" name="category_img" required>
                        <small class="text-muted">Please upload an image that represents the category.</small>
                    </div>

                    <!-- Category Description Section -->
                    <div class="mb-3">
                        <label for="category_description" class="form-label"><b>Description (Optional)</b></label>
                        <textarea id="category_description" name="category_description" class="form-control" rows="3" placeholder="Enter category description (optional)"></textarea>
                    </div>
                </div>

                <!-- Modal Footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Add Category</button>
                </div>
            </form>
        </div>
    </div>
</div>


    <!-- Add Product Modal -->
    <div class="modal fade" id="add-product" tabindex="-1" aria-labelledby="addProductModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-centered">
        <div class="modal-content rounded-3 shadow-sm">
            <div class="modal-header bg-primary text-white">
                <h5 class="modal-title" id="addProductModalLabel">Add New Product</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="add" method="post" name="addProductForm" enctype="multipart/form-data">
                <div class="modal-body">
                    <input type="hidden" name="operation" value="addProduct">

                    <!-- Product Name Section -->
                    <div class="mb-4">
                        <label for="product_name" class="form-label"><b>Product Name</b></label>
                        <input type="text" id="product_name" name="name" class="form-control" placeholder="Enter product name" required>
                    </div>

                    <!-- Product Description Section -->
                    <div class="mb-4">
                        <label for="product_description" class="form-label"><b>Product Description</b></label>
                        <textarea id="product_description" name="description" class="form-control" rows="4" placeholder="Enter product description" required></textarea>
                    </div>

                    <!-- Product Details Section -->
                    <div class="row mb-4">
                        <div class="col-md-6 mb-3">
                            <label for="product_price" class="form-label"><b>Unit Price</b></label>
                            <input type="number" id="product_price" name="price" class="form-control" placeholder="Enter unit price" required>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="product_discount" class="form-label"><b>Discount Percentage</b></label>
                            <input type="number" id="product_discount" name="discount" class="form-control" placeholder="Enter discount percentage" onblur="validateDiscount()">
                        </div>
                    </div>

                    <div class="row mb-4">
                        <div class="col-md-6 mb-3">
                            <label for="product_quantity" class="form-label"><b>Product Quantity</b></label>
                            <input type="number" id="product_quantity" name="quantity" class="form-control" placeholder="Enter quantity" required>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="categoryType" class="form-label"><b>Category Type</b></label>
                            <select id="categoryType" name="categoryType" class="form-select" required>
                                <option value="0">--Select Category--</option>
                                <% for (categoryModel c : categoryList) { %>
                                    <option value="<%=c.getCategoryId()%>"><%=c.getCategoryName()%></option>
                                <% } %>
                            </select>
                        </div>
                    </div>

                    <!-- Product Image Section -->
                    <div class="mb-4">
                        <label for="product_image" class="form-label"><b>Product Image</b></label>
                        <input type="file" id="product_image" name="photo" class="form-control" accept="image/*" required>
                        <small class="text-muted">Upload an image that represents the product. Accepts jpg, png, and gif formats.</small>
                    </div>
                </div>
                <!-- Modal Footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">Add Product</button>
                </div>
            </form>
        </div>
    </div>
</div>

    <script>
        function validate() {
            var dis = document.addProductForm.discount.value;
            if (dis > 100 || dis < 0) {
                alert("Discount should be between 0-100!");
                return false;
            }
        }
    </script>
</body>
</html>
