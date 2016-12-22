package data.strategydata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import Enum.VIPType;
import dataservice.strategydataservice.StrategyDataService;
import po.HotelStrategyPO;
import po.MarketingStrategyPO;
import po.PrivilegePO;

public class StrategyData extends UnicastRemoteObject implements StrategyDataService{

	public StrategyData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public boolean addPrivilege(PrivilegePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	
	public List<PrivilegePO> findAllPrivilege(VIPType type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean deletePrivilege(PrivilegePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean addMarketingStrategy(MarketingStrategyPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	
	public List<MarketingStrategyPO> getMarketingStrategy(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean deleteMarketingStrategy(MarketingStrategyPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	
	public List<HotelStrategyPO> getHotelStrategy(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean updateHotelStrategy(HotelStrategyPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
