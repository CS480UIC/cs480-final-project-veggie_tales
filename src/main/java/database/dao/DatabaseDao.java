package database.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import java.util.ArrayList;
//import java.util.List;

import database.domain.Database;

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

			String sql = "alter table plant add dummy int";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			System.out.println(preparestatement);
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
	 * Let this be the command that handles the simple query
	 */
	public void update(Database form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);

			String sql = "UPDATE database SET name = ?, vore_type = ? where database = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
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
	
	/**
	 * The simple sql query
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void simple() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/veggietales_db", MySQL_user,
					MySQL_password);

			String sql = "alter table plant drop column dummy;";	//	change this to an aggregate function, then run it
			PreparedStatement preparestatement = connect.prepareStatement(sql);
//			preparestatement.setString(1, database);
			System.out.println(preparestatement);
			preparestatement.executeUpdate();
			connect.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * The complex sql query
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void complex() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
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
}
