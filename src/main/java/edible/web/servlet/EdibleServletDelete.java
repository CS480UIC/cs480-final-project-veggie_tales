package edible.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edible.dao.EdibleDao;
import edible.domain.Edible;

/**
 * Servlet implementation class UserServlet
 */

public class EdibleServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EdibleServletDelete() {
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
		EdibleDao edibleDao = new EdibleDao();
		Edible edible = null;
		if (method.equals("search")) {
			try {
				edible = edibleDao.findByCrop(request.getParameter("crop"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if (edible.getCrop() != null) {
				System.out.println(edible);
				request.setAttribute("edible", edible);
				request.getRequestDispatcher("/jsps/edible/edible_delete_output.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/edible/edible_read_output.jsp").forward(request, response);
			}
		} else if (method.equals("delete")) {
			try {
				edibleDao.delete(request.getParameter("crop"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Deleted");
			request.getRequestDispatcher("/jsps/edible/edible_read_output.jsp").forward(request, response);
		}
	}
}
