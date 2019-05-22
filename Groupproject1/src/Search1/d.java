package Search1;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class d
 */
@WebServlet("/d")
public class d extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RequestDispatcher rd = null;
	String actionPerformed = null;

    public d() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cid = request.getParameter("search2");
		System.out.println(cid);

		CusPojo cusPojo = new CusPojo();

		cusPojo.setCid(cid);
		
		CustomerDao customerDao = new CustomerDao();
		

			List<CusPojo> cusList = customerDao.listCustomer(cid);
			request.setAttribute("cusList", cusList);
			System.out.println("redirect");
			rd = request.getRequestDispatcher("customerDetails.jsp");
			rd.forward(request, response);
			}

}
