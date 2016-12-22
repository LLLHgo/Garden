package presentation.hotelstaff.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Enum.OrderType;
import Enum.ResultMessage;
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
	private AddButton jbAdd;
	private JPanel roominfoPanel;
	private JScrollPane scrollPane;
	private JLabel resultLabel;
	private String state;
	
	
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
		
		//新增房间信息
		jbAdd = new AddButton(800,490);
		jbAdd.addActionListener(new AddButtonActionListener());
		jbAdd.setVisible(true);
		this.add(jbAdd);
		
		//显示结果
		resultLabel = new JLabel();
		resultLabel.setForeground(Color.BLACK);
		resultLabel.setFont(new Font("微软雅黑",Font.PLAIN,20));
		resultLabel.setBounds(290, 50, 500, 20);
		this.add(resultLabel);
		
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
	    scrollPane.setBounds(285, 110, 800, 360);
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

	        String price = String.valueOf(room.getPrice());
	        
	        //制作roominfo需要的组件
	        RoominfoLabel roomIDLabel=new RoominfoLabel(20,10,180,25,"房间号："+room.getRoomNum());
	        RoominfoLabel typeLabel=new RoominfoLabel(190,10,180,25,"类型："+room.getType());
	        RoominfoLabel priceLabel=new RoominfoLabel(190,45,70,25,"价格：");
	        RoominfoLabel stateLabel = new RoominfoLabel(190,80,80,25,"状态：");
	        String[] states = {"可用","不可用"};
	        JComboBox jcbState = new JComboBox(states);
	        if(room.getRoomState()==RoomState.Usable){
	        	jcbState.setSelectedIndex(0);
	        }else{
	        	jcbState.setSelectedIndex(1);
	        }
	        jcbState.setEnabled(false);
	        jcbState.setBounds(250,78,90,30);
	        
	        
	        JTextField jtfPrice = new JTextField(String.valueOf(price));
	        jtfPrice.setBounds(250,45,100,25);
	        jtfPrice.setFont(new Font("微软雅黑",Font.PLAIN,20));
	        jtfPrice.setBorder(null);
	        jtfPrice.setOpaque(false);
	        jtfPrice.setForeground(Color.white);
	        jtfPrice.setEditable(false);
	        
	        panel.add(jtfPrice);
	        
	        panel.add(jcbState);
	        
	        JLabel[] labelList = {roomIDLabel,typeLabel,priceLabel,stateLabel};
	        
	        for(int i=0;i<labelList.length;i++){
	        	panel.add(labelList[i]);
	        }
	        

			ConfirmButton jbConfirm= new ConfirmButton(550,40);
			CancleButton jbCancle = new CancleButton(450,40);
			ModifyButton jbModify = new ModifyButton(500,40,60,60);
			 
			jbConfirm.setVisible(false);
			jbConfirm.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					String originState = state;
					String sPrice = jtfPrice.getText();
					if(sPrice.equals("")){
						showMessage("信息不完整，重新填写");
					}else if(!isNumeric(sPrice)){
						showMessage("价格格式错误，请输入数字");
					}else{
						room.setPrice(Double.parseDouble(sPrice));
						String state = jcbState.getSelectedItem().toString();
						if(state.equals("可用")){
							room.setRoomState(RoomState.Usable);
						}else{
							room.setRoomState(RoomState.Unusable);
						}
						ResultMessage message = controller.updateroominfo(room, hotelID);
						if(message == ResultMessage.SUCCESS){
							showMessage("修改成功");
							jbConfirm.setVisible(false);
							jbCancle.setVisible(false);
							jbModify.setVisible(true);
							jtfPrice.setEditable(false);
						}
						else{
							//TODO 
							jcbState.setSelectedItem(originState);
							showMessage("修改失败");
						}
						jcbState.setEnabled(false);
					}
				}
				
			});
			panel.add(jbConfirm);
			
			
			jbCancle.setVisible(false);
			jbCancle.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					jbConfirm.setVisible(false);
					jbCancle.setVisible(false);
					jbModify.setVisible(true);
					jcbState.setSelectedItem(state);
					jcbState.setEnabled(false);
					jtfPrice.setText(price);
					jtfPrice.setEditable(false);
					showMessage("取消成功");
				}
				
			});
			panel.add(jbCancle);
	        
	       
			jbModify.addActionListener(new ActionListener(){
			
				@Override
				public void actionPerformed(ActionEvent e) {
					jtfPrice.setEditable(true);
					state = jcbState.getSelectedItem().toString();
					jbConfirm.setVisible(true);
					jbCancle.setVisible(true);
					jbModify.setVisible(false);
					jcbState.setEnabled(true);
					showMessage("修改房间信息");
				}
				
			});
			panel.add(jbModify);
	        
			
	        roominfoPanel.add(panel);

	}
}
	
	private class AddButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.JBAddRoomClicked();
		}
	}
	
	public void showMessage(String message){
	 	//提示信息
		new Thread(new Runnable(){
			@Override
			public void run() {
					resultLabel.setText(message);
				try {
					Thread.sleep(2000);
	            }catch(InterruptedException ex){
	                    ex.printStackTrace();
	            }
	            resultLabel.setText("");
			}
		}).start();
		
	}
	
	public boolean isNumeric(String str){ 
		   Pattern pattern = Pattern.compile("-?[0-9]+.?[0-9]+"); 
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false; 
		   } 
		   return true; 
	}
}
