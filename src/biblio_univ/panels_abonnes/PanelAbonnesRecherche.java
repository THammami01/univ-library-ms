package biblio_univ.panels_abonnes;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import java.awt.Color;

import biblio_univ.useful.Abonne;
import biblio_univ.useful.EstEOuE;
import biblio_univ.useful.MariaDBConnection;

public class PanelAbonnesRecherche extends JPanel {
	
	MariaDBConnection connDB;
	Abonne currAbonne;
	Abonne aucunAbonne;
	Abonne resAbonne;
	
	private JTextField textId;
	
	JLabel lblInformations;

	/**
	 * Create the panel.
	 */
	
	public PanelAbonnesRecherche() {
		// == MY INITS ====================================
		connDB = new MariaDBConnection();		
		aucunAbonne = new Abonne();
		currAbonne = aucunAbonne;
		
		// ================================================
		
		setBounds(0, 0, 381, 305);
		setLayout(null);
		
		JLabel lblRecherche = new JLabel("Entrer l'identifiant de l'abonn\u00E9 \u00E0 rechercher");
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
		
		JLabel lblRecherche2 = new JLabel("Les informations de l'abonn\u00E9 avec l'identifiant entr\u00E9");
		lblRecherche2.setHorizontalAlignment(SwingConstants.LEFT);
		lblRecherche2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRecherche2.setBounds(25, 135, 300, 50);
		add(lblRecherche2);
		
		lblInformations = new JLabel(generateInfo(currAbonne));
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
						resAbonne = connDB.rechercherAbonne(Integer.parseInt(textId.getText()));
					} catch(Exception e2) {
						resAbonne = null;
					}
					
					if(resAbonne == null) {
						JOptionPane.showMessageDialog(null, "Erreur lors de la recherche !", "Failure", JOptionPane.ERROR_MESSAGE);
					} else if(resAbonne.getId() == -2) {
						JOptionPane.showMessageDialog(null, "Aucun abonné trouvé avec cet identifiant !");
					} else {
						currAbonne = resAbonne;	
					}

					lblInformations.setText(generateInfo(currAbonne));	
					
				}

			}
		});
		lblRechercher.setOpaque(true);
		lblRechercher.setHorizontalAlignment(SwingConstants.CENTER);
		lblRechercher.setBackground(new Color(215, 215, 215));
		lblRechercher.setBounds(25, 100, 80, 25);
		add(lblRechercher);
		
	}
	
	public String generateInfo(Abonne abonne) {
			return "<html>Identifiant: " + (currAbonne.getId() == -1 ? "..." : currAbonne.getId()) +
			"<br/>Pr\u00E9nom: " + currAbonne.getPrenom() + 
			"<br/>Nom: " + currAbonne.getNom() + 
			"<br/>N° Tel: " + (currAbonne.getNumTel() == 0 ? "..." : currAbonne.getNumTel()) +
			"<br/>Date Abonnement: " + (abonne.getDateComplet() == null ? "..." : abonne.getDateComplet()) +
			"<br/>L'abonn\u00E9 est: " +
			(currAbonne.getEstEOuE() == EstEOuE.NOT_SET_YET ? "..." : currAbonne.getEstEOuE() == EstEOuE.ETUDIANT ? "Etudiant" : "Enseignant");

	}

}
