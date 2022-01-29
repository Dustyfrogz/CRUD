package CRUD;

import java.util.ArrayList;
import java.util.Arrays;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Querydragon extends MyConnexion {
	private static int counter = 0;
	private static ArrayList<String> tab;

	static ArrayList<String> getTab() {
		return tab;
	}

	void setTab(ArrayList<String> tab) {
		Querydragon.tab = tab;
	}

	static int getCounter() {
		return counter;
	}

	static void setCounter(int counter) {
		Querydragon.counter = counter;
	}

	

	/**
	 * read all the dragon in the list
	 */
	public static void readAll() {
		try {
			String query = "SELECT id_dragon,dragon FROM dragons;";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			ResultSet resultat = declaration.executeQuery(query);
			/* Récupération des données */
			while (resultat.next()) {
				Object[] row = new Object[] { resultat.getInt("id_dragon"), resultat.getString("dragon")};
				System.out.println(Arrays.toString(row));
				setCounter(getCounter() + 1); //
			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'ing: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param dragonId
	 * @return
	 */
	public static boolean read(int dragonId) {
		boolean flag = true;
		try {
			// Statement declaration = accessDataBase.createStatement();
			String query = "Select * FROM dragons WHERE id_dragon = ?";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setInt(1, dragonId);
			ResultSet result = declaration.executeQuery();
			//flag = (result.equals(1));
			while (result.next()) {
				Object[] row = new Object[] { result.getInt("id_dragon"), result.getString("dragon"),
						result.getString("sexe"),result.getInt("longueur"),result.getInt("nombre_ecailles"),
						result.getString("crache_feu"),result.getString("comportement_amoureux")};
				System.out.println(Arrays.toString(row));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Erreur d'insertion dragon: " + e.getMessage());
		}
		return flag;
	}

	/**
	 * Création d'un nouveau dragon
	 * 
	 * @param dragon
	 * @return // true si insertion réussite
	 */
	public static boolean create() {
		boolean flag = true;
		try {
			// Statement declaration = accessDataBase.createStatement();
			System.out.println("entrer le nom du dragon : ");
			String lecture = Keyboard.readString();
			String query = "INSERT INTO dragons (dragon) VALUES (?)";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setString(1, lecture);
			int executeUpdate = declaration.executeUpdate();
			flag = (executeUpdate == 1);
			System.out.println("le dragon " + lecture + " a été créé.");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Erreur d'insertion dragon: " + e.getMessage());
		}
		return flag;
	}

	/**
	 * delete a dragon to the db
	 * @param id
	 * @return
	 */
	public static boolean delete(int id) {
		boolean success = false;
		try {
			// Statement declaration = accessDataBase.createStatement();
			/* Requete */
			String query = "DELETE FROM dragons WHERE id_dragon = ?";
			PreparedStatement declaration = accessDataBase.prepareStatement(query);
			declaration.setInt(1, id);
			/* Exécution d'une requête de lecture */
			int executeUpdate = declaration.executeUpdate();
			success = (executeUpdate == 1);
			System.out.println("*************************");
			System.out.println("Tu as supprimé le dragon ");
		} catch (SQLException e) {
			System.err.println("Erreur suppression du dragon : " + e.getMessage());
		}
		return success;
	}
/**
 * update a dragon to the db
 * @param col
 * @param newValue
 * @param idDragon
 * @return
 */
	public static boolean update(String col,String newValue, int idDragon) {
		boolean success=false;
		try {
		String query = "UPDATE dragons SET "+ col+" = ? WHERE dragons.id_dragon= ?";
		PreparedStatement declaration = accessDataBase.prepareStatement(query);
		//declaration.setString(1, col);
		declaration.setString(1, newValue);
		declaration.setInt(2, idDragon);
		int executeUpdate = declaration.executeUpdate();
		success = (executeUpdate == 1);
		} catch (SQLException e) {
		System.err.println("Erreur update dragon: "
		+ e.getMessage());
		}
		return success;
		}
	
	/**
	 * get name of column in the table dragon 
	 * then display it
	 * @throws SQLException
	 */
	public static void nameCol() throws SQLException {
		tab=new ArrayList<>();
		DatabaseMetaData databaseMetaData = accessDataBase.getMetaData();
		ResultSet columns = databaseMetaData.getColumns(null,null, "dragons", null);
		//System.out.println(columns);
		while(columns.next()) {
		String columnName = columns.getString("COLUMN_NAME");
		tab.add(columnName);
		}
		for (int i=1;i<8;i++) { // remove the begining of the row name
		 tab.remove(1);
		}
		setCounter(tab.size());
		for (int i=1;i<tab.size();i++) {
		System.out.println((i)+" : "+tab.get(i));
		}
	}
}
