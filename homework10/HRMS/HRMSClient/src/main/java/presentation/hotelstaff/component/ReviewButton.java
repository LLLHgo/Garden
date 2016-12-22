package presentation.hotelstaff.component;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ReviewButton extends JButton{
	
	private static final long serialVersionUID = 1L;
	private int x=625;
	private int y;
	private int w=38;
	private int h=33;
	private ImageIcon icon;
	
	public ReviewButton(int x,int y,int w,int h){
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.setBounds(this.x,this.y,this.w,this.h);
		this.icon = new ImageIcon("./src/main/resource/picture/hotelinfo/review.png");
		this.setIcon(this.icon);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setVisible(true);
	}
}
