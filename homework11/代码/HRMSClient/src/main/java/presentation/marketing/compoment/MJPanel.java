package presentation.marketing.compoment;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class MJPanel extends JPanel{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Image image=null;

	public MJPanel(int x,int y,int w,int h){
    	this.setBounds(x, y, w, h);
    	this.setLayout(null);
    	this.setOpaque(false);
    }

	public MJPanel(int x,int y,int w,int h,Image image){
    	this.setBounds(x, y, w, h);
    	this.setLayout(null);
    	this.setOpaque(false);
    	this.image=image;

    }

	protected  void paintComponent(Graphics g) {
    	g.drawImage(image,0,0,getSize().width,getSize().height,this);
    }
}
