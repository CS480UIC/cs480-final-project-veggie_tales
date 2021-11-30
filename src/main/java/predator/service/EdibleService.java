package edible.service;

import edible.dao.EdibleDao;
import edible.domain.Edible;

/**
 * logic functions such as register, login
 * 
 * @author Aayush Makharia
 *
 */
public class EdibleService {
	private EdibleDao edibleDao = new EdibleDao();

	/**
	 * register a Edible
	 * 
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public void create(Edible form)
			throws EdibleException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// check the primary key of Edible
		Edible edible = edibleDao.findByCrop(form.getCrop());
		if (edible.getCrop() != null && edible.getCrop().equals(form.getCrop()))
			throw new EdibleException("This crop name has been created!");
		edibleDao.add(form);
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
	public void login(Edible form)
			throws EdibleException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Edible crop = edibleDao.findByCrop(form.getCrop());
		if (crop.getCrop() == null)
			throw new EdibleException("The crop is not in the database");

		String dish = crop.getDishes();

		if (dish != null && !dish.equals(form.getDishes()))
			throw new EdibleException(" The dish does not exist");

	}
}
