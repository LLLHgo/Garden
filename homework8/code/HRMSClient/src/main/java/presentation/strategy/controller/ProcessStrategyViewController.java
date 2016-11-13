package presentation.strategy.controller;

import java.util.List;

import Enum.ResultMessage;
import Enum.VIPType;
import businesslogic.strategybl.StrategyManage;
import businesslogicservice.strategyblservice.*;
import presentation.strategy.view.ProcessStrategyViewControllerService;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;
import vo.strategyVO.PrivilegeVO;

public class ProcessStrategyViewController implements ProcessStrategyViewControllerService{

	private StrategyBLService StrategyBLService;
	public ProcessStrategyViewController(){
		this.StrategyBLService= new StrategyManage();
	}
	@Override
	public ResultMessage addMarketingStrategy(MarketingStrategyVO vo) {
		return this.StrategyBLService.addMarketingStrategy(vo);
	}

	@Override
	public List<MarketingStrategyVO> getMarketingStrategy(String id) {
		return this.StrategyBLService.getMarketingStrategy(id);
	}

	@Override
	public ResultMessage deleteMarketingStrategy(MarketingStrategyVO vo) {
		return this.StrategyBLService.deleteMarketingStrategy(vo);
	}

	@Override
	public List<HotelStrategyVO> getHotelStrategy(String hotelID) {
		return this.StrategyBLService.getHotelStrategy(hotelID);
	}



	@Override
	public ResultMessage addPrivilege(PrivilegeVO vo) {
		return this.StrategyBLService.addPrivilege(vo);
	}

	@Override
	public List<PrivilegeVO> findAllPrivilege(VIPType type) {
		return this.StrategyBLService.findAllPrivilege(type);
	}

	@Override
	public ResultMessage delete(PrivilegeVO vo) {
		return this.StrategyBLService.delete(vo);
	}
	@Override
	public ResultMessage updateHotelStrategy(String hotelID,HotelStrategyVO vo) {
		return this.StrategyBLService.updateHotelStrategy(hotelID, vo);
	}

}
