package biblio_univ;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import biblio_univ.panels_abonnes.PanelAbonnesAjout;
import biblio_univ.panels_abonnes.PanelAbonnesModification;
import biblio_univ.panels_abonnes.PanelAbonnesRecherche;
import biblio_univ.panels_abonnes.PanelAbonnesSuppression;

import java.awt.Color;

public class PanelAbonnes extends JPanel {

	private enum MySubPanelName {
		RECHERCHE,
		AJOUT,
	    MODIFICATION,
	    SUPPRESSION
	}
	
	private Color selectedColor = new Color(215, 215, 215);
	private Color unselectedColor = new Color(230, 230, 230);
	
	MySubPanelName currSubPanel;
	
	private PanelAbonnesAjout panelAbonnesAjout;
	private PanelAbonnesModification panelAbonnesModification;
	private PanelAbonnesSuppression panelAbonnesSuppression;
	private PanelAbonnesRecherche panelAbonnesRecherche;
	private JLabel lblAbonnesRecherche;
	private JLabel lblAbonnesAjout;
	private JLabel lblAbonnesModification;
	private JLabel lblAbonnesSuppression;

	/**
	 * Create the panel.
	 */
	
	public PanelAbonnes() {
		// == MY INITS ====================================
		currSubPanel = MySubPanelName.RECHERCHE;
		
		
		// ================================================
		
		setBounds(0, 0, 381, 378);
		setLayout(null);

		panelAbonnesAjout = new PanelAbonnesAjout();
		panelAbonnesAjout.setLocation(0, 73);
		panelAbonnesAjout.setSize(381, 305);
		panelAbonnesModification = new PanelAbonnesModification();
		panelAbonnesModification.setLocation(0, 73);
		panelAbonnesModification.setSize(381, 305);
		panelAbonnesSuppression = new PanelAbonnesSuppression();
		panelAbonnesSuppression.setLocation(0, 73);
		panelAbonnesSuppression.setSize(381, 305);
		panelAbonnesRecherche = new PanelAbonnesRecherche();
		panelAbonnesRecherche.setLocation(0, 73);
		panelAbonnesRecherche.setSize(381, 305);
		
		JPanel pnlAbonneMainContent = new JPanel();
		pnlAbonneMainContent.setBounds(0, 0, 381, 378);
		add(pnlAbonneMainContent);
		pnlAbonneMainContent.setLayout(null);
		
		lblAbonnesRecherche = new JLabel("Recherche");
		lblAbonnesRecherche.addMouseListener(new CustumMouseAdapterForSubPanels(panelAbonnesRecherche, lblAbonnesRecherche, MySubPanelName.RECHERCHE));
		lblAbonnesRecherche.setFont(new Font("Arial", Font.PLAIN, 11));
		lblAbonnesRecherche.setOpaque(true);
		lblAbonnesRecherche.setBackground(new Color(215, 215, 215));
		lblAbonnesRecherche.setForeground(new Color(0, 0, 0));
		lblAbonnesRecherche.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbonnesRecherche.setBounds(20, 50, 65, 20);
		pnlAbonneMainContent.add(lblAbonnesRecherche);
		
		lblAbonnesAjout = new JLabel("Ajout");
		lblAbonnesAjout.addMouseListener(new CustumMouseAdapterForSubPanels(panelAbonnesAjout, lblAbonnesAjout, MySubPanelName.AJOUT));
		lblAbonnesAjout.setFont(new Font("Arial", Font.PLAIN, 11));
		lblAbonnesAjout.setOpaque(true);
		lblAbonnesAjout.setBackground(new Color(230, 230, 230));
		lblAbonnesAjout.setForeground(new Color(0, 0, 0));
		lblAbonnesAjout.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbonnesAjout.setBounds(90, 50, 65, 20);
		pnlAbonneMainContent.add(lblAbonnesAjout);
		
		lblAbonnesModification = new JLabel("Modification");
		lblAbonnesModification.addMouseListener(new CustumMouseAdapterForSubPanels(panelAbonnesModification, lblAbonnesModification, MySubPanelName.MODIFICATION));
		lblAbonnesModification.setFont(new Font("Arial", Font.PLAIN, 11));
		lblAbonnesModification.setOpaque(true);
		lblAbonnesModification.setBackground(new Color(230, 230, 230));
		lblAbonnesModification.setForeground(new Color(0, 0, 0));
		lblAbonnesModification.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbonnesModification.setBounds(160, 50, 65, 20);
		pnlAbonneMainContent.add(lblAbonnesModification);
		
		lblAbonnesSuppression = new JLabel("Suppression");
		lblAbonnesSuppression.addMouseListener(new CustumMouseAdapterForSubPanels(panelAbonnesSuppression, lblAbonnesSuppression, MySubPanelName.SUPPRESSION));
		lblAbonnesSuppression.setFont(new Font("Arial", Font.PLAIN, 11));
		lblAbonnesSuppression.setOpaque(true);
		lblAbonnesSuppression.setBackground(new Color(230, 230, 230));
		lblAbonnesSuppression.setForeground(new Color(0, 0, 0));
		lblAbonnesSuppression.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbonnesSuppression.setBounds(230, 50, 65, 20);
		pnlAbonneMainContent.add(lblAbonnesSuppression);
		
		JLabel lblAbonnes = new JLabel("Abonnés");
		lblAbonnes.setBounds(20, 5, 200, 50);
		pnlAbonneMainContent.add(lblAbonnes);
		lblAbonnes.setFont(new Font("Tahoma", Font.PLAIN, 18));

		pnlAbonneMainContent.add(panelAbonnesRecherche);
		panelAbonnesRecherche.setLayout(null);
		pnlAbonneMainContent.add(panelAbonnesAjout);
		panelAbonnesAjout.setLayout(null);
		pnlAbonneMainContent.add(panelAbonnesModification);
		panelAbonnesModification.setLayout(null);
		pnlAbonneMainContent.add(panelAbonnesSuppression);
		panelAbonnesSuppression.setLayout(null);
		
		menuClicked(panelAbonnesRecherche);
		
	}
	
	private void menuClicked(JPanel panelToShow) {
		panelAbonnesRecherche.setVisible(false);
		panelAbonnesAjout.setVisible(false);
		panelAbonnesModification.setVisible(false);
		panelAbonnesSuppression.setVisible(false);		

		panelToShow.setVisible(true);
	}
	
	private class CustumMouseAdapterForSubPanels extends MouseAdapter {
		private JPanel subPanel;
		private JLabel lblForSubPanel;
		private MySubPanelName currSubPanelName;

		CustumMouseAdapterForSubPanels(JPanel subPanel, JLabel lblForSubPanel, MySubPanelName currSubPanelName) {
			this.subPanel = subPanel;
			this.currSubPanelName = currSubPanelName;
			this.lblForSubPanel = lblForSubPanel;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			switch(currSubPanel) {
				case RECHERCHE:
					lblAbonnesRecherche.setBackground(unselectedColor);
					break;
				case AJOUT:
					lblAbonnesAjout.setBackground(unselectedColor);
					break;
				case MODIFICATION:
					lblAbonnesModification.setBackground(unselectedColor);
					break;
				case SUPPRESSION:
					lblAbonnesSuppression.setBackground(unselectedColor);
					break;						
			}
			
			menuClicked(subPanel);
			currSubPanel = this.currSubPanelName;
			lblForSubPanel.setBackground(selectedColor);
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			if(currSubPanel != currSubPanelName && !lblForSubPanel.getBackground().equals(selectedColor)) {
				lblForSubPanel.setBackground(selectedColor);
			}
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			if(currSubPanel != this.currSubPanelName) {				
				lblForSubPanel.setBackground(unselectedColor);
			}
		}			
	}



}
