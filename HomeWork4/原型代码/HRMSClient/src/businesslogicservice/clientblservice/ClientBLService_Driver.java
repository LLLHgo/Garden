package businesslogicservice.clientblservice;

import java.io.File;
import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.ClientRequirementVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.levelVO.LevelVO;
import vo.orderVO.OrderVO;

public class ClientBLService_Driver {
	public void drive(ClientBLService clientBLService){
		//测试取客户个人信息
		ClientVO vo=clientBLService.getclient("000001");
		if(vo!=null)System.out.println("Get Client!");
		//测试创建新客户
		boolean cc=clientBLService.createClient(vo);
		if(cc)System.out.println("New Client!ERROR!");
		//测试设置信用值
		boolean sc=clientBLService.setCredit("000001", 2);
		if(sc)System.out.println("Update Credit!");
		//测试设置会员等级
		boolean sal=clientBLService.setAllClientLevel(new LevelVO(0, null, 0));
		if(sal)System.out.println("Set Level!");
		//测试搜索酒店
		List<HotelinfoVO> hil=clientBLService.getSearchHotel(new ClientRequirementVO());
		if(hil!=null)System.out.println("Get Hotel List!");
		//测试查看正常已完成订单列表
		List<OrderVO> ol=clientBLService.getOrderList("000001", OrderType.NORMALEXEC);
		if(ol!=null)System.out.println("Get Client Normal Execeeded List!");
		//测试修改个人基本信息
		if(clientBLService.updateInfo(vo)==ResultMessage.SUCCESS)System.out.println("Update Info!");
		//测试查看个人信用记录
		File cr=clientBLService.getCreditRecord("000001");
		if(cr!=null)System.out.println("Get Client Credit Record!");
	}
}


