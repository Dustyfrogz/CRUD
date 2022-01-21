package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyConnexion {
	
		static Connection accessDataBase = null;

		/**
		 * Connection to the dataBse
		 * 
		 * @throws SQLException
		 */
		public static void openConnection() {
			/* Parameters for the connection */
			String url = "jdbc:mysql://127.0.0.1/dragon2";
			String utilisateur = "root";
			String motDePasse = "";
			try {
				System.out.println("try to connect");
				// add our parameters
				accessDataBase = DriverManager.getConnection(url, utilisateur, motDePasse);
				
			} catch (SQLException ex) {
				Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		/**
		 * True if connection is OK
		 *
		 * @return
		 */
		public static boolean testConnection() {
			boolean flag = false;
			try {
				if (accessDataBase != null) {
					if (!accessDataBase.isClosed()) {
						System.out.println("Connexion au serveur... OK");
						flag = true;
					}
				}
			} catch (SQLException ex) {
				Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
			}
			return flag;
		}

		public static void closeConnection() {
			if (accessDataBase != null) {
				try {
					accessDataBase.close();
					System.out.println("Close connection");
				} catch (SQLException e) {
					System.err.println("Erreur fermreture: " + e.getMessage());
				}
			}
		}
}
