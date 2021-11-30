package terrain.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import terrain.dao.TerrainDao;
import terrain.domain.Terrain;

/**
 * Servlet implementation class UserServlet
 */

public class TerrainServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TerrainServletRead() {
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
		Terrain terrain = null;
		TerrainDao terrainDao = new TerrainDao();

		try {
			terrain = terrainDao.findByterraintype(request.getParameter("terrain_type"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}

		if (terrain.getTerraintype() != null) {
			System.out.println(terrain);
			request.setAttribute("terrain", terrain);
			request.getRequestDispatcher("/jsps/terrain/terrain_read_output.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "Entity not found");
			request.getRequestDispatcher("/jsps/terrain/terrain_read_output.jsp").forward(request, response);
		}
	}
}
