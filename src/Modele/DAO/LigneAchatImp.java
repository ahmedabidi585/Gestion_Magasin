package Modele.DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connexion.Singleton;
import Modele.LigneAchat;
public class LigneAchatImp implements LigneAchatDao {

	private Connection connection=Singleton.getConnection();;



	    @Override
	    public void addLigneAchat(LigneAchat ligneAchat) {
	        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO ligneachat (idachat, idart, qte) VALUES (?, ?, ?)")) {
	            stmt.setInt(1, ligneAchat.getIdachat());
	            stmt.setInt(2, ligneAchat.getIdart());
	            stmt.setInt(3, ligneAchat.getQte());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    @Override
	    public void updateLigneAchat(int idachat , int idart , int qte ) {
	        try (PreparedStatement stmt = connection.prepareStatement("UPDATE ligneachat SET idart = ?, qte = ? WHERE idachat = ?")) {
	            stmt.setInt(1, idart);
	            stmt.setInt(2, qte);
	            stmt.setInt(3, idachat);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    @Override
	    public ArrayList<LigneAchat> getAllLigneAchats() {
	        ArrayList<LigneAchat> lignesAchat = new ArrayList<>();
	        try (Statement stmt = connection.createStatement()) {
	            ResultSet rs = stmt.executeQuery("SELECT * FROM ligneachat");
	            while (rs.next()) {
	                LigneAchat ligneAchat = new LigneAchat(rs.getInt("idachat"), rs.getInt("idart"),  rs.getInt("qte"));
	                lignesAchat.add(ligneAchat);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return lignesAchat;
	    }

	    @Override
	    public LigneAchat getLigneAchatById(int achatId) {
	    	LigneAchat ligneachat= null;
	        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ligneachat WHERE idachat = ?")) {
	            
	        	stmt.setInt(1, achatId);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                 ligneachat = new LigneAchat(rs.getInt("idachat"), rs.getInt("idart"), rs.getInt("qte"));
	              
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	       return ligneachat ;
	    }

	    @Override
	    public void deleteLigneAchat(int achatId) {
	        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM ligneachat WHERE idachat = ?")) {
	            stmt.setInt(1, achatId);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


