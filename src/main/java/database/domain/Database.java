package database.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Database {
	/*
	 * Correspond to the user table
	 */
	private String database;
	
	/**
	 * @constructor
	 */
	public Database()
	{
		this.database = "veggietales_db";
	}
	/**
	 * @return the database
	 */
	public String getDatabase() {
		return database;
	}

	/**
	 * @param database_name the database_name to set
	 */
	public void setDatabase(String database_name) {
		this.database = database_name;
	}

	/**
	 * @return the date
	 */
	
	@Override
	public String toString() {
		return "User [ database_name=" + database+ "]";
	}
}
