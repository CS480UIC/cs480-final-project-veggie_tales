package visitor_location.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import java.util.ArrayList;
//import java.util.List;

import visitor_location.domain.VisitorLocation;

/**
 * DDL functions performed in database
 */
public class VisitorLocationDao {

	/**
	 * user name to connect to the database
	 */
	private String MySQL_user = "veggie_tales";

	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "passw";

	public VisitorLocation findByZip(String zip_code)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		VisitorLocation vl = new VisitorLocation();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);
			String sql = "select * from visitor_location where zip_code=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, zip_code);
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				String user_name = resultSet.getString("zip_code");
				if (user_name.equals(zip_code)) {
					vl.setZip(resultSet.getString("zip_code"));
					vl.setContinent(resultSet.getString("continent"));
					vl.setCountry(resultSet.getString("country"));
					vl.setCity(resultSet.getString("city"));
					vl.setClimate(resultSet.getString("climate"));
					vl.setTerrain(resultSet.getString("terrain"));
				}
			}
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return vl;
	}

	/**
	 * insert Entity1
	 * 
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */

	public void add(VisitorLocation form)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);

			String sql = "insert into visitor_location values(?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, form.getZip());
			preparestatement.setString(2, form.getContinent());
			preparestatement.setString(3, form.getCountry());
			preparestatement.setString(4, form.getCity());
			preparestatement.setString(5, form.getClimate());
			preparestatement.setString(6, form.getTerrain());
			preparestatement.executeUpdate();
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(VisitorLocation form)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);
			String sql = null;
			PreparedStatement preparestatement = null;
			
			sql = "SET FOREIGN_KEY_CHECKS = 0;";
			preparestatement = connect.prepareStatement(sql);
			preparestatement.executeUpdate();
			System.out.println(sql);
			
			sql = "UPDATE visitor_location SET continent = ?, country = ?, city = ?, climate = ?, terrain = ? where zip_code = ?;";
			System.out.println(sql);
			
			preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, form.getContinent());
			preparestatement.setString(2, form.getCountry());
			preparestatement.setString(3, form.getCity());
			preparestatement.setString(4, form.getClimate());
			preparestatement.setString(5, form.getTerrain());
			preparestatement.setString(6, form.getZip());
			System.out.println(preparestatement);
			preparestatement.executeUpdate();
			
			
			sql = "SET FOREIGN_KEY_CHECKS = 1;";
			preparestatement = connect.prepareStatement(sql);
			preparestatement.executeUpdate();
			System.out.println(sql);
			
			connect.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param username
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String zip_code) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TO-DO: zip_code is always coming in as null, must debug
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);
			System.out.println(zip_code);
			
			String sql = "SET FOREIGN_KEY_CHECKS = 0;";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			System.out.println(preparestatement);
			preparestatement.executeUpdate();
			
			sql = "delete from visitor_location where zip_code = ?;";
			
			preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, zip_code);
			System.out.println(preparestatement);
			preparestatement.executeUpdate();
			
			sql = "SET FOREIGN_KEY_CHECKS = 1;";
			preparestatement = connect.prepareStatement(sql);
			System.out.println(preparestatement);
			preparestatement.executeUpdate();
			
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
