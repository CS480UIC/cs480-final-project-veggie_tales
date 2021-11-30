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

import visitor_location.domain.VisitorLocation;
import visitor_location.service.VisitorLocationException;
import visitor_location.service.VisitorLocationService;

/**
 * Servlet implementation class UserServlet
 */

public class VisitorLocationServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisitorLocationServletCreate() {
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
		VisitorLocationService vlservice = new VisitorLocationService();
		Map<String, String[]> paramMap = request.getParameterMap();
		VisitorLocation form = new VisitorLocation();
		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setZip(info.get(0));
		form.setContinent(info.get(1));
		form.setCountry(info.get(2));
		form.setCity(info.get(2));

		try {
			vlservice.create(form);
			response.sendRedirect(request.getContextPath() + "/jsps/main.jsp");

		} catch (ClassNotFoundException | VisitorLocationException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
