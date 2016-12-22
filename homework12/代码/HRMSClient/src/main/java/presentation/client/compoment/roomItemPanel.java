package presentation.client.compoment;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


import vo.hotelinfoVO.RoominfoVO;

public class roomItemPanel extends JPanel{
	private ImageIcon imageIcon = null;
	private Label roomName;
	private Label roomMoney;
	private RoominfoVO vo;
public roomItemPanel(int x,int y,RoominfoVO vo){
	imageIcon = new ImageIcon("image/roomPanel.png");
	this.vo=vo;

	String price=""+vo.getPrice();
	roomName=new Label(vo.getType(),5,5,100,30,25);
	roomMoney=new Label(price,120,5,50,30,25);


	this.add(roomName);
	this.add(roomMoney);


    this.setLayout(null);
	this.setBounds(x,y,200,30);

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
