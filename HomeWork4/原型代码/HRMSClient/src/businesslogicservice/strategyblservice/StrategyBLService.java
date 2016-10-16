package businesslogicservice.strategyblservice;

import java.util.List;

import Enum.VIPType;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;
import vo.strategyVO.PrivilegeVO;

public interface StrategyBLService {
	/**
	 * 增加网站营销人员所制定的策略
	 * @param vo
	 * @return 返回是否增加成功
	 */
    public boolean  addMarketingStrategy(MarketingStrategyVO vo);

    /**
     * 返回营销人员所指定的促销策略
     * @param id
     * @return 返回策略信息列表
     */
    public List<MarketingStrategyVO> getMarketingStrategy(String id);

    /**
     * 删除网站营销人员制定的促销策略
     * @param vo
     * @return 返回是否删除成功
     */
    public boolean deleteMarketingStrategy(MarketingStrategyVO vo);

    /**
     * 根据酒店ID返回该酒店的促销策略
     * @param hotelID
     * @return 返回该酒店的促销策略列表
     */
    public List<HotelStrategyVO> getHotelStrategy(String hotelID);

    /**
     * 更新酒店制定的促销策略
     * @param vo
     * @return 返回是否更新成功
     */
    public boolean updateHotelStrategy(HotelStrategyVO vo);

    /**
     * 增加会员福利信息
     * @param vo
     * @return 返回是否增加成功
     */
    public  boolean addPrivilege(PrivilegeVO vo);

    /**
     * 根据VIPType返回该类型VIP的福利优惠信息
     * @param VIPType
     * @return 返回福利信息列表
     */
    public List<PrivilegeVO> findAllPrivilege(VIPType type);

    /**
     * 删除会员福利信息
     * @param vo
     * @return 返回是否删除成功
     */
    public boolean delete(PrivilegeVO vo);

}
