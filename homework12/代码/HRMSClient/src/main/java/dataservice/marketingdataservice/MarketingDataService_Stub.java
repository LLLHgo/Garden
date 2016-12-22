package dataservice.marketingdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.LevelPO;
import po.MarketingPO;

public class MarketingDataService_Stub implements MarketingDataService{


    /**
     * 返回已制定的Level信息列表
     * @return 返回Level信息列表
     * @throws RemoteException
     */
    public List<LevelPO> findAllLevel() throws RemoteException {
    	LevelPO po=new LevelPO(1,"金牌",2000,0.8);
		List<LevelPO> list=new ArrayList<LevelPO>();
		list.add(po);
		return list;
	}

    /**
     * 删除已制定的Level信息
     * @param po
     * @return 返回是否删除成功
     * @throws RemoteException
     */
    public boolean deleteLevel(LevelPO po) throws RemoteException {
    	if(po!=null)
		    return true;
	    else
		    return false;
	}

    /**
     * 返回网站营销人员信息
     * @param id
     * @return 返回网站营销人员信息
     * @throws RemoteException
     */
    public MarketingPO getInfo(String id) throws RemoteException {
		MarketingPO po=new MarketingPO("网站营销人员","password","M00000001","13477778888");
		if(id.charAt(0)!='M')
			return null;
		else
			return po;

	}

    /**
     * 更新网站营销人员信息
     * @param po
     * @return 返回是否更新成功
     * @throws RemoteException
     */
    public boolean MarketingAccountAdd(MarketingPO po) throws RemoteException {
    	if(po!=null)
		    return true;
	    else
		    return false;
	}

    /**
     * 更新网站营销人员信息
     * @param po
     * @return 返回是否更新成功
     * @throws RemoteException
     */
    public boolean MarketingAccountUpdate(MarketingPO po) throws RemoteException {
    	if(po!=null)
		    return true;
	    else
		    return false;
	}

    /**
     * 删除网站营销人员信息
     * @param po
     * @return 返回是否删除成功
     * @throws RemoteException
     */
	public boolean MarketingAccountDelete(MarketingPO po) throws RemoteException {
    	if(po!=null)
    		return true;
		else
		    return false;
	}

	@Override
	public boolean checkAccount(String ID, String password) throws RemoteException {
		if(ID.equals("M00000001")&&password.equals("password"))
			return true;
		else if(ID.equals("M00000004")&&password.equals("passwordfor04"))
			return true;
		else
		 return false;
	}

	@Override
	public boolean updateLevel(List<LevelPO> pos) throws RemoteException {
		if(pos!=null&&pos.size()>0)
			return true;
		else{
			return false;
		}
	}
}
