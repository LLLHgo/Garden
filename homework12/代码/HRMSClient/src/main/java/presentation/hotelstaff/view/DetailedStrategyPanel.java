package presentation.hotelstaff.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Enum.HotelStrategy;
import Enum.ResultMessage;
import Enum.VIPType;
import presentation.hotelstaff.component.CancleButton;
import presentation.hotelstaff.component.ConfirmButton;
import presentation.hotelstaff.component.MJRadioButton;
import presentation.hotelstaff.component.TextField;
import presentation.hotelstaff.component.TimePanel;
import presentation.hotelstaff.controller.HotelstaffViewController;
import presentation.marketing.compoment.MJButton;
import presentation.marketing.compoment.newPanel;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class DetailedStrategyPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private HotelstaffViewController controller;
	private String hotelID;
	private JPanel newPanel;
	private ImageIcon Iinit;
	private JLabel resultLabel;
	private TextField jtfname;
	private TextField jtfdiscount;
	private TextField jtfroom;
	private TextField jtfmoney;
	private TextField jtflevel;
	private TimePanel tpStart;
	private TimePanel tpEnd;
	private MJRadioButton jrbClient;
	private MJRadioButton jrbBusiness;
	private ConfirmButton confirm;
	private CancleButton cancle;
	private HotelStrategyVO vo;
	private String name;
	private Calendar startTime;
	private Calendar endTime;
	private VIPType viptype;
	private List<VIPType> vipKinds;
	private double discount;
	private int level;
	private double minSum;
	private int minRooms;

	public DetailedStrategyPanel(HotelstaffViewController controller,HotelStrategyVO vo){
		this.controller=controller;
		this.hotelID=controller.gethotelID();
		this.name = vo.getName();
		this.discount = vo.getDiscount();
		this.startTime = vo.getStartTime();
		this.endTime = vo.getEndTime();
		this.level = vo.getLevel();
		this.startTime = vo.getStartTime();
		this.endTime = vo.getEndTime();
		this.vipKinds = vo.getVipKinds();
		this.minRooms = vo.getMinRooms();
		this.minSum = vo.getMinSum();
		Iinit = new ImageIcon("./src/main/resource/picture/hotelstrategy/newstrategy.png");
		init();
	}

	public void init(){
		this.setLayout(null);
		this.setLocation(0, 0);
		this.setSize(1000, 618);
		this.setVisible(true);
		setOpaque(false);

		//显示结果
		resultLabel = new JLabel();
		resultLabel.setForeground(Color.BLACK);
		resultLabel.setFont(new Font("微软雅黑",Font.PLAIN,20));
		resultLabel.setBounds(290, 50, 500, 20);
		this.add(resultLabel);

		tpStart = new TimePanel(458,129,308,37);
		tpEnd = new TimePanel(458,182,308,37);
		tpStart.setTime(startTime.get(Calendar.YEAR), startTime.get(Calendar.MONTH),
				startTime.get(Calendar.DATE), startTime.get(Calendar.HOUR), startTime.get(Calendar.MINUTE));
		tpEnd.setTime(endTime.get(Calendar.YEAR), startTime.get(Calendar.MONTH),
				startTime.get(Calendar.DATE), startTime.get(Calendar.HOUR), startTime.get(Calendar.MINUTE));
		this.add(tpStart);
		this.add(tpEnd);

		jtfname = new TextField(name,460,90,400,35,4);
		this.add(jtfname);

		jtfdiscount = new TextField(String.valueOf(discount),460,235,50,35,4);
		this.add(jtfdiscount);

		jtfroom = new TextField(String.valueOf(minRooms),460,401,50,35,4);
		this.add(jtfroom);

		jtfmoney = new TextField(String.valueOf(minSum),460,455,50,35,4);
		this.add(jtfmoney);

		jtflevel = new TextField(String.valueOf(level),460,347,50,35,4);
		this.add(jtflevel);

		jrbClient = new MJRadioButton("普通会员",true,455,295,120,35);
		jrbBusiness = new MJRadioButton("企业会员",true,620,295,120,35);
		if(vipKinds.contains(VIPType.ORDINARYVIP)){
			jrbClient.setSelected(true);
		}
		if(vipKinds.contains(VIPType.ENTERPRISEVIP)){
			jrbBusiness.setSelected(true);
		}
		this.add(jrbClient);
		this.add(jrbBusiness);

		confirm = new ConfirmButton(840,480);
		this.add(confirm);
		confirm.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			try{
				name = jtfname.getText();
				discount = Double.parseDouble(jtfdiscount.getText());
				minRooms = Integer.parseInt(jtfroom.getText());
				minSum = Integer.parseInt(jtfmoney.getText());
				level = Integer.parseInt(jtflevel.getText());
				vipKinds = new ArrayList<VIPType>();
				if(jrbClient.isSelected()){
					vipKinds.add(VIPType.ORDINARYVIP);
				}
				if(jrbBusiness.isSelected()){
					vipKinds.add(VIPType.ENTERPRISEVIP);
				}
				startTime = tpStart.getTime();
				endTime = tpEnd.getTime();
				vo = new HotelStrategyVO(name,hotelID,HotelStrategy.CREATED,vipKinds,
						startTime,endTime,discount,minRooms,minSum,level);
				ResultMessage result = controller.updatehotelStrategy(vo);
				if(result == ResultMessage.SUCCESS){
					controller.JBStrategyClicked("修改策略成功");
				}else{
					showMessage(result.toString());
				}
			}catch(NumberFormatException e1){
				showMessage("数字格式错误或信息不完整，请重新填写");
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
	}

	protected void paintComponent(Graphics g) {
		g.drawImage(Iinit.getImage(), 305,90,464,404,this);
    }

	public void showMessage(String message){
	 	//提示信息
		new Thread(new Runnable(){
			@Override
			public void run() {
					resultLabel.setText(message);
				try {
					Thread.sleep(2000);
	            }catch(InterruptedException ex){
	                    ex.printStackTrace();
	            }
	            resultLabel.setText("");
			}
		}).start();
	}
}