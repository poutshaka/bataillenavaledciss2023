package fr.uga.miashs.inff3.bataillenavale;

import java.util.Random;

public class JoueurAutoIntelligent extends JoueurAuto {

    private Coordonnee derniereAttaque;
    private int dernierEtat;

    public JoueurAutoIntelligent(GrilleNavale g, String nom) {
        super(g, nom);
        this.derniereAttaque = null;
        this.dernierEtat = -1;
    }

    public JoueurAutoIntelligent(GrilleNavale g) {
        super(g);
        this.derniereAttaque = null;
        this.dernierEtat = -1;
    }

    @Override
    protected void retourAttaque(Coordonnee c, int etat) {
        super.retourAttaque(c, etat);
        this.derniereAttaque = c;
        this.dernierEtat = etat;
    }

    @Override
    public Coordonnee choixAttaque() {
        if (dernierEtat == TOUCHE) {
            // Si le dernier tir a touché, tire à coté
            return choisirCoordonneeAdjacent(derniereAttaque);
        } else {
            // Sinon, choisissons une coordonnée aléatoire comme avant
            return super.choixAttaque();
        }
    }

    private Coordonnee choisirCoordonneeAdjacent(Coordonnee c) {
        Random random = new Random();
        int direction = random.nextInt(4); // 0: haut, 1: droite, 2: bas, 3: gauche

        int ligne = c.getLigne();
        int colonne = c.getColonne();

        switch (direction) {
            case 0:
                ligne = Math.max(0, ligne - 1);
                break;
            case 1:
                colonne = Math.min(getGrille().getTaille() - 1, colonne + 1);
                break;
            case 2:
                ligne = Math.min(getGrille().getTaille() - 1, ligne + 1);
                break;
            case 3:
                colonne = Math.max(0, colonne - 1);
                break;
        }

        return new Coordonnee(ligne, colonne);
    }
}
