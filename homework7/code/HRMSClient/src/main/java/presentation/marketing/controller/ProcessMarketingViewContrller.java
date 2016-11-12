package presentation.marketing.controller;

import java.util.List;

import Enum.ResultMessage;
import businesslogic.marketingbl.MarketingManage;
import presentation.marketing.view.ProcessMarketingViewControllerService;
import businesslogicservice.marketinblservice.MarketingBLService;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;

public class ProcessMarketingViewContrller implements ProcessMarketingViewControllerService{
    private MarketingBLService MarketingBlService;

    public ProcessMarketingViewContrller (){
    	this.MarketingBlService=new MarketingManage();
    }

    @Override
	public ResultMessage addLevel(LevelVO vo) {
		return this.MarketingBlService.addLevel(vo);
	}

	@Override
	public List<LevelVO> findAllLevel() {
		return this.MarketingBlService.findAllLevel();
	}

	@Override
	public ResultMessage deleteLevel(LevelVO vo) {
		return this.MarketingBlService.deleteLevel(vo);
	}

	@Override
	public ResultMessage MarketingAccountAdd(MarketingVO marketing) {
		return this.MarketingBlService.MarketingAccountAdd(marketing);
	}

	@Override
	public ResultMessage MarketingAccountUpdate(MarketingVO marketing) {
		return this.MarketingBlService.MarketingAccountUpdate(marketing);
	}

	@Override
	public ResultMessage MarketingAccountDelete(MarketingVO marketing) {
		return this.MarketingBlService.MarketingAccountDelete(marketing);
	}

	@Override
	public MarketingVO MarketingAccountFind(String marketingID) {
		return this.MarketingBlService.MarketingAccountFind(marketingID);
	}

	@Override
	public boolean checkAccount(String marketingID, String password) {
		return this.MarketingBlService.checkAccount(marketingID, password);
	}

	@Override
	public MarketingVO init(String id) {
		return this.MarketingBlService.init(id);
	}

}
