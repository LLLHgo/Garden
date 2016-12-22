package businesslogicservice.strategyblservice;

import java.util.List;

import Enum.ResultMessage;
import Enum.VIPType;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;
import vo.strategyVO.PrivilegeVO;

public class StrategyBLService_Driver {
    public void drive(StrategyBLService strategyBLService){
    	//增加网站营销人员促销策略信息
    	MarketingStrategyVO Mvo=new MarketingStrategyVO();
    	ResultMessage  addMarketingStrategyBool=strategyBLService.addMarketingStrategy(Mvo);
    	if(addMarketingStrategyBool==ResultMessage.SUCCESS)System.out.println("增加网站营销人员促销策略信息成功。");

    	//返回网站营销人员制定的促销策略信息列表
    	List<MarketingStrategyVO> marketingStrategyList=strategyBLService.getMarketingStrategy("M00010001");
    	if(marketingStrategyList.size()>0)System.out.println("返回网站营销人员制定的促销策略信息列表成功。");

    	//删除网站营销人员促销策略信息
    	ResultMessage deleteMarketingStrategy=strategyBLService.deleteMarketingStrategy(Mvo);
    	if(deleteMarketingStrategy==ResultMessage.SUCCESS)System.out.println("删除网站营销人员促销策略信息成功。");

    	//返回酒店工作人员制定的促销策略信息列表
    	List<HotelStrategyVO> hotelStrategyList=strategyBLService.getHotelStrategy("凯撒饭店");
    	if(hotelStrategyList.size()>0)System.out.println("返回酒店工作人员制定的促销策略信息列表成功。");

    	//更新酒店工作人员促销策略信息
    	HotelStrategyVO Hvo=new HotelStrategyVO();
    	ResultMessage updateHotelStrategyBool=strategyBLService.updateHotelStrategy("H0000001",Hvo);
    	if(updateHotelStrategyBool==ResultMessage.SUCCESS)System.out.println("更新酒店工作人员促销策略信息成功。");

    	//增加会员福利
    	PrivilegeVO Pvo=new PrivilegeVO();
    	ResultMessage addPrivilegeBool=strategyBLService.addPrivilege(Pvo);
    	if(addPrivilegeBool==ResultMessage.SUCCESS)System.out.println("增加会员福利成功");

    	//返回会员福利信息列表
    	List<PrivilegeVO> privilegeVOList=strategyBLService.findAllPrivilege(VIPType.ORDINARYVIP);
    	if(privilegeVOList.size()>0)System.out.println("返回会员福利信息列表成功。");

    	//删除会员福利
    	ResultMessage deleteBool=strategyBLService.deletePrivilege(Pvo);
    	if(deleteBool==ResultMessage.SUCCESS)System.out.println("删除会员福利成功");
    }
}
