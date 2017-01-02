package presentation.client.compoment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import datatool.RoominfoDataTool;
import presentation.client.controller.SearchPanelController;
import presentation.common.CreditFrame;
import presentation.common.remarkFrame;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;

/**
 * 酒店详细信息frame类，显示酒店详情信息
 * @author ClaraLee
 *
 */
public class HotelDetailFrame extends JFrame{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	HotelDetailPanel hdp;
	private HotelinfoVO vo;
	private JPanel Panel;
	private SearchPanelController controller;
	ClientVO client;
	JLabel hint;
	JFrame frame;
	public HotelDetailFrame(ClientVO client,SearchPanelController controller,HotelinfoVO vo){

		this.controller=controller;
		this.client=client;
		Panel=new JPanel();
		this.vo=vo;
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JTextArea text=new JTextArea();
		text.setBounds(100,245,200,100);
		text.setOpaque(false);
	    text.setForeground(Color.WHITE);
	    text.setFont(new java.awt.Font("微软雅黑", 4,  20));
	    text.setLineWrap(true);
	    text.setCaretColor(Color.WHITE);
	    //此处根据hotelinfovo来增加 text
	    ArrayList<RoominfoVO> roomslist=vo.getRoominfoList();
	    for(int i=0;i<roomslist.size();i++){
	    	text.append(roomslist.get(i).getType()+"     ￥"+roomslist.get(i).getPrice()+"\n");}
        this.add(text);


		hdp=new HotelDetailPanel();
		frame=this;
		hint=new JLabel("");
		hint.setBounds(350,10,300,30);
		hint.setFont(new java.awt.Font("微软雅黑", 4,  30));
		hint.setForeground(Color.WHITE);
		this.add(hint);
		this.add(hdp);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(591, 433);
		this.setLocation(500,200);
	}
	class HotelDetailPanel extends JPanel{
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;
		private ImageIcon imageIcon = null;
		private Label hotelNameLabel;
		private Label hotelLevelLabel;
		private Label hotelRemarkLabel;
		private Label hotelAddressLabel;
		private Label hotelFacilityLabel;
		private Label hotelTelLabel;
		private orderButton order;
		private ArrayList<String> remarklist;
		private detailButton db;
		public HotelDetailPanel(){
		imageIcon = new ImageIcon(this.getClass().getResource("image/HotelDetailPanel.png"));

		remarklist=new ArrayList<String>();
       ArrayList<String>list=vo.getRemark();
       for(int i=0;i<list.size();i++){
    	   String str="评分：";
    	   String str0[]=list.get(i).split(" ");
    	   str+=str0[0];
    	   str+=" 评论：";
    	   str+=str0[1];
    	   remarklist.add(str);
       }

       	db=new detailButton();
       	db.addActionListener(new detailButtonListener());
       	this.add(db);
		order=new orderButton(470,280);
		order.addActionListener(new orderButtonListener());
		hotelNameLabel=new Label(vo.getName(),90,13,300,30);
		hotelLevelLabel=new Label(vo.getStar().toString(),90,65,150,30);
		hotelRemarkLabel=new Label(""+vo.getRemarkstar(),350,70,100,30);
		hotelAddressLabel=new Label(vo.getAddress(),90,130,400,30);
		hotelFacilityLabel=new Label(vo.getFacility(),140,182,300,30);
		hotelTelLabel=new Label(vo.getTel(),140,356,300,30);
		this.add(hotelNameLabel);
		this.add(hotelLevelLabel);
		this.add(hotelRemarkLabel);
		this.add(hotelAddressLabel);
		this.add(hotelFacilityLabel);
		this.add(hotelTelLabel);
		this.add(order);



		this.setVisible(true);
	    this.setLayout(null);
	    this.setBounds(0,0,591,413);
	    this.setOpaque(false);
	    this.setVisible(true);
	    this.repaint();

		}
		class detailButton extends JButton{
			 private static final long serialVersionUID = 1L;
			ImageIcon icon;
			public detailButton(){
			icon=new ImageIcon(this.getClass().getResource("image/creditButton.png"));
			this.setIcon(icon);
			this.setOpaque(true);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			this.setFocusPainted(false);
			this.setBounds(400,55,60,60);
			}
		}
		private class detailButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				new remarkFrame(remarklist);
			}

		}
		class Label extends JLabel{
			/**
			 *
			 */
			private static final long serialVersionUID = 1L;

			public Label(String str,int x,int y,int w,int h){
				super(str);
				java.awt.Font f=new java.awt.Font("微软雅黑", 4,  25);
				this.setFont(f);
				this.setForeground(Color.WHITE);
				this.setBounds(x,y,w,h);
			}
		}
		class orderButton extends JButton{
			/**
			 *
			 */
			private static final long serialVersionUID = 1L;
			ImageIcon icon;
			public orderButton(int x,int y){
			icon=new ImageIcon(this.getClass().getResource("image/orderButton.png"));
			this.setIcon(icon);
			this.setOpaque(true);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			this.setFocusPainted(false);
			this.setBounds(x,y,70,70);
			}
		}
		private class orderButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				OrderCreateFrame order=new OrderCreateFrame(client,controller,vo);
				order.hdp.ok.addActionListener(new ActionListener(){
		    		public void actionPerformed(ActionEvent e) {
		    			order.dispose();
		    			setHint("下单成功");
		    		}
		    		});
			}

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
		@Override
		public void paintComponent(Graphics g) {
			    g.drawImage(imageIcon.getImage(), 0, 0, this);
			    super.paintComponents(g);
			   }
	}
		class roomListPane extends JScrollPane{

			/**
			 *
			 */
			private static final long serialVersionUID = 1L;

			public roomListPane(){
				super(Panel);

				Panel.setLayout(null);
			    Panel.setPreferredSize(new Dimension(200,240));
			    Panel.setBounds(0,0,200,1000);
			    Panel.setOpaque(false);


			   this.setBounds(120, 270, 620, 70);
			   this.setOpaque(false);
			   this.getViewport().setOpaque(false);
			   this.getVerticalScrollBar().setVisible(false);
			   this.setBorder(new EmptyBorder(0,0,0,0));
			   this.setVisible(false);
			    for(int i=0;i<6;i++){
			    	roomItemPanel p=new roomItemPanel(0, i*40,RoominfoDataTool.roominfo1);
		    	 Panel.add(p);
			    }
			    this.getVerticalScrollBar().setVisible(false);
			}
		}
//end scrollpane

}



