package Search1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import Search1.CusPojo;

public class CustomerDao {

	Connection connection = null;
	PreparedStatement ps = null;
	private Connection getConnection() {
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/groupproject", "root", "root");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}



	public List<CusPojo> listCustomer(String id) {
		List<CusPojo> customerList = new ArrayList<CusPojo>();
		
		
		try {
						connection = getConnection();
			String sql = "SELECT * FROM packagedetail1 where consignmentid=?";

			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet result = ps.executeQuery();


			String sql1 = "SELECT expname,date1 FROM trackorder where cid=?";

			ps = connection.prepareStatement(sql1);
			ps.setString(1, id);

			ResultSet result1 = ps.executeQuery();
			while(result1.next()&& result.next())
			{
				CusPojo cusPojo = new CusPojo();

			String cexp=result1.getString("expname");
			Date date1=result1.getDate("date1");
			cusPojo.setDate1(date1);
			cusPojo.setCexp(cexp);
			
				cusPojo.setName(result.getString("name"));
				cusPojo.setPhno(result.getString("phnumber"));
				cusPojo.setWeight(Double.parseDouble(result.getString("weight")));
				cusPojo.setFcity(result.getString("fromcity"));
				cusPojo.setTcity(result.getString("tocity"));
				cusPojo.setAdate(result.getString("accepteddate"));
				cusPojo.setCost(Double.parseDouble(result.getString("cost")));
				cusPojo.setCid(result.getString("consignmentid"));
				
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
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return customerList;

	}

	
	}
