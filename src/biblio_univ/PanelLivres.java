package biblio_univ;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import biblio_univ.panels_livres.PanelLivresAjout;
import biblio_univ.panels_livres.PanelLivresModification;
import biblio_univ.panels_livres.PanelLivresRecherche;
import biblio_univ.panels_livres.PanelLivresSuppression;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelLivres extends JPanel {

	private enum MySubPanelName {
		RECHERCHE,
		AJOUT,
	    MODIFICATION,
	    SUPPRESSION
	}
	
	private Color selectedColor = new Color(215, 215, 215);
	private Color unselectedColor = new Color(230, 230, 230);
	
	MySubPanelName currSubPanel;
	
	private PanelLivresAjout panelLivresAjout;
	private PanelLivresModification panelLivresModification;
	private PanelLivresSuppression panelLivresSuppression;
	private PanelLivresRecherche panelLivresRecherche;
	private JLabel lblLivresRecherche;
	private JLabel lblLivresAjout;
	private JLabel lblLivresModification;
	private JLabel lblLivresSuppression;
	
	/**
	 * Create the panel.
	 */
	
	public PanelLivres() {
		// == MY INITS ====================================
		currSubPanel = MySubPanelName.RECHERCHE;
		
		
		// ================================================

		setBounds(0, 0, 381, 378);
		setLayout(null);
		
		panelLivresAjout = new PanelLivresAjout();
		panelLivresAjout.setLocation(0, 73);
		panelLivresAjout.setSize(381, 305);
		panelLivresModification = new PanelLivresModification();
		panelLivresModification.setLocation(0, 73);
		panelLivresModification.setSize(381, 305);
		panelLivresSuppression = new PanelLivresSuppression();
		panelLivresSuppression.setLocation(0, 73);
		panelLivresSuppression.setSize(381, 305);
		panelLivresRecherche = new PanelLivresRecherche();
		panelLivresRecherche.setLocation(0, 73);
		panelLivresRecherche.setSize(381, 305);		
		
		JPanel pnlAbonneMainContent = new JPanel();
		pnlAbonneMainContent.setBounds(0, 0, 381, 378);
		add(pnlAbonneMainContent);
		pnlAbonneMainContent.setLayout(null);
		
		lblLivresRecherche = new JLabel("Recherche");
		lblLivresRecherche.addMouseListener(new CustumMouseAdapterForSubPanels(panelLivresRecherche, lblLivresRecherche, MySubPanelName.RECHERCHE));
		lblLivresRecherche.setFont(new Font("Arial", Font.PLAIN, 11));
		lblLivresRecherche.setOpaque(true);
		lblLivresRecherche.setBackground(new Color(215, 215, 215));
		lblLivresRecherche.setForeground(new Color(0, 0, 0));
		lblLivresRecherche.setHorizontalAlignment(SwingConstants.CENTER);
		lblLivresRecherche.setBounds(20, 50, 65, 20);
		pnlAbonneMainContent.add(lblLivresRecherche);
		
		lblLivresAjout = new JLabel("Ajout");
		lblLivresAjout.addMouseListener(new CustumMouseAdapterForSubPanels(panelLivresAjout, lblLivresAjout, MySubPanelName.AJOUT));
		lblLivresAjout.setFont(new Font("Arial", Font.PLAIN, 11));
		lblLivresAjout.setOpaque(true);
		lblLivresAjout.setBackground(new Color(230, 230, 230));
		lblLivresAjout.setForeground(new Color(0, 0, 0));
		lblLivresAjout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLivresAjout.setBounds(90, 50, 65, 20);
		pnlAbonneMainContent.add(lblLivresAjout);
		
		lblLivresModification = new JLabel("Modification");
		lblLivresModification.addMouseListener(new CustumMouseAdapterForSubPanels(panelLivresModification, lblLivresModification, MySubPanelName.MODIFICATION));
		lblLivresModification.setFont(new Font("Arial", Font.PLAIN, 11));
		lblLivresModification.setOpaque(true);
		lblLivresModification.setBackground(new Color(230, 230, 230));
		lblLivresModification.setForeground(new Color(0, 0, 0));
		lblLivresModification.setHorizontalAlignment(SwingConstants.CENTER);
		lblLivresModification.setBounds(160, 50, 65, 20);
		pnlAbonneMainContent.add(lblLivresModification);
		
		lblLivresSuppression = new JLabel("Suppression");
		lblLivresSuppression.addMouseListener(new CustumMouseAdapterForSubPanels(panelLivresSuppression, lblLivresSuppression, MySubPanelName.SUPPRESSION));
		lblLivresSuppression.setFont(new Font("Arial", Font.PLAIN, 11));
		lblLivresSuppression.setOpaque(true);
		lblLivresSuppression.setBackground(new Color(230, 230, 230));
		lblLivresSuppression.setForeground(new Color(0, 0, 0));
		lblLivresSuppression.setHorizontalAlignment(SwingConstants.CENTER);
		lblLivresSuppression.setBounds(230, 50, 65, 20);
		pnlAbonneMainContent.add(lblLivresSuppression);
		
		JLabel lblHomeContent = new JLabel("Livres");
		lblHomeContent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHomeContent.setBounds(20, 5, 200, 50);
		add(lblHomeContent);

		JLabel lblLivres = new JLabel("Livres");
		lblLivres.setBounds(20, 5, 200, 50);
		pnlAbonneMainContent.add(lblLivres);
		lblLivres.setFont(new Font("Tahoma", Font.PLAIN, 18));

		pnlAbonneMainContent.add(panelLivresRecherche);
		panelLivresRecherche.setLayout(null);
		pnlAbonneMainContent.add(panelLivresAjout);
		panelLivresAjout.setLayout(null);
		pnlAbonneMainContent.add(panelLivresModification);
		panelLivresModification.setLayout(null);
		pnlAbonneMainContent.add(panelLivresSuppression);
		panelLivresSuppression.setLayout(null);
		
		menuClicked(panelLivresRecherche);	
	}


	private void menuClicked(JPanel panelToShow) {
		panelLivresRecherche.setVisible(false);
		panelLivresAjout.setVisible(false);
		panelLivresModification.setVisible(false);
		panelLivresSuppression.setVisible(false);		

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
					lblLivresRecherche.setBackground(unselectedColor);
					break;
				case AJOUT:
					lblLivresAjout.setBackground(unselectedColor);
					break;
				case MODIFICATION:
					lblLivresModification.setBackground(unselectedColor);
					break;
				case SUPPRESSION:
					lblLivresSuppression.setBackground(unselectedColor);
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
