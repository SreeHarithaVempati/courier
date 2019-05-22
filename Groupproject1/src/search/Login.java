package search;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;



/**
 * Servlet implementation class Login
 */


    public class Login {  
    	public static boolean validate(String cid){  
    	boolean status=false;  
    	try{  
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/groupproject", "root", "root");
    	      Statement smt=(Statement) con.createStatement();
    	      String sql="select * from packagedetail1  where consignmentid='"+cid+"'";
    	      
    	//PreparedStatement ps=con.prepareStatement("select * from packagedetail1  where consignmentid='"+name+"'");  
    //	ps.setString(1,name);  
    
    	      
    	ResultSet rs=smt.executeQuery(sql);  
    	status=rs.next();  
    	while(rs.next())
    	{
    		PrintWriter out = null;
			out.println(rs.getString(1)+""+rs.getString(2));
    	}
    	          
    	}catch(Exception e){System.out.println(e);}  
    	return status;  
    	}  
    	}  