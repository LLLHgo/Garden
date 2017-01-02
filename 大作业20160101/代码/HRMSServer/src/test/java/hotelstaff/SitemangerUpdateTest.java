package hotelstaff;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import dataservice.hotelstaffdataservice.HotelstaffDataService;
import dataservice.hotelstaffdataservice.HotelstaffDataService_Stub;
import impl.mysql.HotelstaffDataServiceMySqlImpl;
import po.HotelstaffPO;

public class SitemangerUpdateTest {
	HotelstaffDataService hotelstaff;
	
	public SitemangerUpdateTest(){
		hotelstaff = new HotelstaffDataService_Stub();
	}
	
	@Test
	public void test1() throws RemoteException{
		//正确修改
		HotelstaffPO po = new HotelstaffPO();
		po.setHotelID("H00000001");
		po.setPassword("111111");
		po.setTel("345678");
		assertEquals(true,hotelstaff.sitemanagerUpdate(po));
	}
	
	@Test
	public void test2() throws RemoteException{
		//没有找到
		HotelstaffPO po = new HotelstaffPO();
		po.setHotelID("H00000002");
		po.setPassword("111111");
		po.setTel("123456");
		assertEquals(false,hotelstaff.sitemanagerUpdate(po));
	}
	
	@Test
	public void test3() throws RemoteException{
		//将密码恢复到000000，电话恢复到123456,否则影响别的测试用例
		HotelstaffPO po = new HotelstaffPO();
		po.setHotelID("H00000001");
		po.setPassword("000000");
		po.setTel("123456");
		assertEquals(true,hotelstaff.hotelstaffUpdate(po));
	}
}
