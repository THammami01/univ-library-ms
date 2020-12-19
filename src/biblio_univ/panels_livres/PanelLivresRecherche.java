package biblio_univ.panels_livres;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import biblio_univ.useful.Abonne;
import biblio_univ.useful.EstEOuE;
import biblio_univ.useful.Livre;
import biblio_univ.useful.MariaDBConnection;

public class PanelLivresRecherche extends JPanel {

	MariaDBConnection connDB;
	Livre currLivre;
	Livre aucunLivre;
	Livre resLivre;
	
	private JTextField textId;
	
	JLabel lblInformations;
	
	/**
	 * Create the panel.
	 */
	
	public PanelLivresRecherche() {
		// == MY INITS ====================================
		connDB = new MariaDBConnection();		
		aucunLivre = new Livre();
		currLivre = aucunLivre;
		
		// ================================================

	
		
		setBounds(0, 0, 381, 305);
		setLayout(null);
		
		JLabel lblRecherche = new JLabel("Entrer l'identifiant du livre \u00E0 rechercher");
		lblRecherche.setHorizontalAlignment(SwingConstants.LEFT);
		lblRecherche.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRecherche.setBounds(25, 11, 300, 50);
		add(lblRecherche);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblId.setBounds(35, 63, 50, 14);
		add(lblId);
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(91, 61, 150, 20);
		add(textId);
		
		JLabel lblRecherche2 = new JLabel("Les informations du livre avec l'identifiant entr\u00E9");
		lblRecherche2.setHorizontalAlignment(SwingConstants.LEFT);
		lblRecherche2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRecherche2.setBounds(25, 135, 300, 50);
		add(lblRecherche2);
		
		lblInformations = new JLabel(generateInfo(currLivre));
		lblInformations.setVerticalAlignment(SwingConstants.TOP);
		lblInformations.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInformations.setBounds(35, 187, 300, 100);
		add(lblInformations);
		
		JLabel lblRechercher = new JLabel("Rechercher");
		lblRechercher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRechercher.setBackground(new Color(190, 190, 190));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblRechercher.setBackground(new Color(215, 215, 215));				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textId.getText().length() == 0) {
					
					JOptionPane.showMessageDialog(null, "Vous devez d'abord entrer un identifiant !");
					
				} else {
					
					try {
						resLivre = connDB.rechercherLivre(Integer.parseInt(textId.getText()));
					} catch(Exception e2) {
						resLivre = null;
					}
					
					if(resLivre == null) {
						JOptionPane.showMessageDialog(null, "Erreur lors de la recherche !", "Failure", JOptionPane.ERROR_MESSAGE);
					} else if(resLivre.getId() == -2) {
						JOptionPane.showMessageDialog(null, "Aucun abonné trouvé avec cet identifiant !");
					} else {
						currLivre = resLivre;	
					}

					lblInformations.setText(generateInfo(currLivre));	
					
				}

			}
		});
		lblRechercher.setOpaque(true);
		lblRechercher.setHorizontalAlignment(SwingConstants.CENTER);
		lblRechercher.setBackground(new Color(215, 215, 215));
		lblRechercher.setBounds(25, 100, 80, 25);
		add(lblRechercher);
		
	}
	
	public String generateInfo(Livre Livre) {
			return "<html>Identifiant: " + (currLivre.getId() == -1 ? "..." : currLivre.getId()) +
			"<br/>Titre: " + currLivre.getTitre() + 
			"<br/>ISBN: " + currLivre.getISBN() + 
			"<br/>Date Ajout: " + (Livre.getDateAjoutComplet() == null ? "..." : Livre.getDateAjoutComplet());

	}	
		
	public class CustomDocumentListener implements DocumentListener {
		JTextField currTextField;
		
//		USAGE:
//		textTitre.getDocument().addDocumentListener(new CustomDocumentListener(textTitre));
		
		public CustomDocumentListener(JTextField currTextField) {
			this.currTextField = currTextField;
		}
		
		@Override
		public void insertUpdate(DocumentEvent e) {
//			System.out.println("1 - " + currTextField.getText());	
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
//			System.out.println("2 - " + currTextField.getText());					
		}

		@Override
		public void changedUpdate(DocumentEvent e) {

		}
		
	}

}
