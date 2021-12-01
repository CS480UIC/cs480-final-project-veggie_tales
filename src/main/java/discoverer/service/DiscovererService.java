package discoverer.service;

import discoverer.dao.DiscovererDao;
import discoverer.domain.Discoverer;

/**
 * logic functions such as register, login
 * 
 * @author Aayush Makharia
 *
 */
public class DiscovererService {
	private DiscovererDao discovererDao = new DiscovererDao();

	/**
	 * register a Edible
	 * 
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public void create(Discoverer form)
			throws DiscovererException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// check the primary key of Edible
		Discoverer discoverer = discovererDao.findByName(form.getDiscovererName());
		if (discoverer.getDiscovererName() != null && discoverer.getDiscovererName().equals(form.getDiscovererName()))
			throw new DiscovererException("This discoverer has been created!");
		discovererDao.add(form);
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
	public void login(Discoverer form)
			throws DiscovererException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Discoverer discoverer= discovererDao.findByName(form.getDiscovererName());
		if (discoverer.getDiscovererName() == null)
			throw new DiscovererException("The discoverer is not in the database");
//		is there a need to look up the secondary key?
//		String dish = crop.getDishes();
//
//		if (dish != null && !dish.equals(form.getDishes()))
//			throw new DiscovererException(" The dish does not exist");

	}
}
