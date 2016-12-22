package presentation.hotelstaff.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Enum.ResultMessage;
import Enum.Star;
import presentation.common.ModifyButton;
import presentation.common.MyLabel;
import presentation.hotelstaff.component.AddButton;
import presentation.hotelstaff.component.CancleButton;
import presentation.hotelstaff.component.ConfirmButton;
import presentation.hotelstaff.component.ReviewButton;
import presentation.hotelstaff.component.ReviewTextArea;
import presentation.hotelstaff.controller.HotelstaffViewController;
import vo.hotelinfoVO.HotelinfoVO;
/**
 *
 * @version 1
 * @author liuyu
 *
 */
public class HotelinfoPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private HotelstaffViewController controller;
	private HotelinfoVO vo;
	private String hotelID;
	private String name;
	private String address;
	private String area;
	private String intro;
	private String facility;
	private String tel;
	private Star star;
	private JLabel jlcompany;
	private ArrayList<String> companyList;
	private String company;
	private ReviewTextArea jtaAddress;
	//private ReviewTextArea jtaArea;
	private JComboBox jcbArea;
	private ReviewTextArea jtaIntro;
	private ReviewTextArea jtaFacility;
	private ReviewTextArea jtaTEL;
//	private ReviewTextArea jtaStar;
	private JComboBox jcbStar;
	private JComboBox jcbCompany;
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

		this.vo = controller.getHotelBasicinfo(hotelID);
		this.name = vo.getName();
		this.address = vo.getAddress();
		this.area = vo.getArea();
		this.intro = vo.getIntroduction();
		this.facility = vo.getFacility();
		this.tel = vo.getTel();
		this.star = vo.getStar();
		this.companyList = vo.getCompany();

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
		jcbStar.setBounds(345,451,200,25);
		jcbStar.setOpaque(false);
		jcbStar.setBorder(null);
		jcbStar.setSelectedItem(star.toString());
		jcbStar.setFont(new Font("微软雅黑",Font.PLAIN,20));
		jcbStar.setEnabled(false);
		this.add(jcbStar);

		jlcompany = new JLabel("合作企业");
		jlcompany.setFont(new Font("微软雅黑",Font.PLAIN,20));
		jlcompany.setBounds(600, 451, 100, 25);
		jlcompany.setForeground(Color.white);
		this.add(jlcompany);

		String[] companies = {""};
		if(companyList!=null){
			companies = new String[companyList.size()];
			for(int i=0;i<companyList.size();i++){
				companies[i] = companyList.get(i);
			}
		}
		jcbCompany = new JComboBox(companies);
		jcbCompany.setBounds(700,451,220,25);
		jcbCompany.setOpaque(false);
		jcbCompany.setBorder(null);
		jcbCompany.setSelectedItem(area);
		jcbCompany.setFont(new Font("微软雅黑",Font.PLAIN,20));
		jcbCompany.setEnabled(false);
		this.add(jcbCompany);

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
			jcbArea.setEnabled(true);
			jcbArea.setEditable(true);//商圈也可以自己添加
			jtaIntro.setEditable(true);
			jtaFacility.setEditable(true);
			jtaTEL.setEditable(true);
			jcbStar.setEnabled(true);
			jcbCompany.setEnabled(true);
			jcbCompany.setEditable(true);//合作企业也可以自己添加

			jbModify.setVisible(false);
			jbCancle.setVisible(true);
			jbConfirm.setVisible(true);

			showMessage("修改信息");
		}

	}

	private class ConfirmButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			jtaAddress.setEditable(false);
			jcbArea.setEnabled(false);
			jtaIntro.setEditable(false);
			jtaFacility.setEditable(false);
			jtaTEL.setEditable(false);
			jcbStar.setEnabled(false);
			jcbCompany.setEnabled(false);

			jbModify.setVisible(true);
			jbCancle.setVisible(false);
			jbConfirm.setVisible(false);

			address = jtaAddress.getText();
			area = jcbArea.getSelectedItem().toString();
			intro = jtaIntro.getText();
			facility = jtaFacility.getText();
			tel = jtaTEL.getText();
			company = jcbCompany.getSelectedItem().toString();

			String sStar = jcbStar.getSelectedItem().toString();
			String[] arrayString = {"ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN"};
			Star[] arrayStar = {Star.ONE,Star.TWO,Star.THREE,Star.FOUR,Star.FIVE,Star.SIX,Star.SEVEN};
			for(int i=0;i<arrayString.length;i++){
				if(sStar.equals(arrayString[i])){
					star = arrayStar[i];
				}
			}

			if(address.equals("")){
				showMessage("地址不能为空");
			}else if(area.equals("")){
				showMessage("商圈不能为空");
			}else if(intro.equals("")){
				showMessage("简介不能为空");
			}else if(facility.equals("")){
				showMessage("设施不能为空");
			}else if(tel.equals("")){
				showMessage("联系电话不能为空");
			}else if(sStar.equals("")){
				showMessage("星级不能为空");
			}else{
				ResultMessage result = controller.addArea(area);
				//提示信息
				if(result == ResultMessage.SUCCESS){
					showMessage("添加商圈成功");
				}

				int flag = 0;
				for(int i=0;i<companyList.size();i++){
					if(companyList.get(i).equals(company)){
						flag = 1;
					}
				}
				if(flag == 0){
					companyList.add(company);
				}
				result = controller.updateBassicinfo(new HotelinfoVO(
					name,address,area,intro,facility,tel,star,hotelID,companyList));
				if(result == ResultMessage.SUCCESS){
					showMessage("保存成功");
				}else if(result == ResultMessage.FAIL){
					showMessage("保存失败");
				}else if(result == ResultMessage.REMOTEEXCEPTION){
					showMessage("网络异常");
				}
			}
		}
	}

	private class CancleButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			jbModify.setVisible(true);
			jbCancle.setVisible(false);
			jbConfirm.setVisible(false);

			jtaAddress.setText(address);
			jcbArea.setSelectedItem(area);
			jtaIntro.setText(intro);
			jtaFacility.setText(facility);
			jtaTEL.setText(tel);
			jcbCompany.setSelectedItem("");

			jcbStar.setSelectedItem(star.toString());

			jtaAddress.setEditable(false);
			jcbArea.setEnabled(false);
			jtaIntro.setEditable(false);
			jtaFacility.setEditable(false);
			jtaTEL.setEditable(false);
			jcbStar.setEnabled(false);
			jcbCompany.setEnabled(false);

			showMessage("操作取消");
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

}
