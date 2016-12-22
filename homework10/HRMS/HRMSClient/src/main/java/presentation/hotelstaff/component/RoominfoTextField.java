package presentation.hotelstaff.component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

public class RoominfoTextField extends JTextField{
	private static final long serialVersionUID = 1L;
	
	public RoominfoTextField(int x,int y,int w,int h){
		super();
		this.setBounds(x,y,w,h);
		this.setVisible(true);
		Font font = new Font("微软雅黑",Font.PLAIN,20);
		this.setFont(font);
		this.setForeground(Color.white);
		this.setOpaque(false);
		this.setBorder(null);	
	}
}
