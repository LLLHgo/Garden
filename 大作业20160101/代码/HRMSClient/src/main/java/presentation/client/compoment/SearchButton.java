package presentation.client.compoment;

import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * 搜索按钮
 * @author ClaraLee
 *
 */

public class SearchButton extends JButton{
	private static final long serialVersionUID = 1L;
	ImageIcon icon;
	public SearchButton(){
	icon=new ImageIcon(this.getClass().getResource("image/searchButton.png"));
	this.setIcon(icon);
	this.setOpaque(true);
	this.setContentAreaFilled(false);
	this.setBorderPainted(false);
	this.setFocusPainted(false);
	this.setBounds(550,15,60,60);
	}
}
