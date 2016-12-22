package presentation.hotelstaff.component;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AddButton extends JButton{
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private int w=50;
	private int h=50;
	private ImageIcon icon;
	
	public AddButton(int x,int y){
		super();
		this.x = x;
		this.y = y;
		this.setBounds(this.x,this.y,this.w,this.h);
		this.icon = new ImageIcon("./src/main/resource/picture/hotelinfo/add.png");
		this.setIcon(this.icon);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setVisible(true);
	}
	
	public AddButton(int x,int y,int w,int h){
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.setBounds(this.x,this.y,this.w,this.h);
		this.icon = new ImageIcon("./src/main/resource/picture/hotelinfo/add.png");
		this.setIcon(this.icon);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setVisible(true);
	}
}
