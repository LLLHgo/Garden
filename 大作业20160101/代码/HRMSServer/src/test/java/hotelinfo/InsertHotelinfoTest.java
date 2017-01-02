package hotelinfo;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import Enum.RoomState;
import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.hotelinfodataservice.HotelinfoDataService_Stub;
import impl.mysql.HotelinfoDataServiceMySqlImpl;
import po.HotelinfoPO;
import po.RoominfoPO;

public class InsertHotelinfoTest {
	
	HotelinfoDataService mysql;
	
	public InsertHotelinfoTest(){
		mysql = new HotelinfoDataService_Stub();
	}
	
	@Test
	public void test1(){
		try {
			assertEquals("H00000002",mysql.inserthotelinfo("lalala"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
