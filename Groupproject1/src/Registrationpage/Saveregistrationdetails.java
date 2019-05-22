 package Registrationpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Saveregistrationdetails")
public class Saveregistrationdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
		RequestDispatcher rd = null;

response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
        
String cusname = request.getParameter("name");
String email = request.getParameter("email");
long phonenumber=Long.parseLong(request.getParameter("phno"));
String password = request.getParameter("password");

      
try{  
	Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/groupproject", "root", "root");
PreparedStatement ps=con.prepareStatement(  
"insert into userregistration values(?,?,?,?)");  
  
ps.setString(1,cusname);
ps.setString(2,email);  
ps.setLong(3,phonenumber);  
ps.setString(4, password);


ps.executeUpdate();

rd = request.getRequestDispatcher("secondlogin.html");
rd.forward(request, response);

   
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  

}  
	
}