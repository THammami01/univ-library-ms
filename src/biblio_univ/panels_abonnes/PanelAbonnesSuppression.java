package biblio_univ.panels_abonnes;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import biblio_univ.useful.MariaDBConnection;

import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import java.awt.Color;

public class PanelAbonnesSuppression extends JPanel {

	MariaDBConnection connDB;
	
	private JTextField textId;

	/**
	 * Create the panel.
	 */
	public PanelAbonnesSuppression() {
		// == MY INITS ====================================
		connDB = new MariaDBConnection();		
		
		
		// ================================================
		
		setBounds(0, 0, 381, 305);
		setLayout(null);
		
		JLabel lblSuppression = new JLabel("Entrer l'identifiant de l'abonn\u00E9 \u00E0 supprimer");
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
		lblSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSupprimer.setBackground(new Color(190, 190, 190));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblSupprimer.setBackground(new Color(215, 215, 215));				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textId.getText().length() == 0) {
					
					JOptionPane.showMessageDialog(null, "Vous devez d'abord entrer un indentifiant !");
					
				} else if(JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer l'abonnés avec l'identifiant " + textId.getText() + " ?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {

					try {
						// ===========================================================================
						// DEPENDING ON RETURN VALUE: Aucun abonné trouvé avec cet identifiant !
						// ===========================================================================

						if(connDB.supprimerAbonne(Integer.parseInt(textId.getText()))) {
							JOptionPane.showMessageDialog(null, "Abonné supprimé avec succés.");					
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
