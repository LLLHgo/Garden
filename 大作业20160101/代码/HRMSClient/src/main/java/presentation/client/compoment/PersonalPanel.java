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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentation.client.controller.PersonalPanelController;
import presentation.common.CreditFrame;
import presentation.login.view.DialogCreator;
import vo.clientVO.ClientVO;

/**
 * 个人信息界面类，显示个人基本信息
 * @author ClaraLee
 *
 */
public class PersonalPanel extends JPanel{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon imageIcon = null;
	private JTextField nameField;
	private JTextField telField;
	private Label idLabel;
	private Label nameLabel;
	private Label telLabel;
	private Label vipLabel;
	private Label hint;
	private Label creditLabel;
	private Label keyLabel;
	private JPasswordField keyField;
	private okButton ok;
	private deleteButton delete;
	private creditButton cb;
	private editButton editName;
	private editButton editKey;
	private editButton editTel;
	private PersonalPanelController controller;
	private ArrayList<String> credits;
	private ClientVO vo;
	private String clientID;
	public PersonalPanel(String clientID,PersonalPanelController controller){
		this.controller=controller;
		this.clientID=clientID;
		vo=controller.getclient(clientID);

		credits=vo.getCreditRecord();
		cb=new creditButton();
		cb.addActionListener(new creditButtonListener());
		imageIcon = new ImageIcon(this.getClass().getResource("image/personalPanel.png"));
		idLabel=new Label("ID:"+clientID);
		idLabel.setBounds(250,170,200,30);
		nameField=new Field(vo.getName(),200,220,200,35);
		telField=new Field(vo.getTel(),200,270,200,35);
		nameLabel=new Label("姓名：");
		nameLabel.setBounds(120,220,100,30);
		ok=new okButton(500,150);
		ok.addActionListener(new okButtonListener());
		delete=new deleteButton(520,270);
		delete.addActionListener(new deleteButtonListener());
		editName=new editButton(420,220);
		editName.addActionListener(new editNameButtonListener());
		telLabel=new Label("电话：");
		telLabel.setBounds(120,270,100,30);
		editTel=new editButton(420,270);
		editTel.addActionListener(new editTelButtonListener());
		editKey=new editButton(320,415);
		editKey.addActionListener(new editKeyButtonListener());
		vipLabel=new Label("会员类型："+vo.getType());
		vipLabel.setBounds(120,320,400,30);
		creditLabel=new Label("信用值："+vo.getCredit());
		creditLabel.setBounds(120,370,200,30);
		keyLabel=new Label("密码:");
		keyLabel.setBounds(120,415,100,30);
		keyField=new JPasswordField(vo.getPassword());
		keyField.setBounds(200,415,100,30);
		keyField.setBorder(new EmptyBorder(0,0,0,0));
		keyField.setOpaque(false);
		keyField.setFont(new java.awt.Font("微软雅黑", 4,  25));
		keyField.setFocusable(false);

		hint=new Label("");
		hint.setBounds(5,5,300,30);
		this.add(idLabel);
		this.add(nameLabel);
		this.add(nameField);
		this.add(telLabel);
		this.add(telField);
		this.add(vipLabel);
		this.add(creditLabel);
		this.add(keyLabel);
		this.add(keyField);
		this.add(cb);
		this.add(ok);
		this.add(delete);
		this.add(editName);
		this.add(editKey);
		this.add(editTel);
		this.add(hint);
		this.setVisible(false);
	    this.setLayout(null);
	    this.setSize(704, 502);
	    this.setOpaque(false);
	}
	class Field extends JTextField{
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

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
		private static final long serialVersionUID = 1L;
		public Label(String str){
			super(str);
			java.awt.Font f=new java.awt.Font("微软雅黑", 4,  25);
			this.setFont(f);
			this.setForeground(Color.WHITE);

		}
	}
	public void refresh(){
		vo=controller.getclient(clientID);
		nameField.setText(vo.getName());
		telField.setText(vo.getTel());
		vipLabel.setText("会员类型："+vo.getType());
		creditLabel.setText("信用值："+vo.getCredit());
		credits=vo.getCreditRecord();
	}
	 class creditButton extends JButton{
		 private static final long serialVersionUID = 1L;
		ImageIcon icon;
		public creditButton(){
		icon=new ImageIcon(this.getClass().getResource("image/creditButton.png"));
		this.setIcon(icon);
		this.setOpaque(true);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setBounds(320,350,60,60);
		}
	}
	 private class okButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(nameField.getText()!=""&&telField.getText()!=""&&telField.getText().length()==11&&new String(keyField.getPassword())!="")
				{
				vo.setName(nameField.getText());
				vo.setTel(telField.getText());
				vo.setPassword(new String(keyField.getPassword()));
				boolean k=controller.updateInfo(vo);
				if(k)
				setHint("个人信息修改成功！");
				else
				setHint("个人信息修改失败！");
				nameField.setOpaque(false);
				nameField.setFocusable(false);
				nameField.setForeground(Color.WHITE);
				telField.setOpaque(false);
				telField.setFocusable(false);
				telField.setForeground(Color.WHITE);
				keyField.setOpaque(false);
				keyField.setFocusable(false);

				}else
					setHint("信息填写不完整！");
			}

		}
	 private class deleteButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nameField.setText(vo.getName());
				telField.setText(vo.getTel());
				keyField.setText(vo.getPassword());
				nameField.setOpaque(false);
				nameField.setFocusable(false);
				nameField.setForeground(Color.WHITE);
				telField.setOpaque(false);
				telField.setFocusable(false);
				telField.setForeground(Color.WHITE);
				keyField.setOpaque(false);
				keyField.setFocusable(false);

			}

		}
	 private class editKeyButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				keyField.setOpaque(true);
				keyField.setForeground(Color.BLACK);
				keyField.setFocusable(true);
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
				if(credits!=null){}
				else
				credits=new ArrayList<String>();
				new CreditFrame(credits);


			}

		}
	@Override
	public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }
	//设置定时提示信息
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
