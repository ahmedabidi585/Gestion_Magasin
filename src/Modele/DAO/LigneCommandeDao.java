package Modele.DAO;
import java.util.List;
import Modele.LigneCommande;

public interface LigneCommandeDao {
    void addLigneCommande(LigneCommande ligneCommande);
    LigneCommande getLigneCommandeById(int id);
    List<LigneCommande> getAllLigneCommande();
    void updateLigneCommande(int idcom, int qte ,int idart);
    void deleteLigneCommandeById(int id);

}
