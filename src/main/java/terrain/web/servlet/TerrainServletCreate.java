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

import terrain.domain.Terrain;
import terrain.service.TerrainException;
import terrain.service.TerrainService;

/**
 * Servlet implementation class UserServlet
 */

public class TerrainServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TerrainServletCreate() {
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
		TerrainService terrainservice = new TerrainService();
		Map<String, String[]> paramMap = request.getParameterMap();
		Terrain form = new Terrain();
		List<String> info = new ArrayList<String>();

		for (String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setTerraintype(info.get(0));
		form.setMinerals(info.get(1));
		form.setSoil(info.get(2));
		form.setFertilizer(info.get(3));

		try {
			terrainservice.create(form);
			response.sendRedirect(request.getContextPath() + "/jsps/main.jsp");

		} catch (ClassNotFoundException | TerrainException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
