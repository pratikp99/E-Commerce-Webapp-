<%@page import="com.revature.ecom.Models.messageModel"%>
<%@page import="com.revature.ecom.DAO.userDAO"%>
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
<title>View Users</title>
<%@include file="Components/common_css_js.jsp"%>
<style>
    /* General Container Styling */
    .container-fluid {
        padding: 20px;
    }

    /* Table Styling */
    .table {
        background-color: #f8f9fa;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        margin-top: 20px;
        overflow: hidden;
    }

    .table th, .table td {
        padding: 15px;
        text-align: center;
        vertical-align: middle;
    }

    .table th {
        background-color: #007bff;
        color: white;
        font-weight: bold;
        border-bottom: 2px solid #0056b3;
    }

    .table tbody tr {
        transition: background-color 0.3s ease;
    }

    .table tbody tr:hover {
        background-color: #e9ecef;
    }

    /* Button Styling */
    .btn-danger {
        padding: 6px 12px;
        font-size: 14px;
        border-radius: 4px;
        transition: background-color 0.3s ease, box-shadow 0.3s ease;
    }

    .btn-danger:hover {
        background-color: #dc3545;
        box-shadow: 0 4px 6px rgba(220, 53, 69, 0.3);
    }

    /* Centering Content */
    .text-center {
        text-align: center;
    }

    /* Responsive Adjustments */
    @media (max-width: 768px) {
        .table th, .table td {
            padding: 10px;
            font-size: 14px;
        }
        .btn-danger {
            padding: 4px 8px;
            font-size: 12px;
        }
    }
</style>
</head>
<body>
    <!-- Navbar -->
    <div class="mb-3">
        <%@include file="Components/navbar.jsp"%>
    </div>

    <!-- User Table -->
    <div class="container-fluid px-5 py-3">
        <table class="table table-hover">
            <thead>
                <tr class="text-center table-primary" style="font-size: 18px;">
                    <th>User Name</th>
                    <th>Email</th>
                    <th>Phone No.</th>
                    <th>Gender</th>
                    <th>Address</th>
                    <th>Register Date</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                userDAO userDao = new userDAO(DatabaseUtil.getConnection());
                List<userModel> userList = userDao.getAllUser();
                for (userModel u : userList) {
                %>
                <tr>
                    <td><%=u.getUserName()%></td>
                    <td><%=u.getUserEmail()%></td>
                    <td><%=u.getUserPhone()%></td>
                    <td><%=u.getUserGender()%></td>
                    <td><%=userDao.getUserAddress(u.getUserId())%></td>
                    <td><%=u.getDateTime()%></td>
                    <td>
                        <form action="updateuser" method="post">
                            <input type="hidden" name="operation" value="deleteUser">
                            <input type="hidden" name="uid" value="<%=u.getUserId()%>">
                            <button type="submit" class="btn btn-danger">Remove</button>
                        </form>
                    </td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
