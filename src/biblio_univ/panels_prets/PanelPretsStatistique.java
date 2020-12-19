package biblio_univ.panels_prets;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import biblio_univ.useful.CustomMouseAdapter;
import biblio_univ.useful.MariaDBConnection;

public class PanelPretsStatistique extends JPanel {

	MariaDBConnection connDB;
	JLabel[] lblTop10 = new JLabel[10];
	
	
	/**
	 * Create the panel.
	 */
	
	public PanelPretsStatistique() {
		// == MY INITS ====================================
		connDB = new MariaDBConnection();		
		
		// ================================================
		
		setBounds(0, 0, 381, 305);
		setLayout(null);
		
		
		JLabel lblStatistique = new JLabel("Les 10 livres les plus empruntés");
		lblStatistique.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatistique.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStatistique.setBounds(25, 11, 300, 50);
		add(lblStatistique);
		
		JLabel lblActualiser = new JLabel("Actualiser");
		lblActualiser.addMouseListener(new CustomMouseAdapter(lblActualiser) {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				updateFields();
			}

		});
		lblActualiser.setOpaque(true);
		lblActualiser.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualiser.setBackground(new Color(215, 215, 215));
		lblActualiser.setBounds(25, 63, 80, 25);
		add(lblActualiser);
		
		JLabel numberOne = new JLabel("#1");
		numberOne.setHorizontalAlignment(SwingConstants.CENTER);
		numberOne.setBounds(25, 100, 30, 30);
		add(numberOne);
		
		JLabel numberThree = new JLabel("#3");
		numberThree.setHorizontalAlignment(SwingConstants.CENTER);
		numberThree.setBounds(25, 135, 30, 30);
		add(numberThree);
		
		JLabel numberFive = new JLabel("#5");
		numberFive.setHorizontalAlignment(SwingConstants.CENTER);
		numberFive.setBounds(25, 170, 30, 30);
		add(numberFive);
		
		JLabel numberSeven = new JLabel("#7");
		numberSeven.setHorizontalAlignment(SwingConstants.CENTER);
		numberSeven.setBounds(25, 205, 30, 30);
		add(numberSeven);
		
		JLabel numberNine = new JLabel("#9");
		numberNine.setHorizontalAlignment(SwingConstants.CENTER);
		numberNine.setBounds(25, 240, 30, 30);
		add(numberNine);
		
		lblTop10[0] = new JLabel("N/A");
		lblTop10[0].setHorizontalAlignment(SwingConstants.LEFT);
		lblTop10[0].setBounds(55, 100, 130, 30);
		lblTop10[0].setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblTop10[0]);
		
		lblTop10[2] = new JLabel("N/A");
		lblTop10[2].setHorizontalAlignment(SwingConstants.LEFT);
		lblTop10[2].setBounds(55, 135, 130, 30);
		lblTop10[2].setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblTop10[2]);
		
		lblTop10[4] = new JLabel("N/A");
		lblTop10[4].setHorizontalAlignment(SwingConstants.LEFT);
		lblTop10[4].setBounds(55, 170, 130, 30);
		lblTop10[4].setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblTop10[4]);
		
		lblTop10[6] = new JLabel("N/A");
		lblTop10[6].setHorizontalAlignment(SwingConstants.LEFT);
		lblTop10[6].setBounds(55, 205, 130, 30);
		lblTop10[6].setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblTop10[6]);
		
		lblTop10[8] = new JLabel("N/A");
		lblTop10[8].setHorizontalAlignment(SwingConstants.LEFT);
		lblTop10[8].setBounds(55, 240, 130, 30);
		lblTop10[8].setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblTop10[8]);
		
		JLabel numberTwo = new JLabel("#2");
		numberTwo.setHorizontalAlignment(SwingConstants.CENTER);
		numberTwo.setBounds(191, 100, 30, 30);
		add(numberTwo);
		
		JLabel numberFour = new JLabel("#4");
		numberFour.setHorizontalAlignment(SwingConstants.CENTER);
		numberFour.setBounds(191, 135, 30, 30);
		add(numberFour);
		
		JLabel numberSix = new JLabel("#6");
		numberSix.setHorizontalAlignment(SwingConstants.CENTER);
		numberSix.setBounds(191, 170, 30, 30);
		add(numberSix);
		
		JLabel numberEight = new JLabel("#8");
		numberEight.setHorizontalAlignment(SwingConstants.CENTER);
		numberEight.setBounds(191, 205, 30, 30);
		add(numberEight);
		
		JLabel numberTen = new JLabel("#10");
		numberTen.setHorizontalAlignment(SwingConstants.CENTER);
		numberTen.setBounds(191, 240, 30, 30);
		add(numberTen);
		
		lblTop10[1] = new JLabel("N/A");
		lblTop10[1].setHorizontalAlignment(SwingConstants.LEFT);
		lblTop10[1].setBounds(221, 100, 130, 30);
		lblTop10[1].setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblTop10[1]);
		
		lblTop10[3] = new JLabel("N/A");
		lblTop10[3].setHorizontalAlignment(SwingConstants.LEFT);
		lblTop10[3].setBounds(221, 135, 130, 30);
		lblTop10[3].setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblTop10[3]);
		
		lblTop10[5] = new JLabel("N/A");
		lblTop10[5].setHorizontalAlignment(SwingConstants.LEFT);
		lblTop10[5].setBounds(221, 170, 130, 30);
		lblTop10[5].setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblTop10[5]);
		
		lblTop10[7] = new JLabel("N/A");
		lblTop10[7].setHorizontalAlignment(SwingConstants.LEFT);
		lblTop10[7].setBounds(221, 205, 130, 30);
		lblTop10[7].setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblTop10[7]);
		
		lblTop10[9] = new JLabel("N/A");
		lblTop10[9].setHorizontalAlignment(SwingConstants.LEFT);
		lblTop10[9].setBounds(221, 240, 130, 30);
		lblTop10[9].setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblTop10[9]);
		
		updateFields();
	}
	

	public void updateFields() {
		String[] top10 = connDB.rechercherTop10();
		for(int i=0; i<10; i++)
			lblTop10[i].setText(top10[i]);
		
	}
	
}
