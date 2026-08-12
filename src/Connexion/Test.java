package Connexion;

import java.sql.Connection;

public class Test {
	


    public static void main(String[] args) {
    	
        Connection connection = Singleton.getConnection();
        if (connection != null) {
            System.out.println("La connexion a réussi !");
        } else {
            System.out.println("La connexion a échoué.");
        }
        
    }}

 
