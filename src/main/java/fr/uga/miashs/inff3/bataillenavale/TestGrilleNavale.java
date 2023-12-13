package fr.uga.miashs.inff3.bataillenavale;


public class TestGrilleNavale {

	public static void testConstructoresetToString() {
        System.out.println("Test de constructores y toString:");

        int tailleGrille = 5;
        int[] taillesNavires = {3, 4, 2};

        // Constructor con taillesNavires
        GrilleNavale grille1 = new GrilleNavale(tailleGrille, taillesNavires);
        
        System.out.println(grille1.toString());

        // Constructor con nbNavires
        GrilleNavale grille2 = new GrilleNavale(tailleGrille, 5);
        System.out.println(grille2.toString());

        
    }

	public static void main(String[] args) {
		testConstructoresetToString();

	}

}
