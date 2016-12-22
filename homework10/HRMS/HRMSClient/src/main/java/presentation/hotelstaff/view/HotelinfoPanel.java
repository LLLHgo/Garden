package presentation.hotelstaff.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Enum.ResultMessage;
import Enum.Star;
import presentation.common.ModifyButton;
import presentation.common.MyLabel;
import presentation.hotelstaff.component.CancleButton;
import presentation.hotelstaff.component.ConfirmButton;
import presentation.hotelstaff.component.ReviewButton;
import presentation.hotelstaff.component.ReviewTextArea;
import presentation.hotelstaff.controller.HotelstaffViewController;
import vo.hotelinfoVO.HotelinfoVO;
/**
 * 
 * @version 1
 * @since 16.11.27
 * @author liuyu
 *
 */
public class HotelinfoPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private HotelstaffViewController controller;
	private String hotelID;
	private String name;
	private String address;
	private String area;
	private String intro;
	private String facility;
	private String tel;
	private Star star;
	private ReviewTextArea jtaAddress;
	//private ReviewTextArea jtaArea;
	private JComboBox jcbArea;
	private ReviewTextArea jtaIntro;
	private ReviewTextArea jtaFacility;
	private ReviewTextArea jtaTEL;
//	private ReviewTextArea jtaStar;
	private JComboBox jcbStar;
	private ImageIcon init_image;
	private ModifyButton jbModify;
	private ConfirmButton jbConfirm;
	private CancleButton jbCancle;
	private JLabel resultLabel;
	private String[] areas;
	
	public HotelinfoPanel(HotelstaffViewController controller){
		this.controller = controller;
		this.hotelID = controller.gethotelID();
		initHotelinfoPanel();
	}
	
	private void initHotelinfoPanel(){
		this.setLayout(null);
		this.setBounds(0,0,1000,618);
		this.setVisible(true);
		setOpaque(false);
		
		init_image = new ImageIcon("./src/main/resource/picture/hotelinfo/hotelinfoPanel.png");
	
		//修改按钮，点击后hotelinfo属性变成可以编辑
		jbModify = new ModifyButton(580,485,60,60);
		jbModify.addActionListener(new ModifyButtonActionListener());
		this.add(jbModify);
		
		this.name = controller.getHotelBasicinfo(hotelID).getName();
		this.address = controller.getHotelBasicinfo(hotelID).getAddress();
		this.area = controller.getHotelBasicinfo(hotelID).getArea();
		this.intro = controller.getHotelBasicinfo(hotelID).getIntroduction();
		this.facility = controller.getHotelBasicinfo(hotelID).getFacility();
		this.tel = controller.getHotelBasicinfo(hotelID).getTel();
		this.star = controller.getHotelBasicinfo(hotelID).getStar();
		
		jtaAddress = new ReviewTextArea(345,135,580,25,address);
		//jtaArea= new ReviewTextArea(345,186,580,25,area);
		jtaIntro= new ReviewTextArea(345,230,580,70,intro);
		jtaFacility= new ReviewTextArea(345,311,580,70,facility);
		jtaTEL= new ReviewTextArea(345,402,580,25,tel);
		//jtaStar= new ReviewTextArea(345,451,580,25,String.valueOf(star));
		
		this.add(jtaAddress);
		//this.add(jtaArea);
		this.add(jtaIntro);
		this.add(jtaFacility);
		this.add(jtaTEL);
		//this.add(jtaStar);
		
		//TODO
		areas = controller.getArea();
		jcbArea = new JComboBox(areas);
		jcbArea.setBounds(345,186,580,25);
		jcbArea.setOpaque(false);
		jcbArea.setBorder(null);
		jcbArea.setSelectedItem(area);
		jcbArea.setFont(new Font("微软雅黑",Font.PLAIN,20));
		jcbArea.setEnabled(false);
		this.add(jcbArea);
		
		String [] stars = {"ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN"};
		jcbStar = new JComboBox(stars);
		jcbStar.setBounds(345,451,580,25);
		jcbStar.setOpaque(false);
		jcbStar.setBorder(null);
		jcbStar.setSelectedItem(star.toString());
		jcbStar.setFont(new Font("微软雅黑",Font.PLAIN,20));
		jcbStar.setEnabled(false);
		this.add(jcbStar);
		//确认按钮，点击后hotelinfo属性变成不可编辑，向bl层传数据
		jbConfirm = new ConfirmButton(695,485);
		jbConfirm.addActionListener(new ConfirmButtonActionListener());
		jbConfirm.setVisible(false);
		this.add(jbConfirm);
		
		//取消按钮，取消操作
		jbCancle = new CancleButton(495,488);
		jbCancle.addActionListener(new CancleButtonActionListener());
		jbCancle.setVisible(false);
		this.add(jbCancle);
		
		MyLabel label = new MyLabel(280,90,500,25,name);
		this.add(label);
		
		//显示结果
		resultLabel = new JLabel();
		resultLabel.setForeground(Color.BLACK);
		resultLabel.setFont(new Font("微软雅黑",Font.PLAIN,20));
		resultLabel.setBounds(290, 50, 500, 20);
		this.add(resultLabel);
	}
	
	protected void paintComponent(Graphics g) {
		g.drawImage(init_image.getImage(), 280,125,668,360,this);
    }

	private class ModifyButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			jtaAddress.setEditable(true);
			//TODO
			jcbArea.setEnabled(true);
			jcbArea.setEditable(true);//商圈也可以自己添加
			jtaIntro.setEditable(true);
			jtaFacility.setEditable(true);
			jtaTEL.setEditable(true);
			//TODO
			jcbStar.setEnabled(true);
			
			jbModify.setVisible(false);
			jbCancle.setVisible(true);
			jbConfirm.setVisible(true);

		}
		
	}
	
	private class ConfirmButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			jtaAddress.setEditable(false);
			//TODO
			jcbArea.setEnabled(false);
			jtaIntro.setEditable(false);
			jtaFacility.setEditable(false);
			jtaTEL.setEditable(false);
			//TODO
			jcbStar.setEnabled(false);
			
			jbModify.setVisible(true);
			jbCancle.setVisible(false);
			jbConfirm.setVisible(false);
			
			address = jtaAddress.getText();
			//TODO
			area = jcbArea.getSelectedItem().toString();

			intro = jtaIntro.getText();
			facility = jtaFacility.getText();
			tel = jtaTEL.getText();
			//TODO
			String sStar = jcbStar.getSelectedItem().toString();
			String[] arrayString = {"ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN"};
			Star[] arrayStar = {Star.ONE,Star.TWO,Star.THREE,Star.FOUR,Star.FIVE,Star.SIX,Star.SEVEN};
			for(int i=0;i<arrayString.length;i++){
				if(sStar.equals(arrayString[i])){
					star = arrayStar[i];
				}
			}
			
			
			final ResultMessage result = controller.addArea(area);
			//提示信息

				new Thread(new Runnable(){
					@Override
					public void run() {
						if(result!=null){
							resultLabel.setText(result.toString());
							try {
								Thread.sleep(1000);
							}catch(InterruptedException ex){
								ex.printStackTrace();
							}
						}
						resultLabel.setText(controller.updateBassicinfo
						(new HotelinfoVO(address,area,intro,facility,tel,star,hotelID)).toString());
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
	
	private class CancleButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			jbModify.setVisible(true);
			jbCancle.setVisible(false);
			jbConfirm.setVisible(false);
			
			jtaAddress.setText(address);
			//TODO
			jcbArea.setSelectedItem(area);
			jtaIntro.setText(intro);
			jtaFacility.setText(facility);
			jtaTEL.setText(tel);
			//TODO
			
			jcbStar.setSelectedItem(star.toString());
			
			jtaAddress.setEditable(false);
			//TODO
			jcbArea.setEnabled(false);
			jtaIntro.setEditable(false);
			jtaFacility.setEditable(false);
			jtaTEL.setEditable(false);
			//TODO
			jcbStar.setEnabled(false);
			
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
			}).start();;
		}
		
	}
}
