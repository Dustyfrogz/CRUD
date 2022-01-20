package CRUD;

import java.sql.SQLException;
import java.util.ArrayList;

public class Display {

	public static void main(String[] args) {
		MyConnexion.openConnection();
		displayAllDragon();

	}

	/**
	 * Display all the dragon of the db in the console
	 */
	public static void displayAllDragon() {
		System.out.println("***************************");
		System.out.println("la liste des dragons de la bdd : ");
		Querydragon.readAll();
		if(Querydragon.getCounter()==0) {
			System.out.println("***************************");
			System.out.println("Il n'y a pas de dragon dans la bdd.");
			displayActionCreate();
		}else {
			displayActionDragon();
		}
	}
	/**
	 * displayed choice if the bdd is empty
	 * then call actionDragon()
	 */
	public static void displayActionCreate() {
		int choice = 0;
		do {
			System.out.println("***************************");
			System.out.println("Quelle action voulez-vous effectué ?( entrer le chiffre correspondant)");
			System.out.println("1: créer un dragon");
			System.out.println("2: quitter le programme");
			choice = Clavier.lireInt(1, 2);
		} while (choice == 0);
		actionDragon(choice);
	}

	/**
	 * Display the choices for manipulate the bdd in the console then call
	 * actionDragon()
	 */
	public static void displayActionDragon() {
		int choice = 0;
		do {
			System.out.println("***************************");
			System.out.println("Quelle action voulez-vous effectué ?( entrer le chiffre correspondant)");
			System.out.println("1: créer un dragon");
			System.out.println("2: supprimer un dragon");
			System.out.println("3: modifier le paramètres d'un dragon");
			System.out.println("4: lire toute les infos d'un dragon");
			System.out.println("5: quitter le programme");
			choice = Clavier.lireInt(1, 5);
		} while (choice == 0);
		actionDragon(choice);
	}
/**
 * launch a methode following the parameter
 * @param nbAction
 */
	public static void actionDragon(int nbAction) {
		switch (nbAction) {
		case 1:
			createDragon();
			break;
		case 2:
		case2(); // methode in fonction if the db is empty or not
		break;
		case 3:
			displayChoiceUpdateDragon(dragonChoice());
			break;
		case 4:
			displayRead(dragonChoice());
			break;
		case 5:
			System.out.println("Au revoir !!!");
			MyConnexion.closeConnection();
			System.exit(0);
		}
	}
	
	/**
	 * method for choice actionDragon if db is empty
	 */
	public static void case2() {
		if(Querydragon.getCounter()==0) { // if db is empty
			System.out.println("Au revoir !!!");
			MyConnexion.closeConnection();
			System.exit(0);
		}else {
			Querydragon.delete(dragonChoice());
			}
		}
	
	/**
	 * display the dragon's list then allow to choice in the list
	 * @return choice (dragonid)
	 */
	public static int dragonChoice() {
		System.out.println("Choisissez le dragon dans la liste en choisissant son numéro");
		Querydragon.readAll();
		int choice=Clavier.lireInt(1, Querydragon.getCounter());
		return choice;
	}
	
	/**
	 * display the dragon
	 * @param dragonId4
	 */
	public static void displayRead(int dragonId) {
		Querydragon.read(dragonId);
		displayAllDragon();
		
	}
	
	/**
	 * create a dragon
	 */
	public static void createDragon() {
		Querydragon.create();
		displayAllDragon();
	}
	
	/**
	 * display choice of update for the table dragon
	 * then update
	 * then display all dragons
	 * @param idDragon
	 */
	public static void displayChoiceUpdateDragon(int idDragon) {
		System.out.println("Choisissez un attribut du dragon à modifier par son numéros: ");
		try {
			Querydragon.nameCol();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int readInt=Clavier.lireInt(1, Querydragon.getCounter());
		ArrayList<String> colDragon= Querydragon.getTab();
		String col=colDragon.get(readInt);
		System.out.println("Entrer la nouvelle valeur de "+col+" :");
		String newValue=Clavier.lireString();
		System.out.println(newValue);
		Querydragon.update(col,newValue,idDragon);
		displayActionDragon();
	}
	
	
	
	
	}

