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

import predator.domain.Predator;
import predator.service.PredatorException;
import predator.service.PredatorService;

/**
 * Servlet implementation class UserServlet
 */

public class PredatorServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PredatorServletCreate() {
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
		PredatorService predatorservice = new PredatorService();
		Map<String, String[]> paramMap = request.getParameterMap();
		Predator form = new Predator();
		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setSpecies(info.get(0));
		form.setName(info.get(1));
		form.setVoreType(info.get(2));

		try {
			predatorservice.create(form);
			response.sendRedirect(request.getContextPath() + "/jsps/main.jsp");

		} catch (ClassNotFoundException | PredatorException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
