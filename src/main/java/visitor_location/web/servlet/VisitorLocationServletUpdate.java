package visitor_location.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import visitor_location.dao.VisitorLocationDao;
import visitor_location.domain.VisitorLocation;

/**
 * Servlet implementation class UserServlet
 */

public class VisitorLocationServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisitorLocationServletUpdate() {
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
		VisitorLocationDao vldao = new VisitorLocationDao();
		VisitorLocation vl = null;

		if (method.equals("search")) {
			try {
				vl = vldao.findByZip(request.getParameter("zip_code"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if (vl.getZip() != null) {
				request.setAttribute("visitor_location", vl);
				request.getRequestDispatcher("/jsps/visitor_location/visitor_location_update_output.jsp")
						.forward(request, response);

			} else {
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/visitor_location/visitor_location_read_output.jsp").forward(request,
						response);
			}
		} else if (method.equals("update")) {
			Map<String, String[]> paramMap = request.getParameterMap();
			VisitorLocation form = new VisitorLocation();
			List<String> info = new ArrayList<String>();

			for (String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setContinent(info.get(2));
			form.setCountry(info.get(3));
			form.setCity(info.get(4));
			form.setClimate(info.get(5));
			form.setTerrain(info.get(6));
			form.setZip(request.getParameter("zip_code"));

			try {
				vldao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Updated");
			request.getRequestDispatcher("/jsps/visitor_location/visitor_location_read_output.jsp").forward(request,
					response);
		}
	}
}
