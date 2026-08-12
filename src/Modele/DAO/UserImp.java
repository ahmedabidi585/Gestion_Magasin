package Modele.DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connexion.Singleton;
import Modele.User;

public class UserImp implements UserDao {
	private Connection getConnection() {
		return Singleton.getConnection();
	}

	@Override
	public void addUser(User user) {
		Connection connection = getConnection();
		if (connection == null) return;
		try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO user (id_u, nom_u, prenom_u, adresse_u, role_user, password_user) VALUES (?, ?, ?, ?, ?, ?)")) {
			stmt.setInt(1, user.getId());
			stmt.setString(2, user.getNom());
			stmt.setString(3, user.getPrenom());
			stmt.setString(4, user.getAdresse());
			stmt.setString(5, user.getRole());
			stmt.setInt(6, user.getPassword_user());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUserById(int userId) {
		Connection connection = getConnection();
		if (connection == null) return null;
		User user = null;
		try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user WHERE id_u = ?")) {
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt("id_u"), rs.getString("nom_u"), rs.getString("prenom_u"), rs.getString("adresse_u"), rs.getString("role_user"), rs.getInt("password_user"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<>();
		Connection connection = getConnection();
		if (connection == null) return users;
		try (Statement stmt = connection.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM user");
			while (rs.next()) {
				User user = new User(rs.getInt("id_u"), rs.getString("nom_u"), rs.getString("prenom_u"), rs.getString("adresse_u"), rs.getString("role_user"), rs.getInt("password_user"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public void updateUser(int id, String nom, String prenom, String adresse, String role, int password_user) {
		Connection connection = getConnection();
		if (connection == null) return;
		try (PreparedStatement stmt = connection.prepareStatement("UPDATE user SET nom_u = ?, prenom_u = ?, adresse_u = ?, role_user = ?, password_user = ? WHERE id_u = ?")) {
			stmt.setString(1, nom);
			stmt.setString(2, prenom);
			stmt.setString(3, adresse);
			stmt.setString(4, role);
			stmt.setInt(5, password_user);
			stmt.setInt(6, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int userId) {
		Connection connection = getConnection();
		if (connection == null) return;
		try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM user WHERE id_u = ?")) {
			stmt.setInt(1, userId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}



