package presentation.client.compoment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentation.client.compoment.PersonalPanel.Label;
import presentation.client.controller.SearchPanelController;
import presentation.common.remarkFrame;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.orderVO.OrderVO;
/**
 * 查询酒店界面类，实现查询酒店的功能
 * @author ClaraLee
 *
 */
public class SearchPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private ImageIcon imageIcon = null;
	private JTextField searchField;
	private SearchButton searchButton;
	private Button historyButton;
	private Button sortButton;
	private JComboBox<String> areabox;
	private JComboBox<String> roombox;
	private JComboBox<String> starbox;
	private JComboBox<String> sortbox;
	private HotelSearchListPane hslp;
	private JPanel Panel;
	private JFrame frame;
	private Label hint;
	ClientVO client;
	private SearchPanelController controller;
	private ArrayList<HotelinfoVO> hotellist;
	public SearchPanel(ClientVO client,JFrame frame,SearchPanelController controller){
		this.client=client;
		Panel=new JPanel();
		this.frame=frame;
		this.controller=controller;
		hotellist=new ArrayList<HotelinfoVO>();
		hslp=new HotelSearchListPane(frame,hotellist);
		frame.add(hslp);

		hint=new Label("");
		hint.setBounds(5,5,400,20);
		this.add(hint);

		historyButton=new Button("image/history.png",10,25);
		historyButton.addActionListener(new historyButtonListener());
		this.add(historyButton);
		sortButton=new Button("image/sort.png",60,25);
		sortButton.addActionListener(new sortButtonListener());
		this.add(sortButton);

		sortbox=new JComboBox<String>();
		sortbox.setOpaque(false);
		sortbox.addItem("按星级");
		sortbox.addItem("按评分");
		sortbox.addItem("按价格");
		sortbox.setBounds(0,35,110,20);
		sortbox.setVisible(false);
		sortbox.addItemListener(new ItemListener() {
			@Override
		      public void itemStateChanged(final ItemEvent e) {
		        int index = sortbox.getSelectedIndex();
		        if(index==0){
		        	hotellist=controller.rankHotelAccordingtoHotelStar(hotellist);
		        	hslp.change(hotellist);
		  			hslp.setVisible(true);
		  			hslp.repaint();
		  			hslp.revalidate();
		  			frame.repaint();
		  			frame.revalidate();
		        }
		        else if(index==1){
		        	hotellist=controller.rankHotelAccordingtoRemarkStar(hotellist);
		        	hslp.change(hotellist);
		  			hslp.setVisible(true);
		  			hslp.repaint();
		  			hslp.revalidate();
		  			frame.repaint();
		  			frame.revalidate();
		          }
		          else if(index==2){
		        	  hotellist=controller.rankHotelAccordingtoMinPrice(hotellist);
			        	hslp.change(hotellist);
			  			hslp.setVisible(true);
			  			hslp.repaint();
			  			hslp.revalidate();
			  			frame.repaint();
			  			frame.revalidate();
		          }
		          sortbox.setVisible(false);
		          sortButton.setVisible(true);
		          historyButton.setVisible(true);

		      }

		    });
		this.add(sortbox);

		areabox=new JComboBox<String>();
		areabox.addItem("全部商圈");
		String[] area=controller.getArea();
		for(int i=0;i<area.length;i++)
		areabox.addItem(area[i]);
		areabox.setBounds(100,15,110,20);
		this.add(areabox);

		roombox=new JComboBox<String>();
		roombox.addItem("全部房间");
		roombox.addItem("标准间");
		roombox.addItem("大床房");
		roombox.addItem("商务间");
		roombox.setBounds(100,35,110,20);
		this.add(roombox);
		starbox=new JComboBox<String>();
		starbox.addItem("全部星级");
		starbox.addItem("一星级");
		starbox.addItem("二星级");
		starbox.addItem("三星级");
		starbox.addItem("四星级");
		starbox.addItem("五星级");
		starbox.addItem("六星级");
		starbox.addItem("七星级");
		starbox.setBounds(100,55,110,20);
		this.add(starbox);

		imageIcon = new ImageIcon(this.getClass().getResource("image/searchPanel.png"));
		searchField=new JTextField();
		searchButton=new SearchButton();
		searchButton.setBounds(625,15,60,60);
		searchButton.addActionListener(new searchButtonListener());
		searchField.setBounds(252, 18, 350, 50);
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
	class Label extends JLabel{
		private static final long serialVersionUID = 1L;
		public Label(String str){
			super(str);
			java.awt.Font f=new java.awt.Font("微软雅黑", 4,  20);
			this.setFont(f);
			this.setForeground(Color.WHITE);

		}
	}
	public void setHint(String str){
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
	public void setvisible(boolean flag){
		this.setVisible(flag);
		if(!flag)
		hslp.setVisible(flag);

	}

	private class sortButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			sortbox.setVisible(true);
			sortButton.setVisible(false);
	        historyButton.setVisible(false);
	        new Thread(new Runnable(){
				@Override
				public void run() {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					sortbox.setVisible(false);
					sortButton.setVisible(true);
			        historyButton.setVisible(true);
				}

			}).start();
		}

	}
	private class searchButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name=searchField.getText();
			if(name.equals(""))
				name=null;
			String area=(String)areabox.getSelectedItem();
			if(!area.equals("全部商圈")){
			String type=(String)roombox.getSelectedItem();
			if(type.equals("全部房间"))
				type=null;
			int star=starbox.getSelectedIndex();
			hotellist=controller.getBasicinfoList(area,name,star,type);
			hslp.change(hotellist);
			hslp.setVisible(true);
			hslp.repaint();
			hslp.revalidate();
			frame.repaint();
			frame.revalidate();
			}else setHint("请选择商圈");
		}

	}
	private class historyButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		if(hotellist!=null){
			for(int i=0;i<hotellist.size();i++){
				HotelinfoVO vo=hotellist.get(i);
				if(controller.findSpecificHotelClientOrderList(client.getID(),vo.getHotelID()).size()==0){
					hotellist.remove(i);
					i--;
				}
			}
			hslp.change(hotellist);
			hslp.setVisible(true);
			hslp.repaint();
			hslp.revalidate();
			frame.repaint();
			frame.revalidate();
		}
		}

	}
	private class HotelSearchListPane extends JScrollPane{
		private static final long serialVersionUID = 1L;

		public HotelSearchListPane(JFrame frame,ArrayList<HotelinfoVO> list){
			super(Panel);
			if(list!=null){
			Panel.setLayout(null);
		    Panel.setPreferredSize(new Dimension(600,list.size()));
		    Panel.setBounds(0,0,1000,4000);
		    Panel.setOpaque(false);


		   this.setBounds(320, 170, 920, 400);
		   this.setOpaque(false);
		   this.getViewport().setOpaque(false);
		   this.getVerticalScrollBar().setVisible(false);
		   this.setBorder(new EmptyBorder(0,0,0,0));
		   this.setVisible(false);
		    for(int i=0;i<list.size();i++){
		    	HotelinfoVO vo=list.get(i);
		    	HotelSearchItemPanel p=new HotelSearchItemPanel(0, i*100,vo);
		    	 //p.setBounds(0,i*100,600,100);
		    	p.vb.addActionListener(new ActionListener(){
		    		public void actionPerformed(ActionEvent e) {
		    			new HotelDetailFrame(client,controller,vo);
		    		}
		    		});
		    	p.ob.addActionListener(new ActionListener(){
		    		public void actionPerformed(ActionEvent e) {
		    			new OrderCreateFrame(client,controller,vo);
		    		}
		    		});
		    	ArrayList<OrderVO> orders=controller.findSpecificHotelClientOrderList(client.getID(),vo.getHotelID());
		    	 if(orders!=null){
		    		 if(orders.size()!=0){
			    		 System.out.println(orders.size());
			    		 p.hotelorder.setVisible(true);
			    		 p.hotelorder.addActionListener(new ActionListener(){
					    		public void actionPerformed(ActionEvent e) {
					    ArrayList<String>orderlist=new ArrayList<String>();
			    		 for(int j=0;j<orders.size();j++){
			    			 OrderVO ordervo=orders.get(j);
			    			 orderlist.add("订单号："+ordervo.getOrderId()+"\n"+ordervo.getOrderDate()+" "+ordervo.getOrderType());
			    		 }
			    		 new remarkFrame(orderlist);
					    		}
					    		});
			    	 }
		    	 }
		    	Panel.add(p);
		    }
		    this.getVerticalScrollBar().setVisible(false);

		}
		}
	public void change(ArrayList<HotelinfoVO> list){
		Panel.removeAll();
		if(list!=null){
			Panel.setPreferredSize(new Dimension(600,list.size()*100));
			 for(int i=0;i<list.size();i++){

			    	HotelinfoVO vo=list.get(i);
			    	HotelSearchItemPanel p=new HotelSearchItemPanel(0, i*100,vo);
			    	p.vb.addActionListener(new ActionListener(){
			    		public void actionPerformed(ActionEvent e) {
			    			new HotelDetailFrame(client,controller,vo);
			    		}
			    		});
			    	p.ob.addActionListener(new ActionListener(){
			    		public void actionPerformed(ActionEvent e) {
			    			new OrderCreateFrame(client,controller,vo);
			    		}
			    		});
			    	ArrayList<OrderVO> orders=controller.findSpecificHotelClientOrderList(client.getID(),vo.getHotelID());
			    	 ArrayList<String>orderlist=new ArrayList<String>();
			    		 for(int j=0;j<orders.size();j++){
			    			 OrderVO ordervo=orders.get(j);
			    			 orderlist.add(ordervo.getOrderDate().substring(0,11)+" "+ordervo.getOrderType());
			    		 }
			    		if(orders.size()!=0){
			    		 p.hotelorder.setVisible(true);
			    		 p.hotelorder.addActionListener(new ActionListener(){
					    		public void actionPerformed(ActionEvent e) {
			    		 new remarkFrame(orderlist);
					    		}
					    		});

			    	}
			    	 Panel.add(p);
			    }}
			    this.getVerticalScrollBar().setVisible(false);
			    this.repaint();
	}
	}
	class Button extends JButton{
		private static final long serialVersionUID = 1L;
		ImageIcon icon;
		public Button(String add,int x,int y){
		icon=new ImageIcon(this.getClass().getResource(add));
		this.setIcon(icon);
		this.setOpaque(true);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setBounds(x,y,40,40);
		}
	}
	@Override
	public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }

}
