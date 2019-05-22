package adminaddexchangepoint;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Search1.CusPojo;
import Search1.CustomerDao;

/**
 * Servlet implementation class addcurrentexp
 */
@WebServlet("/addcurrentexp")
public class addcurrentexp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd = null;

    public addcurrentexp() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost");

		String cid = request.getParameter("cid");
		

	
		addcurrentDao addcurrentDao = new addcurrentDao();
		System.out.println("inside doget");
		System.out.println("method sent.." + request.getMethod());


		addcurrentDao.addcurexp(cid);
			rd = request.getRequestDispatcher("addexchangepoint.html");
			rd.forward(request, response);
		
	

		      
		          
		          
			}

}
