package dataHelper;

import dataservice.clientdataservice.ClientDataService;
import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.hotelstaffdataservice.HotelstaffDataService;
import dataservice.logdataservice.LogDataService;
import dataservice.marketingdataservice.MarketingDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.sitemanagerdataservice.SitemanagerDataService;
import dataservice.strategydataservice.StrategyDataService;
/**
 * 数据库实现的适配器
 * @author yilu
 *
 */
abstract class AdapterSql {
	public abstract ClientDataService getClientDatabase();
	public abstract HotelinfoDataService getHotelinfoDataBase();
	public abstract HotelstaffDataService getHotelstaffDataBase();
	public abstract MarketingDataService getMarketingDataService();
	public abstract SitemanagerDataService getSitemanagerDataService();
	public LogDataService getLogDataService(){
		return null;
	};
	public abstract OrderDataService getLogDataservice();
	public abstract StrategyDataService getStrategyDataService();
}
