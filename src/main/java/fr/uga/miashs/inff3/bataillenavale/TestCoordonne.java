package fr.uga.miashs.inff3.bataillenavale;

public class TestCoordonnee {

	public static void testConstructeurs() {
		System.out.println("Test du premier constructeur: ");
		Coordonnee c = new Coordonnee(2, 3);
		if (c.getLigne() != 2 || c.getColonne() != 3) {
			System.out.println("Probleme sur constructeur, erreur sur Coordonnee(2, 3) ");
			return;
		} else {
			System.out.println("Coordonnee(2, 3) vérifiée avec succès");
		}
		try {
			new Coordonnee(-1, -2);
			System.out.println("Probleme sur constructeur, chifre ");
			return;
		} catch (IllegalArgumentException e) {
		}
		System.out.println("----------------");
	}
	
		public static void testConstructeurString() {
	        System.out.println("Test du deuxième constructeur: ");
	        Coordonnee c2 = new Coordonnee("D3");
	        if (c2.getLigne() != 3 || c2.getColonne() != 2) {
	            System.out.println("Problème sur le constructeur, erreur sur Coordonnee(\"D3\")");
	            return;
	        } else {
	            System.out.println("Coordonnee(\"D3\") vérifiée avec succès");   
	     }   System.out.println("----------------");
	   }
	   
		public static void testToString() {
		    System.out.println("Test de la méthode toString(): ");
		    Coordonnee c = new Coordonnee(0, 0);
		    String expected = "A1";
		    String result = c.toString();

		    if (result.equals(expected)) {
		        System.out.println("Méthode toString() vérifiée avec succès. Résultat: " + result);
		    } else {
		        System.out.println("Probleme sur la méthode toString(). Résultat obtenu: " + result + ", Résultat attendu: " + expected);
		    }	System.out.println("----------------");

		}
		
		public static void testGetLigne() {
		    System.out.println("Test de la méthode getLigne(): ");
		    
		    Coordonnee c = new Coordonnee(2, 5);  
		    int expected = 2;  
		    int result = c.getLigne();

		   
		    if (result == expected) {
		        System.out.println("Méthode getLigne() vérifiée avec succès. Résultat: " + result);
		    } else {
		        System.out.println("Problème sur la méthode getLigne(). Résultat obtenu: " + result + ", Résultat attendu: " + expected);
		    }	System.out.println("----------------");
		}

		
		public static void testGetColonne() {
		    System.out.println("Test de la méthode getColonne(): ");
		    
		    Coordonnee c = new Coordonnee(2, 5); 
		    int expected = 5;  
		    int result = c.getColonne();

		    
		    if (result == expected) {
		        System.out.println("Méthode getColonne() vérifiée avec succès. Résultat: " + result);
		    } else {
		        System.out.println("Problème sur la méthode getColonne(). Résultat obtenu: " + result + ", Résultat attendu: " + expected);
		    }	System.out.println("----------------");
		}
		
		public static void testEquals() {
		    System.out.println("Test de la méthode equals(): ");
		    
		    Coordonnee c1 = new Coordonnee(2, 5);
		    Coordonnee c2 = new Coordonnee(2, 5);
		    Coordonnee c3 = new Coordonnee(3, 7);

		   
		    if (c1.equals(c2)) {
		        System.out.println("Méthode equals() vérifiée avec succès pour c1 et c2.");
		    } else {
		        System.out.println("Problème sur la méthode equals() pour c1 et c2.");
		    }

		    if (!c1.equals(c3)) {
		        System.out.println("Méthode equals() vérifiée avec succès pour c1 et c3.");
		    } else {
		        System.out.println("Problème sur la méthode equals() pour c1 et c3.");
		    }	System.out.println("----------------");
		}
		
		public static void testVoisine() {
		    System.out.println("Test de la méthode voisine(): ");
		    
		    Coordonnee c1 = new Coordonnee(2, 5);
		    Coordonnee c2 = new Coordonnee(2, 4); // Coordonnee adyacente a c1
		    Coordonnee c3 = new Coordonnee(0, 0); // Coordonnee non adyacente a c1

		    if (c1.voisine(c2)) {
		        System.out.println("Méthode voisine() vérifiée avec succès pour c1 et c2.");
		    } else {
		        System.out.println("Problème sur la méthode voisine() pour c1 et c2.");
		    }

		    if (!c1.voisine(c3)) {
		        System.out.println("Méthode voisine() vérifiée avec succès pour c1 et c3.");
		    } else {
		        System.out.println("Problème sur la méthode voisine() pour c1 et c3.");
		    }	System.out.println("----------------");
		}
		
		public static void testCompareTo() {
		    System.out.println("Test de la méthode compareTo(): ");
		    
		    Coordonnee c1 = new Coordonnee(2, 5);
		    Coordonnee c2 = new Coordonnee(2, 4); // Meme ligne, colonne menor
		    Coordonnee c3 = new Coordonnee(3, 7); // ligne mayor, meme colone
		    Coordonnee c4 = new Coordonnee(2, 5); // Egal a c1

	
		    if (c1.compareTo(c2) > 0) {
		        System.out.println("Méthode compareTo() vérifiée avec succès pour c1 > c2.");
		    } else {
		        System.out.println("Problème sur la méthode compareTo() pour c1 > c2.");
		    }

		    if (c1.compareTo(c3) < 0) {
		        System.out.println("Méthode compareTo() vérifiée avec succès pour c1 < c3.");
		    } else {
		        System.out.println("Problème sur la méthode compareTo() pour c1 < c3.");
		    }

		    if (c1.compareTo(c4) == 0) {
		        System.out.println("Méthode compareTo() vérifiée avec succès pour c1 == c4.");
		    } else {
		        System.out.println("Problème sur la méthode compareTo() pour c1 == c4.");
		    }
		}




		
		
	
	
	

	
	

	

	public static void main(String[] args) {
	
		
		testConstructeurs();
		testConstructeurString();
		testToString();
		testGetLigne();
		testGetColonne();
		testEquals();
		testVoisine();
		testCompareTo();
		
	}
}