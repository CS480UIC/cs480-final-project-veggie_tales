package season.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import season.dao.SeasonDao;
import season.domain.Season;


/**
 * Servlet implementation class UserServlet
 */

public class SeasonServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeasonServletRead() {
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
		Season season = null;
		SeasonDao seasonDao = new SeasonDao();
		
		try {
			season = seasonDao.findBySeason(request.getParameter("season"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(season.getSeason()!=null){
					System.out.println(season);
					request.setAttribute("season", season);
					request.getRequestDispatcher("/jsps/season/season_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Season not found");
			request.getRequestDispatcher("/jsps/season/season_read_output.jsp").forward(request, response);
		}
	}
}



