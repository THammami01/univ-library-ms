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

import biblio_univ.useful.CustomMouseAdapter;
import biblio_univ.useful.MariaDBConnection;

public class PanelLivresSuppression extends JPanel {

	MariaDBConnection connDB;
	
	private JTextField textId;

	/**
	 * Create the panel.
	 */
	
	public PanelLivresSuppression() {
		// == MY INITS ====================================
		connDB = new MariaDBConnection();		
		
		
		// ================================================
		
		setBounds(0, 0, 381, 305);
		setLayout(null);
		
		JLabel lblSuppression = new JLabel("Entrer l'identifiant du livre à supprimer");
		lblSuppression.setHorizontalAlignment(SwingConstants.LEFT);
		lblSuppression.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSuppression.setBounds(25, 11, 300, 50);
		add(lblSuppression);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblId.setBounds(35, 63, 50, 14);
		add(lblId);
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(91, 61, 150, 20);
		add(textId);
		
		JLabel lblSupprimer = new JLabel("Supprimer");
		lblSupprimer.addMouseListener(new CustomMouseAdapter(lblSupprimer) {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(textId.getText().length() == 0) {
					
					JOptionPane.showMessageDialog(null, "Vous devez d'abord entrer un indentifiant !");
					
				} else if(JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer le livre avec l'identifiant " + textId.getText() + " ?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {

					try {
						// ===========================================================================
						// DEPENDING ON RETURN VALUE: Aucun livre trouvé avec cet identifiant !
						// ===========================================================================

						if(connDB.supprimerLivre(Integer.parseInt(textId.getText()))) {
							JOptionPane.showMessageDialog(null, "Livre supprimé avec succés.");					
						} else {
							JOptionPane.showMessageDialog(null, "Erreur lors de la suppression !", "Failure", JOptionPane.ERROR_MESSAGE);										
						}
						
					} catch(Exception e2) {
						JOptionPane.showMessageDialog(null, "Erreur lors de la suppression !", "Failure", JOptionPane.ERROR_MESSAGE);	
						
					}

				}
			}

		});
		lblSupprimer.setOpaque(true);
		lblSupprimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupprimer.setBackground(new Color(215, 215, 215));
		lblSupprimer.setBounds(25, 100, 80, 25);
		add(lblSupprimer);
		
	}

}
