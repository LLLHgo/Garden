package presentation.sitemanager.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Enum.ResultMessage;
import presentation.common.SitemanagerIconLabel;
import presentation.sitemanager.component.AddButton;
import presentation.sitemanager.component.CheckButton;
import presentation.sitemanager.component.ModifyButton;
import presentation.sitemanager.component.MyLabel;
import presentation.sitemanager.component.MyPasswordField;
import presentation.sitemanager.component.MyTextField;
import vo.sitemanagerVO.SitemanagerVO;

public class ProcessSitemanagerAccountManageView extends JPanel{
	private static final long serialVersionUID = 1L;
	private ProcessSitemanagerViewControllerService controller;
	private ProcessSitemanagerView view;
	ResultMessage result;
	Date date;
	String id;
	String tel;
	String password;
	MyLabel idLabel;
	MyLabel telLabel;
	MyLabel passwordLabel;
	MyLabel idTextLabel;
	MyTextField telField;
	JPasswordField passWordField;
	ModifyButton modifyButton;
	AddButton addButton;
	CheckButton checkButton;
	MyLabel conditionalLabel;

	// 主菜单界面的账户头像
	SitemanagerIconLabel sitemanagerIconLabel;
	
	ImageIcon img=new ImageIcon(this.getClass().getResource("image/sitemanagerAccountShow.png"));
	
	public  ProcessSitemanagerAccountManageView(ProcessSitemanagerViewControllerService controller
		,ProcessSitemanagerView processSitemanagerView,SitemanagerVO sitemanagerVO){
		this.controller=controller;
		this.view=processSitemanagerView;
		
		this.setLayout(null);
		this.controller=controller;
		// 账户信息显示区域
		id=sitemanagerVO.getSitemanagerId();
		tel=sitemanagerVO.getSitemanagerPhoneNumber();
		password=sitemanagerVO.getPassword();
		idLabel=new MyLabel(300, 200, 60, 40,"帐号:");
		telLabel=new MyLabel(300,245,60,40,"电话:");
		passwordLabel=new MyLabel(300, 290, 100, 40,"密码:");
		idTextLabel=new MyLabel(350,200,150,40,id);
		telField=new MyTextField(350,245,200,40,tel);
		telField.setBorder(new EmptyBorder(0,0,0,0));
		telField.setForeground(Color.white);
		passWordField=new MyPasswordField(350,290,200,40,password);
		passWordField.setForeground(Color.white);
		passWordField.setBorder(new EmptyBorder(0,0,0,0));
		modifyButton=new ModifyButton(620,180,50,50);
		checkButton=new CheckButton(618,280,55,55);
		// 设置状态栏
		conditionalLabel=new MyLabel(80,450,350,40,"");
		conditionalLabel.setForeground(Color.white);
		// 设置右边主菜单的账户头像
		sitemanagerIconLabel=new SitemanagerIconLabel(160,200);
		// 给修改、确认按钮加监听
		modifyButton.addMouseListener(new ModifyListener());
		checkButton.addMouseListener(new CheckListener());
		
		this.add(idLabel);
		this.add(telLabel);
		this.add(passwordLabel);
		this.add(idTextLabel);
		this.add(telField);
		this.add(passWordField);
		this.add(modifyButton);
		this.add(checkButton);
		this.add(conditionalLabel);
		this.add(sitemanagerIconLabel);
		this.setVisible(true);
		this.setBounds(276,82,702,502);
		this.repaint();
		view.add(this);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		img.setImage(img.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST));
		img.paintIcon(this, g, 0, 0);
	}
	
	class ModifyListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			telField.setEditable(true);
			telField.setOpaque(true);
			telField.setForeground(Color.DARK_GRAY);
			passWordField.setEditable(true);
			passWordField.setOpaque(true);
			passWordField.setForeground(Color.DARK_GRAY);
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}		
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
	
	class CheckListener implements MouseListener{
		String newTel;
		String newPassword;
		ImageIcon newImg;
		SitemanagerVO newSitemanagerVO;
		ResultMessage result;
		public void mouseClicked(MouseEvent e) {
			newTel=telField.getText();
			newPassword=passWordField.getText();
			newSitemanagerVO=new SitemanagerVO(id,newTel,newPassword);
			if(!isNumeric(newTel)){
				conditionalLabel.setText("请确认电话中是否全为数字，重新输入电话！");
			}
			else if(newTel.length()!=11){
				conditionalLabel.setText("电话位数不对，请重新输入电话！");
			}
			else{
			result=controller.sitemanagerAccountUpdate(newSitemanagerVO);
			if(result==ResultMessage.SUCCESS){
				conditionalLabel.setText("保存成功！");
				telField.setEditable(false);
				telField.setForeground(Color.white);
				telField.setOpaque(false);
				passWordField.setEditable(false);
				passWordField.setForeground(Color.white);
				passWordField.setOpaque(false);
				date = new Date();
				addLog("S00000001 "+date.toString()+" 修改网站管理人员账户");
			}
			else if(result==ResultMessage.VOIDINFO){
				conditionalLabel.setText("电话和密码为空，请填写后再确认！");
			}
			else if(result==ResultMessage.VOIDPASSWORD){
				conditionalLabel.setText("密码为空，请填写后再确认！");
			}
			else if(result==ResultMessage.VOIDTEL){
				conditionalLabel.setText("电话为空，请填写后再确认！");
			}
			else{
				conditionalLabel.setText("数据库保存失败，请联系服务人员！");
			}
			
			}
			
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
	
	void addLog(String info){
		result=controller.addLog(info);
	}
	
	public void hideSitemanagerAccountManageView(){
		this.setVisible(false);
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
