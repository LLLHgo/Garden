//package hotelinfo;
//
//import static org.junit.Assert.assertEquals;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//
//import org.junit.Test;
//
//import Enum.Star;
//import impl.mysql.HotelinfoDataServiceMySqlImpl;
//import po.RoominfoPO;
//
//public class FindHotelinfoTest {
//
//	HotelinfoDataServiceMySqlImpl mysql;
//	
//	public FindHotelinfoTest(){
//		try {
//			mysql = new HotelinfoDataServiceMySqlImpl();
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void test1(){
//		//数据库里有对应的酒店信息
//		try {
//			assertEquals(Star.SEVEN,mysql.findhotelinfo("H00000001").getStar());
//			assertEquals("025-12345678",mysql.findhotelinfo("H00000001").getTel());
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//	}
//	@Test
//	public void test2(){
//		//数据库里没有对应的酒店信息
//		try {
//			assertEquals(null,mysql.findhotelinfo("H00000002"));
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//}
