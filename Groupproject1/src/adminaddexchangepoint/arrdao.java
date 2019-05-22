package adminaddexchangepoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Search1.CusPojo;

public class arrdao {
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



	public List<arrPojo> listCustomer(String date1,String date2) {
		List<arrPojo> customerList = new ArrayList<arrPojo>();
		
		
		try {
						connection = getConnection();
						System.out.println("1");
			String sql = "SELECT * FROM packagedetail1 where (accepteddate between ? and ?) ";

			ps = connection.prepareStatement(sql);
			ps.setString(1, date1);
			ps.setString(2, date2);

			ResultSet result = ps.executeQuery();

			while(result.next())
			{
				arrPojo arrPojo = new arrPojo();

			
				arrPojo.setName(result.getString("name"));
				arrPojo.setPhnumber(result.getString("phnumber"));
				arrPojo.setWeight(Double.parseDouble(result.getString("weight")));
				arrPojo.setFromcity(result.getString("fromcity"));
				arrPojo.setTocity(result.getString("tocity"));
				arrPojo.setAccepteddate(result.getString("accepteddate"));
				arrPojo.setCost(Double.parseDouble(result.getString("cost")));
				arrPojo.setConsignmentid(result.getString("consignmentid"));
				
				customerList.add(arrPojo);
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
