package presentation.marketing.compoment;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MJTextField extends JTextField{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public MJTextField(String text,int x,int y,int w,int h,Font font){
    	this.setFont(font);
    	this.setForeground(Color.black);
    	this.setBounds(x, y,w, h);
    	this.setBackground(null);
    	this.setOpaque(false);
    	this.setBorder(new EmptyBorder(0,0,0,0));
    	this.setText(text);

    }

	public MJTextField(int x,int y,int w,int h,Font font){
    	this.setFont(font);
    	this.setForeground(Color.black);
    	this.setBounds(x, y,w, h);
    	this.setBackground(null);
    	this.setOpaque(false);
    	this.setBorder(new EmptyBorder(0,0,0,0));

    }
}
