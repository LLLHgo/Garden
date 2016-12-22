package data.hotelstaffdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.hotelstaffdataservice.HotelstaffDataService;
import po.HotelstaffPO;

public class HotelStaffData extends UnicastRemoteObject implements HotelstaffDataService{

	public HotelStaffData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public void init() throws RemoteException {

		// TODO Auto-generated method stub
	}


	public HotelstaffPO findBasicInfo(String hotelStaffID) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean updatePassword(HotelstaffPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean checkAccount(HotelstaffPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
