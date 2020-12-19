package biblio_univ.panels_abonnes;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import biblio_univ.useful.Abonne;
import biblio_univ.useful.EstEOuE;
import biblio_univ.useful.MariaDBConnection;

import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import java.awt.Color;

public class PanelAbonnesModification extends JPanel {
	
	private JTextField textPrenom;
	private JTextField textNom;
	private JTextField textNumTel;
	private JTextField textId;

	private ButtonGroup rdbtnGroup;

	MariaDBConnection connDB;
	
	/**
	 * Create the panel.
	 */
	
	public PanelAbonnesModification() {

		// == MY INITS ====================================
		connDB = new MariaDBConnection();		
		
		// ================================================
		
		setBounds(0, 0, 381, 305);
		setLayout(null);
		
		JLabel lblModification = new JLabel("Entrer l'identifiant de l'abonn\u00E9 \u00E0 modifier");
		lblModification.setHorizontalAlignment(SwingConstants.LEFT);
		lblModification.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblModification.setBounds(25, 11, 300, 50);
		add(lblModification);
		
		JRadioButton rdbtnEtudiant = new JRadioButton("Étudiant");
		rdbtnEtudiant.setSelected(true);
		rdbtnEtudiant.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnEtudiant.setBounds(75, 214, 80, 23);
		add(rdbtnEtudiant);
		
		JRadioButton rdbtnEnseignant = new JRadioButton("Enseignant");
		rdbtnEnseignant.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnEnseignant.setBounds(150, 214, 80, 23);
		add(rdbtnEnseignant);
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom: ");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrenom.setBounds(35, 135, 50, 14);
		add(lblPrenom);
		
		textPrenom = new JTextField();
		textPrenom.setColumns(10);
		textPrenom.setBounds(91, 133, 150, 20);
		add(textPrenom);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNom.setBounds(35, 162, 50, 14);
		add(lblNom);
		
		textNom = new JTextField();
		textNom.setColumns(10);
		textNom.setBounds(91, 160, 150, 20);
		add(textNom);
		
		JLabel lblNumTel = new JLabel("N\u00B0 Tel:");
		lblNumTel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumTel.setBounds(35, 189, 50, 14);
		add(lblNumTel);
		
		textNumTel = new JTextField();
		textNumTel.setColumns(10);
		textNumTel.setBounds(91, 187, 150, 20);
		add(textNumTel);
		
		JLabel lblModifier = new JLabel("Modifier");
		lblModifier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblModifier.setBackground(new Color(190, 190, 190));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblModifier.setBackground(new Color(215, 215, 215));				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				EstEOuE tempEstEOuE;
				if(rdbtnEtudiant.isSelected())
					tempEstEOuE = EstEOuE.ETUDIANT;
				else
					tempEstEOuE = EstEOuE.ENSEIGNANT;
				
				
				if(textId.getText().length() == 0 || textPrenom.getText().length() == 0 || textNom.getText().length() == 0 || textNumTel.getText().length() == 0) {
					
					JOptionPane.showMessageDialog(null, "Vous devez d'abord remplir tous les champs !");
					
				} else if(JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment modifié l'abonnés " + textId.getText() + " ?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					try {
						if(connDB.modifierAbonne(new Abonne(Integer.parseInt(textId.getText()), textPrenom.getText(), textNom.getText(), Integer.parseInt(textNumTel.getText()), tempEstEOuE))) {
							JOptionPane.showMessageDialog(null, "Abonné modifié avec succés.");					
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
		lblModifier.setBounds(25, 253, 80, 25);
		add(lblModifier);
		
		JLabel lblModification2 = new JLabel("Entrer les nouveaux informations de l'abonn\u00E9");
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
		
		rdbtnGroup = new ButtonGroup();
		rdbtnGroup.add(rdbtnEtudiant);
		rdbtnGroup.add(rdbtnEnseignant);
	
	}

}
