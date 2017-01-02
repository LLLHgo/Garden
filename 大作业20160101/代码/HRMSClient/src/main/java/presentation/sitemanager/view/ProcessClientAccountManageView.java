package presentation.sitemanager.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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
import Enum.VIPType;
import presentation.common.ClientIconLabel;
import presentation.common.CreditFrame;
import presentation.sitemanager.component.CheckButton;
import presentation.sitemanager.component.CreditButton;
import presentation.sitemanager.component.DeleteButton;
import presentation.sitemanager.component.ModifyButton;
import presentation.sitemanager.component.MyLabel;
import presentation.sitemanager.component.MyPasswordField;
import presentation.sitemanager.component.MyTextField;
import presentation.sitemanager.component.SearchButton;
import vo.clientVO.ClientVO;

public class ProcessClientAccountManageView extends JPanel{

	private static final long serialVersionUID = 1L;
	private ProcessSitemanagerViewControllerService controller;
	private ProcessSitemanagerView view;
	ClientVO clientVO=null;
	Date date;
	ResultMessage result;
	String id;
	String name;
	String tel;
	VIPType viptype;
	int vipgrade;
	String birth;
	int credit;
	String password;
	// 信用值列表 图标及信用记录窗体
	CreditButton creditIconButton;
	CreditFrame creditFrame;
	// 左边的label
	MyLabel idLabelL;
	MyLabel nameLabelL;
	MyLabel telLabelL;
	MyLabel viptypeLabelL;
	MyLabel vipgradeLabelL;
	MyLabel birthLabelL;
	MyLabel firmLabelL;
	MyLabel creditLabelL;
	MyLabel passwordLabelL;
	
	// 右边的显示具体网站管理人员的id  只改客户的电话
	MyLabel clientIdLabel;
	MyLabel nameText;
	MyTextField telText;
	MyLabel viptypeLabel;
	MyLabel vipgradeLabel;
	MyLabel birthLabel;
	MyLabel firmLabel;
	MyLabel creditLabel;
	MyPasswordField passwordText;
	
	// 设置右边工具栏图标
	ModifyButton modifyButton;
	CheckButton checkButton;
	DeleteButton deleteButton;
	
	// 客户头像
	ClientIconLabel clientIconLabel;
	
	// 搜索框
	SearchButton searchButton;
	JTextField searchText;
	
	// 状态栏
	MyLabel conditionLabel;
	
	// 背景图片
	private ImageIcon background;
	
	public ProcessClientAccountManageView(ProcessSitemanagerViewControllerService controller,ProcessSitemanagerView processSitemanagerView){
		this.controller=controller;
		this.view=processSitemanagerView;
		this.setBounds(277,79,702,502);
		this.setLayout(null);
		// 设置背景图片
		background=new ImageIcon(this.getClass().getResource("image/clientAccountManage.png"));
		this.setBounds(276,82,702,502);
		// 搜索按钮
		searchButton=new SearchButton(530,20,40,40);
		// 搜索区域
		searchText=new JTextField();
		searchText.setBounds(210,17,275,40);
		searchText.setFont(new java.awt.Font("楷体",Font.ITALIC,25));
		searchText.setOpaque(false);
		searchText.setBorder(new EmptyBorder(0,0,0,0));
		searchButton.addMouseListener(new SearchListener());		
		// 状态栏
		conditionLabel=new MyLabel(80,450,500,40,"");
		conditionLabel.setForeground(Color.white);
		// 右边工具栏
		modifyButton=new ModifyButton(618,180,50,50);
		checkButton=new CheckButton(610,240,65,65);
		deleteButton=new DeleteButton(612,310,65,65);
		modifyButton.addMouseListener(new ModifyMouseListener());
		deleteButton.addMouseListener(new DeleteMouseListener());
		checkButton.addMouseListener(new CheckButtonListener());
		modifyButton.setEnabled(false);
		checkButton.setEnabled(false);
		deleteButton.setEnabled(false);
		// 账户头像区域
		clientIconLabel=new ClientIconLabel(160,200);
		// 账户信息区域
		idLabelL=new MyLabel(300,130,60,25,"帐号：");
		nameLabelL=new MyLabel(300,160,60,25,"名字：");
		telLabelL=new MyLabel(300,190,100,25,"电话：");
		viptypeLabelL=new MyLabel(300,220,100,25,"会员种类：");
		vipgradeLabelL=new MyLabel(300,250,100,25,"会员等级：");
		birthLabelL=new MyLabel(300,280,60,25,"生日：");
		firmLabelL=new MyLabel(300,310,100,25,"公司：");
		creditLabelL=new MyLabel(300,340,100,25,"信用值：");
		passwordLabelL=new MyLabel(300,370,60,25,"密码:");
		
		clientIdLabel=new MyLabel(400,130,180,25,"");
		nameText=new MyLabel(400,160,180,25,"");
		telText=new MyTextField(400,190,160,25,"");
		telText.setBorder(new EmptyBorder(0,0,0,0));
		telText.setForeground(Color.white);
		viptypeLabel=new MyLabel(400,220,180,25,"");
		vipgradeLabel=new MyLabel(400,250,180,25,"");
		birthLabel=new MyLabel(400,280,180,25,"");
		firmLabel=new MyLabel(400,310,180,25,"");
		creditLabel=new MyLabel(400,340,180,25,"");
		passwordText=new MyPasswordField(400,370,180,25,"");
		passwordText.setBorder(new EmptyBorder(0,0,0,0));
		passwordText.setForeground(Color.white);
		
		creditIconButton=new CreditButton(240,320);
		creditIconButton.addMouseListener(new ShowCreditListener());
		
		this.add(searchButton);
		this.add(searchText);
		this.add(conditionLabel);
		this.add(modifyButton);
		this.add(checkButton);
		this.add(deleteButton);
		this.add(clientIconLabel);
		this.add(creditIconButton);
		this.add(idLabelL);  this.add(nameLabelL);  this.add(telLabelL); this.add(viptypeLabelL); this.add(vipgradeLabelL);
		this.add(birthLabelL); this.add(creditLabelL); this.add(passwordLabelL); this.add(firmLabelL);
		
		this.add(clientIdLabel);  this.add(nameText); this.add(telText); this.add(viptypeLabel);
		this.add(vipgradeLabel);   this.add(birthLabel); this.add(creditLabel);  this.add(passwordText);this.add(firmLabel);
		this.repaint(); 
		view.add(this);
	}
	void showSpecificAccountInfo(ClientVO clientVO){
		id=clientVO.getID();
		clientIdLabel.setText(clientVO.getID());
		nameText.setText(clientVO.getName());
		telText.setText(clientVO.getTel());
		telText.setBorder(new EmptyBorder(0,0,0,0));
		viptypeLabel.setText(clientVO.getType()+"");
		vipgradeLabel.setText(clientVO.getLevel()+"");
		if(clientVO.getFirm()!=null||!clientVO.getFirm().equals("")){
			firmLabel.setText(clientVO.getFirm());
		}
		else{ 
			firmLabel.setText("--");
		}
		if(clientVO.getBirth()!=null||!clientVO.getBirth().equals("")){
			birthLabel.setText(clientVO.getBirth());
		}
		else{ 	
			birthLabel.setText("--");
		}
		creditLabel.setText(clientVO.getCredit()+"");
		passwordText.setText(clientVO.getPassword());
		creditIconButton.setEnabled(true);
		deleteButton.setEnabled(true);
		modifyButton.setEnabled(true);
	}
	
	
	class ShowCreditListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			creditFrame=new CreditFrame(clientVO.getCreditRecord());
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
	class SearchListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			deleteButton.setEnabled(false);
			checkButton.setEnabled(false);
			modifyButton.setEnabled(false);
			telText.setEditable(false);
			clientIdLabel.setText("");
			nameText.setText("");
			telText.setText("");
			
			vipgradeLabel.setText("");
			viptypeLabel.setText("");
			birthLabel.setText("");
			firmLabel.setText("");
			creditLabel.setText("");
			passwordText.setText("");
			id=searchText.getText();
			creditIconButton.setEnabled(false);
			clientVO=controller.clientAccountFind(id);
			if(clientVO==null){
				conditionLabel.setText("无匹配的账户，请确认帐号后重新输入！");
			}
			else{
				conditionLabel.setText("找到匹配账户");
				showSpecificAccountInfo(clientVO);
				deleteButton.setEnabled(true);
				modifyButton.setEnabled(true);
				creditIconButton.setEnabled(true);
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

	class DeleteMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			result=controller.clientAccountDelete(id);
			modifyButton.setEnabled(false);
			if(result==ResultMessage.SUCCESS){
				conditionLabel.setText("删除成功！");
				deleteButton.setEnabled(false);
				checkButton.setEnabled(false);
				modifyButton.setEnabled(false);
				telText.setEditable(false);
				clientIdLabel.setText("");
				nameText.setText("");
				telText.setText("");
				vipgradeLabel.setText("");
				viptypeLabel.setText("");
				birthLabel.setText("");
				firmLabel.setText("");
				creditLabel.setText("");
				passwordText.setText("");
				creditIconButton.setEnabled(false);
				
			}
			else if(result==ResultMessage.DATEBASEFAIL){
				conditionLabel.setText("数据库中删除失败！");
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

	class CheckButtonListener implements MouseListener{
		String telModify;
        ClientVO newClientVO;
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			telModify=telText.getText();
			if(telModify==""||telModify.equals("")){
				conditionLabel.setText("电话为空，请输入电话");
			}
			else if(!isNumeric(telModify)){
				conditionLabel.setText("电话请确认是否全为数字，重新输入电话");	
			}
			else if(telModify.length()!=11){
				conditionLabel.setText("电话位数不对，请重新输入电话");
			}
			else{
				
			newClientVO=new ClientVO(clientVO.getID(),clientVO.getPassword(),clientVO.getName(),telModify
					,clientVO.getType(),clientVO.getLevel(),clientVO.getBirth(),clientVO.getFirm(),
					clientVO.getCredit(),clientVO.getCreditRecord());
			result=controller.clientAccountUpdate(newClientVO);
			if(result==ResultMessage.SUCCESS){
				conditionLabel.setText("保存成功！");
				telText.setEditable(false);
				telText.setBorder(new EmptyBorder(0,0,0,0));
				telText.setForeground(Color.white);
				telText.setOpaque(false);
				date=new Date();
				addLog("S00000001 "+date.toString()+" 修改"+clientVO.getID()+"账户");
			}
			else if(result==ResultMessage.DATEBASEFAIL){
				conditionLabel.setText("数据库存储失败！");
			}
			
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
	
	class ModifyMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			checkButton.setEnabled(true);
			telText.setEditable(true);
			telText.setBorder(new EmptyBorder(3,3,3,3));
			telText.setOpaque(true);
			telText.setForeground(Color.DARK_GRAY);
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
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		background.setImage(background.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST));
		background.paintIcon(this, g, 0, 0);
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

