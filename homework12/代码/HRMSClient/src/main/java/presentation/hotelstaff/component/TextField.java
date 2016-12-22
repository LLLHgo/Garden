package presentation.hotelstaff.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TextField extends JTextField{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public TextField(String string,int x,int y,int w,int h,int num){
		Font font = new Font("微软雅黑",Font.PLAIN,15);
    	this.setFont(font);
    	this.setForeground(Color.black);
    	this.setBounds(x, y,w, h);
    	this.setBackground(null);
    	this.setOpaque(false);
    	this.setBorder(new EmptyBorder(0,0,0,0));
    	this.setText(string);
    }

//	public TextField(int x,int y,int w,int h,Font font){
//    	this.setFont(font);
//    	this.setForeground(Color.black);
//    	this.setBounds(x, y,w, h);
//    	this.setBackground(null);
//    	//this.setOpaque(false);
//    	this.setBorder(new EmptyBorder(0,0,0,0));
//
//    }
//	
}
