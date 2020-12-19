package biblio_univ;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import biblio_univ.useful.MariaDBConnection;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Window.Type;

public class FrameLogin extends JFrame {

	MariaDBConnection connDB;
	
	private Image imgLogo = new ImageIcon(FrameLogin.class.getResource("imgs/help_man.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
	private Image imgUsername = new ImageIcon(FrameLogin.class.getResource("imgs/help_man.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image imgPassword = new ImageIcon(FrameLogin.class.getResource("imgs/help_man.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image imgLogin = new ImageIcon(FrameLogin.class.getResource("imgs/log_in.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblLoginMsg = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
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
	public FrameLogin() {

		/* DATABSE CONNECTION */
		connDB = new MariaDBConnection();
		if(connDB.isConnected != null) {
			JOptionPane.showMessageDialog(null, connDB.isConnected);			
		}
		/* ================== */
		
//		UIManager.put("OptionPane.cancelButtonText", "Annuler");
//	    UIManager.put("OptionPane.okButtonText", "D'accord");
	    UIManager.put("OptionPane.yesButtonText", "Oui");
	    UIManager.put("OptionPane.noButtonText", "Non");
	    
	    setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(34, 40, 49));
		contentPane.setBorder(new LineBorder(new Color(34, 40, 49), 2));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(34, 40, 49));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
				JLabel lblX = new JLabel("X");
				lblX.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment fermer cette application ?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
							FrameLogin.this.dispose();
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						lblX.setForeground(Color.RED);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						lblX.setForeground(Color.WHITE);
					}
				});
				lblX.setForeground(new Color(255, 255, 255));
				lblX.setHorizontalAlignment(SwingConstants.CENTER);
				lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
				lblX.setBounds(566, 11, 20, 20);
				panel.add(lblX);

		JPanel panelMotion = new MotionPanel(FrameLogin.this);
		panelMotion.setBounds(0, 0, 600, 30);
		panel.add(panelMotion);		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(167, 159, 250, 40);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUsername.getText().equals("Nom d'utilisateur")) {
					txtUsername.setText("");
				} else {
					txtUsername.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().equals("")) {
					txtUsername.setText("Nom d'utilisateur");
				}
			}
		});
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 14));
		txtUsername.setText("Nom d'utilisateur");
		txtUsername.setBounds(10, 8, 200, 25);
		panel_1.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblIconUsername = new JLabel("");
		lblIconUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconUsername.setBounds(210, 0, 40, 40);
		lblIconUsername.setIcon(new ImageIcon(imgUsername));
		panel_1.add(lblIconUsername);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(167, 210, 250, 40);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword.getText().equals("Mot de passe")) {
					txtPassword.setEchoChar('●');
					txtPassword.setText("");
				} else {
					txtPassword.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword.getText().equals("")) {
					txtPassword.setText("Mot de passe");
					txtPassword.setEchoChar((char) 0);
				}
			}
		});
		txtPassword.setBorder(null);
		txtPassword.setEchoChar((char) 0);
		txtPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		txtPassword.setText("Mot de passe");
		txtPassword.setBounds(10, 8, 200, 25);
		panel_1_1.add(txtPassword);
		
		JLabel lblIconPassword = new JLabel("");
		lblIconPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPassword.setBounds(210, 0, 40, 40);
		lblIconPassword.setIcon(new ImageIcon(imgPassword));
		panel_1_1.add(lblIconPassword);
		
		JPanel pnlBtnLogin = new JPanel();
		pnlBtnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] credentials = connDB.getCredentials();

				if(txtUsername.getText().equals(credentials[0]) && txtPassword.getText().equals(credentials[1])) {
					connDB.close();
					lblLoginMsg.setText("");
//					JOptionPane.showMessageDialog(null, "Login Successful");
				
					FrameDashboard fd = new FrameDashboard();
					fd.setVisible(true);	
					FrameLogin.this.dispose();
					
				} else if(
							txtUsername.getText().equals("") || txtUsername.getText().equals("Nom d'utilisateur") ||
							txtPassword.getText().equals("") || txtPassword.getText().equals("Mot de passe")
						) {
					lblLoginMsg.setText("Tous les champs doivent être remplis !");					

				} else if(credentials[0].equals("ERR01")) {
					lblLoginMsg.setText("Erreur lors de la connexion !");
					
				} else {
					lblLoginMsg.setText("Nom d'utilisateur et/ou mot de passe incorrect !");	
					
				}

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(50, 130, 240));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(30, 144, 255));
			}
		});
		pnlBtnLogin.setBackground(new Color(30, 144, 255));
		pnlBtnLogin.setBounds(167, 278, 250, 40);
		panel.add(pnlBtnLogin);
		pnlBtnLogin.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Connexion");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(75, 6, 123, 29);
		pnlBtnLogin.add(lblNewLabel);
		
		JLabel lblIconLogin = new JLabel("");
		lblIconLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogin.setBounds(60, 0, 40, 40);
		lblIconLogin.setIcon(new ImageIcon(imgLogin));
		pnlBtnLogin.add(lblIconLogin);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(167, 65, 250, 68);
		panel.add(lblIconLogo);
		lblIconLogo.setIcon(new ImageIcon(imgLogo));
		lblLoginMsg.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		lblLoginMsg.setForeground(new Color(0, 100, 0));
		lblLoginMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginMsg.setBounds(167, 262, 250, 14);
		panel.add(lblLoginMsg);
		setLocationRelativeTo(null); // to center it according to screen
		
	}
		
	
	
}
