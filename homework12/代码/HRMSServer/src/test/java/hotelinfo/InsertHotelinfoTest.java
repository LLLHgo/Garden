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
//import po.HotelinfoPO;
//import po.RoominfoPO;
//
//public class InsertHotelinfoTest {
//	
//	HotelinfoDataServiceMySqlImpl mysql;
//	
//	public InsertHotelinfoTest(){
//		try {
//			mysql = new HotelinfoDataServiceMySqlImpl();
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void test1(){
//		assertEquals("H00000002",mysql.insertHotelinfo("lalala"));
//	}
//}
