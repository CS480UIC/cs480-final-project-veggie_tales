package climate.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import climate.dao.ClimateDao;
import climate.domain.Climate;

/**
 * Servlet implementation class UserServlet
 */

public class ClimateServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClimateServletUpdate() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String method = request.getParameter("method");
		ClimateDao climatedao = new ClimateDao();
		Climate climate = null;

		if(method.equals("search"))
		{
			try {
				climate = climatedao.findByClimate(request.getParameter("climate"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(climate.getClimate()!=null){
				request.setAttribute("climate", climate);
				request.getRequestDispatcher("/jsps/climate/climate_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Climate not found");
				request.getRequestDispatcher("/jsps/climate/climate_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Climate form = new Climate();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setRainfall(info.get(2));
			form.setHumidity(info.get(3));
			form.setClimate(request.getParameter("climate"));

			try {
				climatedao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Climate Updated");
			request.getRequestDispatcher("/jsps/climate/climate_read_output.jsp").forward(request, response);
		}
	}
}



