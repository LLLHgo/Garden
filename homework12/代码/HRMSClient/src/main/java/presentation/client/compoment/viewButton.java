package presentation.client.compoment;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class viewButton extends JButton{
	ImageIcon icon;
	public viewButton(int x,int y){
	icon=new ImageIcon("image/viewButton.png");
	this.setIcon(icon);
	this.setOpaque(true);
	this.setContentAreaFilled(false);
	this.setBorderPainted(false);
	this.setFocusPainted(false);
	this.setBounds(x,y,40,30);
	}
}
