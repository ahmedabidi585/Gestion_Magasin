package Modele.DAO;
import Modele.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connexion.Singleton;

public class FournisseurImp implements FournissuerDao{

	 private Connection connection=Singleton.getConnection();;
	
	    @Override
	    public void addFournisseur(Fournisseur fournisseur) {
	        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO fournisseur (id_f, nom_f, prenom_f, adresse_f, matricule_f, tel_f) VALUES (?, ?, ?, ?, ?, ?)")) {
	            stmt.setInt(1, fournisseur.getId());
	            stmt.setString(2, fournisseur.getNom());
	            stmt.setString(3, fournisseur.getPrenom());
	            stmt.setString(4, fournisseur.getAdresse());
	            stmt.setInt(5, fournisseur.getMatricule());
	            stmt.setInt(6, fournisseur.getTel());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public Fournisseur getFournisseurById(int fournisseurId) {
	        Fournisseur fournisseur = null;
	        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM fournisseur WHERE id_f = ?")) {
	            stmt.setInt(1, fournisseurId);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                fournisseur = new Fournisseur(rs.getInt("id_f"), rs.getString("nom_f"), rs.getString("prenom_f"), rs.getString("adresse_f"), rs.getInt("matricule_f"), rs.getInt("tel_f"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return fournisseur;
	    }

	    @Override
	    public ArrayList<Fournisseur> getAllFournisseurs() {
	        ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
	        try (Statement stmt = connection.createStatement()) {
	            ResultSet rs = stmt.executeQuery("SELECT * FROM fournisseur");
	            while (rs.next()) {
	                Fournisseur fournisseur = new Fournisseur(rs.getInt("id_f"), rs.getString("nom_f"), rs.getString("prenom_f"), rs.getString("adresse_f"), rs.getInt("matricule_f"), rs.getInt("tel_f"));
	                fournisseurs.add(fournisseur);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return fournisseurs;
	    }

	    @Override
	    public void updateFournisseur(int id_f ,String nom_f,String prenom_f,String adresse_f,int matricule,int tel_f) {
	        try (PreparedStatement stmt = connection.prepareStatement("UPDATE fournisseur SET nom_f = ?, prenom_f = ?, adresse_f = ?, matricule_f = ?, tel_f = ? WHERE id_f = ?")) {
	            stmt.setString(1, nom_f);
	            stmt.setString(2,prenom_f);
	            stmt.setString(3,adresse_f);
	            stmt.setInt(4,matricule);
	            stmt.setInt(5,tel_f);
	            stmt.setInt(6,id_f);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


	    @Override
	    public void deleteFournisseur(int fournisseurId) {
	        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM fournisseur WHERE id_f = ?")) {
	            stmt.setInt(1, fournisseurId);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}



