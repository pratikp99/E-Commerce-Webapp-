package com.revature.ecom.DAO;
import com.revature.ecom.Models.orderedProductModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class orderedProductDAO {
	private Connection con;

	public orderedProductDAO(Connection con) {
		super();
		this.con = con;
	}
	
	public void insertOrderedProduct(orderedProductModel ordProduct) {
		try {
			String query = "insert into ordered_product(name, quantity, price, image, orderid) values(?, ?, ?, ?, ?)";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setString(1, ordProduct.getName());
			psmt.setInt(2, ordProduct.getQuantity());
			psmt.setFloat(3,ordProduct.getPrice());
			psmt.setString(4, ordProduct.getImage());
			psmt.setInt(5, ordProduct.getOrderId());

			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<orderedProductModel> getAllOrderedProduct(int oid){
		List<orderedProductModel> list = new ArrayList<orderedProductModel>();
		try {
			String query = "select * from ordered_product where orderid = ?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setInt(1, oid);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				orderedProductModel orderProd = new orderedProductModel();
				orderProd.setName(rs.getString("name"));
				orderProd.setQuantity(rs.getInt("quantity"));
				orderProd.setPrice(rs.getFloat("price"));
				orderProd.setImage(rs.getString("image"));
				orderProd.setOrderId(oid);

				list.add(orderProd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
