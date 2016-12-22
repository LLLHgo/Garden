package presentation.hotelstaff.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Enum.ResultMessage;
import Enum.Star;
import presentation.common.ModifyButton;
import presentation.hotelstaff.component.CancleButton;
import presentation.hotelstaff.component.ConfirmButton;
import presentation.hotelstaff.component.ReviewImageButton;
import presentation.hotelstaff.component.ReviewTextArea;
import presentation.hotelstaff.component.UserImageLabel;
import presentation.hotelstaff.controller.HotelstaffViewController;
import vo.hotelinfoVO.HotelinfoVO;
/**
 * 
 * @version 1
 * @since 16.11.27
 * @author liuyu
 *
 */
public class HotelstaffPanel extends JPanel{
	
	private HotelstaffViewController controller;
	private String hotelID;
	private ImageIcon ipassword;
	private JTextField jtfPassword;
	private UserImageLabel jlUserImage;
	private ReviewImageButton jbReviewImage;
	private ModifyButton jbModify;
	private ConfirmButton jbConfirm;
	private CancleButton jbCancle;
	private String password;
	private JLabel resultLabel;
	
	public HotelstaffPanel(HotelstaffViewController controller){
		this.controller = controller;
		this.hotelID = controller.gethotelID();
		initHotelstaffPanel();
	}
	
	private void initHotelstaffPanel(){
		//设置panel
		this.setLayout(null);
		this.setLocation(0, 0);
		this.setSize(1000, 618);
		this.setVisible(true);
		setOpaque(false);
		
		//修改密码的背景
		ipassword = new ImageIcon("./src/main/resource/picture/hotelstaff/password.png");
		
		password = controller.getHotelstaffBasicinfo(hotelID).getPassword();
	
		jtfPassword = new JTextField(15);
		Font font = new Font("微软雅黑",Font.PLAIN,20);
		jtfPassword.setFont(font);
		jtfPassword.setForeground(Color.white);
		jtfPassword.setBounds(345, 260, 585, 50);
		jtfPassword.setOpaque(false);
		jtfPassword.setBorder(null);
		jtfPassword.setText(password);
		jtfPassword.setEditable(false);
		this.add(jtfPassword);
		
		//修改按钮
		jbModify = new ModifyButton(900,255,60,60);
		jbModify.addActionListener(new ModifyButtonActionListener());
		this.add(jbModify);
		
		//确认按钮
		jbConfirm = new ConfirmButton(680,485);
		jbConfirm.addActionListener(new ConfirmButtonActionListener());
		jbConfirm.setVisible(false);
		this.add(jbConfirm);
		
		//取消按钮
		jbCancle = new CancleButton(480,488);
		jbCancle.addActionListener(new CancleButtonActionListener());
		jbCancle.setVisible(false);
		this.add(jbCancle);
		
		//用户头像
		jlUserImage = new UserImageLabel(565,150);
		this.add(jlUserImage);
		
		//显示结果
		resultLabel = new JLabel();
		resultLabel.setForeground(Color.BLACK);
		resultLabel.setFont(font);
		resultLabel.setBounds(290, 50, 500, 20);
		this.add(resultLabel);
	}
	
	protected void paintComponent(Graphics g) {
		g.drawImage(ipassword.getImage(), 285,260,670,50,this);
    }
	
	
	
	private class ModifyButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			jbConfirm.setVisible(true);
			jbCancle.setVisible(true);
			jbModify.setVisible(false);
			jtfPassword.setEditable(true);
		}	
	}
	
	private class ConfirmButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			jbConfirm.setVisible(false);
			jbCancle.setVisible(false);
			jbModify.setVisible(true);
			jtfPassword.setEditable(false);
			password = jtfPassword.getText();
			ResultMessage result = controller.setPassword(hotelID, password);
			
			//提示信息
			new Thread(new Runnable(){
				@Override
				public void run() {
					resultLabel.setText(String.valueOf(result));
					try {
						Thread.sleep(1000);
		            }catch(InterruptedException ex){
		                    ex.printStackTrace();
		            }
		            resultLabel.setText("");
				}
			}).start();;
		}	
	}
	
	private class CancleButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			jbConfirm.setVisible(false);
			jbCancle.setVisible(false);
			jbModify.setVisible(true);
			jtfPassword.setEditable(false);
			jtfPassword.setText(password);
			
			//提示信息
			new Thread(new Runnable(){
				@Override
				public void run() {
					resultLabel.setText("Operation was cancled");
					try {
						Thread.sleep(1000);
		            }catch(InterruptedException ex){
		                    ex.printStackTrace();
		            }
		            resultLabel.setText("");
				}
			}).start();
		}	
	}
}
