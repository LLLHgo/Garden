package presentation.sitemanager.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import presentation.sitemanager.component.MyPasswordField;
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
	MyPasswordField passwordField;
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
		background=new ImageIcon(this.getClass().getResource("image/hotelManageMain.png"));
		// 设置酒店工作人员头像
		hotelIconLabel=new HotelIconLabel(160,200);
		// 设置添加按钮
		addHotelButton=new AddButton(210,5,65,65);
		addHotelLabel=new MyLabel(100,15,100,40,"添加酒店");
		addHotelLabel.setFont(new java.awt.Font("微软雅黑",1,20));
		addHotelButton.addMouseListener(new AddHotelButtonMouseListener());
		// 搜索框和搜索按钮
		searchButton=new SearchButton(635,11,40,40);
		searchText=new JTextField("输入酒店工作人员帐号");
		searchText.addFocusListener(new FocusAdapter() {  
            public void focusGained(FocusEvent arg0) {  
            	searchText.setSelectionStart(0);  
            }  
        });
		searchText.setBounds(400,17,275,40);
		searchText.setFont(new java.awt.Font("楷体",Font.ITALIC,20));
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
		nameTextField.setBorder(new EmptyBorder(0,0,0,0));
		nameTextField.setForeground(Color.white);
		nameTextField.setOpaque(false);
		telTextField=new MyTextField(400,280,180,25,"");
		telTextField.setBorder(new EmptyBorder(0,0,0,0));
		telTextField.setForeground(Color.white);
		passwordField=new MyPasswordField(400,330,180,25,"");
		passwordField.setForeground(Color.white);
		
		passwordField.setBorder(new EmptyBorder(0,0,0,0));
		
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
			nameTextField.setText("");
			nameTextField.setOpaque(true);
			nameTextField.setForeground(Color.DARK_GRAY);
			telTextField.setText("");
			telTextField.setOpaque(true);
			telTextField.setForeground(Color.DARK_GRAY);
			passwordField.setText("");
			passwordField.setOpaque(true);
			passwordField.setForeground(Color.DARK_GRAY);
			idLabel.setText("");
			nameTextField.setEditable(true);;
			telTextField.setEditable(true);
			passwordField.setEditable(true);
			checkAddButton.setVisible(true);
			checkAddButton.setEnabled(true);
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}

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
				nameTextField.setOpaque(false);
				nameTextField.setForeground(Color.white);
				idLabel.setText(hotelstaffVO.getHotelID());
				telTextField.setText(hotelstaffVO.getTel());
				passwordField.setText(hotelstaffVO.getPassword());
				telTextField.setForeground(Color.white);
				telTextField.setOpaque(false);
				passwordField.setForeground(Color.white);
				passwordField.setOpaque(false);
				nameTextField.setForeground(Color.white);
				telTextField.setEditable(false);
				telTextField.setOpaque(false);
				passwordField.setEditable(false);
				modifyButton.setEnabled(true);
				checkAddButton.setVisible(false);
			}
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}

	}
	// 确认修改的按钮
	class CheckModifyListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			modifyTel=telTextField.getText();
			modifyPassword=passwordField.getText();
			if((modifyTel==""||modifyTel.equals(""))&&(modifyPassword==""||modifyPassword.equals(""))){
				conditionLabel.setText("请输入修改后的电话和密码！");
			}
			else if(modifyTel==""||modifyTel.equals("")){
				conditionLabel.setText("请输入修改后的电话！");
			}
			else if(modifyPassword==""||modifyPassword.equals("")){
				conditionLabel.setText("请输入修改后的密码！");
			}
			else if(!isNumeric(modifyTel)){
				conditionLabel.setText("请确认电话中是否全为数字，重新输入电话！");
			}
			else if(modifyTel.length()!=11){
				conditionLabel.setText("电话位数不对，请重新输入电话！");
			}
			else {

			modifyHotelstaffVO=new HotelstaffVO(idLabel.getText(),modifyPassword,modifyTel);
			result=controller.HotelStaffAccountUpdate(modifyHotelstaffVO);
			if(result==ResultMessage.SUCCESS){
				conditionLabel.setText("修改成功！");
				date=new Date();
				telTextField.setEditable(false);
				telTextField.setForeground(Color.white);
				telTextField.setOpaque(false);
				passwordField.setEditable(false);
				passwordField.setForeground(Color.white);
				nameTextField.setEditable(false);
				nameTextField.setForeground(Color.white);
				addLog("S00000001 "+date.toString()+" 修改"+idLabel.getText()+"账户");
				checkModifyButton.setEnabled(true);
			}
			else if(result==ResultMessage.DATEBASEFAIL){
				conditionLabel.setText("数据库保存失败！");
			}

			}
		}

		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}

	}
	// 修改按钮
	class ModifyListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			nameTextField.setEditable(false);
			telTextField.setEditable(true);
			passwordField.setEditable(true);
			checkModifyButton.setEnabled(true);
			
			telTextField.setForeground(Color.DARK_GRAY);
			telTextField.setOpaque(true);
		}

		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}

	}
	// 确认添加的按钮
	class CheckAddListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

			addName=nameTextField.getText();
			addTel=telTextField.getText();
			addPassword=passwordField.getText();
			if(addName==""||addName.equals("")||addTel==""||addTel.equals("")||addPassword==""||addPassword.equals("")){
				conditionLabel.setText("请将信息填写完整！");
			}
			else if(!isNumeric(addTel)){
				conditionLabel.setText("请确认电话中是否全为数字，重新输入电话！");
			}
			else if(addTel.length()!=11){
				conditionLabel.setText("电话位数不对，请重新输入电话！");
			}
			else{
			addHotelstaffVO=new HotelstaffVO("",addPassword,addTel);
			sitemanagerAddVO=new SitemanagerAddVO(addName);
			result=controller.HotelAccountAdd(sitemanagerAddVO,addHotelstaffVO);
			if(result==ResultMessage.SUCCESS){
				conditionLabel.setText("添加成功！");
				idLabel.setText(controller.getHotelID());
				nameTextField.setEditable(false);
				telTextField.setEditable(false);
				passwordField.setEditable(false);
				
				nameTextField.setForeground(Color.white);
				nameTextField.setOpaque(false);
				telTextField.setForeground(Color.white);
				telTextField.setOpaque(false);
				passwordField.setForeground(Color.white);
				passwordField.setOpaque(false);
				
				date=new Date();
				addLog("S00000001 "+date.toString()+" 添加酒店"+addName+"账户");
				checkAddButton.setEnabled(false);
			}
			else if(result==ResultMessage.DUPLICATENAME){
				conditionLabel.setText("酒店名字已存在！");
			}
			else if(result==ResultMessage.DATEBASEFAIL){
				conditionLabel.setText("数据库保存失败！");
			}
			}
		}


		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}

	}
	void addLog(String info){
		controller.addLog(info);
	}
	// 判断字符串是不是全为数字，如果全为数字，返回true
	public boolean isNumeric(String str){
		Pattern pattern = Pattern.compile("[0-9]*");
	    Matcher isNum = pattern.matcher(str);
	    if( !isNum.matches() ){
		   return false;
		}
		return true;
		}
}

