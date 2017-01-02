package businesslogic.hoteinfobl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.hotelinfodataservice.HotelinfoDataService;
import po.RoominfoPO;
import rmi.RemoteHelper;
import vo.hotelinfoVO.RoominfoVO;

public class RoominfoManage{

	HotelinfoDataService data = RemoteHelper.getInstance().hotelinfoDataService();

//		data = new HotelinfoDataService_Stub();


	public RoominfoVO getroominfo(String hotelID, String roomID) {
		RoominfoPO po = null;
		try {
			po = data.findroominfo(hotelID, roomID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(po==null){
			return null;
		}
		return po2vo(po);
	}

	public boolean addroominfo(RoominfoVO vo){
		RoominfoPO po = new RoominfoPO(vo.getHotelID(),
				vo.getType(),vo.getRoomNum(),vo.getPrice(),vo.getRoomState());
		boolean result = false;
		try {
			result = data.insertroominfo(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}

		return result;
	}

	public boolean updateroominfo(RoominfoVO vo,String hotelID) {
		RoominfoPO po = new RoominfoPO(vo.getHotelID(),
				vo.getType(),vo.getRoomNum(),vo.getPrice(),vo.getRoomState());
		boolean result = false;
		try {
			result = data.updateroominfo(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}

		return result;
	}


	public String[] getRoomType() {
		try {
			return data.getRoomType();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}


	public boolean addRoomType(String type) {
		try {
			return data.addRoomType(type);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}



	public ArrayList<RoominfoVO> getRoominfoList(String hotelID) {
		ArrayList<RoominfoPO> listPO;
		ArrayList<RoominfoVO> listVO = new ArrayList<RoominfoVO>();
		try {
			listPO = (ArrayList<RoominfoPO>) data.findRoominfoList(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		if(listPO == null){
			return null;
		}
		for(int i=0;i<listPO.size();i++){
			listVO.add(po2vo(listPO.get(i)));
		}
		return listVO;
	}


	private RoominfoVO po2vo(RoominfoPO po){
		RoominfoVO vo;
		try{
			vo = new RoominfoVO(po.getHotelID(),po.getType(),po.getRoomNum(),
					po.getPrice(),po.getRoomState());
		}catch(NullPointerException e){
			e.printStackTrace();
			return null;
		}
		return vo;
	}

	public boolean deleteroom(String hotelID,String roomID){
		try {
			return data.deleteroom(hotelID,roomID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	public  ArrayList<String> getAvailableRooms(String hotelID){
//		try {
//			ArrayList<RoominfoPO> list = (ArrayList<RoominfoPO>) data.findRoominfoList(hotelID);
//
//			for(int i=0;i<list.size();i++){
//				if(list.get(i).getRoomState()== RoomState.Usable){
//
//				}
//			}
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			return null;
//		}
		return null;
	}


}
