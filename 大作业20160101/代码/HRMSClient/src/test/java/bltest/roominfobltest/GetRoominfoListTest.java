//package bltest.roominfobltest;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import Enum.RoomState;
//import businesslogic.hoteinfobl.RoominfoManage;
//import po.RoominfoPO;
//
//public class GetRoominfoListTest {
//
//	RoominfoManage roominfo = new RoominfoManage();
//	RoominfoPO roominfo1 = new RoominfoPO("H00000001","标准间","8304",200, RoomState.Usable);
//	RoominfoPO roominfo2 = new RoominfoPO("H00000001","标准间","8305",200, RoomState.Usable);
//	RoominfoPO roominfo3 = new RoominfoPO("H00000001","大床房","8306",200, RoomState.Usable);
//	RoominfoPO roominfo4 = new RoominfoPO("H00000001","标准间","8307",200, RoomState.Usable);
//	RoominfoPO roominfo5 = new RoominfoPO("H00000001","标准间","8308",200, RoomState.Unusable);
//	RoominfoPO roominfo6 = new RoominfoPO("H00000001","大床房","8309",200, RoomState.Unusable);
//	ArrayList<RoominfoPO> roominfoList = new ArrayList<RoominfoPO>();
//	
//	@Before
//	public void init(){
//	roominfoList.add(roominfo1);
//	roominfoList.add(roominfo2);
//	roominfoList.add(roominfo3);
//	roominfoList.add(roominfo4);
//	roominfoList.add(roominfo5);
//	roominfoList.add(roominfo6);
//	}
//	
//	@Test
//	public void test1(){
//		assertEquals("8304",roominfo.getRoominfoList("H00000001").get(0).getRoomNum());
//		assertEquals(200,roominfo.getRoominfoList("H00000001").get(0).getPrice(),0);
//		assertEquals(RoomState.Usable,roominfo.getRoominfoList("H00000001").get(0).getRoomState());
//		assertEquals("标准间",roominfo.getRoominfoList("H00000001").get(0).getType());
//	}
//}
