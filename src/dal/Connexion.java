package dal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connexion {
	private static Connection cnx = null;

	
	public static Connection getCnx() {
		if (cnx == null) {
			Properties properties = new Properties();
			// je viens linker le fichier de config
			try {
				properties.load(Connexion.class.getResourceAsStream("config.properties"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String psw =properties.getProperty("psw");
			
			try {
				cnx = DriverManager.getConnection(url,user,psw);
			} catch (SQLException e) {
				System.out.println("Connexion win failed");
				try {
					properties.load(Connexion.class.getResourceAsStream("config_mac.properties"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				url = properties.getProperty("url");
				user = properties.getProperty("user");
				psw =properties.getProperty("psw");
				
				try {
					cnx = DriverManager.getConnection(url,user,psw);
					System.out.println("Connexion Mac success");

				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return cnx;
	}
	
	public static void deconnexion(Connection c) {
		try {
			c.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
