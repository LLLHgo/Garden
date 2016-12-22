package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

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
import impl.mysql.MarketingDataServiceMySqlImpl;
import impl.mysql.OrderDataServiceMySqlImpl;
import impl.mysql.SitemanagerDataServiceMySqlImpl;
import impl.mysql.StrategyDataServiceMySqlImpl;
import impl.txt.HotelinfoDataServiceTxtImpl;
import impl.txt.LogDataServiceTxtImpl;

public class RemoteHelper {
	static final String host = "rmi://localhost:8888/";
	public RemoteHelper(){
		initServer();
	}
	
	public void initServer(){
		try {
			LocateRegistry.createRegistry(8888);
			
			ClientDataService client = new ClientDataServiceMySqlImpl();
			Naming.rebind(host+"ClientService", client);
			
			HotelstaffDataService hotelstaff = new HotelstaffDataServiceMySqlImpl();
			Naming.rebind(host+"HotelstaffService", hotelstaff);
			
			HotelinfoDataService hotelinfo = new HotelinfoDataServiceImpl();
			Naming.rebind(host+"HotelinfoService", hotelinfo);
		
			LogDataService log = new LogDataServiceTxtImpl();
			Naming.rebind(host+"LogService", log);
			
			MarketingDataService marketing = new MarketingDataServiceMySqlImpl();
			Naming.rebind(host+"MarketingService", marketing);
			
			OrderDataService order = new OrderDataServiceMySqlImpl();
			Naming.rebind(host+"OrderService", order);
			
			SitemanagerDataService sitemanager = new SitemanagerDataServiceMySqlImpl();
			Naming.rebind(host+"SitemanagerService", sitemanager);
			
			StrategyDataService strategy = new StrategyDataServiceMySqlImpl();
			Naming.rebind(host+"StrategyService", strategy);
			
			System.out.println("Server is running...");
		} catch (RemoteException  e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.err.println("port 转换错误");
			e.printStackTrace();
		} 
		
	}
}
