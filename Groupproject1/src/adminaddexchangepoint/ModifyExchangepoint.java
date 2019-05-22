package adminaddexchangepoint;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ModifyExchangepoint")
public class ModifyExchangepoint extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd = null;

   
    public ModifyExchangepoint() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  

		Connection con = null;
		
		PreparedStatement ps = null;
	      
		try{ 
			String scity = request.getParameter("scity");
			String dcity = request.getParameter("dcity"); 
			
			String mcity = request.getParameter("modifycity");
			String ncity = request.getParameter("newcity"); 
			Class.forName("com.mysql.jdbc.Driver");
			 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/groupproject", "root", "root");
			String updateCustomer = "UPDATE addexp SET expname=? WHERE expname=? and fcity=? and dcity=?";
			ps = con.prepareStatement(updateCustomer);
			ps.setString(1, ncity);
		ps.setString(2,mcity);
		ps.setString(3, scity);
		ps.setString(4, dcity);

		int i=ps.executeUpdate(); 
		if(i>0)
		{
			rd = request.getRequestDispatcher("addexchangepoint.html");
		rd.forward(request, response);}	
		else
		{
			out.println("failed to modified");

		}
		       
		}catch (Exception e2) {System.out.println(e2);}  
		          
		out.close();  
	}
	}


