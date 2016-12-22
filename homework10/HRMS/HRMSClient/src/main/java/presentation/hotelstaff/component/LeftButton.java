package presentation.hotelstaff.component;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LeftButton extends JButton{
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private int w=55;
	private int h=55;
	private ImageIcon icon;
	
	public LeftButton(int x,int y){
		
		
		super();
		this.x = x;
		this.y = y;
		this.setBounds(this.x,this.y,this.w,this.h);
		this.icon = new ImageIcon("./src/main/resource/picture/hotelinfo/left.png");
		this.setIcon(this.icon);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setVisible(true);		
	}
}
