package hotelstaff;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import dataservice.hotelstaffdataservice.HotelstaffDataService;
import dataservice.hotelstaffdataservice.HotelstaffDataService_Stub;
import impl.mysql.HotelstaffDataServiceMySqlImpl;
import po.HotelstaffPO;

public class InsertTest {
		HotelstaffDataService hotelstaff;
		
		public InsertTest(){
			hotelstaff = new HotelstaffDataService_Stub();
		}
		
		@Test
		public void test1() throws RemoteException{
			//正确insert
			HotelstaffPO po = new HotelstaffPO("H00000000","000000","123456");
			assertEquals(true,hotelstaff.insert(po));
		}
		
//		@Test
//		public void test2() throws RemoteException{
//			//没有找到
//			assertEquals(null,hotelstaff.find("H00000002"));
//		}
}
