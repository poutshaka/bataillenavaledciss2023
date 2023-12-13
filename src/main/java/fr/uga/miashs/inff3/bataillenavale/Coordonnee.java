package fr.uga.miashs.inff3.bataillenavale;


public class Coordonnee implements Comparable<Coordonnee> {
	
	private int ligne;
	private int colonne; 
	
	public Coordonnee (int ligne, int colonne) {
	/*permet d'obtenir une coordonnée de ligne i et de colonne j (indices Java).*/
		if (ligne<0 || ligne>=26 || colonne<0 || colonne>=26)
			throw new IllegalArgumentException("Les coordonnes sont hors limites.");
		this.ligne = ligne;
		this.colonne = colonne;
	}
	
	public Coordonnee(String s) {
	/*permet d'obtenir une coordonnée d'après son expression donnée par s dans le système de coordonnées de la bataille navale.*/	
		if (s.length()<2 || s.length()> 3 )
			throw new IllegalArgumentException("Une coordonnee doit avoir au minimum 2 caracteres et au max 3 caracteres"); 
		if (s.charAt(0)< 'A' || s.charAt(0)> 'Z' )
			throw new IllegalArgumentException("Les coordonnees doivent etre entre A et Z"); 
		try {
				Integer.parseInt(s.substring(1));
		}catch (NumberFormatException e) {
			throw new IllegalArgumentException("Format incorrect");
		} this.colonne = s.charAt(0) - 'A'; 
		this.ligne = Integer.parseInt(s.substring(1)) - 1;
	}
	
	public String toString() { 
	/*Retourne une String exprimant this dans le système de coordonnée de la bataille navale (exemple : "C6").*/
		return " "+(char)('A' + this.colonne) + (int)(this.ligne + 1);   
	}
	
	public int getColonne() {
	/*Accesseur en lecture pour l'indice de colonne.*/
		return colonne;
	}
	
	public int getLigne() {
	/*Accesseur en lecture pour l'indice de ligne.*/
		return ligne;
	}

	public boolean equals(Object obj) {
	/*Retourne true si et seulement si this est équivalent à obj.*/
		if (!(obj instanceof Coordonnee) || obj==null)
			return false;
		Coordonnee c = (Coordonnee) obj;
			return c.ligne == this.ligne && c.colonne == this.colonne;	 	
	}
	
	public boolean voisine(Coordonnee c) {
		return (((this.colonne == c.colonne) && ((this.ligne == c.ligne + 1) || (this.ligne == c.ligne - 1))) || 
				((this.ligne == c.ligne) && ((this.colonne == c.colonne+1) || (this.colonne == c.colonne - 1))));
			
		}
    
	
	public int compareTo(Coordonnee c) {
		if ((this.ligne == c.ligne )&& (this.colonne == c.colonne))
			return 0;
		else if ((this.ligne != c.ligne) && (this.colonne == c.colonne))
			return this.ligne - c.ligne;
		else
			return this.colonne - c.colonne; 

	}
	
}

