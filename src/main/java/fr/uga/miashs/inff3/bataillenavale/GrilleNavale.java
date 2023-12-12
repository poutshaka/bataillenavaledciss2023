package fr.uga.miashs.inff3.bataillenavale;

import batailleNavale.Coordonnee;
import batailleNavale.Navire;

public class GrilleNavale {
	
	private Navire[] navires;
    private int nbNavires;
    private int taille;
    private Coordonnee[] tirsRecus;
    private int nbTirsRecus;
    //
 
public GrilleNavale(int taille, int[] taillesNavires) {
		
		if (taille < 0 || taille > 26)
			throw new IllegalArgumentException("taille de la grille incorrecte");
		
		this.taille = taille; 
		this.navires = new Navire [taillesNavires.length];
		this.tirsRecus = new Coordonnee [taille * taille]; 
		this.nbTirsRecus = 0;
		this.nbNavires = 0; 
			
	}

public GrilleNavale(int taille, int nbNavires) {
	if (taille < 0 || taille > 26)
		throw new IllegalArgumentException("taille de la grille incorrecte");
	
	this.taille = taille; 
	this.navires = new Navire [nbNavires]; 
	this.tirsRecus = new Coordonnee [taille * taille]; 
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
	                } else if (contientNavire(c)) {//normalement c'est la méthode contient de la classe navir
	                    grille.append("# ");
	                } else {
	                    grille.append(". ");
	                }
	            }
	            grille.append("\n");
	        }
	        return grille.toString();
	    }
//____________________________________________________________________________________________________________	    
	    public int getTaille() {
	    return taille;
	  }
//____________________________________________________________________________________________________________
	    
	/*    public boolean ajouteNavire(Navire n) {
			 if (nbNavires < navires.length && estDansGrille(n.getDebut()) && estDansGrille(n.getFin()) && !chevaucheNavire(n)) {
		            navires[nbNavires++] = n;
		            return true;
		        }
		        return false;
		    }*/
//____________________________________________________________________________________________________________
	    
	    private boolean estDansGrille(Coordonnee c) {
	    	return  c.getLigne()>=0 && c.getLigne() < this.taille && c.getColonne()>=0 && c.getColonne()<this.taille; //pas sur est ce que est juste
	    }
//_____________________________________________________________________________________________________________
	    
	    public boolean contientNavire(Coordonnee c) {// j'ai ajouté cette méthode pour pouvoir écrire la méthode string tosting
	        for (int i = 0; i < navires.length; i++) {
	            Navire n = navires[i];
	            if (n.contient(c)) {
	                return true;
	            }
	        }
	        return false;
	    }
//______________________________________________________________________________________________________________
	    
	    private boolean estDansTirsRecus(Coordonnee c) {
	    	if(!estDansGrille(c)) {
	    		return false; 
	    	} else 
	    		if (nbTirsRecus != 0) {
	    			for (int i = 0; i < nbTirsRecus; i++) {
	    				if (this.tirsRecus[i].equals(c)) {
	    					return true;
	    				}
	    			}
	    		}
	    		return false;

	    	}
//____________________________________________________________________________________________________
	    
	    private boolean ajouteDansTirsRecus(Coordonnee c) {
	    	
	    	if(!estDansTirsRecus(c)) 
	    		return true; 
	    		
	    		tirsRecus[nbTirsRecus++]=c;
	    		return true;
	    }
 //__________________________________________________________________________________________________	    
	   
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

//____________________________________________________________________________________________________
	    
	    public boolean estTouche(Coordonnee c) {
	 
	    	for (int i = 0; i < nbNavires; i++) {
	    		if (this.navires[i].estTouche(c))
					
					return true;
			}
			return false;
		}
//______________________________________________________________________________________________________	    	   
	    
	    public boolean estALEau(Coordonnee c) {
	        return !(estTouche(c)); // normalement on peut faire seulement la condition !estTouche 
	    }
//______________________________________________________________________________________________________	    
	  
	   
	    public boolean estCoule(Coordonnee c) {
	    	
	    	for(int i=0; i<nbNavires; i++) {
	    		
	    		if (this.navires[i].estTouche(c) && this.navires[i].estCoule()) {
	    	return true; 
	    		}
	    	}
	    		return false; 
	    }
//________________________________________________________________________________________________________
	    public boolean perdu() {
	    	
	    		for (int i = 0; i < this.nbNavires; i++)
	    			if (!(this.navires[i].estCoule()))
	    				return false;
	    		
	    		return true;
	    	}

}

