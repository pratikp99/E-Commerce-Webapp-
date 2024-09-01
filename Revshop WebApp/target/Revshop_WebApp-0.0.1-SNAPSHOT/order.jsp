<%@page import="com.revature.ecom.Models.messageModel"%>
<%@page import="com.revature.ecom.Models.orderedProductModel"%>
<%@page import="com.revature.ecom.Models.orderModel"%>
<%@page import="java.util.List"%>
<%@page import="com.revature.ecom.DAO.orderedProductDAO"%>
<%@page import="com.revature.ecom.DAO.orderDAO"%>
<%@page import="com.revature.ecom.Utils.DatabaseUtil"%>
<%@page import="com.revature.ecom.Models.userModel"%>
<%@page errorPage="error_exception.jsp"%>

<%
userModel u2 = (userModel) session.getAttribute("activeUser");
if (u2 == null) {
	messageModel message = new messageModel("You are not logged in! Login first!!", "error", "alert-danger");
	session.setAttribute("message", message);
	response.sendRedirect("login.jsp");
	return;  
}
orderDAO orderDao = new orderDAO(DatabaseUtil.getConnection());
orderedProductDAO ordProdDao = new orderedProductDAO(DatabaseUtil.getConnection());

List<orderModel> orderList = orderDao.getAllOrderByUserId(u2.getUserId());
%>
<div class="container-fluid px-3 py-3">
	<%
	if (orderList == null || orderList.size() == 0) {
	%>
	<div class="container mt-5 mb-5 text-center">
		<img src="Images/empty-cart.png" style="max-width: 200px;"
			class="img-fluid">
		<h4 class="mt-3">Zero Order found</h4>
		Looks like you haven't placed any order!
	</div>
	<%
	} else {
	%>
	<h4>My Order</h4>
	<hr>
	<div class="container">
		<table class="table table-hover">
			<tr class="text-center table-secondary">
			  <th>Product</th>
			  <th>Order ID</th>
			  <th>Name</th>
			  <th>Quantity</th>
			  <th>Total Price</th>
			  <th>Date and Time</th>
			  <th>Payment Type</th>
			  <th>Status</th>
			</tr>
			<%
			for (orderModel order : orderList) {
				List<orderedProductModel> ordProdList = ordProdDao.getAllOrderedProduct(order.getId());
				for (orderedProductModel orderProduct : ordProdList) {
			%>
			<tr class="text-center">
				<td><img src="Product_imgs\<%=orderProduct.getImage()%>"
					style="width: 40px; height: 40px; width: auto;"></td>
				<td class="text-start"><%=order.getOrderId()%></td>
				<td class="text-start"><%=orderProduct.getName()%></td>
				<td><%=orderProduct.getQuantity()%></td>
				<td><%=orderProduct.getPrice() * orderProduct.getQuantity()%></td>
				<td><%=order.getDate()%></td>
				<td><%=order.getPayementType()%></td>
				<td class="fw-semibold" style="color: green;"><%=order.getStatus()%></td>
			</tr>
			<%
			}
			}
			%>
		</table>
	</div>
	<%
	}
	%>
</div>
