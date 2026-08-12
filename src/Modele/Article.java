package Modele;

public class Article {
	private int idart;
	private int qte;
	private String categorie;
	private double prix_unit;
	private String nom;
	public Article(int idart,  String categorie, double prix_unit, String nom ,int qte) {
		super();
		this.idart = idart;
		this.qte = qte;
		this.categorie = categorie;
		this.prix_unit = prix_unit;
		this.nom = nom;
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
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public double getPrix_unit() {
		return prix_unit;
	}
	public void setPrix_unit(double prix_unit) {
		this.prix_unit = prix_unit;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	

}
