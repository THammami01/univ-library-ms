package biblio_univ.panels_prets;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import biblio_univ.useful.CustomMouseAdapter;
import biblio_univ.useful.Emprunt;
import biblio_univ.useful.Livre;
import biblio_univ.useful.MariaDBConnection;

public class PanelPretsAjout extends JPanel {

	private JTextField textIdLivre;
	private JTextField textIdAbonne;
	
	MariaDBConnection connDB;

	/**
	 * Create the panel.
	 */
	
	public PanelPretsAjout() {
		// == MY INITS ====================================
		connDB = new MariaDBConnection();		
		
		// ================================================

		setBounds(0, 0, 381, 305);
		setLayout(null);
		
		JLabel lblIdLivre = new JLabel("ID Livre: ");
		lblIdLivre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIdLivre.setBounds(35, 63, 50, 14);
		add(lblIdLivre);
		
		textIdLivre = new JTextField();
		textIdLivre.setColumns(10);
		textIdLivre.setBounds(100, 61, 150, 20);
		add(textIdLivre);
		
		JLabel lblIdAbonne = new JLabel("ID Abonné:");
		lblIdAbonne.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIdAbonne.setBounds(35, 90, 60, 14);
		add(lblIdAbonne);
		
		textIdAbonne = new JTextField();
		textIdAbonne.setColumns(10);
		textIdAbonne.setBounds(100, 88, 150, 20);
		add(textIdAbonne);


		JLabel lblAjouter = new JLabel("Ajouter");
		lblAjouter.addMouseListener(new CustomMouseAdapter(lblAjouter) {

			@Override
			public void mouseClicked(MouseEvent e) {

				if(textIdLivre.getText().length() == 0 || textIdAbonne.getText().length() == 0) {
					
					JOptionPane.showMessageDialog(null, "Vous devez d'abord remplir tous les champs !");
					
				} else if(JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment ajouter cet emprunt ?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {

					try {
						
						Emprunt nouvEmprunt = new Emprunt(-1, Integer.parseInt(textIdLivre.getText()), Integer.parseInt(textIdAbonne.getText()));
						int resId = connDB.ajouterEmprunt(nouvEmprunt);

						if(resId >= 0) {
							JOptionPane.showMessageDialog(null, "Emprunt d'identifiant " + resId + " ajouté avec succés.");					
						} else if(resId == -1) {
							JOptionPane.showMessageDialog(null, "Aucun livre trouvé avec l'identifiant " + nouvEmprunt.getIdLivre() + " !");	
						} else if(resId == -2) {
							JOptionPane.showMessageDialog(null, "Aucun abonné trouvé avec l'identifiant " + nouvEmprunt.getIdAbonne() + " !");								
						} else if(resId == -3) {
							JOptionPane.showMessageDialog(null, "L'abonné avec l'identifiant " + nouvEmprunt.getIdAbonne() + " a atteint le nombre maximal d'emprunts !");								
						} else if(resId == -4) {
							JOptionPane.showMessageDialog(null, "Le livre avec l'identifiant " + nouvEmprunt.getIdLivre() + " est emprunté pour le moment !");							
						} else if(resId == -5) {							
							JOptionPane.showMessageDialog(null, "Erreur lors de la validation de l'emprunt !", "Failure", JOptionPane.ERROR_MESSAGE);										
						} else if(resId == -6) {
							JOptionPane.showMessageDialog(null, "Erreur lors de la connexion avec la base de données !", "Failure", JOptionPane.ERROR_MESSAGE);																	
						}
						
					} catch(Exception e2) {
						
						JOptionPane.showMessageDialog(null, "Erreur lors de l'interprétation des entrées !", "Failure", JOptionPane.ERROR_MESSAGE);	
						
					}

				}			
			
				
			}

		});
		
		lblAjouter.setOpaque(true);
		lblAjouter.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjouter.setBackground(new Color(215, 215, 215));
		lblAjouter.setBounds(25, 127, 80, 25);
		add(lblAjouter);
		
		JLabel lblAjout = new JLabel("Entrer les informations du nouveau emprunt");
		lblAjout.setHorizontalAlignment(SwingConstants.LEFT);
		lblAjout.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAjout.setBounds(25, 11, 300, 50);
		add(lblAjout);
	

		
	}

}
