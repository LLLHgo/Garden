package dataservice.hotelstaffdataservice;

import java.rmi.RemoteException;

import po.HotelstaffPO;

public class HotelstaffDataService_Stub implements HotelstaffDataService{

	HotelstaffPO hotelstaffPO = new HotelstaffPO("H00000001","000000");

	/**
	 * 初始化持久化数据库
	 * @throws RemoteException
	 */
	public void init() throws RemoteException {
		hotelstaffPO = new HotelstaffPO("H00000001","000000");
	}

	/**
	 *返回酒店工作人员信息
	 * @param hotelStaffID
	 * @return
	 */
	public HotelstaffPO findBasicInfo(String hotelStaffID) {
		HotelstaffPO hotelstaffPO = new HotelstaffPO("H00000001","000000");
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
	 * 检查酒店工作人员账户密码
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean checkAccount(HotelstaffPO po) throws RemoteException {
		if(po.getHotelID().equals("H00000001")&&po.getPassword().equals("000000"))
		return true;
		else 
		return false;
	}

	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException {

	}

}
