package dataservice.strategydataservice;

import java.util.List;

import Enum.VIPType;
import po.HotelStrategyPO;
import po.MarketingStrategyPO;
import po.PrivilegePO;

public interface StrategyDataService {
	/**
	 * 增加会员福利信息
	 * @param po
	 * @return 是否增加成功
	 */
    public boolean addPrivilege(PrivilegePO po);

    /**
     * 根据VIPtype返回已制定的会员福利信息
     * @param type
     * @return 返回该种类会员的福利信息列表
     */
    public List<PrivilegePO> findAllPrivilege(VIPType type);

    /**
     * 删除会员福利信息
     * @param po
     * @return 返回是否删除成功
     */
    public boolean deletePrivilege(PrivilegePO po);

    /**
     * 增加网站营销人员促销策略
     * @param po
     * @return 是否增加成功
     */
    public boolean addMarketingStrategy(MarketingStrategyPO po);

    /**
     * 返回网站营销人员指定的额策略列表
     * @param id
     * @return 返回策略列表
     */
    public List<MarketingStrategyPO> getMarketingStrategy (String id);

    /**
     * 删除网站营销人员制定的策略
     * @param po
     * @return 返回是否删除成功
     */
    public boolean deleteMarketingStrategy (MarketingStrategyPO po);

    /**
     * 根据hotelID返回该酒店制定的策略
     * @param hotelID
     * @return 返回策略列表
     */
    public List<HotelStrategyPO> getHotelStrategy(String hotelID);

    /**
     * 更新酒店策略
     * @param po
     * @return 返回是否更新成功
     */
    public boolean updateHotelStrategy(HotelStrategyPO po);
}
