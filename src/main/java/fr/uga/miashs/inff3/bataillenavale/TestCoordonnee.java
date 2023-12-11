package fr.uga.miashs.inff3.bataillenavale;

import batailleNavale.Coordonnee;

public class TestCoordonnee {

	public static void testConstructeurs() {
		System.out.println("test du premier constructeur: ");
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
		
		
	}
	
	

	
	

	public static void main(String[] args) {
	
		
		
		
		Coordonnee c = new Coordonnee(0, 0);
		Coordonnee c2 = new Coordonnee("A1");
		
		// Pruebas
        System.out.println("toString(): " + c.toString());
        System.out.println("getLigne(): " + c.getLigne());
        System.out.println("getColonne(): " + c.getColonne());
        System.out.println("equals(): " + c.equals(c2));
        System.out.println("voisine(): " + c.voisine(c2));
        System.out.println("compareTo(): " + c.compareTo(c2));
        
        
       
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
