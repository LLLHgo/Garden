package presentation.hotelstaff.component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class UserImageLabel extends JLabel{
	private ImageIcon user_image;
	
	public UserImageLabel(int x,int y){
		user_image = new ImageIcon(this.getClass().getResource("images/user_image.png"));
		this.setIcon(user_image);
		this.setBounds(x, y, 100, 100);
	}
}
