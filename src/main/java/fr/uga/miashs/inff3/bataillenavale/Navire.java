
package fr.uga.miashs.inff3.bataillenavale;


public class Navire {
	
	private Coordonnee debut;
	private Coordonnee fin;
	private Coordonnee[] partiesTouchees;
	private int nbTouchees;


	public Navire(Coordonnee debut, int longueur, boolean estVertical) {
		/*permet d'obtenir un navire débutant en debut et de taille longueur. Ce navire est disposé verticalement si estVertical vaut true, horizontalement sinon.*/
		if (longueur < 1) {
            throw new IllegalArgumentException("La longueur du navire doit être au moins 1");
        }this.debut = debut;
	    if (estVertical) 
	    	this.fin = new Coordonnee (debut.getLigne() + longueur -1, debut.getColonne());
	    else 
	    	this.fin = new Coordonnee (debut.getLigne(), debut.getColonne() + longueur -1);
	    this.partiesTouchees = new Coordonnee[longueur];
	    this.nbTouchees = 0;
		}


	public String toString() {
		/*Retourne une String représentant this. On souhaite obtenir une représentation de la forme "Navire(B1, 4, horizontal)" (pour un navire de taille 4 placé horizontalement par exemple).*/
		String s= "Navire(";
		s+= debut.toString();
		if(estVertical()) {
			int longueur= fin.getLigne()- debut.getLigne()+1;
			s+=", "+ longueur + ", vertical)";
		}else {
			int longueur= fin.getColonne()- debut.getColonne()+1;
			s+=", "+ longueur + ", horizontal)";
		}
		return s;
	}
		
	
	public Coordonnee getDebut() {
		/*Accesseur en lecture.*/
		return debut;
	}
	
	public Coordonnee getFin() {
		/*Accesseur en lecture.*/
		return fin;
	}
	

	public boolean estVertical() {
		/* retourne true si et seulement si le navire est vertical.*/
		return debut.getColonne() == fin.getColonne();
	}


	public boolean contient(Coordonnee c) {
	/* Retourne true si et seulement si this occupe c. */
		return c.getLigne() >= debut.getLigne() && c.getLigne() <= fin.getLigne() &&
	               c.getColonne() >= debut.getColonne() && c.getColonne() <= fin.getColonne();
	}
	
	
	
	public boolean touche(Navire n) {
		/*Retourne true si et seulement si this est adjacent à n. L'adjacence par la diagonale ne compte pas.*/
	    int debutLigneThis = debut.getLigne();
	    int finLigneThis = fin.getLigne();
	    int debutColonneThis = debut.getColonne();
	    int finColonneThis = fin.getColonne();
	
	    
	    int debutLigneN = n.debut.getLigne();
	    int finLigneN = n.fin.getLigne();
	    int debutColonneN = n.debut.getColonne();
	    int finColonneN = n.fin.getColonne();
	
	 
	    boolean adjacenceHorizontale = (finLigneThis >= debutLigneN && debutLigneThis <= finLigneN) &&
	                                   (debutColonneThis == finColonneN + 1 || finColonneThis == debutColonneN - 1 ||
	                                    debutColonneThis == finColonneN || finColonneThis == debutColonneN);
	
	    boolean adjacenceVerticale = (finColonneThis >= debutColonneN && debutColonneThis <= finColonneN) &&
	                                 (debutLigneThis == finLigneN + 1 || finLigneThis == debutLigneN - 1 ||
	                                  debutLigneThis == finLigneN || finLigneThis == debutLigneN);
	
	    return adjacenceHorizontale || adjacenceVerticale;
	    
	}


	public boolean chevauchebis(Navire n) {
		/*Retourne true si et seulement si this chevauche n, c'est-à-dire que this et n occupent au moins une coordonnée en commun*/
		for (int i=n.getDebut().getLigne();i<=n.getFin().getLigne(); i++ ) {
			Coordonnee c = new Coordonnee(i,n.getDebut().getColonne());
			if (this.contient(c))
				return true;
	    }for (int i=n.getDebut().getColonne();i<=n.getFin().getColonne(); i++ ) {
	    	Coordonnee c = new Coordonnee(n.getDebut().getLigne(),i);
	        if (this.contient(c))
	            return true;
	        }return false;
	    }
	
	public boolean chevauche(Navire n) {
		/*Retourne true si et seulement si this est adjacent à n. L'adjacence par la diagonale ne compte pas.*/
	    int debutLigneThis = debut.getLigne();
	    int finLigneThis = fin.getLigne();
	    int debutColonneThis = debut.getColonne();
	    int finColonneThis = fin.getColonne();
	
	    
	    int debutLigneN = n.debut.getLigne();
	    int finLigneN = n.fin.getLigne();
	    int debutColonneN = n.debut.getColonne();
	    int finColonneN = n.fin.getColonne();
	
	 
	    boolean chevauchementHorizontale = (finLigneThis >= debutLigneN && debutLigneThis <= finLigneN) &&
	                                   (debutColonneThis == finColonneN || finColonneThis == debutColonneN);
	
	    boolean chevauchementVerticale = (finColonneThis >= debutColonneN && debutColonneThis <= finColonneN) &&
	                                 (debutLigneThis == finLigneN || finLigneThis == debutLigneN);
	
	    return chevauchementHorizontale || chevauchementVerticale;
	}
	        

	public boolean recoitTir(Coordonnee c) {
		/* Retourne true si et seulement si this contient c. Dans ce cas, c est ajoutée aux parties touchées si nécessaire*/
       if (this.contient(c)) {
            int indice = estVertical() ? c.getLigne() - debut.getLigne() : c.getColonne() - debut.getColonne();
            partiesTouchees[indice] = c;
            this.nbTouchees ++;
            return true;
        }return false;
    }
	
	
	
	public boolean estTouche(Coordonnee c) {
		/* Retourne true si et seulement si this a été touché par un tir en c. */
		return contient(c) && partiesTouchees[estVertical() ? c.getLigne() - debut.getLigne() : c.getColonne() - debut.getColonne()] != null;
	}
	
	public boolean estTouche() {
		/*Retourne true si et seulement si this a au moins une partie touchée.*/
		return nbTouchees > 0;
	}
	
	
	
	public boolean estCoule() {
		/*Retourne true si et seulement si this est coulé, c'est-à-dire que toutes ses parties ont été touchées.*/
	    for (int i = estVertical() ? debut.getLigne() : debut.getColonne();
	         i <= (estVertical() ? fin.getLigne() : fin.getColonne());
	         i++) {
	        Coordonnee c = estVertical() ? new Coordonnee(i, debut.getColonne()) : new Coordonnee(debut.getLigne(), i);
	        if (!estTouche(c)) {
	            return false;
	        }
	    }return true;
	}

}
