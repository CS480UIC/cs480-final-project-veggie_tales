package database.service;

import database.dao.DatabaseDao;
import database.domain.Database;

/**
 * logic functions such as register, login
 * 
 * @author Aayush Makharia
 *
 */
public class DatabaseService {
	private DatabaseDao databaseDao = new DatabaseDao();

	/**
	 * register a Database
	 * 
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public void create(Database form)
			throws DatabaseException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		databaseDao.add();
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
	public void login(Database form)
			throws DatabaseException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Database db = databaseDao.findByDatabase(form.getDatabase());
		if (db.getDatabase() == null)
			throw new DatabaseException("The Database is not in the database...LOL!");

	}
}
