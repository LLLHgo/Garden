package presentation.marketing.compoment;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

public class MJPasswordField extends JPasswordField{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public MJPasswordField(String text,int x,int y,int w,int h,Font font){
    	this.setFont(font);
    	this.setForeground(Color.black);
    	this.setBounds(x, y,w, h);
    	this.setBackground(null);
    	this.setOpaque(false);
    	this.setBorder(new EmptyBorder(0,0,0,0));
    	this.setText(text);
    	this.setEchoChar('*');

    }

	public MJPasswordField(int x,int y,int w,int h,Font font){
    	this.setFont(font);
    	this.setForeground(Color.black);
    	this.setBounds(x, y,w, h);
    	this.setBackground(null);
    	this.setOpaque(false);
    	this.setBorder(new EmptyBorder(0,0,0,0));
    	this.setEchoChar('*');

    }
}