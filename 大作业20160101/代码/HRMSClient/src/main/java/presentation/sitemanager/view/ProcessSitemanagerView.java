package presentation.sitemanager.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.common.GuideBoardButton;
import presentation.common.SitemanagerIconLabel;
import presentation.sitemanager.component.MyLabel;
import vo.sitemanagerVO.SitemanagerVO;

public class ProcessSitemanagerView extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private ProcessSitemanagerViewControllerService controller;
	// 左上区域 网站管理人员账户信息
	private MyLabel currentUserIdLabel;
	private SitemanagerIconLabel sitemanagerIconLabel;
	private ImageIcon backgroundImage;
	SitemanagerVO currentSitemanagerUserVO;
	String currentUserId;
	// 左下区域 导航栏
	private GuideBoardButton jbClientManage;
	private GuideBoardButton jbHotelManage;
	private GuideBoardButton jbMarktingManage;
	private GuideBoardButton jbSitemanagerManage;
	private GuideBoardButton jbShowLog;
	private GuideBoardButton jbExit;
	// 右主区域界面1:欢迎界面  JLabel实现
	private JLabel welComeLabel;
	Icon welcomeIcon;
	// 右主区域界面2:个人账户管理
	public ProcessSitemanagerAccountManageView sitemanagerAccountManageView;
	// 右主区域界面2:网站营销人员账户管理
	public ProcessMarketingAccountManageView marketingAccountManageView;
	
	public SitemanagerVO sitemanagerVO;

	public ProcessSitemanagerView(ProcessSitemanagerViewControllerService controller){
		backgroundImage=new ImageIcon(this.getClass().getResource("image/accountManageBackground.png"));
		this.controller=controller;
		this.setLayout(null);
		this.setLocation(0, 0);
		this.setSize(1000, 618);
		this.setVisible(true);
		setOpaque(false);
		// 得到左上角网站管理人员账户信息
		currentUserId=controller.getSitemanagerId();
		currentSitemanagerUserVO=controller.init();
		
		currentUserIdLabel=new MyLabel(60,190,200,40,"ID: "+currentUserId);
		currentUserIdLabel.setForeground(Color.white);
		
		sitemanagerIconLabel=new SitemanagerIconLabel(90, 90);
		
		// 得到导航栏的按钮
		jbClientManage=new GuideBoardButton(241,"用户账户管理");
		jbHotelManage=new GuideBoardButton(299,"酒店账户管理");
		jbMarktingManage=new GuideBoardButton(357,"网营账户管理");
		jbSitemanagerManage=new GuideBoardButton(414,"个人账户管理");
		jbShowLog=new GuideBoardButton(471,"查看日志");
		jbExit=new GuideBoardButton(528,"退出");
		
		// 初始化时设置显示welcome
		welComeLabel=new JLabel();
		//275,-19,775,800
		welComeLabel.setBounds(276,-19,775,800);
		welcomeIcon=new ImageIcon(this.getClass().getResource("image/welcomeIcon.png"));
		welComeLabel.setIcon(welcomeIcon);
		
		this.add(currentUserIdLabel);
		this.add(sitemanagerIconLabel);
		this.add(jbClientManage);
		this.add(jbHotelManage);
		this.add(jbMarktingManage);
		this.add(jbSitemanagerManage);
		this.add(jbShowLog);
		this.add(jbExit);
		this.add(welComeLabel);
		
		// 网站管理人员账户加监听
		jbSitemanagerManage.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				controller.jbSitemanagerManageButtonClicked();
			}

			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}	
		});
		
		jbMarktingManage.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				controller.jbMarketingManageButtonClicked();
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		

		jbClientManage.addMouseListener(new  MouseListener(){

			public void mouseClicked(MouseEvent e) {
				controller.jbClientManageButtonClicked();
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		
		jbHotelManage.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				controller.jbHotelManageButtonClicked();
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		jbExit.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				controller.jbExitButtonClicked();
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			
		});
		
		jbShowLog.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				controller.jbShowLogButtonClicked();
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		
		this.setVisible(true);
	}
	
	
	
	// 大框架界面 ：包括左上logo，左边导航栏的矩形框架、右边主界面
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		backgroundImage.setImage(backgroundImage.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST));
		backgroundImage.paintIcon(this, g, 0, 0);
	}
	
	 public void hideWelcome(){
		 welComeLabel.setVisible(false);
	 }
}
	

