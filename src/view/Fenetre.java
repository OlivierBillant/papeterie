package view;

	import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import controller.ControllerLivre;
import model.bo.InfoLivre;

	public class Fenetre extends JFrame {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Fenetre() {
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setBounds(150,150,375,500);
			setTitle("Papeterie-MVC");
			
			//Affichage des catégories
			JPanel monPanel = new JPanel();
			setContentPane(monPanel);
			setLayout(null);
			
//			JLabel idLivre = new JLabel();
//			idLivre.setText("ID du livre");
//			idLivre.setBounds(20, 20, 80, 20);
//			monPanel.add(idLivre);
			
			JLabel reference = new JLabel("", SwingConstants.CENTER);
			reference.setText("Reference");
			reference.setBounds(20, 20, 100, 20);
			monPanel.add(reference);
			
			JLabel designation = new JLabel("", SwingConstants.CENTER);
			designation.setText("Designation");
			designation.setBounds(20, 40, 100, 20);
			monPanel.add(designation);
			
			JLabel marque = new JLabel("", SwingConstants.CENTER);
			marque.setText("Marque");
			marque.setBounds(20, 60, 100, 20);
			monPanel.add(marque);
			
			JLabel stock = new JLabel("", SwingConstants.CENTER);
			stock.setText("Stock");
			stock.setBounds(20, 80, 100, 20);
			monPanel.add(stock);
			
			JLabel prix = new JLabel("", SwingConstants.CENTER);
			prix.setText("Prix");
			prix.setBounds(20, 100, 100, 20);
			monPanel.add(prix);
			
			JLabel type = new JLabel("", SwingConstants.CENTER);
			type.setText("Type");
			type.setBounds(20, 140, 100, 20);
			monPanel.add(type);
			
			JLabel grammage = new JLabel("", SwingConstants.CENTER);
			grammage.setText("Grammage");
			grammage.setBounds(20, 180, 100, 20);
			monPanel.add(grammage);
			
			JLabel couleur = new JLabel("", SwingConstants.CENTER);
			couleur.setText("Couleur");
			couleur.setBounds(20, 220, 100, 20);
			monPanel.add(couleur);
			//Affichage des champs de saisie

//			JTextField saisieIdLivre = new JTextField();
//			saisieIdLivre.setBounds(20, 40, 80, 20);
//			monPanel.add(saisieIdLivre);

			JTextField saisieReference = new JTextField();
			saisieReference.setBounds(120, 20, 200, 20);
			monPanel.add(saisieReference);
			
			JTextField saisieDesignation = new JTextField();
			saisieDesignation.setBounds(120, 40, 200, 20);
			monPanel.add(saisieDesignation);
			
			JTextField saisieMarque = new JTextField();
			saisieMarque.setBounds(120, 60, 200, 20);
			monPanel.add(saisieMarque);
			
			JTextField saisieStock = new JTextField();
			saisieStock.setBounds(120, 80, 200, 20);
			monPanel.add(saisieStock);
			
			JTextField saisiePrix = new JTextField();
			saisiePrix.setBounds(120, 100, 200, 20);
			monPanel.add(saisiePrix);
			
			JRadioButton benjaminRamette = new JRadioButton("Ramette");
			benjaminRamette.setBounds(170, 130, 200, 20);
			benjaminRamette.setMnemonic(KeyEvent.VK_B);
			benjaminRamette.setActionCommand("Ramette");
			benjaminRamette.setSelected(true);
			monPanel.add(benjaminRamette);
			
			JRadioButton benjaminStylo = new JRadioButton("Stylo");
			benjaminStylo.setBounds(170, 150, 200, 20);
			benjaminStylo.setMnemonic(KeyEvent.VK_B);
			benjaminStylo.setActionCommand("Stylo");
			benjaminStylo.setSelected(true);
			monPanel.add(benjaminStylo);
			
			ButtonGroup group = new ButtonGroup();
		    group.add(benjaminRamette);
		    group.add(benjaminStylo);
		    
		   JCheckBox benjaminGrammage80 = new JCheckBox("80 grammes");
		   benjaminGrammage80.setBounds(170, 170, 200, 20);
		   benjaminGrammage80.setMnemonic(KeyEvent.VK_C); 
		   benjaminGrammage80.setSelected(true);
		   monPanel.add(benjaminGrammage80);
		   
		   JCheckBox benjaminGrammage100 = new JCheckBox("100 grammes");
		   benjaminGrammage100.setBounds(170, 190, 200, 20);
		   benjaminGrammage100.setMnemonic(KeyEvent.VK_C); 
		   benjaminGrammage100.setSelected(true);
		   monPanel.add(benjaminGrammage100);
		    
			//Affichage du bouton
			JButton benjamin = new JButton("Ajoutez une reference");
			benjamin.setBounds(20, 80, 310, 20);
			monPanel.add(benjamin);
			benjamin.setVisible(false);
			
			//Affichage des informations sans JTable (V1)
			JLabel idLivre_1 = new JLabel();
			idLivre_1.setBounds(20, 100, 80, 20);
			monPanel.add(idLivre_1);
			
			JLabel titreLivre_1 = new JLabel();
			titreLivre_1.setBounds(100, 100, 100, 20);
			monPanel.add(titreLivre_1);
			
			JLabel isbnLivre_1 = new JLabel();
			isbnLivre_1.setBounds(200, 100, 50, 20);
			monPanel.add(isbnLivre_1);
			
			JLabel auteurLivre_1 = new JLabel();
			auteurLivre_1.setBounds(250, 100, 80, 20);
			monPanel.add(auteurLivre_1);
			
			setVisible(true);
			
			//Action du Bouton
			benjamin.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//					String idLivre_str = saisieIdLivre.getText();
//					float idLivre = Integer.parseInt(idLivre_str);
					String titreLivre = saisieTitreLivre.getText();
					String isbnLivre = saisieIsbnLivre.getText();
					String auteurLivre = saisieAuteurLivre.getText();

					InfoLivre info = ControllerLivre.traitement(titreLivre, isbnLivre, auteurLivre);
					Fenetre resultat = new Fenetre(info);
//					saisieIdLivre.setText("");
					saisieTitreLivre.setText("");
					saisieIsbnLivre.setText("");
					saisieAuteurLivre.setText("");
					
//					for (int i= 0; i < info.getL().size(); i++) {
//						idLivre_1.setText(Integer.toString(info.getL().get(i).getId()));
//						titreLivre_1.setText(info.getL().get(i).getTitre());
//						isbnLivre_1.setText(info.getL().get(i).getIsbn());
//						auteurLivre_1.setText(info.getL().get(i).getAuteur());
//					}
				}
			});
		}
		public Fenetre(InfoLivre info) {
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setBounds(500,150,375,500);
			setTitle("Liste-MVC");
			
			//Affichage des catï¿½gories
			JPanel monPanel = new JPanel();
			setContentPane(monPanel);
			setLayout(null);
			
			JButton benjaminModifier = new JButton("Modifier");
			benjaminModifier.setBounds(20, 150, 150, 20);
			monPanel.add(benjaminModifier);
			benjaminModifier.setVisible(true);
			
			JButton benjaminSupprimer = new JButton("Supprimer");
			benjaminSupprimer.setBounds(170, 150, 150, 20);
			monPanel.add(benjaminSupprimer);
			benjaminSupprimer.setVisible(true);
			
			JButton benjaminConstruire = new JButton("Construire Alexandrie");
			benjaminConstruire.setBounds(20, 170, 150, 20);
			monPanel.add(benjaminConstruire);
			benjaminConstruire.setVisible(true);
			
			JButton benjaminBruler = new JButton("Bruler Alexandrie");
			benjaminBruler.setBounds(170, 170, 150, 20);
			monPanel.add(benjaminBruler);
			benjaminBruler.setVisible(true);
			
			//Alimentation du tableau JFrame
			String[] colonnes = {"ID", "Titre", "ISBN", "Auteur"};
			int nb = info.getL().size();
			String [][] tableau = new String [nb] [colonnes.length];
			
			for (int i= 0; i < info.getL().size(); i++) {
				tableau[i][0] = Integer.toString(info.getL().get(i).getId());
				tableau[i][1] = info.getL().get(i).getTitre();
				tableau[i][2] = info.getL().get(i).getIsbn();
				tableau[i][3] = info.getL().get(i).getAuteur();
			}
			
			JTable listeLivres = new JTable(tableau, colonnes);
			listeLivres.setBounds(20, 120, 310, 100);
			listeLivres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			setLayout(new BorderLayout());
	        add(listeLivres.getTableHeader(), BorderLayout.PAGE_START);
	        add(listeLivres, BorderLayout.CENTER);
			monPanel.add(listeLivres);

	        setVisible(true);
	        
	        benjaminSupprimer.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					int index = listeLivres.getSelectedRow();
					int id = Integer.parseInt(tableau[index][0]);
					ControllerLivre.traitement(id);
					Fenetre resultatMaj = new Fenetre(ControllerLivre.traitement());
					setVisible(false);
					dispose();
				}
			});
	        
	        benjaminModifier.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					int index = listeLivres.getSelectedRow();
					int idLivre = Integer.parseInt(tableau[index][0]);
					String titreLivre = tableau[index][1];
					String isbnLivre = tableau[index][2];
					String auteurLivre = tableau[index][3];

					InfoLivre info = ControllerLivre.traitement(idLivre, titreLivre, isbnLivre, auteurLivre);
					Fenetre resultatMaj = new Fenetre(info);
					setVisible(false);
					dispose();
				}
			});
	        benjaminConstruire.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					ControllerLivre.constructionAlexandrie();
					Fenetre resultatMaj = new Fenetre(ControllerLivre.traitement());
					setVisible(false);
					dispose();
				}
			});
	        
	        benjaminBruler.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					ControllerLivre.brulerAlexandrie();
					Fenetre resultatMaj = new Fenetre(ControllerLivre.traitement());
					setVisible(false);
					dispose();
				}
			});
		}
	}
