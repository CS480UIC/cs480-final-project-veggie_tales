package predator.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import java.util.ArrayList;
//import java.util.List;

import predator.domain.Predator;

/**
 * DDL functions performed in database
 */
public class PredatorDao {

	/**
	 * user name to connect to the database
	 */
	private String MySQL_user = "veggie_tales"; // TODO change user

	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "passw"; // TODO change password

	public Predator findBySpecies(String species)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Predator predator = new Predator();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);
			String sql = "select * from predator where species=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, species);
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				String species_name = resultSet.getString("species");
				if (species_name.equals(species)) {
					predator.setSpecies(resultSet.getString("species"));
					predator.setName(resultSet.getString("name"));
					predator.setVoreType(resultSet.getString("vore_type"));
				}
			}
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return predator;
	}

	/**
	 * insert Predator
	 * 
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */

	public void add(Predator form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);

			String sql = "insert into predator values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, form.getSpecies());
			preparestatement.setString(2, form.getName());
			preparestatement.setString(3, form.getVoreType());
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
	public void update(Predator form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);

			String sql = "UPDATE predator SET name = ?, vore_type = ? where species = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, form.getName());
			preparestatement.setString(2, form.getVoreType());
			preparestatement.setString(3, form.getSpecies());
			System.out.println(preparestatement);
			preparestatement.executeUpdate();
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param crop
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String species) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);

			String sql = "delete from predator where species = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, species);
			preparestatement.executeUpdate();
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
