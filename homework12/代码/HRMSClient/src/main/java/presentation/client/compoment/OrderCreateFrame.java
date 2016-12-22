package presentation.client.compoment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentation.client.compoment.OrderCreateFrame.OrderCreatePanel.chooseRoomListPane;




public class OrderCreateFrame extends JFrame{
	private OrderCreatePanel hdp;
	private  JPanel Panel;
	private DateChooser begin;
	private DateChooser end;

	public OrderCreateFrame(){
		this.setLayout(null);
		begin=new DateChooser();
		end=new DateChooser();
		this.add(begin);
		begin.setOpaque(false);
		begin.setBorder(new EmptyBorder(0,0,0,0));
		begin.setBounds(150,187,100,25);
		this.add(end);
		end.setOpaque(false);
		end.setBorder(new EmptyBorder(0,0,0,0));
		end.setBounds(330,187,100,25);
		this.pack();


		Panel=new JPanel();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		hdp=new OrderCreatePanel(this);
		this.add(hdp);
		this.setLocationRelativeTo(null);




		this.setVisible(true);
		this.setResizable(false);
		this.setSize(591, 433);
		this.setLocation(400,200);
	}
	class OrderCreatePanel extends JPanel{
		private ImageIcon imageIcon = null;
		private Label hotelNameLabel;
		private Label totalMoneyLabel;
		private Label actualMoneyLabel;
		private Field nameField;
		private chooseRoomListPane crlp;
		private deleteButton delete;
		private okButton ok;
		public OrderCreatePanel(JFrame frame){
			crlp=new chooseRoomListPane();
			frame.add(crlp);
		imageIcon = new ImageIcon("image/OrderCreatePanel.png");
		hotelNameLabel=new Label("test",90,13,300,30);
		totalMoneyLabel=new Label("test",117,240,300,30);
		actualMoneyLabel=new Label("test",374,238,300,30);
		nameField=new Field("test",123,70,92,30,20);

		delete=new deleteButton(300,310);
		ok=new okButton(400,290);
		this.add(delete);
		this.add(ok);

		this.add(hotelNameLabel);
		this.add(nameField);
		this.add(totalMoneyLabel);
		this.add(actualMoneyLabel);
		this.setVisible(true);
	    this.setLayout(null);
	    this.setBounds(0,0,591,413);
	    this.setOpaque(false);
	    this.setVisible(true);
	    this.repaint();

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
		  class chooseRoomListPane extends JScrollPane{

			public chooseRoomListPane(){
				super(Panel);
				Panel.setLayout(null);
			    Panel.setPreferredSize(new Dimension(200,105));
			    Panel.setBounds(0,0,1000,4000);
			    Panel.setOpaque(false);


			   this.setBounds(150, 134, 720, 50);
			   this.setOpaque(false);
			   this.getViewport().setOpaque(false);
			   this.getVerticalScrollBar().setVisible(false);
			   this.setBorder(new EmptyBorder(0,0,0,0));
			   this.setVisible(true);
			    for(int i=0;i<3;i++){
			    	chooseRoomPanel p=new chooseRoomPanel(0, i*35,"标准间");
			    	 //p.setBounds(0,i*100,600,100);

			    	 Panel.add(p);
			    }
			    this.getVerticalScrollBar().setVisible(false);

			}
		}
		@Override
		public void paintComponent(Graphics g) {
			    g.drawImage(imageIcon.getImage(), 0, 0, this);
			    super.paintComponents(g);
			   }
	}

}
