package presentation.hotelstaff.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Enum.ResultMessage;
import presentation.hotelstaff.component.CancleButton;
import presentation.hotelstaff.component.ConfirmButton;
import presentation.hotelstaff.controller.HotelstaffViewController;
import vo.strategyVO.HotelStrategyVO;

public class PeriodStrategy extends JPanel{

	private static final long serialVersionUID = 1L;
	private HotelstaffViewController controller;
	private String hotelID;
	private HotelStrategyVO vo;
	private ConfirmButton confirm;
	private CancleButton cancle;
	private Calendar startTime;
	private Calendar endTime;
	private JLabel resultLabel;
	
	public PeriodStrategy(HotelstaffViewController controller,HotelStrategyVO vo){
		this.controller = controller;
		this.hotelID = controller.gethotelID();
		this.vo = vo;
		init();
	}
	
	private void init(){
		this.setLayout(null);
		this.setBounds(0,0,1000,618);
		this.setVisible(true);
		setOpaque(false);
		confirm = new ConfirmButton(840,480);
		this.add(confirm);
		confirm.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				ResultMessage result = controller.updatehotelStrategy(vo);
				if(result == ResultMessage.SUCCESS){
					controller.JBStrategyClicked("修改策略成功");
				}else{
					showMessage(result.toString());
				}
				
			}
			
		});
		
		cancle = new CancleButton(690,480);
		this.add(cancle);
		cancle.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.JBStrategyClicked("取消操作成功");	
			}
			
		});
		
		//显示结果
		resultLabel = new JLabel();
		resultLabel.setForeground(Color.BLACK);
		resultLabel.setFont(new Font("微软雅黑",Font.PLAIN,20));
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
