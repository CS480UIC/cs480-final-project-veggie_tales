package climate.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import java.util.ArrayList;
//import java.util.List;

import climate.domain.Climate;

/**
 * DDL functions performed in database
 */
public class ClimateDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "veggie_tales"; 
	
	/**
	 * rainfall of your climate to connect to the database
	 */
	private String MySQL_password = "passw"; 

	public Climate findByClimate(String climateString) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Climate climate = new Climate();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user, MySQL_password);
		    String sql = "select * from climate where climate=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,climateString);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String user_name = resultSet.getString("climate");
		    	if(user_name.equals(climateString)){
		    		climate.setClimate(resultSet.getString("climate"));
		    		climate.setRainfall(resultSet.getString("rainfall"));
		    		climate.setHumidity(resultSet.getString("email"));		
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return climate;
	}	
	
	/**
	 * insert Climate
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Climate form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user, MySQL_password);
			
			String sql = "insert into climate values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getClimate());
		    preparestatement.setString(2,form.getRainfall());
		    preparestatement.setString(3,form.getHumidity());
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
	public void update(Climate form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user, MySQL_password);
			
			String sql = "UPDATE climate SET rainfall = ?, humidity = ? where climate = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getRainfall());
			preparestatement.setString(2,form.getHumidity());
		    preparestatement.setString(3,form.getClimate());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param climate
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String climate) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user, MySQL_password);
			
			String sql = "delete from climate where climate = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,climate);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
