package Modele.DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connexion.Singleton;
import Modele.Client;
public class ClientImp implements ClientDao{

	 private Connection connection=Singleton.getConnection();;


	    @Override
	    public void addClient(Client client) {
	        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO client (id_c, nom_c, prenom_c, adresse_c, tel_c) VALUES (?, ?, ?, ?, ?)")) {
	            stmt.setInt(1, client.getId());
	            stmt.setString(2, client.getNom());
	            stmt.setString(3, client.getPrenom());
	            stmt.setString(4, client.getAdresse());
	            stmt.setInt(5, client.getTel());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public Client getClientById(int clientId) {
	        Client client = null;
	        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM client WHERE id_c = ?")) {
	            stmt.setInt(1, clientId);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                client = new Client(rs.getInt("id_c"), rs.getString("nom_c"), rs.getString("prenom_c"), rs.getString("adresse_c"), rs.getInt("tel_c"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return client;
	    }

	    @Override
	    public ArrayList<Client> getAllClients() {
	        ArrayList<Client> clients = new ArrayList<>();
	        try (Statement stmt = connection.createStatement()) {
	            ResultSet rs = stmt.executeQuery("SELECT * FROM client");
	            while (rs.next()) {
	                Client client = new Client(rs.getInt("id_c"), rs.getString("nom_c"), rs.getString("prenom_c"), rs.getString("adresse_c"), rs.getInt("tel_c"));
	                clients.add(client);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return clients;
	    }

	    @Override
	    public void updateClient(int id , String nom , String prenom , String adresse , int tel ) {
	        try (PreparedStatement stmt = connection.prepareStatement("UPDATE client SET nom_c = ?, prenom_c = ?, adresse_c = ?, tel_c = ? WHERE id_c = ?")) {
	            stmt.setString(1, nom);
	            stmt.setString(2, prenom);
	            stmt.setString(3, adresse);
	            stmt.setInt(4, tel);
	            stmt.setInt(5, id);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteClient(int clientId) {
	        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM client WHERE id_c = ?")) {
	            stmt.setInt(1, clientId);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}



