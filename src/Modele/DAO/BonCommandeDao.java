package Modele.DAO;
import java.util.Date;
import java.util.List;
import Modele.BonCommande;

public interface BonCommandeDao {
    void addBonCommande(BonCommande bonCommande);
    BonCommande getBonCommandeById(int id);
    List<BonCommande> getAllBonCommandes();
    void updateBonCommande(int idcom , Date date , int id_c);
    void deleteBonCommande(int id);

}
