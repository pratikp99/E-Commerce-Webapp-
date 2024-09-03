<%@page import="com.revature.ecom.DAO.productDAO"%>
<%@page import="com.revature.ecom.Models.productModel"%>
<%@page import="com.revature.ecom.Utils.DatabaseUtil"%>
<%@page errorPage="error_exception.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
productDAO productDao = new productDAO(DatabaseUtil.getConnection());
List<productModel> productList = productDao.getAllLatestProducts();
List<productModel> topDeals = productDao.getDiscountedProducts();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<%@include file="Components/common_css_js.jsp"%>
<style type="text/css">
.social-link {
        color: white;
        text-decoration: none;
        font-size: 16px;
        margin-bottom: 10px;
        display: inline-block;
    }

    .social-link:hover {
        color: #17a2b8;
        text-decoration: underline;
        transition: color 0.3s ease;
    }

    .social-link::before {
        content: '\f0c1'; /* FontAwesome chain icon */
        font-family: FontAwesome;
        padding-right: 8px;
    }
    .box-container, .card {
        border: 2px solid #ddd; /* Light gray border */
        border-radius: 10px; /* Rounded corners */
        background-color: white; /* Light background color */
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Subtle shadow for depth */
        max-width: 320px; /* Set a maximum width for the box */
        margin: 0 auto; /* Center align the box within the column */
        transition: transform 0.3s ease, box-shadow 0.3s ease; /* Smooth transition for hover effect */
    }
    
    .product-link {
    text-decoration: none; /* Remove underline from links */
    color: inherit; /* Inherit color from parent element */
}

.new-arrival-heading {
    font-size: 24px; /* Adjust the font size */
    font-weight: bold; /* Make the font bold */
    color: #333; /* Set the text color */
    display: flex; /* Use flexbox for alignment */
    align-items: center; /* Center items vertically */
    justify-content: center; /* Center items horizontally */
    margin: 20px 0; /* Add vertical margin */
}

.new-arrival-heading .arrow {
    margin-left: 10px; /* Space between text and arrow */
    font-size: 30px; /* Adjust the size of the arrow */
    color: #027a3e; /* Set the color of the arrow */
}

    .box-container:hover {
        transform: translateY(-5px); /* Slight lift on hover */
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2); /* Enhance shadow on hover */
    }

    .box-img {
        max-width: 100%; /* Ensure image fits within the box */
        max-height: 300px; /* Limit the height of the image */
        width: auto; /* Maintain aspect ratio */
        border-radius: 10px 10px 0 0; /* Rounded top corners for the image */
    }
    
    .card:hover {
        transform: translateY(-5px); /* Slight lift on hover */
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2); /* Enhance shadow on hover */
    }
.cus-card {
	border-radius: 50%;
	border-color: transparent;
	max-height: 200px;
	max-width: 200px;
	max-height: 200px;
}

.real-price {
	font-size: 20px !important;
	font-weight: 600;
}

.product-price {
	font-size: 17px !important;
	text-decoration: line-through;
}

.product-discount {
	font-size: 15px !important;
	color: #027a3e;
}
.welcome-section {
    background-image: linear-gradient(rgba(0, 0, 0, 0.6), rgba(0, 0, 0, 0.6)), url('Images/fashion-bg.jpg');
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    padding: 3rem 1rem;
    border-radius: 10px;
    box-shadow: 0 4px 15px rgba(0, 0, 0, 0.3);
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
	<!--navbar -->
	<%@include file="Components/navbar.jsp"%>
	<link rel="stylesheet" type="text/css" href="CSS/styles.css">

	<!-- Carousel -->
	<div class="container-fluid py-5 welcome-section">
    <div class="row justify-content-center">
        <div class="col-md-8 text-center text-white">
            <h1 class="display-4">Welcome to Revshop Fashion</h1>
            <p class="lead">Discover the latest trends in fashion. At Revshop Fashion, we bring you the hottest styles from top brands, all in one place.</p>
            <p>Explore our curated collections, from casual wear to formal attire, and find the perfect outfit for any occasion. With exclusive deals and a wide range of sizes, Revshop Fashion is your go-to destination for all things fashion.</p>
            <a href="products.jsp" class="btn btn-primary btn-lg mt-3">Explore Our Collection</a>
        </div>
    </div>
</div>
	<!-- end of carousel -->
	<br>

	<!-- latest product listed -->
<div class="container-fluid py-3 px-3" style="background: #f2f2f2;">
    <div class="row row-cols-1 row-cols-md-4 g-3">
        <div class="col">
            <div class="box-container text-center p-4">
                <img src="Images/new Arrival.jpg" class="box-img" alt="New Arrival">
                <div class="container-fluid py-3 px-3" style="background: #f2f2f2;">
    				<h3 class="new-arrival-heading">New Arrival <span class="arrow">&#8594;</span></h3>
				</div>
            </div>
        </div>
        <% for (int i = 0; i < Math.min(3, productList.size()); i++) { %>
        <div class="col">
            <a href="viewProduct.jsp?pid=<%=productList.get(i).getProductId()%>" class="product-link">
                <div class="card stylish-card">
                    <div class="container text-center">
                        <img src="Product_imgs/<%=productList.get(i).getProductImages()%>" class="card-img-top" alt="<%=productList.get(i).getProductName()%>">
                    </div>
                    <div class="card-body">
                        <h5 class="card-title text-center"><%=productList.get(i).getProductName()%></h5>
                        <div class="container text-center">
                            <span class="real-price">&#8377;<%=productList.get(i).getProductPriceAfterDiscount()%></span>
                            &ensp;<span class="product-price">&#8377;<%=productList.get(i).getProductPrice()%></span>
                            &ensp;<span class="product-discount"><%=productList.get(i).getProductDiscount()%>&#37; off</span>
                            <p class="product-description"><%=productList.get(i).getProductDescription()%></p>
                        </div>
                    </div>
                </div>
            </a>
        </div>
        <% } %>
    </div>
</div>
<!-- end of list -->

	<!-- end of list -->
<br>
	<!-- product with heavy deals -->
	<div class="container-fluid py-3 px-3" style="background: #f2f2f2;">
		<div class="row row-cols-1 row-cols-md-4 g-3">
			<div class="col">
            <div class="box-container text-center p-4">
                <img src="Images/trending.png" class="box-img" alt="Trending">
                <div class="container-fluid py-3 px-3" style="background: #f2f2f2;">
    				<h3 class="new-arrival-heading">Trending Wears <span class="arrow">&#8594;</span></h3>
    
				</div>
            </div>
        </div>
			<%
			for (int i = 0; i < Math.min(3, topDeals.size()); i++) {
			%>
			<div class="col">
				<a href="viewProduct.jsp?pid=<%=topDeals.get(i).getProductId()%>" style="text-decoration: none;" class="product-link">
					<div class="card stylish-card">
						<div class="container text-center">
							<img src="Product_imgs\<%=topDeals.get(i).getProductImages()%>"
								class="card-img-top "
								style="max-height: 300px;">
						</div>
						<div class="card-body">
							<h5 class="card-title text-center"><%=topDeals.get(i).getProductName()%></h5>

							<div class="container text-center">
								<span class="real-price">&#8377;<%=topDeals.get(i).getProductPriceAfterDiscount()%></span>
								&ensp;<span class="product-price">&#8377;<%=topDeals.get(i).getProductPrice()%>
								</span>&ensp;<span class="product-discount"><%=topDeals.get(i).getProductDiscount()%>&#37;
									off</span>&ensp;<p class="product-description"><%=topDeals.get(i).getProductDescription()%></p>
							</div>
						</div>
					</div>
				</a>
			</div>
			<%
			}
			%>
		</div>
	</div>
	
	<div class="container-fluid py-4" style="background-color: #343a40; color: white;">
    <div class="row text-center text-md-left">
        <div class="col-md-4 text-md-left">
            <h5>Contact Us</h5>
            <p>Email: support@revshop-ecommerce.com</p>
            <p>Phone: +91 12345 67890</p>
            <p>Address: 123 Revshop Street, Ecom City, India</p>
        </div>
        <div class="col-md-4 text-center">
            <h5>About Revshop-Ecommerce</h5>
            <p>Revshop-Ecommerce is your one-stop online shopping platform offering a wide range of products across multiple categories. Our goal is to provide you with a seamless shopping experience.</p>
        </div>
        <div class="col-md-4 text-md-right">
            <h5>Follow Us</h5>
            <a href="#" class="social-link">Facebook</a><br>
            <a href="#" class="social-link">Twitter</a><br>
            <a href="#" class="social-link">Instagram</a><br>
            <a href="#" class="social-link">LinkedIn</a>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col text-center">
            <p>&copy; 2024 Revshop-Ecommerce. All rights reserved.</p>
        </div>
    </div>
</div>
<!-- End of Footer -->

	<!-- confirmation message for successful order -->
	<%
	String order = (String) session.getAttribute("order");
	if (order != null) {
	%>
	<script type="text/javascript">
		Swal.fire({
		  icon : 'success',
		  title: 'Order Placed, Thank you!! Visit Us Again!!!',
		  text: 'Confirmation will be sent to <%=user.getUserEmail()%>',
		  width: 600,
		  padding: '3em',
		  showConfirmButton : false,
		  timer : 3500,
		  backdrop: `
		    rgba(0,0,123,0.4)
		  `
		});
	</script>
	<%
	}
	session.removeAttribute("order");
	%>
	<!-- end of message -->
	
</body>
</html>