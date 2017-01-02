package presentation.client.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import businesslogic.clientbl.ClientManage;
import businesslogicservice.clientblservice.ClientBLService;
import presentation.client.compoment.EvaluatePanel;
import presentation.client.compoment.PersonalPanel;
import presentation.client.compoment.RegisterPanel;
import presentation.client.compoment.SearchPanel;
import presentation.client.compoment.ViewOrderPanel;
import presentation.client.compoment.WelPanel;
import presentation.client.controller.EvaluatePanelController;
import presentation.client.controller.PersonalPanelController;
import presentation.client.controller.RegisterPanelController;
import presentation.client.controller.SearchPanelController;
import presentation.client.controller.ViewOrderPanelController;
import presentation.common.GuideBoardButton;

public class ProcessClientView extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private GuideBoardButton searchHotel;
	private GuideBoardButton viewOrder;
	private GuideBoardButton personal;
	private GuideBoardButton evaluate;
	private GuideBoardButton register;
	private GuideBoardButton exit;
	private String id;
	private WelPanel wp;
	private SearchPanel sp;
	private ViewOrderPanel vp;
	private PersonalPanel pp;
	private RegisterPanel rp;
	private EvaluatePanel ep;

	private ImageIcon imageIcon = null;
	private JLabel idLabel;
	private JFrame frame;
	public ProcessClientView(JFrame frame,String id){
			//hdp=new HotelDetailPanel();
			this.frame=frame;
			this.id=id;
			idLabel =new JLabel(id);
			idLabel.setBounds(80,185, 180, 30);
			idLabel.setFont(new java.awt.Font("微软雅黑", 4,  25));
			idLabel.setForeground(Color.WHITE);

			wp=new WelPanel();
			ClientBLService client=new ClientManage();
			sp=new SearchPanel(client.getclient(id),frame,new SearchPanelController());
			vp=new ViewOrderPanel(frame,id,new ViewOrderPanelController());
			pp=new PersonalPanel(id,new PersonalPanelController());
			rp=new RegisterPanel(id,new RegisterPanelController());
			ep=new EvaluatePanel(frame,new EvaluatePanelController(),id);
			imageIcon = new ImageIcon(this.getClass().getResource("image/clientPanel.png"));


			searchHotel=new GuideBoardButton(240,"查询酒店");
			searchHotel.addActionListener( new searchButtonListener());
			viewOrder=new GuideBoardButton(290,"浏览订单");
			viewOrder.addActionListener( new viewOrderButtonListener());
			personal=new GuideBoardButton(340,"个人信息");
			personal.addActionListener( new personalButtonListener());
			evaluate=new GuideBoardButton(390,"评价酒店");
			evaluate.addActionListener( new evaluateButtonListener());
			register=new GuideBoardButton(440,"注册会员");
			register.addActionListener( new registerButtonListener());
			exit=new GuideBoardButton(490,"退出");
			exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
				});


			this.add(searchHotel);
			this.add(viewOrder);
			this.add(personal);
			this.add(evaluate);
			this.add(register);
			this.add(exit);
			this.setOpaque(true);
		    this.setLayout(null);
		    this.add(idLabel);
		    wp.setLocation(277,82);
		    sp.setLocation(277,82);
		    vp.setLocation(277,82);
		    pp.setLocation(277,82);
		    rp.setLocation(277,82);
		    ep.setLocation(277,82);

		    wp.setVisible(true);

		    frame.add(wp);
		    frame.add(sp);
		    frame.add(vp);
		    frame.add(pp);
		    frame.add(rp);
		    frame.add(ep);
		    //frame.add(hdp);
		    this.setSize(1000, 618);
		    this.setVisible(true);
	}

	private class searchButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			pp.setVisible(false);
			wp.setVisible(false);
			vp.setvisible(false);
			rp.setVisible(false);
			ep.setvisible(false);
			sp.setvisible(true);
		}

	}
	private class registerButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			rp.refresh();
			pp.setVisible(false);
			wp.setVisible(false);
			vp.setvisible(false);
			sp.setvisible(false);
			ep.setvisible(false);
			rp.setVisible(true);
		}

	}
	private class viewOrderButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			pp.setVisible(false);
			rp.setVisible(false);
			wp.setVisible(false);
			sp.setvisible(false);
			ep.setvisible(false);
			vp.setvisible(true);
		}

	}
	private class personalButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			pp.refresh();
			wp.setVisible(false);
			sp.setvisible(false);
			vp.setvisible(false);
			rp.setVisible(false);
			ep.setvisible(false);
			pp.setVisible(true);
		}

	}
	private class evaluateButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			wp.setVisible(false);
			sp.setvisible(false);
			vp.setvisible(false);
			rp.setVisible(false);
			pp.setVisible(false);
			ep.setvisible(true);
		}

	}
	@Override
	 public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }
}
