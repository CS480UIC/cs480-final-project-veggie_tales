package season.service;


import season.dao.SeasonDao;
import season.domain.Season;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class SeasonService {
	private SeasonDao seasonDao = new SeasonDao();
	
	/**
	 * register a Season
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Season form) throws SeasonException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Season
		Season season = seasonDao.findBySeason(form.getSeason());
		if(season.getSeason()!=null && season.getSeason().equals(form.getSeason())) throw new SeasonException("This season already exists!");
		seasonDao.add(form);
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
	public void login(Season form) throws SeasonException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Season season = seasonDao.findBySeason(form.getSeason());
		if(season.getSeason()==null) throw new SeasonException("The season is not in the database");
		
		// String password = user.getPassword();
		// if(password!=null && !password.equals(form.getPassword()))
		// 	throw new SeasonException(" The password is not right");
		
	}
}
