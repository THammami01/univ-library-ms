package biblio_univ;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import biblio_univ.useful.MariaDBConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameDashboard extends JFrame {

	MariaDBConnection connDB;
	
	private Image imgHome = new ImageIcon(FrameLogin.class.getResource("imgs/help_man.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);

	private JPanel contentPane;
	
	private PanelLivres panelLivres;
	private PanelAbonnes panelAbonnes;
	private PanelPropos panelPropos;
	private PanelPrets panelPrets;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameDashboard frame = new FrameDashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameDashboard() {
		setUndecorated(true);
		/* DATABSE CONNECTION */
		connDB = new MariaDBConnection();		
		/* ================== */
		
		UIManager.put("OptionPane.yesButtonText", "Oui");
	    UIManager.put("OptionPane.noButtonText", "Non");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new LineBorder(new Color(34, 40, 49), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); // to center it according to screen		
		
				JLabel lblX = new JLabel("X");
				lblX.setHorizontalAlignment(SwingConstants.CENTER);
				lblX.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment fermer cette application ?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
							FrameDashboard.this.dispose();
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						lblX.setForeground(Color.RED);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						lblX.setForeground(new Color(34, 40, 49));
					}			
				});
				lblX.setForeground(new Color(34, 40, 49));
				lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblX.setBounds(570, 11, 20, 20);
				contentPane.add(lblX);

		JPanel panelMotion = new MotionPanel(FrameDashboard.this);
		panelMotion.setBounds(0, 0, 600, 30);
		contentPane.add(panelMotion);
		
		panelLivres = new PanelLivres();
		panelAbonnes = new PanelAbonnes();
		panelPrets = new PanelPrets();
		panelPropos = new PanelPropos();
		
		JPanel pnlMainContent = new JPanel();
		pnlMainContent.setBounds(189, 11, 381, 378);
		contentPane.add(pnlMainContent);
		pnlMainContent.setLayout(null);

		/**********************************************/
		pnlMainContent.add(panelLivres);
		pnlMainContent.add(panelAbonnes);
		pnlMainContent.add(panelPrets);
		pnlMainContent.add(panelPropos);
		
		menuClicked(panelPrets);
		/**********************************************/
		
		JPanel pnlSideBar = new JPanel();
		pnlSideBar.setLayout(null);
		pnlSideBar.setBackground(new Color(34, 40, 49));
		pnlSideBar.setBounds(0, 0, 187, 400);
		contentPane.add(pnlSideBar);
		
		JLabel lblIconHome = new JLabel("");
		lblIconHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconHome.setBounds(10, 23, 167, 80);
		lblIconHome.setIcon(new ImageIcon(imgHome));
		pnlSideBar.add(lblIconHome);
		
		JPanel pnlLivres = new JPanel();
		pnlLivres.addMouseListener(new MouseAdapterForPanels(pnlLivres) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelLivres);
			}
		});
		pnlLivres.setLayout(null);
		pnlLivres.setBorder(null);
		pnlLivres.setBackground(new Color(30, 144, 255));
		pnlLivres.setBounds(0, 132, 187, 30);
		pnlSideBar.add(pnlLivres);
		
		JLabel lblTxtLivres = new JLabel("Gestion des Livres");
		lblTxtLivres.setHorizontalAlignment(SwingConstants.LEFT);
		lblTxtLivres.setForeground(Color.WHITE);
		lblTxtLivres.setFont(new Font("Arial", Font.BOLD, 14));
		lblTxtLivres.setBounds(10, 5, 170, 20);
		pnlLivres.add(lblTxtLivres);
		
		JPanel pnlAbonnes = new JPanel();
		pnlAbonnes.addMouseListener(new MouseAdapterForPanels(pnlAbonnes) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelAbonnes);
			}			
		});
		pnlAbonnes.setLayout(null);
		pnlAbonnes.setBorder(null);
		pnlAbonnes.setBackground(new Color(30, 144, 255));
		pnlAbonnes.setBounds(0, 167, 187, 30);
		pnlSideBar.add(pnlAbonnes);
		
		JLabel lblTxtAbonnes = new JLabel("Gestion des Abonnés");
		lblTxtAbonnes.setForeground(Color.WHITE);
		lblTxtAbonnes.setFont(new Font("Arial", Font.BOLD, 14));
		lblTxtAbonnes.setBounds(10, 5, 170, 20);
		pnlAbonnes.add(lblTxtAbonnes);
		
		JPanel pnlPrets = new JPanel();
		pnlPrets.addMouseListener(new MouseAdapterForPanels(pnlPrets) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelPrets);
			}
		});
		pnlPrets.setLayout(null);
		pnlPrets.setBorder(null);
		pnlPrets.setBackground(new Color(30, 144, 255));
		pnlPrets.setBounds(0, 202, 187, 30);
		pnlSideBar.add(pnlPrets);
		
		JLabel lblTxtPrets = new JLabel("Gestion des Pr\u00EAts");
		lblTxtPrets.setForeground(Color.WHITE);
		lblTxtPrets.setFont(new Font("Arial", Font.BOLD, 14));
		lblTxtPrets.setBounds(10, 5, 170, 20);
		pnlPrets.add(lblTxtPrets);
		
		JPanel pnlPropos = new JPanel();
		pnlPropos.addMouseListener(new MouseAdapterForPanels(pnlPropos) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelPropos);
			}			
		});
		pnlPropos.setLayout(null);
		pnlPropos.setBorder(null);
		pnlPropos.setBackground(new Color(30, 144, 255));
		pnlPropos.setBounds(0, 237, 187, 30);
		pnlSideBar.add(pnlPropos);
		
		JLabel lblTxtPropos = new JLabel("À Propos");
		lblTxtPropos.setForeground(Color.WHITE);
		lblTxtPropos.setFont(new Font("Arial", Font.BOLD, 14));
		lblTxtPropos.setBounds(10, 5, 170, 20);
		pnlPropos.add(lblTxtPropos);
		
		JPanel pnlDeconnexion = new JPanel();
		pnlDeconnexion.addMouseListener(new MouseAdapterForPanels(pnlDeconnexion) {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlDeconnexion.setBackground(new Color(232, 69, 69));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Êtes-vous certain de vouloir vous déconnecter ?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					connDB.close();
					FrameLogin fl = new FrameLogin();
					fl.setVisible(true);
					FrameDashboard.this.dispose();
				}	
			}
		});
		pnlDeconnexion.setLayout(null);
		pnlDeconnexion.setBorder(null);
		pnlDeconnexion.setBackground(new Color(30, 144, 255));
		pnlDeconnexion.setBounds(0, 272, 187, 30);
		pnlSideBar.add(pnlDeconnexion);
		
		JLabel lblTxtDeconnexion = new JLabel("Déconnexion");
		lblTxtDeconnexion.setForeground(Color.WHITE);
		lblTxtDeconnexion.setFont(new Font("Arial", Font.BOLD, 14));
		lblTxtDeconnexion.setBounds(10, 5, 170, 20);
		pnlDeconnexion.add(lblTxtDeconnexion);
	}
	
	public void menuClicked(JPanel panelToShow) {
		panelLivres.setVisible(false);
		panelAbonnes.setVisible(false);
		panelPrets.setVisible(false);
		panelPropos.setVisible(false);
		
		panelToShow.setVisible(true);
	}
	
	private class MouseAdapterForPanels extends MouseAdapter {
		JPanel currPanel;
		
		public MouseAdapterForPanels(JPanel panel) {
			currPanel = panel;
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			currPanel.setBackground(new Color(50, 130, 240));
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			currPanel.setBackground(new Color(30, 144, 255));			
		}
		
	}
	

}
