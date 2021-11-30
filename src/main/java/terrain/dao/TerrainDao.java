package terrain.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import java.util.ArrayList;
//import java.util.List;

import terrain.domain.Terrain;

/**
 * DDL functions performed in database
 */
public class TerrainDao {

	/**
	 * user name to connect to the database
	 */
	private String MySQL_user = "veggie_tales"; 

	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "passw"; 

	public Terrain findByterraintype(String terrain_type)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Terrain terrain = new Terrain();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);
			String sql = "select * from terrain where terrain_type=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, terrain_type);
			ResultSet resultSet = preparestatement.executeQuery();

			while (resultSet.next()) {
				String terrain_name = resultSet.getString("terrain_type");
				if (terrain_name.equals(terrain_type)) {
					terrain.setTerraintype(resultSet.getString("terrain_type"));
					terrain.setMinerals(resultSet.getString("minerals"));
					terrain.setSoil(resultSet.getString("soil"));
					terrain.setFertilizer(resultSet.getString("fertilizer"));
				}
			}
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return terrain;
	}

	/**
	 * insert Terrain
	 * 
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */

	public void add(Terrain form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);

			String sql = "insert into terrain values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, form.getTerraintype());
			preparestatement.setString(2, form.getMinerals());
			preparestatement.setString(3, form.getSoil());
			preparestatement.setString(4, form.getFertilizer());
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
	public void update(Terrain form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);

			String sql = "UPDATE terrain SET minerals = ?, soil = ? , fertilizer = ?, where terrain_type = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, form.getMinerals());
			preparestatement.setString(2, form.getSoil());
			preparestatement.setString(3, form.getFertilizer());
			preparestatement.setString(4, form.getTerraintype());
			System.out.println(preparestatement);
			preparestatement.executeUpdate();
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param terrain_type
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String terrain_type)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);

			String sql = "delete from edible where terrain_type = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1, terrain_type);
			preparestatement.executeUpdate();
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
