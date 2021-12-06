package database.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.dao.DatabaseDao;
import database.domain.Database;


/**
 * Servlet implementation class UserServlet
 */

public class DatabaseServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatabaseServletRead() {
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
		Database database = null;
		DatabaseDao databaseDao = new DatabaseDao();
		
		try {
			database = databaseDao.findByDatabase(request.getParameter("database"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(database.getDatabase()!=null){
					System.out.println(database);
					request.setAttribute("database", database);
					request.getRequestDispatcher("/jsps/database/database_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Database not found");
			request.getRequestDispatcher("/jsps/database/database_read_output.jsp").forward(request, response);
		}
	}
}



