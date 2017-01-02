package presentation.client.compoment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Enum.OrderType;
import Enum.ResultMessage;
import presentation.client.controller.SearchPanelController;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.orderVO.OrderVO;
import vo.priceVO.PriceVO;



/**
 * 生成订单的frame类，显示订单详情界面
 * @author ClaraLee
 *
 */
public class OrderCreateFrame extends JFrame{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	OrderCreatePanel hdp;
	private  JPanel Panel;
	private DateChooser begin;
	private DateChooser end;
	private HotelinfoVO hotelVO;
	private SearchPanelController controller;
	private ClientVO client;
	PriceVO pricevo;
	JFrame frame;
	private JTextArea strategyArea;
	public OrderCreateFrame(ClientVO client,SearchPanelController controller,HotelinfoVO hotelVO){
		pricevo=new PriceVO(0,null);
		this.controller=controller;
		this.hotelVO=hotelVO;
		this.client=client;
		this.setLayout(null);
		begin=new DateChooser();
		end=new DateChooser();
		this.add(begin);
		begin.setOpaque(false);
		begin.setBorder(new EmptyBorder(0,0,0,0));
		begin.setBounds(150,187,100,25);

		this.add(end);
		end.setOpaque(false);
		end.setBorder(new EmptyBorder(0,0,0,0));
		end.setBounds(330,187,100,25);
		end.addMouseListener(new mouseListener());
		this.pack();


		Panel=new JPanel();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		hdp=new OrderCreatePanel(this);
		this.add(hdp);
		this.setLocationRelativeTo(null);




		this.setVisible(true);
		this.setResizable(false);
		this.setSize(591, 433);
		this.setLocation(400,200);
		frame=this;
	}
	class mouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub


		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			//对订单信息的检查
			  int i=0;
			  for(;i<hdp.crlp.rooms.size();i++){
				  if(hdp.crlp.rooms.get(i).numField.getText().charAt(0)!='<')
					  break;
			  }
			  int days=hdp.calTime(begin.getChooseDate(),end.getChooseDate());
			  if(days<0)days=0;
			  int num=Integer.parseInt(hdp.crlp.rooms.get(i).numField.getText());

			  RoominfoVO room=hotelVO.getRoominfoList().get(i);
			 double beforeprice=num*days*room.getPrice();
					 pricevo=controller.calculatePrice(client,room,hotelVO,num,days);
					 String Strategy="优惠策略：";
					 for(int k=0;k<pricevo.getStrategys().size();k++)
						 Strategy=Strategy+pricevo.getStrategys().get(k)+"\n";
					 strategyArea.setText(Strategy);
			hdp.actualMoneyLabel.setText(Double.toString(pricevo.getPrice()));
			  hdp.totalMoneyLabel.setText(Double.toString(beforeprice));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}
	class OrderCreatePanel extends JPanel{
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;
		private ImageIcon imageIcon = null;
		private Label hotelNameLabel;
		private Label totalMoneyLabel;
		private Label actualMoneyLabel;
		private Field nameField;
		private chooseRoomListPane crlp;
		private deleteButton delete;
		private JLabel hint;
		okButton ok;

		public OrderCreatePanel(JFrame frame){
			crlp=new chooseRoomListPane(hotelVO.getRoominfoList());
			System.out.println(hotelVO.getRoominfoList().size());
			frame.add(crlp);
		imageIcon = new ImageIcon(this.getClass().getResource("image/OrderCreatePanel.png"));
		hotelNameLabel=new Label(hotelVO.getName(),90,13,300,30);
		totalMoneyLabel=new Label("0",117,240,300,30);
		actualMoneyLabel=new Label("0",374,238,300,30);
		nameField=new Field("",123,70,92,30,20);

		delete=new deleteButton(300,310);
		delete.addActionListener(new deleteButtonListener());
		ok=new okButton(400,290);
		ok.addActionListener(new okButtonListener());
		this.add(delete);
		this.add(ok);

		hint=new JLabel("请选择一种类型的房间");
		hint.setFont(new java.awt.Font("微软雅黑", 4,  18));
		hint.setForeground(Color.WHITE);
		hint.setBounds(360,130,250,20);
		this.add(hint);

		strategyArea=new JTextArea();
		strategyArea.setBounds(40,280,300,150);
		strategyArea.setOpaque(false);
		strategyArea.setForeground(Color.WHITE);
		strategyArea.setFont(new java.awt.Font("微软雅黑", 4,  20));
		strategyArea.setLineWrap(true);
		strategyArea.setCaretColor(Color.WHITE);

		this.add(strategyArea);
		this.add(hotelNameLabel);
		this.add(nameField);
		this.add(totalMoneyLabel);
		this.add(actualMoneyLabel);
		this.setVisible(true);
	    this.setLayout(null);
	    this.setBounds(0,0,591,413);
	    this.setOpaque(false);
	    this.setVisible(true);
	    this.repaint();

		}

		private class okButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Date date=new Date();
				  DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				  String time=format.format(date);
				  int i=0;
				  for(;;i++){
					  if(crlp.rooms.get(i).numField.getText().charAt(0)!='<'&&crlp.rooms.get(i).numField.getText().charAt(0)>'0'&&crlp.rooms.get(i).numField.getText().charAt(0)<='9')
						  break;
				  }

				  String begindate=begin.getChooseDate();
				  String enddate=end.getChooseDate();
				  int days=calTime(begindate,enddate);
				  int begin=calTime(time,begindate);
				  int num=Integer.parseInt(crlp.rooms.get(i).numField.getText());
				  RoominfoVO room=hotelVO.getRoominfoList().get(i);
				  double beforeprice=num*days*room.getPrice();
				  pricevo=controller.calculatePrice(client,room,hotelVO,num,days);
				  if(client.getCredit()<0)
					  hint.setText("您的信用值不足，请尽快充值");
				  else if(days<=0||begin<0){
					  hint.setText("请输入正确的日期");
				  }
				  else if(nameField.getText().equals(""))
					  hint.setText("请输入入住人姓名");
				  else{
				  OrderVO order=createOrderVO(nameField.getText(),time,pricevo.getPrice(),pricevo.getStrategys(),room.getType(),num,days,beforeprice);
				  ResultMessage rs=controller.createOrderPO(order);
				  if(rs==ResultMessage.SUCCESS)new Thread(new Runnable(){
						@Override
						public void run() {
							hint.setText("下单成功");
							try {
								Thread.sleep(1500);
								frame.dispose();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}).start();
				  else new Thread(new Runnable(){
						@Override
						public void run() {
							hint.setText("下单失败");
							try {
								Thread.sleep(1500);
								frame.dispose();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}).start();
				  }
			}

		}
		//根据界面信息形成订单vo
		private OrderVO createOrderVO(String name,String time,double price,ArrayList<String> strategy,String roomType,int num,int days,double prePrice){
			OrderVO order=new OrderVO();
			order.setOrderId("");
			order.setClientId(client.getID());
			order.setClientName(name);
			order.setOrderDate(time);
			order.setHotelName(hotelVO.getName());
			order.setClientPhone(client.getTel());
			order.setHotelId(hotelVO.getHotelID());
			//以后补上
			order.setPrice(price);

			order.setStrategies(strategy );
			order.setVipType(client.getType());
			order.setRoomType(roomType);
			order.setRoomNum(num);
			order.setOrderType(OrderType.NORMALNONEXEC);
			order.setAnticipateArrivedTime(begin.getChooseDate());
			order.setAnticipateLeaveTime(end.getChooseDate());
			order.setActualArrivedTime("");
			order.setDays(days);
			order.seteValuate(false);
			order.setPrePrice(prePrice);
			return order;
		}
		private int calTime(String begin,String end){
			int beginday=(begin.charAt(9)-'0')+10*(begin.charAt(8)-'0');
			int endday=(end.charAt(9)-'0')+10*(end.charAt(8)-'0');
			int beginmon=(begin.charAt(6)-'0')+10*(begin.charAt(5)-'0');
			int endmon=(end.charAt(6)-'0')+10*(end.charAt(5)-'0');
			int res=0;
			if(beginmon<endmon){
				res+=31-beginday+endday;
			}
			else
				res+=(endday-beginday);

			return res;
		}
		private class deleteButtonListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nameField.setText("");
				totalMoneyLabel.setText("");
				actualMoneyLabel.setText("");
			}

		}
		class Label extends JLabel{
			/**
			 *
			 */
			private static final long serialVersionUID = 1L;

			public Label(String str,int x,int y,int w,int h){
				super(str);
				java.awt.Font f=new java.awt.Font("微软雅黑", 4,  25);
				this.setFont(f);
				this.setForeground(Color.WHITE);
				this.setBounds(x,y,w,h);
			}
		}
		class Field extends JTextField{
			/**
			 *
			 */
			private static final long serialVersionUID = 1L;

			public Field(String str,int x,int y,int w,int h,int big){
				super(str);
				java.awt.Font f=new java.awt.Font("微软雅黑", 4,  big);
				this.setFont(f);
				this.setForeground(Color.WHITE);
				this.setBorder(new EmptyBorder(0,0,0,0));
				this.setBounds(x,y,w,h);
				this.setOpaque(false);
				this.setFocusable(true);

			}
		}
		  class chooseRoomListPane extends JScrollPane{
			  /**
			 *
			 */
			private static final long serialVersionUID = 1L;
			ArrayList<chooseRoomPanel> rooms;
			public chooseRoomListPane(ArrayList<RoominfoVO> list){

				super(Panel);
				rooms=new ArrayList<chooseRoomPanel>();
				Panel.setLayout(null);
			    Panel.setPreferredSize(new Dimension(200,list.size()*35));
			    Panel.setBounds(0,0,1000,4000);
			    Panel.setOpaque(false);


			   this.setBounds(150, 134, 720, 50);
			   this.setOpaque(false);
			   this.getViewport().setOpaque(false);
			   this.getVerticalScrollBar().setVisible(false);
			   this.setBorder(new EmptyBorder(0,0,0,0));
			   this.setVisible(true);
			   if(list!=null)
			    for(int i=0;i<list.size();i++){
			    	RoominfoVO vo=list.get(i);
	//		    	System.out.println(vo.getType()+"type");
		//	    	System.out.println(hotelVO.getAvailableNum().get(i)+"num");
			    	chooseRoomPanel p=new chooseRoomPanel(0, i*35,vo.getType(),hotelVO.getAvailableNum().get(i)+1);
			    	 Panel.add(p);
			    	 rooms.add(p);
			    }
			    this.getVerticalScrollBar().setVisible(false);

			}
		}
		@Override
		public void paintComponent(Graphics g) {
			    g.drawImage(imageIcon.getImage(), 0, 0, this);
			    super.paintComponents(g);
			   }
	}

}
