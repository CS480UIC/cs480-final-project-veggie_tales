package climate.service;


import climate.dao.ClimateDao;
import climate.domain.Climate;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class ClimateService {
	private ClimateDao climateDao = new ClimateDao();
	
	/**
	 * register a Climate
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Climate form) throws ClimateException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Climate
		Climate climate = climateDao.findByClimate(form.getClimate());
		if(climate.getClimate()!=null && climate.getClimate().equals(form.getClimate())) throw new ClimateException("This climate already exists!");
		climateDao.add(form);
	}
	/**
	 * Login function
	 * @param form
	 * @return
	 * @throws UserException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void login(Climate form) throws ClimateException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Climate climate = climateDao.findByClimate(form.getClimate());
		if(climate.getClimate()==null) throw new ClimateException("The climate is not in the database");
		// String rainfall = climate.getRainfall();
		// if(rainfall!=null && !rainfall.equals(form.getRainfall()))
		// 	throw new ClimateException(" The rainfall is not right");
	}
}
