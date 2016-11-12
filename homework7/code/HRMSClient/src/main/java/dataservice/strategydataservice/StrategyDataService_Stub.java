package dataservice.strategydataservice;

import java.util.ArrayList;
import java.util.List;

import Enum.VIPType;
import po.HotelStrategyPO;
import po.MarketingStrategyPO;
import po.PrivilegePO;

public class StrategyDataService_Stub implements StrategyDataService{
	/**
	 * 增加会员福利信息
	 * @param po
	 * @return 是否增加成功
	 */
    public boolean addPrivilege(PrivilegePO po) {
		if(po!=null)
			return true;
		else
			return false;
	}

    /**
     * 根据VIPtype返回已制定的会员福利信息
     * @param type
     * @return 返回该种类会员的福利信息列表
     */
    public List<PrivilegePO> findAllPrivilege(VIPType type) {
		PrivilegePO po=new PrivilegePO();
		List<PrivilegePO> list=new ArrayList<PrivilegePO>();
		list.add(po);
		return list;
	}

    /**
     * 删除会员福利信息
     * @param po
     * @return 返回是否删除成功
     */
    public boolean deletePrivilege(PrivilegePO po) {
    	if(po!=null)
			return true;
		else
			return false;
	}

    /**
     * 增加网站营销人员促销策略
     * @param po
     * @return 是否增加成功
     */
    public boolean addMarketingStrategy(MarketingStrategyPO po) {
    	if(po!=null)
			return true;
		else
			return false;
	}

    /**
     * 返回网站营销人员指定的额策略列表
     * @param id
     * @return 返回策略列表
     */
    public List<MarketingStrategyPO> getMarketingStrategy (String id) {
    	MarketingStrategyPO po=new MarketingStrategyPO();
    	List<MarketingStrategyPO> list=new ArrayList<MarketingStrategyPO>();
    	list.add(po);
		return list;
	}

    /**
     * 删除网站营销人员制定的策略
     * @param po
     * @return 返回是否删除成功
     */
    public boolean deleteMarketingStrategy (MarketingStrategyPO po) {
    	if(po!=null)
			return true;
		else
			return false;
	}

    /**
     * 根据hotelID返回该酒店制定的策略
     * @param hotelID
     * @return 返回策略列表
     */
    public List<HotelStrategyPO> getHotelStrategy(String hotelID) {
    	HotelStrategyPO po=new HotelStrategyPO();
    	List<HotelStrategyPO> list=new ArrayList<HotelStrategyPO>();
    	list.add(po);
		return list;
	}

    /**
     * 更新酒店策略
     * @param po
     * @return 返回是否更新成功
     */
    public boolean updateHotelStrategy(HotelStrategyPO po) {
    	if(po!=null)
			return true;
		else
			return false;
	}
}
