<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>

<%
String name=request.getParameter("customername");
int phonenumber=Integer.parseInt(request.getParameter("contactnumber"));
String fcity_name=request.getParameter("fromcity");
String dcity=request.getParameter("destinationcity");


try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
Statement st=conn.createStatement();

out.println("Data is successfully inserted!");
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>
