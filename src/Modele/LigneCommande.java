package Modele;

public class LigneCommande {
	private int idart;
	private int idcom;
	private int qte;
	public LigneCommande(int idcom,int idart,  int qte) {
		super();
		this.idart = idart;
		this.idcom = idcom;
		this.qte = qte;
	}
	public int getIdart() {
		return idart;
	}
	public void setIdart(int idart) {
		this.idart = idart;
	}
	public int getIdcom() {
		return idcom;
	}
	public void setIdcom(int idcom) {
		this.idcom = idcom;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	

}
