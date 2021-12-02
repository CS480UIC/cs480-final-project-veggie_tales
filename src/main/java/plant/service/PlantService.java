package plant.service;

import plant.dao.PlantDao;
import plant.domain.Plant;

/**
 * logic functions such as register, login
 * 
 * @author Aayush Makharia
 *
 */
public class PlantService {
	private PlantDao plantDao = new PlantDao();

	/**
	 * register a Edible
	 * 
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public void create(Plant form)
			throws PlantException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// check the primary key of Edible
		Plant plant = plantDao.findByPlantName(form.getPlantName());
		if (plant.getPlantName() != null && plant.getPlantName().equals(form.getPlantName()))
			throw new PlantException("This plant_name name has been created!");
		plantDao.add(form);
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
	public void login(Plant form)
			throws PlantException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Plant plant_name = plantDao.findByPlantName(form.getPlantName());
		if (plant_name.getPlantName() == null)
			throw new PlantException("The plant is not in the database");

		String classification = plant_name.getClassification();

		if (classification != null && !classification.equals(form.getClassification()))
			throw new PlantException(" The plant does not exist");

	}
}
