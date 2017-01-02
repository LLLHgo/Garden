package presentation.marketing.compoment;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class showPeriod extends MJPanel{
	private static final long serialVersionUID = 1L;
	private Font font=new Font("微软雅黑",Font.HANGING_BASELINE,17);
	private Image background=new ImageIcon(this.getClass().getResource("showBackground.png")).getImage();

	public showPeriod(String name,String start,String end,double discount,int x, int y, int w, int h) {
		super(x, y, w, h);
        JLabel Name=new MJLabel(name,5,5,400,17,font);
        JLabel Start=new MJLabel(start,5,30,400,17,font);
        JLabel End=new MJLabel(end,5,55,400,17,font);
        JLabel Discount=new MJLabel(((String)("折扣："+discount)),5,80,400,17,font);

        this.add(Name);
        this.add(Start);
        this.add(End);
        this.add(Discount);
        this.revalidate();
        this.repaint();
	}

	protected  void paintComponent(Graphics g) {
    	g.drawImage(background,0,0,getSize().width,getSize().height,this);
    }
}
