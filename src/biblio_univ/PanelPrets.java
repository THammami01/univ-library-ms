package biblio_univ;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import biblio_univ.panels_prets.PanelPretsAjout;
import biblio_univ.panels_prets.PanelPretsRecherche;
import biblio_univ.panels_prets.PanelPretsStatistique;
import biblio_univ.panels_prets.PanelPretsRemise;
import biblio_univ.panels_prets.PanelPretsVerification;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelPrets extends JPanel {

	private enum MySubPanelName {
		RECHERCHE,
		VERIFICATION,
		AJOUT,
	    REMISE,
	    STATISTIQUE
	}
	
	private Color selectedColor = new Color(215, 215, 215);
	private Color unselectedColor = new Color(230, 230, 230);
	
	MySubPanelName currSubPanel;
	
	private PanelPretsRecherche panelPretsRecherche;
	private PanelPretsAjout panelPretsAjout;
	private PanelPretsRemise panelPretsRemise;
	private PanelPretsVerification panelPretsVerification;
	private PanelPretsStatistique panelPretsStatistique;
	private JLabel lblPretsRecherche;
	private JLabel lblPretsAjout;
	private JLabel lblPretsRemise;
	private JLabel lblPretsVerification;
	private JLabel lblPretsStatistique;

	/**
	 * Create the panel.
	 */
	
	public PanelPrets() {
		// == MY INITS ====================================
		currSubPanel = MySubPanelName.RECHERCHE;
		
		
		// ================================================
		
		setBounds(0, 0, 381, 378);
		setLayout(null);
		
		
		panelPretsAjout = new PanelPretsAjout();
		panelPretsAjout.setLocation(0, 73);
		panelPretsAjout.setSize(381, 305);
		panelPretsVerification = new PanelPretsVerification();
		panelPretsVerification.setLocation(0, 73);
		panelPretsVerification.setSize(381, 305);
		panelPretsRemise = new PanelPretsRemise();
		panelPretsRemise.setLocation(0, 73);
		panelPretsRemise.setSize(381, 305);
		panelPretsRecherche = new PanelPretsRecherche();
		panelPretsRecherche.setLocation(0, 73);
		panelPretsRecherche.setSize(381, 305);
		panelPretsStatistique = new PanelPretsStatistique();
		panelPretsStatistique.setLocation(0, 73);
		panelPretsStatistique.setSize(381, 305);
		
		JPanel pnlPretsMainContent = new JPanel();
		pnlPretsMainContent.setBounds(0, 0, 381, 378);
		add(pnlPretsMainContent);
		pnlPretsMainContent.setLayout(null);
		
		lblPretsRecherche = new JLabel("Recherche");
		lblPretsRecherche.addMouseListener(new CustumMouseAdapterForSubPanels(panelPretsRecherche, lblPretsRecherche, MySubPanelName.RECHERCHE));
		lblPretsRecherche.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPretsRecherche.setOpaque(true);
		lblPretsRecherche.setBackground(new Color(215, 215, 215));
		lblPretsRecherche.setForeground(new Color(0, 0, 0));
		lblPretsRecherche.setHorizontalAlignment(SwingConstants.CENTER);
		lblPretsRecherche.setBounds(20, 50, 65, 20);
		pnlPretsMainContent.add(lblPretsRecherche);
		
		lblPretsAjout = new JLabel("Ajout");
		lblPretsAjout.addMouseListener(new CustumMouseAdapterForSubPanels(panelPretsAjout, lblPretsAjout, MySubPanelName.AJOUT));
		lblPretsAjout.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPretsAjout.setOpaque(true);
		lblPretsAjout.setBackground(new Color(230, 230, 230));
		lblPretsAjout.setForeground(new Color(0, 0, 0));
		lblPretsAjout.setHorizontalAlignment(SwingConstants.CENTER);
		lblPretsAjout.setBounds(90, 50, 65, 20);
		pnlPretsMainContent.add(lblPretsAjout);
		
		lblPretsVerification = new JLabel("Verification");
		lblPretsVerification.addMouseListener(new CustumMouseAdapterForSubPanels(panelPretsVerification, lblPretsVerification, MySubPanelName.VERIFICATION));
		lblPretsVerification.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPretsVerification.setOpaque(true);
		lblPretsVerification.setBackground(new Color(230, 230, 230));
		lblPretsVerification.setForeground(new Color(0, 0, 0));
		lblPretsVerification.setHorizontalAlignment(SwingConstants.CENTER);
		lblPretsVerification.setBounds(230, 50, 65, 20);
		pnlPretsMainContent.add(lblPretsVerification);
		
		lblPretsRemise = new JLabel("Remise");
		lblPretsRemise.addMouseListener(new CustumMouseAdapterForSubPanels(panelPretsRemise, lblPretsRemise, MySubPanelName.REMISE));
		lblPretsRemise.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPretsRemise.setOpaque(true);
		lblPretsRemise.setBackground(new Color(230, 230, 230));
		lblPretsRemise.setForeground(new Color(0, 0, 0));
		lblPretsRemise.setHorizontalAlignment(SwingConstants.CENTER);
		lblPretsRemise.setBounds(160, 50, 65, 20);
		pnlPretsMainContent.add(lblPretsRemise);
		
		lblPretsStatistique = new JLabel("Statistique");
		lblPretsStatistique.addMouseListener(new CustumMouseAdapterForSubPanels(panelPretsStatistique, lblPretsStatistique, MySubPanelName.STATISTIQUE));
		lblPretsStatistique.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPretsStatistique.setOpaque(true);
		lblPretsStatistique.setBackground(new Color(230, 230, 230));
		lblPretsStatistique.setForeground(new Color(0, 0, 0));
		lblPretsStatistique.setHorizontalAlignment(SwingConstants.CENTER);
		lblPretsStatistique.setBounds(300, 50, 65, 20);
		pnlPretsMainContent.add(lblPretsStatistique);

		JLabel lblPretsContent = new JLabel("Prêts");
		lblPretsContent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPretsContent.setBounds(20, 5, 200, 50);
		pnlPretsMainContent.add(lblPretsContent);
		
		pnlPretsMainContent.add(panelPretsRecherche);
		panelPretsRecherche.setLayout(null);
		pnlPretsMainContent.add(panelPretsAjout);
		panelPretsAjout.setLayout(null);
		pnlPretsMainContent.add(panelPretsVerification);
		panelPretsVerification.setLayout(null);
		pnlPretsMainContent.add(panelPretsRemise);
		panelPretsRemise.setLayout(null);
		pnlPretsMainContent.add(panelPretsStatistique);
		panelPretsStatistique.setLayout(null);
		
		
		menuClicked(panelPretsRecherche);	
	}

	
	private void menuClicked(JPanel panelToShow) {
		panelPretsRecherche.setVisible(false);
		panelPretsAjout.setVisible(false);
		panelPretsVerification.setVisible(false);
		panelPretsRemise.setVisible(false);		
		panelPretsStatistique.setVisible(false);		

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
					lblPretsRecherche.setBackground(unselectedColor);
					break;
				case AJOUT:
					lblPretsAjout.setBackground(unselectedColor);
					break;
				case VERIFICATION:
					lblPretsVerification.setBackground(unselectedColor);
					break;
				case REMISE:
					lblPretsRemise.setBackground(unselectedColor);
					break;
				case STATISTIQUE:
					lblPretsStatistique.setBackground(unselectedColor);
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
