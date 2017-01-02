package presentation.client.compoment;

import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * 查看详情按钮
 * @author ClaraLee
 *
 */
public class viewButton extends JButton{
	private static final long serialVersionUID = 1L;
	ImageIcon icon;
	public viewButton(int x,int y){
	icon=new ImageIcon(this.getClass().getResource("image/viewButton.png"));
	this.setIcon(icon);
	this.setOpaque(true);
	this.setContentAreaFilled(false);
	this.setBorderPainted(false);
	this.setFocusPainted(false);
	this.setBounds(x,y,40,30);
	}
}
