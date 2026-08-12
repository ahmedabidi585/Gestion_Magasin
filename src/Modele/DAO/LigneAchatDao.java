package Modele.DAO;
import java.util.List;
import Modele.LigneAchat;

public interface LigneAchatDao {
    void addLigneAchat(LigneAchat ligneAchat);
    LigneAchat getLigneAchatById(int id);
    List<LigneAchat> getAllLigneAchats();
    void updateLigneAchat(int idachat , int idart , int qte);
    void deleteLigneAchat(int id);
}
