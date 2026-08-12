package Modele.DAO;
import java.util.List;
import Modele.Client;

public interface ClientDao {
    void addClient(Client client);
    Client getClientById(int clientId);
    List<Client> getAllClients();
    void updateClient(int id , String nom , String prenom , String adresse , int tel);
    void deleteClient(int clientId);

}
