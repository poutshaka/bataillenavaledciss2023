package fr.uga.miashs.inff3.bataillenavale;

import java.awt.EventQueue;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

public class FenetreJoueur extends JFrame {

	private JPanel contentPane;
	private GrilleGraphique grilleTirs;
	private GrilleNavaleGraphique grilleDefense;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreJoueur frame = new FenetreJoueur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreJoueur() {
		this("Mattéo le plus beau",10);
	}
	
    public FenetreJoueur(String nom, int taille) {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle(nom);
		contentPane = new JPanel();
		

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 2, 0, 0));
		
		grilleTirs = new GrilleGraphique(taille);
		JPanel panelTirs = grilleTirs;
		panelTirs.setBorder(new TitledBorder(null, "Grille de Tirs", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelTirs);
		
		grilleDefense = new GrilleNavaleGraphique(taille);
		JPanel panelDefense = grilleDefense.getGrilleGraphique();
		panelDefense.setBorder(new TitledBorder(null, "Grille de D\u00E9fense", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelDefense);
		
		int minBateaux = 1 ;int maxBateaux = 6;
		int minLongueur=1; int maxLongueur=5;
		int nombreBateaux = (int) (taille / 2);
	    int[] taillesNavires = new int[nombreBateaux];
	    for (int i = 0; i < nombreBateaux; i++) {
	        taillesNavires[i] = (int) (Math.random() * (maxLongueur - minLongueur + 1) + minLongueur);
	    }
	    
	    grilleDefense.placementAuto(taillesNavires);
		System.out.println(grilleDefense);
	}
    
    public GrilleGraphique getGrilleTirs() {
    	/*Accesseur en lecture pour grilleTirs.*/
    	return grilleTirs;
    }
    
    public GrilleNavaleGraphique getGrilleDefense() {
    	/*Accesseur en lecture pour grilleDefense.*/
    	return grilleDefense;
    }

}
