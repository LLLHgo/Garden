package presentation.client.compoment;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class evaluateButton extends JButton{
	ImageIcon icon;
	public evaluateButton(int x,int y){
	icon=new ImageIcon("image/evaluateButton.png");
	this.setIcon(icon);
	this.setOpaque(true);
	this.setContentAreaFilled(false);
	this.setBorderPainted(false);
	this.setFocusPainted(false);
	this.setBounds(x,y,80,80);
	}
}
