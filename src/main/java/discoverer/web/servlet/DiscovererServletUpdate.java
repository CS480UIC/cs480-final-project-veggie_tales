package discoverer.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import discoverer.dao.DiscovererDao;
import discoverer.domain.Discoverer;

/**
 * Servlet implementation class UserServlet
 */

public class DiscovererServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DiscovererServletUpdate() {
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
		DiscovererDao discovererdao = new DiscovererDao();
		Discoverer discoverer = null;

		if (method.equals("search")) {
			try {
				discoverer = discovererdao.findByName(request.getParameter("discoverer_name"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if (discoverer.getDiscovererName() != null) {
				request.setAttribute("discoverer", discoverer);
				request.getRequestDispatcher("/jsps/discoverer/discoverer_update_output.jsp").forward(request, response);

			} else {
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/discoverer/discoverer_read_output.jsp").forward(request, response);
			}
		} else if (method.equals("update")) {
			Map<String, String[]> paramMap = request.getParameterMap();
			Discoverer form = new Discoverer();
			List<String> info = new ArrayList<String>();

			for (String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setDate(info.get(2));
			form.setDiscoveredLocation(info.get(3));
			form.setDiscovererName(request.getParameter("discoverer_name"));
//			System.out.println(info.get(0));
			System.out.println(info.get(2));
			System.out.println(info.get(3));
			try {
				discovererdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Discoverer Updated");
			request.getRequestDispatcher("/jsps/discoverer/discoverer_read_output.jsp").forward(request, response);
		}
	}
}
