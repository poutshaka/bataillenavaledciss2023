package fr.uga.miashs.inff3.bataillenavale;

import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;


public class BatailleNaval {

	private JFrame frmBatailleNavale;
	private JTextField taillegrille;
	private JTextField LeNomJ1;
	private JTextField LeNomJ2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	
	private Joueur j1, j2;
	
	private int tailleGrille;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BatailleNaval window = new BatailleNaval();
					window.frmBatailleNavale.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	private void demarrerPartie() {
		new Thread() {
		public void run() {
		j1.jouerAvec(j2);
		}
		}.start();
		}
	
	/**
	 * Create the application.
	 */
	public BatailleNaval() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBatailleNavale = new JFrame();
		frmBatailleNavale.setTitle("Bataille Navale");
		frmBatailleNavale.setBounds(100, 100, 653, 478);
		frmBatailleNavale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelHaut = new JPanel();
		frmBatailleNavale.getContentPane().add(panelHaut, BorderLayout.NORTH);
		panelHaut.setLayout(new BoxLayout(panelHaut, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("Taille de Grille :");
		panelHaut.add(lblNewLabel);
		
		taillegrille = new JTextField();
		panelHaut.add(taillegrille);
		taillegrille.setColumns(10);
		
		JPanel panelBas = new JPanel();
		frmBatailleNavale.getContentPane().add(panelBas, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Lancer la Partie");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				
				//  lancer la partie

				// récupération des variables
				
				int taille = Integer.parseInt(taillegrille.getText());
				String NomJ1 = LeNomJ1.getText();
				String NomJ2 = LeNomJ2.getText();
				String j1Type = (J1G.isSelected())?"Graphique":((j1Text.isSelected())?"Texte":"Auto");
				String j2Type = (J2G.isSelected())?"Graphique":((j2Texte.isSelected())?"Texte":"Auto");

				// création des instances

				int[] taillesNavires = {2,3,3,4,5};

				if (j1Type == "Graphique") {
					

					FenetreJoueur f1 = new FenetreJoueur("NomJ1",10);
					f1.pack(); 
	                f1.setVisible(true); 
					j1 = new JoueurGraphique(f1.getGrilleDefense(), f1.getGrilleTirs(), NomJ1);

				}
				else if (j1Type == "Texte") {
					GrilleNavale g = new GrilleNavale(taille, taillesNavires);
					j1 = new JoueurTexte(g, NomJ1);
				}
				else {
					GrilleNavale g = new GrilleNavale(taille, taillesNavires);
					j1 = new JoueurAuto(g, NomJ1);
				}

				if (j2Type == "Graphique") {

					FenetreJoueur f2 = new FenetreJoueur("NomJ2",10);
					f2.pack();
	                f2.setVisible(true);
					j2 = new JoueurGraphique(f2.getGrilleDefense(), f2.getGrilleTirs(), NomJ2);

				}
				else if (j2Type == "Texte") {
					GrilleNavale g = new GrilleNavale(taille, taillesNavires);
					j2 = new JoueurTexte(g, NomJ2);
				}
				else {
					GrilleNavale g = new GrilleNavale(taille, taillesNavires);
					j2 = new JoueurAuto(g, NomJ2);
				}

				
				
				demarrerPartie();
			
			}
		});
				//------------------------------------
				
				
				
		
		panelBas.add(btnNewButton);
		
		JPanel panelCentre = new JPanel();
		frmBatailleNavale.getContentPane().add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panelCenHaute = new JPanel();
		panelCenHaute.setBorder(new TitledBorder(null, "Joueur 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCentre.add(panelCenHaute);
		SpringLayout sl_panelCenHaute = new SpringLayout();
		panelCenHaute.setLayout(sl_panelCenHaute);
		
		JLabel NomJoueur1 = new JLabel("Nom :");
		sl_panelCenHaute.putConstraint(SpringLayout.NORTH, NomJoueur1, 8, SpringLayout.NORTH, panelCenHaute);
		sl_panelCenHaute.putConstraint(SpringLayout.WEST, NomJoueur1, 10, SpringLayout.WEST, panelCenHaute);
		NomJoueur1.setHorizontalAlignment(SwingConstants.LEFT);
		panelCenHaute.add(NomJoueur1);
		
		LeNomJ1 = new JTextField();
		sl_panelCenHaute.putConstraint(SpringLayout.NORTH, LeNomJ1, -3, SpringLayout.NORTH, NomJoueur1);
		sl_panelCenHaute.putConstraint(SpringLayout.WEST, LeNomJ1, 6, SpringLayout.EAST, NomJoueur1);
		panelCenHaute.add(LeNomJ1);
		LeNomJ1.setColumns(30);
		
		JRadioButton J1G = new JRadioButton("Joueur Graphique");
		J1G.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(J1G);
		sl_panelCenHaute.putConstraint(SpringLayout.NORTH, J1G, 12, SpringLayout.SOUTH, LeNomJ1);
		sl_panelCenHaute.putConstraint(SpringLayout.WEST, J1G, 0, SpringLayout.WEST, NomJoueur1);
		panelCenHaute.add(J1G);
		
		JRadioButton j1Text = new JRadioButton("Joueur Texte");
		j1Text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(j1Text);
		sl_panelCenHaute.putConstraint(SpringLayout.NORTH, j1Text, 6, SpringLayout.SOUTH, J1G);
		sl_panelCenHaute.putConstraint(SpringLayout.WEST, j1Text, 0, SpringLayout.WEST, NomJoueur1);
		panelCenHaute.add(j1Text);
		
		JRadioButton J1auto = new JRadioButton("Joueur Auto");
		J1auto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//-----------------------------------------------
			}
		});
		buttonGroup.add(J1auto);
		sl_panelCenHaute.putConstraint(SpringLayout.NORTH, J1auto, 6, SpringLayout.SOUTH, j1Text);
		sl_panelCenHaute.putConstraint(SpringLayout.WEST, J1auto, 0, SpringLayout.WEST, NomJoueur1);
		panelCenHaute.add(J1auto);
		
		JPanel panelCenBas = new JPanel();
		panelCenBas.setBorder(new TitledBorder(null, "joueur 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCentre.add(panelCenBas);
		SpringLayout sl_panelCenBas = new SpringLayout();
		panelCenBas.setLayout(sl_panelCenBas);
		
		JLabel NomJoueur2 = new JLabel("Nom :");
		sl_panelCenBas.putConstraint(SpringLayout.NORTH, NomJoueur2, 8, SpringLayout.NORTH, panelCenBas);
		sl_panelCenBas.putConstraint(SpringLayout.WEST, NomJoueur2, 10, SpringLayout.WEST, panelCenBas);
		panelCenBas.add(NomJoueur2);
		
		LeNomJ2 = new JTextField();
		sl_panelCenBas.putConstraint(SpringLayout.NORTH, LeNomJ2, -3, SpringLayout.NORTH, NomJoueur2);
		sl_panelCenBas.putConstraint(SpringLayout.WEST, LeNomJ2, 6, SpringLayout.EAST, NomJoueur2);
		panelCenBas.add(LeNomJ2);
		LeNomJ2.setColumns(30);
		
		JRadioButton JG2 = new JRadioButton("Joueur Graphique");
		JG2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup_1.add(JG2);
		sl_panelCenBas.putConstraint(SpringLayout.NORTH, JG2, 16, SpringLayout.SOUTH, LeNomJ2);
		sl_panelCenBas.putConstraint(SpringLayout.WEST, JG2, 0, SpringLayout.WEST, NomJoueur2);
		panelCenBas.add(JG2);
		
		JRadioButton j2Text = new JRadioButton("Joueur Texte");
		j2Text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup_1.add(j2Text);
		sl_panelCenBas.putConstraint(SpringLayout.NORTH, j2Text, 6, SpringLayout.SOUTH, JG2);
		sl_panelCenBas.putConstraint(SpringLayout.WEST, j2Text, 0, SpringLayout.WEST, NomJoueur2);
		panelCenBas.add(j2Text);
		
		JRadioButton j2Auto = new JRadioButton("Joueur Auto");
		j2Auto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//--------------------------------------------------
			}
		});
		buttonGroup_1.add(j2Auto);
		sl_panelCenBas.putConstraint(SpringLayout.NORTH, j2Auto, 6, SpringLayout.SOUTH, j2Text);
		sl_panelCenBas.putConstraint(SpringLayout.WEST, j2Auto, 0, SpringLayout.WEST, NomJoueur2);
		panelCenBas.add(j2Auto);
		
		//----------------
		
		LeNomJ1.setText("Joueur 1");
		LeNomJ2.setText("Joueur 2");
		taillegrille.setText("10");
		J1auto.setSelected(true);
		j2Auto.setSelected(true);
	}
	
}
