package dataservice.sitemanagerdataservice;

import java.rmi.RemoteException;

import po.SitemanagerPO;
/**
 * sitemanager接口的数据层驱动
 * @author yilu
 *
 */
public class SitemanagerDataService_Driver {
	public void driver(SitemanagerDataService sitemanagerDataService)throws RemoteException{
		SitemanagerPO sitemanagerPO;
		boolean result;
		
		// 从数据库中得到网站管理人员账户信息
	    System.out.println("从数据库中得到网站管理人员账户信息:");
	    sitemanagerPO=sitemanagerDataService.getAccount();
	    System.out.println("网站管理人员账户信息如下:");
	    //System.out.println(sitemanagerPO.getSitemanagerId()+" "+sitemanagerPO.getPassword()+" "+sitemanagerPO.getSitemanagerPhoneNumber());
	    System.out.println("这里是网站管理人员账户信息");
	
	    // 修改数据库中网站管理人员账户信息
	    System.out.println("修改数据库中网站管理人员账户信息:");
	    result=sitemanagerDataService.SitemanagerAccountUpdate(new SitemanagerPO("S00000001","010-08923","s123"));
	    if(result==true){
	    	System.out.println("修改站管理人员账户信息成功");
	    }
	    else
	    	System.out.println("修改站管理人员账户信息失败");
	
	}
}
