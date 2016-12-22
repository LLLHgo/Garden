package presentation.client.compoment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Enum.OrderType;
import datatool.OrderDataTool;
import presentation.client.controller.EvaluatePanelController;
import vo.hotelinfoVO.HotelinfoVO;
import vo.orderVO.OrderVO;


public class EvaluatePanel extends JPanel{
	private ImageIcon imageIcon = null;
	private SearchButton searchButton;
	private JTextField searchField;
	private HotelListPane hlp;
	private JPanel Panel;
	private EvaluatePanelController controller;
	private String id;
	public EvaluatePanel(JFrame frame,EvaluatePanelController controller,String id){
		this.controller=controller;
		this.id=id;
		Panel=new JPanel();
		hlp=new HotelListPane(controller.findClientTypeOrderList(OrderType.NORMALEXEC,id));
		hlp=new HotelListPane(new ArrayList<OrderVO>());
		frame.add(hlp);
	imageIcon = new ImageIcon("image/searchPanel.png");
	searchField=new JTextField();
	searchButton=new SearchButton();
	searchField.setBounds(72, 18, 450, 50);
	searchField.setBorder(new EmptyBorder(0,0,0,0));
	searchField.setFont(new java.awt.Font("微软雅黑", 4,  25));
	searchField.setForeground(Color.WHITE);
	searchField.setOpaque(false);
	searchField.setFocusable(true);



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
	class HotelListPane extends JScrollPane{

		private JScrollPane scrollpanel;
		public HotelListPane(ArrayList<OrderVO> list){
			super(Panel);
			Panel.setLayout(null);
		    Panel.setPreferredSize(new Dimension(600,100*list.size()));
		    Panel.setBounds(0,0,1000,4000);
		    Panel.setOpaque(false);


		   this.setBounds(320, 170, 920, 400);
		   this.setOpaque(false);
		   this.getViewport().setOpaque(false);
		   this.getVerticalScrollBar().setVisible(false);
		   this.setBorder(new EmptyBorder(0,0,0,0));
		   this.setVisible(false);
		    for(int i=0;i<list.size();i++){
		    	OrderVO order=list.get(i);
		    	HotelEvaluateItemPanel p=new HotelEvaluateItemPanel(0, i*100,order);
		    	p.vb.addActionListener(new ActionListener(){
		    		public void actionPerformed(ActionEvent e) {
		    			new OrderDetailFrame(order);
		    		}
		    		});
		    	 Panel.add(p);
		    }
		    this.getVerticalScrollBar().setVisible(false);
		    scrollpanel=this;
		}
	}
}
