package dataservice.hotelstaffdataservice;

import java.rmi.RemoteException;

import po.HotelstaffPO;

public class HotelstaffDataService_Stub implements HotelstaffDataService{

	HotelstaffPO hotelstaffPO ;
	
	public HotelstaffDataService_Stub(){
		hotelstaffPO = new HotelstaffPO("H00000001","000000","123456");
	}
	/**
	 * 初始化持久化数据库
	 * @throws RemoteException
	 */
	public void init() throws RemoteException {
		hotelstaffPO = new HotelstaffPO("H00000001","000000","123456");
	}
	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException {

	}

	public boolean insert(HotelstaffPO po) throws RemoteException {
		
		return true;
	}
	
	public HotelstaffPO find(String hotelStaffID) throws RemoteException {
		if(hotelStaffID.equals("H00000001")){
			return hotelstaffPO;
		}
		return null;
	}

	public boolean hotelstaffUpdate(HotelstaffPO po) throws RemoteException {
		if(po.getHotelID().equals("H00000001")){
			return true;
		}
		return false;
	}

	public boolean sitemanagerUpdate(HotelstaffPO po) throws RemoteException {
		if(po.getHotelID().equals("H00000001")){
			return true;
		}
		return false;
	}
	public String gethotelID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
