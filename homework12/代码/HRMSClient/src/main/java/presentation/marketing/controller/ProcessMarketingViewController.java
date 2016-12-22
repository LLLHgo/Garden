package presentation.marketing.controller;

import java.util.List;

import Enum.*;
import businesslogic.marketingbl.MarketingBLController;
import presentation.marketing.view.*;
import businesslogicservice.marketinblservice.*;
import vo.areaVO.AreaVO;
import vo.clientVO.ClientVO;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.*;

public class ProcessMarketingViewController implements ProcessMarketingViewControllerService{
    private MarketingBLControllerService MarketingBLControllerService=new MarketingBLController();

    private String marketingID;
    private ProcessMarketingView view;
    private ProcessMarketingProfileView profileView;
    private ProcessMarketingAbnormalView abnormalView;
    private ProcessMarketingStrategyView strategyView;
    private ProcessMarketingVIPView VIPView;
    private ProcessMarketingCreditView creditView;

    public ProcessMarketingViewController (String marketingID){
    	this.marketingID=marketingID;
    }
    @Override
    public String getMarketingID(){
    	return this.marketingID;
    }
    @Override
	public ResultMessage updateLevel(List<LevelVO> vo) {
		return  this.MarketingBLControllerService.updateLevel(vo);
	}

	@Override
	public List<LevelVO> findAllLevel() {
		return this.MarketingBLControllerService.findAllLevel();
	}

	@Override
	public ResultMessage MarketingAccountAdd(MarketingVO marketing) {
		return this.MarketingBLControllerService.MarketingAccountAdd(marketing);
	}

	@Override
	public ResultMessage MarketingAccountUpdate(MarketingVO marketing) {
		return this.MarketingBLControllerService.MarketingAccountUpdate(marketing);
	}

	@Override
	public ResultMessage MarketingAccountDelete(MarketingVO marketingVO) {
		return this.MarketingBLControllerService.MarketingAccountDelete(marketingVO);
	}

	@Override
	public MarketingVO MarketingAccountFind(String marketingID) {
		return this.MarketingBLControllerService.MarketingAccountFind(marketingID);
	}

	@Override
	public boolean checkAccount(String marketingID, String password) {
		return this.MarketingBLControllerService.checkAccount(marketingID, password);
	}

	@Override
	public MarketingVO init(String id) {
		return this.MarketingBLControllerService.init(id);
	}

	@Override
	public ResultMessage addMarketingStrategy(MarketingStrategyVO vo) {
		return this.MarketingBLControllerService.addMarketingStrategy(vo);
	}

	@Override
	public List<MarketingStrategyVO> getMarketingStrategy() {
		return this.MarketingBLControllerService.getMarketingStrategy();
	}

	@Override
	public ResultMessage deleteMarketingStrategy(String vo) {
		return this.MarketingBLControllerService.deleteMarketingStrategy(vo);
	}


	@Override
	public List<OrderVO> findAbnormalOrderList(String date) {
		return this.MarketingBLControllerService.findAbnormalOrderList(date);
	}

	@Override
	public OrderVO findSpecificOrder(String orderID) {
		return this.MarketingBLControllerService.findSpecificOrder(marketingID,orderID);//删掉List
	}

	@Override
	public ClientVO getclient(String clientID) {
		return this.MarketingBLControllerService.getclient(clientID);
	}

	@Override
	public boolean setCredit(String clientID, int amount) {//改为double
		return this.MarketingBLControllerService.setCredit(clientID, amount);
	}



	@Override
	public List<AreaVO> getDistricts() {
		return this.MarketingBLControllerService.getDistricts();
	}

	@Override
	public String[] getDistrictNames() {
		return this.MarketingBLControllerService.getDistrictNames();
	}

	@Override
	public ResultMessage operateOnAbnormalOrder(OrderVO order, double price, StringBuilder log) {
		return this.MarketingBLControllerService.operateOnAbnormalOrder(order,price,log);
	}

	@Override
	public void setView(ProcessMarketingView view) {
		this.view=view;
	}
	@Override
	public void profileButtonClicked() {
		view.hideWelcome();
		hide();
		profileView=new ProcessMarketingProfileView(this,view);
	}
	@Override
	public void abnormalButtonClicked() {
		view.hideWelcome();
		hide();
		abnormalView=new ProcessMarketingAbnormalView(this,view);
	}

	@Override
	public void strategyButtonClicked() {
		view.hideWelcome();
		hide();
		strategyView=new ProcessMarketingStrategyView(this,view);

	}

	@Override
	public void creditButtonClicked() {
		view.hideWelcome();
		hide();
		creditView=new ProcessMarketingCreditView(this,view);
	}
	@Override
	public void VIPButtonClicked() {
		view.hideWelcome();
		hide();
		VIPView=new ProcessMarketingVIPView(this,view);
	}


	private void hide(){
		if(abnormalView!=null)
			abnormalView.hideAbnormal();
		abnormalView=null;

		if(profileView!=null)
			profileView.hideProfile();
		profileView=null;

		if(strategyView!=null)
			strategyView.hideStrategy();
		strategyView=null;

		if(VIPView!=null)
			VIPView.hideVIP();
		VIPView=null;

		if(creditView!=null)
			creditView.hideCredit();
		creditView=null;
	}



}
