package season.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import season.domain.Season;

/**
 * DDL functions performed in database
 */
public class SeasonDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "veggie_tales"; //TODO change user
	
	/**
	 * temperature of your season to connect to the database
	 */
	private String MySQL_password = "passw"; //TODO change temperature

	public Season findBySeason(String seasonString) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Season season = new Season();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user, MySQL_password);
		    String sql = "select * from season where season=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,seasonString);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String user_name = resultSet.getString("season");
		    	if(user_name.equals(seasonString)){
		    		season.setSeason(resultSet.getString("season"));
		    		season.setTemperature(resultSet.getString("temperature"));
		    		season.setDuration(resultSet.getString("duration"));		
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return season;
	}	
	
	/**
	 * insert Season
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Season form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user, MySQL_password);
			
			String sql = "insert into season values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getSeason());
		    preparestatement.setString(2,form.getTemperature());
		    preparestatement.setString(3,form.getDuration());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(Season form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user, MySQL_password);
			
			String sql = "UPDATE season SET temperature = ?, duration = ? where season = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getTemperature());
			preparestatement.setString(2,form.getDuration());
		    preparestatement.setString(3,form.getSeason());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param season
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String season) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user, MySQL_password);
			
			String sql = "delete from season where season = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,season);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
