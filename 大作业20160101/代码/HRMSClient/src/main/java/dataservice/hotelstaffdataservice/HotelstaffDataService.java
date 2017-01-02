package dataservice.hotelstaffdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.HotelstaffPO;

public interface HotelstaffDataService extends Remote{
	/**
	 * 初始化持久化数据库
	 * @throws RemoteException
	 */
	public void init() throws RemoteException;
	/**
	 * 增
	 * @param po
	 * @return boolean
	 * @throws RemoteException
	 */
	public boolean insert(HotelstaffPO po) throws RemoteException;
	/**
	 *查
	 * @param hotelStaffID
	 * @return HotelstaffPO
	 */
	public HotelstaffPO find(String hotelStaffID)throws RemoteException;
	/**
	 * 酒店工作人员改
	 * @param po
	 * @throws RemoteException
	 * @return boolean
	 */
	public boolean hotelstaffUpdate(HotelstaffPO po) throws RemoteException;
	/**
	 * 网站营销人员改
	 * @param po
	 * @throws RemoteException
	 * @return boolean
	 */
	public boolean sitemanagerUpdate(HotelstaffPO po) throws RemoteException;
	/**
	 * 网站营销人员获得新增的酒店工作人员的账号
	 * @return
	 * @throws RemoteException
	 */
	public String gethotelID () throws RemoteException; 
	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}
