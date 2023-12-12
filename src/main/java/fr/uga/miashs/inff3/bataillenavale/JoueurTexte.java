package fr.uga.miashs.inff3.bataillenavale;
import java.util.Scanner;


public class JoueurTexte {
    private Scanner scanner;

    // Constructeur par défaut
    public JoueurTexte() {
        this.scanner = new Scanner(System.in);
    }

    // Constructeur avec un Scanner en paramètre
    public JoueurTexte(Scanner scanner) {
        this.scanner = scanner;
    }

    // Méthode pour recueillir la saisie de la coordonnée à attaquer
    public Coordonnee choixAttaque() {
        System.out.println("Entrez les coordonnées de votre attaque (format : ligne colonne) :");
        int ligne = scanner.nextInt();
        int colonne = scanner.nextInt();
        return new Coordonnee(ligne, colonne);
    }

    // Méthode pour afficher les étapes de l'attaque à la console
    public void retourAttaque(Coordonnee c, int etat) {
        System.out.println("Attaque en " + c + " - Résultat : " + etat);
    }

    // Méthode pour afficher les étapes de la défense à la console
    public void retourDefense(Coordonnee c, int etat) {
        System.out.println("Défense en " + c + " - Résultat : " + etat);
    }
}

