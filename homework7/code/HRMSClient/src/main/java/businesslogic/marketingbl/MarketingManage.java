package businesslogic.marketingbl;

import java.util.Date;
import java.util.List;

import Enum.ResultMessage;
import businesslogicservice.marketinblservice.MarketingBLService;
import vo.clientVO.ClientVO;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;

public class MarketingManage implements MarketingBLService{

	@Override
	public ResultMessage addLevel(LevelVO vo) {
		return null;
	}

	@Override
	public List<LevelVO> findAllLevel() {
		return null;
	}

	@Override
	public ResultMessage deleteLevel(LevelVO vo) {
		return null;
	}



	@Override
	public ResultMessage MarketingAccountUpdate(MarketingVO vo) {

		return null;
	}

	@Override
	public boolean checkAccount(String marketingID, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MarketingVO init(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResultMessage MarketingAccountAdd(MarketingVO marketing) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage MarketingAccountDelete(MarketingVO marketing) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MarketingVO MarketingAccountFind(String marketingID) {
		return null;
	}





}
