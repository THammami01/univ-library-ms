package biblio_univ.useful;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class CustomMouseAdapter extends MouseAdapter {

		JLabel currBtn;
		
		public CustomMouseAdapter(JLabel currBtn) {
			this.currBtn = currBtn;
		}
	
		@Override
		public void mouseEntered(MouseEvent e) {
			currBtn.setBackground(new Color(190, 190, 190));
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			currBtn.setBackground(new Color(215, 215, 215));				
		}
}
