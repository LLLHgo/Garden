package presentation.marketing.compoment;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JLabel;

public class MJLabel extends JLabel{

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public MJLabel(int x,int y,int w,int h,Icon icon){
    	this.setBounds(x, y, w, h);
    	this.setForeground(Color.white);
    	this.setIcon(icon);
    }

	public MJLabel(String s, int x,int y,int w,int h,Font font){
		this.setText(s);
    	this.setBounds(x, y, w, h);
    	this.setFont(font);
    	this.setForeground(Color.white);
    }
	public MJLabel(String s, int x,int y,int w,int h,Font font,Icon icon){
		this.setText(s);
    	this.setBounds(x, y, w, h);
    	this.setFont(font);
    	this.setForeground(Color.white);
    	this.setIcon(icon);
    }
}
