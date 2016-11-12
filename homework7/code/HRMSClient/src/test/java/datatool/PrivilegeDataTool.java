package datatool;

import java.util.ArrayList;
import java.util.List;

import Enum.PrivilegeWay;
import Enum.VIPType;
import vo.strategyVO.PrivilegeVO;

public class PrivilegeDataTool {
	static List<String> elist=new ArrayList<String>();
	static{
		elist.add("苏宁电器");
		elist.add("南京大学");
	}
    public static PrivilegeVO p1=new PrivilegeVO("生日特惠",VIPType.ORDINARYVIP,0.88,PrivilegeWay.BIRTHDAY);
    public static PrivilegeVO p2=new PrivilegeVO("企业特惠",VIPType.ENTERPRISEVIP,0.9,PrivilegeWay.DAILY,
    		elist);
}
