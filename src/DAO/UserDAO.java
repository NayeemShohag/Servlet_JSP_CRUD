package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO {

	String dbURL = "jdbc:mysql://localhost:3306/demo";
	String username = "root";
	String password = "My1234";

	private static final String INSERT_USERS_SQL = "INSERT INTO users(name,card, email, country) VALUES(?,?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select id,name,card,email,country from users where id =?";
	private static final String SELECT_ALL_USERS = "select * from users";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_USERS_SQL = "update users set name = ?,card=?,email= ?, country =? where id = ?;";

	protected Connection getconnection() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbURL, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

	public List<User> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate
		// code)
		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection connection = getconnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection
					.prepareStatement(SELECT_ALL_USERS);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String card = rs.getString("card");
				String email = rs.getString("email");
				String country = rs.getString("country");
				users.add(new User(id, name, card, email, country));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public void insertUser(User user) throws SQLException {
		// System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getconnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getCard());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getCountry());
			//preparedStatement.setInt(4, user.getId());
			// System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User selectUser(int id) {
		User user = null;
		try (Connection connection = getconnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(SELECT_USER_BY_ID)) {
			preparedStatement.setInt(1, id);
			// System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				String card = rs.getString("card");
				String email = rs.getString("email");
				String country = rs.getString("country");
				user = new User(id, name,card, email, country);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
	
		try{
			Connection connection = getconnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getCard());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4,user.getCountry());
			preparedStatement.setInt(5, user.getId());
			System.out.println(preparedStatement);
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		try{
			Connection connection= getconnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}
