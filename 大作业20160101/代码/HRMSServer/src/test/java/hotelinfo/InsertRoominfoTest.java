package hotelinfo;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import Enum.RoomState;
import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.hotelinfodataservice.HotelinfoDataService_Stub;
import impl.mysql.HotelinfoDataServiceMySqlImpl;
import po.RoominfoPO;

public class InsertRoominfoTest {
	
	HotelinfoDataService mysql;
	
	public InsertRoominfoTest(){
		mysql = new HotelinfoDataService_Stub();
	}
	
	@Test
	public void test1(){
		RoominfoPO po = new RoominfoPO("H00000003","标准间","8102",200,RoomState.Usable);
		try {
			assertEquals(true,mysql.insertroominfo(po));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
