package fr.uga.miashs.inff3.bataillenavale;

import fr.uga.miashs.inff3.bataillenavale.Coordonnee;

public class Navire {
	
private Coordonnee debut;
private Coordonnee fin;
private Coordonnee[] partiesTouchees;
private int nbTouchees;
public Navire(Coordonnee debut, int longueur, boolean estVertical) {
        this.debut = debut;
        if (estVertical) 
            this.fin = new Coordonnee (debut.getLigne() + longueur -1, debut.getColonne());
        else 
            this.fin = new Coordonnee (debut.getLigne(), debut.getColonne() + longueur -1);
        this.partiesTouchees = new Coordonnee[longueur];
        this.nbTouchees = 0;
	}


public String toString() {
	String s= "Navire(";
	s+= debut.toString();
	if(estVertical) {
		int longueur= fin.getLigne()- debut.getLigne()+1;
		s+=", "+ longueur + ", vertical)";
	}else {
		int longueur= fin.getColonne()- debut.getColonne()+1;
		s+=", "+ longueur + ", horizontal)";
	}
	return s;
}
	

public Coordonnee getDebut() {
	return debut;
}
public Coordonnee getFin() {
	return fin;
}
public boolean estVertical(Navire N) {
	return N.getDebut.getColonne() == N.getFin.getLigne();
}


public boolean contient(Coordonnee c) {
		return(c.getColonne()== debut.getColonne() && (c.getLigne()>debut.getLigne()+1 && c.getLigne()<fin.getLigne()-1)) || (c.getLigne()== debut.getLigne() && (c.getColonne()>debut.getColonne()+1 && c.getColonne()<fin.getColonne()-1));
	
	}
public boolean touche(Navire n) { //TODO
	
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


public boolean chevauche(Navire n) {
		for (int i=n.getDebut().getLigne();i=n.getFin().getLigne(); i++ ) {
            if (this.contient(i,n.getDebut().getColonne()))
                return true;
        }for (int i=n.getDebut().getColonne();i==n.getFin().getColonne(); i++ ) {
            if (this.contient(n.getDebut().getLigne(),i))
                return true;
        return false;
        }
    }
	        

public boolean recoitTir(Coordonnee c) {
       if (this.contient(c)) {
            this.nbTouchees ++;
            int indice = estVertical(this) ? c.getLigne() - debut.getLigne() + 1 : c.getColonne() - debut.getColonne() + 1 ;
            partiesTouchees[indice] = c;
        }
    }
public boolean estTouche(Coordonnee c) {
	if(estVertical) {
	for(int i=debut.getLigne(); i<fin.getLigne(); i++)
		if (partiesTouchees[i] != null && partiesTouchees[i].equals(c));
	return true;
	} else {
		for(int i=debut.getColonne(); i<fin.getColonne(); i++)
			if ((partiesTouchees[i] != null && partiesTouchees[i].equals(c));
		return true;
	}
}
public boolean estTouche() {
for (int i=)
}
public boolean estCoule() {...}
}
