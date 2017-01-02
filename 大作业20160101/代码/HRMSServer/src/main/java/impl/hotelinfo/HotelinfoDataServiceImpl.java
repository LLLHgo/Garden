package impl.hotelinfo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dataservice.hotelinfodataservice.HotelinfoDataService;
import impl.mysql.HotelinfoDataServiceMySqlImpl;
import impl.txt.HotelinfoDataServiceTxtImpl;
import po.HotelinfoPO;
import po.RoominfoPO;

public  class HotelinfoDataServiceImpl extends UnicastRemoteObject implements HotelinfoDataService{

	private static final long serialVersionUID = 1L;
	HotelinfoDataServiceMySqlImpl mysql = new HotelinfoDataServiceMySqlImpl();
	HotelinfoDataServiceTxtImpl txt = new HotelinfoDataServiceTxtImpl();

	public HotelinfoDataServiceImpl() throws RemoteException {
		super();
	}


	public void init() throws RemoteException {
	}

	public List<RoominfoPO> findRoominfoList(String hotelID) throws RemoteException {
		return mysql.findRoominfoList(hotelID);
	}

	public HotelinfoPO findhotelinfo(String hotelID) throws RemoteException {
		return mysql.findhotelinfo(hotelID);
	}

	public boolean hotelstaffUpdatehotelinfo(HotelinfoPO po) throws RemoteException {
		return mysql.hotelstaffUpdatehotelinfo(po);
	}

	public boolean updateroominfo(RoominfoPO po) throws RemoteException {
		return mysql.updateroominfo(po);
	}

	public void finish() throws RemoteException {

	}


	public String[] getArea() {
//		return txt.getArea();
		return mysql.getArea();
	}


	public boolean addArea(String area) {
//		return txt.addArea(area);
		return mysql.addArea(area);
	}


	public String[] getRoomType() {
//		return txt.getRoomType();
		return mysql.getRoomType();
	}


	public boolean addRoomType(String type) {
		
		return true;
//		return txt.addRoomType(type);
	}

	public boolean clientUpdatehotelinfo(String remark,String hotelID) throws RemoteException {
		return mysql.clientupdatehotelinfo(remark,hotelID);
	}


	public boolean insertroominfo(RoominfoPO po) throws RemoteException {
		return mysql.insertRoominfo(po);
	}


	public String inserthotelinfo(String hotelName) throws RemoteException {
		return mysql.insertHotelinfo(hotelName);
	}

	public ArrayList<HotelinfoPO> findHotelinfoList(String area) throws RemoteException{
		return mysql.findHotelinfoList(area);
	}

	public RoominfoPO findroominfo(String hotelID,String roomID) throws RemoteException{
		return mysql.findroominfo(hotelID,roomID);
	}


	public boolean deleteroom(String hotelID, String roomID) throws RemoteException {
		return mysql.deleteroom(hotelID,roomID);
	}


	public ArrayList<HotelinfoPO> clientfindhotelinfo(String area,String hotelname,int hotelstar) throws RemoteException {
		return mysql.clientfindhotelinfo(area, hotelname, hotelstar);
	}

}
