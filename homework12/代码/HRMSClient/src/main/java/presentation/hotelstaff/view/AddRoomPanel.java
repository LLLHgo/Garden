package presentation.hotelstaff.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Enum.ResultMessage;
import Enum.RoomState;
import presentation.hotelstaff.component.CancleButton;
import presentation.hotelstaff.component.ConfirmButton;
import presentation.hotelstaff.component.RoominfoTextField;
import presentation.hotelstaff.controller.HotelstaffViewController;
import vo.hotelinfoVO.RoominfoVO;
/** 
 * @version 1
 * @since 16.11.27
 * @author liuyu
 *
 */
public class AddRoomPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private HotelstaffViewController controller;
	private String hotelID;
	private ImageIcon image;
	private RoominfoTextField jtfroomNum;
	private RoominfoTextField jtfroomPrice;
	private JComboBox jcbState;
	private JComboBox jcbType;
	private String[] types;
	private String type;
	private String num;
	private String price;
	private String state;
	private ConfirmButton jbConfirm;
	private CancleButton jbCancle;
	private JLabel resultLabel;
	private RoominfoVO vo;
	
	public AddRoomPanel(HotelstaffViewController controller){
		this.controller = controller;
		this.hotelID = controller.gethotelID();
		initAddRoomPanel();
	}
	
	private void initAddRoomPanel(){
		this.setLayout(null);
		this.setLocation(0, 0);
		this.setSize(1000, 618);
		this.setVisible(true);
		setOpaque(false);
		
		//初始化背景
		image = new ImageIcon("./src/main/resource/picture/hotelinfo/room.png");
		
		jtfroomNum = new RoominfoTextField(406,128,200,30);
		jtfroomPrice = new RoominfoTextField(406,282,200,30);
		this.add(jtfroomNum);
		this.add(jtfroomPrice);
		
		types = controller.getRoomType();
		jcbType = new JComboBox(types);
		jcbType.setBounds(406,207,200,30);
		jcbType.setOpaque(false);
		jcbType.setBorder(null);
		jcbType.setSelectedItem(type);
		jcbType.setFont(new Font("微软雅黑",Font.PLAIN,20));
		this.add(jcbType);
		
		String [] states = {"可用","不可用"};
		jcbState = new JComboBox(states);
		jcbState.setBounds(406,370,200,30);
		jcbState.setOpaque(false);
		jcbState.setBorder(null);
//		jcbState.setSelectedItem(state.toString());
		jcbState.setFont(new Font("微软雅黑",Font.PLAIN,20));
		this.add(jcbState);
		
		//确认按钮，向bl层传数据
		jbConfirm = new ConfirmButton(830,446);
		jbConfirm.addActionListener(new ConfirmButtonActionListener());
		this.add(jbConfirm);
		
		//取消按钮，取消操作
		jbCancle = new CancleButton(700,450);
		jbCancle.addActionListener(new CancleButtonActionListener());
		this.add(jbCancle);
		
		//显示结果
		resultLabel = new JLabel();
		resultLabel.setForeground(Color.BLACK);
		resultLabel.setFont(new Font("微软雅黑",Font.PLAIN,20));
		resultLabel.setBounds(290, 50, 500, 20);
		this.add(resultLabel);
	}
	
	class ConfirmButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			vo = getRoominfoVO();
			if(vo!=null){
				ResultMessage result = controller.updateroominfo(vo, hotelID);

				if(result == ResultMessage.SUCCESS){
					controller.JBRoomClicked("新增成功");
				}else{
					showMessage(result.toString());
				}
			}
				
		}
		
	}
	
	class CancleButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			controller.JBRoomClicked("取消操作成功");
		}
		
	}
	
	private RoominfoVO getRoominfoVO(){
		if(jcbType.getSelectedItem()==null||jcbState.getSelectedItem()==null){
			showMessage("信息不完整，新增房间失败");
			return null;
		}
		//获得room属性
		num = jtfroomNum.getText();
		price = jtfroomPrice.getText();
			state = jcbState.getSelectedItem().toString();type = jcbType.getSelectedItem().toString();
			RoominfoVO vo1 = null;
	
		//如果没有填写完整，返回null
		if(num.equals("")||price.equals("")||type.equals("")||state.equals("")){
			showMessage("信息不完整，新增房间失败");
			return null;
		}
		//如果填写完整，返回vo包
		else{
			vo1 = new RoominfoVO();
			vo1.setHotelID(hotelID);
			try{
				vo1.setPrice(Double.parseDouble(price));
			}catch(NumberFormatException e){
				showMessage("数字格式错误");
			}
			vo1.setRoomNum(num);
			vo1.setType(type);
			if(state.equals("可用")){
				vo1.setRoomState(RoomState.Usable);
			}else{
				vo1.setRoomState(RoomState.Unusable);
			}
		}
		return vo1;
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
	
	protected void paintComponent(Graphics g) {
		g.drawImage(image.getImage(), 290,115,660,300,this);
    }
}
