package dataservice.hotelinfodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.HotelinfoPO;
import po.RoominfoPO;

public interface HotelinfoDataService extends Remote{
	/**
	 * 初始化持久化数据库
	 * @throws RemoteException
	 */
	public void init() throws RemoteException;
	/**
	 * 获得某个具体房间的信息
	 * @param hotelID
	 * @param roomID
	 * @return RoominfoPO
	 * @throws RemoteException
	 */
	public RoominfoPO getRoominfo(String hotelID,String roomID) throws RemoteException;
	/**
	 * 获得房间信息列表
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoominfoPO> getRoominfoList(String hotelID) throws RemoteException;
	
	/**
	 * 获得某商圈的酒店信息列表
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<HotelinfoPO> findHotelinfoList(String area) throws RemoteException;
	
	/**
	 * 获得房间信息
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public HotelinfoPO findhotelinfo(String hotelID) throws RemoteException;
	/**
	 * 更新酒店信息
	 * @param po
	 * @throws RemoteException
	 */
	public boolean updatehotelinfo(HotelinfoPO po) throws RemoteException;
	/**
	 * 更新房间信息
	 * @param po
	 * @throws RemoteException
	 */
	public boolean updateroominfo(RoominfoPO po) throws RemoteException;
	/**
	 * 删除持久化数据
	 * @param po
	 * @throws RemoteException
	 */
	public boolean delete(RoominfoPO po) throws RemoteException;
	/**
	 * 网站管理人员新建酒店，如果新建成功，返回hotelID，如果已经存在,返回"R",表示重复
	 * @param po
	 * @return String
	 */
	public String addhotelinfofromsitemanager(HotelinfoPO po) throws RemoteException;
	
	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}
