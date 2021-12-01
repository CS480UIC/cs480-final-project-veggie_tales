package predator.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import predator.dao.PredatorDao;
import predator.domain.Predator;

/**
 * Servlet implementation class UserServlet
 */

public class PredatorServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PredatorServletDelete() {
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
		String method = request.getParameter("method");
		PredatorDao predatorDao = new PredatorDao();
		Predator predator = null;
		if (method.equals("search")) {
			try {
				predator = predatorDao.findBySpecies(request.getParameter("species"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if (predator.getSpecies() != null) {
				System.out.println(predator);
				request.setAttribute("predator", predator);
				request.getRequestDispatcher("/jsps/predator/predator_delete_output.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/predator/predator_read_output.jsp").forward(request, response);
			}
		} else if (method.equals("delete")) {
			try {
				predatorDao.delete(request.getParameter("species"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Predator Deleted");
			request.getRequestDispatcher("/jsps/predator/predator_read_output.jsp").forward(request, response);
		}
	}
}
