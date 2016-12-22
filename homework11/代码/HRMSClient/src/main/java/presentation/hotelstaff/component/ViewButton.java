package presentation.hotelstaff.component;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ViewButton extends JButton{

	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private int w=37;
	private int h=25;
	private ImageIcon icon;
	
	public ViewButton(int x,int y){
		this.x = x;
		this.y = y;
		this.setBounds(this.x,this.y,this.w,this.h);
		this.icon = new ImageIcon("./src/main/resource/picture/hotelstrategy/view.png");
		this.setIcon(this.icon);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setVisible(true);
	}
}
