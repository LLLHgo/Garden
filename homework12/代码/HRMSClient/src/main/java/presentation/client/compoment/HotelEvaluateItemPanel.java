package presentation.client.compoment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vo.orderVO.OrderVO;



public class HotelEvaluateItemPanel extends JPanel{
	private ImageIcon imageIcon = null;
	private evaluateButton eb;
	viewButton vb;
	private Label hotelName;
	private Label orderNum;
	private Label money;
	private OrderVO vo;
	
public HotelEvaluateItemPanel(int x,int y,OrderVO vo){
	
	this.vo=vo;
	imageIcon = new ImageIcon("image/hotelEvaluatePanel.png");
	eb=new evaluateButton(510, 7);
	eb.addActionListener(new evaluateButtonListener());
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
	this.add(eb);
	this.setOpaque(false);
	this.setVisible(true);
}
private class evaluateButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new EvaluateFrame();
	}

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

