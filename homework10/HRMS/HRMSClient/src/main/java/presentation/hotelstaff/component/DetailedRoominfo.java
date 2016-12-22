package presentation.hotelstaff.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DetailedRoominfo extends JFrame{
	private static final long serialVersionUID = 1L;
	private String roomID;
	private String type;
	private String price;
	private String state;
	private ImageIcon init_image;
	private ReviewTextArea jtaRoomID;
	private ReviewTextArea jtaType;
	private ReviewTextArea jtaPrice;
	private ReviewTextArea jtaState;
	private CancleButton jbCancle;
	private ConfirmButton jbConfirm;
	private JPanel panel;
	public DetailedRoominfo(String roomID,String type,String price,String state){
		this.setSize(300,380);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setUndecorated(true);
		this.setVisible(true);
		
		Toolkit kit = Toolkit.getDefaultToolkit();    // 定义工具包
	    Dimension screenSize = kit.getScreenSize();   // 获取屏幕的尺寸
	    int screenWidth = screenSize.width/2;         // 获取屏幕的宽
	    int screenHeight = screenSize.height/2;       // 获取屏幕的高
	    int height = this.getHeight();
	    int width = this.getWidth();
	    this.setLocation(screenWidth-width/2, screenHeight-height/2);
	    
	    init_image = new ImageIcon("C:/Users/1/Documents/GitHub/Code/HRMSClient/src/main/resource/picture/hotelinfo/detailedroominfo.png");
	    
		this.roomID = roomID;
		this.type = type;
		this.price = price;
		this.state = state;
		init();
	}
	
	private void init(){ 
		panel = new JPanel(){
			protected void paintComponent(Graphics g) {
				g.drawImage(init_image.getImage(),0,0,300,380,panel);
		    }
		};
	    panel.setLayout(null);
	    panel.setSize(300,380);
	    panel.setVisible(true);
	    panel.setOpaque(false);
		this.getContentPane().add(panel);
		this.getContentPane().setBackground(new Color(255,255,255,0));
		
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
		
		jbConfirm = new ConfirmButton(230,300);
		jbConfirm.addActionListener(new ConfirmButtonActionListener());
		panel.add(jbConfirm);
		
		jbCancle = new CancleButton(20,300);
		jbCancle.addActionListener(new CancleButtonActionListener());
		panel.add(jbCancle);
		
	}

	
	private class ConfirmButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

		}
	}
	private class CancleButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

		}
	}
}
