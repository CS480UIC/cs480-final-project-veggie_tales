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

public class PlantServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlantServletDelete() {
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
		PlantDao plantDao = new PlantDao();
		Plant plant = null;
		if (method.equals("search")) {
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
				request.getRequestDispatcher("/jsps/plant/plant_delete_output.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/plant/plant_read_output.jsp").forward(request, response);
			}
		} else if (method.equals("delete")) {
			try {
				plantDao.delete(request.getParameter("plant_name"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Deleted");
			request.getRequestDispatcher("/jsps/plant/plant_read_output.jsp").forward(request, response);
		}
	}
}
