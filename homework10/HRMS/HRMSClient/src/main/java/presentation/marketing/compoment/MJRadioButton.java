package presentation.marketing.compoment;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JRadioButton;

public class MJRadioButton extends JRadioButton{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public MJRadioButton(String text,boolean choosed,int x,int y,int w,int h,Font font){
		this.setText(text);
		this.setSelected(false);
    	this.setBounds(x, y, w, h);
    	this.setFont(font);
    	this.setForeground(Color.white);
    	this.setContentAreaFilled(false);
	    this.setOpaque(false);
	    this.setBackground(null);
	    this.setBorderPainted(false);;
    }
}
