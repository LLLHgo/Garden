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
import javax.swing.JRadioButton;

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

public class NewStrategyPanel extends JPanel{

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
	private int minSum;
	private int minRooms;
	
	public NewStrategyPanel(HotelstaffViewController controller){
		this.controller=controller;
		this.hotelID=controller.gethotelID();
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
		this.add(tpStart);
		this.add(tpEnd);
		
		jtfname = new TextField("",460,92,400,35,4);
		this.add(jtfname);
		
		jtfdiscount = new TextField("",460,237,50,35,4);
		this.add(jtfdiscount);
		
		jtfroom = new TextField("",460,401,50,35,4);
		this.add(jtfroom);
		
		jtfmoney = new TextField("",460,455,50,35,4);
		this.add(jtfmoney);
		
		jtflevel = new TextField("",460,347,50,35,4);
		this.add(jtflevel);
		
		jrbClient = new MJRadioButton("普通会员",true,455,295,120,35);
		jrbBusiness = new MJRadioButton("企业会员",true,620,295,120,35);
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
				if(discount>1||discount<=0){
					showMessage("折扣必须在0到1之间");
				}else{
					//TODO　对必须要大于0的判断 
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
						controller.JBStrategyClicked("新增策略成功");
					}else{
						showMessage(result.toString());
					}
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
