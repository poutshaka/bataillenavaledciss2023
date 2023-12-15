package fr.uga.miashs.inff3.bataillenavale;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JoueurAutoIntelligent extends JoueurAuto{

    private Coordonnee derniereAttaque;
    private int dernierEtat;
    private List<Coordonnee> coordonneesDejaAttaquees;

    public JoueurAutoIntelligent(GrilleNavale g, String nom) {
        super(g, nom);
        this.derniereAttaque = null;
        this.dernierEtat = -1;
        this.coordonneesDejaAttaquees = new ArrayList<>();
    }

    public JoueurAutoIntelligent(GrilleNavale g) {
        super(g);
        this.derniereAttaque = null;
        this.dernierEtat = -1;
        this.coordonneesDejaAttaquees = new ArrayList<>();
    }

    
    protected void retourAttaque(Coordonnee c, int etat) {
        super.retourAttaque(c, etat);
        this.derniereAttaque = c;
        this.dernierEtat = etat;
        coordonneesDejaAttaquees.add(c);
    }

   
    public Coordonnee choixAttaque() {
        if (dernierEtat == TOUCHE) {
     
            // Si le dernier tir a touché, tire à coté
            return choisirCoordonneeAdjacent(derniereAttaque);
            
        } else {
        	
            // Sinon, choisi une coordonnée aléatoire non attaquée
            return choisirCoordonneeAleatoireNonAttaquee();
          
        }
    }

    private Coordonnee choisirCoordonneeAdjacent(Coordonnee c) {
        Random random = new Random();

        int taille = getGrille().getTaille();
        int ligne = c.getLigne();
        int colonne = c.getColonne();

        int direction;
        int nouvelLigne;
        int nouvelColonne;
        int A=0;
        int B=0;
        int C=0;
        int D=0;

        do {
            direction = random.nextInt(4); // 0: haut, 1: droite, 2: bas, 3: gauche

            switch (direction) {
                case 0:
                    nouvelLigne = Math.max(0, ligne - 1);
                    nouvelColonne = colonne;
                    A++;
                    break;
                case 1:
                    nouvelLigne = ligne;
                    nouvelColonne = Math.min(taille - 1, colonne + 1);
                    B++;
                    break;
                case 2:
                    nouvelLigne = Math.min(taille - 1, ligne + 1);
                    nouvelColonne = colonne;
                    C++;
                    break;
                case 3:
                    nouvelLigne = ligne;
                    nouvelColonne = Math.max(0, colonne - 1);
                    D++;
                    break;
                default:
                    nouvelLigne = ligne;
                    nouvelColonne = colonne;
            }
            if(A>0 && B>0 && C>0 && D>0)
            	nouvelLigne= (int)(Math.random()*taille);
            	nouvelColonne= (int)(Math.random()*taille);
        } while (coordonneesDejaAttaquees.contains(new Coordonnee(nouvelLigne, nouvelColonne)) || getGrille().estDansTirsRecus(new Coordonnee(nouvelLigne, nouvelColonne)));

        return new Coordonnee(nouvelLigne, nouvelColonne);
    }

    private Coordonnee choisirCoordonneeAleatoireNonAttaquee() {
        Random random = new Random();
        int taille = getGrille().getTaille();
        Coordonnee coordonnee;

        do {
            int ligne = random.nextInt(taille);
            int colonne = random.nextInt(taille);
            coordonnee = new Coordonnee(ligne, colonne);
        } while (getGrille().estDansTirsRecus(coordonnee));

        return coordonnee;
    }
}

    
