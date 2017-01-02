package hotelinfo;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import Enum.RoomState;
import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.hotelinfodataservice.HotelinfoDataService_Stub;
import impl.mysql.HotelinfoDataServiceMySqlImpl;
import impl.mysql.HotelstaffDataServiceMySqlImpl;
import po.RoominfoPO;

public class GetRoominfoListTest {
	HotelinfoDataService mysql;
	ArrayList<RoominfoPO> roominfoList;
	public GetRoominfoListTest(){
		mysql = new HotelinfoDataService_Stub();
		RoominfoPO roominfo1 = new RoominfoPO("H00000001","标准间","8304",200, RoomState.Usable);
		RoominfoPO roominfo2 = new RoominfoPO("H00000001","标准间","8305",200, RoomState.Usable);
		RoominfoPO roominfo3 = new RoominfoPO("H00000001","大床房","8306",200, RoomState.Usable);
		RoominfoPO roominfo4 = new RoominfoPO("H00000001","标准间","8307",200, RoomState.Usable);
		RoominfoPO roominfo5 = new RoominfoPO("H00000001","标准间","8308",200, RoomState.Unusable);
		RoominfoPO roominfo6 = new RoominfoPO("H00000001","大床房","8309",200, RoomState.Unusable);
		roominfoList = new ArrayList<RoominfoPO>();
		roominfoList.add(roominfo1);
		roominfoList.add(roominfo2);
		roominfoList.add(roominfo3);
		roominfoList.add(roominfo4);
		roominfoList.add(roominfo5);
		roominfoList.add(roominfo6);
	}
	
	@Test
	public void test1(){
		//正确
		try {
			assertEquals("H00000001",mysql.findRoominfoList("H00000001").get(0).getHotelID());
			assertEquals("8304",mysql.findRoominfoList("H00000001").get(0).getRoomNum());
			assertEquals(200,mysql.findRoominfoList("H00000001").get(0).getPrice(),1);
			assertEquals(RoomState.Usable,mysql.findRoominfoList("H00000001").get(0).getRoomState());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2(){
		//查找不到任何信息
		try {
			assertEquals(null,mysql.findRoominfoList("H00000002"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
