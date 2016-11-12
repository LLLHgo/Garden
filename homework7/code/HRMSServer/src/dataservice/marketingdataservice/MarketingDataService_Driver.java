package dataservice.marketingdataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.LevelPO;
import po.MarketingPO;

public class MarketingDataService_Driver {
    public void drive(MarketingDataService marketingDataService) throws RemoteException{
    	//在数据库中增加一个Level等级信息
    	LevelPO po=new LevelPO(0,"铜牌",0);
    	boolean addLevelBool=marketingDataService.addLevel(po);
    	if(addLevelBool)System.out.println("增加Level信息成功");

    	//从数据库中返回Level信息列表
    	List<LevelPO> list=marketingDataService.findAllLevel();
    	if(list.size()>0)System.out.println("获取Level信息列表成功");

    	//从数据库中删除一个Level信息
    	boolean deleteLevelBool=marketingDataService.deleteLevel(po);
    	if(deleteLevelBool)System.out.println("删除Level信息成功");

    	//返回一个网站营销人员的信息
    	MarketingPO Mpo=marketingDataService.getInfo("M0001");
    	if(Mpo!=null)System.out.println("返回网站营销人员信息成功");

    	//更新网站营销人员信息
    	boolean updateAndAddBool=marketingDataService.updateAndAdd(Mpo);
    	if(updateAndAddBool)System.out.println("更新网站营销人员信息成功");

    	//删除网站营销人员信息
    	boolean deleteBool=marketingDataService.delete(Mpo);
    	if(deleteBool)System.out.println("删除网站营销人员信息成功");

    }


}
