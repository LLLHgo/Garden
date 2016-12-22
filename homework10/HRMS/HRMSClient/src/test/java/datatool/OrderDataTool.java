package datatool;

import java.util.ArrayList;

import Enum.OrderType;
import Enum.VIPType;
import vo.orderVO.OrderVO;

public class OrderDataTool {
	// findSpecificOrderList(20161015085702):orderVO1
	// findUserOrderList(C00000002):list1
	// findSpecificDayClientOrder(C00000002,2016-10-15):list2
	// findSpecificHotelClientOrder(C00000010,H00000002):list1
	// findUserTypeOrder(NORMALNONEXEC,C00000002):list1
	// findSpecificHotelOrder("H00000001","20161016092301"):orderVO4
	// findAbnormalOrderList("2016-10-17"):list3

	public static ArrayList<String> strategy;
	public static ArrayList<OrderVO> list1;
	public static ArrayList<OrderVO> list2;
	public static ArrayList<OrderVO> list3;

	static{
		String strategy1="M2016091501";
		String strategy2="H2016091602";
		strategy=new ArrayList<String>();
		strategy.add(strategy1);
		strategy.add(strategy2);
	}

	public static OrderVO orderVO1=new OrderVO("20161015085702","C00000002","Lucy","17714368889",
			VIPType.ORDINARYVIP,"2016-10-15 08:57",OrderType.NORMALNONEXEC,"caesar","H00000001",650.32,strategy);

	public static OrderVO orderVO2=new OrderVO("20161015095706","C00000002","Lucy","17714368889",
			VIPType.ORDINARYVIP,"2016-10-15 09:57",OrderType.NORMALNONEXEC,"caesar","H00000001",650.32,strategy);

	public static OrderVO orderVO3=new OrderVO("20161017090702","C00000002","Lucy","17714368889",
			VIPType.ORDINARYVIP,"2016-10-17 09:07",OrderType.NORMALNONEXEC,"caesar","H00000001",650.32,strategy);

	public static OrderVO orderVO4=new OrderVO("20161016092301","C00000010","Lily","17887780990"
			,VIPType.ORDINARYVIP,"2016-10-16 09:23",OrderType.NORMALNONEXEC,"LLLHH","H00000002",998,strategy);

	public static OrderVO orderVO5=new OrderVO("20161017092401","C00000011","Tinny","17887780991"
			,VIPType.ORDINARYVIP,"2016-10-17 09:24",OrderType.ABNORMAL,"LLLHH","H00000002",666,strategy);

	public static OrderVO orderVO6=new OrderVO("20161017092501","C00000012","belikout","17887780992"
			,VIPType.ORDINARYVIP,"2016-10-17 09:25",OrderType.ABNORMAL,"LLLHH","H00000002",666,strategy);

	public static OrderVO orderVO7=new OrderVO("20161017092601","C00000013","sweetstreet","17887780993"
			,VIPType.ORDINARYVIP,"2016-10-17 09:26",OrderType.ABNORMAL,"LLLHH","H00000002",666,strategy);


	static {
		list1=new ArrayList<OrderVO>();
		list1.add(orderVO1);
		list1.add(orderVO2);
		list1.add(orderVO3);

		list2=new ArrayList<OrderVO>();
		list2.add(orderVO1);
		list2.add(orderVO2);

		list3=new ArrayList<OrderVO>();
		list3.add(orderVO1);
		list3.add(orderVO2);
	}

}
