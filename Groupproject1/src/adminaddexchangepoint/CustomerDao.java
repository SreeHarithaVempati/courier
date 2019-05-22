package adminaddexchangepoint;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import adminaddexchangepoint.CusPojo;

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



	public List<CusPojo> listCustomer(String city1,String city2) {
		List<CusPojo> customerList = new ArrayList<CusPojo>();
				
		try {
						con = getConnection();
			String sql = "SELECT * FROM addexp where fcity=? and dcity=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, city1);
			ps.setString(2, city2);

			ResultSet result = ps.executeQuery();

			while(result.next()) {
				CusPojo cusPojo = new CusPojo();
				cusPojo.setFcity(result.getString("fcity"));
				cusPojo.setDcity(result.getString("dcity"));
				cusPojo.setExpn(result.getString("expname"));
				
				customerList.add(cusPojo);
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
		return customerList;

	}

	
	}
