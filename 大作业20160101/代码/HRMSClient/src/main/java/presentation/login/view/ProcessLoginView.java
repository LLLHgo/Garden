package presentation.login.view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Enum.ResultMessage;
import presentation.client.view.ProcessClientView;
import presentation.hotelstaff.controller.HotelstaffViewController;
import presentation.hotelstaff.view.HotelstaffView;
import presentation.login.controller.ProcessLoginViewController;
import presentation.marketing.controller.ProcessMarketingViewController;
import presentation.marketing.view.ProcessMarketingView;
import presentation.marketing.view.ProcessMarketingViewControllerService;
import presentation.sitemanager.controller.ProcessSitemanagerViewController;
import presentation.sitemanager.view.ProcessSitemanagerView;
import presentation.sitemanager.view.ProcessSitemanagerViewControllerService;
import vo.clientVO.ClientVO;

public class ProcessLoginView extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JTextField IdField;
	private JPasswordField KeyField;
	private JButton loginButton;
	private JButton signUpButton;
	private ImageIcon imageIcon = null;
	private ProcessLoginViewController controller;
	private ProcessSitemanagerViewControllerService ps;
	JLabel hint;
	public ProcessLoginView(JFrame frame,ProcessLoginViewController controller){
			this.controller=controller;
			hint=new JLabel("");
			hint.setBounds(350,170,300,30);
			hint.setFont(new java.awt.Font("微软雅黑", 4,  20));
			hint.setForeground(Color.WHITE);
			this.add(hint);
			ImageIcon lib=new ImageIcon(this.getClass().getResource("image/loginButton.png"));
			ImageIcon sub=new ImageIcon(this.getClass().getResource("image/signUpButton.png"));
			imageIcon = new ImageIcon(this.getClass().getResource("image/login.png"));
			this.setOpaque(true);
		    this.setLayout(null);
		    IdField = new JTextField();
			KeyField = new JPasswordField();
			IdField.setFont(new java.awt.Font("微软雅黑", 4,  25));
			KeyField.setFont(new java.awt.Font("微软雅黑", 4,  25));
			IdField.setBorder(new EmptyBorder(0,0,0,0));
			IdField.setBounds(385, 220, 300, 48);
			IdField.setOpaque(false);
			IdField.setFocusable(true);
			KeyField.setBounds(388, 315, 297, 48);
			KeyField.setBorder(new EmptyBorder(0,0,0,0));
			KeyField.setOpaque(false);
			KeyField.setFocusable(true);

			this.add(IdField);
			this.add(KeyField);
			loginButton=new JButton();
			loginButton.setBounds(353,417,120,32);
			loginButton.setIcon(lib);
			loginButton.setOpaque(true);
			loginButton.setContentAreaFilled(false);
			loginButton.setBorderPainted(false);
			loginButton.setFocusPainted(false);
			loginButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String id=IdField.getText();
					System.out.println(id);
					String key=new String(KeyField.getPassword());
					switch(controller.login(id,key)){
					case 'c':
						frame.getContentPane().removeAll();
						frame.getContentPane().add(new ProcessClientView(frame,id));
						frame.getContentPane().revalidate();
						frame.getContentPane().repaint();
						break;
					case 'h':
						frame.getContentPane().removeAll();
						HotelstaffViewController hotelstaff = HotelstaffViewController.getInstance(id);
						HotelstaffView view = new HotelstaffView(hotelstaff);
						hotelstaff.setView(view);
						frame.getContentPane().add(view);
						frame.getContentPane().revalidate();
						frame.getContentPane().repaint();
						break;
					case 's':
						frame.getContentPane().removeAll();
						ProcessSitemanagerViewControllerService sitemanagerC = new ProcessSitemanagerViewController("S00000001");
						ProcessSitemanagerView sitemanagerview = new ProcessSitemanagerView(sitemanagerC);
						sitemanagerC.setView(sitemanagerview);
						frame.getContentPane().add(sitemanagerview);
						frame.getContentPane().revalidate();
						frame.getContentPane().repaint();

						break;
					case 'm':
						ProcessMarketingViewControllerService controller1=new ProcessMarketingViewController(id);
						frame.getContentPane().removeAll();
						ProcessMarketingView marketingView=new ProcessMarketingView(controller1);
						controller1.setView(marketingView);
						frame.getContentPane().add(marketingView);
						frame.getContentPane().revalidate();
						frame.getContentPane().repaint();

						break;
					case 'e':
						hint.setText("登录失败，请检查账号信息");
						break;
					}
				}
				});

			signUpButton=new JButton();
			signUpButton.setBounds(548,417,120,32);
			signUpButton.setIcon(sub);
			signUpButton.setOpaque(true);
			signUpButton.setContentAreaFilled(false);
			signUpButton.setBorderPainted(false);
			signUpButton.setFocusPainted(false);
			signUpButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(IdField.getText().length()==11&&new String(KeyField.getPassword()).length()>0){
					ClientVO vo=new ClientVO(IdField.getText(),new String(KeyField.getPassword()));
					String res=controller.addclient(vo);
					if(res.charAt(0)=='C')
					hint.setText("您的登陆账号为："+res);
					else
						hint.setText("注册失败");
				}else
					hint.setText("请检查电话号码或是否输入密码");

				}
				});
			this.add(loginButton);
			this.add(signUpButton);
		    this.setSize(1000, 618);

		    this.setVisible(true);
	}

	@Override
	 public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }
}
