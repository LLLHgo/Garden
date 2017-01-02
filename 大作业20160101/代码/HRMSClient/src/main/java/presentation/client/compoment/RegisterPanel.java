package presentation.client.compoment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Enum.VIPType;
import presentation.client.compoment.PersonalPanel.Label;
import presentation.client.controller.RegisterPanelController;
import presentation.login.view.DialogCreator;
import vo.clientVO.ClientVO;
/**
 * 注册会员界面类，显示注册会员的相关信息并进行注册会员的相关操作
 * @author ClaraLee
 *
 */
//
public class RegisterPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private ImageIcon imageIcon = null;
	private okButton ok;
	private deleteButton delete;
	private Label idLabel;
	private Label nameLabel;
	private Label telLabel;
	private Label hint;
	private Field firmField;
	private Field yearField;
	private Field monthField;
	private Field dayField;

	private JComboBox<String> combobox;
	private RegisterPanelController controller;
	private ClientVO vo;
	private String clientID;
	public RegisterPanel(String id,RegisterPanelController controller){
		this.controller=controller;
		this.clientID=id;
		vo=controller.getclient(id);
		imageIcon = new ImageIcon(this.getClass().getResource("image/registerPanel.png"));
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
		hint=new Label("");
		hint.setBounds(5,5,300,30);

		combobox=new JComboBox<String>();
		combobox.addItem("普通会员");
		combobox.addItem("企业会员");
		combobox.setBounds(260,260,150,40);
		if(vo.getType()==VIPType.ENTERPRISEVIP)
		firmField=new Field(vo.getFirm(), 100,400, 300, 30,25);
		else firmField=new Field("", 100,400, 300, 30,25);
		firmField.setBounds(225,315,220,30);
		if(vo.getType()==VIPType.ORDINARYVIP){
		yearField=new Field(vo.getBirth().substring(0,4),190,365,65,30,15);
		monthField=new Field(vo.getBirth().substring(5,7),290,365,35,30,15);
		dayField=new Field(vo.getBirth().substring(8,10),370,365,35,30,15);
		}
		else{
			yearField=new Field("",190,365,65,30,15);
			monthField=new Field("",290,365,35,30,15);
			dayField=new Field("",370,365,35,30,15);
		}
		this.add(ok);
		this.add(delete);
		this.add(idLabel);
		this.add(hint);
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
	public void refresh(){
		vo=controller.getclient(clientID);
		nameLabel.setText(vo.getName());
		telLabel.setText(vo.getTel());

	}
	class Field extends JTextField{
		private static final long serialVersionUID = 1L;
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

				if(vo.getType()==VIPType.NONVIP){
				if((String)combobox.getSelectedItem()=="普通会员"){
					if(yearField.getText().length()==4&&monthField.getText().length()==2&&dayField.getText().length()==2){
					vo.setBirth(yearField.getText()+"-"+monthField.getText()+"-"+dayField.getText());
					vo.setType(VIPType.ORDINARYVIP);
					boolean k=controller.updateInfo(vo);
					if(k)setHint("注册成功");
					else setHint("注册失败");
					}else setHint("请输入生日");
				}
				else {
					if(firmField.getText()!=""){
					vo.setFirm(firmField.getText());
					vo.setType(VIPType.ENTERPRISEVIP);
					boolean k=controller.updateInfo(vo);
					if(k)setHint("注册成功");
					else setHint("注册失败");
					}else setHint("请输入公司名");
				}
				}
				else
					setHint("您已经是会员了");
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
		private static final long serialVersionUID = 1L;
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
	public void setHint(String str){
        hint.setText(str);
    	new Thread(new Runnable(){
			@Override
			public void run() {
				hint.setText(str);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				hint.setText("");
			}

		}).start();

    }
}
