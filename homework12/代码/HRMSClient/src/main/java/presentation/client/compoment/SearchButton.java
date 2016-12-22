package presentation.client.compoment;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SearchButton extends JButton{
	ImageIcon icon;
	public SearchButton(){
	icon=new ImageIcon("image/searchButton.png");
	this.setIcon(icon);
	this.setOpaque(true);
	this.setContentAreaFilled(false);
	this.setBorderPainted(false);
	this.setFocusPainted(false);
	this.setBounds(550,15,60,60);
	}
}
