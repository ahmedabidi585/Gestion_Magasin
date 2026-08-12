package Modele;

public class Fournisseur extends Personne {

	private int tel ;
	private int matricule ;
	public Fournisseur(int id, String nom, String prenom, String adresse, int matricule,int tel) {
		super(id, nom, prenom, adresse);
		this.tel = tel;
		this.matricule = matricule;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public int getMatricule() {
		return matricule;
	}
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	
}
