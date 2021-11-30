package plant.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import plant.domain.Plant;
import plant.service.PlantException;
import plant.service.PlantService;

/**
 * Servlet implementation class UserServlet
 */

public class PlantServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlantServletCreate() {
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
		PlantService plantservice = new PlantService();
		Map<String, String[]> paramMap = request.getParameterMap();
		Plant form = new Plant();
		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setPlant_name(info.get(0));
		form.setMeasurement(info.get(1));
		form.setClassification(info.get(2));
		form.setGrowthseason(info.get(3));
		form.setPlantdiscoverer(info.get(4));
		form.setPhotoid()info.get(5));
		form.setPlantpredator(info.get(6));

		try {
			plantservice.create(form);
			response.sendRedirect(request.getContextPath() + "/jsps/main.jsp");

		} catch (ClassNotFoundException | PlantException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
