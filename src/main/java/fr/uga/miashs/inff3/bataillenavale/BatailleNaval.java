package fr.uga.miashs.inff3.bataillenavale;

import java.awt.EventQueue;

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

	private JFrame frmBatailleNavalle;
	private JTextField textField;
	private JTextField textJoueur1;
	private JTextField textJoueur2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	
	private Joueur joueur1, joueur2;
	private int tailleGrille;
	private void demarrerPartie() {
	new Thread() {
	public void run() {
	joueur1.jouerAvec(joueur2);
	}
	}.start();
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BatailleNaval window = new BatailleNaval();
					window.frmBatailleNavalle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		frmBatailleNavalle = new JFrame();
		frmBatailleNavalle.setTitle("Bataille Navale");
		frmBatailleNavalle.setBounds(100, 100, 653, 478);
		frmBatailleNavalle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelHaut = new JPanel();
		frmBatailleNavalle.getContentPane().add(panelHaut, BorderLayout.NORTH);
		panelHaut.setLayout(new BoxLayout(panelHaut, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("Taille de Grille :");
		panelHaut.add(lblNewLabel);
		
		textField = new JTextField();
		panelHaut.add(textField);
		textField.setColumns(10);
		
		JPanel panelBas = new JPanel();
		frmBatailleNavalle.getContentPane().add(panelBas, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Lancer la Partie");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelBas.add(btnNewButton);
		
		JPanel panelCentre = new JPanel();
		frmBatailleNavalle.getContentPane().add(panelCentre, BorderLayout.CENTER);
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
		
		textJoueur1 = new JTextField();
		sl_panelCenHaute.putConstraint(SpringLayout.NORTH, textJoueur1, -3, SpringLayout.NORTH, NomJoueur1);
		sl_panelCenHaute.putConstraint(SpringLayout.WEST, textJoueur1, 6, SpringLayout.EAST, NomJoueur1);
		panelCenHaute.add(textJoueur1);
		textJoueur1.setColumns(30);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Joueur graphique");
		buttonGroup.add(rdbtnNewRadioButton);
		sl_panelCenHaute.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton, 12, SpringLayout.SOUTH, textJoueur1);
		sl_panelCenHaute.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton, 0, SpringLayout.WEST, NomJoueur1);
		panelCenHaute.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Joueur text");
		buttonGroup.add(rdbtnNewRadioButton_1);
		sl_panelCenHaute.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_1, 6, SpringLayout.SOUTH, rdbtnNewRadioButton);
		sl_panelCenHaute.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_1, 0, SpringLayout.WEST, NomJoueur1);
		panelCenHaute.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Joueur Auto");
		buttonGroup.add(rdbtnNewRadioButton_2);
		sl_panelCenHaute.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_2, 6, SpringLayout.SOUTH, rdbtnNewRadioButton_1);
		sl_panelCenHaute.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_2, 0, SpringLayout.WEST, NomJoueur1);
		panelCenHaute.add(rdbtnNewRadioButton_2);
		
		JPanel panelCenBas = new JPanel();
		panelCenBas.setBorder(new TitledBorder(null, "joueur 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCentre.add(panelCenBas);
		SpringLayout sl_panelCenBas = new SpringLayout();
		panelCenBas.setLayout(sl_panelCenBas);
		
		JLabel NomJoueur2 = new JLabel("Nom :");
		sl_panelCenBas.putConstraint(SpringLayout.NORTH, NomJoueur2, 8, SpringLayout.NORTH, panelCenBas);
		sl_panelCenBas.putConstraint(SpringLayout.WEST, NomJoueur2, 10, SpringLayout.WEST, panelCenBas);
		panelCenBas.add(NomJoueur2);
		
		textJoueur2 = new JTextField();
		sl_panelCenBas.putConstraint(SpringLayout.NORTH, textJoueur2, -3, SpringLayout.NORTH, NomJoueur2);
		sl_panelCenBas.putConstraint(SpringLayout.WEST, textJoueur2, 6, SpringLayout.EAST, NomJoueur2);
		panelCenBas.add(textJoueur2);
		textJoueur2.setColumns(30);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Joueur Graphique");
		buttonGroup_1.add(rdbtnNewRadioButton_3);
		sl_panelCenBas.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_3, 16, SpringLayout.SOUTH, textJoueur2);
		sl_panelCenBas.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_3, 0, SpringLayout.WEST, NomJoueur2);
		panelCenBas.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Joueur text");
		buttonGroup_1.add(rdbtnNewRadioButton_4);
		sl_panelCenBas.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_4, 6, SpringLayout.SOUTH, rdbtnNewRadioButton_3);
		sl_panelCenBas.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_4, 0, SpringLayout.WEST, NomJoueur2);
		panelCenBas.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Joueur Auto");
		buttonGroup_1.add(rdbtnNewRadioButton_5);
		sl_panelCenBas.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_5, 6, SpringLayout.SOUTH, rdbtnNewRadioButton_4);
		sl_panelCenBas.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_5, 0, SpringLayout.WEST, NomJoueur2);
		panelCenBas.add(rdbtnNewRadioButton_5);
	}
}
