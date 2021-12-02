package plant.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import plant.dao.PlantDao;
import plant.domain.Plant;

/**
 * Servlet implementation class UserServlet
 */

public class PlantServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlantServletRead() {
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
		Plant plant = null;
		PlantDao plantDao = new PlantDao();

		try {
			plant = plantDao.findByPlantName(request.getParameter("plant_name"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}

		if (plant.getPlantName() != null) {
			System.out.println(plant);
			request.setAttribute("plant", plant);
			request.getRequestDispatcher("/jsps/plant/plant_read_output.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "Entity not found");
			request.getRequestDispatcher("/jsps/plant/plant_read_output.jsp").forward(request, response);
		}
	}
}
