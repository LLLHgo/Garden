package presentation.client.compoment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Enum.OrderType;
import Enum.ResultMessage;
import presentation.client.controller.ViewOrderPanelController;
import vo.orderVO.OrderVO;

public class ViewOrderPanel extends JPanel{
	/**
	 *浏览订单界面
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon imageIcon = null;
	private SearchButton searchButton;
	private JTextField searchField;
	private Button unfin;
	private Button fin;
	private Button abnormal;
	private Button repeal;
	private Button confirmdelete;
	private Button nodelete;
	private OrderListPane olp;
	private JPanel Panel;
	private String clientID;
	JLabel hint;
	private JFrame frame;
	private ViewOrderPanelController controller;
public ViewOrderPanel(JFrame frame,String clientID,ViewOrderPanelController controller){
	this.controller=controller;
	this.clientID=clientID;
	this.frame=frame;
	Panel=new JPanel();
	olp=new OrderListPane(controller.findUserOrderList(clientID));
	frame.add(olp);
	imageIcon = new ImageIcon(this.getClass().getResource("image/searchOrder.png"));
	ImageIcon icon=new ImageIcon(this.getClass().getResource("image/unfinButton.png"));
	searchButton=new SearchButton();
	searchButton.addActionListener(new searchButtonListener());
	searchField=new JTextField();
	searchField.setBounds(72, 18, 450, 50);
	searchField.setBorder(new EmptyBorder(0,0,0,0));
	searchField.setFont(new java.awt.Font("微软雅黑", 4,  25));
	searchField.setForeground(Color.WHITE);
	searchField.setOpaque(false);
	searchField.setFocusable(true);

	hint=new JLabel("");
	hint.setBounds(250,10,300,30);
	hint.setFont(new java.awt.Font("微软雅黑", 4,  20));
	hint.setForeground(Color.WHITE);
	this.add(hint);

		unfin=new Button(icon,10,100,80,80);
		icon=new ImageIcon(this.getClass().getResource("image/finButton.png"));
		unfin.addActionListener(new unfinButtonListener());
		fin=new Button(icon,10,190,80,80);
		fin.addActionListener(new finButtonListener());
		icon=new ImageIcon(this.getClass().getResource("image/abnormalButton.png"));
		abnormal=new Button(icon,10,280,80,80);
		abnormal.addActionListener(new abnormalButtonListener());
		icon=new ImageIcon(this.getClass().getResource("image/repealButton.png"));
		repeal=new Button(icon,10,370,80,80);
		repeal.addActionListener(new repealButtonListener());
		icon=new ImageIcon(this.getClass().getResource("image/confirmdelete.png"));
		confirmdelete=new Button(icon,610,15,75,26);
		confirmdelete.setVisible(false);
		icon=new ImageIcon(this.getClass().getResource("image/nodelete.png"));
		nodelete=new Button(icon,610,45,75,26);
		nodelete.setVisible(false);

		this.setLayout(null);
	    this.setSize(704, 502);
	    this.setOpaque(false);
	    this.add(searchField);
	    this.add(searchButton);
	    this.add(unfin);
	    this.add(fin);
	    this.add(abnormal);
	    this.add(repeal);
	    this.add(confirmdelete);
	    this.add(nodelete);
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

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon icon;
	public Button(ImageIcon icon,int x,int y,int w,int h){

	this.setIcon(icon);
	this.setOpaque(true);
	this.setContentAreaFilled(false);
	this.setBorderPainted(false);
	this.setFocusPainted(false);
	this.setBounds(x,y,w,h);
	}
}
private class searchButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub


		olp.change(controller.findSpecificDayClientOrderList(clientID,searchField.getText()));
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

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public OrderListPane(ArrayList<OrderVO> list){
		super(Panel);

		Panel.setLayout(null);
		if(list!=null)
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

	    	OrderItemPanel p=new OrderItemPanel(0, i*100,order);
	    	 //p.setBounds(0,i*100,600,100);
	    	p.vb.addActionListener(new ActionListener(){
	    		public void actionPerformed(ActionEvent e) {
	    			new OrderDetailFrame(order);
	    		}
	    		});
	    	if(order.getOrderStatus().equals(OrderType.NORMALNONEXEC))
	    	//撤销订单监听
	    		p.db.addActionListener(new ActionListener(){
	    		public void actionPerformed(ActionEvent e) {
	    			confirmdelete.setVisible(true);
	    			nodelete.setVisible(true);
	    			confirmdelete.addActionListener(new ActionListener(){
	    	    		public void actionPerformed(ActionEvent e) {
	    	    			Date date=new Date();
	    					  DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    					  String time=format.format(date);
	    					if(time.substring(0,10).equals(order.getAnticipateArrivedTime().substring(0,10))&&Integer.parseInt(time.substring(11,13))>=6){
	    						int creditminus=(int)order.getPrice()/2;
	    	    			if(controller.cancelOrderPO(order.getOrderId())==ResultMessage.SUCCESS&&controller.setCredit(clientID, (-1)*creditminus,time.substring(0,10),"Cancel Late"))
	    	    				setHint("撤销成功,扣除信用值"+creditminus);

	    					}else{
	    						if(controller.cancelOrderPO(order.getOrderId())==ResultMessage.SUCCESS)
		    	    				setHint("撤销成功");
	    					}
	    	    			confirmdelete.setVisible(false);
	    	    			nodelete.setVisible(false);
	    	    			olp.change(controller.findClientTypeOrderList(OrderType.NORMALNONEXEC,clientID));
	    			olp.repaint();
	    			olp.revalidate();
	    			frame.repaint();
	    			frame.revalidate();
	    	    		}
	    	    		});
	    			nodelete.addActionListener(new ActionListener(){
	    	    		public void actionPerformed(ActionEvent e) {
	    	    			confirmdelete.setVisible(false);
	    	    			nodelete.setVisible(false);
	    	    		}
	    	    		});

	    		}
	    		});
	    	 Panel.add(p);
	    }
	    this.getVerticalScrollBar().setVisible(false);

	}

	public void change(ArrayList<OrderVO> list){
		Panel.removeAll();
		if(list!=null){
			 Panel.setPreferredSize(new Dimension(600,list.size()*100));
			   for(int i=0;i<list.size();i++){
			    	OrderVO order=list.get(i);

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
				    			confirmdelete.setVisible(true);
				    			nodelete.setVisible(true);
				    			confirmdelete.addActionListener(new ActionListener(){
				    	    		public void actionPerformed(ActionEvent e) {
				    	    			Date date=new Date();
				    					  DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				    					  String time=format.format(date);
				    	    			if(time.substring(0,10).equals(order.getAnticipateArrivedTime().substring(0,10))&&Integer.parseInt(time.substring(11,13))>=6){
				    						int creditminus=(int)order.getPrice()/2;
				    	    			if(controller.cancelOrderPO(order.getOrderId())==ResultMessage.SUCCESS&&controller.setCredit(clientID, (-1)*creditminus,time.substring(0,10),"Cancel Late"))
				    	    				setHint("撤销成功,扣除信用值"+creditminus);

				    					}else{
				    						if(controller.cancelOrderPO(order.getOrderId())==ResultMessage.SUCCESS)
					    	    				setHint("撤销成功");
				    					}
				    	    			confirmdelete.setVisible(false);
				    	    			nodelete.setVisible(false);
				    	    			olp.change(controller.findClientTypeOrderList(OrderType.NORMALNONEXEC,clientID));

				    	    	olp.repaint();
				    			olp.revalidate();
				    			frame.repaint();
				    			frame.revalidate();
				    	    		}
				    	    		});
				    			nodelete.addActionListener(new ActionListener(){
				    	    		public void actionPerformed(ActionEvent e) {
				    	    			confirmdelete.setVisible(false);
				    	    			nodelete.setVisible(false);
				    	    		}
				    	    		});

				    		}
				    		});
			    	 Panel.add(p);
			    }
		}
			    this.getVerticalScrollBar().setVisible(false);

			    this.repaint();
	}
	void setHint(String str){
        hint.setText(str);
    	new Thread(new Runnable(){
			@Override
			public void run() {
				hint.setText(str);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				hint.setText("");
			}

		}).start();

    }
}
}
