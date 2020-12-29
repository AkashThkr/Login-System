package com.login.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	String sql = "select * from login where uname=? and pass=?";
	String url = "jdbc:mysql://localhost:3306/akash";
	String user = "root";
	String password = "root";
	public boolean check(String uname , String pass) {
		try {
			java.sql.Connection connection = DriverManager.getConnection(url, user, password);
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return true;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
