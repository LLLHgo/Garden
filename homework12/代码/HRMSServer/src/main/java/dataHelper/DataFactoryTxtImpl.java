package dataHelper;

import java.rmi.RemoteException;

import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.logdataservice.LogDataService;
import impl.hotelinfo.HotelinfoDataServiceImpl;
import impl.txt.HotelinfoDataServiceTxtImpl;
import impl.txt.LogDataServiceTxtImpl;

public class DataFactoryTxtImpl extends AdapterTxt implements DataFactory{
	
	LogDataService logDataService;
	HotelinfoDataService hotelinfoDataService;
	
	public DataFactoryTxtImpl() throws RemoteException{
		 logDataService=new LogDataServiceTxtImpl();
		 hotelinfoDataService=new HotelinfoDataServiceImpl();
	}

	@Override
	public HotelinfoDataService getHotelinfoDataBase() {
		// TODO Auto-generated method stub
		return hotelinfoDataService;
	}

	@Override
	public LogDataService getLogDataService() {
		// TODO Auto-generated method stub
		return logDataService;
	}
	

	

}
