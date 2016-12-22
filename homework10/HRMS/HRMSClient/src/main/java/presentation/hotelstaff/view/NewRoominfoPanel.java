package presentation.hotelstaff.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import Enum.OrderType;
import Enum.RoomState;
import presentation.common.ModifyButton;
import presentation.hotelstaff.component.AddButton;
import presentation.hotelstaff.component.CancleButton;
import presentation.hotelstaff.component.ConfirmButton;
import presentation.hotelstaff.component.LeftButton;
import presentation.hotelstaff.component.ReviewTextArea;
import presentation.hotelstaff.component.RightButton;
import presentation.hotelstaff.component.RoominfoLabel;
import presentation.hotelstaff.component.RoominfoTextField;
import presentation.hotelstaff.controller.HotelstaffViewController;
import vo.hotelinfoVO.RoominfoVO;
import vo.orderVO.OrderVO;

public class NewRoominfoPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private HotelstaffViewController controller;
	private String hotelID;
	private ModifyButton jbModify;
	private AddButton jbAdd;

	private JPanel roominfoPanel;
	private JScrollPane scrollPane;

	public NewRoominfoPanel(HotelstaffViewController controller){
		this.controller = controller;
		this.hotelID = controller.gethotelID();
		initRoominfoPanel();
	}
	/**
	 * 初始查看酒店房间信息
	 */
	private void initRoominfoPanel(){
		this.setLayout(null);
		this.setBounds(0,0,1000,618);
		this.setVisible(true);
		setOpaque(false);
		
		jbAdd = new AddButton(690,488);
		jbAdd.addActionListener(new AddButtonActionListener());
		jbAdd.setVisible(true);
		this.add(jbAdd);
		
		showRoomList((ArrayList<RoominfoVO>)controller.getRoominfoList(hotelID));
	}
	
	private void showRoomList(ArrayList<RoominfoVO> rooms){
		//设置放置room信息的JPanel
	    roominfoPanel=new JPanel();
	    roominfoPanel.setLayout(null);
	    roominfoPanel.setPreferredSize(new Dimension(650,30+130*rooms.size()));
	    roominfoPanel.setBounds(0,0,1000,4000);
	    roominfoPanel.setOpaque(false);

	    //设置放置roominfo的JScrollPanel
	    scrollPane = new JScrollPane(roominfoPanel);
	    scrollPane.setBounds(285, 130, 800, 360);
	    scrollPane.setOpaque(false);
	    scrollPane.getViewport().setOpaque(false);
	    scrollPane.getVerticalScrollBar().setVisible(false);
	    scrollPane.setBorder(new EmptyBorder(0,0,0,0));
	    this.add(scrollPane);
	  
	    int num=0;

	    Image image=new ImageIcon("./src/main/resource/picture/hotelinfo/newroominfo.png").getImage();
	    for(RoominfoVO room:rooms){
	    	//制作roominfo背景
	        JPanel panel=new JPanel(){
				private static final long serialVersionUID = 1L;
				protected  void paintComponent(Graphics g) {
	            	g.drawImage(image,0,0,650,115,this);
	            }
			};
	        panel.setBounds(10, 10+120*num,680, 130);
	        panel.setLayout(null);
	        num++;
	        
	        //制作roominfo需要的组件
	        RoominfoLabel roomIDLabel=new RoominfoLabel(20,10,80,25,"房间号：");
	        RoominfoLabel typeLabel=new RoominfoLabel(190,10,80,25,"类型：");
	        RoominfoLabel priceLabel=new RoominfoLabel(190,45,80,25,"价格：");
	        RoominfoLabel stateLabel = new RoominfoLabel(190,80,80,25,"状态：");
	        JRadioButton usableButton=new JRadioButton("可用",false);
	        JRadioButton unusableButton=new JRadioButton("不可用",false);
	        ButtonGroup group=new ButtonGroup();
	        group.add(usableButton);
	        group.add(unusableButton);
	     
	        
	        RoominfoTextField roomIDText = new RoominfoTextField(100,10,180,25);
	        RoominfoTextField typeText = new RoominfoTextField(255,10,180,25);
	        RoominfoTextField priceText = new RoominfoTextField(255,45,180,25);
	      //  RoominfoTextField stateText = new RoominfoTextField(240,80,180,25);
	        
	        JLabel[] labelList = {roomIDLabel,typeLabel,priceLabel,stateLabel};
	        JTextField[] textfieldList = {roomIDText,typeText,priceText};
	        
	        textfieldList[0].setText(room.getRoomNum());
	        textfieldList[1].setText(room.getType());
	        textfieldList[2].setText(String.valueOf(room.getPrice()));

	        usableButton.setBounds(255, 80, 80, 25);
	        unusableButton.setBounds(320,80,80,25);
	        
	        for(int i=0;i<labelList.length;i++){
	        	panel.add(labelList[i]);
	        }
	        
	        for(int i=0;i<textfieldList.length;i++){
	        	panel.add(textfieldList[i]);
	        	textfieldList[i].setEditable(false);
	        }
	        
	        if(room.getRoomState()==RoomState.Usable){
	        	usableButton.setSelected(true);
	        }else{
	        	usableButton.setSelected(false);
	        }
	        panel.add(usableButton);
	        panel.add(unusableButton);
	        
	        jbModify = new ModifyButton(500,40,60,60);
			jbModify.addActionListener(new ActionListener(){
			
				@Override
				public void actionPerformed(ActionEvent e) {
				
					 for(int i=1;i<textfieldList.length;i++){
				        	textfieldList[i].setEditable(true);
				        }
				}
				
			});
			panel.add(jbModify);
	        
	        roominfoPanel.add(panel);

	}
}

	
	private void addRoom(){
		
	}
	
	private class AddButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			addRoom();
		}
	}
	
	
}
