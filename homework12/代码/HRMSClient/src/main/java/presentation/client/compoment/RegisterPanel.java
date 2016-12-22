package presentation.client.compoment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Enum.VIPType;
import presentation.DialogCreator;
import presentation.client.compoment.PersonalPanel.Label;
import presentation.client.controller.PersonalPanelController;
import presentation.client.controller.RegisterPanelController;
import vo.clientVO.ClientVO;

public class RegisterPanel extends JPanel{
	private ImageIcon imageIcon = null;
	private okButton ok;
	private deleteButton delete;
	private Label idLabel;
	private Label nameLabel;
	private Label telLabel;
	private Label vipLabel;
	private Field firmField;
	private Field yearField;
	private Field monthField;
	private Field dayField;
	private JScrollPane scrollPane;
	private JComboBox combobox;
	private RegisterPanelController controller;
	private ClientVO vo;
	public RegisterPanel(String id,RegisterPanelController controller){
		this.controller=controller;
		vo=controller.getclient(id);
		java.awt.Font f=new java.awt.Font("微软雅黑", 4,  25);
		imageIcon = new ImageIcon("image/registerPanel.png");
		ok=new okButton(500,120);
		ok.addActionListener(new okButtonListener());
		delete=new deleteButton(510,260);
		delete.addActionListener(new deleteButtonListener());
		idLabel=new Label(id);
		idLabel.setBounds(240,123,200,30);
		nameLabel=new Label(vo.getName());
		nameLabel.setBounds(150,165,100,30);

		telLabel=new Label(vo.getTel());
		telLabel.setBounds(150,215,300,30);

		combobox=new JComboBox();
		combobox.addItem("普通会员");
		combobox.addItem("企业会员");
		combobox.setBounds(260,260,150,40);

		firmField=new Field(vo.getFirm(), 100,400, 300, 30,25);
		firmField.setBounds(225,315,220,30);

		yearField=new Field("",190,365,65,30,15);
		monthField=new Field("",290,365,35,30,15);
		dayField=new Field("",370,365,35,30,15);
		this.add(ok);
		this.add(delete);
		this.add(idLabel);
		this.add(nameLabel);
		this.add(telLabel);
		this.add(firmField);
		this.add(yearField);
		this.add(monthField);
		this.add(dayField);
		this.add(combobox);
		this.setVisible(false);
	    this.setLayout(null);
	    this.setSize(704, 502);
	    this.setOpaque(false);
	}
	class Field extends JTextField{
		public Field(String str,int x,int y,int w,int h,int big){
			super(str);
			java.awt.Font f=new java.awt.Font("微软雅黑", 4,  big);
			this.setFont(f);
			this.setForeground(Color.WHITE);
			this.setBorder(new EmptyBorder(0,0,0,0));
			this.setBounds(x,y,w,h);
			this.setOpaque(false);
			this.setFocusable(true);

		}
	}
	 private class okButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if((String)combobox.getSelectedItem()=="普通会员"){
					vo.setBirth(yearField.getText()+"-"+monthField.getText()+"-"+dayField.getText());
					vo.setType(VIPType.ORDINARYVIP);
				}
				else {
					vo.setFirm(firmField.getText());
					vo.setType(VIPType.ENTERPRISEVIP);
				}
				boolean k=controller.updateInfo(vo);
				if(k)DialogCreator.successDialog("suceess");
				else DialogCreator.failDialog("fail");


			}

		}
	 private class deleteButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				firmField.setText("");
				yearField.setText("");
				monthField.setText("");
				dayField.setText("");

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
	@Override
	public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }
}
