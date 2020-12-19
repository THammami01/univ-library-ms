package biblio_univ.panels_livres;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import biblio_univ.useful.Abonne;
import biblio_univ.useful.CustomMouseAdapter;
import biblio_univ.useful.EstEOuE;
import biblio_univ.useful.Livre;
import biblio_univ.useful.MariaDBConnection;

public class PanelLivresModification extends JPanel {

	private JTextField textId;
	private JTextField textTitre;
	private JTextField textISBN;

	MariaDBConnection connDB;
	
	/**
	 * Create the panel.
	 */

	public PanelLivresModification() {

		// == MY INITS ====================================
		connDB = new MariaDBConnection();		
		
		// ================================================
		
		setBounds(0, 0, 381, 305);
		setLayout(null);
		
		JLabel lblModification = new JLabel("Entrer l'identifiant du livre à modifier");
		lblModification.setHorizontalAlignment(SwingConstants.LEFT);
		lblModification.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblModification.setBounds(25, 11, 300, 50);
		add(lblModification);
		
		JLabel lblTitre = new JLabel("Titre: ");
		lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTitre.setBounds(35, 135, 50, 14);
		add(lblTitre);
		
		textTitre = new JTextField();
		textTitre.setColumns(10);
		textTitre.setBounds(91, 133, 150, 20);
		add(textTitre);
		
		JLabel lblISBN = new JLabel("ISBN:");
		lblISBN.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblISBN.setBounds(35, 162, 50, 14);
		add(lblISBN);
		
		textISBN = new JTextField();
		textISBN.setColumns(10);
		textISBN.setBounds(91, 160, 150, 20);
		add(textISBN);
		
		JLabel lblModifier = new JLabel("Modifier");
		lblModifier.addMouseListener(new CustomMouseAdapter(lblModifier) {

			@Override
			public void mouseClicked(MouseEvent e) {

				if(textId.getText().length() == 0 || textTitre.getText().length() == 0 || textISBN.getText().length() == 0) {
					
					JOptionPane.showMessageDialog(null, "Vous devez d'abord remplir tous les champs !");
					
				} else if(JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment modifié le livre " + textId.getText() + " ?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					try {
						if(connDB.modifierLivre(new Livre(Integer.parseInt(textId.getText()), textTitre.getText(), textISBN.getText()))) {
							JOptionPane.showMessageDialog(null, "Livre modifié avec succés.");					
						} else {
							JOptionPane.showMessageDialog(null, "Erreur lors de la modification !", "Failure", JOptionPane.ERROR_MESSAGE);										
						}
						
					} catch(Exception e2) {
						JOptionPane.showMessageDialog(null, "Erreur lors de la modification !", "Failure", JOptionPane.ERROR_MESSAGE);	
						
					}

				}
				
			}

		});
		lblModifier.setOpaque(true);
		lblModifier.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifier.setBackground(new Color(215, 215, 215));
		lblModifier.setBounds(25, 199, 80, 25);
		add(lblModifier);
		
		JLabel lblModification2 = new JLabel("Entrer les nouveaux informations du livre");
		lblModification2.setHorizontalAlignment(SwingConstants.LEFT);
		lblModification2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblModification2.setBounds(25, 83, 300, 50);
		add(lblModification2);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblId.setBounds(35, 63, 50, 14);
		add(lblId);
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(91, 61, 150, 20);
		add(textId);

	
		
	}

}
