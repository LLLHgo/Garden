package data.clientdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Enum.ResultMessage;
import dataservice.clientdataservice.ClientDataService;
import po.ClientPO;
import po.LevelPO;

public class ClientData extends UnicastRemoteObject implements ClientDataService{

	public ClientData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public File findCreditRecord(String clientID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean setCredit(String clientID, int recharge) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public ClientPO findPersonalInfo(String clientID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage modifyPersonalInfo(ClientPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checkAccount(String client_id, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean setAllLevel(LevelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean createClient(ClientPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
