package presentation.client.compoment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentation.DialogCreator;
import presentation.client.controller.PersonalPanelController;
import presentation.common.CreditFrame;
import vo.clientVO.ClientVO;


public class PersonalPanel extends JPanel{
	private ImageIcon imageIcon = null;
	private JTextField nameField;
	private JTextField telField;
	private Label idLabel;
	private Label nameLabel;
	private Label telLabel;
	private Label vipLabel;
	private Label creditLabel;
	private okButton ok;
	private deleteButton delete;
	private creditButton cb;
	private editButton editName;
	private editButton editTel;
	private PersonalPanelController controller;
	private ArrayList<String> credits;
	private ClientVO vo;
	public PersonalPanel(String clientID,PersonalPanelController controller){
		this.controller=controller;
		vo=controller.getclient(clientID);
		credits=vo.getCreditRecord();
		java.awt.Font f=new java.awt.Font("微软雅黑", 4,  25);
		cb=new creditButton();
		cb.addActionListener(new creditButtonListener());
		imageIcon = new ImageIcon("image/personalPanel.png");
		idLabel=new Label("ID:"+clientID);
		idLabel.setBounds(250,170,200,30);
		nameField=new Field(vo.getName(),200,220,100,35);
		telField=new Field(vo.getTel(),200,270,200,35);
		nameLabel=new Label("姓名：");
		nameLabel.setBounds(120,220,100,30);
		ok=new okButton(500,150);
		ok.addActionListener(new okButtonListener());
		delete=new deleteButton(520,270);
		delete.addActionListener(new deleteButtonListener());
		editName=new editButton(320,220);
		editName.addActionListener(new editNameButtonListener());
		telLabel=new Label("电话：");
		telLabel.setBounds(120,270,100,30);
		editTel=new editButton(420,270);
		editTel.addActionListener(new editTelButtonListener());
		vipLabel=new Label("会员类型：非会员");
		vipLabel.setBounds(120,320,200,30);
		creditLabel=new Label("信用值："+vo.getCredit());
		creditLabel.setBounds(120,370,150,30);
		this.add(idLabel);
		this.add(nameLabel);
		this.add(nameField);
		this.add(telLabel);
		this.add(telField);
		this.add(vipLabel);
		this.add(creditLabel);
		this.add(cb);
		this.add(ok);
		this.add(delete);
		this.add(editName);
		this.add(editTel);
		this.setVisible(false);
	    this.setLayout(null);
	    this.setSize(704, 502);
	    this.setOpaque(false);
	}
	class Field extends JTextField{
		public Field(String str,int x,int y,int w,int h){
			super(str);
			java.awt.Font f=new java.awt.Font("微软雅黑", 4,  25);
			this.setFont(f);
			this.setForeground(Color.WHITE);
			this.setBorder(new EmptyBorder(0,0,0,0));
			this.setBounds(x,y,w,h);
			this.setOpaque(false);
			this.setFocusable(false);

		}
	}
	class Label extends JLabel{
		public Label(String str){
			super(str);
			java.awt.Font f=new java.awt.Font("微软雅黑", 4,  25);
			this.setFont(f);
			this.setForeground(Color.WHITE);

		}
	}
	 class creditButton extends JButton{
		ImageIcon icon;
		public creditButton(){
		icon=new ImageIcon("image/creditButton.png");
		this.setIcon(icon);
		this.setOpaque(true);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setBounds(270,350,60,60);
		}
	}
	 private class okButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vo.setName(nameField.getText());
				vo.setTel(telField.getText());
				boolean k=controller.updateInfo(vo);
				if(k)DialogCreator.successDialog("suceess");
				else DialogCreator.failDialog("fail");
				nameField.setOpaque(false);
				nameField.setFocusable(false);
				nameField.setForeground(Color.WHITE);
				telField.setOpaque(false);
				telField.setFocusable(false);
				telField.setForeground(Color.WHITE);

			}

		}
	 private class deleteButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nameField.setText(vo.getName());
				telField.setText(vo.getTel());
				nameField.setOpaque(false);
				nameField.setFocusable(false);
				nameField.setForeground(Color.WHITE);
				telField.setOpaque(false);
				telField.setFocusable(false);
				telField.setForeground(Color.WHITE);

			}

		}
	 private class editNameButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nameField.setOpaque(true);
				nameField.setForeground(Color.BLACK);
				nameField.setFocusable(true);
			}

		}
	 private class editTelButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				telField.setOpaque(true);
				telField.setForeground(Color.BLACK);
				telField.setFocusable(true);


			}

		}
	 private class creditButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CreditFrame(credits);


			}

		}
	@Override
	public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }
}
