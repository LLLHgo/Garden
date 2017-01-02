package presentation.client.compoment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Enum.OrderType;
import Enum.ResultMessage;
import presentation.client.compoment.PersonalPanel.Label;
import presentation.client.controller.EvaluatePanelController;
import vo.orderVO.OrderVO;

/**
 * 酒店评价主界面，显示待评价酒店列表
 * @author ClaraLee
 *
 */
public class EvaluatePanel extends JPanel{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon imageIcon = null;
	private SearchButton searchButton;
	private JTextField searchField;
	private HotelListPane hlp;//酒店信息列表
	private JPanel Panel;
	private EvaluatePanelController controller;
	private String id;
	static JLabel hint;
	private ArrayList<OrderVO> orderlist;
	public EvaluatePanel(JFrame frame,EvaluatePanelController controller,String id){
		this.controller=controller;
		this.id=id;
		hint=new JLabel("");
		hint.setBounds(5,0,300,30);
		hint.setFont(new java.awt.Font("微软雅黑", 4,  15));
		hint.setForeground(Color.WHITE);
		Panel=new JPanel();
		hlp=new HotelListPane(controller.findClientTypeOrderList(OrderType.NORMALEXEC,id));
		//hlp=new HotelListPane(new ArrayList<OrderVO>());
		frame.add(hlp);
	imageIcon = new ImageIcon(this.getClass().getResource("image/searchOrder.png"));
	searchField=new JTextField();
	searchButton=new SearchButton();
	searchField.setBounds(72, 18, 450, 50);
	searchField.setBorder(new EmptyBorder(0,0,0,0));
	searchField.setFont(new java.awt.Font("微软雅黑", 4,  25));
	searchField.setForeground(Color.WHITE);
	searchField.setOpaque(false);
	searchField.setFocusable(true);


	this.add(hint);
	this.add(searchButton);
	this.add(searchField);
	this.setVisible(false);
    this.setLayout(null);
    this.setSize(704, 502);
    this.setOpaque(false);
	}

	public void setvisible(boolean flag){
		this.setVisible(flag);
		hlp.setVisible(flag);

	}
	@Override
	public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }
	//酒店列表类，显示单个酒店订单信息
	class HotelListPane extends JScrollPane{

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		public HotelListPane(ArrayList<OrderVO> list){
			super(Panel);
			Panel.setLayout(null);
			if(list!=null)
				for(int i=0;i<list.size();i++)
					if(list.get(i).iseValuate()==true){
						list.remove(i);
						i--;
					}
			if(list!=null)
		    Panel.setPreferredSize(new Dimension(600,100*list.size()));
		    orderlist=list;
			Panel.setBounds(0,0,1000,4000);
		    Panel.setOpaque(false);


		   this.setBounds(320, 170, 920, 400);
		   this.setOpaque(false);
		   this.getViewport().setOpaque(false);
		   this.getVerticalScrollBar().setVisible(false);
		   this.setBorder(new EmptyBorder(0,0,0,0));
		   this.setVisible(false);
		   if(list!=null)
		    for(int i=0;i<list.size();i++){
		    	OrderVO order=list.get(i);
		    	HotelEvaluateItemPanel p=new HotelEvaluateItemPanel(0, i*100,order,controller);
		    	p.vb.addActionListener(new ActionListener(){
		    		public void actionPerformed(ActionEvent e) {
		    			new OrderDetailFrame(order);
		    		}
		    		});
		    	p.eb.addActionListener(new ActionListener(){
		    		public void actionPerformed(ActionEvent e) {
		    			EvaluateFrame ef=new EvaluateFrame(order.getClientId(),order.getHotelId(),controller);
		    			ef.okButton.addActionListener(new ActionListener(){
		    				public void actionPerformed(ActionEvent e) {
		    					order.seteValuate(true);
		    					if(controller.saveOrderPO(order)==ResultMessage.SUCCESS){
		    						orderlist.remove(order);
		    						hlp.change(orderlist);
		    						hlp.repaint();
					    			hlp.revalidate();

		    					}

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
				 orderlist=list;
				 for(int i=0;i<list.size();i++){
				    	OrderVO order=list.get(i);
				    	HotelEvaluateItemPanel p=new HotelEvaluateItemPanel(0, i*100,order,controller);
				    	p.vb.addActionListener(new ActionListener(){
				    		public void actionPerformed(ActionEvent e) {
				    			new OrderDetailFrame(order);
				    		}
				    		});
				    	p.eb.addActionListener(new ActionListener(){
				    		public void actionPerformed(ActionEvent e) {
				    			EvaluateFrame ef=new EvaluateFrame(order.getClientId(),order.getHotelId(),controller);
				    			ef.okButton.addActionListener(new ActionListener(){
				    				public void actionPerformed(ActionEvent e) {
				    					order.seteValuate(true);
				    					if(controller.saveOrderPO(order)==ResultMessage.SUCCESS){
				    						orderlist.remove(order);
				    						hlp.change(orderlist);
				    						hlp.repaint();
							    			hlp.revalidate();

				    					}
				    				}
				    			});
				    		}
				    		});
				    	 Panel.add(p);
				    }
				    this.getVerticalScrollBar().setVisible(false);
				    this.repaint();
		}
	}
	}


}
