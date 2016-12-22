package presentation.client.compoment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;





public class EvaluateFrame extends JFrame{
	Panel panel;
	JFrame frame;

public EvaluateFrame(){
	panel=new Panel();
	frame=this;
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.add(panel);
	this.setLocationRelativeTo(null);
	this.setLayout(null);
	this.setVisible(true);
	this.setResizable(false);
	this.setSize(500, 309);
	this.setLocation(500,200);


}
class Panel extends JPanel{
	JTextArea text;
	private JButton okButton;
	private ImageIcon imageIcon = null;
	private Label hintLabel;
	private checkbutton s1;
	private checkbutton s2;
	private checkbutton s3;
	private checkbutton s4;
	private checkbutton s5;
	private ButtonGroup box;
	private boolean flag=true;
	public Panel(){
		okButton = new JButton();
		okButton.setIcon(new ImageIcon("image/evaluateConfirm.png"));
		okButton.setBounds(80,250,100,24);
		okButton.setOpaque(true);
		okButton.setContentAreaFilled(false);
		okButton.setBorderPainted(false);
		okButton.setFocusPainted(false);
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}

		});
		this.add(okButton);

		text=new JTextArea("请写下自己对此行的评语：");
		text.setBounds(265,90,200,160);
		text.setOpaque(false);
		text.setFont(new java.awt.Font("微软雅黑", 4,  15));
		text.setForeground(Color.WHITE);
		text.setLineWrap(true);
		text.addMouseListener(new mouseListener());
		this.add(text);
		imageIcon = new ImageIcon("image/evaluateFrame.png");
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
		public checkbutton(String str,int y){
			super(str,true);
			this.setBounds(30,y,350,30);
			this.setFont(new java.awt.Font("微软雅黑", 4,  20));
			this.setForeground(Color.WHITE);
		}
	}
	class Label extends JLabel{
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
