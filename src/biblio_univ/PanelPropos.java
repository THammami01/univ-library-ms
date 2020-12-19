package biblio_univ;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import java.awt.Point;

// ENTER URL, HOST, PASSWORD AND DATABASE NAME
// CREATE NEW CONSTRUCTOR THAT INITIALES THE CONNECTION WITH THESE VALUES
// CREATE DEBUGGING USERNAME AND PASSWORD FOR LOGIN WITHOUT DATABASE ACCES WHEN YOU SHARE YOUR CODE ON GITHUB
// CREATE NEW VERSION IN ENGLISH

public class PanelPropos extends JPanel {

	private Image myImg = new ImageIcon(FrameLogin.class.getResource("imgs/my_img.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);

	/**
	 * Create the panel.
	 */
	public PanelPropos() {
		setFont(new Font("Tahoma", Font.PLAIN, 10));
		setBounds(0, 0, 381, 378);
		setLayout(null);
		
		JLabel lblSettingsContent = new JLabel("À Propos");
		lblSettingsContent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSettingsContent.setBounds(20, 5, 200, 50);
		add(lblSettingsContent);
		
		JLabel lblMyImg = new JLabel("");
		lblMyImg.setBounds(20, 149, 80, 80);
		lblMyImg.setIcon(new ImageIcon(myImg));
		add(lblMyImg);
		
		JLabel lblPropos = new JLabel("<html>Application de gestion de la biblioth\u00E8que universitaire.<br/><br/>Version 1.0.0<br/><br/>D\u00E9velopp\u00E9e par:</html>");
		lblPropos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPropos.setVerticalAlignment(SwingConstants.TOP);
		lblPropos.setBounds(20, 66, 351, 86);
		add(lblPropos);
		
		JLabel lblNewLabel = new JLabel("<html>Tarek Hammami<br/>\u00C9tudiant \u00E0 l'ISLAIB (2GLSI, 2020/21)<br/>thammami.me@gmail.com<br/>github.com/THammami01</html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(110, 154, 241, 71);
		add(lblNewLabel);
		
	}
}
