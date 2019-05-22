package adminaddexchangepoint;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddExchagePoint")
public class AddExchagePoint extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd = null;
 
    
    public AddExchagePoint() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served.. at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  

		String scity = request.getParameter("scity");
		String dcity = request.getParameter("dcity");        
		String expname = request.getParameter("excname");
		String add = request.getParameter("address");
		long phonenumber = Long.parseLong(request.getParameter("contactnumber"));
				      
		try{  
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/groupproject", "root", "root");
		PreparedStatement ps=con.prepareStatement(  
		"insert into addexp(fcity,dcity,expname,expadd,contactno) values(?,?,?,?,?)");  
		ps.setString(1,scity);  
		ps.setString(2, dcity);
		ps.setString(3,expname);  
			ps.setString(4, add);
		ps.setLong(5, phonenumber);
		
		  		          
		int i=ps.executeUpdate();  
		if(i>0)  
		{
			rd = request.getRequestDispatcher("addedexchangepoint.html");
		rd.forward(request, response);}		      
		          
		}catch (Exception e2) {System.out.println(e2);}  
		          
		out.close();  
	}

}
