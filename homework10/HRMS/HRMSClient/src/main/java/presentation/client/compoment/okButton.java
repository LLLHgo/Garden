package presentation.client.compoment;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class okButton extends JButton{
	ImageIcon icon;
	public okButton(int x,int y){
	icon=new ImageIcon("image/checkButton.png");
	this.setIcon(icon);
	this.setOpaque(true);
	this.setContentAreaFilled(false);
	this.setBorderPainted(false);
	this.setFocusPainted(false);
	this.setBounds(x,y,120,120);
	}
}
