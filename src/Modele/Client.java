package Modele;

public class Client extends Personne{
	private int tel ;

	public Client(int id, String nom, String prenom, String adresse, int tel) {
		super(id, nom, prenom, adresse);
		this.tel = tel;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}
	



}
