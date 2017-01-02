package presentation.client.compoment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
/**
 * 选择房间类型和数量的小panel类
 * @author ClaraLee
 *
 */

public class chooseRoomPanel extends JPanel{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon imageIcon = null;
	private Label roomNameLabel;
	Field numField;
	String name;
	boolean flag=true;
	public chooseRoomPanel(int x,int y,String roomName,int num){
		this.setLayout(null);
		name=roomName;
		imageIcon = new ImageIcon(this.getClass().getResource("image/chooseRoom.png"));
		roomNameLabel=new Label(roomName,0,0,80,30,20);
		this.add(roomNameLabel);

		numField=new Field("<"+num,138,4,25,20,15);
		numField.addMouseListener(new mouseListener());
		this.add(numField);

		this.setVisible(true);
		this.setBounds(x,y,200,35);
		this.setOpaque(false);
	}
	class Field extends JTextField{
		/**
		 *
		 */
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
	class Label extends JLabel{
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		public Label(String str,int x,int y,int w,int h,int big){
			super(str);
			java.awt.Font f=new java.awt.Font("微软雅黑", 4,  big);
			this.setFont(f);
			this.setForeground(Color.WHITE);
			this.setBounds(x,y,w,h);
		}
	}
	class mouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		if(flag)
			numField.setText("");
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
	@Override
	public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }
}
