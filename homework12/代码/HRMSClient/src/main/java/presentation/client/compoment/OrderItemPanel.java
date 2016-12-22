package presentation.client.compoment;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Enum.OrderType;
import Enum.VIPType;
import presentation.client.compoment.HotelEvaluateItemPanel.Label;
import vo.orderVO.OrderVO;

public class OrderItemPanel extends JPanel{
	private ImageIcon imageIcon = null;
	minideleteButton db;
	 viewButton vb;
	 private Label hotelName;
		private Label orderNum;
		private Label money;
		private OrderVO vo;
public OrderItemPanel(int x,int y,OrderVO vo){
	this.vo=vo;
	imageIcon = new ImageIcon("image/hotelEvaluatePanel.png");
	if(vo.getOrderStatus().equals(OrderType.NORMALNONEXEC)){
	db=new minideleteButton(500, 7);
	this.add(db);
	}
	vb=new viewButton(450, 30);
	hotelName=new Label(vo.getHotelName(),10,5,200,30,25);
	orderNum=new Label(vo.getOrderId(),90,45,240,30,20);
	money=new Label(""+vo.getPrice(),350,35,80,50,20);
	this.add(hotelName);
	this.add(orderNum);
	this.add(money);

    this.setLayout(null);
	this.setBounds(x,y,600,100);
	this.add(vb);

	this.setOpaque(false);
	this.setVisible(true);
}
class Label extends JLabel{
	public Label(String str,int x,int y,int w,int h,int big){
		super(str);
		java.awt.Font f=new java.awt.Font("微软雅黑", 4, big);
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
