package presentation.client.compoment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import presentation.client.controller.EvaluatePanelController;



/**
 * 评价frame类，显示评价酒店的界面，提供评价酒店的操作
 * @author ClaraLee
 *
 */

public class EvaluateFrame extends JFrame{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	ePanel panel;
	JFrame frame;
	String clientID;
	String hotelID;
	Label hint;
	JButton okButton;
	private EvaluatePanelController controller;
public EvaluateFrame(String clientID,String hotelID,EvaluatePanelController controller){
	this.controller=controller;
	this.clientID=clientID;
	this.hotelID=hotelID;
	panel=new ePanel();
	frame=this;
	hint=new Label("");
	hint.setBounds(200,250,150,30);
	this.add(hint);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.add(panel);
	this.setLocationRelativeTo(null);
	this.setLayout(null);
	this.setVisible(true);
	this.setResizable(false);
	this.setSize(500, 309);
	this.setLocation(500,200);


}
class Label extends JLabel{
	private static final long serialVersionUID = 1L;
	public Label(String str){
		super(str);
		java.awt.Font f=new java.awt.Font("微软雅黑", 4,  20);
		this.setFont(f);
		this.setForeground(Color.WHITE);

	}
}
class ePanel extends JPanel{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextArea text;

	private ImageIcon imageIcon = null;
	private Label hintLabel;
	private checkbutton s1;
	private checkbutton s2;
	private checkbutton s3;
	private checkbutton s4;
	private checkbutton s5;
	private ButtonGroup box;
	private boolean flag=true;
	public ePanel(){
		okButton = new JButton();
		okButton.setIcon(new ImageIcon(this.getClass().getResource("image/evaluateConfirm.png")));
		okButton.setBounds(80,250,100,24);
		okButton.setOpaque(true);
		okButton.setContentAreaFilled(false);
		okButton.setBorderPainted(false);
		okButton.setFocusPainted(false);
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				int star=0;
				if(s1.isSelected())
					star=1;
				if(s2.isSelected())
					star=2;
				if(s3.isSelected())
					star=3;
				if(s4.isSelected())
					star=4;
				if(s5.isSelected())
					star=5;
				String et=text.getText();
				if(et.equals("")||et.equals("请为此次酒店入住体验打分～"))
					et="无评价";
				boolean k=controller.setEvaluate(star,et,clientID,hotelID);
				if(k)
				new Thread(new Runnable(){
					@Override
					public void run() {
						hint.setText("评价成功");
						try {
							Thread.sleep(1500);
							frame.dispose();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}).start();
			else hint.setText("评价失败！");

			}});
		this.add(okButton);

		text=new JTextArea("请写下自己对此行的评语：");
		text.setBounds(265,90,200,160);
		text.setOpaque(false);
		text.setFont(new java.awt.Font("微软雅黑", 4,  15));
		text.setForeground(Color.WHITE);
		text.setLineWrap(true);
		text.addMouseListener(new mouseListener());
		this.add(text);
		imageIcon = new ImageIcon(this.getClass().getResource("image/evaluateFrame.png"));
		hintLabel=new Label("请为此次酒店入住体验打分～",80,20,350,30);

		box=new ButtonGroup();
		s5=new checkbutton("五星 好评～",60);
		s4=new checkbutton("四星 还不错～",100);
		s3=new checkbutton("三星 一般～",140);
		s2=new checkbutton("二星 很有待改善～",180);
		s1=new checkbutton("一星 再也不来了～",220);

		box.add(s5);
		box.add(s4);
		box.add(s3);
		box.add(s2);
		box.add(s1);

		this.add(s5);
		this.add(s4);
		this.add(s3);
		this.add(s2);
		this.add(s1);

		this.add(hintLabel);
		this.setLayout(null);
	    this.setBounds(0,0,500,309);
	    this.setOpaque(false);
	    this.setVisible(true);
	    this.repaint();

	}
	class mouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		if(flag)
			text.setText("");
		flag=false;
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
	class checkbutton extends JRadioButton{
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		public checkbutton(String str,int y){
			super(str,true);
			this.setBounds(30,y,350,30);
			this.setFont(new java.awt.Font("微软雅黑", 4,  20));
			this.setForeground(Color.WHITE);
		}
	}
	class Label extends JLabel{
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		public Label(String str,int x,int y,int w,int h){
			super(str);
			java.awt.Font f=new java.awt.Font("微软雅黑", 4,  25);
			this.setFont(f);
			this.setForeground(Color.WHITE);
			this.setBounds(x,y,w,h);
		}
	}
	@Override
	public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }
}
}
