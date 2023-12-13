package fr.uga.miashs.inff3.bataillenavale;




public class TestNavire {


	public static void main(String[] args) {
	        testConstructor();
	        testToString();
	        testContient();
	        testChevauche();
	        testRecoitTir();
	        testEstTouche();
	        //testEstCoule();
	    }

	    public static void testConstructor() {
	        Coordonnee debut = new Coordonnee(1, 1);
	        int longueur = 4;
	        boolean estVertical = true;

	        Navire navire = new Navire(debut, longueur, estVertical);

	        System.out.println(navire.getDebut().equals(debut));
	        System.out.println(navire.getFin().equals(new Coordonnee(4, 1)));
	        System.out.println(navire.estVertical() == estVertical);
	        System.out.println("--------------------");
	    }

	    public static void testToString() { //volver a hacer
	        Coordonnee debut = new Coordonnee(1, 1);
	        int longueur = 4;
	        boolean estVertical = true;

	        Navire navire = new Navire(debut, longueur, estVertical);

	        String expected = "Navire(debut=B1, 4, vertical)";
	        System.out.println(navire.toString().equals(expected));
	        System.out.println("--------------------");
	    }


	    public static void testContient() {
	        Coordonnee debut = new Coordonnee(1, 1);
	        int longueur = 4;
	        boolean estVertical = true;

	        Navire navire = new Navire(debut, longueur, estVertical);

	        Coordonnee c1 = new Coordonnee(2, 1);
	        Coordonnee c2 = new Coordonnee(5, 1);
	        Coordonnee c3 = new Coordonnee(1, 2);
	        Coordonnee c4 = new Coordonnee(1, 5);

	        System.out.println(navire.contient(c1));
	        System.out.println(!navire.contient(c2));
	        System.out.println(navire.contient(c3));
	        System.out.println(!navire.contient(c4));
	        System.out.println("--------------------");
	    }

	    public static void testEstTouche() {
	        Coordonnee debut = new Coordonnee(1, 1);
	        int longueur = 4;
	        boolean estVertical = true;

	        Navire navire = new Navire(debut, longueur, estVertical);

	        Navire navireAdjacent = new Navire(new Coordonnee(5, 1), 3, true);
	        Navire navireNonAdjacent = new Navire(new Coordonnee(5, 5), 3, true);

	        System.out.println(navire.touche(navireAdjacent));
	        System.out.println(!navire.touche(navireNonAdjacent));
	        System.out.println("--------------------");
	    }

	    public static void testChevauche() {
	        Coordonnee debut = new Coordonnee(1, 1);
	        int longueur = 4;
	        boolean estVertical = true;

	        Navire navire = new Navire(debut, longueur, estVertical);

	        Navire navireChevauchant = new Navire(new Coordonnee(2, 1), 3, true);
	        Navire navireNonChevauchant = new Navire(new Coordonnee(5, 1), 3, true);

	        System.out.println(navire.chevauche(navireChevauchant));
	        System.out.println(!navire.chevauche(navireNonChevauchant));
	        System.out.println("--------------------");
	    }

	    public static void testRecoitTir() {
	        Coordonnee debut = new Coordonnee(1, 1);
	        int longueur = 4;
	        boolean estVertical = true;

	        Navire navire = new Navire(debut, longueur, estVertical);

	        Coordonnee c1 = new Coordonnee(2, 1);
	        Coordonnee c2 = new Coordonnee(5, 1);

	        System.out.println(navire.recoitTir(c1));
	        System.out.println(!navire.recoitTir(c2));
	        System.out.println("--------------------");
	    }
	


	

}
