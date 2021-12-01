package predator.service;

import predator.dao.PredatorDao;
import predator.domain.Predator;

/**
 * logic functions such as register, login
 * 
 * @author Aayush Makharia
 *
 */
public class PredatorService {
	private PredatorDao predatorDao = new PredatorDao();

	/**
	 * register a Predator
	 * 
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public void create(Predator form)
			throws PredatorException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// check the primary key of Predator
		Predator predator = predatorDao.findBySpecies(form.getSpecies());
		if (predator.getSpecies() != null && predator.getSpecies().equals(form.getSpecies()))
			throw new PredatorException("This species name has been created!");
		predatorDao.add(form);
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
	public void login(Predator form)
			throws PredatorException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Predator crop = predatorDao.findBySpecies(form.getSpecies());
		if (crop.getSpecies() == null)
			throw new PredatorException("The species is not in the database");
//
//		String dish = crop.getDishes();
//
//		if (dish != null && !dish.equals(form.getDishes()))
//			throw new PredatorException(" The dish does not exist");

	}
}
