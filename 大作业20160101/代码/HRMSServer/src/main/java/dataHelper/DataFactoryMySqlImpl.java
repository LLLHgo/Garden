package dataHelper;

import java.rmi.RemoteException;

import dataservice.clientdataservice.ClientDataService;
import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.hotelstaffdataservice.HotelstaffDataService;
import dataservice.logdataservice.LogDataService;
import dataservice.marketingdataservice.MarketingDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.sitemanagerdataservice.SitemanagerDataService;
import dataservice.strategydataservice.StrategyDataService;
import impl.hotelinfo.HotelinfoDataServiceImpl;
import impl.mysql.ClientDataServiceMySqlImpl;
import impl.mysql.HotelstaffDataServiceMySqlImpl;
import impl.mysql.LogDataServiceMySqlImpl;
import impl.mysql.MarketingDataServiceMySqlImpl;
import impl.mysql.OrderDataServiceMySqlImpl;
import impl.mysql.SitemanagerDataServiceMySqlImpl;
import impl.mysql.StrategyDataServiceMySqlImpl;
/**
 * 数据工厂的实现
 * @author yilu
 *
 */
public class DataFactoryMySqlImpl  implements DataFactory{
	
	ClientDataService clientDataService;
	HotelstaffDataService hotelstaffDataService;
	HotelinfoDataService hotelinfoDataService;
	MarketingDataService marketingDataService;
	OrderDataService orderDataService;
	SitemanagerDataService sitemanagerDataService;
	StrategyDataService strategyDataService;
	LogDataService logDataService;


	public DataFactoryMySqlImpl() throws RemoteException {
		super();
		
		clientDataService=new ClientDataServiceMySqlImpl();
		hotelstaffDataService=new HotelstaffDataServiceMySqlImpl();
		hotelinfoDataService=new HotelinfoDataServiceImpl();
		marketingDataService=new MarketingDataServiceMySqlImpl();
		orderDataService=new OrderDataServiceMySqlImpl();
		sitemanagerDataService=new SitemanagerDataServiceMySqlImpl();
		strategyDataService=new StrategyDataServiceMySqlImpl();
		logDataService=new LogDataServiceMySqlImpl();
		
	}
	
	/**
	 * 执行语句并返回执行结果
	 * @param tempPreState
	 * @return
	 */
	// 这里感觉用ResultSet更好诶
	/*public ResultSet getDoResult(String sql){
		try {
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(sql);
			return resultSet;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}*/

	public ClientDataService getClientDatabase() {
		// TODO Auto-generated method stub
		return clientDataService;
	}

	public HotelinfoDataService getHotelinfoDataBase() {
		// TODO Auto-generated method stub
		return hotelinfoDataService;
	}

	public HotelstaffDataService getHotelstaffDataBase() {
		// TODO Auto-generated method stub
		return hotelstaffDataService;
	}

	public MarketingDataService getMarketingDataService() {
		// TODO Auto-generated method stub
		return marketingDataService;
	}

	public SitemanagerDataService getSitemanagerDataService() {
		// TODO Auto-generated method stub
		return sitemanagerDataService;
	}


	public OrderDataService getLogDataservice() {
		// TODO Auto-generated method stub
		return orderDataService;
	}

	public StrategyDataService getStrategyDataService() {
		// TODO Auto-generated method stub
		return strategyDataService;
	}

	public LogDataService getLogDataService() {
		// TODO Auto-generated method stub
		return logDataService;
	}


}
