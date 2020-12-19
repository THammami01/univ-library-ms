package biblio_univ.panels_abonnes;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.UIManager;
import javax.swing.JTextField;

import biblio_univ.useful.Abonne;
import biblio_univ.useful.EstEOuE;
import biblio_univ.useful.MariaDBConnection;

public class PanelAbonnesAjout extends JPanel {
	
	private JTextField textPrenom;
	private JTextField textNom;
	private JTextField textNumTel;
	
	private ButtonGroup rdbtnGroup;

	MariaDBConnection connDB;
	
	/**
	 * Create the panel.
	 */
	
	public PanelAbonnesAjout() {

		// == MY INITS ====================================
		connDB = new MariaDBConnection();		
		
		// ================================================
		
		setBounds(0, 0, 381, 305);
		setLayout(null);
		
		JRadioButton rdbtnEtudiant = new JRadioButton("Étudiant");
		rdbtnEtudiant.setActionCommand("Étudiant");
		rdbtnEtudiant.setSelected(true);
		rdbtnEtudiant.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnEtudiant.setBounds(75, 142, 80, 23);
		add(rdbtnEtudiant);
		
		JRadioButton rdbtnEnseignant = new JRadioButton("Enseignant");
		rdbtnEnseignant.setActionCommand("Enseignant");
		rdbtnEnseignant.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnEnseignant.setBounds(150, 142, 80, 23);
		add(rdbtnEnseignant);
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom: ");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrenom.setBounds(35, 63, 50, 14);
		add(lblPrenom);
		
		textPrenom = new JTextField();
		textPrenom.setColumns(10);
		textPrenom.setBounds(91, 61, 150, 20);
		add(textPrenom);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNom.setBounds(35, 90, 50, 14);
		add(lblNom);
		
		textNom = new JTextField();
		textNom.setColumns(10);
		textNom.setBounds(91, 88, 150, 20);
		add(textNom);
		
		JLabel lblNumTel = new JLabel("N\u00B0 Tel:");
		lblNumTel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumTel.setBounds(35, 117, 50, 14);
		add(lblNumTel);
		
		textNumTel = new JTextField();
		textNumTel.setColumns(10);
		textNumTel.setBounds(91, 115, 150, 20);
		add(textNumTel);
		
		JLabel lblAjouter = new JLabel("Ajouter");
		lblAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAjouter.setBackground(new Color(190, 190, 190));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblAjouter.setBackground(new Color(215, 215, 215));				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				EstEOuE tempEstEOuE;
				if(rdbtnEtudiant.isSelected())
					tempEstEOuE = EstEOuE.ETUDIANT;
				else
					tempEstEOuE = EstEOuE.ENSEIGNANT;
				
				
				if(textPrenom.getText().length() == 0 || textNom.getText().length() == 0 || textNumTel.getText().length() == 0) {
					
					JOptionPane.showMessageDialog(null, "Vous devez d'abord remplir tous les champs !");
					
				} else if(JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment ajouter cet abonné ?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					try {
						int resId = connDB.ajouterAbonne(new Abonne(-1, textPrenom.getText(), textNom.getText(), Integer.parseInt(textNumTel.getText()), tempEstEOuE));
						if(resId >= 0) {
							JOptionPane.showMessageDialog(null, "Abonné d'identifiant " + resId + " ajouté avec succés.");					
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
		lblAjouter.setBounds(25, 181, 80, 25);
		add(lblAjouter);
		
		JLabel lblAjout = new JLabel("Entrer les informations du nouveau abonn\u00E9");
		lblAjout.setHorizontalAlignment(SwingConstants.LEFT);
		lblAjout.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAjout.setBounds(25, 11, 300, 50);
		add(lblAjout);
		
		rdbtnGroup = new ButtonGroup();
		rdbtnGroup.add(rdbtnEtudiant);
		rdbtnGroup.add(rdbtnEnseignant);
		
	}
	

}
