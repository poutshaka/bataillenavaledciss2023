import fr.uga.miashs.inff3.bataillenavale.*;

public class TestJoueurAutoIntel {

    private GrilleNavale grille;
    private JoueurAutoIntelligent joueur;

    public void setUp() {
        // Initialisez vos objets nécessaires ici, par exemple une nouvelle grille
        grille = new GrilleNavale(10, new int[]{5, 4, 3, 3, 2});
        joueur = new JoueurAutoIntelligent(grille, "TestPlayer");
    }

    public void testChoixAttaque() {
        // Testez le comportement de choixAttaque() en fonction des différents scénarios possibles

        // Cas où le dernier tir a touché
        joueur.retourAttaque(new Coordonnee(1, 1), Joueur.TOUCHE);
        Coordonnee attaqueApresTouche = joueur.choixAttaque();
        if (attaqueApresTouche == null) {
            throw new AssertionError("La coordonnée après un tir réussi ne doit pas être nulle.");
        }
        assertTrue(grille.getTirs().contains(attaqueApresTouche));

        // Cas où le dernier tir n'a pas touché
        joueur.retourAttaque(new Coordonnee(2, 2), Joueur.A_L_EAU);
        Coordonnee attaqueApresEau = joueur.choixAttaque();
        assertNonNull(attaqueApresEau);
        assertTrue(grille.getTirs().contains(attaqueApresEau));
    }

    public static void main(String[] args) {
        TestJoueurAutoIntel test = new TestJoueurAutoIntel();
        test.setUp();
        test.testChoixAttaque();

        // Ajoutez des appels à d'autres méthodes de test au besoin
    }
}

