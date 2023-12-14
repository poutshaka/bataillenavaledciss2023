package fr.uga.miashs.inff3.bataillenavale;


public class TestGrilleNavale {

	public static void testConstructoresetToString() {
        System.out.println("Test de constructores et toString:");

        int tailleGrille = 5;
        int[] taillesNavires = {3, 4, 2};

        // Constructor avec taillesNavires
        GrilleNavale grille1 = new GrilleNavale(tailleGrille, taillesNavires);
        
        System.out.println(grille1.toString());

        // Constructor avec nbNavires
        GrilleNavale grille2 = new GrilleNavale(tailleGrille, 5);
        System.out.println(grille2.toString());

        
    }
	
	public static void testAjouteNavireYPlacementAuto() {
        System.out.println("Test de ajouteNavire et placementAuto:");

        int tailleGrille = 10;
        int[] taillesNavires = {3, 4, 2};

        GrilleNavale grille = new GrilleNavale(tailleGrille, taillesNavires);

        // add navire
        Navire navire = new Navire(new Coordonnee(0, 0), 3, true);
        boolean ajoutPossible = grille.ajouteNavire(navire);
        System.out.println("Ajoute navire possible: " + ajoutPossible);
        System.out.println(grille.toString());

        // add navire automátiquement
        grille.placementAuto(taillesNavires);
        System.out.println("Après placement auto:");
        System.out.println(grille.toString());

    }

    public static void testRecoitTiretMetodosRelacionados() {
        System.out.println("Test de recoitTir et métodos relacionados:");

        int tailleGrille = 10;
        int[] taillesNavires = {3, 4, 2};

        GrilleNavale grille = new GrilleNavale(tailleGrille, taillesNavires);

        // Recoit un tir et verifie métodos relacionados
        Coordonnee tirCoord = new Coordonnee(0, 0);
        boolean tirCorrecto = grille.recoitTir(tirCoord);
        System.out.println("Tir correct: " + tirCorrecto);
        System.out.println("Après tir:");
        System.out.println(grille.toString());

        boolean estTouche = grille.estTouche(tirCoord);
        boolean estALEau = grille.estALEau(tirCoord);
        boolean estCoule = grille.estCoule(tirCoord);
        System.out.println("Est touché: " + estTouche);
        System.out.println("Est à l'eau: " + estALEau);
        System.out.println("Est coulé: " + estCoule);

    }

	public static void main(String[] args) {
		testConstructoresetToString();
		testAjouteNavireYPlacementAuto();
		testRecoitTiretMetodosRelacionados();
		

	}

}
