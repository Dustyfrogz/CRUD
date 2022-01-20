package CRUD;

import java.sql.Statement;
import java.util.Arrays;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Querydragon extends MyConnexion {

	/**
	 * Ici on test
	 * 
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		openConnection();
//		readAll();
//		create();
		//update("dddd", "merdique JB est update");
//		deleteByNamePrepared("merde");
		readAll();
		closeConnection();
	}

	/**
	 * Action de lire les tous les ingrèdients
	 */
	public static void readAll() {
		try {
			Statement declaration = accessDataBase.createStatement();
			String query = "SELECT * FROM dragons;";
			ResultSet resultat = declaration.executeQuery(query);
			/* Récupération des données */
			while (resultat.next()) {
				Object[] row = new Object[] { resultat.getInt("id_dragon"), resultat.getString("dragon") };
				System.out.println(Arrays.toString(row));
			}
//			while (resultat.next()) {
//				Dragons ing = new Dragons();
//				ing.setId(resultat.getInt("id_dragon"));
//				ing.setDragon(resultat.getString("dragon"));
//				ing.setSexe(resultat.getString("sexe"));
//				ing.setLongueur(resultat.getInt("longueur"));
//				ing.setNombreEcailles(resultat.getInt("nombre_ecailles"));
//				ing.setCracheFeu(resultat.getString("crache_feu"));
//				ing.setComportementAmoureux(resultat.getString("comportement_amoureux"));
//				System.out.println(ing.toString());
//			}
		} catch (Exception e) {
			System.err.println("Erreur d'affichage d'ing: " + e.getMessage());
		}
	}


	/**
	 * Création d'un nouvel ingrédient
	 * 
	 * @param ingredient
	 * @return // true si insertion réussite
	 */

	public static boolean create() {
		String response = "oui";
		boolean flag=true;
		while (response.equals("oui")) {

			System.out.println("Voulez-vous saisir un ingredient?");
			response = Clavier.lireOuiNon();
			if (response!="oui") {
				response="non";
			}
			
			flag = false;
			try {
				//Statement declaration = accessDataBase.createStatement();
				System.out.println("entrer le nom de l'ingredient :");
				String lecture = Clavier.lireString();
				String query = "INSERT INTO ingredients (nom) VALUES (?)";
				PreparedStatement declaration = accessDataBase.prepareStatement(query);		
				declaration.setString(1, lecture);
				int executeUpdate = declaration.executeUpdate();
				flag = (executeUpdate == 1);
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Erreur d'insertion ingredient: " + e.getMessage());
			}
		}
		
		return flag;
	}

	public static boolean delete(int id) {
		boolean success = false;
		try {
			Statement declaration = accessDataBase.createStatement();
			/* Requete */
			String query = "DELETE FROM `ingredients` WHERE `id`= " + id + ";";
			/* Exécution d'une requête de lecture */
			int executeUpdate = declaration.executeUpdate(query);
			success = (executeUpdate == 1);
		} catch (SQLException e) {
			System.err.println("Erreur suppression ingredient: " + e.getMessage());
		}
		return success;
	}

	public static boolean deleteByName(String nom) {
		boolean success = false;
		try {
			Statement declaration = accessDataBase.createStatement();
			String query = "DELETE FROM `ingredients` WHERE `nom`= \"" + nom + "\";";
			int executeUpdate = declaration.executeUpdate(query);
			success = (executeUpdate == 1);
		} catch (SQLException e) {
			System.err.println("Erreur suppression ingredient: " + e.getMessage());
		}
		return success;
	}
	
	public static boolean deleteByNamePrepared(String nom) {
		boolean success = false;
		try {
		String query = "DELETE FROM ingredients WHERE nom = ?";
		PreparedStatement declaration = accessDataBase.prepareStatement(query);
		declaration.setString(1, nom);
		int executeUpdate = declaration.executeUpdate();
		success = (executeUpdate == 1);
		} catch (SQLException e) {
		System.err.println("Erreur suppression ingredient: "
		+ e.getMessage());
		}
		return success;
		}
	
	public static boolean update(String nom,String nom2) {
		boolean success=false;
		try {
		String query = "UPDATE ingredients SET nom = ? WHERE ingredients.nom= ?";
		PreparedStatement declaration = accessDataBase.prepareStatement(query);
		declaration.setString(2, nom);
		declaration.setString(1, nom2);
		int executeUpdate = declaration.executeUpdate();
		success = (executeUpdate == 1);
		} catch (SQLException e) {
		System.err.println("Erreur update ingredient: "
		+ e.getMessage());
		}
		return success;
		}
	}
