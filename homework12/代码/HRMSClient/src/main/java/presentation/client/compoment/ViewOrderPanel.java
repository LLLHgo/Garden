package presentation.client.compoment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Enum.OrderType;
import datatool.OrderDataTool;
import presentation.client.controller.ViewOrderPanelController;
import vo.orderVO.OrderVO;

public class ViewOrderPanel extends JPanel{
	private ImageIcon imageIcon = null;
	private SearchButton searchButton;
	private JTextField searchField;
	private Button unfin;
	private Button fin;
	private Button abnormal;
	private Button repeal;
	private OrderListPane olp;
	private JPanel Panel;
	private String clientID;
	private JFrame frame;
	private ViewOrderPanelController controller;
public ViewOrderPanel(JFrame frame,String clientID,ViewOrderPanelController controller){
	this.controller=controller;
	this.clientID=clientID;
	this.frame=frame;
	Panel=new JPanel();
	olp=new OrderListPane(controller.findUserOrderList(clientID));
	frame.add(olp);
	imageIcon = new ImageIcon("image/searchPanel.png");
	ImageIcon icon=new ImageIcon("image/unfinButton.png");
	searchButton=new SearchButton();
	searchButton.addActionListener(new searchButtonListener());
	searchField=new JTextField();
	searchField.setBounds(72, 18, 450, 50);
	searchField.setBorder(new EmptyBorder(0,0,0,0));
	searchField.setFont(new java.awt.Font("微软雅黑", 4,  25));
	searchField.setForeground(Color.WHITE);
	searchField.setOpaque(false);
	searchField.setFocusable(true);
		unfin=new Button(icon,10,100);
		icon=new ImageIcon("image/finButton.png");
		unfin.addActionListener(new unfinButtonListener());
		fin=new Button(icon,10,190);
		fin.addActionListener(new finButtonListener());
		icon=new ImageIcon("image/abnormalButton.png");
		abnormal=new Button(icon,10,280);
		abnormal.addActionListener(new abnormalButtonListener());
		icon=new ImageIcon("image/repealButton.png");
		repeal=new Button(icon,10,370);
		repeal.addActionListener(new repealButtonListener());
		this.setLayout(null);
	    this.setSize(704, 502);
	    this.setOpaque(false);
	    this.add(searchField);
	    this.add(searchButton);
	    this.add(unfin);
	    this.add(fin);
	    this.add(abnormal);
	    this.add(repeal);
	    this.setVisible(false);
}
@Override
public void paintComponent(Graphics g) {
	    g.drawImage(imageIcon.getImage(), 0, 0, this);
	    super.paintComponents(g);

	   }

public void setvisible(boolean flag){
	this.setVisible(flag);
	olp.setVisible(flag);

}

class Button extends JButton{

	ImageIcon icon;
	public Button(ImageIcon icon,int x,int y){

	this.setIcon(icon);
	this.setOpaque(true);
	this.setContentAreaFilled(false);
	this.setBorderPainted(false);
	this.setFocusPainted(false);
	this.setBounds(x,y,80,80);
	}
}
private class searchButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub


		olp.change(controller.findSpecificDayClientOrderList(searchField.getText(),clientID));
		olp.repaint();
		olp.revalidate();
		frame.repaint();
		frame.revalidate();

	}

}
private class unfinButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		//ArrayList<OrderVO> order=new ArrayList<OrderVO>();
		//order.add(OrderDataTool.orderVO2);
		olp.change(controller.findClientTypeOrderList(OrderType.NORMALNONEXEC,clientID));
		olp.repaint();
		olp.revalidate();
		frame.repaint();
		frame.revalidate();

	}

}
private class finButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		olp.change(controller.findClientTypeOrderList(OrderType.NORMALEXEC,clientID));
		olp.repaint();
		olp.revalidate();
		frame.repaint();
		frame.revalidate();
	}

}
private class abnormalButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		olp.change(controller.findClientTypeOrderList(OrderType.ABNORMAL,clientID));
		olp.repaint();
		olp.revalidate();
		frame.repaint();
		frame.revalidate();
	}

}
private class repealButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		olp.change(controller.findClientTypeOrderList(OrderType.CANCEL,clientID));
		olp.repaint();
		olp.revalidate();
		frame.repaint();
		frame.revalidate();
	}

}
private class OrderListPane extends JScrollPane{

	private JScrollPane scrollpanel;
	public OrderListPane(ArrayList<OrderVO> list){
		super(Panel);

		Panel.setLayout(null);
	    Panel.setPreferredSize(new Dimension(600,list.size()*100));
	    Panel.setBounds(0,0,1000,4000);
	    Panel.setOpaque(false);


	   this.setBounds(370, 170, 920, 400);
	   this.setOpaque(false);
	   this.getViewport().setOpaque(false);
	   this.getVerticalScrollBar().setVisible(false);
	   this.setBorder(new EmptyBorder(0,0,0,0));
	   this.setVisible(false);

	   if(list!=null)
	   for(int i=0;i<list.size();i++){
	    	OrderVO order=list.get(i);
	    	System.out.println(order.getPrice());
	    	OrderItemPanel p=new OrderItemPanel(0, i*100,order);
	    	 //p.setBounds(0,i*100,600,100);
	    	p.vb.addActionListener(new ActionListener(){
	    		public void actionPerformed(ActionEvent e) {
	    			new OrderDetailFrame(order);
	    		}
	    		});
	    	if(order.getOrderStatus().equals(OrderType.NORMALNONEXEC))
	    	p.db.addActionListener(new ActionListener(){
	    		public void actionPerformed(ActionEvent e) {
	    			controller.cancelOrderPO(order.getOrderId());
	    			olp.change(controller.findClientTypeOrderList(OrderType.CANCEL,clientID));
	    			olp.repaint();
	    			olp.revalidate();
	    			frame.repaint();
	    			frame.revalidate();
	    		}
	    		});
	    	 Panel.add(p);
	    }
	    this.getVerticalScrollBar().setVisible(false);
	    scrollpanel=this;
	}

	public void change(ArrayList<OrderVO> list){
		Panel.removeAll();
		if(list!=null)
			   for(int i=0;i<list.size();i++){
			    	OrderVO order=list.get(i);
			    	System.out.println(order.getPrice());
			    	OrderItemPanel p=new OrderItemPanel(0, i*100,order);
			    	 //p.setBounds(0,i*100,600,100);
			    	p.vb.addActionListener(new ActionListener(){
			    		public void actionPerformed(ActionEvent e) {
			    			new OrderDetailFrame(order);
			    		}
			    		});
			    	if(order.getOrderStatus().equals(OrderType.NORMALNONEXEC))
				    	p.db.addActionListener(new ActionListener(){
				    		public void actionPerformed(ActionEvent e) {
				    			controller.cancelOrderPO(order.getOrderId());
				    			olp.change(controller.findClientTypeOrderList(OrderType.CANCEL,clientID));
				    			olp.repaint();
				    			olp.revalidate();
				    			frame.repaint();
				    			frame.revalidate();
				    		}
				    		});
			    	 Panel.add(p);
			    }
			    this.getVerticalScrollBar().setVisible(false);
			    scrollpanel=this;
			    this.repaint();
	}
}
}
