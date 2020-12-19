package biblio_univ.panels_prets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import biblio_univ.useful.CustomMouseAdapter;
import biblio_univ.useful.Emprunt;
import biblio_univ.useful.Livre;
import biblio_univ.useful.MariaDBConnection;
import javax.swing.border.LineBorder;

public class PanelPretsRecherche extends JPanel {

	JTextField textIdLivre;
	JTextField textIdAbonne;
	
	JTextField usedTextField;
	
	MariaDBConnection connDB;

	/**
	 * Create the panel.
	 */
	
	public PanelPretsRecherche() {
		// == MY INITS ====================================
		connDB = new MariaDBConnection();		
		
		// ================================================

		setBounds(0, 0, 381, 305);
		setLayout(null);
		
		
		JPanel test = new JPanel();
		test.setBorder(null);
		test.setPreferredSize(new Dimension(290, 2000));
		JScrollPane scrollFrame = new JScrollPane(test);
		scrollFrame.setBorder(new LineBorder(new Color(215, 215, 215)));
		scrollFrame.setLocation(35, 163);
		scrollFrame.setSize(311, 121);
		test.setAutoscrolls(true);
		test.setLayout(null);
		
		JLabel lblJournal = new JLabel(connDB.rechercherTousPretsNonRendus());
		lblJournal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblJournal.setVerticalAlignment(SwingConstants.TOP);
		lblJournal.setOpaque(true);
		lblJournal.setBounds(5, 5, 282, 1900);
		test.add(lblJournal);
		scrollFrame.setPreferredSize(new Dimension(361, 131));
		add(scrollFrame);
		
		JLabel lblIdLivre = new JLabel("ID Livre: ");
		lblIdLivre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIdLivre.setBounds(35, 63, 50, 14);
		add(lblIdLivre);
		
		textIdLivre = new JTextField();
		textIdLivre.getDocument().addDocumentListener(new CustomDocumentListener(textIdLivre));
		textIdLivre.setColumns(10);
		textIdLivre.setBounds(100, 61, 150, 20);
		add(textIdLivre);
		
		JLabel lblIdAbonne = new JLabel("ID Abonné:");
		lblIdAbonne.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIdAbonne.setBounds(35, 90, 60, 14);
		add(lblIdAbonne);
		
		textIdAbonne = new JTextField();
		textIdAbonne.getDocument().addDocumentListener(new CustomDocumentListener(textIdAbonne));
		textIdAbonne.setColumns(10);
		textIdAbonne.setBounds(100, 88, 150, 20);
		add(textIdAbonne);


		JLabel lblRechercher = new JLabel("Rechercher");
		lblRechercher.addMouseListener(new CustomMouseAdapter(lblRechercher) {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(textIdLivre.getText().isBlank() && textIdAbonne.getText().isBlank()) {
					
					JOptionPane.showMessageDialog(null, "Vous devez d'abord remplir l'un des champs !");
					
				} else {
					
					try {
						
						if(usedTextField == textIdLivre)
							lblJournal.setText(connDB.rechercherTousPretsAvecIdLivre(Integer.parseInt(textIdLivre.getText())));							
						else
							lblJournal.setText(connDB.rechercherTousPretsAvecIdAbonne(Integer.parseInt(textIdAbonne.getText())));

					} catch(Exception e2) {
						System.out.println(e2);
						JOptionPane.showMessageDialog(null, "Erreur lors de l'interprétation des entrées !", "Failure", JOptionPane.ERROR_MESSAGE);

					}

				}	
			
				
			}

		});
		
		lblRechercher.setOpaque(true);
		lblRechercher.setHorizontalAlignment(SwingConstants.CENTER);
		lblRechercher.setBackground(new Color(215, 215, 215));
		lblRechercher.setBounds(25, 127, 80, 25);
		add(lblRechercher);
		
		JLabel lblAjout = new JLabel("Entrer l'un des cr\u00E9t\u00E8res suivants \u00E0 rechercher");
		lblAjout.setHorizontalAlignment(SwingConstants.LEFT);
		lblAjout.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAjout.setBounds(25, 11, 300, 50);
		add(lblAjout);
		
		JLabel lblRechercher_1 = new JLabel("Voir Tous Emprunt\u00E9s");
		lblRechercher_1.setOpaque(true);
		lblRechercher_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRechercher_1.setBackground(new Color(215, 215, 215));
		lblRechercher_1.setBounds(110, 127, 130, 25);
		lblRechercher_1.addMouseListener(new CustomMouseAdapter(lblRechercher_1) {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				lblJournal.setText(connDB.rechercherTousPretsNonRendus());	
			}
			
		});
		add(lblRechercher_1);
		
//		JLabel lblRecherche2 = new JLabel("En attente de recherche..");
//		lblRecherche2.setHorizontalAlignment(SwingConstants.LEFT);
//		lblRecherche2.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblRecherche2.setBounds(25, 162, 300, 50);
//		add(lblRecherche2);
		
//		JPanel test = new JPanel();
//		test.setPreferredSize(new Dimension(2000, 2000));
//		JScrollPane scrollFrame = new JScrollPane(test);
//		scrollFrame.setLocation(10, 163);
//		scrollFrame.setSize(361, 131);
//		test.setAutoscrolls(true);
//		scrollFrame.setPreferredSize(new Dimension(361, 131));
//		this.add(scrollFrame);

	

	}
	
	
	public class CustomDocumentListener implements DocumentListener {
		JTextField currTextField;
		
//		USAGE: textTitre.getDocument().addDocumentListener(new CustomDocumentListener(textTitre));
		
		public CustomDocumentListener(JTextField currTextField) {
			this.currTextField = currTextField;
		}
		
		@Override
		public void insertUpdate(DocumentEvent e) {
			changeEditable();
//			System.out.println("1 - " + currTextField.getText());	
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			changeEditable();
//			System.out.println("2 - " + currTextField.getText());					
		}

		@Override
		public void changedUpdate(DocumentEvent e) {

		}

		public void changeEditable() {
			if(currTextField.getText().isEmpty())
				if(currTextField == textIdLivre)
					textIdAbonne.setEditable(true);
				else
					textIdLivre.setEditable(true);
			else
				if(currTextField == textIdLivre) {
					textIdAbonne.setEditable(false);					
					usedTextField = textIdLivre;
				} else {
					textIdLivre.setEditable(false);
					usedTextField = textIdAbonne;					
				}
		}
		
	}
}
