package biblio_univ.panels_livres;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import biblio_univ.useful.Abonne;
import biblio_univ.useful.CustomMouseAdapter;
import biblio_univ.useful.EstEOuE;
import biblio_univ.useful.Livre;
import biblio_univ.useful.MariaDBConnection;

public class PanelLivresAjout extends JPanel {

	private JTextField textTitre;
	private JTextField textISBN;
	
	MariaDBConnection connDB;

	/**
	 * Create the panel.
	 */
	
	public PanelLivresAjout() {
	
		// == MY INITS ====================================
		connDB = new MariaDBConnection();		
		
		// ================================================

		setBounds(0, 0, 381, 305);
		setLayout(null);
		
		JLabel lblTitre = new JLabel("Titre: ");
		lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTitre.setBounds(35, 63, 50, 14);
		add(lblTitre);
		
		textTitre = new JTextField();
		textTitre.setColumns(10);
		textTitre.setBounds(91, 61, 150, 20);
		add(textTitre);
		
		JLabel lblISBN = new JLabel("ISBN:");
		lblISBN.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblISBN.setBounds(35, 90, 50, 14);
		add(lblISBN);
		
		textISBN = new JTextField();
		textISBN.setColumns(10);
		textISBN.setBounds(91, 88, 150, 20);
		add(textISBN);
//		textISBN.setEditable(false);
		
		JLabel lblAjouter = new JLabel("Ajouter");
		lblAjouter.addMouseListener(new CustomMouseAdapter(lblAjouter) {

			@Override
			public void mouseClicked(MouseEvent e) {

				if(textTitre.getText().length() == 0 || textISBN.getText().length() == 0) {
					
					JOptionPane.showMessageDialog(null, "Vous devez d'abord remplir tous les champs !");
					
				} else if(JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment ajouter cet livre ?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					try {

						// TODO: MISSING METHODE ajouterLivre AND CLASS Livre
						int resId = connDB.ajouterLivre(new Livre(-1, textTitre.getText(), textISBN.getText()));

						if(resId >= 0) {
							JOptionPane.showMessageDialog(null, "Livre d'identifiant " + resId + " ajouté avec succés.");					
						} else {
							JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout !", "Failure", JOptionPane.ERROR_MESSAGE);										
						}
						
					} catch(Exception e2) {
						JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout !", "Failure", JOptionPane.ERROR_MESSAGE);	
						
					}

				}			
			
				
				
			}

		});
		
		lblAjouter.setOpaque(true);
		lblAjouter.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjouter.setBackground(new Color(215, 215, 215));
		lblAjouter.setBounds(25, 127, 80, 25);
		add(lblAjouter);
		
		JLabel lblAjout = new JLabel("Entrer les informations du nouveau livre");
		lblAjout.setHorizontalAlignment(SwingConstants.LEFT);
		lblAjout.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAjout.setBounds(25, 11, 300, 50);
		add(lblAjout);
	
	
	}


}
