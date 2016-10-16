package dataservice.hotelinfodataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import Enum.RoomState;
import Enum.Star;
import po.HotelinfoPO;
import po.RoominfoPO;


public class HotelinfoDataService_Stub implements HotelinfoDataService{

	RoominfoPO roominfoPO;
	HotelinfoPO hotelinfoPO;

	/**
	 * 初始化持久化数据库
	 * @throws RemoteException
	 */
	public void init() throws RemoteException {
		roominfoPO = new RoominfoPO("四人间","413-3",666.6,RoomState.Usable);

		ArrayList<RoominfoPO> roominfoList = new ArrayList<RoominfoPO>();
		roominfoList.add(roominfoPO);
		ArrayList<String> remark = new ArrayList<String>();
		remark.add("超级棒！");
		remark.add("一个很温馨的地方，么么哒~");
		String introduction = "一个可以让大家一起愉快地写大作业的地方哈哈哈哈";
		String hotelID = "H00000000";
		hotelinfoPO = new HotelinfoPO("LLLH酒店","仙林大道163号","栖霞区商圈","025-12345678",
			roominfoList,Star.SEVEN,remark,introduction,hotelID);
	}

	/**
	 * 获得房间信息列表
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public List<RoominfoPO> getRoominfoList(String hotelID) throws RemoteException {
		List<RoominfoPO> list=new ArrayList<RoominfoPO>();
		list.add(new RoominfoPO());
		return list;
	}

	/**
	 * 获得房间信息
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public HotelinfoPO findhotelinfo(String hotelID) throws RemoteException {
		return hotelinfoPO;
	}

	/**
	 * 更新酒店信息
	 * @param po
	 * @throws RemoteException
	 */
	public void updatehotelinfo(HotelinfoPO po) throws RemoteException {

	}

	/**
	 * 更新房间信息
	 * @param po
	 * @throws RemoteException
	 */
	public void updateroominfo(RoominfoPO po) throws RemoteException {

	}

	/**
	 * 删除持久化数据
	 * @param po
	 * @throws RemoteException
	 */
	public void delete(RoominfoPO po) throws RemoteException {

	}

	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException {

	}

}
