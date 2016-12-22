//package hotelinfo;
//
//import static org.junit.Assert.assertEquals;
//
//import java.rmi.RemoteException;
//
//import org.junit.Test;
//
//import Enum.RoomState;
//import impl.mysql.HotelinfoDataServiceMySqlImpl;
//import po.RoominfoPO;
//
//public class InsertRoominfoTest {
//	
//	HotelinfoDataServiceMySqlImpl mysql;
//	
//	public InsertRoominfoTest(){
//		try {
//			mysql = new HotelinfoDataServiceMySqlImpl();
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void test1(){
//		RoominfoPO po = new RoominfoPO("H00000003","标准间","8102",200,RoomState.Usable);
//		assertEquals(true,mysql.insertRoominfo(po));
//	}
//}
