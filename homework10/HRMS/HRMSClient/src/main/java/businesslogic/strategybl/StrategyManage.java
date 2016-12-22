package businesslogic.strategybl;

import java.util.List;

import Enum.ResultMessage;
import Enum.VIPType;
import businesslogicservice.strategyblservice.StrategyBLService;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;
import vo.strategyVO.PrivilegeVO;

public class StrategyManage implements StrategyBLService{

	@Override
	public ResultMessage addMarketingStrategy(MarketingStrategyVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public List<MarketingStrategyVO> getMarketingStrategy(String id) {
		return null;
	}

	@Override
	public ResultMessage deleteMarketingStrategy(MarketingStrategyVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public boolean deletehotelStrategy(HotelStrategyVO vo) {
		return false;
	}

	@Override
	public List<HotelStrategyVO> getHotelStrategy(String hotelID) {
		return null;
	}

	@Override
	public ResultMessage updateHotelStrategy(String hotelID, HotelStrategyVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage addPrivilege(PrivilegeVO vo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public List<PrivilegeVO> findAllPrivilege(VIPType type) {
		return null;
	}

	@Override
	public ResultMessage deletePrivilege(PrivilegeVO vo) {
		return ResultMessage.SUCCESS;
	}

}
