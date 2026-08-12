package Modele.DAO;
import Modele.LigneCommande;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Connexion.Singleton;

public class LigneCommandeImp implements LigneCommandeDao {

    private Connection connection=Singleton.getConnection();


    @Override
    public void addLigneCommande(LigneCommande ligneCommande) {
        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO lignecommande (idcom, idart, qte) VALUES (?, ?, ?)")) {
            stmt.setInt(1, ligneCommande.getIdcom());
            stmt.setInt(2, ligneCommande.getIdart());
            stmt.setInt(3, ligneCommande.getQte());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public LigneCommande getLigneCommandeById(int commandeId) {
        LigneCommande ligneCommande = null;
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM lignecommande WHERE idcom = ?")) {
            stmt.setInt(1, commandeId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                 ligneCommande = new LigneCommande(rs.getInt("idart"), rs.getInt("idcom"), rs.getInt("qte"));
 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ligneCommande;
    }

    @Override
    public void deleteLigneCommandeById(int commandeId) {
        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM lignecommande WHERE idcom = ?")) {
            stmt.setInt(1, commandeId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public ArrayList<LigneCommande> getAllLigneCommande() {
        ArrayList<LigneCommande> lignesCommande = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM lignecommande");
            while (rs.next()) {
                LigneCommande ligneCommande = new LigneCommande(rs.getInt("idcom"), rs.getInt("idart"), rs.getInt("qte"));
                lignesCommande.add(ligneCommande);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lignesCommande;
    }
    @Override
    public void updateLigneCommande(int idcom,int idart,int qte) {
        try (PreparedStatement stmt = connection.prepareStatement("UPDATE lignecommande SET  qte = ? WHERE idcom = ? and idart = ?")) {
            stmt.setInt(1,qte);
            stmt.setInt(2,idcom);
            stmt.setInt(3, idart);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



