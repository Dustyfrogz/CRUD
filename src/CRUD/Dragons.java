package CRUD;

public class Dragons {
int id;

public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getDragon() {
	return dragon;
}


public void setDragon(String dragon) {
	this.dragon = dragon;
}


public String getSexe() {
	return sexe;
}


public void setSexe(String sexe) {
	this.sexe = sexe;
}


public int getLongueur() {
	return longueur;
}


public void setLongueur(int longueur) {
	this.longueur = longueur;
}


public int getNombreEcailles() {
	return nombreEcailles;
}


public void setNombreEcailles(int nombreEcailles) {
	this.nombreEcailles = nombreEcailles;
}


public boolean isCracheFeu() {
	return cracheFeu;
}


public void setCracheFeu(boolean cracheFeu) {
	this.cracheFeu = cracheFeu;
}


public String getComportementAmoureux() {
	return comportementAmoureux;
}


public void setComportementAmoureux(String comportementAmoureux) {
	this.comportementAmoureux = comportementAmoureux;
}


String dragon;
String sexe;
int longueur;
int nombreEcailles;
boolean cracheFeu;
String comportementAmoureux;



@Override
public String toString() {
	return "Le dragon [id=" + id + ", nom=" + dragon + ", sexe= "+sexe + "longueur :" + longueur + 
			" Nombre Ecailles : "+ nombreEcailles + " ,crache du Feu : " + cracheFeu + " ,comportement amoureux : "+ comportementAmoureux+"]";
}
}
