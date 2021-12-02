package terrain.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import terrain.dao.TerrainDao;
import terrain.domain.Terrain;

/**
 * Servlet implementation class UserServlet
 */

public class TerrainServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TerrainServletUpdate() {
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
		TerrainDao terraindao = new TerrainDao();
		Terrain terrain = null;

		if (method.equals("search")) {
			try {
				terrain = terraindao.findByterraintype(request.getParameter("terrain_type"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if (terrain.getTerraintype() != null) {
				request.setAttribute("terrain", terrain);
				request.getRequestDispatcher("/jsps/terrain/terrain_update_output.jsp").forward(request, response);

			} else {
				request.setAttribute("msg", "Terrain not found");
				request.getRequestDispatcher("/jsps/terrain/terrain_read_output.jsp").forward(request, response);
			}
		} else if (method.equals("update")) {
			Map<String, String[]> paramMap = request.getParameterMap();
			Terrain form = new Terrain();
			List<String> info = new ArrayList<String>();

			for (String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setMinerals(info.get(2));
			form.setSoil(info.get(3));
			form.setFertilizer(info.get(4));
			form.setTerraintype(request.getParameter("terrain_type"));
			// System.out.println(info.get(0));
			System.out.println(info.get(2));
			System.out.println(info.get(3));
			System.out.println(info.get(4));
			try {
				terraindao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Terrain Updated");
			request.getRequestDispatcher("/jsps/terrain/terrain_read_output.jsp").forward(request, response);
		}
	}
}
