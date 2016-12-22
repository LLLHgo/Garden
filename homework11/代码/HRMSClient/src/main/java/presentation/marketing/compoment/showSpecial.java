package presentation.marketing.compoment;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class showSpecial extends MJPanel{
	private static final long serialVersionUID = 1L;
	private Font font=new Font("微软雅黑",Font.HANGING_BASELINE,17);
	private Image background=new ImageIcon("./src/main/resource/picture/marketing/showBackground.png").getImage();

	public showSpecial(String name,String start,String end,String district,int[] levels,double[] discounts,int x, int y, int w, int h) {
		super(x, y, w, h);
        JLabel Name=new MJLabel(name,5,5,400,17,font);
        JLabel Start=new MJLabel(start,5,30,400,17,font);
        JLabel End=new MJLabel(end,5,55,400,17,font);
        JLabel District=new MJLabel("商圈："+district,5,80,400,17,font);
        JLabel Level=new MJLabel("等级:",5,105,80,17,font);
        JLabel Discount=new MJLabel("折扣:",5,130,80,17,font);


        //加入相对等级和折扣
        for(int i=0;i<levels.length;i++){
        	JLabel level=new MJLabel(""+levels[i],50+40*i,105,80,17,font);
        	JLabel discount=new MJLabel(""+discounts[i],50+40*i,130,80,17,font);
        	this.add(discount);
        	this.add(level);
        }

        this.add(Name);
        this.add(Start);
        this.add(End);
        this.add(District);
        this.add(Level);
        this.add(Discount);
        this.revalidate();
        this.repaint();
	}

	protected  void paintComponent(Graphics g) {
    	g.drawImage(background,0,0,getSize().width,getSize().height,this);
    }
}

