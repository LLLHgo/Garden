package presentation.client.compoment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.DialogCreator;
import vo.hotelinfoVO.HotelinfoVO;

public class HotelSearchItemPanel extends JPanel{
	private ImageIcon imageIcon = null;
	private Label hotelName;
	private Label hotelLevel;
	private Label hotelAddress;
	viewButton vb;
	private HotelinfoVO vo;
public HotelSearchItemPanel(int x,int y,HotelinfoVO vo){
	imageIcon = new ImageIcon("image/hotelSearchPanel.png");
	this.vo=vo;
	vb=new viewButton(500, 30);
	hotelName=new Label(vo.getName(),15,7,200,30,25);
	hotelLevel=new Label(vo.getStar().toString(),380,12,100,30,25);
	hotelAddress=new Label(vo.getAddress(),75,43,450,30,20);

	this.add(hotelName);
	this.add(hotelLevel);
	this.add(hotelAddress);

    this.setLayout(null);
	this.setBounds(x,y,600,100);
	this.add(vb);
	this.setOpaque(false);
	this.setVisible(true);
}

class Label extends JLabel{
	public Label(String str,int x,int y,int w,int h,int big){
		super(str);
		java.awt.Font f=new java.awt.Font("微软雅黑", 4,  25);
		this.setFont(f);
		this.setForeground(Color.WHITE);
		this.setBounds(x,y,w,h);
	}
}
@Override
public void paintComponent(Graphics g) {
	    g.drawImage(imageIcon.getImage(), 0, 0, this);
	    super.paintComponents(g);
	   }
}


