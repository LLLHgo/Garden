package presentation.hotelstaff.component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class RoominfoLabel extends JLabel{
	private static final long serialVersionUID = 1L;
	
	public RoominfoLabel(int x,int y,int w,int h,String string){
		super();
		this.setBounds(x,y,w,h);
		this.setVisible(true);
		Font font = new Font("微软雅黑",Font.PLAIN,20);
		this.setFont(font);
		this.setForeground(Color.white);
		this.setText(string);
	}
}
