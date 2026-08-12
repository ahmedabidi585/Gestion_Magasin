package Modele.DAO;
import java.util.Date;
import java.util.List;
import Modele.BonAchat;

public interface BonAchatDao {
    void addBonAchat(BonAchat bonAchat);
    BonAchat getBonAchatById(int bonAchatId);
    List<BonAchat> getAllBonAchats();
    void updateBonAchat(int idachat, Date date , int id_f);
    void deleteBonAchat(int bonAchatId);

}
