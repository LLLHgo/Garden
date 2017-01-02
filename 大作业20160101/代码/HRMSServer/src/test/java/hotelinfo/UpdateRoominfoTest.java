package hotelinfo;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import Enum.RoomState;
import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.hotelinfodataservice.HotelinfoDataService_Stub;
import impl.mysql.HotelinfoDataServiceMySqlImpl;
import po.RoominfoPO;

public class UpdateRoominfoTest {

HotelinfoDataService mysql;
	
	public UpdateRoominfoTest(){
		mysql = new HotelinfoDataService_Stub();
	}
	
	@Test
	public void test1(){
		RoominfoPO po = new RoominfoPO("H00000001","标准间","8304",666.6,RoomState.Usable);
		//修改价格成功
		try {
			assertEquals(true,mysql.updateroominfo(po));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test2(){
		RoominfoPO po = new RoominfoPO("H00000001","标准间","8304",666.6,RoomState.Unusable);
		//修改状态成功
		try {
			assertEquals(true,mysql.updateroominfo(po));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3(){
		//查找不到要修改的房间号
		RoominfoPO po = new RoominfoPO("H00000001","标准间","8311",666.6,RoomState.Unusable);
		try {
			assertEquals(false,mysql.updateroominfo(po));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test4(){
		//查找不到要修改的酒店
		RoominfoPO po = new RoominfoPO("H00000002","标准间","8304",666.6,RoomState.Unusable);
		try {
			assertEquals(false,mysql.updateroominfo(po));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test5(){
		//修改成功，将房间信息恢复成和原来一样以免影响其他测试用例
		RoominfoPO po = new RoominfoPO("H00000001","标准间","8304",200,RoomState.Usable);
		try {
			assertEquals(true,mysql.updateroominfo(po));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
