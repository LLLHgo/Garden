package presentation.client.compoment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.client.controller.EvaluatePanelController;
import vo.orderVO.OrderVO;

/**
 * 酒店评价小panel类，负责显示酒店评价的列表项
 * @author ClaraLee
 *
 */

public class HotelEvaluateItemPanel extends JPanel{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon imageIcon = null;
	evaluateButton eb;
	viewButton vb;
	private Label hotelName;
	private Label orderNum;
	private Label money;
	private OrderVO vo;

	private EvaluatePanelController controller;
public HotelEvaluateItemPanel(int x,int y,OrderVO vo,EvaluatePanelController controller){

	this.controller=controller;
	this.vo=vo;
	imageIcon = new ImageIcon(this.getClass().getResource("image/hotelEvaluatePanel.png"));
	eb=new evaluateButton(510, 7);
	//eb.addActionListener(new evaluateButtonListener());
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
		new EvaluateFrame(vo.getClientId(),vo.getHotelId(),controller);
	}

}
class Label extends JLabel{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

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

