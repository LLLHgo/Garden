package presentation.hotelstaff.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Enum.ResultMessage;
import presentation.hotelstaff.component.CancleButton;
import presentation.hotelstaff.component.ConfirmButton;
import presentation.hotelstaff.component.TextField;
import presentation.hotelstaff.controller.HotelstaffViewController;
import vo.strategyVO.HotelStrategyVO;

public class BirthdayStrategyPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private HotelstaffViewController controller;
	private String hotelID;
	private HotelStrategyVO vo;
	private ImageIcon image;
	private TextField jftdiscount;
	private ConfirmButton jbConfirm;
	private CancleButton jbCancle;
	private JLabel label;
	private String discount;
	private JLabel resultLabel;

	
	public BirthdayStrategyPanel(HotelstaffViewController controller,HotelStrategyVO vo){
		this.controller = controller;
		this.hotelID = controller.gethotelID();
		this.vo = vo;
		init();		
		showMessage("生日特惠折扣");
	}
	
	
	private void init(){
		this.setLayout(null);
		this.setBounds(0,0,1000,618);
		this.setVisible(true);
		setOpaque(false);
		
		label = new JLabel("折扣");
		label.setFont(new Font("微软雅黑",Font.PLAIN,20));
		label.setBounds(350,200,50,30);
		label.setForeground(Color.white);
		this.add(label);
		
		jftdiscount = new TextField("",400,200,80,30,4);
		jftdiscount.setText(String.valueOf(vo.getDiscount()));
		jftdiscount.setForeground(Color.white);
		this.add(jftdiscount);
		
		jbConfirm = new ConfirmButton(670,470);
		this.add(jbConfirm);
		jbConfirm.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				discount = jftdiscount.getText();
				vo.setDiscount(Double.parseDouble(discount));
				ResultMessage result = controller.updatehotelStrategy(vo);
				if(result == ResultMessage.SUCCESS){
					controller.JBStrategyClicked("生日特惠折扣修改成功");
				}else{
					showMessage(result.toString());
				}
			}
			
		});
		
		jbCancle = new CancleButton(520,470);
		this.add(jbCancle);
		jbCancle.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			
				controller.JBStrategyClicked("取消操作成功");
			
			}
			
		});
		
		//显示结果
		resultLabel = new JLabel();
		resultLabel.setForeground(Color.BLACK);
		resultLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
		resultLabel.setBounds(290, 50, 500, 20);
		this.add(resultLabel);
		
	}
	
	public void showMessage(String message){
	 	//提示信息
		new Thread(new Runnable(){
			@Override
			public void run() {
				resultLabel.setText(message);
				try {
					Thread.sleep(1000);
	            }catch(InterruptedException ex){
	                    ex.printStackTrace();
	            }
	            resultLabel.setText("");
			}
		}).start();
		
	}
}
