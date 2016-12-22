package dataHelper;

import dataservice.clientdataservice.ClientDataService;
import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.hotelstaffdataservice.HotelstaffDataService;
import dataservice.logdataservice.LogDataService;
import dataservice.marketingdataservice.MarketingDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.sitemanagerdataservice.SitemanagerDataService;
import dataservice.strategydataservice.StrategyDataService;

public interface DataFactory {
	public ClientDataService getClientDatabase();
	public HotelinfoDataService getHotelinfoDataBase();
	public HotelstaffDataService getHotelstaffDataBase();
	public MarketingDataService getMarketingDataService();
	public SitemanagerDataService getSitemanagerDataService();
	public LogDataService getLogDataService();
	public OrderDataService getLogDataservice();
	public StrategyDataService getStrategyDataService();
}
