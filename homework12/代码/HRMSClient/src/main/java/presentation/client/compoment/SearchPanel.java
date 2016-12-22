package presentation.client.compoment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Enum.OrderType;
import datatool.HotelinfoDataTool;
import presentation.client.controller.SearchPanelController;
import vo.hotelinfoVO.HotelinfoVO;
import vo.orderVO.OrderVO;

public class SearchPanel extends JPanel{
	private ImageIcon imageIcon = null;
	private JTextField searchField;
	private SearchButton searchButton;
	private HotelSearchListPane hslp;
	private JPanel Panel;
	private JPanel temp;
	private JFrame frame;
	private SearchPanelController controller;
	public SearchPanel(JFrame frame,SearchPanelController controller){

		Panel=new JPanel();
		this.frame=frame;
		this.controller=controller;
		hslp=new HotelSearchListPane(frame,null);
		frame.add(hslp);

		imageIcon = new ImageIcon("image/searchPanel.png");
		searchField=new JTextField();
		searchButton=new SearchButton();
		searchButton.addActionListener(new searchButtonListener());
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
	    temp=this;
	}
	public void setvisible(boolean flag){
		this.setVisible(flag);
		if(!flag)
		hslp.setVisible(flag);

	}
	private class searchButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String info=searchField.getText();
			hslp.change(controller.getBasicinfoList(info));
			hslp.setVisible(true);
		}

	}
	private class HotelSearchListPane extends JScrollPane{
		private JFrame frame;
		private JScrollPane scrollpanel;
		public HotelSearchListPane(JFrame frame,ArrayList<HotelinfoVO> list){
			super(Panel);
			this.frame=frame;
			if(list!=null){
			Panel.setLayout(null);
		    Panel.setPreferredSize(new Dimension(600,list.size()));
		    Panel.setBounds(0,0,1000,4000);
		    Panel.setOpaque(false);


		   this.setBounds(320, 170, 920, 400);
		   this.setOpaque(false);
		   this.getViewport().setOpaque(false);
		   this.getVerticalScrollBar().setVisible(false);
		   this.setBorder(new EmptyBorder(0,0,0,0));
		   this.setVisible(false);
		    for(int i=0;i<list.size();i++){
		    	HotelinfoVO vo=list.get(i);
		    	HotelSearchItemPanel p=new HotelSearchItemPanel(0, i*100,vo);
		    	 //p.setBounds(0,i*100,600,100);
		    	p.vb.addActionListener(new ActionListener(){
		    		public void actionPerformed(ActionEvent e) {
		    			new HotelDetailFrame(vo);
		    		}
		    		});
		    	 Panel.add(p);
		    }
		    this.getVerticalScrollBar().setVisible(false);
		    scrollpanel=this;
		}
		}
	public void change(ArrayList<HotelinfoVO> list){
		Panel.removeAll();
		if(list!=null)
			 for(int i=0;i<list.size();i++){
			    	HotelinfoVO vo=list.get(i);
			    	HotelSearchItemPanel p=new HotelSearchItemPanel(0, i*100,vo);
			    	 //p.setBounds(0,i*100,600,100);
			    	p.vb.addActionListener(new ActionListener(){
			    		public void actionPerformed(ActionEvent e) {
			    			new HotelDetailFrame(vo);
			    		}
			    		});
			    	 Panel.add(p);
			    }
			    this.getVerticalScrollBar().setVisible(false);

			    this.repaint();
	}
	}
	@Override
	public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }

}
