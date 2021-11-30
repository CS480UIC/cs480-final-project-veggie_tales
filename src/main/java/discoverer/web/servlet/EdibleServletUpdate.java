package edible.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edible.dao.EdibleDao;
import edible.domain.Edible;

/**
 * Servlet implementation class UserServlet
 */

public class EdibleServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EdibleServletUpdate() {
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
		EdibleDao edibledao = new EdibleDao();
		Edible edible = null;

		if (method.equals("search")) {
			try {
				edible = edibledao.findByCrop(request.getParameter("crop"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if (edible.getCrop() != null) {
				request.setAttribute("edible", edible);
				request.getRequestDispatcher("/jsps/edible/edible_update_output.jsp").forward(request, response);

			} else {
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/edible/edible_read_output.jsp").forward(request, response);
			}
		} else if (method.equals("update")) {
			Map<String, String[]> paramMap = request.getParameterMap();
			Edible form = new Edible();
			List<String> info = new ArrayList<String>();

			for (String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setDishes(info.get(2));
			form.setAllergen(info.get(3));
			form.setCrop(request.getParameter("crop"));
//			System.out.println(info.get(0));
			System.out.println(info.get(2));
			System.out.println(info.get(3));
			try {
				edibledao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Updated");
			request.getRequestDispatcher("/jsps/edible/edible_read_output.jsp").forward(request, response);
		}
	}
}
