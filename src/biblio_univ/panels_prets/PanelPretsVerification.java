package biblio_univ.panels_prets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import biblio_univ.useful.CustomMouseAdapter;
import biblio_univ.useful.MariaDBConnection;

// DON'T FORGET THAT THEY ARE 2 VERIFICATIONS !!

public class PanelPretsVerification extends JPanel {

	JTextField textIdLivre;
	JTextField textIdAbonne;
	
	JTextField usedTextField;
	
	MariaDBConnection connDB;
	
	/**
	 * Create the panel.
	 */
	
	public PanelPretsVerification() {
		// == MY INITS ====================================
		connDB = new MariaDBConnection();		
		
		// ================================================

		setBounds(0, 0, 381, 305);
		setLayout(null);
		
		JPanel test = new JPanel();
		test.setBorder(null);
		test.setPreferredSize(new Dimension(290, 2000));
		JScrollPane scrollFrame = new JScrollPane(test);
		scrollFrame.setBorder(new LineBorder(new Color(215, 215, 215)));
		scrollFrame.setLocation(35, 99);
		scrollFrame.setSize(311, 185);
		test.setAutoscrolls(true);
		test.setLayout(null);
		
		JLabel lblJournal = new JLabel(connDB.rechercherTousPretsNonRendusAvant7Jours());
		lblJournal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblJournal.setVerticalAlignment(SwingConstants.TOP);
		lblJournal.setOpaque(true);
		lblJournal.setBounds(5, 5, 282, 1900);
		test.add(lblJournal);
		scrollFrame.setPreferredSize(new Dimension(361, 131));
		add(scrollFrame);
		
		JLabel lblActualiser = new JLabel("Actualiser");
		lblActualiser.addMouseListener(new CustomMouseAdapter(lblActualiser) {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				lblJournal.setText(connDB.rechercherTousPretsNonRendusAvant7Jours());
			}

		});
		lblActualiser.setOpaque(true);
		lblActualiser.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualiser.setBackground(new Color(215, 215, 215));
		lblActualiser.setBounds(25, 63, 80, 25);
		add(lblActualiser);
		
		JLabel lblAjout = new JLabel("Liste des pr\u00EAts non retourn\u00E9s avant 7 jours");
		lblAjout.setHorizontalAlignment(SwingConstants.LEFT);
		lblAjout.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAjout.setBounds(25, 11, 300, 50);
		add(lblAjout);
		
		
		
	}

}
