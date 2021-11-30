package photo.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import photo.dao.PhotoDao;
import photo.domain.Photo;

/**
 * Servlet implementation class UserServlet
 */

public class PhotoServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PhotoServletUpdate() {
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
		PhotoDao photodao = new PhotoDao();
		Photo photo = null;

		if (method.equals("search")) {
			try {
				photo = photodao.findById(request.getParameter("photo_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if (photo.getPhotoId() != null) {
				request.setAttribute("photo", photo);
				request.getRequestDispatcher("/jsps/photo/photo_update_output.jsp").forward(request, response);

			} else {
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/photo/photo_read_output.jsp").forward(request, response);
			}
		} else if (method.equals("update")) {
			Map<String, String[]> paramMap = request.getParameterMap();
			Photo form = new Photo();
			List<String> info = new ArrayList<String>();

			for (String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setDateTaken(info.get(2));
			form.setPhotoDir(info.get(3));
			form.setPhotoId(request.getParameter("photo_id"));
			// System.out.println(info.get(0));
			// System.out.println(info.get(2));
			// System.out.println(info.get(3));
			try {
				photodao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Updated");
			request.getRequestDispatcher("/jsps/photo/photo_read_output.jsp").forward(request, response);
		}
	}
}
