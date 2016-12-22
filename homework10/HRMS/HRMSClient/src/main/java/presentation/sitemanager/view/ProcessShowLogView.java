package presentation.sitemanager.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import presentation.sitemanager.component.MyLabel;
import presentation.sitemanager.component.RefreshButton;
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
	// 中间的jtextarea部分
	ArrayList<LogVO> listVO;
	ArrayList<String> listShow;
	JTextArea logArea;
	JScrollPane jscrollPane;
	// 下面的刷新按钮
	RefreshButton refreshButton;
	
	public ProcessShowLogView(ProcessSitemanagerViewControllerService controller,
			ProcessSitemanagerView processSitemanagerView){
		this.controller=controller;
		this.view=processSitemanagerView;
		this.setBounds(277,79,702,502);
		this.setLayout(null);
		// 背景图片
		background=new ImageIcon("src/main/resource/picture/sitemanager/showLog.png");
		// 日志背景图片
		logJTextAreaIcon=new ImageIcon("src/main/resource/picture/sitemanager/logJTextAreaIcon.png");
		// 刷新按钮
		refreshButton=new RefreshButton(320,443);
		refreshButton.addMouseListener(new refreshButtonListener());
		// 中间显示日志的jtextarea
		logArea=new JTextArea(10,1);
		logArea.setFont(new java.awt.Font("华文黑体",  1,  20));
		logArea.setForeground(Color.black);
		logArea.setWrapStyleWord(true);
		logArea.setLineWrap(true);
		logArea.setOpaque(false);
		
		// 给JTextArea加滚动条
		jscrollPane = new JScrollPane(logArea);
		jscrollPane.setBounds(46, 78, 610, 365);
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
		logUpLabel=new MyLabel(310,30,100,30,"日志");
		logUpLabel.setFont(new java.awt.Font("华文黑体",  1,  25));
		
		this.add(backdrop);
		this.add(logUpLabel);
		this.add(jscrollPane);
		this.add(refreshButton);
		this.repaint();
		view.add(this);
		
		showLog();
	}
	public void showLog(){
		listShow=new ArrayList<String>();
		listVO=controller.findLog();
		for(int i=listVO.size()-1;i>=0;i--){
			listShow.add(listVO.get(i).getLogInfo());
		}
		for(int i=0;i<listShow.size();i++){
			logArea.append(listShow.get(i)+'\n');
		}
	}
	
	class refreshButtonListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			logArea.setText("");
			showLog();
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
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		background.setImage(background.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST));
		background.paintIcon(this, g, 0, 0);
	}
}
