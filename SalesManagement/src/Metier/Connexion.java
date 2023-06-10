package Metier;


import java.sql.DriverManager;
import java.sql.Connection;
public class Connexion {
	private static Connection connection; 
	static{
		try {            
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_des_ventes", "root", "");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	// méthode getConnection
	public static Connection getConnection(){
		return connection;
	}
}
