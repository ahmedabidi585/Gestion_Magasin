package Modele.DAO;

import Modele.*;

import java.util.List;

public interface UserDao {
    // Méthodes CRUD pour l'entité User
    void addUser(User user);
    User getUserById(int userId);
    List<User> getAllUsers();
    void updateUser(int id, String nom, String prenom, String adresse, String role, int password_user);
    void deleteUser(int userId);
}