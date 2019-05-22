package com.pack.cm.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class search1 {
	public static void main(String args[])
	{
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/groupproject", "root", "root");
			Statement stmt=(Statement) con.createStatement();
		}
		catch(Exception e)
		{
			
		}
	}

}
