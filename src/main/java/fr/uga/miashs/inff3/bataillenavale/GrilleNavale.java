package fr.uga.miashs.inff3.bataillenavale;

public class GrilleNavale {

	private Navire[] navires;
	private int nbNavires;
	private int taille;
	private Coordonnee[] tirsRecus;
	private int nbTirsRecus;
	
//_________________________Constructeur 1 ______________________________________________________________
		
		/* permet d'obtenir une grille navale de taille taille dans laquelle ont été
		 * placés automatiquement taillesNavires.length navires dont les tailles sont données dans taillesNavires.
		 */

	public GrilleNavale(int taille, int[] taillesNavires) {
		if (taille < 1 || taille > 26)
			throw new IllegalArgumentException("taille de la grille incorrecte");
		this.taille = taille;
		this.nbNavires = taillesNavires.length;
		this.navires = new Navire[nbNavires];
		this.tirsRecus = new Coordonnee[taille * taille];
		this.nbTirsRecus = 0;
		placementAuto(taillesNavires);
	}
//____________________________Constructeur 2___________________________________________________
	 
	/* permet d'obtenir une grille navale vide de taille taille pouvant accueillir jusqu'à nbNavires.*/
	 
	public GrilleNavale(int taille, int nbNavires) {
		
		if (taille < 1 || taille > 26)
			throw new IllegalArgumentException("taille de la grille incorrecte");

		this.taille = taille;
		this.nbNavires = nbNavires; 
		this.navires = new Navire[nbNavires];
		this.tirsRecus = new Coordonnee[taille * taille];
		this.nbTirsRecus = 0;
	}
	
//_________________________________toString_________________________________________
	public String toString() {
		StringBuffer grille = new StringBuffer();
		grille.append(" ");
		for (int i = 1; i <= taille; i++) {
			grille.append((char) ('A' + i - 1)).append(" ");
		}
		grille.append("\n");

		for (int i = 1; i <= taille; i++) {
			grille.append(i).append(" ");
			for (int j = 1; j <= taille; j++) {
				Coordonnee c = new Coordonnee(i-1, j-1);
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
//______________________________________________________________________________________________
	public int getTaille() {
		/*Accesseur en lecture.*/
		return taille;
	}
//___________________________________________Ajouter un Navire____________________________________________________	
	
	 /* 
	  * Retourne true après avoir ajouté n à this si cet ajout est possible. L'ajout
	  * est impossible si n touche ou chevauche un navire déjà présent dans this, ou
	  * encore si n dépasse les limites de this.
	  */

	public boolean ajouteNavire(Navire n) {
        if (!estDansGrille(n.getDebut()) || !estDansGrille(n.getFin()) || !(nbNavires < navires.length))
            return false;
        for (Navire navire : navires) {
            if (navire.chevauche(n) || navire.touche(n))
                return false;
        }navires[nbNavires++] = n;
        return true;
    }

//----------------------------------------------- placementAuto ------------------------------------------------------------------------------------------------------------------------------------
// Place automatiquement et aléatoirement taillesNavires.length navires dont les tailles sont données dans taillesNavire.

	public void placementAuto(int[] taillesNavires) {
        for (int i = 0; i < taillesNavires.length; i++) {
            int tailleNavire = taillesNavires[i];
            boolean estVertical = Math.random() < 0.5;
            int ligne;
            int colonne;
            if (estVertical) {
                ligne = (int) ((this.taille - taillesNavires[i]+1) * Math.random());
                colonne = (int) ((this.taille) * Math.random());
            } else {
                ligne = (int) ((this.taille) * Math.random());
                colonne = (int) ((this.taille - taillesNavires[i]+1) * Math.random());
            }Coordonnee debut = new Coordonnee(ligne, colonne);
            Navire nouveauNavire = new Navire(debut, tailleNavire, estVertical);
            if (ajouteNavire(nouveauNavire)) {
                nbNavires++;
            } else {
                i--;
            }
        }
	}


//________________________________________estDansGrille_____________________________________________
	private boolean estDansGrille(Coordonnee c) {
	/*Retourne true si et seulement si c est dans this.*/
		return c.getLigne() >= 0 && c.getLigne() < this.taille -1  && c.getColonne() >= 0 && c.getColonne() < this.taille -1 ; 
	}


 
//____________________________________________contientNavire_________________________________________________________________
	    
	    public boolean contientNavire(Coordonnee c) {// j'ai ajouté cette méthode pour pouvoir écrire la méthode string tosting
	        for (Navire n : navires) {
	            if (n.contient(c))
	                return true;
	        } return false;
	    }

//----------------------------------------------- estDansTirsRecus ------------------------------------------------------------------------------------------------------------------------------------
// Retourne true si et seulement si c correspond à un tir reçu par this.

	 private boolean estDansTirsRecus(Coordonnee c) {
			for (int i = 0; i < tirsRecus.length; i++) {
				if (tirsRecus[i].equals(c))
					return true;
			}return false;
		}
	    
//________________________________________ajouteDansTirsRecus____________________________________________________________
	    
		 /* Ajoute c aux tirs reçus de this si nécessaire. Retourne true si 
		  * et seulement si this est modifié.
		  */
		 
	    private boolean ajouteDansTirsRecus(Coordonnee c) {
	    	if (!estDansTirsRecus(c)&& (estDansGrille(c) && (nbTirsRecus < tirsRecus.length))) {
	    		tirsRecus[nbTirsRecus++]=c;
	    		return true; 
	    }return false; 
	    }
 //_____________________________________recoitTir_____________________________________________________________	    
	    
		 /* Ajoute c aux tirs reçus de this si nécessaire. Retourne true si et seulement 
		 * si c ne correspondait pas déjà à un tir reçu et a permis de toucher un 
		 * navire de this. */
		 
	    
	    public boolean recoitTir(Coordonnee c) {
			boolean tir = ajouteDansTirsRecus(c);
			boolean touche = false;
			if (tir) {
				int i = 0;
				while (i < nbNavires && !touche) {
					if (navires[i].recoitTir(c))
						touche = true;
					i++;
				}
			}

			return touche;
		}

//__________________________________estTouche__________________________________________________________________
	    /* Retourne true si et seulement si un des navires présents dans this a été touché en c. */
	    public boolean estTouche(Coordonnee c) {
	        for (Navire navire : navires) {
	            if (navire.estTouche(c)) 
	                return true;
	        } return false;
	    }
//__________________________________estALEau____________________________________________________________________	    	   
	    
		 /* Retourne true si et seulement si c correspond à un tir reçu dans l'eau par this.*/
		 
	    public boolean estALEau(Coordonnee c) {
	        return estDansTirsRecus(c) && !(estTouche(c)); 
	    }
//__________________________________estCoule____________________________________________________________________	    
	    
		 /* Retourne true si et seulement si un des navires présents dans this a été
		 * touché en c et est coulé */
	   
	    public boolean estCoule(Coordonnee c) {
			for (Navire n : navires) {
				if (n.contient(c) && n.estCoule()) 
					return true;
			}return false;
		}
//___________________________________perdu_____________________________________________________________________
	    /* Retourne true si et seulement si tous les navires de this ont été coulés. */
	    
	    public boolean perdu() {
			for (Navire n : navires) {
				if (!n.estCoule())
					return false;
			}return true;
		}
	    
}
	
