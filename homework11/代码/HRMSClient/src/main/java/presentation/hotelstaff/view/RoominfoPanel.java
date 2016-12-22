package presentation.hotelstaff.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.synth.SynthSpinnerUI;

import Enum.RoomState;
import Enum.Star;
import presentation.common.ModifyButton;
import presentation.common.MyLabel;
import presentation.hotelstaff.component.AddButton;
import presentation.hotelstaff.component.CancleButton;
import presentation.hotelstaff.component.ConfirmButton;
import presentation.hotelstaff.component.DetailedRoominfo;
import presentation.hotelstaff.component.LeftButton;
import presentation.hotelstaff.component.ReviewTextArea;
import presentation.hotelstaff.component.RightButton;
import presentation.hotelstaff.component.RoominfoLabel;
import presentation.hotelstaff.controller.HotelstaffViewController;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;

public class RoominfoPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private HotelstaffViewController controller;
	private String hotelID;
	private ImageIcon init_image;
	private ModifyButton jbModify1;
	private ModifyButton jbModify2;
	private ModifyButton jbModify3;
	private LeftButton jbLeft;
	private RightButton jbRight;
	private AddButton jbAdd;
	private RoominfoLabel label1_roomNO;
	private RoominfoLabel label1_type;
	private RoominfoLabel label1_price;
	private RoominfoLabel label1_state;
	private RoominfoLabel label2_roomNO;
	private RoominfoLabel label2_type;
	private RoominfoLabel label2_price;
	private RoominfoLabel label2_state;
	private RoominfoLabel label3_roomNO;
	private RoominfoLabel label3_type;
	private RoominfoLabel label3_price;
	private RoominfoLabel label3_state;
	private RoominfoLabel  arrayRoomNO[]=new RoominfoLabel[3];
	private RoominfoLabel arrayType[]=new RoominfoLabel[3];
	private RoominfoLabel arrayPrice[]=new RoominfoLabel[3];
	private RoominfoLabel arrayState[]=new RoominfoLabel[3];
	private int page=1;
	private int maxPage;
	
	private JFrame frame;
	private String roomID="";
	private String type="";
	private String price="";
	private String state="";
	private ImageIcon init_detailedroominfo_image;
	private ReviewTextArea jtaRoomID;
	private ReviewTextArea jtaType;
	private ReviewTextArea jtaPrice;
	private ReviewTextArea jtaState;
	private CancleButton jbDetailedCancle;
	private ConfirmButton jbDetailedConfirm;
	private JPanel panel;

	public RoominfoPanel(HotelstaffViewController controller){
		this.controller = controller;
		this.hotelID = controller.gethotelID();
		initHotelinfoPanel();
	}
	
	private void initHotelinfoPanel(){
		page=1;
		
		this.setLayout(null);
		this.setBounds(0,0,1000,618);
		this.setVisible(true);
		setOpaque(false);
		
		init_image = new ImageIcon("./src/main/resource/picture/hotelinfo/roominfo.png");
	
		jbLeft = new LeftButton(295,480);
		jbRight = new RightButton(888,480);
		jbLeft.addActionListener(new LeftButtonActionListener());
		jbRight.addActionListener(new RightButtonActionListener());
		jbLeft.setEnabled(false);
		
		this.add(jbLeft);
		this.add(jbRight);
		
		jbModify1 = new ModifyButton(880,150,60,60);
		jbModify1.addActionListener(new ModifyButtonActionListener());
		this.add(jbModify1);
		
		jbModify2 = new ModifyButton(880,270,60,60);
		jbModify2.addActionListener(new ModifyButtonActionListener());
		this.add(jbModify2);
		
		jbModify3 = new ModifyButton(880,390,60,60);
		jbModify3.addActionListener(new ModifyButtonActionListener());
		this.add(jbModify3);
		
		jbAdd = new AddButton(590,488);
		jbAdd.addActionListener(new AddButtonActionListener());
		jbAdd.setVisible(true);
		this.add(jbAdd);
		
		arrayRoomNO[0]=label1_roomNO = new RoominfoLabel(320,122,180,25,"房间号：");
		arrayType[0]=label1_type = new RoominfoLabel(540,122,180,25,"类型：");
		arrayPrice[0]=label1_price = new RoominfoLabel(540,160,180,25,"价格：");
		arrayState[0]=label1_state = new RoominfoLabel(540,198,180,25,"状态：");
		arrayRoomNO[1]=label2_roomNO = new RoominfoLabel(320,245,180,25,"房间号：");
		arrayType[1]=label2_type = new RoominfoLabel(540,245,180,25,"类型：");
		arrayPrice[1]=label2_price = new RoominfoLabel(540,283,180,25,"价格：");
		arrayState[1]=label2_state = new RoominfoLabel(540,321,180,25,"状态：");
		arrayRoomNO[2]=label3_roomNO = new RoominfoLabel(320,370,180,25,"房间号：");
		arrayType[2]=label3_type = new RoominfoLabel(540,370,180,25,"类型：");
		arrayPrice[2]=label3_price = new RoominfoLabel(540,408,180,25,"价格：");
		arrayState[2]=label3_state = new RoominfoLabel(540,446,180,25,"状态：");
		
		if(controller.getRoominfoList(hotelID)!=null){
			maxPage = (controller.getRoominfoList(hotelID).size()-1)/3+1;
		}
		if(page==maxPage){
			jbRight.setEnabled(false);
		}
		
		if(controller.getRoominfoList(hotelID)==null){
			
		}else if(controller.getRoominfoList(hotelID).size()<=3){
			for(int i=0;i<controller.getRoominfoList(hotelID).size();i++){
				arrayRoomNO[i].setText("房间号:"+controller.getRoominfoList(hotelID).get(i).getRoomNum());
				arrayType[i].setText("类型:"+controller.getRoominfoList(hotelID).get(i).getType());
				arrayPrice[i].setText("价格:"+controller.getRoominfoList(hotelID).get(i).getPrice());
				arrayState[i].setText("状态:"+controller.getRoominfoList(hotelID).get(i).getRoomState());
			}
		}else{
			for(int i=0;i<3;i++){
				arrayRoomNO[i].setText("房间号:"+controller.getRoominfoList(hotelID).get(i).getRoomNum());
				arrayType[i].setText("类型:"+controller.getRoominfoList(hotelID).get(i).getType());
				arrayPrice[i].setText("价格:"+controller.getRoominfoList(hotelID).get(i).getPrice());
				arrayState[i].setText("状态:"+controller.getRoominfoList(hotelID).get(i).getRoomState());
			}
		}
		this.add(label1_roomNO);
		this.add(label2_roomNO);
		this.add(label3_roomNO);
		this.add(label1_type);
		this.add(label2_type);
		this.add(label3_type);
		this.add(label1_price);
		this.add(label2_price);
		this.add(label3_price);
		this.add(label1_state);
		this.add(label2_state);
		this.add(label3_state);
	}
	
	protected void paintComponent(Graphics g) {
		g.drawImage(init_image.getImage(), 290,120,650,360,this);
    }

	private class ModifyButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jbModify1){
				
				roomID = label1_roomNO.getText().substring(4);
				type = label1_type.getText().substring(3);
				price = label1_price.getText().substring(3);
				state = label1_state.getText().substring(3);
				
			}else if(e.getSource()==jbModify2){
				
				roomID = label2_roomNO.getText().substring(4);
				type = label2_type.getText().substring(3);
				price = label2_price.getText().substring(3);
				state = label2_state.getText().substring(3);
				
			}else if(e.getSource()==jbModify3){
				
				roomID = label3_roomNO.getText().substring(4);
				type = label3_type.getText().substring(3);
				price = label3_price.getText().substring(3);
				state = label3_state.getText().substring(3);
				
			}
			initDetailedRoominfo();
			jtaRoomID.setEditable(false);
			jtaType.setEditable(true);
			jtaPrice.setEditable(true);
			jtaState.setEditable(true);
			setPanelUnEditable();
		}
		
	}
	
	private class ConfirmButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			roomID = jtaRoomID.getText();
			type = jtaPrice.getText();
			price = jtaPrice.getText();
			state = jtaPrice.getText();
			if(state.equals("Unusable")){
				controller.updateroominfo(new RoominfoVO(type,roomID,Double.parseDouble(price),RoomState.Unusable),hotelID);
			}else if(state.equals("Unusable")){
				controller.updateroominfo(new RoominfoVO(type,roomID,Double.parseDouble(price),RoomState.Unusable),hotelID);
			}else{
				//TODO
			}
			frame.dispose();
			refreshPanel();
		}
	}
	private class CancleButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			refreshPanel();
		}
	}
	
	private void setPanelUnEditable(){
		this.removeAll();
	}
	private void refreshPanel(){
		this.initHotelinfoPanel();
	}
	
	private class AddButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			roomID = "";
			type = "";
			price = "";
			state = "";
			initDetailedRoominfo();
			jtaRoomID.setEditable(true);
			jtaType.setEditable(true);
			jtaPrice.setEditable(true);
			jtaState.setEditable(true);
			setPanelUnEditable();
		}
	}
	
	public void initDetailedRoominfo(){
		frame = new JFrame();
		frame.setSize(300,380);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setVisible(true);
		
		Toolkit kit = Toolkit.getDefaultToolkit();    // 定义工具包
	    Dimension screenSize = kit.getScreenSize();   // 获取屏幕的尺寸
	    int screenWidth = screenSize.width/2;         // 获取屏幕的宽
	    int screenHeight = screenSize.height/2;       // 获取屏幕的高
	    int height = frame.getHeight();
	    int width = frame.getWidth();
	    frame.setLocation(screenWidth-width/2, screenHeight-height/2);
	    
	    init_detailedroominfo_image = new ImageIcon("C:/Users/1/Documents/GitHub/Code/HRMSClient/src/main/resource/picture/hotelinfo/detailedroominfo.png");
	    
	    panel = new JPanel(){
			protected void paintComponent(Graphics g) {
				g.drawImage(init_detailedroominfo_image.getImage(),0,0,300,380,panel);
		    }
		};
	    panel.setLayout(null);
	    panel.setSize(300,380);
	    panel.setVisible(true);
	    panel.setOpaque(false);
		frame.getContentPane().add(panel);
		
		jtaRoomID = new ReviewTextArea(83,54,200,30,roomID);
		jtaType = new ReviewTextArea(83,104,200,30,type);
		jtaPrice = new ReviewTextArea(83,157,200,30,price);
		jtaState = new ReviewTextArea(83,213,200,30,state);
		jtaRoomID.setForeground(Color.BLACK);
		jtaType.setForeground(Color.BLACK);
		jtaPrice.setForeground(Color.BLACK);
		jtaState.setForeground(Color.BLACK);
		jtaRoomID.setText(roomID);
		jtaType.setText(type);
		jtaState.setText(state);
		jtaPrice.setText(price);

		panel.add(jtaRoomID);
		panel.add(jtaType);
		panel.add(jtaPrice);
		panel.add(jtaState);
		
		jbDetailedConfirm = new ConfirmButton(230,300);
		jbDetailedConfirm.addActionListener(new ConfirmButtonActionListener());
		panel.add(jbDetailedConfirm);
		
		jbDetailedCancle = new CancleButton(20,300);
		jbDetailedCancle.addActionListener(new CancleButtonActionListener());
		panel.add(jbDetailedCancle);
	}
	
	private class LeftButtonActionListener  implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			page--;
			if(page==maxPage){
				jbRight.setEnabled(false);
			}
			if(page>1){
				jbLeft.setEnabled(true);
			}
			if(page==1){
				jbLeft.setEnabled(false);
			}
			if(page<maxPage){
				jbRight.setEnabled(true);
			}
			for(int i=0;i<3;i++){
				arrayRoomNO[i].setText("房间号:");
				arrayType[i].setText("类型:");
				arrayPrice[i].setText("价格:");
				arrayState[i].setText("状态:");
			}
			int index=0;
			for(int i=(page-1)*3;i<page*3&&i<controller.getRoominfoList(hotelID).size()-1;i++){
				arrayRoomNO[index].setText("房间号:"+controller.getRoominfoList(hotelID).get(i).getRoomNum());
				arrayType[index].setText("类型:"+controller.getRoominfoList(hotelID).get(i).getType());
				arrayPrice[index].setText("价格:"+controller.getRoominfoList(hotelID).get(i).getPrice());
				arrayState[index].setText("状态:"+controller.getRoominfoList(hotelID).get(i).getRoomState());
				index++;
			}
		}
		
	}
	
	private class RightButtonActionListener  implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			page++;
			if(page==1){
				jbLeft.setEnabled(false);
			}
			if(page<maxPage){
				jbRight.setEnabled(true);
			}
			if(page==maxPage){
				jbRight.setEnabled(false);
			}
			if(page>1){
				jbLeft.setEnabled(true);
			}
			for(int i=0;i<3;i++){
				arrayRoomNO[i].setText("房间号:");
				arrayType[i].setText("类型:");
				arrayPrice[i].setText("价格:");
				arrayState[i].setText("状态:");
			}
			int index=0;
			for(int i=(page-1)*3;i<page*3&&i<controller.getRoominfoList(hotelID).size()-1;i++){
				arrayRoomNO[index].setText("房间号:"+controller.getRoominfoList(hotelID).get(i).getRoomNum());
				arrayType[index].setText("类型:"+controller.getRoominfoList(hotelID).get(i).getType());
				arrayPrice[index].setText("价格:"+controller.getRoominfoList(hotelID).get(i).getPrice());
				arrayState[index].setText("状态:"+controller.getRoominfoList(hotelID).get(i).getRoomState());
				index++;
			}
		}
		
	}
}