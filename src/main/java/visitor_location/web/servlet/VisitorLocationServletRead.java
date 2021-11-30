package visitor_location.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import visitor_location.dao.VisitorLocationDao;
import visitor_location.domain.VisitorLocation;

/**
 * Servlet implementation class UserServlet
 */

public class VisitorLocationServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisitorLocationServletRead() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VisitorLocation vl = null;
		VisitorLocationDao vlDao = new VisitorLocationDao();

		try {
			vl = vlDao.findByZip(request.getParameter("zip_code"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}

		if (vl.getZip() != null) {
			System.out.println(vl);
			request.setAttribute("visitor_location", vl);
			request.getRequestDispatcher("/jsps/visitor_location/visitor_location_read_output.jsp").forward(request,
					response);
		} else {
			request.setAttribute("msg", "Entity not found");
			request.getRequestDispatcher("/jsps/visitor_location/visitor_location_read_output.jsp").forward(request,
					response);
		}
	}
}
