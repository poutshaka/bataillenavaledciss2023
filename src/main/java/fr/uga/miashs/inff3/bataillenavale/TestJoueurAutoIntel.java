package fr.uga.miashs.inff3.bataillenavale;


public class TestJoueurAutoIntel {

    private GrilleNavale grille;
    private JoueurAutoIntelligent joueur;

    public void setUp() {
        // Initialisez vos objets nécessaires ici, par exemple une nouvelle grille
        grille = new GrilleNavale(10, new int[]{5, 2, 6, 2, 3});
        joueur = new JoueurAutoIntelligent(grille, "TestPlayer");
    }

    public void testChoixAttaque() {
        // ...

        // Cas où le dernier tir a touché
        joueur.retourAttaque(new Coordonnee(21, 1), Joueur.TOUCHE);
        Coordonnee attaqueApresTouche = joueur.choixAttaque();
        if (attaqueApresTouche == null) {
            throw new AssertionError("La coordonnée après un tir réussi ne doit pas être nulle.");
        }

        // Cas où le dernier tir n'a pas touché
        joueur.retourAttaque(new Coordonnee(2, 3), Joueur.A_L_EAU);
        Coordonnee attaqueApresEau = joueur.choixAttaque();
        if (attaqueApresEau == null) {
            throw new AssertionError("La coordonnée après un tir dans l'eau ne doit pas être nulle.");
        }
    }

    // ...

    public static void main(String[] args) {
        TestJoueurAutoIntel test = new TestJoueurAutoIntel();
        test.setUp();
        test.testChoixAttaque();

        // Ajoutez des appels à d'autres méthodes de test au besoin
    }
}

