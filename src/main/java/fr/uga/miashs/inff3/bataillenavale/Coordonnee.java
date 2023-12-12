package fr.uga.miashs.inff3.bataillenavale;

import batailleNavale.Coordonnee;

public class Coordonnee implements Comparable<Coordonnee> {
	
	private int ligne;
	private int colonne; 
	
	public Coordonnee (int ligne, int colonne) {
		if (ligne<0 || ligne>=26 || colonne<0 || colonne>=26)
			throw new IllegalArgumentException("Les coordonnes sont hors limites.");
		this.ligne = ligne;
		this.colonne = ligne;
	}
	
	public Coordonnee(String s) {
		char lettre = s.charAt(0);
		int ligne = lettre - 'A';
		int colonne =Integer.parseInt(s.substring(1)) - 1;
		this.ligne = ligne;
		this.colonne = colonne;
	}
	
	public String toString() {
		return (char)('A' + colonne) + Integer.toString(ligne + 1);   
	}
	
	public int getLigne() {
		return ligne;
	}
	
	public int getColonne() {
		return colonne;
	}
	
	public boolean equals(Object obj) {
		return ( obj instanceof Coordonnee) && (this.compareTo((Coordonnee)obj) == 0);	 	
	}
	
	public boolean voisine(Coordonnee c) {
		if( Math.abs(this.ligne-c.ligne) <=1 && Math.abs(this.colonne-c.colonne) <=1) {
			return true; 
			
		}
            return false;
	}
	
	public int compareTo(Coordonnee c) {
		if (this.ligne < c.ligne )
			return -1; 
		if (this.ligne > c.ligne)
			return 1; 
		if (this.colonne < c.colonne)
			return -1; 
		if (this.colonne > c.colonne)
			return 1;
		return 0;
	}
	
}

