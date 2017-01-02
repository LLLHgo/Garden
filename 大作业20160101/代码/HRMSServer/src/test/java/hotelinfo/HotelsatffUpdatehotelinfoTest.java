package hotelinfo;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import Enum.Star;
import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.hotelinfodataservice.HotelinfoDataService_Stub;
import impl.mysql.HotelinfoDataServiceMySqlImpl;
import po.HotelinfoPO;

public class HotelsatffUpdatehotelinfoTest {

HotelinfoDataService mysql;

	public HotelsatffUpdatehotelinfoTest(){
		mysql = new HotelinfoDataService_Stub();
	}

	@Test
	public void test1(){
		//改变电话
		ArrayList<String> remark = new ArrayList<String>();
		remark.add("超级棒！");
		remark.add("一个很温馨的地方，么么哒~");
		String introduction = "一个可以让大家一起愉快地写大作业的地方哈哈哈哈";
		String hotelID = "H00000001";
		String facility="wifi";
		ArrayList<String> companyList = new ArrayList<String>();
		companyList.add("南京大学软件学院");
		HotelinfoPO po = new HotelinfoPO("LLLH酒店","仙林大道163号","栖霞区商圈",introduction,facility,"1",
			Star.SEVEN,hotelID,companyList);
		try {
			assertEquals(true,mysql.hotelstaffUpdatehotelinfo(po));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test2(){
		//数据库里没有对应的酒店信息
		ArrayList<String> remark = new ArrayList<String>();
		remark.add("超级棒！");
		remark.add("一个很温馨的地方，么么哒~");
		String introduction = "一个可以让大家一起愉快地写大作业的地方哈哈哈哈";
		String hotelID = "H00000002";
		String facility="wifi";
		ArrayList<String> companyList = new ArrayList<String>();
		companyList.add("南京大学软件学院");
		HotelinfoPO po = new HotelinfoPO("LLLH酒店","仙林大道163号","栖霞区商圈",introduction,facility,"025-12345678",
			Star.SEVEN,hotelID,companyList);
		try {
			assertEquals(false,mysql.hotelstaffUpdatehotelinfo(po));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test3(){
		//将酒店信息改回来以免影响别的测试
		ArrayList<String> remark = new ArrayList<String>();
		remark.add("超级棒！");
		remark.add("一个很温馨的地方，么么哒~");
		String introduction = "一个可以让大家一起愉快地写大作业的地方哈哈哈哈";
		String hotelID = "H00000001";
		String facility="wifi";
		ArrayList<String> companyList = new ArrayList<String>();
		companyList.add("南京大学软件学院");
		HotelinfoPO po = new HotelinfoPO("LLLH酒店","仙林大道163号","栖霞区商圈",introduction,facility,"025-12345678",
			Star.SEVEN,hotelID,companyList);
		try {
			assertEquals(true,mysql.hotelstaffUpdatehotelinfo(po));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
