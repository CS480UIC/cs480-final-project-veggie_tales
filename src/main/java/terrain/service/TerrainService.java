package terrain.service;

import terrain.dao.TerrainDao;
import terrain.domain.Terrain;

/**
 * logic functions such as register, login
 * 
 * @author Aayush Makharia
 *
 */
public class TerrainService {
	private TerrainDao terrainDao = new TerrainDao();

	/**
	 * register a Terrain
	 * 
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public void create(Terrain form)
			throws TerrainException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// check the primary key of Edible
		Terrain terrain = terrainDao.findByterraintype(form.getTerraintype());
		if (terrain.getTerraintype() != null && terrain.getTerraintype().equals(form.getTerraintype()))
			throw new TerrainException("This terrain_type name has been created!");
		terrainDao.add(form);
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
	public void login(Terrain form)
			throws TerrainException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Terrain terrain_type = terrainDao.findByterraintype(form.getTerraintype());
		if (terrain_type.getTerraintype() == null)
			throw new TerrainException("The crop is not in the database");

		String minerals = terrain_type.getMinerals();

		if (minerals != null && !minerals.equals(form.getMinerals()))
			throw new TerrainException(" The Minerals do not exist");

	}
}
