package presentation.marketing.compoment;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Enum.VIPType;

public class showNew extends MJPanel{
	private static final long serialVersionUID = 1L;
	private Font font=new Font("微软雅黑",Font.HANGING_BASELINE,17);
	private Image background=new ImageIcon("./src/main/resource/picture/marketing/showBackground.png").getImage();

	public showNew(String name,String start,String end,List<VIPType> viptypes,double discount,int minLevel,int minRoom,double minSum,List<String> hotels,int x, int y, int w, int h) {
		super(x, y, w, h);
        JLabel Name=new MJLabel(name,5,5,400,17,font);
        JLabel Start=new MJLabel(start,5,30,400,17,font);
        JLabel End=new MJLabel(end,5,55,400,17,font);
        JLabel VIPType=new MJLabel("会员种类:",5,80,100,17,font);
        for(int i=0;i<viptypes.size();i++){
        	JLabel type=new MJLabel(viptypes.get(i).toString(),105+150*i,80,300,17,font);
        	this.add(type);
        }

        JLabel dis=new MJLabel("折扣:"+discount,5,105,200,17,font);
        JLabel level=new MJLabel("最低等级:"+minLevel,5,130,200,17,font);
        JLabel room=new MJLabel("最少房间数: "+minRoom,5,155,200,17,font);
        JLabel sum=new MJLabel("最少消费额:"+minSum,5,180,200,17,font);
        JPanel hotelsPanel=new SelectPanel("酒店",5,140,500,100,hotels);

        this.add(Name);
        this.add(Start);
        this.add(End);
        this.add(VIPType);
        this.add(dis);
        this.add(level);
        this.add(room);
        this.add(sum);
        this.add(hotelsPanel);
        this.revalidate();
        this.repaint();
	}

	protected  void paintComponent(Graphics g) {
    	g.drawImage(background,0,0,getSize().width,getSize().height,this);
    }
}


































