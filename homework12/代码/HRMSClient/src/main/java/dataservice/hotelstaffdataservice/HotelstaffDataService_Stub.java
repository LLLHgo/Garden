package dataservice.hotelstaffdataservice;

import java.rmi.RemoteException;

import po.HotelstaffPO;

public class HotelstaffDataService_Stub implements HotelstaffDataService{

	HotelstaffPO hotelstaffPO = new HotelstaffPO("H00000001","000000","123456");

	/**
	 * 初始化持久化数据库
	 * @throws RemoteException
	 */
	public void init() throws RemoteException {
		hotelstaffPO = new HotelstaffPO("H00000001","000000","123456");
	}

	/**
	 *返回酒店工作人员信息
	 * @param hotelStaffID
	 * @return
	 */
	public HotelstaffPO findBasicInfo(String hotelStaffID) {
		HotelstaffPO hotelstaffPO = new HotelstaffPO("H00000001","000000","123456");
		return hotelstaffPO;
	}

	/**
	 * 更新酒店工作人员信息
	 * @param po
	 * @throws RemoteException
	 */
	public boolean update(HotelstaffPO po) throws RemoteException {
		return true;
	}

	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException {

	}

	@Override
	public boolean insert(HotelstaffPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HotelstaffPO find(String hotelStaffID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hotelstaffUpdate(HotelstaffPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sitemanagerUpdate(HotelstaffPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
