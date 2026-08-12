package Modele;

public class User extends Personne {
   private String role;
   private int password_user ;
public User(int id, String nom, String prenom, String adresse, String role, int password_user) {
	super(id, nom, prenom, adresse);
	this.role = role;
	this.password_user = password_user;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public int getPassword_user() {
	return password_user;
}
public void setPassword_user(int password_user) {
	this.password_user = password_user;
}
   

	

}
