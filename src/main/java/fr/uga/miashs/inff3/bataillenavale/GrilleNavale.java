package fr.uga.miashs.inff3.bataillenavale;

public class GrilleNavale {

	private Navire[] navires;
	private int nbNavires;
	private int taille;
	private Coordonnee[] tirsRecus;
	private int nbTirsRecus;
	

	public GrilleNavale(int taille, int[] taillesNavires) {
		/*
		 * permet d'obtenir une grille navale de taille taille dans laquelle ont été
		 * placés automatiquement taillesNavires.length navires dont les tailles sont
		 * données dans taillesNavires.
		 */
// Attention les navires ne sont pas placés automatiquement comme demandé et le nombre de navires est taillesNavires.length
		if (taille < 0 || taille > 26)
			throw new IllegalArgumentException("taille de la grille incorrecte");

		this.taille = taille;
		this.navires = new Navire[taillesNavires.length];
		this.tirsRecus = new Coordonnee[taille * taille];
		this.nbTirsRecus = 0;
		this.nbNavires = 0;

	}

	public GrilleNavale(int taille, int nbNavires) {
		/*
		 * permet d'obtenir une grille navale vide de taille taille pouvant accueillir
		 * jusqu'à nbNavires.
		 */
//Attention le nombre de navires est taillesNavires.length
		if (taille < 0 || taille > 26)
			throw new IllegalArgumentException("taille de la grille incorrecte");

		this.taille = taille;
		this.navires = new Navire[nbNavires];
		this.tirsRecus = new Coordonnee[taille * taille];
		this.nbNavires = 0;
		this.nbTirsRecus = 0;

	}
	

	public String toString() {
		StringBuffer grille = new StringBuffer();
		grille.append(" ");
		for (int i = 0; i < taille; i++) {
			grille.append((char) ('A' + i)).append(" ");
		}
		grille.append("\n");

		for (int i = 0; i < taille; i++) {
			grille.append(i + 1).append(" ");
			for (int j = 0; j < taille; j++) {
				Coordonnee c = new Coordonnee(i, j);
				if (estTouche(c)) {
					grille.append("X ");
				} else if (estALEau(c)) {
					grille.append("O ");
				} else if (contientNavire(c)) {// normalement c'est la méthode contient de la classe navir
					grille.append("# ");
				} else {
					grille.append(". ");
				}
			}
			grille.append("\n");
		}
		return grille.toString();
	}

	public int getTaille() {
		/*Accesseur en lecture.*/
		return taille;
	}

	public boolean ajouteNavire(Navire n) {
		/*
		 * Retourne true après avoir ajouté n à this si cet ajout est possible. L'ajout
		 * est impossible si n touche ou chevauche un navire déjà présent dans this, ou
		 * encore si n dépasse les limites de this.
		 */
//chevauche est une méthode de la classe Navire il faut l'utiliser en conséquence en parcourant les différents navires
		if (nbNavires < navires.length && estDansGrille(n.getDebut()) && estDansGrille(n.getFin())
				&& !chevaucheNavire(n)) {
			navires[nbNavires++] = n;
			return true;
		}
		return false;
	}

	private boolean estDansGrille(Coordonnee c) {
		/*Retourne true si et seulement si c est dans this.*/
//attention les numéros de lignes et colonnes vont de 0 à taille -1
		return c.getLigne() >= 0 && c.getLigne() < this.taille && c.getColonne() >= 0 && c.getColonne() < this.taille; 
	}

	
	public boolean contientNavire(Coordonnee c) {// j'ai ajouté cette méthode pour pouvoir écrire la méthode string
													// tostring
		for (int i = 0; i < navires.length; i++) {
			Navire n = navires[i];
			if (n.contient(c)) {
				return true;
			}
		}
		return false;
	}

	private boolean estDansTirsRecus(Coordonnee c) {
		/* Retourne true si et seulement si c correspond à un tir reçu par this. */
		for (int i = 0; i < tirsRecus.length; i++) {
			if (tirsRecus[i].equals(c))
				return true;
		}
		return false;
	}

	private boolean ajouteDansTirsRecus(Coordonnee c) {
		/*
		 * Ajoute c aux tirs reçus de this si nécessaire. Retourne true si et seulement
		 * si this est modifié.
		 */
//Attention la coordonnée peut ne pas faire partie de la grille. Il faut aussi vérifier si le tableau tirsRecus n'est pas déjà plein
		if (!estDansTirsRecus(c)) {
			tirsRecus[nbTirsRecus++] = c;
			return true;
		}
		return false;
	}

	public boolean recoitTir(Coordonnee c) {
    	/*
		 * Ajoute c aux tirs reçus de this si nécessaire. Retourne true si et seulement 
		 * si c ne correspondait pas déjà à un tir reçu et a permis de toucher un 
		 * navire de this.
		 */
//Il faut vérifier que la coordonnée soit dans la grille et que ajouteDansTirsRecus soit vrai puis vérifier que la coordonnée soit bien celle d'un navire touché
	    if(!estDansTirsRecus(c))
	    	ajouteDansTirsRecus(c);
	   return true;
	    }
	

	public boolean estTouche(Coordonnee c) {
		/* Retourne true si et seulement si un des navires présents dans this a été touché en c. */
		return estDansTirsRecus(c) && contientNavire(c); //
		/*
		 * for (int i = 0; i < navires.length; i++) { Navire n = navires[i] ; if
		 * (n.contient(c)) { return true; } } return false;
		 */
	}

	public boolean estALEau(Coordonnee c) {
		/*
		 * Retourne true si et seulement si c correspond à un tir reçu dans l'eau par
		 * this.
		 */
//Il faut que la coordonnée soit dans les tirs reçus
		return !estDansTirsRecus(c) && !estTouche(c); // normalement on peut faire seulement la condition !estTouche
	}

	public boolean estCoule(Coordonnee c) {
		/*
		 * Retourne true si et seulement si un des navires présents dans this a été
		 * touché en c et est coulé
		 */
		for (Navire n : navires) {
			if (n.contient(c) && n.estCoule()) {
				return true;
			}
		}

		return false;
	}

	public boolean perdu() {
		/* Retourne true si et seulement si tous les navires de this ont été coulés. */
		for (Navire n : navires) {
			if (!n.estCoule()) {
				return false;
			}
		}

		return true;
	}

}
