package dataservice.sitemanagerdataservice;

import java.rmi.RemoteException;

import po.SitemanagerPO;
/**
 * sitamanger的数据层接口的桩
 * @author yilu
 *
 */
public class SitemanagerDataService_Stub implements SitemanagerDataService{
	
	SitemanagerPO sitemanagerPO;
	
	public SitemanagerDataService_Stub(SitemanagerPO sitemanagerPO) throws RemoteException{
		this.sitemanagerPO=sitemanagerPO;	
	}
	
	/**
	 * 从数据库中得到网站管理人员账户信息
	 * @return 网站管理人员PO
	 */
	public SitemanagerPO getAccount()throws RemoteException{
		return sitemanagerPO;
	}
	/**
	 * 修改数据库中网站管理人员账户信息
	 * @return  修改成功（true）或失败（false）
	 */
	public boolean SitemanagerAccountUpdate(SitemanagerPO sitemanagerPO) throws RemoteException{
		return true;
	}
	

}
