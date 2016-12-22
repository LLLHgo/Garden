//package hotelstaff;
//
//import static org.junit.Assert.assertEquals;
//
//import java.rmi.RemoteException;
//
//import org.junit.Test;
//
//import dataservice.hotelstaffdataservice.HotelstaffDataService;
//import impl.mysql.HotelstaffDataServiceMySqlImpl;
//
//public class FindTest {
//	HotelstaffDataServiceMySqlImpl hotelstaff;
//	
//	public FindTest(){
//		try {
//			hotelstaff = new HotelstaffDataServiceMySqlImpl();
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void test1() throws RemoteException{
//		//正确查找
//		assertEquals("000000",hotelstaff.find("H00000001").getPassword());
//	}
//	
//	@Test
//	public void test2() throws RemoteException{
//		//没有找到
//		assertEquals(null,hotelstaff.find("H00000002"));
//	}
//}
