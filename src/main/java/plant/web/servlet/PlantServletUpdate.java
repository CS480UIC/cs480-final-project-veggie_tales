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

import plant.dao.PlantDao;
import plant.domain.Plant;

/**
 * Servlet implementation class UserServlet
 */

public class PlantServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlantServletUpdate() {
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
		PlantDao plantdao = new PlantDao();
		Plant plant = null;

		if (method.equals("search")) {
			try {
				plant = plantdao.findByPlantName(request.getParameter("plant_name"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if (plant.getPlantName() != null) {
				request.setAttribute("plant", plant);
				request.getRequestDispatcher("/jsps/plant/plant_update_output.jsp").forward(request, response);

			} else {
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/plant/plant_read_output.jsp").forward(request, response);
			}
		} else if (method.equals("update")) {
			Map<String, String[]> paramMap = request.getParameterMap();
			Plant form = new Plant();
			List<String> info = new ArrayList<String>();

			for (String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setMeasurement(info.get(2));
			form.setClassification(info.get(3));
			form.setGrowthSeason(info.get(4));
			form.setPlantDiscoverer(info.get(5));
			form.setPhotoId(info.get(6));
			form.setPlantPredator(info.get(7));
			form.setPlantName(request.getParameter("plant_name"));
			// System.out.println(info.get(0));
			System.out.println(info.get(2));
			System.out.println(info.get(3));
			System.out.println(info.get(4));
			System.out.println(info.get(5));
			System.out.println(info.get(6));
			System.out.println(info.get(7));
		
			try {
				plantdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Plant Updated");
			request.getRequestDispatcher("/jsps/plant/plant_read_output.jsp").forward(request, response);
		}
	}
}
