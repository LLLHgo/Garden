package presentation.client.compoment;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class editButton extends JButton{
	/**
	 *编辑按钮
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon icon;
	public editButton(int x,int y){
	icon=new ImageIcon(this.getClass().getResource("image/editButton.png"));
	this.setIcon(icon);
	this.setOpaque(true);
	this.setContentAreaFilled(false);
	this.setBorderPainted(false);
	this.setFocusPainted(false);
	this.setBounds(x,y,40,40);
	}
}
