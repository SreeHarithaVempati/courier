package com.pack.cm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.java_cup.internal.runtime.Scanner;
import java.util.*;


@WebServlet("/SaveCustomerdetails")
public class SaveCustomerdetails extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
		RequestDispatcher rd = null;

response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
        
String cusname = request.getParameter("customername");
Long phonenumber = Long.parseLong(request.getParameter("contactnumber"));
double weight=Double.parseDouble(request.getParameter("pw"));
System.out.println(weight);
String fcity = request.getParameter("fromcity");
String tcity = request.getParameter("destinationcity");
String date1 = request.getParameter("date1");
double cost = Double.parseDouble(request.getParameter("cost"));
String id=getCustomerid();  
      
try{  
	Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/groupproject", "root", "root");
	


PreparedStatement ps=con.prepareStatement(  
"insert into packagedetail1 values(?,?,?,?,?,?,?,?)");  
  
ps.setString(1,cusname);  
ps.setLong(2,phonenumber);  
ps.setDouble(3, weight);  
ps.setString(4, fcity);
ps.setString(5, tcity);
ps.setString(6, date1);
ps.setDouble(7, cost);  
ps.setString(8, id);

int i=ps.executeUpdate();

if(i>0) 
{
rd = request.getRequestDispatcher("sendcourier1.html");
rd.forward(request, response);


}


      
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  

}  
	String getCustomerid() {

		Random rd = new Random();
		String cusid = "PKG" + rd.nextInt(100000);

		return cusid;

	}
	public void addcurrentexcp()
	{
	}
}