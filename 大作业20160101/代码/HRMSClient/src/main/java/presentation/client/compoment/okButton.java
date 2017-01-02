package presentation.client.compoment;

import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * 确认按钮
 * @author ClaraLee
 *
 */
public class okButton extends JButton{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon icon;
	public okButton(int x,int y){
	icon=new ImageIcon(this.getClass().getResource("image/checkButton.png"));
	this.setIcon(icon);
	this.setOpaque(true);
	this.setContentAreaFilled(false);
	this.setBorderPainted(false);
	this.setFocusPainted(false);
	this.setBounds(x,y,120,120);
	}
}
