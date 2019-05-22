package Loginform;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Loginform.CustomerDao;
import Loginform.CusPojo;


@WebServlet("/customerServlet2")
public class CustomerManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd = null;
	
	public CustomerManagement() {
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("uname");
		String password = request.getParameter("password");

		
		CustomerDao customerDao = new CustomerDao();
		


			int flag = customerDao.listCustomer(uname,password);
			if(flag==1)
			{
				rd = request.getRequestDispatcher("addexchangepoint.html");
				rd.forward(request, response);
			}
			else if(flag==2)
			{
				rd = request.getRequestDispatcher("SendCourier.html");
				rd.forward(request, response);
			}

			else
			{
	         response.sendRedirect("errorlogin.html");
			}
	}

}
