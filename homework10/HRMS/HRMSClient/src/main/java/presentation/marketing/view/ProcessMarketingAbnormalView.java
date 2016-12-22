package presentation.marketing.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Enum.OrderType;
import Enum.ResultMessage;
import datatool.OrderDataTool;
import presentation.marketing.compoment.MJButton;
import presentation.marketing.compoment.MJLabel;
import presentation.marketing.compoment.MJPanel;
import presentation.marketing.compoment.MJRadioButton;
import presentation.marketing.compoment.MJScrollPane;
import presentation.marketing.compoment.MJTextField;
import vo.orderVO.OrderVO;

public class ProcessMarketingAbnormalView extends JPanel{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ProcessMarketingViewControllerService controller;
	private Font font=new Font("微软雅黑",Font.HANGING_BASELINE,22);
	private Font font2=new Font("楷体",Font.PLAIN,17);
	private Font font3=new Font("微软雅黑",Font.HANGING_BASELINE,24);
	private String MarketingID;
	private JPanel searchPanel=new MJPanel(0, 80, 700, 70);
	private JPanel listPanel=new MJPanel(0, 80, 700, 70);
	private JPanel orderPanel;

	private MJButton searchButton=new MJButton("搜索订单",125, 0, 200, 80,font3);
	private MJButton listButton=new MJButton("异常订单列表",375,0, 200, 80,font3);

	private Icon searchBarIcon=new ImageIcon("./src/main/resource/picture/marketing/searchBar.png");
	private Icon searchKeyIcon=new ImageIcon("./src/main/resource/picture/marketing/searchKey.png");
	private Icon checkIcon=new ImageIcon("./src/main/resource/picture/marketing/littleCheck.png");

	private JLabel searchBarLabel=new MJLabel(60, 5, 500, 50,searchBarIcon);
	private JTextField searchBarField=new MJTextField(17, 0, 405,44,font2);
	private JButton searchKeyButton=new MJButton(550, 5, 60, 60,searchKeyIcon);

	private JLabel dateLabel=new MJLabel("输入日期",50, 0, 120, 70,font);
	private JButton listKeyButton=new MJButton(525,15, 60, 60,searchKeyIcon);

	private JTextField year=new MJTextField(200, 16, 62, 40,font3);
	private JTextField month=new MJTextField(310, 16, 42, 40,font3);
	private JTextField date=new MJTextField(400, 16, 42, 40,font3);

	private JLabel yearLabel=new MJLabel("年",275, 16, 30, 40,font2);
	private JLabel monthLabel=new MJLabel("月",355, 16, 30, 40,font2);
	private JLabel dayLabel=new MJLabel("日",445, 16, 30, 40,font2);

	public ProcessMarketingAbnormalView(ProcessMarketingViewControllerService controller,JPanel panel){
    	this.controller=controller;
    	this.MarketingID=controller.getMarketingID();
        this.setBounds(275, 82, 704, 500);
    	this.setLayout(null);
    	this.setOpaque(false);

		//添加搜索订单与查看订单列表Button
		this.add(searchButton);
		this.add(listButton);

    	//为搜索订单JLabel添加监听
    	searchButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				searchButtonClicked();
			}
    	} );

    	//为查看异常订单JLabel添加监听
    	listButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				listButtonClicked();
			}
       	});

    	panel.add(this);
	}

	public void searchButtonClicked() {
	   //searchAbnormalLabel点击后的JPanel
	   searchBarField.setText("");
	   listPanel.setVisible(false);
	   searchPanel.setVisible(true);
	   removeOrderPanel();

	   //为搜索Bar加组件 Label加背景Icon和JTextField
	   searchBarLabel.add(searchBarField);
	   searchPanel.add(searchBarLabel);

	    //为搜索key加组件 Label加背景和监听
	    searchKeyButton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
			    String orderIDEntered=searchBarField.getText();
			    OrderVO order=controller.findSpecificOrder(orderIDEntered);
			    ArrayList<OrderVO> orders=new ArrayList<OrderVO>();
			    if(order!=null){
			    	orders.add(order);
			        showAbnormalOrders(orders);//调用显示abnormalOrder的方法
			    }
		    }
	    });
	    searchPanel.add(searchKeyButton);

        this.add(searchPanel);
        this.revalidate();
        this.repaint();
    }

	public void listButtonClicked() {
		//listButton点击后的JPanel
        searchPanel.setVisible(false);
        listPanel.setVisible(true);
        removeOrderPanel();

        Calendar c=Calendar.getInstance();
		year.setText(c.get(Calendar.YEAR)+"");
		month.setText(""+(c.get(Calendar.MONTH)+1)%12);
		date.setText(""+c.get(Calendar.DATE));

		 //为搜索key加组件 Label加背景和监听
	    listKeyButton.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	int yearEntered=Integer.parseInt(year.getText());
		    	int monthEntered=Integer.parseInt(month.getText());
		    	int dateEntered=Integer.parseInt(date.getText());
		    	@SuppressWarnings("deprecation")
				Date date=new Date(yearEntered,monthEntered,dateEntered);
			    ArrayList<OrderVO> orders=(ArrayList<OrderVO>) controller.findAbnormalOrderList(date);
			    showAbnormalOrders(orders);//调用显示abnormalOrder的方法
		    }
	    });

   		listPanel.add(dateLabel);
		listPanel.add(year);
		listPanel.add(month);
		listPanel.add(date);
		listPanel.add(yearLabel);
		listPanel.add(monthLabel);
		listPanel.add(dayLabel);
		listPanel.add(listKeyButton);

		this.add(listPanel);
		this.revalidate();
   		this.repaint();
	}

   public void showAbnormalOrders(ArrayList<OrderVO> orders){
	    orders=OrderDataTool.list1;
	   removeOrderPanel();
	   if(orders==null||orders.size()==0)return;
	   //设置放置Order信息的JPanel
       orderPanel=new MJPanel(0, 0, 702, 3520);
       orderPanel.setPreferredSize(new Dimension(680,+30+150*orders.size()));

       //放置showAbnormalOrderPanel的JScrollPanel
       JScrollPane showAbnormalScroll = new MJScrollPane(20, 150, 699, 365,orderPanel);
       int num=0;

       Image image=new ImageIcon("./src/main/resource/picture/marketing/orderBackground.png").getImage();
       for(OrderVO order:orders){
    	    //制作order背景
            JPanel panel=new JPanel(){
				private static final long serialVersionUID = 1L;
				protected  void paintComponent(Graphics g) {
	            	g.drawImage(image,0,0,getSize().width,getSize().height,this);
	            }
			};
	        panel.setBounds(10, 10+150*num, 700, 150);
	        panel.setLayout(null);

	        //制作order需要的组件
	        JLabel nameLabel=new MJLabel("用户："+order.getClientName(),5, 5, 600, 30,font2);
	        JLabel orderIDLabel=new MJLabel("订单号："+order.getOrderId(),5, 31, 600, 30,font2);
	        JLabel hotelLabel=new MJLabel("入住酒店："+order.getHotelName(),5, 57, 300, 30,font2);
	        JLabel priceLabel=new MJLabel("订单价格："+order.getPrice(),310, 57, 300, 30,font2);
	        JLabel creditLabel=new MJLabel("恢复信用值 ",5, 86, 300, 30,font2);
	        JRadioButton fullButton=new MJRadioButton("全额",false,165, 86, 67, 30,font2);
	        JRadioButton halfButton=new MJRadioButton("半额",false,280, 86, 67, 30,font2);
	        JButton checkButton=new MJButton(430, 86, 30, 30,checkIcon);

	        ButtonGroup group=new ButtonGroup();
	        group.add(fullButton);
	        group.add(halfButton);

	        panel.add(nameLabel);
	        panel.add(orderIDLabel);
	        panel.add(hotelLabel);
	        panel.add(priceLabel);
	        panel.add(creditLabel);
	        panel.add(fullButton);
	        panel.add(halfButton);


	        //对撤销订单label加监听
	        checkButton.addActionListener(new ActionListener(){
	        	boolean ifSuccess=false,ifSet=false;
				@Override
				public void actionPerformed(ActionEvent e) {
					if (!checkButton.isEnabled())return ;
					String log=MarketingID+" 撤销异常订单 "+order.orderId;
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					if(fullButton.isSelected()){
						if(controller.setCredit(order.getClientId(),order.getPrice())){
							ifSet=true;
						    log=log+" 全额："+order.getPrice()+" ";
						}
					}else if(halfButton.isSelected()){
						if(controller.setCredit(order.getClientId(),order.getPrice()*0.5)){
							ifSet=true;
						    log=log+" 半额:"+order.getPrice()*0.5+" ";
						}
					}
					if (ifSet){
						order.setOrderStatus(OrderType.ABNORMALCANCEL);
						if(controller.saveOrder(order)==ResultMessage.SUCCESS){
							log=log+df.format(new Date((System.currentTimeMillis())));
							controller.addLog(log);
							ifSuccess=true;
						}
					}

					//分情况讨论ifSuccess是否成功
					if(ifSuccess){
						checkButton.setEnabled(false);
					    fullButton.setEnabled(false);
					    halfButton.setEnabled(false);
						//进行成功提示显示
					}else{
						//进行失败提示
					}
				}
	        });
	        panel.add(checkButton);

	        orderPanel.add(panel);
	        num++;
	    }

	    this.add(showAbnormalScroll);
	    this.revalidate();
	    this.repaint();
}

	public void hideAbnormal() {
		this.removeAll();
		this.setVisible(false);
	}
    public void removeOrderPanel(){
    	if(orderPanel!=null){
    		orderPanel.setVisible(false);
    		orderPanel.removeAll();
    	}
    	orderPanel=null;
    }


}