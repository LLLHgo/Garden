package dataHelper;

import dataservice.clientdataservice.ClientDataService;
import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.hotelstaffdataservice.HotelstaffDataService;
import dataservice.logdataservice.LogDataService;
import dataservice.marketingdataservice.MarketingDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.sitemanagerdataservice.SitemanagerDataService;
import dataservice.strategydataservice.StrategyDataService;

abstract class AdapterTxt implements DataFactory{
	public ClientDataService getClientDatabase(){
		return null;
	};
	public abstract HotelinfoDataService getHotelinfoDataBase();
	
	public HotelstaffDataService getHotelstaffDataBase(){
		return null;
	};
	public MarketingDataService getMarketingDataService(){
		return null;
	};
	public SitemanagerDataService getSitemanagerDataService(){
		return null;
	};
	public abstract LogDataService getLogDataService();
	
	public OrderDataService getLogDataservice(){
		return null;
	};
	public StrategyDataService getStrategyDataService(){
		return null;
	};
}
