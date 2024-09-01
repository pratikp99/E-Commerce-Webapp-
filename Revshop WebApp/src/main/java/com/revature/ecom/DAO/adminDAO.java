package com.revature.ecom.DAO;

import com.revature.ecom.Models.adminModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class adminDAO {
	
	private Connection con;
	
	public adminDAO(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean saveAdmin(adminModel admin) {
		boolean flag = false;

		try {
			String query = "insert into admin(name, email, password, phone) values(?, ?, ?, ?)";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setString(1, admin.getName());
			psmt.setString(2, admin.getEmail());
			psmt.setString(3, admin.getPassword());
			psmt.setString(4, admin.getPhone());

			psmt.executeUpdate();
			flag = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	public adminModel getAdminByEmailPassword(String email, String password) {
		adminModel admin = null;
		try {
			String query = "select * from admin where email = ? and password = ?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setString(1, email);
			psmt.setString(2, password);

			ResultSet set = psmt.executeQuery();
			while (set.next()) {
				admin = new adminModel();
				admin.setId(set.getInt("id"));
				admin.setName(set.getString("name"));
				admin.setEmail(set.getString("email"));
				admin.setPassword(set.getString("password"));
				admin.setPhone(set.getString("phone"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
	public List<adminModel> getAllAdmin(){
		List<adminModel> list = new ArrayList<adminModel>();
		try {
			
			String query = "select * from admin";
			Statement statement = this.con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				adminModel admin = new adminModel();
				admin.setId(rs.getInt("id"));
				admin.setName(rs.getString("name"));
				admin.setEmail(rs.getString("email"));
				admin.setPhone(rs.getString("phone"));
				admin.setPassword(rs.getString("password"));
				
				list.add(admin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean deleteAdmin(int id) {
		boolean flag = false;
		try {
			String query = "delete from admin where id = ?";
			PreparedStatement psmt = this.con.prepareStatement(query);
			psmt.setInt(1, id);
			psmt.executeUpdate();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
