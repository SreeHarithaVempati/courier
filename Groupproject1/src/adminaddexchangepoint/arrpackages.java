package adminaddexchangepoint;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Search1.CusPojo;
import Search1.CustomerDao;

@WebServlet("/arrpackages")
public class arrpackages extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd = null;

       
        public arrpackages() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");


		arrPojo arrPojo = new arrPojo();

		
		arrdao arrdao = new arrdao();
		System.out.println("inside doget");
		System.out.println("method sent.." + request.getMethod());


			List<arrPojo> cusList = arrdao.listCustomer(date1,date2);
			request.setAttribute("cusList", cusList);
			System.out.println("redirect");
			rd = request.getRequestDispatcher("customerDetails3.jsp");
			rd.forward(request, response);
		
	
	}

}
