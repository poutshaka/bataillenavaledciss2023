package fr.uga.miashs.inff3.bataillenavale;

public class Coordonnee {
	
	private int ligne;
	private int colonne; 
	
	public Coordonnee (int ligne, int colonne) {
		if (ligne<0 || ligne>=26 || colonne<0 || colonne>=26)
			throw new IllegalArgumentException("Les coordonnes sont hors limites.");
		this.ligne = ligne;
		this.colonne = ligne;
	}
	
	public Coordonnee(String s) {
		
	}
	

	
	public int getLigne() {
		// A modifier
		return 0;
	}
	
	public int getColonne() {
		// A modifier
		return 0;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Coordonnee) {
			Coordonnee c = (Coordonnee) o;
			// A modifier
		}
		return false;
	}
	
	public boolean voisine(Coordonnee c) {
		// A modifier
		return true;
	}
	
	public int compareTo(Coordonnee c) {
		// A modifier
		return 0;
	}
	
	public String toString() {
		// A modifier
	   return super.toString();
	}
}
