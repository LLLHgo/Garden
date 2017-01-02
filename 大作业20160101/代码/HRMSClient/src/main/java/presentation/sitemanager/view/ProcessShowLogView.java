package presentation.sitemanager.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import presentation.sitemanager.component.MyLabel;
import presentation.sitemanager.component.MyTextField;
import presentation.sitemanager.component.RefreshButton;
import presentation.sitemanager.component.SearchButton;
import vo.logVO.LogVO;

public class ProcessShowLogView extends JPanel{

	private static final long serialVersionUID = 1L;
	ProcessSitemanagerViewControllerService  controller;
	ProcessSitemanagerView view;
	
	// 背景图片
	ImageIcon background;
	// 日志背景
	ImageIcon logJTextAreaIcon;
	// 日志题头
	MyLabel logUpLabel;
	// 选择日期
	MyLabel chooseDate;
	MyLabel yearLabel;
	MyLabel monthLabel;
	MyLabel dayLabel;
	MyTextField yearField;
	MyTextField monthField;
	MyTextField dayField;
	// 搜索按钮
	SearchButton searchButton;
	
	// 中间的jtextarea部分
	ArrayList<LogVO> listVO;
	ArrayList<String> listShow;
	JTextArea logArea;
	JScrollPane jscrollPane;
	// 下面的刷新按钮
	RefreshButton refreshButton;
	// 得到日期
	String year;
	String month;
	String day;
	String currentYear;
	String currentMonth;
	String currentDay;
	
	@SuppressWarnings("deprecation")
	public ProcessShowLogView(ProcessSitemanagerViewControllerService controller,
			ProcessSitemanagerView processSitemanagerView){
		this.controller=controller;
		this.view=processSitemanagerView;
		this.setBounds(276,82,702,502);
		this.setLayout(null);
		// 背景图片
		background=new ImageIcon(this.getClass().getResource("image/showLog.png"));
		// 日志背景图片
		logJTextAreaIcon=new ImageIcon(this.getClass().getResource("image/logJTextAreaIcon.png"));
		// 刷新按钮
		refreshButton=new RefreshButton(320,443);
		refreshButton.addMouseListener(new refreshButtonListener());
		// 选择日期
		 Date dateNow=new Date();
		 String yearNow=dateNow.getYear()+1900+"";
		 String monthNow=dateNow.getMonth()+1+"";
		 String dayNow=dateNow.getDate()+"";
		 
		chooseDate=new MyLabel(200,30,100,30,"选择日期");
		yearLabel=new MyLabel(370,30,30,30,"年");
		yearField=new MyTextField(300,30,70,30, yearNow);
		yearField.setEditable(true);
		monthLabel=new MyLabel(440,30,30,30,"月");
		monthField=new MyTextField(400,30,40,30,monthNow);
		monthField.setEditable(true);
		dayLabel=new MyLabel(510,30,30,30,"日");
		dayField=new MyTextField(470,30,40,30,dayNow);
		dayField.setEditable(true);
		// 搜索按钮
		searchButton=new SearchButton(550,27,40,40);
		searchButton.addMouseListener(new SearchListener());
		
		// 中间显示日志的jtextarea
		logArea=new JTextArea(10,1);
		logArea.setFont(new java.awt.Font("华文黑体",  1,  15));
		logArea.setForeground(Color.white);
		logArea.setWrapStyleWord(true);
		logArea.setLineWrap(true);
		logArea.setOpaque(false);
		
		// 给JTextArea加滚动条
		jscrollPane = new JScrollPane(logArea);
		jscrollPane.setBounds(46, 78, 810, 365);
		jscrollPane.getViewport().setOpaque(false);
		jscrollPane.setBorder(new EmptyBorder(0,0,0,0));
		jscrollPane.setOpaque(false); 
		
		// 装有textArea背景图片的panel
		JPanel backdrop = new JPanel() {
			private static final long serialVersionUID = 1L;
			{
				this.setOpaque(false);
				this.setLayout(new BorderLayout());
			}
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				logJTextAreaIcon.setImage(logJTextAreaIcon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST));
				logJTextAreaIcon.paintIcon(this, g, 0, 0);
			}
		};
		// 将滚动组件加入
		backdrop.add(jscrollPane);
		
		// 日志抬头
		logUpLabel=new MyLabel(100,30,100,30,"日志");
		logUpLabel.setFont(new java.awt.Font("楷体",  1,  25));
		
		this.add(backdrop);
		this.add(logUpLabel);
		this.add(jscrollPane);
		this.add(refreshButton);
		this.add(searchButton);
		this.add(chooseDate);
		this.add(dayLabel);
		this.add(monthLabel);
		this.add(yearLabel);
		this.add(dayField);
		this.add(monthField);
		this.add(yearField);
		this.repaint();
		view.add(this);
		
		listVO=controller.findLog(yearNow,monthNow,dayNow);
		if(listVO!=null)
			showLog(listVO);
		
	}
	public void showLog(ArrayList<LogVO> list){
		
		logArea.setText("");
		listShow=new ArrayList<String>();
		for(int i=list.size()-1;i>=0;i--){
			listShow.add(list.get(i).getLogInfo());
		}
		for(int i=0;i<listShow.size();i++){
			logArea.append(listShow.get(i)+'\n');
		}
		logArea.setEditable(false);
		
	}
	
	class refreshButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			//logArea.setText("");
			listVO.clear();
			year=yearField.getText();
			month=monthField.getText();
			day=dayField.getText();
			listVO=controller.findLog(year, month, day);
			showLog(listVO);	
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
	class SearchListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			year=yearField.getText();
			month=monthField.getText();
			day=dayField.getText();
			currentYear=year;
			currentMonth=month;
			currentDay=day;
			listVO.clear();
			listVO=controller.findLog(year, month, day);
			logArea.setText("");
			showLog(listVO);
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
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		background.setImage(background.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST));
		background.paintIcon(this, g, 0, 0);
	}
}
