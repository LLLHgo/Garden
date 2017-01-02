package dataHelper;

import java.rmi.RemoteException;

import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.logdataservice.LogDataService;
import impl.hotelinfo.HotelinfoDataServiceImpl;
import impl.txt.LogDataServiceTxtImpl;
/**
 * txt工厂的实现
 * @author yilu
 *
 */
public class DataFactoryTxtImpl extends AdapterTxt implements DataFactory{

	HotelinfoDataService hotelinfoDataService;
	LogDataService logDataService;
	
	public DataFactoryTxtImpl() throws RemoteException{
		 hotelinfoDataService=new HotelinfoDataServiceImpl();
		 logDataService=new LogDataServiceTxtImpl();
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
