package predator.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import predator.dao.PredatorDao;
import predator.domain.Predator;

/**
 * Servlet implementation class UserServlet
 */

public class PredatorServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PredatorServletUpdate() {
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
		PredatorDao predatordao = new PredatorDao();
		Predator predator = null;

		if (method.equals("search")) {
			try {
				predator = predatordao.findBySpecies(request.getParameter("species"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if (predator.getSpecies() != null) {
				request.setAttribute("predator", predator);
				request.getRequestDispatcher("/jsps/predator/predator_update_output.jsp").forward(request, response);

			} else {
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/predator/predator_read_output.jsp").forward(request, response);
			}
		} else if (method.equals("update")) {
			Map<String, String[]> paramMap = request.getParameterMap();
			Predator form = new Predator();
			List<String> info = new ArrayList<String>();

			for (String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setName(info.get(2));
			form.setVoreType(info.get(3));
			form.setSpecies(request.getParameter("species"));
//			System.out.println(info.get(0));
			System.out.println(info.get(2));
			System.out.println(info.get(3));
			try {
				predatordao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Predator Updated");
			request.getRequestDispatcher("/jsps/predator/predator_read_output.jsp").forward(request, response);
		}
	}
}
