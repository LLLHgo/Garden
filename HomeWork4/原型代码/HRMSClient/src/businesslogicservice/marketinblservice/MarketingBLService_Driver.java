package businesslogicservice.marketinblservice;

import java.util.Date;
import java.util.List;
import Enum.OrderType;
import Enum.ResultMessage;
import Enum.VIPType;
import vo.clientVO.ClientVO;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.MarketingStrategyVO;
import vo.strategyVO.PrivilegeVO;

public class MarketingBLService_Driver {
    public void drive(MarketingBLService marketingBLService){
    	//创建MarketingStrategyVO
    	MarketingStrategyVO vo=new MarketingStrategyVO();
    	ResultMessage result=marketingBLService.addMarketingStrategy(vo);
    	if(result==ResultMessage.FAIL)System.out.println("创建MarketingStrategyVO失败");

    	//返回MarketingStrategyVO列表
    	List<MarketingStrategyVO> list=marketingBLService.getMarketingStrategy("M0001");
    	if(list.size()==0)System.out.println("List为空");

    	//删除MarketingStrategyVO
    	ResultMessage deleteResult=marketingBLService.deleteMarketingStrategy(vo);
    	if(deleteResult==ResultMessage.FAIL)System.out.println("删除MarketingStrategyVO失败");

    	//建立LevelVO
    	LevelVO Lvo=new LevelVO(1,"银牌",200);
    	ResultMessage addLevelResult=marketingBLService.addLevel(Lvo);
    	if(addLevelResult==ResultMessage.SUCCESS)System.out.println("建立LevelVO成功");

    	//返回Level等级
    	List<LevelVO> levellist=marketingBLService.findAllLevel();
    	if(levellist.size()>0)System.out.println("返回Level等级成功");

    	//删除等级信息
    	ResultMessage deleteLevelResult=marketingBLService.deleteLevel(Lvo);
    	if(deleteLevelResult==ResultMessage.SUCCESS)System.out.println("删除等级信息成功");

    	//增加策略
    	PrivilegeVO Pvo=new PrivilegeVO();
    	ResultMessage addPrivilegeResult=marketingBLService.addPrivilege(Pvo);
    	if(addPrivilegeResult==ResultMessage.FAIL)System.out.print("增加策略失败");

    	//返回privilegeVOList
    	List<PrivilegeVO> privilegeList=marketingBLService.findAllPrivilege(VIPType.ORDINARYVIP);
    	if(privilegeList.size()>0)System.out.println("返回privilegeVOList成功");

    	//删除Privilege
    	ResultMessage deletePrivilegeResult=marketingBLService.deletePrivilege(Pvo);
    	if(deletePrivilegeResult==ResultMessage.FAIL)System.out.println("删除Privilege失败");

    	//返回当日未执行订单列表
    	Date date=new Date();
    	List<OrderVO> orderList=marketingBLService.showAbnormal(date);
    	if(orderList.size()>0)System.out.print("返回当日未执行订单列表成功");

    	//返回异常订单信息
    	OrderVO Ovo=marketingBLService.findSpecificAbnormalOrder("201610150001");
    	if(Ovo.getOrderStatus()==OrderType.ABNORMAL)System.out.print("返回异常订单信息成功");

        //撤销异常订单
    	ResultMessage handleAbnormalResult=marketingBLService.handleAbnormal(Ovo);
    	if(handleAbnormalResult==ResultMessage.SUCCESS)System.out.println("撤销异常订单成功");

    	//返回客户信息
    	ClientVO Cvo=marketingBLService.getClient("C0001");
    	if(Cvo.getLevel()>1)System.out.println("返回客户信息成功");

    	//设置客户信用值
    	ResultMessage setCreditResult=marketingBLService.setCredit("C0001",200);
    	if(setCreditResult==ResultMessage.SUCCESS)System.out.println("设置客户信用值成功");

    	//修改网站营销人员信息
    	MarketingVO Mvo=new MarketingVO();
    	ResultMessage updateResult=marketingBLService.update(Mvo);
    	if(updateResult==ResultMessage.SUCCESS)System.out.println("修改网站营销人员信息成功");

    	//网站管理人员修改网站营销人员信息
    	ResultMessage siteManagerUpdateResult=marketingBLService.siteManagerUpdate(Mvo);
    	if(siteManagerUpdateResult==ResultMessage.SUCCESS)System.out.println("网站管理人员修改网站营销人员信息成功");

    	//网站管理人员增加营销人员信息
    	boolean addBool=marketingBLService.saveSitemanagerAdd(Mvo);
    	if(addBool)System.out.println("网站管理人员增加营销人员信息成功");

    	//网站管理人员删除营销人员信息
    	boolean deleteBool=marketingBLService.saveSitemanagerDelete(Mvo);
    	if(deleteBool)System.out.println("网站管理人员删除营销人员信息成功");

    	//网站营销人员验证登录密码
    	boolean checkBool=marketingBLService.checkAccount("M0001","password");
    	if(checkBool)System.out.println("网站营销人员验证登录成功");

    	//获得网站营销人员信息
    	MarketingVO mvo=marketingBLService.init("M0001");
    	if(mvo!=null)System.out.println("得到网站营销人员信息成功");

    	//返回网站营销人员的个人信息
    	MarketingVO MVO=marketingBLService.returnSitemanagerAccount("M00010001");
    	if(MVO!=null){System.out.println("已成功返回网站营销人员的个人信息");
    	}
    }
}
