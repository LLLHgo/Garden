package presentation.client.compoment;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class minideleteButton extends JButton{
	ImageIcon icon;
	public minideleteButton(int x,int y){
	icon=new ImageIcon("image/minideleteButton.png");
	this.setIcon(icon);
	this.setOpaque(true);
	this.setContentAreaFilled(false);
	this.setBorderPainted(false);
	this.setFocusPainted(false);
	this.setBounds(x,y,80,80);
	}
}
