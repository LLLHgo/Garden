package dataservice.hotelinfodataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import Enum.RoomState;
import Enum.Star;
import datatool.HotelinfoDataTool;
import po.HotelinfoPO;
import po.RoominfoPO;


public class HotelinfoDataService_Stub implements HotelinfoDataService{

	RoominfoPO roominfoPO;
	HotelinfoPO hotelinfoPO;


	public HotelinfoDataService_Stub(){
		roominfoPO = new RoominfoPO("H00000001","四人间","413-3",666.6,RoomState.Usable);

		ArrayList<RoominfoPO> roominfoList = new ArrayList<RoominfoPO>();
		roominfoList.add(roominfoPO);
		ArrayList<String> remark = new ArrayList<String>();
		remark.add("超级棒！");
		remark.add("一个很温馨的地方，么么哒~");
		String introduction = "一个可以让大家一起愉快地写大作业的地方哈哈哈哈";
		String hotelID = "H00000001";
		hotelinfoPO = new HotelinfoPO("LLLH酒店","仙林大道163号","栖霞区商圈","025-12345678",
			roominfoList,Star.SEVEN,remark,introduction,hotelID);
	}
	/**
	 * 初始化持久化数据库
	 * @throws RemoteException
	 */
	public void init() throws RemoteException {
		roominfoPO = new RoominfoPO("H00000001","四人间","413-3",666.6,RoomState.Usable);

		ArrayList<RoominfoPO> roominfoList = new ArrayList<RoominfoPO>();
		roominfoList.add(roominfoPO);
		ArrayList<String> remark = new ArrayList<String>();
		remark.add("超级棒！");
		remark.add("一个很温馨的地方，么么哒~");
		String introduction = "一个可以让大家一起愉快地写大作业的地方哈哈哈哈";
		String hotelID = "H00000001";
		hotelinfoPO = new HotelinfoPO("LLLH酒店","仙林大道163号","栖霞区商圈","025-12345678",
			roominfoList,Star.SEVEN,remark,introduction,hotelID);
	}

	/**
	 * 获得房间信息列表
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoominfoPO> getRoominfoList(String hotelID) throws RemoteException {
		RoominfoPO roominfo1 = new RoominfoPO("H00000001","标准间","8304",200, RoomState.Usable);
		RoominfoPO roominfo2 = new RoominfoPO("H00000001","标准间","8305",200, RoomState.Usable);
		RoominfoPO roominfo3 = new RoominfoPO("H00000001","大床房","8306",200, RoomState.Usable);
		RoominfoPO roominfo4 = new RoominfoPO("H00000001","标准间","8307",200, RoomState.Usable);
		RoominfoPO roominfo5 = new RoominfoPO("H00000001","标准间","8308",200, RoomState.Unusable);
		RoominfoPO roominfo6 = new RoominfoPO("H00000001","大床房","8309",200, RoomState.Unusable);
		ArrayList<RoominfoPO> roominfoList = new ArrayList<RoominfoPO>();
		roominfoList.add(roominfo1);
		roominfoList.add(roominfo2);
		roominfoList.add(roominfo3);
		roominfoList.add(roominfo4);
		roominfoList.add(roominfo5);
		roominfoList.add(roominfo6);
		return roominfoList;
	}

	/**
	 * 获得房间信息
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public HotelinfoPO findhotelinfo(String hotelID) throws RemoteException {
		return HotelinfoDataTool.hotelinfoPO1;
	}

	/**
	 * 更新酒店信息
	 * @param po
	 * @throws RemoteException
	 */
	public boolean updatehotelinfo(HotelinfoPO po) throws RemoteException {
		return true;
	}

	/**
	 * 更新房间信息
	 * @param po
	 * @throws RemoteException
	 */
	public boolean updateroominfo(RoominfoPO po) throws RemoteException {
		return true;
	}

	/**
	 * 删除持久化数据
	 * @param po
	 * @throws RemoteException
	 */
	public boolean delete(RoominfoPO po) throws RemoteException {
		return true;
	}

	/**
	 * 结束持久化数据库的使用
	 * @throws RemoteException
	 */
	public void finish() throws RemoteException {

	}

	@Override
	public ArrayList<HotelinfoPO> findHotelinfoList(String area) throws RemoteException {
		if(area.equals("山西路商圈"))
		return (ArrayList<HotelinfoPO>) HotelinfoDataTool.listPO;
		return new ArrayList<HotelinfoPO>();
	}

	@Override
	public RoominfoPO findroominfo(String hotelID, String roomID) throws RemoteException {
		RoominfoPO roominfo1 = new RoominfoPO("H00000001","标准间","8304",200, RoomState.Usable);
		RoominfoPO roominfo2 = new RoominfoPO("H00000001","标准间","8305",200, RoomState.Usable);
		RoominfoPO roominfo3 = new RoominfoPO("H00000001","大床房","8306",200, RoomState.Usable);
		RoominfoPO roominfo4 = new RoominfoPO("H00000001","标准间","8307",200, RoomState.Usable);
		RoominfoPO roominfo5 = new RoominfoPO("H00000001","标准间","8308",200, RoomState.Unusable);
		RoominfoPO roominfo6 = new RoominfoPO("H00000001","大床房","8309",200, RoomState.Unusable);
		if(!hotelID.equals("H00000001")){
			return null;
		}
		if(roomID.equals(roominfo1.getRoomNum())){
			return roominfo1;
		}
		if(roomID.equals(roominfo2.getRoomNum())){
			return roominfo2;
		}
		if(roomID.equals(roominfo3.getRoomNum())){
			return roominfo3;
		}
		if(roomID.equals(roominfo4.getRoomNum())){
			return roominfo4;
		}
		if(roomID.equals(roominfo5.getRoomNum())){
			return roominfo5;
		}
		if(roomID.equals(roominfo6.getRoomNum())){
			return roominfo6;
		}
		return null;
	}

	@Override
	public String inserthotelinfo(String hotelName) throws RemoteException {
		if(hotelName.equals("LLLH酒店")){
			return "R";//代表Repeated;
		}else{
			return "H00000002";
		}
	}
	@Override
	public String[] getArea() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean addArea(String area) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String[] getRoomType() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean addRoomType(String type) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean hotelstaffUpdatehotelinfo(HotelinfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertroominfo(RoominfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<RoominfoPO> findRoominfoList(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean clientUpdatehotelinfo(String remark, String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteroom(String hotelID, String roomID) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<HotelinfoPO> clientfindhotelinfo(String area, String hotelname, int hotelstar)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
