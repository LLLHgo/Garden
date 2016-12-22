package presentation.client.compoment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import datatool.OrderDataTool;


public class EvaluatePanel extends JPanel{
	private ImageIcon imageIcon = null;
	private SearchButton searchButton;
	private JTextField searchField;
	private HotelListPane hlp;
	private JPanel Panel;
	public EvaluatePanel(JFrame frame){
		Panel=new JPanel();
		hlp=new HotelListPane();
		frame.add(hlp);
	imageIcon = new ImageIcon("image/searchPanel.png");
	searchField=new JTextField();
	searchButton=new SearchButton();
	searchField.setBounds(72, 18, 450, 50);
	searchField.setBorder(new EmptyBorder(0,0,0,0));
	searchField.setFont(new java.awt.Font("微软雅黑", 4,  25));
	searchField.setForeground(Color.WHITE);
	searchField.setOpaque(false);
	searchField.setFocusable(true);



	this.add(searchButton);
	this.add(searchField);
	this.setVisible(false);
    this.setLayout(null);
    this.setSize(704, 502);
    this.setOpaque(false);
	}

	public void setvisible(boolean flag){
		this.setVisible(flag);
		hlp.setVisible(flag);

	}
	@Override
	public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }
	class HotelListPane extends JScrollPane{

		private JScrollPane scrollpanel;
		public HotelListPane(){
			super(Panel);
			Panel.setLayout(null);
		    Panel.setPreferredSize(new Dimension(600,600));
		    Panel.setBounds(0,0,1000,4000);
		    Panel.setOpaque(false);


		   this.setBounds(320, 170, 920, 400);
		   this.setOpaque(false);
		   this.getViewport().setOpaque(false);
		   this.getVerticalScrollBar().setVisible(false);
		   this.setBorder(new EmptyBorder(0,0,0,0));
		   this.setVisible(false);
		    for(int i=0;i<6;i++){
		    	HotelEvaluateItemPanel p=new HotelEvaluateItemPanel(0, i*100,OrderDataTool.orderVO1);
		    	 //p.setBounds(0,i*100,600,100);
		    	p.vb.addActionListener(new ActionListener(){
		    		public void actionPerformed(ActionEvent e) {
		    			new OrderDetailFrame(OrderDataTool.orderVO1);
		    		}
		    		});
		    	 Panel.add(p);
		    }
		    this.getVerticalScrollBar().setVisible(false);
		    scrollpanel=this;
		}
	}
}
