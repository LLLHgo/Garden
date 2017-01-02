package businesslogic.marketingbl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import businesslogic.clientbl.ClientManage;
import businesslogic.hoteinfobl.Hotelinfo;
import businesslogic.logbl.LogManage;
import businesslogic.orderbl.OrderFind;
import businesslogic.orderbl.OrderOperator;
import businesslogic.strategybl.StrategyManage;
import businesslogicservice.clientblservice.ClientBLService;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService;
import businesslogicservice.logblservice.LogBLService;
import businesslogicservice.marketinblservice.MarketingBLControllerService;
import businesslogicservice.marketinblservice.MarketingBLService;
import businesslogicservice.orderblservice.OrderFindBLService;
import businesslogicservice.orderblservice.OrderOperatorBLService;
import businesslogicservice.strategyblservice.StrategyBLService;
import vo.areaVO.AreaVO;
import vo.clientVO.ClientVO;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.MarketingStrategyVO;

public class MarketingBLController implements MarketingBLControllerService{

	private MarketingBLService marketingBL=new MarketingManage();
	private ClientBLService clientBL=new ClientManage();
	private StrategyBLService strategyBL=new StrategyManage();
	private OrderFindBLService orderFind=new OrderFind();
	private OrderOperatorBLService orderOperator=new OrderOperator();
	private LogBLService logBL=new LogManage();
    private HotelinfoBLService hotelBL=new Hotelinfo();

	@Override
	public ResultMessage updateLevel(List<LevelVO> vos) {
		ResultMessage result=this.marketingBL.updateLevel(vos);//保存等级信息
		if(result==ResultMessage.SUCCESS){//更新等级信息成功
			return ResultMessage.SUCCESS;
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
	public String getMarketingID() {
		return this.marketingBL.getMarketingID();
	}


	@Override
	public boolean setCredit(String clientID, int amount,String reason) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date d=new Date();
        String date=format.format(d.getTime());
		return this.clientBL.setCredit(clientID,amount,date,reason);
	}

	@Override
	public OrderVO findSpecificOrder(String marketingID, String orderID) {
		return this.orderFind.findSpecificOrder(marketingID, orderID);
	}

	@Override
	public List<OrderVO> findAbnormalOrderList(String date) {
		return this.orderFind.findAbnormalOrderList(date);
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
	public List<MarketingStrategyVO> getMarketingStrategy() {
		return this.strategyBL.getMarketingStrategy();
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
	public ResultMessage operateOnAbnormalOrder(OrderVO order, double price, StringBuilder log,String reason) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Calendar c=Calendar.getInstance();
		String date=format.format(c.getTime());
		System.out.println(date+"%%%");
		ResultMessage result=this.orderOperator.saveOrderPO(order);
		if(result==ResultMessage.SUCCESS){//保存订单状态成功
			if(this.clientBL.setCredit(order.getClientId(),(int)price,date,reason)){//设置客户信用值成功
				this.logBL.addLog(log.toString());
			    return ResultMessage.SUCCESS;
			}else{//设置用户信用值失败
				order.setOrderStatus(OrderType.ABNORMAL);//将订单状态重新设为异常
				this.orderOperator.saveOrderPO(order);
				return ResultMessage.SETCREDITEXCEPTION;
			}
		}else{//保存订单状态失败
            return ResultMessage.SETORDERTYPEEXCEPTION;
		}
	}



}
