package fr.uga.miashs.inff3.bataillenavale;
import java.util.Scanner;

public class JoueurTexte extends JoueurAvecGrille {
	
    private Scanner sc;

    public JoueurTexte(GrilleNavale g, String nom) {
		/*permet d'obtenir un joueur de nom nom et jouant sur une grille navale g.*/
		super(g,nom);
	}
	
	public JoueurTexte(GrilleNavale g) {
		/*Cette méthode est invoquée sur le joueur défenseur après le choix de l’attaquant, c est la coordonnée à laquelle l’attaquant a choisi d’effectuer un tir. Elle retourne le résultat du tir qui ne peut être que TOUCHE, COULE, A_L_EAU, ou GAMEOVER.*/
		super(g);
	}

    

    // Méthode pour afficher les étapes de l'attaque à la console pour l'attaque
    protected void retourAttaque(Coordonnee c, int etat) {
        System.out.println("Attaque en " + c);
    }

    // Méthode pour afficher les étapes de la défense à la console pour la défense
    protected void retourDefense(Coordonnee c, int etat) {
        System.out.println("Attaqué en " + c + " - Résultat : " + etat);
    }
    
    public Coordonnee choixAttaque() {
		/*doit recueillir au clavier la saisie de la coordonnée à attaquer.*/
		System.out.println("Entrez les coordonnées de votre attaque (format : colonne ligne) :");
        String s = sc.next();
        return new Coordonnee(s);
	}
}

