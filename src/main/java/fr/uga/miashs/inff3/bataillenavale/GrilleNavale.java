package fr.uga.miashs.inff3.bataillenavale;

import batailleNavale.Coordonnee;
import batailleNavale.Navire;

public class GrilleNavale {
	
	private Navire[] navires;
    private int nbNavires;
    private int taille;
    private Coordonnee[] tirsRecus;
    private int nbTirsRecus;
 
	  public String toString() {
	        StringBuilder grid = new StringBuilder();
	        grid.append(" ");
	        for (int i = 0; i < taille; i++) {
	            grid.append((char) ('A' + i)).append(" ");
	        }
	        grid.append("\n");

	        for (int i = 0; i < taille; i++) {
	            grid.append(i + 1).append(" ");
	            for (int j = 0; j < taille; j++) {
	                Coordonnee c = new Coordonnee(i, j);
	                if (estTouche(c)) {
	                    grid.append("X ");
	                } else if (estALEau(c)) {
	                    grid.append("O ");
	                } else if (contientNavire(c)) {//normalement c'est la méthode contient de la classe navir
	                    grid.append("# ");
	                } else {
	                    grid.append(". ");
	                }
	            }
	            grid.append("\n");
	        }
	        return grid.toString();
	    }
	    
	    public int getTaille() {
	    return taille;
	  }
	    
	    private boolean estDansGrille(Coordonnee c) {
	    	return  c.getLigne()>=0 && c.getLigne() < this.taille && c.getColonne()>=0 && c.getColonne()<this.taille; //pas sur est ce que est juste
	    }
	    
	    public boolean contientNavire(Coordonnee c) {// j'ai ajouté cette méthode pour pouvoir écrire la méthode string tosting
	        for (int i = 0; i < navires.length; i++) {
	            Navire n = navires[i];
	            if (n.contient(c)) {
	                return true;
	            }
	        }
	        return false;
	    }
	    
	    public boolean estTouche(Coordonnee c) {
	    	return estDansTirsRecus(c) && contientNavire(c); // 
	    	/*for (int i = 0; i < navires.length; i++) {
	    	    Navire n = navires[i] ;
	            if (n.contient(c)) {
	                return true;
	            }
	        }
	    	return false;*/
	    }
	    
	    public boolean estALEau(Coordonnee c) {
	        return !estDansTirsRecus(c) && !estTouche(c); // normalement on peut faire seulement la condition !estTouche 
	    }
	    
	    public boolean estCoule(Coordonnee c) {
	        for (Navire n : navires) {
	            if (n.contient(c) && n.estCoule()) {
	                return true;
	            }
	        }

	        return false;
	    }
	    
	    public boolean perdu() {
	        for (Navire n : navires) {
	            if (!n.estCoule()) {
	                return false;
	            }
	        }

	        return true;
	    }

}
}
