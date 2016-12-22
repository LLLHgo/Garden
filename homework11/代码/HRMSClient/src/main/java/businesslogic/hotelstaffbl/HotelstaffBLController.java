package businesslogic.hotelstaffbl;

import java.util.ArrayList;

import Enum.OrderType;
import Enum.ResultMessage;
import businesslogic.hoteinfobl.HotelinfoManage;
import businesslogic.hoteinfobl.RoominfoManage;
import businesslogic.logbl.LogManage;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService;
import businesslogicservice.hotelstaffblservice.HotelstaffControllerBLService;
import businesslogicservice.logblservice.LogBLService;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import businesslogicservice.orderblservice.OrderBLService_Stub;
import businesslogicservice.orderblservice.OrderFindBLService;
import businesslogicservice.orderblservice.OrderOperatorBLService;
import businesslogicservice.strategyblservice.StrategyBLService;
import businesslogicservice.strategyblservice.StrategyBLService_Stub;
import presentation.hotelstaff.controller.HotelstaffViewController;
import presentation.hotelstaff.view.AddRoomPanel;
import presentation.hotelstaff.view.BirthdayStrategyPanel;
import presentation.hotelstaff.view.BusinessStrategyPanel;
import presentation.hotelstaff.view.DetailedStrategy;
import presentation.hotelstaff.view.HotelinfoPanel;
import presentation.hotelstaff.view.HotelstaffPanel;
import presentation.hotelstaff.view.NewRoominfoPanel;
import presentation.hotelstaff.view.NewStrategyPanel;
import presentation.hotelstaff.view.OrderPanel;
import presentation.hotelstaff.view.PeriodStrategy;
import presentation.hotelstaff.view.RoomStrategyPanel;
import presentation.hotelstaff.view.StrategyPanel;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;
/**
 * 这是酒店工作人员在BL层的一个controller，负责将方法分派给BL层中的其他类。由于lq老师上课介绍说View层的controller是不可以知道
 * BL层的逻辑的，但是当时我在View层的controller已经写好了，所以就保留了view层的controller，但具体逻辑实现还是在现在的这个controller里
 * @version 1
 * @since 16.12.3
 * @author liuyu
 *
 */
public class HotelstaffBLController implements HotelstaffControllerBLService{
	
	HotelinfoBLService hotelinfo;
	HotelinfoBLService roominfo;
	StrategyBLService strategy;
	OrderFindBLService orderFind;
	OrderOperatorBLService orderOperator;
	HotelstaffBLService hotelstaff;
	LogBLService log;
	
	public HotelstaffBLController(){
		hotelinfo = new HotelinfoManage();
		roominfo = new RoominfoManage();
//		orderFind = new OrderFind();
//		orderOperator=new OrderOperator();
//		strategy = new StrategyManage();
		hotelstaff = new HotelstaffManage();
		log = new LogManage();
		
//		hotelinfo = new HotelinfoBLService_stub();
		strategy = new StrategyBLService_Stub();
		orderFind = new OrderBLService_Stub();
		orderOperator=new OrderBLService_Stub();
//		hotelstaff = new HotelstaffBLService_stub();

	}
	
	@Override
	public HotelinfoVO getHotelBasicinfo(String hotelID) {
		return hotelinfo.getBasicinfo(hotelID);
	}

	@Override
	public ArrayList<HotelinfoVO> getHotelBasicinfoList(String area) {
		return hotelinfo.getBasicinfoList(area);
	}

	@Override
	public ResultMessage updateBassicinfo(HotelinfoVO VO) {
		return hotelinfo.updateBassicinfo(VO);
	}

	@Override
	public RoominfoVO getRoominfo(String hotelID, String roomID) {
		return roominfo.getroominfo(hotelID, roomID);
	}

	@Override
	public ArrayList<RoominfoVO> getRoominfoList(String hotelID) {
		return roominfo.getRoominfoList(hotelID);
	}

	@Override
	public double calculatePrice(ArrayList<HotelStrategyVO> hotelStrategylist,
			ArrayList<MarketingStrategyVO> marketingStrategyList,ClientVO vo,String hotelID,RoominfoVO roomVO,int num) {
		
		return roominfo.calculatePrice(hotelStrategylist,marketingStrategyList,vo,hotelID,roomVO,num);
	}


	@Override
	public ResultMessage updatehotelStrategy(HotelStrategyVO vo) {
		 return strategy.updateHotelStrategy(vo);
	}

	@Override
	public ArrayList<HotelStrategyVO> gethotelStrategy(String hotelID) {
		return (ArrayList<HotelStrategyVO>) strategy.getHotelStrategy(hotelID);
	}

	@Override
	public ResultMessage deletehotelStrategy(HotelStrategyVO hotelStrategy) {
		boolean result = strategy.deletehotelStrategy(hotelStrategy);
		if(result == true){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.FAIL;
		}
	}

	@Override
	public RoominfoVO getroominfo(String hotelID, String roomID) {
		return roominfo.getroominfo(hotelID, roomID);
	}

	@Override
	public ResultMessage updateroominfo(RoominfoVO vo,String hotelID) {
		if(roominfo.updateroominfo(vo,hotelID)==true){
			return ResultMessage.SUCCESS;
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage updateOrderState(OrderVO vo) {
		return orderOperator.saveOrderPO(vo);
	}

	@Override
	public ArrayList<OrderVO> getALLHotelOrderList(String hotelID, OrderType ALL) {
		return (ArrayList<OrderVO>) orderFind.findHotelTypeOrderList(ALL, hotelID);
	}

	@Override
	public ArrayList<OrderVO> getUnexecutedHotelOrderList(String hotelID, OrderType NORMALEXEC) {
		return (ArrayList<OrderVO>) orderFind.findHotelTypeOrderList(NORMALEXEC, hotelID);
	}

	@Override
	public ArrayList<OrderVO> getExecutedHotelOrderList(String hotelID, OrderType NORMALNONEXEC) {
		return (ArrayList<OrderVO>) orderFind.findHotelTypeOrderList(NORMALNONEXEC, hotelID);
	}

	@Override
	public ArrayList<OrderVO> getAbnormalHotelOrderList(String hotelID, OrderType ABNORMALCANCEL) {
		return (ArrayList<OrderVO>) orderFind.findHotelTypeOrderList(ABNORMALCANCEL, hotelID);
	}
	
	@Override
	public ArrayList<OrderVO> getCancleHotelOrderList(String hotelID, OrderType ABNORMALCANCEL) {
		return (ArrayList<OrderVO>) orderFind.findHotelTypeOrderList(ABNORMALCANCEL, hotelID);
	}
	
	@Override
	public String getHotelstaffBasicinfo(String hotelID) {
		return hotelstaff.getBasicinfo(hotelID);
	}

	@Override
	public ResultMessage setPassword(String hotelID, String password) {
		return hotelstaff.setPassword(hotelID, password);
	}

	@Override
	public boolean checkAccount(String hotelID, String password) {
		return hotelstaff.checkAccount(hotelID, password);
	}
	
	@Override
	public ResultMessage addArea(String area) {
		if(hotelinfo.addArea(area)==true){
			return ResultMessage.AddAreaSuccess;
	}
		return null;
	}

	@Override
	public String[] getArea() {
		return hotelinfo.getArea();
	}
	

	@Override
	public ResultMessage addRoomType(String type) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public String[] getRoomType() {
		return hotelinfo.getRoomType();
	}
	
	@Override
	public ArrayList<OrderVO> getExecutedHotelOrderList(String hotelID, String clientID) {
		ArrayList<OrderVO> list = (ArrayList<OrderVO>) orderFind.findSpecificHotelClientOrderList(clientID, hotelID);
		return list;
	}

	@Override
	public ArrayList<OrderVO> searchOrderFromHotelUI(String hotelID,String text){
		//TODO orderFind里面提供的方法可能会改
		ArrayList<OrderVO> list = 
		(ArrayList<OrderVO>)orderFind.findSpecificHotelClientOrderList(text, hotelID) ;
			if(list == null){
				list = new ArrayList<OrderVO>();
				list.add(orderFind.findSpecificOrder(hotelID, text));
			}
		return list;
	}
	
	@Override
	public boolean addLog(String s){
		ResultMessage result= log.addLog(s);
		if(result == ResultMessage.SUCCESS){
			return true;
		}
		return false;
	}
}
