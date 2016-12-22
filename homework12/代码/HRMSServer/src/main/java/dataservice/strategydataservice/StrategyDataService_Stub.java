package dataservice.strategydataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.StrategyPO.HotelStrategyPO;
import po.StrategyPO.MarketingStrategyPO;
import po.StrategyPO.StrategyPO;

public class StrategyDataService_Stub implements StrategyDataService{

	public boolean addMarketingStrategy(MarketingStrategyPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public List<StrategyPO> getMarketingStrategy() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteMarketingStrategy(String marketingStrategy) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public List<StrategyPO> getHotelStrategy(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateHotelStrategy(HotelStrategyPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}




}
