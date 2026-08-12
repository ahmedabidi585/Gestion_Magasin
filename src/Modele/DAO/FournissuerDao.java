package Modele.DAO;
import java.util.List;
import Modele.Fournisseur;

public interface FournissuerDao {
     void addFournisseur(Fournisseur fournisseur);
    Fournisseur getFournisseurById(int fournisseurId);
    List<Fournisseur> getAllFournisseurs();
    void updateFournisseur(int id_f ,String nom_f,String prenom_f,String adresse_f,int matricule,int tel_f);
    void deleteFournisseur(int fournisseurId);

}
