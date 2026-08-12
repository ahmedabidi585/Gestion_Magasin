package Modele;
import java.util.Date;

public class BonAchat {
	private int idachat;
	private Date dateachat;
	private int id_f;
	public BonAchat(int idachat, Date dateachat,int id_f) {
		super();
		this.idachat = idachat;
		this.dateachat = dateachat;
		this.id_f=id_f;
	}
	public int getId_f() {
		return id_f;
	}
	public void setId_f(int id_f) {
		this.id_f = id_f;
	}
	public int getIdachat() {
		return idachat;
	}
	public void setIdachat(int idachat) {
		this.idachat = idachat;
	}
	public Date getDateachat() {
		return dateachat;
	}
	public void setDateachat(Date dateachat) {
		this.dateachat = dateachat;
	}
	

}
