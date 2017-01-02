package presentation.hotelstaff.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Enum.OrderType;
import Enum.ResultMessage;
import presentation.hotelstaff.component.ConfirmButton;
import presentation.hotelstaff.component.OrderTypeButton;
import presentation.hotelstaff.component.SearchButton;
import presentation.hotelstaff.controller.HotelstaffViewController;
import presentation.sitemanager.component.RefreshButton;
import vo.orderVO.OrderVO;
/**
 * @author liuyu
 *
 */
public class OrderPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	private HotelstaffViewController controller;
	private String hotelID;
	private ImageIcon init_image;
	private JTextField checkbox;
	private ImageIcon Icheckbox;
	private Font font;
	private ArrayList<OrderVO> orderList;
	private JScrollPane scrollPane=null;
	private ImageIcon orderBackground;
	private JLabel jlSearch;
	private OrderTypeButton jbAll;
	private OrderTypeButton jbUnexecuted;
	private OrderTypeButton jbExecuted;
	private OrderTypeButton jbAbnormal;
	private OrderTypeButton jbCancle;
	private JLabel jlDetailedSearch;
	private ImageIcon IDetailedSearch;
	private JButton jbDrag;
	private boolean buttonFlag;
	private JPanel orderPanel;
	private JLabel resultLabel;
	private SearchButton jbSearch;

	public OrderPanel(HotelstaffViewController controller){
		this.controller = controller;
		this.hotelID = controller.gethotelID();
		init();
	}

	private void init(){
		this.setLayout(null);
		this.setBounds(0,0,1000,618);
		this.setVisible(true);
		setOpaque(false);

		buttonFlag = true;

		Icheckbox = new ImageIcon(this.getClass().getResource("images/checkbox.png"));
		IDetailedSearch = new ImageIcon(this.getClass().getResource("images/searchbackground.png"));

		jlSearch = new JLabel();
		jlSearch.setBounds(330, 90, 180, 25);
		jlSearch.setForeground(Color.white);
		font = new Font("微软雅黑",Font.BOLD,15);
		jlSearch.setFont(font);
		jlSearch.setOpaque(false);
		jlSearch.setBorder(null);
		this.add(jlSearch);
		jlSearch.setText("所有订单");

		//下拉框背景
		jlDetailedSearch = new JLabel();
		jlDetailedSearch.setBounds(320, 100, 180, 200);
		jlDetailedSearch.setIcon(IDetailedSearch);
		jlDetailedSearch.setVisible(false);
		this.add(jlDetailedSearch);

		jbAll = new OrderTypeButton(315,120,"所有订单");
		jbUnexecuted = new OrderTypeButton(315,153,"未执行");
		jbExecuted = new OrderTypeButton(315,188,"已执行");
		jbAbnormal = new OrderTypeButton(315,223,"异常");
		jbCancle = new OrderTypeButton(315,260,"已撤销");
		jbAll.addActionListener(new SearchButtonActionListener());
		jbUnexecuted.addActionListener(new SearchButtonActionListener());
		jbExecuted.addActionListener(new SearchButtonActionListener());
		jbAbnormal.addActionListener(new SearchButtonActionListener());
		jbCancle.addActionListener(new SearchButtonActionListener());
		this.add(jbAll);
		this.add(jbUnexecuted);
		this.add(jbExecuted);
		this.add(jbAbnormal);
		this.add(jbCancle);

		jbDrag = new JButton();
		jbDrag.setIcon(new ImageIcon(this.getClass().getResource("images/triangle.png")));
		jbDrag.setBounds(480,90,25,25);
		jbDrag.setContentAreaFilled(false);
		jbDrag.setBorder(null);
		jbDrag.addActionListener(new DragButtonActionListener());
		this.add(jbDrag);
		jbDrag.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				showMessage("请选择订单状态");
			}

			@Override
			public void focusLost(FocusEvent e) {
			}

		});

		showAllOrderList();

		//搜索框
		checkbox = new JTextField();
		checkbox.setBounds(555,88,330,32);
		checkbox.setFont(font);
		checkbox.setBorder(null);
		checkbox.setOpaque(false);
		this.add(checkbox);
		checkbox.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				showMessage("请输入客户ID或订单ID");
			}

			@Override
			public void focusLost(FocusEvent e) {

			}

		});
		//搜索按钮
		jbSearch = new SearchButton(890,79);
		this.add(jbSearch);
		jbSearch.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String text = checkbox.getText();
				if(text.equals("")){
					showMessage("搜索内容不能为空");
				}else{
					orderList = controller.searchOrderFromHotelUI(hotelID,text);
					showSepcificOrder(orderList);
				}
			}

		});

		//更新酒店订单状态
		RefreshButton jbRefresh = new RefreshButton(890,560);
		jbRefresh.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.refreshroomstate();
				controller.JBOrderClicked("刷新成功");
			}

		});
		this.add(jbRefresh);

		//显示结果
		resultLabel = new JLabel();
		resultLabel.setForeground(Color.BLACK);
		resultLabel.setFont(font);
		resultLabel.setBounds(290, 50, 500, 20);
		this.add(resultLabel);
	}

	private class DragButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
//			if(buttonFlag){
				jbAll.setVisible(true);
				jbUnexecuted.setVisible(true);
				jbExecuted.setVisible(true);
				jbAbnormal.setVisible(true);
				jbCancle.setVisible(true);
				jlDetailedSearch.setVisible(true);
				scrollPane.setVisible(false);
				buttonFlag  = false;
//			}
//			else{
//				jbAll.setVisible(false);
//				jbUnexecuted.setVisible(false);
//				jbExecuted.setVisible(false);
//				jbAbnormal.setVisible(false);
//				jbCancle.setVisible(false);
//				jlDetailedSearch.setVisible(false);
//				scrollPane.setVisible(true);
//				buttonFlag = true;
//			}
		}
	}

	private class SearchButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jbAll){
				jlSearch.setText("所有订单");
				showAllOrderList();
			}else if(e.getSource()==jbUnexecuted){
				jlSearch.setText("未执行订单");
				showUnexecutedOrderList();
			}else if(e.getSource()==jbExecuted){
				jlSearch.setText("已执行订单");
				showExecutedOrderList();
			}else if(e.getSource()==jbAbnormal){
				jlSearch.setText("异常订单");
				showAbnormalOrderList();
			}else if(e.getSource()==jbCancle){
				jlSearch.setText("已撤销订单");
				showCancleOrderList();
			}
			jbAll.setVisible(false);
			jbUnexecuted.setVisible(false);
			jbExecuted.setVisible(false);
			jbAbnormal.setVisible(false);
			jbCancle.setVisible(false);
			jlDetailedSearch.setVisible(false);
			scrollPane.setVisible(true);
		}
	}


	private void showOrderList(ArrayList<OrderVO> orders){
		if(orders==null){
			showMessage("未找到订单");
			return;
		}

		//设置放置Order信息的JPanel
	    orderPanel=new JPanel();
	    orderPanel.setLayout(null);
	    orderPanel.setPreferredSize(new Dimension(620,30+120*orders.size()));
	    orderPanel.setBounds(0,0,1000,618);
	    orderPanel.setOpaque(false);

	    //设置放置showAbnormalOrderPanel的JScrollPanel
	    scrollPane = new JScrollPane(orderPanel);
	    scrollPane.setBounds(320, 130, 680, 360);
	    scrollPane.setBorder(new EmptyBorder(0,0,0,0));
	    scrollPane.setOpaque(false);
	    scrollPane.getViewport().setOpaque(false);
	    this.add(scrollPane);
	    int num=0;

	    Image image=new ImageIcon(this.getClass().getResource("images/hotelorder.png")).getImage();
	    for(OrderVO order:orders){
	    	//制作order背景
	        JPanel panel=new JPanel(){
				private static final long serialVersionUID = 1L;
				protected  void paintComponent(Graphics g) {
	            	g.drawImage(image,0,0,630,105,this);
	            }
			};
	        panel.setBounds(10, 10+120*num,630, 120);
	        panel.setLayout(null);
	        num++;
	        //制作order需要的组件
	        JLabel orderIDLabel=new JLabel("订单号："+order.getOrderId());
	        JLabel nameLabel=new JLabel("客户姓名："+order.getClientName());
	        JLabel priceLabel=new JLabel("价格："+String.valueOf(order.getPrice()));
	        JLabel entertimeLabel = new JLabel("计划入住时间："+order.getAnticipateArrivedTime());
	        JLabel leavetimeLabel = new JLabel("计划离开时间："+order.getAnticipateLeaveTime());
	        JLabel phoneLabel = new JLabel("客户电话："+order.getClientPhone());
	        JLabel roomTypeLabel = new JLabel(order.getRoomType());
	        JLabel roomNumLabel = new JLabel("* "+String.valueOf(order.getRoomNum()));
	        OrderType[] orderType = {OrderType.NORMALNONEXEC,OrderType.NORMALEXEC,
	        		OrderType.ABNORMAL,OrderType.CANCEL};
	        String stateLabelText = "";
	    	String [] sOrderType = {"未执行","已执行","异常","已撤销"};
	    	for(int i=0;i<orderType.length;i++){
	    		if(order.getOrderType()==orderType[i]){
	    			stateLabelText = sOrderType[i];
	    		}
	    	}
	        JLabel stateLabel = new JLabel(stateLabelText);

	        orderIDLabel.setBounds(5, 18, 220, 16);
	        nameLabel.setBounds(400,18,200,16);
	        priceLabel.setBounds(290,48,120,16);
	        entertimeLabel.setBounds(5,48,294,16);
	        leavetimeLabel.setBounds(5,77,295,16);
	        phoneLabel.setBounds(400,48,200,16);
	        stateLabel.setBounds(440,80,70,16);
	        roomTypeLabel.setBounds(265,18,96,16);
	        roomNumLabel.setBounds(360,18,90,16);


	        JLabel[] labelList = {orderIDLabel,nameLabel,priceLabel,entertimeLabel,
	        		phoneLabel,stateLabel,leavetimeLabel,roomTypeLabel,roomNumLabel};

	        for(int i=0;i<labelList.length;i++){
	        	panel.add(labelList[i]);
	        	labelList[i].setForeground(Color.white);
	        	labelList[i].setFont(new Font("微软雅黑",Font.PLAIN,16));
	        }

	        //确认入住按钮，按钮按下后订单状态改变
		    ConfirmButton button = new ConfirmButton(550,50);
		    panel.add(button);
	        button.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					order.setOrderStatus(OrderType.NORMALEXEC);
					ResultMessage result = controller.updateOrderState(order);
					if(result == ResultMessage.SUCCESS){
						controller.JBRoomClicked("订单状态已置为已执行，请选择房间",order);
						//showAllOrderList();
					}else{
						showMessage("修改失败");
					}
				}

	        });

	        if(stateLabelText.equals("已执行")){
	        	stateLabel.setForeground(Color.black);
	        	button.setVisible(false);
	        }else if(stateLabelText.equals("异常")){
	        	stateLabel.setForeground(Color.red);
	        }else if(stateLabelText.equals("已撤销")){
	        	button.setVisible(false);
	        }

	        orderPanel.add(panel);

	    };

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

	private void showAllOrderList(){
		if(scrollPane!=null){
			this.remove(scrollPane);
		}
		showOrderList((ArrayList<OrderVO>)controller.getALLHotelOrderList(hotelID,OrderType.ALL));

	}

	private void showUnexecutedOrderList(){
		if(scrollPane!=null){
			this.remove(scrollPane);
		}
		showOrderList((ArrayList<OrderVO>)controller.getUnexecutedHotelOrderList(hotelID,OrderType.NORMALNONEXEC));
	}


	private void showExecutedOrderList(){
		if(scrollPane!=null){
			this.remove(scrollPane);
		}
		showOrderList((ArrayList<OrderVO>)controller.getExecutedHotelOrderList(hotelID,OrderType.NORMALEXEC));
	}

	private void showAbnormalOrderList(){
		if(scrollPane!=null){
			this.remove(scrollPane);
		}
		showOrderList((ArrayList<OrderVO>)controller.getAbnormalHotelOrderList(hotelID,OrderType.ABNORMAL));
	}

	private void showCancleOrderList(){
		if(scrollPane!=null){
			this.remove(scrollPane);
		}
		showOrderList((ArrayList<OrderVO>)controller.getCancleHotelOrderList(hotelID, OrderType.CANCEL));
	}

	private void showSepcificOrder(ArrayList<OrderVO> list){
		if(scrollPane!=null){
			this.remove(scrollPane);
		}
		showOrderList(list);
		this.revalidate();
	}

	protected void paintComponent(Graphics g) {
		g.drawImage(Icheckbox.getImage(),310,90,200,25,this);
		g.drawImage(Icheckbox.getImage(),535,88,350,32,this);
    }

}
