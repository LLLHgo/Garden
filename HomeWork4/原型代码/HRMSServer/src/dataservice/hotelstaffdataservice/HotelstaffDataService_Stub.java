package dataservice.hotelstaffdataservice;

import java.rmi.RemoteException;

import po.HotelstaffPO;

public class HotelstaffDataService_Stub implements HotelstaffDataService{

	HotelstaffPO hotelstaffPO;

	/**
	 * 初始化持久化数据库
	 * @throws RemoteException
	 */
	public void init() throws RemoteException {
		hotelstaffPO = new HotelstaffPO("H00000000","000000");
	}

	/**
	 *返回酒店工作人员信息
	 * @param hotelStaffID
	 * @return
	 */
	public HotelstaffPO findBasicInfo(String hotelStaffID) {
		return hotelstaffPO;
	}

	/**
	 * 更新密码
	 * @param po
	 * @throws RemoteException
	 */
	public void updatePassword(HotelstaffPO po) throws RemoteException {
		System.out.println("已向数据库更新密码");
	}

	/**
	 * 检查酒店工作人员账户密码
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public boolean checkAccount(HotelstaffPO po) throws RemoteException {
		return true;
	}

	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException {

	}

}
