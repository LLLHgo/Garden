package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.clientdataservice.ClientDataService;
import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.hotelstaffdataservice.HotelstaffDataService;
import dataservice.logdataservice.LogDataService;
import dataservice.marketingdataservice.MarketingDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.sitemanagerdataservice.SitemanagerDataService;
import dataservice.strategydataservice.StrategyDataService;

public class RemoteHelper {
//	private Remote remote;
	private static RemoteHelper remoteHelper = new RemoteHelper();
	ClientDataService clientService;
	HotelstaffDataService hotelstaffService;
	HotelinfoDataService hotelinfoService;
	LogDataService logService;
	MarketingDataService marketingService;
	OrderDataService orderService;
	SitemanagerDataService siteManagerService;
	StrategyDataService strategyService;
	
	public static RemoteHelper getInstance(){
		return remoteHelper;
	}
	public RemoteHelper() {
		init();
	}
	
	public void init(){
		String host = "rmi://localhost:8888/";
		try {
			clientService = (ClientDataService) Naming.lookup(host+"ClientService");
			hotelstaffService = (HotelstaffDataService) Naming.lookup(host+"HotelstaffService");
			hotelinfoService = (HotelinfoDataService) Naming.lookup(host+"HotelinfoService");
			logService = (LogDataService) Naming.lookup(host+"LogService");
			marketingService = (MarketingDataService) Naming.lookup(host+"MarketingService");
			orderService = (OrderDataService) Naming.lookup(host+"OrderService");
			siteManagerService = (SitemanagerDataService) Naming.lookup(host+"SitemanagerService");
			strategyService = (StrategyDataService) Naming.lookup(host+"StrategyService");
			//TODO
			System.out.println("Client is running...");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public SitemanagerDataService getSitemanagerDataService(){
		return siteManagerService;
	}
	
	public OrderDataService getOrderDataService(){
		return orderService;
	}
	
	public LogDataService getLogDataService(){
		return logService;
	}
	
	public LogDataService logDataService(){
		return logService;
	} 
	
	public ClientDataService clientDataService(){
		return clientService;
	}
	
	public HotelstaffDataService hotelstaffDataService(){
		return hotelstaffService;
	}
	
	public HotelinfoDataService hotelinfoDataService(){
		return hotelinfoService;
	}
	
	public MarketingDataService marketingDataService(){
		return marketingService;
	}
	
	public StrategyDataService strategyDataService(){
		return strategyService;
	}
	
	
		

}
