package businesslogic.marketingbl;

import java.util.ArrayList;
import java.util.List;

import Enum.ResultMessage;
import businesslogicservice.marketinblservice.MarketingBLService;
import datatool.MarketingDataTool;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;

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
		return false;
	}

	@Override
	public MarketingVO init(String id) {

		return MarketingDataTool.V1;
	}


	@Override
	public ResultMessage MarketingAccountAdd(MarketingVO marketing) {
		return null;
	}

	@Override
	public ResultMessage MarketingAccountDelete(MarketingVO marketing) {
		return null;
	}

	@Override
	public MarketingVO MarketingAccountFind(String marketingID) {
		return null;
	}

	@Override
	public ResultMessage saveSitemanagerDelete(String userId) {
		// TODO Auto-generated method stub
		return null;
	}


}
