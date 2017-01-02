package presentation.client.compoment;

import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * 小型的删除按钮
 * @author ClaraLee
 *
 */
public class minideleteButton extends JButton{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon icon;
	public minideleteButton(int x,int y){
	icon=new ImageIcon(this.getClass().getResource("image/minideleteButton.png"));
	this.setIcon(icon);
	this.setOpaque(true);
	this.setContentAreaFilled(false);
	this.setBorderPainted(false);
	this.setFocusPainted(false);
	this.setBounds(x,y,80,80);
	}
}
