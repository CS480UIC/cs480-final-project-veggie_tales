package photo.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import photo.dao.PhotoDao;
import photo.domain.Photo;

/**
 * Servlet implementation class UserServlet
 */

public class PhotoServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PhotoServletDelete() {
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
		PhotoDao photoDao = new PhotoDao();
		Photo photo = null;
		if (method.equals("search")) {
			try {
				photo = photoDao.findById(request.getParameter("photo_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if (photo.getPhotoId() != null) {
				System.out.println(photo);
				request.setAttribute("photo", photo);
				request.getRequestDispatcher("/jsps/photo/photo_delete_output.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/photo/photo_read_output.jsp").forward(request, response);
			}
		} else if (method.equals("delete")) {
			try {
				photoDao.delete(Integer.parseInt(request.getParameter("photo_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Deleted");
			request.getRequestDispatcher("/jsps/photo/photo_read_output.jsp").forward(request, response);
		}
	}
}
