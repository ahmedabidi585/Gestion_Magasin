package Modele.DAO;
import java.sql.*;
import Connexion.Singleton;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Modele.*;

public class BonAchatImp implements BonAchatDao{
	private Connection connection=Singleton.getConnection();


	    @Override
	    public void addBonAchat(BonAchat bonAchat) {
	        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO bonachat (idachat, dateachat, id_f) VALUES (?, ?, ?)")) {
	            stmt.setInt(1, bonAchat.getIdachat());
	            stmt.setDate(2, new java.sql.Date(bonAchat.getDateachat().getTime()));
	            stmt.setInt(3, bonAchat.getId_f());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public BonAchat getBonAchatById(int bonAchatId) {
	        BonAchat bonAchat = null;
	        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM bonachat WHERE idachat = ?")) {
	            stmt.setInt(1, bonAchatId);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                bonAchat = new BonAchat(rs.getInt("idachat"), rs.getDate("dateachat"), rs.getInt("id_f"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return bonAchat;
	    }

	    @Override
	    public ArrayList<BonAchat> getAllBonAchats() {
	        ArrayList<BonAchat> bonAchats = new ArrayList<>();
	        try (Statement stmt = connection.createStatement()) {
	            ResultSet rs = stmt.executeQuery("SELECT * FROM bonachat");
	            while (rs.next()) {
	                BonAchat bonAchat = new BonAchat(rs.getInt("idachat"), rs.getDate("dateachat"), rs.getInt("id_f"));
	                bonAchats.add(bonAchat);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return bonAchats;
	    }

	    @Override
	    public void updateBonAchat(int idachat, Date date , int id_f) {
	        try (PreparedStatement stmt = connection.prepareStatement("UPDATE bonachat SET dateachat = ?, id_f = ? WHERE idachat = ?")) {
	            stmt.setDate(1, new java.sql.Date(date.getTime()));
	            stmt.setInt(2,id_f);
	            stmt.setInt(3, idachat);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteBonAchat(int bonAchatId) {
	        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM bonachat WHERE idachat = ?")) {
	            stmt.setInt(1, bonAchatId);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}



