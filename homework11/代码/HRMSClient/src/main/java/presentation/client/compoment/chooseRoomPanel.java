package presentation.client.compoment;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class chooseRoomPanel extends JPanel{
	private ImageIcon imageIcon = null;
	private Label roomNameLabel;
	private Field numField;
	public chooseRoomPanel(int x,int y,String roomName){
		this.setLayout(null);
		imageIcon = new ImageIcon("image/chooseRoom.png");
		roomNameLabel=new Label(roomName,0,0,80,30,20);
		this.add(roomNameLabel);

		numField=new Field("0",138,4,25,20,15);
		this.add(numField);

		this.setVisible(true);
		this.setBounds(x,y,200,35);
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
	class Label extends JLabel{
		public Label(String str,int x,int y,int w,int h,int big){
			super(str);
			java.awt.Font f=new java.awt.Font("微软雅黑", 4,  big);
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
