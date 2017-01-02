package presentation.client.compoment;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class deleteButton extends JButton{
	/**
	 *删除按钮
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon icon;
	public deleteButton(int x,int y){
	icon=new ImageIcon(this.getClass().getResource("image/deleteButton.png"));
	this.setIcon(icon);
	this.setOpaque(true);
	this.setContentAreaFilled(false);
	this.setBorderPainted(false);
	this.setFocusPainted(false);
	this.setBounds(x,y,80,80);
	}
}
