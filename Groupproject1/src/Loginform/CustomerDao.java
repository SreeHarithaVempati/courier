package Loginform;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Loginform.CusPojo;

public class CustomerDao {

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



	public int listCustomer(String uname,String pass) {
	
		int flag=0;
		try {
						con = getConnection();
			String sql = "SELECT * FROM userregistration where name=? and password=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pass);
			ResultSet result = ps.executeQuery();

			while(result.next()) {
				String un=result.getString(1);
				String ps=result.getString(4);
				System.out.println(un+ps);

				if(un.equals("admin")&&(ps.equals("admin1234")))
				{
					flag=1;
					break;
				}
				else
				{
					flag=2;
				break;
				}


			}

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
		return flag;


	}

	
	}
