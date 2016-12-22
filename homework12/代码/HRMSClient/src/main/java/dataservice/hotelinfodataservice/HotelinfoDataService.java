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
	 * 获得房间信息列表
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public List<RoominfoPO> findRoominfoList(String hotelID) throws RemoteException;
	/**
	 * 获得房间信息
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public RoominfoPO findroominfo(String hotelID,String roomID) throws RemoteException;
	/**
	 * 酒店工作人员获得酒店信息
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public HotelinfoPO findhotelinfo(String hotelID) throws RemoteException;
	/**
	 * 获得某商圈内的所有酒店信息
	 * @param area
	 * @return
	 * @throws RemoteException
	 */
	
	public ArrayList<HotelinfoPO> findHotelinfoList(String area) throws RemoteException;
	/**
	 * 酒店工作人员更新酒店信息
	 * @param po
	 * @throws RemoteException
	 */
	public boolean hotelstaffUpdatehotelinfo(HotelinfoPO po) throws RemoteException;
	/**
	 * 用户更新酒店信息
	 * @param po
	 * @throws RemoteException
	 */
	public boolean clientUpdatehotelinfo(HotelinfoPO po) throws RemoteException;
	/**
	 * 更新房间信息
	 * @param po
	 * @throws RemoteException
	 */
	public boolean updateroominfo(RoominfoPO po) throws RemoteException;
	/**
	 * 新建房间信息
	 * @param po
	 * @throws RemoteException
	 */
	public boolean insertroominfo(RoominfoPO po) throws RemoteException;
	/**
	 * 新建房间信息
	 * @param po
	 * @throws RemoteException
	 */
	public String inserthotelinfo(String hotelName) throws RemoteException;
	/**
	 * 获得系统内所有商圈名
	 * @return String[]
	 */
	public String[] getArea() throws RemoteException;
	/**
	 *添加商圈名 
	 * @return boolean
	 */
	public boolean addArea(String area) throws RemoteException;
	
	/**
	 * 获得系统内所有房间类型
	 * @return String[]
	 */
	public String[] getRoomType() throws RemoteException;
	/**
	 *添加房间类型
	 * @return boolean
	 */
	public boolean addRoomType(String type) throws RemoteException;
	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException;
}


