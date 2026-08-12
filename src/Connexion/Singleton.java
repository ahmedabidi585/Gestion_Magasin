package Connexion;

import java.sql.*;

public class Singleton {
	
	public Connection con;
	Statement stm;
	
	Singleton(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_stock","root","");
			stm=con.createStatement();
			if(con.isClosed())
			{
				System.out.println("y");
			}
			else {
				System.out.println("n");
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	public static void main(String []args) {
		new Singleton();
	}
	public static Connection getConnection() {
	    Connection con = null;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_stock","root","");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return con;
	}


}
