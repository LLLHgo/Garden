package dataservice.strategydataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.StrategyPO.StrategyPO;

public class StrategyDataService_Driver {
    public void drive(StrategyDataService strategyDataService) throws RemoteException{

      /*	//增加网站营销人员促销策略
    	MarketingStrategyPO Mpo=new MarketingStrategyPO();
    	boolean addMarketingStrategyBool=strategyDataService.addMarketingStrategy(Mpo);
    	if(addMarketingStrategyBool)System.out.println("增加网站营销人员促销策略成功");*/

        //返回网站营销人员促销策略列表
    	List<StrategyPO> marketingStrategyList=strategyDataService.getMarketingStrategy ();
    	if(marketingStrategyList.size()>0)System.out.println("返回网站营销人员促销策略列表成功");

    /*	//删除网站营销人员促销策略
    	boolean deleteMarketingStrategyBool=strategyDataService.deleteMarketingStrategy (Mpo);
    	if(deleteMarketingStrategyBool)System.out.println("删除网站营销人员促销策略成功");

    	//获取酒店工作人员促销策略列表
    	List<HotelStrategyPO> hotelStrategyList=strategyDataService.getHotelStrategy("H00010002");
    	if(hotelStrategyList.size()>0)System.out.println("获取酒店工作人员促销策略列表成功");

    	//更新酒店工作人员促销策略
    	HotelStrategyPO Hpo=new HotelStrategyPO();
    	boolean updateHotelStrategyBool=strategyDataService.updateHotelStrategy(Hpo);
    	if(updateHotelStrategyBool)System.out.println("更新酒店工作人员促销策略成功");*/
    }
}
