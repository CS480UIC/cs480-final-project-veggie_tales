package discoverer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import discoverer.domain.Discoverer;

//import java.util.ArrayList;
//import java.util.List;

/**
 * DDL functions performed in database
 */
public class DiscovererDao {

	/**
	 * user name to connect to the database
	 */
	private String MySQL_user = "veggie_tales"; // TODO change user

	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "passw"; // TODO change password

	public Discoverer findByName(String discoverer_name)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Discoverer  discoverer = new Discoverer();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);
			String sql = "select * from discoverer where discoverer_name=?"; // WARNING, QUERY IS WRONG
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, discoverer_name);
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				String tmp_name = resultSet.getString("discoverer_name");
				if (tmp_name.equals(discoverer_name)) {
					discoverer.setDiscovererName(resultSet.getString("discoverer_name"));
					discoverer.setDate(resultSet.getString("date"));
					discoverer.setDiscoveredLocation(resultSet.getString("discovered_location"));
				}
			}
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return discoverer;
	}

	/**
	 * insert Edible
	 * 
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */

	public void add(Discoverer form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);

			String sql = "insert into discoverer values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, form.getDiscovererName());
			preparestatement.setString(2, form.getDate());
			preparestatement.setString(3, form.getDiscoveredLocation());
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
	public void update(Discoverer form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);

			String sql = "UPDATE discoverer SET date = ?, discovered_location = ? where discoverer_name = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, form.getDate());
			preparestatement.setString(2, form.getDiscoveredLocation());
			preparestatement.setString(3, form.getDiscovererName());
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
	public void delete(String name) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);

			String sql = "delete from discoverer where discoverer_name = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, name);
			preparestatement.executeUpdate();
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
