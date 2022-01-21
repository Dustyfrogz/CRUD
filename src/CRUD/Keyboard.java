package CRUD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Keyboard {
	/**
	 * Methodfor read a String with the console keyboard
	 * @return String 
	 */
	public static String readString()
	{
		String ligne_lue = null;
		try {
			InputStreamReader lecteur = new InputStreamReader(System.in);
			BufferedReader entree = new BufferedReader(lecteur);
			ligne_lue = entree.readLine();
		} catch (IOException err) {
			System.exit(0);
		}
		return ligne_lue;
	}
	/** Method for read "oui" or "non" only from the console
	 * 
	 * @return lignelue lower case if oui/non if not null
	 */
	public static String readYesOrNo()
	{
		String ligne_lue_brut = null;
		String ligne_lue = null;
		try {
			InputStreamReader lecteur = new InputStreamReader(System.in);
			BufferedReader entree = new BufferedReader(lecteur);
			ligne_lue_brut = entree.readLine();
			ligne_lue = ligne_lue_brut.toLowerCase();//transforme en minuscule
			if (!ligne_lue.equals("oui")&&!ligne_lue.equals("non")) {
				ligne_lue = null;
			}
		} catch (IOException err) {
			return null;
		}
		return ligne_lue;
	}
/**
 * Method for read a Float from the console
 * @return the Float
 */
	public static float readFloat() 
	{
		float x = 0;
		try {
			String ligne_lue = readString();
			x = Float.parseFloat(ligne_lue);
		} catch (NumberFormatException err) {
			System.out.println("*** Erreur de donnee ***");
			System.exit(0);
		}
		return x;
	}
/**
 * Method for read a Double from the console
 * @return the Double
 */
	public static double readDouble()
	{
		double x = 0;
		try {
			String ligne_lue = readString();
			x = Double.parseDouble(ligne_lue);
		} catch (NumberFormatException err) {
			System.out.println("*** Erreur de donnee ***");
			System.exit(0);
		}
		return x;
	}
/**
 * Method for read a Int from the console
 * @return the Int
 */
	public static int readInt()
	{
		int n = 0;

		try {
			String ligne_lue = readString();
			n = Integer.parseInt(ligne_lue);
		} catch (NumberFormatException err) {
			System.out.println("*** Erreur de donnee ***");
			System.exit(0);
		}
		return n;
	}
	
	/**
	 * Method for read a int from the console with a range, values include
	 * @param start
	 * @param end
	 * @return the int if not start-1
	 */
	public static int readInt(int start, int end)
	{
		int n = start-1;		
		try {
			String ligne_lue = readString();
			n = Integer.parseInt(ligne_lue);
			if (n<start||n>end) {
				System.out.println("******** ERREUR le chiffre doit être compris entre "+start+ " et "+end+" ********");
				return (start-1);
			}else {			
			}
		} catch (NumberFormatException err) {
			System.out.println("******* ERREUR la valeur n'est pas un nombre entier *******");
			return (start-1);
		}
		return n;
	}
}
