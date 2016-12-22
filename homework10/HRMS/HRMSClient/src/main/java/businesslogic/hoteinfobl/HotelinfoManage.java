package businesslogic.hoteinfobl;

import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.ClientRequirementVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelinfoVO.SitemanagerAddVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class HotelinfoManage implements HotelinfoBLService{

	@Override
	public HotelinfoVO getBasicinfo(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelinfoVO> getBasicinfoList(ClientRequirementVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateBassicinfo(HotelinfoVO VO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoominfoVO getRoominfo(String hotelID, String roomtype) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoominfoVO> getRoominfoList(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculatePrice(List<HotelStrategyVO> hotelStrategylist,
			List<MarketingStrategyVO> marketingStrategyList, ClientVO vo, double originalPrice) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public HotelinfoVO gethotelinfoVO(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoominfoVO getroominfo(String hotelID, String roomID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateroominfo(RoominfoVO vo,String hotelID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultMessage saveSitemanagerAdd(SitemanagerAddVO sitemanagerAddVO, HotelstaffVO hotelstaffVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public String[] getArea() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addArea(String area) {
		//TODO 序列化保存
		return true;
	}
}
