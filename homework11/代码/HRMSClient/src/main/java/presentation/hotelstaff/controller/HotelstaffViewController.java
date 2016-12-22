package presentation.hotelstaff.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import Enum.OrderType;
import Enum.ResultMessage;
import businesslogic.hotelstaffbl.HotelstaffBLController;
import businesslogicservice.hotelstaffblservice.HotelstaffControllerBLService;
import presentation.hotelstaff.view.AddRoomPanel;
import presentation.hotelstaff.view.BirthdayStrategyPanel;
import presentation.hotelstaff.view.BusinessStrategyPanel;
import presentation.hotelstaff.view.DetailedStrategy;
import presentation.hotelstaff.view.PeriodStrategy;
import presentation.hotelstaff.view.HotelinfoPanel;
import presentation.hotelstaff.view.HotelstaffPanel;
import presentation.hotelstaff.view.NewRoominfoPanel;
import presentation.hotelstaff.view.NewStrategyPanel;
import presentation.hotelstaff.view.OrderPanel;
import presentation.hotelstaff.view.RoomStrategyPanel;
import presentation.hotelstaff.view.StrategyPanel;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

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
	public ArrayList<HotelinfoVO> getHotelBasicinfoList(String area) {
		return controller.getHotelBasicinfoList(area);
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
	public double calculatePrice(ArrayList<HotelStrategyVO> hotelStrategyList,
			ArrayList<MarketingStrategyVO> marketingStrategyList, ClientVO vo,String hotelID,RoominfoVO roomVO,int num) {
		return controller.calculatePrice(hotelStrategyList, marketingStrategyList, vo, hotelID,roomVO,num);
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
	public ResultMessage deletehotelStrategy(HotelStrategyVO hotelStrategy) {
		return controller.deletehotelStrategy(hotelStrategy);
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


	public void detailedStrategy(HotelStrategyVO vo) {
		HotelstaffViewController panelcontroller=HotelstaffViewController.getInstance(hotelID);
		if(panel!=null){
			view.remove(panel);
		}
		if(vo.getName().equals("生日特惠折扣")){
			panel = new BirthdayStrategyPanel(panelcontroller,vo);
		}else if(vo.getName().equals("三间及以上预订特惠")){
			panel = new RoomStrategyPanel(panelcontroller,vo);
		}else if(vo.getName().equals("合作企业客户折扣")){
			panel = new BusinessStrategyPanel(panelcontroller,vo);
		}else if(vo.getName().equals("双十一活动折扣")){
			panel = new PeriodStrategy(panelcontroller,vo);
		}else{
			panel = new DetailedStrategy(panelcontroller,vo);
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


}
