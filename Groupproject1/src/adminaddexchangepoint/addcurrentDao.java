package adminaddexchangepoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Search1.CusPojo;

public class addcurrentDao {
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



	public void addcurexp(String id) {
		String a=null;
		String b=null;
		
		try {
						con = getConnection();
			String sql = "SELECT fromcity ,accepteddate FROM packagedetail1 where consignmentid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);

			ResultSet result = ps.executeQuery();
			while(result.next()) {
			 a=result.getString("fromcity");  b=result.getString("accepteddate");				
			}
			System.out.println(a+b);
			String sql1="insert into trackorder values(?,?,?)";
			ps = con.prepareStatement(sql1);

			ps.setString(1, id);
			ps.setString(2, a);
			ps.setString(3, b);
            int i=ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
}
	}
}
	
