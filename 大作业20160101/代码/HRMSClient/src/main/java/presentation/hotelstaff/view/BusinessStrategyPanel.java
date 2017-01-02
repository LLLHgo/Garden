package presentation.hotelstaff.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
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
import presentation.hotelstaff.controller.HotelstaffViewController;
import vo.hotelinfoVO.HotelinfoVO;
import vo.strategyVO.HotelStrategyVO;

public class BusinessStrategyPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private HotelstaffViewController controller;
	private String hotelID;
	private HotelStrategyVO vo;
	private ImageIcon image;
	private TextField jftdiscount;
	private TimePanel1 tpStart;
	private TimePanel1 tpEnd;
	private ConfirmButton jbConfirm;
	private CancleButton jbCancle;
	private TextLabel discountLabel;
	private TextLabel startLabel;
	private TextLabel endLabel;
	private TextLabel companyLabel;
	private String discount;
	private JLabel resultLabel;
	private Calendar startTime;
	private Calendar endTime;
	private JComboBox jcbCompany;
	private ArrayList<String> companyList;

	public BusinessStrategyPanel(HotelstaffViewController controller,HotelStrategyVO vo){
		this.controller = controller;
		this.hotelID = controller.gethotelID();
		this.vo = vo;
		init();
		showMessage("合作企业客户折扣");
	}


	private void init(){
		this.setLayout(null);
		this.setBounds(0,0,1000,618);
		this.setVisible(true);
		setOpaque(false);

		startLabel = new TextLabel(350,135,100,30,"开始时间 ");
		this.add(startLabel);

		endLabel = new TextLabel(350,185,100,30,"结束时间");
		this.add(endLabel);

		discountLabel = new TextLabel(350,235,50,30,"折扣");
		this.add(discountLabel);

		companyLabel = new TextLabel(350,285,150,30,"合作企业列表");
		this.add(companyLabel);

		String[] companies = {""};
		HotelinfoVO hotelinfoVO = controller.gethotelinfoVO(hotelID);
		companyList = hotelinfoVO.getCompany();
		if(companyList!=null){
			companies = new String[companyList.size()];
			for(int i=0;i<companyList.size();i++){
				companies[i] = companyList.get(i);
			}
		}
		jcbCompany = new JComboBox(companies);
		jcbCompany.setBounds(480,285,220,30);
		jcbCompany.setOpaque(false);
		jcbCompany.setBorder(null);
		jcbCompany.setFont(new Font("微软雅黑",Font.BOLD,20));
		jcbCompany.setEditable(false);
		jcbCompany.setSelectedItem(null);
		this.add(jcbCompany);

		jftdiscount = new TextField("",460,234,80,30,4);
		jftdiscount.setText(String.valueOf(vo.getDiscount()));
		jftdiscount.setForeground(Color.white);
		jftdiscount.setFont(new Font("微软雅黑",Font.BOLD,20));
		this.add(jftdiscount);

		tpStart = new TimePanel1(458,129,308,37);
		tpEnd = new TimePanel1(458,182,308,37);
		tpStart.setTime(vo.getStartTime());
		tpEnd.setTime(vo.getEndTime());
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
					vo.setName("合作企业客户折扣");
					vo.setStartTime(startTime);
					vo.setEndTime(endTime);
					vo.setViptype(VIPType.ENTERPRISEVIP);
					vo.setType(HotelStrategy.COMPANY);
					vo.setHotelID(hotelID);
					vo.setDiscount(Double.parseDouble(discount));
					ResultMessage result = controller.updatehotelStrategy(vo);
					if(result == ResultMessage.SUCCESS){
						controller.JBStrategyClicked("合作企业客户折扣修改成功");
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
