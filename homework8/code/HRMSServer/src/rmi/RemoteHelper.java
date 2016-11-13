package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import data.clientdata.ClientData;
import data.hotelinfodata.HotelinfoData;
import data.hotelstaffdata.HotelStaffData;
import data.logdata.LogData;
import data.marketingdata.MarketingData;
import data.orderdata.OrderData;
import data.sitemanagerdata.SiteManagerData;
import data.strategydata.StrategyData;
import dataservice.clientdataservice.ClientDataService;
import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.hotelstaffdataservice.HotelstaffDataService;
import dataservice.logdataservice.LogDataService;
import dataservice.marketingdataservice.MarketingDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.sitemanagerdataservice.SitemanagerDataService;
import dataservice.strategydataservice.StrategyDataService;

public class RemoteHelper {
	static final String host = "rmi://localhost:8888/";
	
	public static void main(String[] args){
		try {
			LocateRegistry.createRegistry(8888);
			
			ClientDataService client = new ClientData();
			Naming.rebind(host+"ClientService", client);
			
			HotelstaffDataService hotelstaff = new HotelStaffData();
			Naming.rebind(host+"HotelstaffService", hotelstaff);

			HotelinfoDataService hotelinfo = new HotelinfoData();
			Naming.rebind(host+"HotelinfoService", hotelinfo);
		
			LogDataService log = new LogData();
			Naming.rebind(host+"LogService", log);
			
			MarketingDataService marketing = new MarketingData();
			Naming.rebind(host+"MarketingService", marketing);
			
			OrderDataService order = new OrderData();
			Naming.rebind(host+"OrderService", order);
			
			SitemanagerDataService sitemanager = new SiteManagerData();
			Naming.rebind(host+"SitemanagerService", sitemanager);
			
			StrategyDataService strategy = new StrategyData();
			Naming.rebind(host+"StrategyService", strategy);
			
			System.out.println("Server is running...");
		} catch (RemoteException  e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} 
		
	}
}
