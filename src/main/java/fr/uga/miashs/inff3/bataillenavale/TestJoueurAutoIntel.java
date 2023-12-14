import fr.uga.miashs.inff3.bataillenavale.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
        assertNotNull(attaqueApresTouche);
        assertTrue(grille.getTirs().contains(attaqueApresTouche));

        // Cas où le dernier tir n'a pas touché
        joueur.retourAttaque(new Coordonnee(2, 2), Joueur.A_L_EAU);
        Coordonnee attaqueApresEau = joueur.choixAttaque();
        assertNotNull(attaqueApresEau);
        assertTrue(grille.getTirs().contains(attaqueApresEau));
    }

    // Ajoutez d'autres méthodes de test au besoin

}
