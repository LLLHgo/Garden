package presentation.hotelstaff.controller;

import java.util.ArrayList;

import javax.swing.JPanel;

import Enum.HotelStrategy;
import Enum.OrderType;
import Enum.ResultMessage;
import businesslogic.hotelstaffbl.HotelstaffBLController;
import businesslogicservice.hotelstaffblservice.HotelstaffControllerBLService;
import presentation.hotelstaff.view.AddRoomPanel;
import presentation.hotelstaff.view.BirthdayStrategyPanel;
import presentation.hotelstaff.view.BusinessStrategyPanel;
import presentation.hotelstaff.view.DetailedStrategyPanel;
import presentation.hotelstaff.view.HotelinfoPanel;
import presentation.hotelstaff.view.HotelstaffPanel;
import presentation.hotelstaff.view.NewRoominfoPanel;
import presentation.hotelstaff.view.NewStrategyPanel;
import presentation.hotelstaff.view.OrderPanel;
import presentation.hotelstaff.view.PeriodStrategy;
import presentation.hotelstaff.view.RoomStrategyPanel;
import presentation.hotelstaff.view.StrategyPanel;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;

public class HotelstaffViewController implements HotelstaffViewControllerService{

	private static HotelstaffViewController viewcontroller;

	private String hotelID;
	public JPanel view;
	public JPanel panel;

	HotelstaffControllerBLService controller;

	public String gethotelID(){
		return hotelID;
	}

	private HotelstaffViewController(String hotelID){
		this.hotelID = hotelID;
		controller = new HotelstaffBLController();
	}

	public static HotelstaffViewController getInstance(String hotelID){
		if(viewcontroller == null){
			viewcontroller = new HotelstaffViewController(hotelID);
		}
		return viewcontroller;
	}

	public void setView(JPanel view){
		this.view = view;
	}

	@Override
	public HotelinfoVO getHotelBasicinfo(String hotelID) {
		return controller.getHotelBasicinfo(hotelID);
	}

	@Override
	public ArrayList<HotelinfoVO> getHotelBasicinfoList(String area,String hotelname,int star,String roomType) {
		return controller.getHotelBasicinfoList(area,hotelname,star,roomType);
	}

	@Override
	public ResultMessage updateBassicinfo(HotelinfoVO VO) {
		return controller.updateBassicinfo(VO);
	}

	@Override
	public RoominfoVO getRoominfo(String hotelID, String roomID) {
		return controller.getroominfo(hotelID, roomID);
	}

	@Override
	public ArrayList<RoominfoVO> getRoominfoList(String hotelID) {
		return controller.getRoominfoList(hotelID);
	}

	@Override
	public ResultMessage updatehotelStrategy(HotelStrategyVO vo) {
		 return controller.updatehotelStrategy(vo);
	}

	@Override
	public ArrayList<HotelStrategyVO> gethotelStrategy(String hotelID) {
		return (ArrayList<HotelStrategyVO>) controller.gethotelStrategy(hotelID);
	}

	@Override
	public HotelinfoVO gethotelinfoVO(String hotelID) {
		return controller.getHotelBasicinfo(hotelID);
	}

	@Override
	public RoominfoVO getroominfo(String hotelID, String roomID) {
		return controller.getroominfo(hotelID, roomID);
	}

	@Override
	public ResultMessage updateroominfo(RoominfoVO vo,String hotelID) {
		return controller.updateroominfo(vo,hotelID);
	}

	@Override
	public ResultMessage updateOrderState(OrderVO vo) {
		return controller.updateOrderState(vo);
	}

	@Override
	public ArrayList<OrderVO> getALLHotelOrderList(String hotelID, OrderType ALL) {
		return (ArrayList<OrderVO>) controller.getALLHotelOrderList(hotelID,ALL);
	}

	@Override
	public ArrayList<OrderVO> getUnexecutedHotelOrderList(String hotelID, OrderType NORMALEXEC) {
		return (ArrayList<OrderVO>) controller.getUnexecutedHotelOrderList(hotelID,NORMALEXEC);
	}

	@Override
	public ArrayList<OrderVO> getExecutedHotelOrderList(String hotelID, OrderType NORMALNONEXEC) {
		return (ArrayList<OrderVO>) controller.getExecutedHotelOrderList(hotelID,NORMALNONEXEC);
	}

	@Override
	public ArrayList<OrderVO> getAbnormalHotelOrderList(String hotelID, OrderType ABNORMALCANCEL) {
		return (ArrayList<OrderVO>) controller.getAbnormalHotelOrderList(hotelID,ABNORMALCANCEL);
	}

	@Override
	public ArrayList<OrderVO> getCancleHotelOrderList(String hotelID, OrderType ABNORMALCANCEL) {
		return (ArrayList<OrderVO>) controller.getCancleHotelOrderList(hotelID,ABNORMALCANCEL);
	}

	@Override
	public String getHotelstaffBasicinfo(String hotelID) {
		return controller.getHotelstaffBasicinfo(hotelID);
	}

	@Override
	public ResultMessage setPassword(String hotelID, String password) {
		return controller.setPassword(hotelID, password);
	}

	@Override
	public boolean checkAccount(String hotelID, String password) {
		return controller.checkAccount(hotelID, password);
	}

	@Override
	public ResultMessage addArea(String area) {
		return controller.addArea(area);
	}

	@Override
	public String[] getArea() {
		return controller.getArea();
	}


	@Override
	public ResultMessage addRoomType(String type) {
		return controller.addRoomType(type);
	}

	@Override
	public String[] getRoomType() {
		return controller.getRoomType();
	}

	public boolean addroominfo(RoominfoVO vo){
		return controller.addroominfo(vo);
	}

	@Override
	public ArrayList<OrderVO> getExecutedHotelOrderList(String hotelID, String clientID) {
		return (ArrayList<OrderVO>) controller.getExecutedHotelOrderList( hotelID,clientID);
	}

	public void JBHotelinfoClicked(){
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		panel = new HotelinfoPanel(panelcontroller);
		view.add(panel);
		panel.revalidate();
		panel.repaint();
	}
	public void JBHotelinfoClicked(String message){
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		panel = new HotelinfoPanel(panelcontroller);
		((HotelinfoPanel)panel).showMessage(message);
		view.add(panel);
		panel.revalidate();
		panel.repaint();
	}

	public void JBRoominfoClicked(){
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		panel = new NewRoominfoPanel(panelcontroller);
		view.add(panel);
		panel.revalidate();
		panel.repaint();
	}

	public void JBRoominfoClicked(String message){
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		panel = new NewRoominfoPanel(panelcontroller);
		((NewRoominfoPanel)panel).showMessage(message);
		view.add(panel);
		panel.revalidate();
		panel.repaint();
	}

	public void JBOrderClicked(){
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		panel = new OrderPanel(panelcontroller);
		view.add(panel);
		panel.revalidate();
		panel.repaint();
	}
	public void JBOrderClicked(String message){
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		panel = new OrderPanel(panelcontroller);
		((OrderPanel)panel).showMessage(message);
		view.add(panel);
		panel.revalidate();
		panel.repaint();
	}

	public void JBPersonalinfoClicked(){
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		panel = new HotelstaffPanel(panelcontroller);
		view.add(panel);
		panel.revalidate();
		panel.repaint();
	}


	public void JBExitClicked(){
		System.exit(0);
	}

	public void JBAddRoomClicked(){
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		panel = new AddRoomPanel(panelcontroller);
		view.add(panel);
		panel.revalidate();
		panel.repaint();
	}

	public void JBStrategyClicked(){
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		panel = new StrategyPanel(panelcontroller);
		view.add(panel);
		panel.revalidate();
		panel.repaint();
	}

	public void JBStrategyClicked(String message){
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		panel = new StrategyPanel(panelcontroller);
		view.add(panel);
		((StrategyPanel)panel).showMessage(message);
		panel.revalidate();
		panel.repaint();
	}

	public void JBRoomClicked(String message){
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		panel = new NewRoominfoPanel(panelcontroller);
		view.add(panel);
		((NewRoominfoPanel)panel).showMessage(message);
		panel.revalidate();
		panel.repaint();
	}

	public void JBRoomClicked(String message,OrderVO vo){
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		String type = vo.getRoomType();
		if(panel!=null){
			view.remove(panel);
		}
		panel = new NewRoominfoPanel(panelcontroller);
		view.add(panel);
			ArrayList<RoominfoVO> preList = getRoominfoList(hotelID);
			ArrayList<RoominfoVO> afterList = new ArrayList<RoominfoVO>();
			for(int i=0;i<preList.size();i++){
				if(preList.get(i).getType().equals(type)){
					afterList.add(preList.get(i));
				}
			}
		((NewRoominfoPanel)panel).showSpecificType(afterList);
		((NewRoominfoPanel)panel).showMessage(message);
		panel.revalidate();
		panel.repaint();
	}

	public void detailedStrategy(HotelStrategyVO vo) {
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		if(vo.getName().equals("生日特惠折扣")||vo.getType()==HotelStrategy.BIRTHDAY){
			panel = new BirthdayStrategyPanel(panelcontroller,vo);
		}else if(vo.getName().equals("三间及以上预订特惠")||vo.getType()==HotelStrategy.OVERTHREEROOMS){
			panel = new RoomStrategyPanel(panelcontroller,vo);
		}else if(vo.getName().equals("合作企业客户折扣")||vo.getType()==HotelStrategy.COMPANY){
			panel = new BusinessStrategyPanel(panelcontroller,vo);
		}else if(vo.getName().equals("双十一活动折扣")||vo.getType()==HotelStrategy.SPECIALDAY){
			panel = new PeriodStrategy(panelcontroller,vo);
		}else{
			panel = new DetailedStrategyPanel(panelcontroller,vo);
		}

		view.add(panel);
		//TODO
//		((NewRoominfoPanel)panel).showMessage(message);
		panel.revalidate();
		panel.repaint();

	}

	@Override
	public void newStrategy() {
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		panel = new NewStrategyPanel(panelcontroller);
		view.add(panel);
		panel.revalidate();
		panel.repaint();
	}

	@Override
	public ArrayList<OrderVO> searchOrderFromHotelUI(String hotelID, String text) {
		return controller.searchOrderFromHotelUI(hotelID, text);
	}

	@Override
	public boolean addLog(String s) {
		return controller.addLog(s);
	}

	@Override
	public boolean deleteroominfo(String hotelID , String roomID) {
		return controller.deleteroom(hotelID,roomID);
	}

	@Override
	public boolean refreshroomstate() {
		return controller.refreshroomstate();
	}
}
