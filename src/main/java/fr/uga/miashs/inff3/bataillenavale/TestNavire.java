package fr.uga.miashs.inff3.bataillenavale;

import batailleNavale.Coordonnee;
import batailleNavale.Navire;

public class TestNavire {
	
	public static void testConstructorNavire() {
        System.out.println("Test du constructeur Navire : ");

        // Coordenada de inicio (A1)
        Coordonnee debut1 = new Coordonnee(0, 0);
        int longueur1 = 3;
        boolean estVertical1 = true;

        // Coordenada de inicio (B2)
        Coordonnee debut2 = new Coordonnee(1, 1);
        int longueur2 = 4;
        boolean estVertical2 = false;

        Navire navire1 = new Navire(debut1, longueur1, estVertical1);
        Navire navire2 = new Navire(debut2, longueur2, estVertical2);

        if (navire1.getDebut().equals(debut1) && navire1.getFin().equals(new Coordonnee(2, 0))) {
            System.out.println("Constructeur Navire vérifié avec succès pour le navire1.");
        } else {
            System.out.println("Problème sur le constructeur Navire pour le navire1.");
        }

        if (navire2.getDebut().equals(debut2) && navire2.getFin().equals(new Coordonnee(1, 4))) {
            System.out.println("Constructeur Navire vérifié avec succès pour le navire2.");
        } else {
            System.out.println("Problème sur le constructeur Navire pour le navire2.");
        }

        System.out.println("--------------------");
    }

	public static void testToStringNavire() {
        System.out.println("Test de la méthode toString() de la classe Navire : ");

        // Coordenada de inicio (A1)
        Coordonnee debut1 = new Coordonnee(0, 0);
        int longueur1 = 3;
        boolean estVertical1 = true;

        // Coordenada de inicio (B2)
        Coordonnee debut2 = new Coordonnee(1, 1);
        int longueur2 = 4;
        boolean estVertical2 = false;

        Navire navire1 = new Navire(debut1, longueur1, estVertical1);
        Navire navire2 = new Navire(debut2, longueur2, estVertical2);

        String expected1 = "Navire( A1,3, vertical)";
        if (expected1.equals(navire1.toString())) {
            System.out.println("Méthode toString() vérifiée avec succès pour le navire1. Résultat: " + navire1.toString());
        } else {
            System.out.println("Problème sur la méthode toString() pour le navire1. Résultat obtenu: " + navire1.toString() + ", Résultat attendu: " + expected1);
        }

        String expected2 = "Navire( B2,4, horizontal)";
        if (expected2.equals(navire2.toString())) {
            System.out.println("Méthode toString() vérifiée avec succès pour le navire2. Résultat:" + navire2.toString());
        } else {
            System.out.println("Problème sur la méthode toString() pour le navire2. Résultat obtenu:" + navire2.toString() + ", Résultat attendu: " + expected2);
        } System.out.println("--------------------");
    
}
	
	public static void testGetDebut() {
        System.out.println("Test de la méthode getDebut() de la classe Navire : ");

        // Coordonnee (A1)
        Coordonnee debut1 = new Coordonnee(0, 0);
        int longueur1 = 3;
        boolean estVertical1 = true;

        // Coordonnee (B2)
        Coordonnee debut2 = new Coordonnee(1, 1);
        int longueur2 = 4;
        boolean estVertical2 = false;

     
        Navire navire1 = new Navire(debut1, longueur1, estVertical1);
        Navire navire2 = new Navire(debut2, longueur2, estVertical2);

       
        if (debut1.equals(navire1.getDebut())) {
            System.out.println("Méthode getDebut() vérifiée avec succès pour le navire1. Résultat: " + navire1.getDebut());
        } else {
            System.out.println("Problème sur la méthode getDebut() pour le navire1. Résultat obtenu: " + navire1.getDebut() + ", Résultat attendu: " + debut1);
        }

        if (debut2.equals(navire2.getDebut())) {
            System.out.println("Méthode getDebut() vérifiée avec succès pour le navire2. Résultat: " + navire2.getDebut());
        } else {
            System.out.println("Problème sur la méthode getDebut() pour le navire2. Résultat obtenu: " + navire2.getDebut() + ", Résultat attendu: " + debut2);
    }	System.out.println("--------------------");
}
	
	public static void testGetFin() {
        System.out.println("Test de la méthode getFin() de la classe Navire : ");

        // Coordonnee (A1)
        Coordonnee debut1 = new Coordonnee(0, 0);
        int longueur1 = 3;
        boolean estVertical1 = true;

        // Coordonnee (B2)
        Coordonnee debut2 = new Coordonnee(1, 1);
        int longueur2 = 4;
        boolean estVertical2 = false;

     
        Navire navire1 = new Navire(debut1, longueur1, estVertical1);
        Navire navire2 = new Navire(debut2, longueur2, estVertical2);


        Coordonnee expected1 = new Coordonnee(2, 0);
        if (expected1.equals(navire1.getFin())) {
            System.out.println("Méthode getFin() vérifiée avec succès pour le navire1. Résultat: " + navire1.getFin());
        } else {
            System.out.println("Problème sur la méthode getFin() pour le navire1. Résultat obtenu: " + navire1.getFin() + ", Résultat attendu: " + expected1);
        }

        Coordonnee expected2 = new Coordonnee(1, 4);
        if (expected2.equals(navire2.getFin())) {
            System.out.println("Méthode getFin() vérifiée avec succès pour le navire2. Résultat: " + navire2.getFin());
        } else {
            System.out.println("Problème sur la méthode getFin() pour le navire2. Résultat obtenu: " + navire2.getFin() + ", Résultat attendu: " + expected2);
        }	System.out.println("--------------------");
}
	
	public static void testEstVertical() {
        System.out.println("Test de la méthode estVertical() de la classe Navire : ");

        // Coordenada de inicio (A1)
        Coordonnee debut1 = new Coordonnee(0, 0);
        int longueur1 = 3;
        boolean estVertical1 = true;

        // Coordenada de inicio (B2)
        Coordonnee debut2 = new Coordonnee(1, 1);
        int longueur2 = 4;
        boolean estVertical2 = false;

       
        Navire navire1 = new Navire(debut1, longueur1, estVertical1);
        Navire navire2 = new Navire(debut2, longueur2, estVertical2);

     
        if (navire1.estVertical()) {
            System.out.println("Méthode estVertical() vérifiée avec succès pour le navire1. Résultat: " + navire1.estVertical());
        } else {
            System.out.println("Problème sur la méthode estVertical() pour le navire1. Résultat obtenu: " + navire1.estVertical() + ", Résultat attendu: true");
        }

        if (!navire2.estVertical()) {
            System.out.println("Méthode estVertical() vérifiée avec succès pour le navire2. Résultat: " + navire2.estVertical());
        } else {
            System.out.println("Problème sur la méthode estVertical() pour le navire2. Résultat obtenu: " + navire2.estVertical() + ", Résultat attendu: false");
        }	System.out.println("--------------------");
    
}
	
	public static void testContient() {
        System.out.println("Test de la méthode contient() de la classe Navire : ");

        // Coordenada de inicio (B2)
        Coordonnee debut2 = new Coordonnee(1, 1);
        int longueur2 = 4;
        boolean estVertical2 = false;

        // Coordonne seconde navire
        Coordonnee coordonneeNonContenue2 = new Coordonnee(1, 3);

        Navire navire2 = new Navire(debut2, longueur2, estVertical2);


        if (!navire2.contient(coordonneeNonContenue2)) {
            System.out.println("Méthode contient() vérifiée avec succès pour le navire2. Résultat: false");
        } else {
            System.out.println("Problème sur la méthode contient() pour le navire2. Résultat obtenu: true, Résultat attendu: false");
        }	System.out.println("--------------------");
    
}


   
	public static void testTouche() {
        System.out.println("Test de la méthode touche() de la classe Navire : ");

        // Coordenada  (A1)
        Coordonnee debut1 = new Coordonnee(0, 0);
        int longueur1 = 3;
        boolean estVertical1 = true;

        // Coordenada (B2)
        Coordonnee debut2 = new Coordonnee(1, 1);
        int longueur2 = 4;
        boolean estVertical2 = false;

        // Coordenada (C1)
        Coordonnee debut3 = new Coordonnee(2, 0);
        int longueur3 = 3;
        boolean estVertical3 = true;

        // Coordenada (B5)
        Coordonnee debut4 = new Coordonnee(1, 4);
        int longueur4 = 3;
        boolean estVertical4 = false;

        Navire navire1 = new Navire(debut1, longueur1, estVertical1);
        Navire navire2 = new Navire(debut2, longueur2, estVertical2);
        Navire navire3 = new Navire(debut3, longueur3, estVertical3);
        Navire navire4 = new Navire(debut4, longueur4, estVertical4);

        if (navire1.touche(navire2)) {
            System.out.println("Méthode touche() vérifiée avec succès pour le navire1 et navire2. Résultat: true");
        } else {
            System.out.println("Problème sur la méthode touche() pour le navire1 et navire2. Résultat obtenu: false, Résultat attendu: true");
        }

        if (navire1.touche(navire3)) {
            System.out.println("Méthode touche() vérifiée avec succès pour le navire1 et navire3. Résultat: true");
        } else {
            System.out.println("Problème sur la méthode touche() pour le navire1 et navire3. Résultat obtenu: false, Résultat attendu: true");
        }

        if (!navire1.touche(navire4)) {
            System.out.println("Méthode touche() vérifiée avec succès pour le navire1 et navire4. Résultat: false");
        } else {
            System.out.println("Problème sur la méthode touche() pour le navire1 et navire4. Résultat obtenu: true, Résultat attendu: false");
        }	System.out.println("--------------------");
    
}
	
	public static void testChevaucheBis() {
        System.out.println("Test de la méthode chevauchebis() de la classe Navire : ");

        // Coordenada  (A1)
        Coordonnee debut1 = new Coordonnee(0, 0);
        int longueur1 = 3;
        boolean estVertical1 = true;

        // Coordenada (B5)
        Coordonnee debut4 = new Coordonnee(1, 4);
        int longueur4 = 3;
        boolean estVertical4 = false;

        Navire navire1 = new Navire(debut1, longueur1, estVertical1);
        Navire navire4 = new Navire(debut4, longueur4, estVertical4);

   

        if (!navire1.chevauchebis(navire4)) {
            System.out.println("Méthode chevauchebis() vérifiée avec succès pour le navire1 et navire4. Résultat: false");
        } else {
            System.out.println("Problème sur la méthode chevauchebis() pour le navire1 et navire4. Résultat obtenu: true, Résultat attendu: false");
        }	System.out.println("--------------------");
    
}
	
	public static void testChevauche() {
        System.out.println("Test de la méthode chevauche() de la classe Navire : ");

        // Coordenada de inicio (A1)
        Coordonnee debut1 = new Coordonnee(0, 0);
        int longueur1 = 3;
        boolean estVertical1 = true;


        // Coordenada de inicio (C1)
        Coordonnee debut3 = new Coordonnee(2, 0);
        int longueur3 = 3;
        boolean estVertical3 = true;

        // Coordenada de inicio (B5)
        Coordonnee debut4 = new Coordonnee(1, 4);
        int longueur4 = 3;
        boolean estVertical4 = false;

   
        Navire navire1 = new Navire(debut1, longueur1, estVertical1);
        Navire navire3 = new Navire(debut3, longueur3, estVertical3);
        Navire navire4 = new Navire(debut4, longueur4, estVertical4);


        if (navire1.chevauche(navire3)) {
            System.out.println("Méthode chevauche() vérifiée avec succès pour le navire1 et navire3. Résultat: true");
        } else {
            System.out.println("Problème sur la méthode chevauche() pour le navire1 et navire3. Résultat obtenu: false, Résultat attendu: true");
        }

        if (!navire1.chevauche(navire4)) {
            System.out.println("Méthode chevauche() vérifiée avec succès pour le navire1 et navire4. Résultat: false");
        } else {
            System.out.println("Problème sur la méthode chevauche() pour le navire1 et navire4. Résultat obtenu: true, Résultat attendu: false");
        }	System.out.println("--------------------");
    
}

    

	public static void testRecoitTir() {
        System.out.println("Test de la méthode recoitTir() de la classe Navire : ");

        // Coordenada (B2)
        Coordonnee debut2 = new Coordonnee(1, 1);
        int longueur2 = 4;
        boolean estVertical2 = false;

        Navire navire2 = new Navire(debut2, longueur2, estVertical2);

        // Coordenada que no toca el segundo navire
        Coordonnee coordonneeNonTouchee2 = new Coordonnee(2, 3);

        if (!navire2.recoitTir(coordonneeNonTouchee2)) {
            System.out.println("Méthode recoitTir() vérifiée avec succès pour le navire2. Résultat: false");
        } else {
            System.out.println("Problème sur la méthode recoitTir() pour le navire2. Résultat obtenu: true, Résultat attendu: false");
        }	System.out.println("--------------------");
    
}
	
	public static void testEstTouche() {
	    System.out.println("Test de la méthode estTouche() de la classe Navire : ");

	   
	    // Coordenada de inicio (B2)
	    Coordonnee debut2 = new Coordonnee(1, 1);
	    int longueur2 = 4;
	    boolean estVertical2 = false;
	    
	    Navire navire2 = new Navire(debut2, longueur2, estVertical2);

	    // Coordenada que no toca el segundo navire
	    Coordonnee coordonneeNonTouchee2 = new Coordonnee(2, 3);

	    // Realizar un tir que afecta al primer navire
	    try {
	        if (!navire2.estTouche(coordonneeNonTouchee2)) {
	            System.out.println("Méthode estTouche() vérifiée avec succès pour le navire2. Résultat: false");
	        } else {
	            System.out.println("Problème sur la méthode estTouche() pour le navire2. Résultat obtenu: true, Résultat attendu: false");
	        }

	    } catch (NullPointerException e) {
	        System.out.println("NullPointerException capturada. Vérifiez l'initialisation de partiesTouchees dans la classe Navire.");
	        e.printStackTrace();
	    }

	    System.out.println("--------------------");
	}
	
	
	public static void testEstToucheSans() {
	    System.out.println("Test de la méthode estTouche() de la classe Navire : ");

	    // Coordenada de inicio (A1), longitud 3, disposición vertical
	    Coordonnee debut1 = new Coordonnee(0, 0);
	    int longueur1 = 3;
	    boolean estVertical1 = true;

	    // Coordenada de inicio (B2)
	    Coordonnee debut2 = new Coordonnee(1, 1);
	    int longueur2 = 4;
	    boolean estVertical2 = false;

	    Navire navire1 = new Navire(debut1, longueur1, estVertical1);
	    Navire navire2 = new Navire(debut2, longueur2, estVertical2);

	    // Coordenada que toca el primer navire
	    Coordonnee coordonneeTouchee1 = new Coordonnee(0, 0); 

	    // Realizar un tir que afecta al primer navire
	    navire1.recoitTir(coordonneeTouchee1);


	    if (!navire2.estTouche()) {
	        System.out.println("Méthode estToucheSans() vérifiée avec succès pour le navire2. Résultat: false");
	    } else {
	        System.out.println("Problème sur la méthode estToucheSans() pour le navire2. Résultat obtenu: true, Résultat attendu: false");
	    }

	    System.out.println("--------------------");
	}
	
	
	public static void testEstCoule() {
	    System.out.println("Test de la méthode estCoule() de la classe Navire : ");

	    // Coordenada de inicio (A1), longitud 3, disposición vertical
	    Coordonnee debut1 = new Coordonnee(0, 0);
	    int longueur1 = 3;
	    boolean estVertical1 = true;

	    // Coordenada de inicio (B2)
	    Coordonnee debut2 = new Coordonnee(1, 1);
	    int longueur2 = 4;
	    boolean estVertical2 = false;

	    Navire navire1 = new Navire(debut1, longueur1, estVertical1);
	    Navire navire2 = new Navire(debut2, longueur2, estVertical2);

	    // Coordenadas que tocan todas las partes del primer navire
	    Coordonnee coordonneeTouchee1_1 = new Coordonnee(0, 0); // Ajustar coordenada
	    Coordonnee coordonneeTouchee1_2 = new Coordonnee(1, 0); // Ajustar coordenada
	    Coordonnee coordonneeTouchee1_3 = new Coordonnee(2, 0); // Ajustar coordenada

	    // Realizar tiros que afectan todas las partes del primer navire
	    navire1.recoitTir(coordonneeTouchee1_1);
	    navire1.recoitTir(coordonneeTouchee1_2);
	    navire1.recoitTir(coordonneeTouchee1_3);

	    if (navire1.estCoule()) {
	        System.out.println("Méthode estCoule() vérifiée avec succès pour le navire1. Résultat: true");
	    } else {
	        System.out.println("Problème sur la méthode estCoule() pour le navire1. Résultat obtenu: false, Résultat attendu: true");
	    }

	    // No realizar tiros en el segundo navire

	    if (!navire2.estCoule()) {
	        System.out.println("Méthode estCoule() vérifiée avec succès pour le navire2. Résultat: false");
	    } else {
	        System.out.println("Problème sur la méthode estCoule() pour le navire2. Résultat obtenu: true, Résultat attendu: false");
	    }

	    System.out.println("--------------------");
	}

    
    

    public static void main(String[] args) {
       testConstructorNavire();
       testToStringNavire();
       testGetDebut();
       testGetFin();
       testEstVertical();
       testContient();
       testTouche();
       testChevaucheBis();
       testChevauche();
       testRecoitTir();
       //testEstTouche();
       testEstToucheSans();
       //testEstCoule();
        
        
    }
}