package fr.uga.miashs.inff3.bataillenavale;

import batailleNavale.Coordonnee;

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
	         }   
	 }
	
	public static void testToString() {
		System.out.println("Test de la méthode toString(): ");
		Coordonnee c = new Coordonnee(1, 2);
		String expected = "B2";
		String result = c.toString();


		    if (result.equals(expected)) {
		        System.out.println("Méthode toString() vérifiée avec succès. Résultat: " + result);
		    } else {
		        System.out.println("Probleme sur la méthode toString(). Résultat obtenu: " + result + ", Résultat attendu: " + expected);
		    
		}
	}
	
	
		
	
	

	//
	

	public static void main(String[] args) {
	
		
		testConstructeurs();
		testConstructeurString();
		testToString();
		
		
		
		//
		/*Coordonnee c = new Coordonnee(0, 0);
		Coordonnee c2 = new Coordonnee("A1");
		
		// Pruebas
        System.out.println("toString(): " + c.toString());
        System.out.println("getLigne(): " + c.getLigne());
        System.out.println("getColonne(): " + c.getColonne());
        System.out.println("equals(): " + c.equals(c2));
        System.out.println("voisine(): " + c.voisine(c2));
        System.out.println("compareTo(): " + c.compareTo(c2));
        */
        
       
	}

}
