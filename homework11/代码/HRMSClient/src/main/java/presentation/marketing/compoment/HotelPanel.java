package presentation.marketing.compoment;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HotelPanel extends JPanel{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Font font=new Font("楷体",Font.ITALIC,20);
	public HotelPanel(String text,int x,int y,int w,int h){
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
		this.setLayout(null);
		JLabel label=new MJLabel(text,0,0,100,50,font);
		this.add(label);

	}

}
