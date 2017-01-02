package presentation.hotelstaff.component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class TextLabel extends JLabel{
	private static final long serialVersionUID = 1L;
	int x;
	int y;
	int w;
	int h;
	
	public TextLabel(int x,int y,int w,int h,String text){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.setText(text);
		this.setFont(new Font("微软雅黑",Font.PLAIN,18));
		this.setBounds(x,y,w,h);
		this.setForeground(Color.lightGray);
	}
	
	
}
