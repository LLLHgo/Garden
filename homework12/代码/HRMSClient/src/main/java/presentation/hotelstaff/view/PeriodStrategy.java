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

import Enum.HotelStrategy;
import Enum.ResultMessage;
import Enum.VIPType;
import presentation.hotelstaff.component.CancleButton;
import presentation.hotelstaff.component.ConfirmButton;
import presentation.hotelstaff.component.TextField;
import presentation.hotelstaff.component.TextLabel;
import presentation.hotelstaff.component.TimePanel1;
import presentation.hotelstaff.component.TimePanel2;
import presentation.hotelstaff.controller.HotelstaffViewController;
import vo.strategyVO.HotelStrategyVO;

public class PeriodStrategy extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private HotelstaffViewController controller;
	private String hotelID;
	private HotelStrategyVO vo;
	private ImageIcon image;
	private TextField jftdiscount;
	private TimePanel2 tpStart;
	private TimePanel2 tpEnd; 
	private ConfirmButton jbConfirm;
	private CancleButton jbCancle;
	private TextLabel discountLabel;
	private TextLabel startLabel;
	private TextLabel endLabel;
	private String discount;
	private JLabel resultLabel;
	private Calendar startTime;
	private Calendar endTime;
	
	public PeriodStrategy(HotelstaffViewController controller,HotelStrategyVO vo){
		this.controller = controller;
		this.hotelID = controller.gethotelID();
		this.vo = vo;
		init();		
		showMessage("双十一活动折扣");
	}
	
	
	private void init(){
		this.setLayout(null);
		this.setBounds(0,0,1000,618);
		this.setVisible(true);
		setOpaque(false);
		
		discountLabel = new TextLabel(350,235,50,30,"折扣");
		this.add(discountLabel);
		
		startLabel = new TextLabel(350,135,100,30,"开始时间 ");
		this.add(startLabel);
		
		endLabel = new TextLabel(350,185,100,30,"结束时间");
		this.add(endLabel);
		
		jftdiscount = new TextField("",460,234,80,30,4);
		jftdiscount.setText(String.valueOf(vo.getDiscount()));
		jftdiscount.setForeground(Color.white);
		jftdiscount.setFont(new Font("微软雅黑",Font.BOLD,20));
		this.add(jftdiscount);
		
		tpStart = new TimePanel2(458,129,308,37);
		tpStart.setTime(Calendar.getInstance().get(Calendar.YEAR), 11, 11, 00, 00);
		tpEnd = new TimePanel2(458,182,308,37);
		tpEnd.setTime(Calendar.getInstance().get(Calendar.YEAR), 11, 11, 24, 00);
		this.add(tpStart);
		this.add(tpEnd);
		
		jbConfirm = new ConfirmButton(670,470);
		this.add(jbConfirm);
		jbConfirm.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				discount = jftdiscount.getText();
				startTime = tpStart.getTime();
				endTime = tpStart.getTime();
				try{
					vo.setName("双十一活动折扣");
					vo.setStartTime(startTime);
					vo.setEndTime(endTime);
					vo.setType(HotelStrategy.SPECIALDAY);
					vo.setHotelID(hotelID);
					vo.setDiscount(Double.parseDouble(discount));
					ResultMessage result = controller.updatehotelStrategy(vo);
					if(result == ResultMessage.SUCCESS){
						controller.JBStrategyClicked("双十一活动折扣修改成功");
					}else{
						showMessage(result.toString());
					}
				}catch(NumberFormatException e1){
					showMessage("未正确填写数字");
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
