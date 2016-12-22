package presentation.client.compoment;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class deleteButton extends JButton{
	ImageIcon icon;
	public deleteButton(int x,int y){
	icon=new ImageIcon("image/deleteButton.png");
	this.setIcon(icon);
	this.setOpaque(true);
	this.setContentAreaFilled(false);
	this.setBorderPainted(false);
	this.setFocusPainted(false);
	this.setBounds(x,y,80,80);
	}
}
