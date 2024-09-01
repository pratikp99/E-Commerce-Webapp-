<%@page import="com.revature.ecom.Models.messageModel"%>
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
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Product</title>
<%@include file="Components/common_css_js.jsp"%>
<style>
    .card {
        margin-top: 30px;
        background-color: #f8f9fa;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    .card-header {
        background-color: #007bff;
        color: white;
        padding: 15px;
        border-radius: 8px 8px 0 0;
    }

    .card-body {
        padding: 20px;
    }

    .card-footer {
        background-color: #f1f1f1;
        padding: 15px;
        border-radius: 0 0 8px 8px;
    }

    .form-label {
        font-weight: bold;
    }

    .form-control {
        padding: 10px;
        font-size: 16px;
        border-radius: 8px;
    }

    .btn-primary {
        background-color: #007bff;
        border: none;
        padding: 10px 20px;
        font-size: 18px;
        border-radius: 8px;
        transition: background-color 0.3s ease;
    }

    .btn-primary:hover {
        background-color: #0056b3;
    }

    .container {
        max-width: 800px;
        margin: -22px auto;
        padding: 20px;
    }

    .img-preview {
        width: 80px;
        height: 80px;
        object-fit: cover;
        border-radius: 8px;
        margin-left: 10px;
    }

    .me-3 {
        margin-right: 1rem;
    }
</style>
</head>
<body>
    <!-- Navbar -->
    <div class="mb-3">
        <%@include file="Components/navbar.jsp"%>
    </div>

    <!-- Update Product Form -->
    <%
    int pid = Integer.parseInt(request.getParameter("pid"));
    productDAO productDao = new productDAO(DatabaseUtil.getConnection());
    productModel product = productDao.getProductsByProductId(pid);
    %>
    <div class="container mt-3">
        <div class="row">
            <div class="col">
                <div class="card">
                    <div class="card-header text-center">
                        <h3>Edit Product</h3>
                    </div>
                    <form action="add?pid=<%=pid%>" method="post" name="updateProductForm" enctype="multipart/form-data">
                        <div class="card-body">
                            <input type="hidden" name="operation" value="updateProduct">
                            <div class="row">
                                <div class="col-md-6 mb-2">
                                    <label class="form-label">Product Name</label>
                                    <input type="text" name="name" value="<%=product.getProductName()%>" class="form-control">
                                </div>
                                <div class="col-md-6 mb-2">
                                    <label class="form-label">Unit Price</label>
                                    <input type="number" name="price" value="<%=product.getProductPrice()%>" class="form-control" required>
                                </div>
                            </div>
                            <div class="mb-2">
                                <label class="form-label">Product Description</label>
                                <textarea name="description" class="form-control" rows="3"><%=product.getProductDescription()%></textarea>
                            </div>
                            <div class="row">
                                <div class="col-md-6 mb-2">
                                    <label class="form-label">Product Quantity</label>
                                    <input type="number" name="quantity" value="<%=product.getProductQunatity()%>" class="form-control">
                                </div>
                                <div class="col-md-6 mb-2">
                                    <label class="form-label">Discount Percentage</label>
                                    <input type="number" name="discount" onblur="validate()" value="<%=product.getProductDiscount()%>" class="form-control">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 mb-2">
                                    <label class="form-label">Product Image</label>
                                    <input type="file" name="product_img" class="form-control">
                                </div>
                                <div class="col-md-6 mb-2">
                                    <label class="form-label">Select Category Type</label>
                                    <select name="categoryType" class="form-control">
                                        <option value="0">--Select Category--</option>
                                        <% for (categoryModel c : categoryList) { %>
                                        <option value="<%=c.getCategoryId()%>"><%=c.getCategoryName()%></option>
                                        <% } %>
                                    </select>
                                    <input type="hidden" name="category" value="<%=product.getCategoryId()%>">
                                </div>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Uploaded Image:</label>
                                <%=product.getProductImages()%>
                                <img src="Product_imgs/<%=product.getProductImages()%>" alt="<%=product.getProductName()%>" class="img-preview">
                                <input type="hidden" name="image" value="<%=product.getProductImages()%>">
                            </div>
                        </div>
                        <div class="card-footer text-center">
                            <button type="submit" class="btn btn-lg btn-primary me-3">Update</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- End -->

    <script type="text/javascript">
        function validate() {
            var dis = document.updateProductForm.discount.value;
            if (dis > 100 || dis < 0) {
                alert("Discount needs to be between 0-100!");
                return false;
            }
        }
    </script>
</body>
</html>
