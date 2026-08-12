package Modele;
import java.util.Date;

public class BonCommande {
	private int idcom;
	private Date datecom;
	private int id_c;
	
	public BonCommande(int idcom, Date datecom , int id_c) {
		super();
		this.idcom = idcom;
		this.datecom = datecom;
		this.id_c=id_c;
	}
	public int getId_c() {
		return id_c;
	}
	public void setId_c(int id_c) {
		this.id_c = id_c;
	}

	public int getIdcom() {
		return idcom;
	}
	public void setIdcom(int idcom) {
		this.idcom = idcom;
	}
	public Date getDatecom() {
		return datecom;
	}
	public void setDatecom(Date datecom) {
		this.datecom = datecom;
	}
	

}
