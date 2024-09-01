<%@page import="com.revature.ecom.Models.messageModel"%>
<%@page import="com.revature.ecom.Models.userModel"%>
<%@page errorPage="error_exception.jsp"%>
<%
userModel activeUser = (userModel) session.getAttribute("activeUser");
if (activeUser == null) {
    messageModel message = new messageModel("You are not logged in! Login first!!", "error", "alert-danger");
    session.setAttribute("message", message);
    response.sendRedirect("login.jsp");
    return;  
}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Profile</title>
<%@include file="Components/common_css_js.jsp"%>
<style>
    body {
        font-family: Arial, sans-serif;
    }

    .cus-active {
        background-color: #007bff !important;
        color: white !important;
        font-weight: bold;
    }

    .list-btn {
        font-size: 18px;
        padding: 12px;
        border: 1px solid #ddd;
        border-radius: 8px;
        background-color: #f1f1f1;
        cursor: pointer;
        text-align: left;
        margin-bottom: 5px;
        transition: background-color 0.3s, color 0.3s;
    }

    .list-btn:hover {
        background-color: #e2e6ea;
        color: #0056b3;
    }

    .list-btn:active {
        background-color: #d1d1d1;
        color: #003d7a;
    }

    .profile-header {
        display: flex;
        align-items: center;
        border-bottom: 2px solid #ddd;
        padding: 20px;
        background-color: #f8f9fa;
    }

    .profile-header img {
        border-radius: 50%;
        max-width: 80px;
        margin-right: 15px;
    }

    .profile-header h5 {
        margin: 0;
        font-size: 24px;
        color: #333;
    }

    .card-header {
        background-color: #007bff;
        color: white;
        padding: 15px;
        border-radius: 0.25rem 0.25rem 0 0;
        font-size: 18px;
    }

    .card-body {
        padding: 20px;
    }

    .modal-header {
        background-color: #007bff;
        color: white;
    }

    .modal-body {
        padding: 20px;
    }

    .modal-header .btn-close {
        background-color: #007bff;
        color: white;
    }

    .modal-footer .btn-primary {
        background-color: #007bff;
        border: none;
    }

    .sidebar-card {
        border: 1px solid #ddd;
        border-radius: 0.5rem;
        margin-bottom: 15px;
        background-color: #ffffff;
    }

    .sidebar-card .card-body {
        padding: 20px;
    }

    .modal-content {
        border-radius: 0.5rem;
    }
</style>
</head>
<body>
    <!-- Navbar -->
    <%@include file="Components/navbar.jsp"%>

    <div class="container-fluid px-3 py-5">
        <div class="row">
            <!-- Sidebar -->
            <div class="col-md-3">
                <div class="card sidebar-card">
                    <div class="card-body profile-header">
                        <div class="row mt-2 mb-2">
                            <div class="col-md-4 text-center">
                                <img src="Images/profile.png" class="img-fluid">
                            </div>
                            <div class="col-md-8">
                                <p>Hello,</p>
                                <h5><%=activeUser.getUserName()%></h5>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="card sidebar-card mt-3">
                    <div class="list-group">
                        <button type="button" id="profile-btn" class="list-btn cus-active" aria-current="true">
                            Profile Information
                        </button>
                        <button type="button" id="wishlist-btn" class="list-btn">
                            My Wishlist
                        </button>
                        <button type="button" id="order-btn" class="list-btn">
                            My Orders
                        </button>
                        <button type="button" id="logout-btn" class="list-btn" onclick="window.open('logout?user=user', '_self')">
                            Logout
                        </button>
                    </div>
                </div>
            </div>
            <!-- End of Sidebar -->

            <!-- Main Content -->
            <div class="col-md-9">
                <div class="card">
                    <div id="profile">
                        <%@include file="Components/alert_message.jsp"%>
                        <%@include file="personalInfo.jsp"%>
                    </div>
                    <div id="wishlist" style="display: none;">
                        <%@include file="wishlist.jsp"%>
                    </div>
                    <div id="order" style="display: none;">
                        <%@include file="order.jsp"%>
                    </div>
                </div>
            </div>
            <!-- End of Main Content -->
        </div>
    </div>

    <!-- Modals -->
    <!-- Change Address Modal -->
    <div class="modal fade" id="changeAddressModal" tabindex="-1" aria-labelledby="changeAddressModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="changeAddressModalLabel">Change Address</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form action="updateuser" method="post">
                    <input type="hidden" name="operation" value="changeAddress">
                    <div class="modal-body">
                        <div class="mb-3">
                            <label for="address" class="form-label">Address</label>
                            <textarea id="address" name="user_address" rows="3" placeholder="Enter Address (Area and Street)" class="form-control" required></textarea>
                        </div>
                        <div class="mb-3">
                            <label for="city" class="form-label">City</label>
                            <input id="city" class="form-control" type="text" name="city" placeholder="City/District/Town" required>
                        </div>
                        <div class="mb-3">
                            <label for="pincode" class="form-label">Pincode</label>
                            <input id="pincode" class="form-control" type="number" name="pincode" placeholder="Pincode" maxlength="6" required>
                        </div>
                        <div class="mb-3">
                            <label for="state" class="form-label">State</label>
                            <select id="state" name="state" class="form-select">
                                <option selected>--Select State--</option>
                                <option value="Andaman &amp; Nicobar Islands">Andaman &amp; Nicobar Islands</option>
                                <option value="Andhra Pradesh">Andhra Pradesh</option>
                                <option value="Arunachal Pradesh">Arunachal Pradesh</option>
                                <option value="Assam">Assam</option>
                                <option value="Bihar">Bihar</option>
                                <option value="Chandigarh">Chandigarh</option>
                                <option value="Chhattisgarh">Chhattisgarh</option>
                                <option value="Dadra &amp; Nagar Haveli &amp; Daman &amp; Diu">Dadra &amp; Nagar Haveli &amp; Daman &amp; Diu</option>
                                <option value="Delhi">Delhi</option>
                                <option value="Goa">Goa</option>
                                <option value="Gujarat">Gujarat</option>
                                <option value="Haryana">Haryana</option>
                                <option value="Himachal Pradesh">Himachal Pradesh</option>
                                <option value="Jammu &amp; Kashmir">Jammu &amp; Kashmir</option>
                                <option value="Jharkhand">Jharkhand</option>
                                <option value="Karnataka">Karnataka</option>
                                <option value="Kerala">Kerala</option>
                                <option value="Ladakh">Ladakh</option>
                                <option value="Lakshadweep">Lakshadweep</option>
                                <option value="Madhya Pradesh">Madhya Pradesh</option>
                                <option value="Maharashtra">Maharashtra</option>
                                <option value="Manipur">Manipur</option>
                                <option value="Meghalaya">Meghalaya</option>
                                <option value="Mizoram">Mizoram</option>
                                <option value="Nagaland">Nagaland</option>
                                <option value="Odisha">Odisha</option>
                                <option value="Puducherry">Puducherry</option>
                                <option value="Punjab">Punjab</option>
                                <option value="Rajasthan">Rajasthan</option>
                                <option value="Sikkim">Sikkim</option>
                                <option value="Tamil Nadu">Tamil Nadu</option>
                                <option value="Telangana">Telangana</option>
                                <option value="Tripura">Tripura</option>
                                <option value="Uttarakhand">Uttarakhand</option>
                                <option value="Uttar Pradesh">Uttar Pradesh</option>
                                <option value="West Bengal">West Bengal</option>
                            </select>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Save</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- End of Change Address Modal -->

    <!-- Add other modals here if needed -->

    <script>
        $(document).ready(function() {
            $('#profile-btn').click(function() {
                $('#profile').show();
                $('#wishlist').hide();
                $('#order').hide();
                $(this).addClass('cus-active');
                $('#wishlist-btn').removeClass('cus-active');
                $('#order-btn').removeClass('cus-active');
            });

            $('#wishlist-btn').click(function() {
                $('#wishlist').show();
                $('#profile').hide();
                $('#order').hide();
                $(this).addClass('cus-active');
                $('#profile-btn').removeClass('cus-active');
                $('#order-btn').removeClass('cus-active');
            });

            $('#order-btn').click(function() {
                $('#order').show();
                $('#profile').hide();
                $('#wishlist').hide();
                $(this).addClass('cus-active');
                $('#profile-btn').removeClass('cus-active');
                $('#wishlist-btn').removeClass('cus-active');
            });
        });
    </script>
</body>
</html>
