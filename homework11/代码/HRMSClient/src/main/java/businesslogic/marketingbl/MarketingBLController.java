package businesslogic.marketingbl;

import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import businesslogicservice.clientblservice.ClientBLService;
import businesslogicservice.clientblservice.ClientBLService_Stub;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService_Stub;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import businesslogicservice.logblservice.LogBLService;
import businesslogicservice.logblservice.LogBLService_Stub;
import businesslogicservice.marketinblservice.MarketingBLControllerService;
import businesslogicservice.marketinblservice.MarketingBLService;
import businesslogicservice.marketinblservice.MarketingBLService_Stub;
import businesslogicservice.orderblservice.*;
import businesslogicservice.strategyblservice.StrategyBLService;
import businesslogicservice.strategyblservice.StrategyBLService_Stub;
import datatool.AreaDataTool;
import vo.areaVO.AreaVO;
import vo.clientVO.ClientVO;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.MarketingStrategyVO;

public class MarketingBLController implements MarketingBLControllerService{

	private MarketingBLService marketingBL=new MarketingBLService_Stub();
	private ClientBLService clientBL=new ClientBLService_Stub();
	private StrategyBLService strategyBL=new StrategyBLService_Stub();
	private OrderBLService_Stub orderBL=new OrderBLService_Stub();
	private LogBLService logBL=new LogBLService_Stub();
    private HotelinfoBLService hotelBL=new HotelinfoBLService_Stub();

	@Override
	public ResultMessage updateLevel(List<LevelVO> vos) {
		ResultMessage result=this.marketingBL.updateLevel(vos);//保存等级信息
		if(result==ResultMessage.SUCCESS){//更新等级信息成功
			if(this.clientBL.setAllClientLevel((LevelVO) vos.get(0))){//更新用户等级信息成功//这里要改接口的！！！
				return ResultMessage.SUCCESS;
			}else{//更新用户等级信息失败
			    return ResultMessage.FAULT;
			}
		}else{//保存等级信息失败
			return ResultMessage.FAIL;
		}
	}

	@Override
	public List<LevelVO> findAllLevel() {
		return this.marketingBL.findAllLevel();
	}

	@Override
	public ResultMessage MarketingAccountAdd(MarketingVO marketing) {
		return this.marketingBL.MarketingAccountAdd(marketing);
	}

	@Override
	public ResultMessage MarketingAccountUpdate(MarketingVO marketing) {
		return this.marketingBL.MarketingAccountUpdate(marketing);
	}

	@Override
	public ResultMessage MarketingAccountDelete(MarketingVO marketingVO) {
		return this.marketingBL.MarketingAccountDelete(marketingVO);
	}

	@Override
	public MarketingVO MarketingAccountFind(String marketingID) {
		return this.marketingBL.MarketingAccountFind(marketingID);
	}

	@Override
	public boolean checkAccount(String marketingID, String password) {
		return this.marketingBL.checkAccount(marketingID, password);
	}

	@Override
	public MarketingVO init(String id) {
		return this.marketingBL.init(id);
	}


	@Override
	public boolean setCredit(String clientID, int amount) {
		return this.clientBL.setCredit(clientID,amount);
	}

	@Override
	public OrderVO findSpecificOrder(String marketingID, String orderID) {
		return this.orderBL.findSpecificOrder(marketingID, orderID);
	}

	@Override
	public List<OrderVO> findAbnormalOrderList(String date) {
		return this.orderBL.findAbnormalOrderList(date);
	}


	@Override
	public ClientVO getclient(String clientID) {
		return this.clientBL.getclient(clientID);
	}

	@Override
	public ResultMessage deleteMarketingStrategy(String vo) {
		return this.strategyBL.deleteMarketingStrategy(vo);
	}

	@Override
	public List<MarketingStrategyVO> getMarketingStrategy(String id) {
		return this.strategyBL.getMarketingStrategy(id);
	}

	@Override
	public ResultMessage addMarketingStrategy(MarketingStrategyVO vo) {
		return this.strategyBL.addMarketingStrategy(vo);
	}

	@Override
	public List<AreaVO> getDistricts() {
		return this.hotelBL.getAreaHotels();
	}

	@Override
	public String[] getDistrictNames() {
	    return this.hotelBL.getArea();
	}

	@Override
	public ResultMessage operateOnAbnormalOrder(OrderVO order, double price, StringBuilder log) {
		ResultMessage result=this.orderBL.saveOrderPO(order);
		if(result==ResultMessage.SUCCESS){//保存订单状态成功
			if(this.clientBL.setCredit(order.getClientId(),(int)price)){//设置客户信用值成功
				//！！！！！！应该是double型的！！！
			    this.logBL.addLog(log.toString());
			    return ResultMessage.SUCCESS;
			}else{//设置用户信用值失败
				order.setOrderStatus(OrderType.ABNORMAL);//将订单状态重新设为异常
				if(this.orderBL.saveOrderPO(order)==ResultMessage.SUCCESS){//将订单状态重新设为异常成功
					return ResultMessage.SUCCESS;
				}else{//将订单状态重新设为异常失败
					return ResultMessage.FAULT;
				}
			}
		}else{//保存订单状态失败
            return ResultMessage.FAIL;
		}
	}

}
