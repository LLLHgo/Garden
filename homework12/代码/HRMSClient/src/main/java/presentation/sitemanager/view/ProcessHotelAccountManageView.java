package presentation.sitemanager.view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Enum.ResultMessage;
import presentation.common.HotelIconLabel;
import presentation.sitemanager.component.AddButton;
import presentation.sitemanager.component.CheckButton;
import presentation.sitemanager.component.ModifyButton;
import presentation.sitemanager.component.MyLabel;
import presentation.sitemanager.component.MyTextField;
import presentation.sitemanager.component.SearchButton;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.SitemanagerAddVO;
import vo.hotelstaffVO.HotelstaffVO;

public class ProcessHotelAccountManageView extends JPanel{
	
	private static final long serialVersionUID = 1L;
	ProcessSitemanagerViewControllerService controller;
	ProcessSitemanagerView view;
	ResultMessage result;
	Date date;
	
	HotelstaffVO addHotelstaffVO;
	HotelstaffVO modifyHotelstaffVO;
	HotelstaffVO hotelstaffVO;
	HotelinfoVO hotelinfoVO;
	SitemanagerAddVO sitemanagerAddVO;
	
	// 背景图片
	private ImageIcon background;
	// 左上角：添加酒店label及按钮
	MyLabel addHotelLabel;
	AddButton addHotelButton;
	// 右上角酒店工作人员账户管理textfield和按钮
	JTextField searchText;
	SearchButton searchButton;
	// 修改和修改确认按钮
	ModifyButton modifyButton;
	CheckButton checkModifyButton;
	CheckButton checkAddButton;
	// 状态栏
	MyLabel conditionLabel;
	// 酒店详细信息区域
	MyLabel idLabelL;
	MyLabel nameLabelL;
	MyLabel telLabelL;
	MyLabel passwordLabelL;
	
	MyLabel idLabel;
	MyTextField nameTextField;
	MyTextField telTextField;
	MyTextField passwordField;
	// 酒店工作人员头像区域
	HotelIconLabel hotelIconLabel;
	// 新增的酒店名称、酒店工作人员电话、酒店工作人员密码
	String addName;
	String addTel;
	String addPassword;
	// 修改后的酒店工作人员电话、密码
	String modifyTel;
	String modifyPassword;
	
	public ProcessHotelAccountManageView(ProcessSitemanagerViewControllerService controller,ProcessSitemanagerView processSitemanagerView){
		this.controller=controller;
		this.view=processSitemanagerView;
		this.setBounds(276,82,702,502);
		this.setLayout(null);
		// 设置背景图片
		background=new ImageIcon("src/main/resource/picture/sitemanager/hotelManageMain.png");
		// 设置酒店工作人员头像
		hotelIconLabel=new HotelIconLabel(160,200);
		// 设置添加按钮
		addHotelButton=new AddButton(210,5,65,65);
		addHotelLabel=new MyLabel(100,15,100,40,"添加酒店");
		addHotelLabel.setFont(new java.awt.Font("微软雅黑",1,25));
		addHotelButton.addMouseListener(new AddHotelButtonMouseListener());
		// 搜索框和搜索按钮
		searchButton=new SearchButton(635,11,40,40);
		searchText=new JTextField("输入酒店工作人员帐号");
		searchText.setBounds(400,17,275,40);
		searchText.setFont(new java.awt.Font("微软雅黑",1,20));
		searchText.setOpaque(false);
		searchText.setForeground(Color.white);
		searchText.setBorder(new EmptyBorder(0,0,0,0));
		searchButton.addMouseListener(new SearchListener());
		// 工具栏按钮（修改按钮和确认按钮）
		modifyButton=new ModifyButton(618,180,50,50);
		modifyButton.addMouseListener(new ModifyListener());
		modifyButton.setEnabled(false);
		checkModifyButton=new CheckButton(610,270,65,65);
		checkModifyButton.addMouseListener(new CheckModifyListener());
		checkModifyButton.setEnabled(false);
		
		checkAddButton=new CheckButton(400,350,65,65);
		checkAddButton.addMouseListener(new CheckAddListener());
		checkAddButton.setVisible(false);
		// 状态栏
		conditionLabel=new MyLabel(80,450,500,40,"");
		// 详细信息
		idLabelL=new MyLabel(300,180,100,25,"酒店帐号：");
		nameLabelL=new MyLabel(300,230,100,25,"酒店名称：");
		telLabelL=new MyLabel(300,280,100,25,"电话：");
		passwordLabelL=new MyLabel(300,330,60,25,"密码:");
		
		idLabel=new MyLabel(400,180,180,25,"");
		nameTextField=new MyTextField(400,230,180,25,"");
		telTextField=new MyTextField(400,280,180,25,"");
		passwordField=new MyTextField(400,330,180,25,"");
		
		this.add(hotelIconLabel);
		this.add(addHotelButton);
		this.add(addHotelLabel);
		this.add(searchButton);
		this.add(searchText);
		this.add(modifyButton);
		this.add(checkModifyButton);
		this.add(conditionLabel);
		this.add(checkAddButton);
		this.add(idLabelL); this.add(nameLabelL); this.add(telLabelL); this.add(passwordLabelL);
		this.add(idLabel); this.add(nameTextField); this.add(telTextField); this.add(passwordField);
		this.repaint();
		view.add(this);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		background.setImage(background.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST));
		background.paintIcon(this, g, 0, 0);
	}
	
	// 添加酒店按钮的监听
	class AddHotelButtonMouseListener implements MouseListener{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			nameTextField.setEditable(true);
			telTextField.setEditable(true);
			passwordField.setEditable(true);
			checkAddButton.setVisible(true);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	// 搜索酒店工作人员账户的监听
	class SearchListener implements MouseListener{
		String searchId;
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			searchId=searchText.getText();
			hotelstaffVO=controller.HotelStaffAccountFind(searchId);
			hotelinfoVO=controller.HotelinfoAccountFind(searchId);
			if(hotelstaffVO==null){
				conditionLabel.setText("找不到账户！");
			}
			else{
				conditionLabel.setText("找到匹配账户");
				nameTextField.setText(hotelinfoVO.getName());
				idLabel.setText(hotelstaffVO.getHotelID());
				telTextField.setText(hotelstaffVO.getPassword());
				passwordField.setText(hotelstaffVO.getPassword());
				telTextField.setEditable(false);
				passwordField.setEditable(false);
				//nameTextField.setText("");
				modifyButton.setEnabled(true);
				checkAddButton.setVisible(false);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class CheckModifyListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			modifyTel=telTextField.getText();
			modifyPassword=passwordField.getText();
			modifyHotelstaffVO=new HotelstaffVO(idLabel.getText(),modifyPassword,modifyTel);
			result=controller.HotelStaffAccountUpdate(modifyHotelstaffVO);
			if(result==ResultMessage.SUCCESS){
				conditionLabel.setText("修改成功！");
				date=new Date();
				telTextField.setEditable(false);
				passwordField.setEditable(false);
				addLog("S00000001 "+date.toString()+" 修改"+idLabel.getText()+"账户");
			}
			else if(result==ResultMessage.DATEBASEFAIL){
				conditionLabel.setText("数据库保存失败！");
			}
			else if(result==ResultMessage.SAMEINFO){
				conditionLabel.setText("信息未做更改，不再进行保存！");
			}
			checkModifyButton.setEnabled(true);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class ModifyListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			telTextField.setEditable(true);
			passwordField.setEditable(true);
			checkModifyButton.setEnabled(true);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class CheckAddListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			addName=nameTextField.getText();
			addTel=telTextField.getText();
			addPassword=passwordField.getText();
			addHotelstaffVO=new HotelstaffVO("",addPassword,addTel);
			sitemanagerAddVO=new SitemanagerAddVO(addName);
			result=controller.HotelAccountAdd(sitemanagerAddVO,addHotelstaffVO);
			if(result==ResultMessage.SUCCESS){
				conditionLabel.setText("添加成功！");
				date=new Date();
				addLog("S00000001 "+date.toString()+" 添加酒店"+addName+"账户");
				checkAddButton.setEnabled(false);
			}
			else{
				conditionLabel.setText("添加失败！ "+result);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	void addLog(String info){
		controller.addLog(info);
	}
}

