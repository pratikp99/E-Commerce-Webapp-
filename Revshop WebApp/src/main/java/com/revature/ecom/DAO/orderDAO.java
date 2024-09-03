package com.revature.ecom.DAO;
import com.revature.ecom.Models.orderModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class orderDAO {
	
	private Connection con;
	public orderDAO(Connection con) {
		super();
		this.con = con;
	}
	
	public int insertOrder(orderModel order) {
		int id = 0;
		try {
			String query = "insert into `orders`(orderid, status, paymentType, userId) values(?, ?, ?, ?)";
			PreparedStatement psmt = this.con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			psmt.setString(1, order.getOrderId());
			psmt.setString(2, order.getStatus());
			psmt.setString(3, order.getPayementType());
			psmt.setInt(4, order.getUserId());
			
			int affectedRows = psmt.executeUpdate();

	        if (affectedRows == 0) {
	            throw new SQLException("Insertion failed, no rows affected.");
	        }
	        try (ResultSet generatedKeys = psmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                id = generatedKeys.getInt(1);
	            }
	            else {
	                throw new SQLException("Insertion failed, no ID obtained.");
	            }
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	public List<orderModel> getAllOrderByUserId(int uid){
		List<orderModel> list = new ArrayList<orderModel>();
		try {
			String query = "select * from `orders` where userId = ?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setInt(1, uid);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				orderModel order = new orderModel();
				order.setId(rs.getInt("id"));
				order.setOrderId(rs.getString("orderid"));
				order.setStatus(rs.getString("status"));
				order.setDate(rs.getTimestamp("date"));
				order.setPayementType(rs.getString("paymentType"));
				order.setUserId(uid);

				list.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public orderModel getOrderById(int id){
		orderModel order = new orderModel();
		try {
			String query = "select * from `orders` where id = ?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				order.setId(rs.getInt("id"));
				order.setOrderId(rs.getString("orderid"));
				order.setStatus(rs.getString("status"));
				order.setDate(rs.getTimestamp("date"));
				order.setPayementType(rs.getString("paymentType"));
				order.setUserId(rs.getInt("userId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}
	public List<orderModel> getAllOrder(){
		List<orderModel> list = new ArrayList<orderModel>();
		try {
			String query = "select * from `orders`";
			Statement statement = this.con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				orderModel order = new orderModel();
				order.setId(rs.getInt("id"));
				order.setOrderId(rs.getString("orderid"));
				order.setStatus(rs.getString("status"));
				order.setDate(rs.getTimestamp("date"));
				order.setPayementType(rs.getString("paymentType"));
				order.setUserId(rs.getInt("userId"));
				
				list.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public void updateOrderStatus(int oid, String status) {
		try {
			String query = "update `orders` set status = ? where id = ?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setString(1, status);
			psmt.setInt(2, oid);

			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}