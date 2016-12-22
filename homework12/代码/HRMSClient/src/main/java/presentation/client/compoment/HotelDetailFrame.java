package presentation.client.compoment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import datatool.HotelinfoDataTool;
import datatool.RoominfoDataTool;
import vo.hotelinfoVO.HotelinfoVO;


public class HotelDetailFrame extends JFrame{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	HotelDetailPanel hdp;
	private HotelinfoVO vo;
	private JPanel Panel;


	public HotelDetailFrame(HotelinfoVO vo){


		Panel=new JPanel();
		this.vo=vo;
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JTextArea text=new JTextArea();
		text.setBounds(100,245,200,100);
		text.setOpaque(false);
	    text.setForeground(Color.WHITE);
	    text.setFont(new java.awt.Font("微软雅黑", 4,  20));
	    text.setLineWrap(true);
	    text.setCaretColor(Color.WHITE);
	    //此处应要根据hotelinfovo来增加 text
	    text.append("标准间     ￥200\n");
	    text.append("大床房     ￥300\n");
	    text.append("商务间     ￥400\n");
        this.add(text);


		hdp=new HotelDetailPanel();
		this.add(hdp);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(591, 433);
		this.setLocation(500,200);
	}
	class HotelDetailPanel extends JPanel{
		private ImageIcon imageIcon = null;
		private Label hotelNameLabel;
		private Label hotelLevelLabel;
		private Label hotelAddressLabel;
		private Label hotelFacilityLabel;
		private Label hotelTelLabel;
		private orderButton order;
		public HotelDetailPanel(){
		imageIcon = new ImageIcon("image/HotelDetailPanel.png");


		order=new orderButton(470,280);
		order.addActionListener(new orderButtonListener());
		hotelNameLabel=new Label(vo.getName(),90,13,300,30);
		hotelLevelLabel=new Label(vo.getStar().toString(),90,65,300,30);
		hotelAddressLabel=new Label(vo.getAddress(),90,125,300,30);
		hotelFacilityLabel=new Label(vo.getFacility(),140,182,300,30);
		hotelTelLabel=new Label(vo.getTel(),140,356,300,30);
		this.add(hotelNameLabel);
		this.add(hotelLevelLabel);
		this.add(hotelAddressLabel);
		this.add(hotelFacilityLabel);
		this.add(hotelTelLabel);
		this.add(order);

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
		class orderButton extends JButton{
			ImageIcon icon;
			public orderButton(int x,int y){
			icon=new ImageIcon("image/orderButton.png");
			this.setIcon(icon);
			this.setOpaque(true);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			this.setFocusPainted(false);
			this.setBounds(x,y,70,70);
			}
		}
		private class orderButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new OrderCreateFrame();
			}

		}
		@Override
		public void paintComponent(Graphics g) {
			    g.drawImage(imageIcon.getImage(), 0, 0, this);
			    super.paintComponents(g);
			   }
	}
		class roomListPane extends JScrollPane{

			private JScrollPane scrollpanel;
			public roomListPane(){
				super(Panel);

				Panel.setLayout(null);
			    Panel.setPreferredSize(new Dimension(200,240));
			    Panel.setBounds(0,0,200,1000);
			    Panel.setOpaque(false);


			   this.setBounds(120, 270, 620, 70);
			   this.setOpaque(false);
			   this.getViewport().setOpaque(false);
			   this.getVerticalScrollBar().setVisible(false);
			   this.setBorder(new EmptyBorder(0,0,0,0));
			   this.setVisible(false);
			    for(int i=0;i<6;i++){
			    	roomItemPanel p=new roomItemPanel(0, i*40,RoominfoDataTool.roominfo1);
		    	 Panel.add(p);
			    }
			    this.getVerticalScrollBar().setVisible(false);
			    scrollpanel=this;
			}
		}
//end scrollpane

}



