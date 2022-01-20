package CRUD;

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
			Querydragon.create();
			break;
		case 2:
			if(Querydragon.getCounter()==0) { // if db is empty
				System.out.println("Au revoir !!!");
				MyConnexion.closeConnection();
				System.exit(0);
			}else {
			Querydragon.delete(dragonChoice());
			break;
			}
		case 3:
			Querydragon.update(null, null);
			break;
		case 4:
			displayRead();
			break;
		case 5:
			System.out.println("Au revoir !!!");
			MyConnexion.closeConnection();
			System.exit(0);
		}
	}
	
	
	public static int dragonChoice() {
		System.out.println("Choisissez le dragon dans la liste en choisissant son numéro");
		Querydragon.readAll();
		int choice=Clavier.lireInt(1, Querydragon.getCounter());
		return choice;
	}
	public static void displayRead() {
		Querydragon.read();
		
	}
}
