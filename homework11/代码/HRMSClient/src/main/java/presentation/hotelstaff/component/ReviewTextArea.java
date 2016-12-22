package presentation.hotelstaff.component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class ReviewTextArea extends JTextArea{
	private static final long serialVersionUID = 1L;

	private int x;
	private int y;
	private int w;
	private int h;
	
	public ReviewTextArea(int x,int y,int w,int h,String string){
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.setBounds(this.x,this.y,this.w,this.h);
		this.setEditable(false);
		this.setVisible(true);
		Font font = new Font("微软雅黑",Font.PLAIN,18);
		this.setFont(font);
		this.setForeground(Color.white);
		this.setText(string);
		this.setOpaque(false);
		this.setLineWrap(true);
	}
}
