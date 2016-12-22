package presentation.client.compoment;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentation.client.compoment.PersonalPanel.Label;

public class RegisterPanel extends JPanel{
	private ImageIcon imageIcon = null;
	private okButton ok;
	private deleteButton delete;
	private Label idLabel;
	private Label nameLabel;
	private Label telLabel;
	private Label vipLabel;
	private Field firmField;
	private JScrollPane scrollPane;

	public RegisterPanel(){
		java.awt.Font f=new java.awt.Font("微软雅黑", 4,  25);
		imageIcon = new ImageIcon("image/registerPanel.png");
		ok=new okButton(500,120);
		delete=new deleteButton(510,260);
		idLabel=new Label("C00000001");
		idLabel.setBounds(240,123,200,30);
		nameLabel=new Label("王二狗");
		nameLabel.setBounds(150,165,100,30);

		telLabel=new Label("1374747471");
		telLabel.setBounds(150,215,300,30);


		firmField=new Field("震你一下有限公司", 100,400, 300, 30);
		firmField.setBounds(225,315,220,30);
		firmField.setFocusable(true);

		this.add(ok);
		this.add(delete);
		this.add(idLabel);
		this.add(nameLabel);
		this.add(telLabel);
		this.add(firmField);
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
	@Override
	public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }
}
