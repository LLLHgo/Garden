package presentation.hotelstaff.component;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ConfirmButton extends JButton{
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private int w=55;
	private int h=55;
	private ImageIcon icon;
	
	public ConfirmButton(int x,int y){
		super();
		this.x = x;
		this.y = y;
		this.setBounds(this.x,this.y,this.w,this.h);
		this.icon = new ImageIcon(this.getClass().getResource("images/confirm.png"));
		this.setIcon(this.icon);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setVisible(true);
	}
}
