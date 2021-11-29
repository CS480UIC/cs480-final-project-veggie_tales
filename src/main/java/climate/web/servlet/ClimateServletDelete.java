package climate.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import climate.dao.ClimateDao;
import climate.domain.Climate;


/**
 * Servlet implementation class UserServlet
 */

public class ClimateServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClimateServletDelete() {
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
		ClimateDao climateDao = new ClimateDao();
		Climate climate = null;
		if(method.equals("search"))
		{
			try {
				climate = climateDao.findByClimate(request.getParameter("climate"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(climate.getClimate()!=null){
						System.out.println(climate);
						request.setAttribute("climate", climate);
						request.getRequestDispatcher("/jsps/climate/climate_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Climate not found");
				request.getRequestDispatcher("/jsps/climate/climate_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				climateDao.delete(request.getParameter("climate"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Climate Deleted");
			request.getRequestDispatcher("/jsps/climate/climate_read_output.jsp").forward(request, response);
		}
	}
}



