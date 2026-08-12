package Modele.DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Connexion.Singleton;
import Modele.BonCommande;

public class BonCommandeImp implements BonCommandeDao{

	private Connection connection=Singleton.getConnection();


	    @Override
	    public void addBonCommande(BonCommande bonCommande) {
	        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO boncommande (idcom, datecom, id_c) VALUES (?, ?, ?)")) {
	            stmt.setInt(1, bonCommande.getIdcom());
	            stmt.setDate(2, new java.sql.Date(bonCommande.getDatecom().getTime()));
	            stmt.setInt(3, bonCommande.getId_c());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public BonCommande getBonCommandeById(int bonCommandeId) {
	        BonCommande bonCommande = null;
	        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM boncommande WHERE idcom = ?")) {
	            stmt.setInt(1, bonCommandeId);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                bonCommande = new BonCommande(rs.getInt("idcom"), rs.getDate("datecom"), rs.getInt("id_c"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return bonCommande;
	    }

	    @Override
	    public ArrayList<BonCommande> getAllBonCommandes() {
	        ArrayList<BonCommande> bonCommandes = new ArrayList<>();
	        try (Statement stmt = connection.createStatement()) {
	            ResultSet rs = stmt.executeQuery("SELECT * FROM boncommande");
	            while (rs.next()) {
	                BonCommande bonCommande = new BonCommande(rs.getInt("idcom"), rs.getDate("datecom"), rs.getInt("id_c"));
	                bonCommandes.add(bonCommande);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return bonCommandes;
	    }

	    @Override
	    public void updateBonCommande(int idcom , Date date , int id_c ) {
	        try (PreparedStatement stmt = connection.prepareStatement("UPDATE boncommande SET datecom = ?, id_c = ? WHERE idcom = ?")) {
	            stmt.setDate(1,new java.sql.Date(date.getTime()));
	            stmt.setInt(2, id_c);
	            stmt.setInt(3, idcom);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteBonCommande(int bonCommandeId) {
	        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM boncommande WHERE idcom = ?")) {
	            stmt.setInt(1, bonCommandeId);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}



