package database.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Hashtable;

//import java.util.ArrayList;
//import java.util.List;

import database.domain.Database;
import edible.domain.Edible;
import photo.domain.Photo;
import predator.domain.Predator;
import season.domain.Season;
import user.domain.User;

/**
 * DDL functions performed in database
 */
public class DatabaseDao {

	/**
	 * user name to connect to the database
	 */
	private String MySQL_user = "veggie_tales"; // TODO change user

	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "passw"; // TODO change password

	public Database findByDatabase(String database_string)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Database database = new Database();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);
			String sql = "select * from database where database=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, database_string);
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				String database_name = resultSet.getString("database");
				if (database_name.equals(database_string)) {
				}
			}
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return database;
	}

	/**
	 * insert Database
	 * 
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * This is where we will initialize the database
	 */

	public void add() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);
			
			Query query = new Query();
			PreparedStatement preparestatement;
			preparestatement = connect.prepareStatement(query.createTables());
			System.out.println(preparestatement);
			preparestatement.execute();
			connect.close();
			init();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}	

	/**
	 * @param crop
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * This is the command that will handle deleting the database
	 * Perhaps the delete can either count as a simple/complex query???
	 */
	public void delete() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);

//			String sql = "alter table plant drop column dummy;";
			Query query = new Query();
			PreparedStatement preparestatement = connect.prepareStatement(query.dropTables());
			System.out.println(preparestatement);
			preparestatement.executeUpdate();
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
		What are aggregate queries in SQL?
		SQL Aggregate Functions
		COUNT counts how many rows are in a particular column.
		SUM adds together all the values in a particular column.
		MIN and MAX return the lowest and highest values in a particular column, respectively.
		AVG calculates the average of a group of selected values.
	 */
	public void aggregate() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//		return;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);

			String sql = "alter table plant drop column dummy;";	//	change this to an aggregate function, then run it
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			System.out.println(preparestatement);
			preparestatement.executeUpdate();
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> findallPhotos() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user, MySQL_password);
			String sql = "call select_all_photos()";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Photo user = new Photo();
				user.setPhotoId(resultSet.getString("photo_id"));
	    		user.setDateTaken(resultSet.getString("date_taken"));
	    		user.setPhotoDir(resultSet.getString("photo_url"));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> findallPredators() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user, MySQL_password);
			String sql = "call select_all_predators()";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Predator user = new Predator();
				user.setSpecies(resultSet.getString("species"));
	    		user.setName(resultSet.getString("name"));
	    		user.setVoreType(resultSet.getString("vore_type"));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public List<Object> findallEdibles() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user, MySQL_password);
			String sql = "call select_all_edibles()";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Edible user = new Edible();
				user.setCrop(resultSet.getString("crop"));
	    		user.setDishes(resultSet.getString("dishes"));
	    		user.setAllergen(resultSet.getString("allergen"));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public List<Object> findallSeasons() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user, MySQL_password);
			String sql = "call select_all_seasons()";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Season user = new Season();
				user.setSeason(resultSet.getString("season"));
	    		user.setTemperature(resultSet.getString("temperature"));
	    		user.setDuration(resultSet.getString("duration"));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	/**
	 * The simple sql query
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void simple() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		findallPhotos();
		findallPredators();
		findallEdibles();
		findallSeasons();
	}
	
	/**
	 * The complex sql query
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void complex() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
			 findCityHumidity();
			 findPlantSeasonGrowth();
//			 findPlantTemperature();
//			 findPlantClassificationLocation();
	}
	
	public List<Object> findCityHumidity() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user, MySQL_password);
			String sql = "call veggietales_db.CityHumidity();";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();		
			while(resultSet.next()){
				Hashtable<String, String> my_dict = new Hashtable<String, String>();
				my_dict.put("rainfall", resultSet.getString("rainfall"));
				my_dict.put("city", resultSet.getString("city"));
				my_dict.put("humidity", resultSet.getString("humidity"));
	    		list.add(my_dict);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public List<Object> findPlantSeasonGrowth() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user, MySQL_password);
			String sql = "call veggietales_db.PlantSeasonGrowth();";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Hashtable<String, String> my_dict = new Hashtable<String, String>();
				my_dict.put("dishes", resultSet.getString("dishes"));
				my_dict.put("growth_season", resultSet.getString("growth_season"));
				my_dict.put("measurement", resultSet.getString("measurement"));
	    		list.add(my_dict);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public List<Object> findPlantTemperature() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user, MySQL_password);
			String sql = "call veggietales_db.PlantTemperature();";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Hashtable<String, String> my_dict = new Hashtable<String, String>();
				my_dict.put("season", resultSet.getString("season"));
				my_dict.put("temperature", resultSet.getString("temperature"));
				my_dict.put("plant_name", resultSet.getString("plant_name"));
	    		list.add(my_dict);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public List<Object> findPlantClassificationLocation() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user, MySQL_password);
			String sql = "call veggietales_db.PlantClassificationLocation();";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Hashtable<String, String> my_dict = new Hashtable<String, String>();
				my_dict.put("classification", resultSet.getString("classification"));
				my_dict.put("discovered_location", resultSet.getString("discovered_location"));
	    		list.add(my_dict);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	
	/**
	 * The initilize db
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void init() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);

			PreparedStatement preparestatement  = connect.prepareStatement("SET FOREIGN_KEY_CHECKS = 0;");
			System.out.println(preparestatement);
			preparestatement.execute();
			Query qr = new Query(); 
			ArrayList<String> arrlist = qr.initializeDatabase();
			for (int i = 0; i < arrlist.size(); i++) { 		      
				preparestatement = connect.prepareStatement(arrlist.get(i));
				preparestatement.executeUpdate();		
		    }  
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
