package adminaddexchangepoint;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminaddexchangepoint.CustomerDao;
import adminaddexchangepoint.CusPojo;


@WebServlet("/customerServlet1")
public class CustomerManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd = null;
	String actionPerformed = null;

	
	public CustomerManagement() {
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost");

		String city1 = request.getParameter("scity");
		String city2 = request.getParameter("dcity");

		
				
		CustomerDao customerDao = new CustomerDao();
		System.out.println("inside doget");
		System.out.println("method sent.." + request.getMethod());


			List<CusPojo> cusList = customerDao.listCustomer(city1,city2);
			request.setAttribute("cusList", cusList);
			System.out.println("redirect");
			rd = request.getRequestDispatcher("customerDetails1.jsp");
			rd.forward(request, response);
		
	
		
	}

}
