package datatool;

import java.util.ArrayList;
import java.util.List;

import vo.districtVO.DistrictVO;

public class DistrictDataTool {
	public static List<String> list1=new ArrayList<String>();
	public static List<String> list2=new ArrayList<String>();
	static{
		list1.add("南京英尊假日酒店");
		list1.add("南京悦宁酒店");
		list1.add("南京松山湖宾馆");
		list1.add("南京新地酒店");
		list2.add("南京金陵饭店");
		list2.add("芷服青年旅社");
		list2.add("汉庭（南京新街口管家桥店）");
		list2.add("南京明日大酒店");
		list2.add("南京8090青年旅社");
		list2.add("支点公寓");
	}
    public static DistrictVO dis1=new DistrictVO("仙林大学城",list1);
    public static DistrictVO dis2=new DistrictVO("新街口",list2);


}
