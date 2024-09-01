<%@page import="com.revature.ecom.DAO.categoryDAO"%>
<%@page import="com.revature.ecom.Models.adminModel"%>
<%@page import="com.revature.ecom.Models.cartModel"%>
<%@page import="com.revature.ecom.DAO.cartDAO"%>
<%@page import="com.revature.ecom.Models.userModel"%>
<%@page import="java.util.List"%>
<%@page import="com.revature.ecom.Models.categoryModel"%>
<%@page import="com.revature.ecom.Utils.DatabaseUtil"%>
<%@page import="com.revature.ecom.DAO.categoryDAO"%>
<%
userModel user = (userModel) session.getAttribute("activeUser");
adminModel admin = (adminModel) session.getAttribute("activeAdmin");

categoryDAO catDao = new categoryDAO(DatabaseUtil.getConnection());
List<categoryModel> categoryList = catDao.getAllCategories();
%>

<style>
/* General navbar styling */
.navbar {
    background-color: #34495e;
    padding: 1rem;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.3);
    max-height:15vh;
}

.navbar-brand {
    font-size: 1.6rem;
    font-weight: bold;
    color: #ecf0f1 !important;
}

.nav-link {
    color: #bdc3c7 !important;
    margin-right: 1rem;
    transition: color 0.3s, background-color 0.3s;
}

.nav-link:hover {
    color: #ecf0f1 !important;
    background-color: rgba(255, 255, 255, 0.1);
}

.navbar-toggler {
    border-color: #ecf0f1;
}

.navbar-toggler-icon {
    background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 30 30'%3E%3Cpath stroke='rgba%2899, 110, 114, 1%29' stroke-width='2' linecap='round' linejoin='round' d='M4 7h22M4 15h22M4 23h22'/%3E%3C/svg%3E");
}

.dropdown-menu {
    background-color: #2c3e50 !important;
    border: none;
}

.dropdown-item {
    color: #bdc3c7 !important;
    transition: background-color 0.3s, color 0.3s;
}

.dropdown-item:hover {
    background-color: #34495e !important;
    color: #ecf0f1 !important;
}

.badge {
    font-size: 0.75rem;
    background-color: #e74c3c;
}

/* Button styling */
.btn-outline-light {
    color: #bdc3c7;
    border-color: #bdc3c7;
    transition: color 0.3s, border-color 0.3s;
}

.btn-outline-light:hover {
    color: #ecf0f1;
    border-color: #ecf0f1;
}

/* Flexbox alignment */
.navbar-nav {
    display: flex;
    align-items: center;
}

.navbar-nav .nav-item {
    margin-right: 0rem;
}

.form-control {
    background-color: #2c3e50 !important;
    border: none;
    color: #ecf0f1;
    margin-right: 0.5rem;
}

.form-control::placeholder {
    color: #bdc3c7;
}

.form-control:focus {
    box-shadow: none;
    border-color: #ecf0f1;
}

@media (max-width: 992px) {
    .navbar-collapse {
        flex-direction: column;
    }
    
    .navbar-nav {
        flex-direction: column;
        width: 100%;
    }

    .navbar-nav .nav-item {
        margin-right: 0;
        margin-bottom: 1rem;
    }

    .form-control {
        margin-bottom: 1rem;
        width: 100%;
    }
}

/* Specific logo styles */
.navbar-nav .register-link {
    background-image: url('path/to/register-icon.png');
    background-repeat: no-repeat;
    background-position: left center;
    padding-left: 30px; /* Adjust based on the size of the icon */
}

.navbar-nav .buyer-link {
    background-image: url('path/to/buyer-icon.png');
    background-repeat: no-repeat;
    background-position: left center;
    padding-left: 30px; /* Adjust based on the size of the icon */
}

.navbar-nav .seller-link {
    background-image: url('path/to/seller-icon.png');
    background-repeat: no-repeat;
    background-position: left center;
    padding-left: 30px; /* Adjust based on the size of the icon */
}
</style>

<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container">
        <a class="navbar-brand" href="index.jsp" style="font-weight: bold; font-size: 1.5rem; margin-right:7vh; background: linear-gradient(45deg, #000000, #ff4081, #007bff); -webkit-background-clip: text; -webkit-text-fill-color: transparent;">
    <i class="fa-sharp fa-solid fa-house"></i>&ensp;RevShop
</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <% if (admin != null) { %>
            <!-- Admin nav bar -->
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
    <li class="nav-item">
        <button type="button" class="btn btn-dark nav-link d-flex align-items-center rounded-pill px-3 py-2 shadow-sm" data-bs-toggle="modal" data-bs-target="#add-category">
            <i class="fa-solid fa-plus fa-xs me-2"></i>Add Category
        </button>
    </li>
    <li class="nav-item">
        <button type="button" class="btn btn-secondary nav-link d-flex align-items-center rounded-pill px-3 py-2 shadow-sm" data-bs-toggle="modal" data-bs-target="#add-product">
            <i class="fa-solid fa-plus fa-xs me-2"></i>Add Product
        </button>
    </li>
</ul>
<ul class="navbar-nav ms-auto">
    <li class="nav-item">
        <a class="nav-link text-info fw-light d-flex align-items-center" href="admin.jsp">
            <i class="fa-solid fa-user-circle fa-lg me-2"></i><%=admin.getName()%>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link text-danger fw-light d-flex align-items-center" href="logout?user=admin">
            <i class="fa-solid fa-sign-out-alt fa-lg me-2"></i>Logout
        </a>
    </li>
</ul>


            <% } else { %>
            <!-- General nav bar -->
            <!-- Navigation items for products and category -->
<ul class="navbar-nav me-auto mb-2 mb-lg-0">
    <li class="nav-item">
        <a class="nav-link text-dark rounded-pill px-3 py-2 shadow-sm d-flex align-items-center" href="products.jsp" role="button" aria-expanded="false">
            Products
        </a>
    </li>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle text-dark rounded-pill px-3 py-2 shadow-sm d-flex align-items-center" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Category
        </a>
        <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="products.jsp?category=0">All Products</a></li>
            <% for (categoryModel c : categoryList) { %>
            <li><a class="dropdown-item" href="products.jsp?category=<%=c.getCategoryId()%>"><%=c.getCategoryName()%></a></li>
            <% } %>
        </ul>
    </li>
</ul>

<!-- Search form -->
<form class="d-flex pe-5" role="search" action="products.jsp" method="get">
    <input name="search" class="form-control me-2 rounded-pill border-0 shadow-sm" size="50" type="search" placeholder="Search for products" aria-label="Search">
    <button class="btn btn-outline-dark rounded-pill px-4" type="submit">Search</button>
</form>

<!-- User actions for logged-in users -->
<% if (user != null) {
    cartDAO cartDao = new cartDAO(DatabaseUtil.getConnection());
    int cartCount = cartDao.getCartCountByUserId(user.getUserId());
%>
<ul class="navbar-nav ms-auto">
    <li class="nav-item pe-3">
        <a class="nav-link position-relative d-flex align-items-center rounded-pill px-3 py-2 shadow-sm" href="cart.jsp">
            <i class="fa-solid fa-cart-shopping me-2"></i> Cart
            <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger"><%=cartCount%></span>
        </a>
    </li>
    <li class="nav-item pe-3">
        <a class="nav-link text-dark rounded-pill px-3 py-2 shadow-sm d-flex align-items-center" href="profile.jsp">
            <i class="fa-solid fa-user me-2"></i><%=user.getUserName()%>
        </a>
    </li>
    <li class="nav-item pe-3">
        <a class="nav-link text-danger rounded-pill px-3 py-2 shadow-sm d-flex align-items-center" href="logout?user=user">
            <i class="fa-solid fa-sign-out-alt me-2"></i> Logout
        </a>
    </li>
</ul>
<% } else { %>
<!-- User actions for guests -->
<ul class="navbar-nav ms-auto">
    <li class="nav-item pe-2">
        <a class="nav-link btn btn-outline-primary rounded-pill px-3 py-2" href="login.jsp">Login</a>
    </li>
    <li class="nav-item pe-2">
        <a class="nav-link btn btn-outline-success rounded-pill px-3 py-2" href="adminlogin.jsp">Seller</a>
    </li>
    <li class="nav-item pe-3">
        <a class="nav-link position-relative d-flex align-items-center rounded-pill px-3 py-2 shadow-sm" href="cart.jsp">
            <i class="fa-solid fa-cart-shopping me-2"></i> Cart
            <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger"></span>
        </a>
    </li>
</ul>
<% } %>

          
            <% } %>
        </div>
    </div>
</nav>
