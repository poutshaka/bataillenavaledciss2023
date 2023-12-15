package fr.uga.miashs.inff3.bataillenavale;


import java.awt.Color;
import javax.swing.JOptionPane;

public class JoueurGraphique extends JoueurAvecGrille {
	
    private GrilleGraphique grilleTirs;
    private GrilleNavaleGraphique grilleDefense;
    

    
   
    /* Permite obtener un jugador gráfico de nombre "nom" que realiza disparos al hacer clic en
     * la "grilleTirs" y cuya flota está ubicada en "grilleDefense".
     */
    public JoueurGraphique(GrilleNavaleGraphique grilleDefense, GrilleGraphique grilleTirs, String nom) {
        super(grilleDefense, nom);
        this.grilleTirs = grilleTirs;
    }

    /* Permite obtener un jugador gráfico que realiza disparos al hacer clic en "grilleTirs" y
     * cuya flota está ubicada en "grilleDefense".
     */
    
    public JoueurGraphique(GrilleNavaleGraphique grilleDefense, GrilleGraphique grilleTirs) {
        super(grilleDefense);
        this.grilleTirs = grilleTirs;
    }
    
    /* Consiste en recuperar la coordenada seleccionada desde "grilleTirs". */
    public Coordonnee choixAttaque() {
        return grilleTirs.getCoordonneeSelectionnee();
    }
    
    /* Muestra un JOptionPane cuando el disparo ha tocado o hundido un barco, o cuando se ha
     * perdido la partida.
     */
    protected void retourDefense(Coordonnee c, int etat) {
        switch(etat) {
            case TOUCHE:
                JOptionPane.showMessageDialog(grilleDefense.getGrilleGraphique(), "Vous avez touché un navire en " + c);
                break;
            case COULE:
                JOptionPane.showMessageDialog(grilleDefense.getGrilleGraphique(), "Vous avez coulé un navire en " + c);
                break;
            case GAMEOVER:
                JOptionPane.showMessageDialog(grilleDefense.getGrilleGraphique(), "Vous avez perdu!!!");
                break;
        }
    }
    
    
    protected void retourAttaque(Coordonnee c, int etat) {
        Color couleur = etat == A_L_EAU ? Color.BLUE : Color.RED;
        grilleTirs.colorie(c, couleur);
        switch (etat) {
            case TOUCHE:
                JOptionPane.showMessageDialog(grilleTirs, "Vous avez touché un navire en " + c);
                break;
            case COULE:
                JOptionPane.showMessageDialog(grilleTirs, "Vous avez coulé un navire en " + c);
                break;
            case GAMEOVER:
                JOptionPane.showMessageDialog(grilleTirs, "Vous avez gagné!!!");
                break;
        }
    }
}
