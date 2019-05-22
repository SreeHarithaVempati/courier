package adminaddexchangepoint;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/modifycurrentexc")

public class modifycurrentexc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd = null;

   
    public modifycurrentexc() {
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
			String id = request.getParameter("id");
			String exp = request.getParameter("modifycurexc");
			String date1=request.getParameter("date1");
			System.out.println(id);
			System.out.println(exp);

			System.out.println(date1);

			
			
			Class.forName("com.mysql.jdbc.Driver");
			 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/groupproject", "root", "root");
			String updateCustomer = "UPDATE trackorder SET expname=?,date1=? WHERE cid=?";
			ps = con.prepareStatement(updateCustomer);
			 
			ps.setString(1,exp);
		ps.setString(2, date1);
		ps.setString(3, id);

		

		int i=ps.executeUpdate(); 
		if(i>0)
		{
			rd = request.getRequestDispatcher("modifycurrentexc1.html");
		rd.forward(request, response);
		}
			       
		}catch (Exception e2) {System.out.println(e2);}  
		          
		out.close();  		
	}

}
