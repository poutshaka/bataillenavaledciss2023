package fr.uga.miashs.inff3.bataillenavale;


public class TestJoueurAutoIntel {

    public static void main(String[] args) {
        // Créez une grille pour le test
       GrilleNavale grille = new GrilleNavale(10, new int[]{5, 4, 3, 3, 2});
    	/* GrilleNavale grille = new GrilleNavale(10, 1);
    	 grille.ajouteNavire(new Navire(new Coordonnee("A1"),1,false));
    	 
    	 System.out.println(grille);
    	 
    	 boolean res = grille.recoitTir(new Coordonnee("A1"));
    	 System.out.println(res);*/
    	 
        // Créez un joueur auto intelligent pour tester
        JoueurAutoIntelligent joueur = new JoueurAutoIntelligent(grille, "TestPlayer");

        // Affichez la grille initiale
        System.out.println("Grille initiale du joueur:");
        System.out.println(grille.toString());

        // Effectuez quelques tirs et affichez les résultats
        for (int i = 0; i < 10; i++) {
            // Affichez l'état actuel de la grille avant le tir
            System.out.println("Avant le tir " + (i + 1) + ":");
            System.out.println(grille.toString());

            // Effectuez le tir
            Coordonnee attaque = joueur.choixAttaque();
            boolean touche = grille.recoitTir(attaque);
            boolean coule = grille.estCoule(attaque);

            // Affichez les résultats du tir
            System.out.println("Tir " + (i + 1) + ": Attaque à la coordonnée " + attaque.toString() +
                    ", Résultat: Touche - " + touche + ", Coule - " + coule);

            // Affichez l'état de la grille après le tir
            System.out.println("Après le tir " + (i + 1) + ":");
            System.out.println(grille.toString());

          
        }
    }
}
