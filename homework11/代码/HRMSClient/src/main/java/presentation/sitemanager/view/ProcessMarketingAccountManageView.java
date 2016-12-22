package presentation.sitemanager.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Enum.ResultMessage;
import presentation.common.MarketingIconLabel;
import presentation.sitemanager.component.AddButton;
import presentation.sitemanager.component.CheckButton;
import presentation.sitemanager.component.DeleteButton;
import presentation.sitemanager.component.ModifyButton;
import presentation.sitemanager.component.MyLabel;
import presentation.sitemanager.component.MyTextField;
import presentation.sitemanager.component.SearchButton;
import vo.marketingVO.MarketingVO;

public class ProcessMarketingAccountManageView extends JPanel{
	private static final long serialVersionUID = 1L;
	private ProcessSitemanagerViewControllerService controller;
	private ProcessSitemanagerView view;
	MarketingVO marketingVO;
	ResultMessage result;

	Date date;
	String id;
	String name;
	String tel;
	String password;
	ImageIcon background;
	MyLabel idLabel;
	MyLabel nameLabel;
	MyLabel telLabel;
	MyLabel passwordLabel;
	JLabel currentImgLabel;
	// 右边的显示具体网站管理人员的id
	MyLabel marketingIdLabel;
	MyTextField marketingName;
	MyTextField marketingTel;
	MyTextField marketingPassword;
	// 搜索框
	SearchButton searchButton;
	JTextField searchBarText;
	// 工具栏区
	ModifyButton modifyButton;
	DeleteButton deleteButton;
	AddButton addButton;
	
	CheckButton checkModifyButton;
	CheckButton checkAddButton;

	// 放网站营销人员头像的label
	MarketingIconLabel marketingIconLabel;

	// 状态栏
	MyLabel conditionalText;

	// 修改后的新信息
	String newTel;
	String newPassword;
	MarketingVO newMarketingVO;
	
	// 新增加的账户的信息
	String addName;
	String addTel;
	String addPassword;
	MarketingVO addMarketingVO;

	public ProcessMarketingAccountManageView(ProcessSitemanagerViewControllerService controller,ProcessSitemanagerView processSitemanagerView){
		this.controller=controller;
		this.view=processSitemanagerView;
		this.setBounds(275,81,702,502);
		this.setLayout(null);
		background=new ImageIcon("src/main/resource/picture/sitemanager/marketingAccountManage.png");
		// 搜索按钮
		searchButton=new SearchButton(530,20,40,40);
		// 搜索区域
		searchBarText=new JTextField();
		searchBarText.setBounds(210,17,275,40);
		searchBarText.setFont(new java.awt.Font("微软雅黑",  1,  20));
		searchBarText.setOpaque(false);
		searchBarText.setBorder(new EmptyBorder(0,0,0,0));
		searchButton.addMouseListener(new SearchListener());
		// 状态栏
		conditionalText=new MyLabel(80,450,500,40,"");
		conditionalText.setForeground(Color.white);
		// 右边工具栏
		modifyButton=new ModifyButton(618,180,50,50);;
		deleteButton=new DeleteButton(610,240,65,65);
		addButton=new AddButton(612,310,65,65);
		// 确认修改信息按钮 
		checkModifyButton=new CheckButton(400,340,55,55);
		// 确认添加信息按钮 
		checkAddButton=new CheckButton(400,340,55,55);
		// 账户信息
		idLabel=new MyLabel(300,160,60,40,"帐号：");
		nameLabel=new MyLabel(300,200,60,40,"名字：");
		telLabel=new MyLabel(300,240,60,40,"电话：");
		passwordLabel=new MyLabel(300,280,60,40,"密码：");
		marketingIdLabel=new MyLabel(350,160,200,40,"");
		marketingName=new MyTextField(350,200,200,40,"");
		marketingName.setEnabled(true);
		marketingTel=new MyTextField(350,240,200,40,"");
		marketingTel.setEnabled(true);
		marketingPassword=new MyTextField(350,280,200,40,"");
		marketingPassword.setEnabled(true);
		// 网站营销人员头像区域
		marketingIconLabel=new MarketingIconLabel(160,200);
		// 工具栏
		modifyButton.setEnabled(false);
		deleteButton.setEnabled(false);
		// 给两个确认按钮加监听
		checkModifyButton.setVisible(false);
		checkModifyButton.addMouseListener(new MarketingModifyCheckListener());
		
		checkAddButton.setVisible(false);
		checkAddButton.addMouseListener(new MarketingAddCheckListener());
		
		// 给工具栏按钮加监听
		addButton.addMouseListener(new MarketingAddListener());
		modifyButton.addMouseListener(new MarketingModifyListener());
		deleteButton.addMouseListener(new MarketingDeleteListener());
		// 右边工具栏
		this.add(modifyButton);
		this.add(checkModifyButton);
		this.add(checkAddButton);
		this.add(deleteButton);
		this.add(addButton);
		// 主面板详细信息
		this.add(idLabel);
		this.add(nameLabel);
		this.add(telLabel);
		this.add(passwordLabel);

		this.add(marketingIdLabel);
		this.add(marketingName);
		this.add(marketingTel);
		this.add(marketingPassword);
		// 搜索栏
		this.add(searchButton);
		this.add(searchBarText);
		this.add(conditionalText);
		// 网站营销人员头像
		this.add(marketingIconLabel);
		this.setVisible(true);
		this.repaint();
		view.add(this);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		background.setImage(background.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST));
		background.paintIcon(this, g, 0, 0);
	}
	// 显示账户信息
	void showSpecificAccountInfo(MarketingVO marketingVO){
		deleteButton.setEnabled(true);
		this.setLayout(null);
		id=marketingVO.getMarketingID();
		name=marketingVO.getName();
		password=marketingVO.getPassword();
		tel=marketingVO.getTelephone();
		marketingIdLabel.setText(id);
		marketingName.setText(name);
		marketingTel.setText(tel);
		marketingPassword.setText(password);

		//checkButton.setEnabled(true);
		modifyButton.setEnabled(true);
		marketingTel.setEditable(false);
		marketingPassword.setEditable(false);
	}
	// 搜索按钮的监听
	class SearchListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			id=searchBarText.getText();
			marketingVO=controller.MarketingAccountFind(id);
			if(marketingVO==null){
				conditionalText.setText("无匹配的账户，请确认网站营销人员帐号后重新输入！");
			}
			else{
				conditionalText.setText("找到匹配账户");
				showSpecificAccountInfo(marketingVO);
			}

		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
	// 修改账户的监听
	class MarketingModifyListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			checkModifyButton.setVisible(true);
			checkAddButton.setVisible(false);
			marketingName.setEditable(false);
			marketingTel.setEditable(true);
			marketingPassword.setEditable(true);
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}

	}
	// 确认修改按钮的监听
	class MarketingModifyCheckListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			ResultMessage result;
			newTel=marketingTel.getText();
			newPassword=marketingPassword.getText();
			newMarketingVO=new MarketingVO(name,newPassword,id,newTel);
			result=controller.MarketingAccountUpdate(newMarketingVO);
			if(result==ResultMessage.SUCCESS){
				conditionalText.setText("修改成功！");
				date=new Date();
				addLog("S00000001 "+date.toString()+" 修改"+id+"账户");
			}else{
				conditionalText.setText("信息未做更改，不再进行保存！");
			}
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
	}
	
	// 确认添加按钮的监听
	class MarketingAddCheckListener implements MouseListener{


		public void mouseClicked(MouseEvent e) {
			addName=marketingName.getText();
			addTel=marketingTel.getText();
			addPassword=marketingPassword.getText();
			addMarketingVO=new MarketingVO(addName,addPassword,addTel);
			result=controller.MarketingAccountAdd(addMarketingVO);
			
			if(result==ResultMessage.SUCCESS){
				conditionalText.setText("添加账户成功！");
				date=new Date();
				addLog("S00000001 "+date.toString()+" 添加网站营销人员"+addName+"账户");
				deleteButton.setEnabled(true);
			}
			else{
				conditionalText.setText("添加账户失败! "+result);
			}
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
	// 添加账户按钮的监听
	class MarketingAddListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			deleteButton.setEnabled(false);
			marketingName.setEditable(true);
			marketingIdLabel.setText("");
			marketingName.setText("");
			marketingTel.setText("");
			marketingTel.setEditable(true);
			marketingPassword.setText("");
			marketingPassword.setEditable(true);
			checkAddButton.setVisible(true);
			checkModifyButton.setVisible(false);
			
		}
		public void mousePressed(MouseEvent e) {
		
		}
		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {		
		}
		public void mouseExited(MouseEvent e) {
		}
		
	}
	
	// 删除账户按钮的监听
	class MarketingDeleteListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			result=controller.marketingAccountDelete(new MarketingVO(id,"",""));
			if(result==ResultMessage.SUCCESS){
				conditionalText.setText("删除成功");
			}
			else{
				conditionalText.setText("删除失败！"+result);
			}
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}

		public void mouseExited(MouseEvent e) {}
	}
	public void hideMarketingAccoutManageView(){
		this.setVisible(false);
	}
	void addLog(String info){
		controller.addLog(info);
	}
	
}
