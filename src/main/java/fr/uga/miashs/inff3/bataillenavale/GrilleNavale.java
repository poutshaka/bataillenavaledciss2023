package fr.uga.miashs.inff3.bataillenavale;

public class GrilleNavale {

	private Navire[] navires;
	private int nbNavires;
	private int taille;
	private Coordonnee[] tirsRecus;
	private int nbTirsRecus;
	
//_________________________Constructeur 1 ______________________________________________________________
		
		/* permet d'obtenir une grille navale de taille taille dans laquelle ont été
		 * placés automatiquement taillesNavires.length navires dont les tailles sont données dans taillesNavires.
		 */

	public GrilleNavale(int taille, int[] taillesNavires) {
		if (taille < 0 || taille > 26)
			throw new IllegalArgumentException("taille de la grille incorrecte");

		this.taille = taille;
		this.navires = new Navire[taillesNavires.length];
		this.tirsRecus = new Coordonnee[taille * taille];
		this.nbTirsRecus = 0;
		this.nbNavires = taillesNavires.length ;
	}
//____________________________Constructeur 2___________________________________________________
	 
	/* permet d'obtenir une grille navale vide de taille taille pouvant accueillir jusqu'à nbNavires.*/
	 
	public GrilleNavale(int taille, int nbNavires) {
		
		if (taille < 0 || taille > 26)
			throw new IllegalArgumentException("taille de la grille incorrecte");

		this.taille = taille;
		this.navires = new Navire[nbNavires];
		this.tirsRecus = new Coordonnee[taille * taille];
		this.nbNavires = nbNavires; // nbNavires
		this.nbTirsRecus = 0;
	}
	
//_________________________________toString_________________________________________
	public String toString() {
		StringBuffer grille = new StringBuffer();
		grille.append(" ");
		for (int i = 0; i < taille; i++) {
			grille.append((char) ('A' + i)).append(" ");
		}
		grille.append("\n");

		for (int i = 0; i < taille; i++) {
			grille.append(i + 1).append(" ");
			for (int j = 0; j < taille; j++) {
				Coordonnee c = new Coordonnee(i, j);
				if (estTouche(c)) {
					grille.append("X ");
				} else if (estALEau(c)) {
					grille.append("O ");
				} else if (contientNavire(c)) {// normalement c'est la méthode contient de la classe navir
					grille.append("# ");
				} else {
					grille.append(". ");
				}
			}
			grille.append("\n");
		}
		return grille.toString();
	}
//______________________________________________________________________________________________
	public int getTaille() {
		/*Accesseur en lecture.*/
		return taille;
	}
//___________________________________________Ajouter un Navire____________________________________________________	
	
	 /* Retourne true après avoir ajouté n à this si cet ajout est possible. L'ajout
	 * est impossible si n touche ou chevauche un navire déjà présent dans this, ou
	 * encore si n dépasse les limites de this.
	 */
//chevauche est une méthode de la classe Navire il faut l'utiliser en conséquence en parcourant les différents navires

	public boolean ajouteNavire(Navire n) {

		if (this.estDansGrille(n.getFin()) && this.estDansGrille(n.getDebut())) {
			for (int i = 0; i < this.nbNavires; i++) {
				if (this.navires[i].touche(n) || this.navires[i].chevauche(n)) {
					
					return false;
				}
			}

			this.navires[nbNavires++] = n;
			
			return true;
		}
		
		return false;

	}

//----------------------------------------------- placementAuto ------------------------------------------------------------------------------------------------------------------------------------
// Place automatiquement et al�atoirement taillesNavires.length navires dont les tailles sont donn�es dans taillesNavire.

	public void placementAuto(int[] taillesNavires) {

		int i = 0;
		if (taillesNavires.length > this.navires.length) {
			System.out.println("La grille doit contenir au max " + this.navires.length + " navires");
		} else
			while (i < taillesNavires.length) {
				// (MIN + (MAX-MIN)*MATH.RANDOM + 1)
				boolean estVertical = Math.random() < 0.5;
				int lignedebut = 0;// probabilit� de tirage vert/hor 50%
				int coldebut = 0;
				if (estVertical) {
					lignedebut = (int) ((this.taille - taillesNavires[i]+1) * Math.random());
					coldebut = (int) ((this.taille) * Math.random());
				} else {
					lignedebut = (int) ((this.taille) * Math.random());
					coldebut = (int) ((this.taille - taillesNavires[i]+1) * Math.random());
				}

				// if (lignedebut<0 || lignedebut >25 || coldebut < 0 || coldebut> 25)
				// continue;

				// int lignedebut = ((int) ( (this.taille+1)*Math.random()));
				// int coldebut = ((int) ( (this.taille+1)*Math.random()));
				Coordonnee coordonneedebut = new Coordonnee(lignedebut, coldebut);
				Navire n = new Navire(coordonneedebut, taillesNavires[i], estVertical);
				if (ajouteNavire(n)) {
					i++;
				}
			}
	}


//----------------------------------------------- estDansTirsRecus ------------------------------------------------------------------------------------------------------------------------------------
// Retourne true si et seulement si c correspond � un tir re�u par this.

	private boolean estDansTirsRecus1(Coordonnee c) {
 if(!estDansGrille(c)) {
	 return false;
 }else 
		if (nbTirsRecus != 0) {
			for (int i = 0; i < nbTirsRecus; i++) {// tirs re�us sont stock� dans un tableau voir attributs
				if (this.tirsRecus[i].equals(c)) {// appel a la methode equals de la classe coordonee
					return true;
				}
			}
		}
		return false;

	}
//________________________________________estDansGrille_____________________________________________
	private boolean estDansGrille(Coordonnee c) {
		/*Retourne true si et seulement si c est dans this.*/
//attention les numéros de lignes et colonnes vont de 0 à taille -1
		return c.getLigne() >= 0 && c.getLigne() < this.taille -1  && c.getColonne() >= 0 && c.getColonne() < this.taille -1 ; 
	}

//_______________________________________________________________________________________________

<<<<<<< HEAD
	       /* for (int i = 0; i < taille; i++) {
	            grille.append(i + 1).append(" ");
	            for (int j = 0; j < taille; j++) {
	                Coordonnee c = new Coordonnee(i, j);
	                if (estTouche(c)) {
	                    grille.append("X ");
	                } else if (estALEau(c)) {
	                    grille.append("O ");
	                } else if (contientNavire(c)) {//normalement c'est la méthode contient de la classe navir
	                    grille.append("# ");
	                } else {
	                    grille.append(". ");
	                }
	            }
	            grille.append("\n");
	        }
	        return grille.toString();
	    }*/

 
//____________________________________________contientNavire_________________________________________________________________
	    
	    public boolean contientNavire(Coordonnee c) {// j'ai ajouté cette méthode pour pouvoir écrire la méthode string tosting
	        for (int i = 0; i < navires.length; i++) {
	            Navire n = navires[i];
	            if (n.contient(c)) {
	                return true;
	            }
	        }
	        return false;
	    }
//_____________________________________________estDansTirsRecus_________________________________________________________________
	    /* Retourne true si et seulement si c correspond à un tir reçu par this. */
	    
	    private boolean estDansTirsRecus(Coordonnee c) {
	    	if (!estDansGrille(c)) {
	        return false;
	     } else if (nbTirsRecus != 0) {
	        for (int i = 0; i < nbTirsRecus; i++) {
	            if (this.tirsRecus[i].equals(c)) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
//________________________________________ajouteDansTirsRecus____________________________________________________________
	    
		 /* Ajoute c aux tirs reçus de this si nécessaire. Retourne true si et seulement
		 * si this est modifié.*/
		 
//Attention la coordonnée peut ne pas faire partie de la grille. Il faut aussi vérifier si le tableau tirsRecus n'est pas déjà plein
	    private boolean ajouteDansTirsRecus(Coordonnee c) {
	    	
	    	if (!estDansTirsRecus1(c)&& (estDansGrille(c) && (nbTirsRecus < tirsRecus.length))) {
	    		tirsRecus[nbTirsRecus++]=c;
	    		return true; 
	    }
	    return false; 
	    }
 //_____________________________________recoitTir_____________________________________________________________	    
	    
		 /* Ajoute c aux tirs reçus de this si nécessaire. Retourne true si et seulement 
		 * si c ne correspondait pas déjà à un tir reçu et a permis de toucher un 
		 * navire de this. */
		 
//Il faut vérifier que la coordonnée soit dans la grille et que ajouteDansTirsRecus soit vrai puis vérifier que la coordonnée soit bien celle d'un navire touché
	    
	    public boolean recoitTir(Coordonnee c) {
			boolean tir = ajouteDansTirsRecus(c);
			boolean touche = false;
			if (tir) {
				int i = 0;
				while (i < nbNavires && !touche) {
					if (navires[i].recoitTir(c))
						touche = true;
					i++;
				}
			}

			return touche;
		}

//__________________________________estTouche__________________________________________________________________
	    /* Retourne true si et seulement si un des navires présents dans this a été touché en c. */
	    public boolean estTouche(Coordonnee c) {
	 
	    	for (int i = 0; i < nbNavires; i++) {
	    		if (this.navires[i].estTouche(c))
					
					return true;
			}
			return false;
		}
//__________________________________estALEau____________________________________________________________________	    	   
	    
		 /* Retourne true si et seulement si c correspond à un tir reçu dans l'eau par this.*/
		 
	    public boolean estALEau(Coordonnee c) {
	        return !(estTouche(c)); 
	    }
//__________________________________estCoule____________________________________________________________________	    
	    
		 /* Retourne true si et seulement si un des navires présents dans this a été
		 * touché en c et est coulé */
	   
	    public boolean estCoule(Coordonnee c) {
	    	
	    	for(int i=0; i<nbNavires; i++) {
	    		
	    		if (this.navires[i].estTouche(c) && this.navires[i].estCoule()) {
	    	return true; 
	    		}
	    	}
	    		return false; 
	    }
//___________________________________perdu_____________________________________________________________________
	    /* Retourne true si et seulement si tous les navires de this ont été coulés. */
	    
	    public boolean perdu() {
	    	
	    		for (int i = 0; i < this.nbNavires; i++)
	    			if (!(this.navires[i].estCoule()))
	    				return false;
	    		
	    		return true;
	    	}

	}
	

	

	
