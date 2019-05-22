package com.pack.cm.servlet;

import java.sql.*;  

public class LoginDao {  
public static boolean validate(String name){  
boolean status=false;  
try{  
	Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/groupproject", "root", "root");
PreparedStatement ps=con.prepareStatement(  
"select * from packagedetail1 where consignmentid=?");  
ps.setString(1,name);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
return status;  
}  
}  