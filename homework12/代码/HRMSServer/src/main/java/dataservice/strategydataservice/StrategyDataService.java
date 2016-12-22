package dataservice.strategydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.StrategyPO.HotelStrategyPO;
import po.StrategyPO.MarketingStrategyPO;
import po.StrategyPO.StrategyPO;

public interface StrategyDataService extends Remote{


    /**
     * 增加网站营销人员促销策略
     * @param po
     * @return 是否增加成功
     */
    public boolean addMarketingStrategy(MarketingStrategyPO po)throws RemoteException;

    /**
     * 返回网站营销人员指定的额策略列表
     * @param id
     * @return 返回策略列表
     */
    public List<StrategyPO> getMarketingStrategy ()throws RemoteException;

    /**
     * 删除网站营销人员制定的策略
     * @param po
     * @return 返回是否删除成功
     */
    public boolean deleteMarketingStrategy (String marketingStrategy)throws RemoteException;

    /**
     * 根据hotelID返回该酒店制定的策略
     * @param hotelID
     * @return 返回策略列表
     */
    public List<StrategyPO> getHotelStrategy(String hotelID)throws RemoteException;

    /**
     * 更新酒店策略
     * @param po
     * @return 返回是否更新成功
     */
    public boolean updateHotelStrategy(HotelStrategyPO po) throws RemoteException;
}
