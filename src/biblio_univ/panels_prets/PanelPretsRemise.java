package biblio_univ.panels_prets;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import biblio_univ.useful.CustomMouseAdapter;
import biblio_univ.useful.MariaDBConnection;

public class PanelPretsRemise extends JPanel {

	MariaDBConnection connDB;
	
	private JTextField textId;
	
	/**
	 * Create the panel.
	 */
	public PanelPretsRemise() {
		// == MY INITS ====================================
		connDB = new MariaDBConnection();		
		
		
		// ================================================
		
		setBounds(0, 0, 381, 305);
		setLayout(null);
		
		JLabel lblSuppression = new JLabel("Entrer l'identifiant de l'emprunt à remettre");
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
		
		JLabel lblValider = new JLabel("Valider");
		lblValider.addMouseListener(new CustomMouseAdapter(lblValider) {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(textId.getText().length() == 0) {
					
					JOptionPane.showMessageDialog(null, "Vous devez d'abord entrer un indentifiant !");
					
				} else if(JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment valider la remise de l'emprunt avec l'identifiant " + textId.getText() + " ?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {

					try {
						// ==============================================================================================
						// DEPENDING ON RETURN VALUE: Aucun emprunt trouvé avec cet identifiant ou bien livre est remis !
						// ==============================================================================================
						int idEmprunt = Integer.parseInt(textId.getText());
						int resId = connDB.remettreEmprunt(idEmprunt);

						if(resId == 0) {
							JOptionPane.showMessageDialog(null, "Emprunt remis avec succés.");					
						} else if(resId == 1) {
							JOptionPane.showMessageDialog(null, "L'identifiant " + idEmprunt  + " n'existe pas ou bien emprunt à été remis !");										
						} else if(resId == 2) {
							JOptionPane.showMessageDialog(null, "Erreur lors de la connexion avec la base de données ! " + idEmprunt  + " !", "Failure", JOptionPane.ERROR_MESSAGE);							
						}
						
					} catch(Exception e2) {
						JOptionPane.showMessageDialog(null, "Erreur lors de l'interprétation des entrées !", "Failure", JOptionPane.ERROR_MESSAGE);	
						
					}

				}
			}

		});
		lblValider.setOpaque(true);
		lblValider.setHorizontalAlignment(SwingConstants.CENTER);
		lblValider.setBackground(new Color(215, 215, 215));
		lblValider.setBounds(25, 100, 80, 25);
		add(lblValider);
		
	}
	


}
