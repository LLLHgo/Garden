package hotelstaff;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import dataservice.hotelstaffdataservice.HotelstaffDataService;
import dataservice.hotelstaffdataservice.HotelstaffDataService_Stub;
import impl.mysql.HotelstaffDataServiceMySqlImpl;

public class FindTest {
	HotelstaffDataService hotelstaff;
	
	public FindTest(){
		hotelstaff = new HotelstaffDataService_Stub();
	}
	
	@Test
	public void test1() throws RemoteException{
		//正确查找
		assertEquals("000000",hotelstaff.find("H00000001").getPassword());
	}
	
	@Test
	public void test2() throws RemoteException{
		//没有找到
		assertEquals(null,hotelstaff.find("H00000002"));
	}
}
