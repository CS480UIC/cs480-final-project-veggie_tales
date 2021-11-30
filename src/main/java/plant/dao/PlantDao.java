package plant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import java.util.ArrayList;
//import java.util.List;

import plant.domain.Plant;

/**
 * DDL functions performed in database
 */
public class PlantDao {

	/**
	 * user name to connect to the database
	 */
	private String MySQL_user = "veggie_tales"; // TODO change user

	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "passw"; // TODO change password

	public Plant findByCrop(String plant_name)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Plant plant = new Plants();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);
			String sql = "select * from plant where plant_name=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, plant_name);
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				String plant_namer = resultSet.getString("plant_name");
				if (plant_namer.equals(plant_name)) {
					plant.setCrop(resultSet.getString("plant_name"));
					plant.setDishes(resultSet.getString("measurement"));
					plant.setAllergen(resultSet.getString("classification"));
					plant.setAllergen(resultSet.getString("growth_season"));
					plant.setAllergen(resultSet.getString("plant_discoverer"));
					plant.setAllergen(resultSet.getString("photo_id"));
					plant.setAllergen(resultSet.getString("plant_predator"));
				}
			}
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return plant;
	}

	/**
	 * insert Plant
	 * 
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */

	public void add(Planr form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);

			String sql = "insert into plant values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, form.getPlant_name());
			preparestatement.setString(2, form.getMeasurement());
			preparestatement.setString(3, form.getClassification());
			preparestatement.setString(4, form.getGrowthseason());
			preparestatement.setString(5, form.getPlantdiscoverer());
			preparestatement.setString(6, form.getPhotoId);
			preparestatement.setString(7, form.getPlantpredator());
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
	public void update(Plant form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);

			String sql = "UPDATE plant SET measurement = ?, classification = ?, growth_season = ?, plant_discoverer = ?, photo_id= ?, plant_predator = ?, where plant_name = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, form.getMeasurement());
			preparestatement.setString(2, form.getClassification());
			preparestatement.setString(3, form.getGrowthseason());
			preparestatement.setString(4, form.getPlantdiscoverer());
			preparestatement.setString(5, form.getPhotoId);
			preparestatement.setString(6, form.getPlantpredator());
			preparestatement.setString(7, form.getPlant_name());
			System.out.println(preparestatement);
			preparestatement.executeUpdate();
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param plant_name
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String plant_name)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);

			String sql = "delete from plant where plant_name = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, plant_name);
			preparestatement.executeUpdate();
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
