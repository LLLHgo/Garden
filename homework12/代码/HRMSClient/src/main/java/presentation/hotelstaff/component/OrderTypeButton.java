package presentation.hotelstaff.component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class OrderTypeButton extends JButton{
		private static final long serialVersionUID = 1L;
		private int x;
		private int y;
		private int w=170;
		private int h=25;
		private ImageIcon icon;
	
		
	public OrderTypeButton(int x,int y,String text){
		super();
		this.x = x;
		this.y = y;
		this.setBounds(this.x,this.y,this.w,this.h);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setVisible(false);
		this.setFont(new Font("微软雅黑",Font.PLAIN,15));
		this.setForeground(Color.white);
		this.setText(text);
	}
}
