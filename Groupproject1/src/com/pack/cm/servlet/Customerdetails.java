package com.pack.cm.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.pack.cm.servlet.CusPojo;

public class Customerdetails {

	Connection con = null;
	PreparedStatement ps = null;

	private Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/groupproject", "root", "root");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public String saveCustomer(String fname, int phonenumber) {
		Connection con = null;
		String customerId = null;
		PreparedStatement ps = null;
		try {
			customerId = generateCustomerid();
			con = getConnection();
			String custInsertSql = "insert into packagedetails (cid,fname,lname) values(?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(custInsertSql);
			ps.setString(1, customerId);
			ps.setString(2, fname);
			ps.setInt(3, phonenumber);

			ps.executeUpdate();
			System.out.println("Customer record inserted successfully..");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return customerId;
	}
	String generateCustomerid() {

		Random rd = new Random();
		String cusid = "CTS" + rd.nextInt(100000);

		return cusid;

	}
}