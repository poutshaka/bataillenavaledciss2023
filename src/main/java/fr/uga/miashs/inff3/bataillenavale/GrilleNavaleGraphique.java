package fr.uga.miashs.inff3.bataillenavale;

import java.awt.Color;


public class GrilleNavaleGraphique extends GrilleNavale {
	private GrilleGraphique grille;

    public GrilleNavaleGraphique(int taille) {
    /*permet d'obtenir une grille de taille taille.*/
        super(taille,0);
        this.grille = new GrilleGraphique(taille);
    }
    
    public GrilleGraphique getGrilleGraphique() {
    /*Accesseur en lecture pour grille.*/
        return grille;
    }
    
    public boolean ajouteNavire(Navire n) {
    /*Spécialisation de la méthode héritée de GrilleNavale. Les cases correspondant au navire ajouté doivent être coloriées en Color.GREEN.*/
    	boolean ajout = super.ajouteNavire(n);
        if (ajout) {
        		grille.colorie(n.getDebut(), Color.GREEN);
        		grille.colorie(n.getFin(), Color.GREEN);
        }return ajout;
    }
    
    public boolean recoitTir(Coordonnee c) {
    /*Spécialisation de la méthode héritée de GrilleNavale. La case correspondant au tir doit être coloriée en Color.RED si le tir a touché un navire ou en Color.BLUE s'il est à l'eau.*/
    	boolean tirTouche = super.recoitTir(c);
        if (tirTouche ) 
        	grille.colorie(c, Color.RED);
        else
        	grille.colorie(c, Color.BLUE);
        return tirTouche;   
    }

}
