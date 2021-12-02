package visitor_location.service;

import visitor_location.dao.VisitorLocationDao;
import visitor_location.domain.VisitorLocation;

/**
 * logic functions such as register, login
 * 
 * @author Aayush Makharia
 *
 */
public class VisitorLocationService {
	private VisitorLocationDao vlDao = new VisitorLocationDao();

	/**
	 * register a VisitorLocation
	 * 
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public void create(VisitorLocation form)
			throws VisitorLocationException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// check the primary key of VisitorLocation
		VisitorLocation vl = vlDao.findByZip(form.getZip());
		if (vl.getZip() != null && vl.getZip().equals(form.getZip()))
			throw new VisitorLocationException("This zip code has been used!");
		vlDao.add(form);
	}

	/**
	 * Login function
	 * 
	 * @param form
	 * @return
	 * @throws UserException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public void login(VisitorLocation form)
			throws VisitorLocationException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		VisitorLocation vl = vlDao.findByZip(form.getZip());
		if (vl.getZip() == null)
			throw new VisitorLocationException("The zip code is not in the database");

		String continent = vl.getContinent();

		if (continent != null && !continent.equals(form.getContinent()))
			throw new VisitorLocationException(" The continent is not right");

	}
}
