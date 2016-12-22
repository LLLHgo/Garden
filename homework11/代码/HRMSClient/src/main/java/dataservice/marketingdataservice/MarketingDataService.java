package dataservice.marketingdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.LevelPO;
import po.MarketingPO;

public interface MarketingDataService extends Remote{


	/**
	 * 检查用户登录信息
	 * @param ID
	 * @param password
	 * @return 用户登录信息是否匹配
	 * @throws RemoteException
	 */
    public boolean checkAccount(String ID,String password)throws RemoteException;
    /**
     * 返回已制定的Level信息列表
     * @return 返回Level信息列表
     * @throws RemoteException
     */
    public List<LevelPO> findAllLevel() throws RemoteException ;

    /**
     * 更新Level信息
     * @param po
     * @return 返回是否更新成功
     * @throws RemoteException
     */
    public boolean updateLevel(List<LevelPO> pos) throws RemoteException;

    /**
     * 返回网站营销人员信息
     * @param id
     * @return 返回网站营销人员信息
     * @throws RemoteException
     */
    public MarketingPO getInfo(String id) throws RemoteException;

    /**
     * 更新网站营销人员信息
     * @param po
     * @return 返回是否更新成功
     * @throws RemoteException
     */
    public boolean MarketingAccountUpdate(MarketingPO po) throws RemoteException;

    /**
     * 增加网站营销人员账户
     * @param po
     * @return 返回是否更新成功
     * @throws RemoteException
     */
    public boolean MarketingAccountAdd(MarketingPO po) throws RemoteException;

    /**
     * 删除网站营销人员信息
     * @param po
     * @return 返回是否删除成功
     * @throws RemoteException
     */
    public boolean MarketingAccountDelete(MarketingPO po) throws RemoteException;
}
