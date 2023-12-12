package fr.uga.miashs.inff3.bataillenavale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJoueur {

	public TestJoueur() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		testConstructeur(); 

	}
    public static void testConstructeur() {
        int tailleGrille = 10;
        String nom = "Joueur1";
        
        Joueur joueur = new JoueurImpl(tailleGrille, nom);
        
        assertEquals(tailleGrille, joueur.getTailleGrille());
        assertEquals(nom, joueur.getNom());
    }
    
    private static class JoueurImpl extends Joueur {
        public JoueurImpl(int tailleGrille, String nom) {
            super(tailleGrille, nom);
        }
    }
}

		