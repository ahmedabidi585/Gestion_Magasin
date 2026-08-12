package Modele;

public class LigneAchat {
	private int idachat;
	private int idart;
	private int qte;
	public LigneAchat(int idachat, int idart, int qte) {
		super();
		this.idachat = idachat;
		this.idart = idart;
		this.qte = qte;
	}
	public int getIdachat() {
		return idachat;
	}
	public void setIdachat(int idachat) {
		this.idachat = idachat;
	}
	public int getIdart() {
		return idart;
	}
	public void setIdart(int idart) {
		this.idart = idart;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	
	

}
