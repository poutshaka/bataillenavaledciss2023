package fr.uga.miashs.inff3.bataillenavale;


public abstract class JoueurAvecGrille extends Joueur {
	
private GrilleNavale grille;

	public GrilleNavale getGrille() {
		return grille;
	}
	
	public JoueurAvecGrille(GrilleNavale g, String nom) {
		/*permet d'obtenir un joueur de nom nom et jouant sur une grille navale g.*/
		super(g.getTaille(), nom);
		this.grille = g;
	}
	
	public JoueurAvecGrille(GrilleNavale g) {
		/*permet d'obtenir un joueur jouant sur une grille navale g.*/
		super(g.getTaille());
		this.grille = g;
	}
	

	public int defendre(Coordonnee c) {
        grille.recoitTir(c);
        /*Cette méthode est invoquée sur le joueur défenseur après le choix de l’attaquant, c est la coordonnée à laquelle l’attaquant a choisi d’effectuer un tir. Elle retourne le résultat du tir qui ne peut être que TOUCHE, COULE, A_L_EAU, ou GAMEOVER.*/
        if (grille.estTouche(c)) {
            if (grille.estCoule(c)) {
                if (grille.perdu()) {
                    return Joueur.GAMEOVER;
            }
            return Joueur.COULE;
            } else {
                return Joueur.TOUCHE;
            }
        } else if (grille.estALEau(c)) {
            return Joueur.A_L_EAU;
        } else {
            throw new IllegalArgumentException("Coordonnées hors limite");
        }
    }

}
