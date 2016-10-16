package businesslogicservice.strategyblservice;

import java.util.ArrayList;
import java.util.List;

import Enum.VIPType;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;
import vo.strategyVO.PrivilegeVO;

public class StrategyBLService_Stub implements StrategyBLService{

	/**
	 * 增加网站营销人员所制定的策略
	 * @param vo
	 * @return 返回是否增加成功
	 */
    public boolean  addMarketingStrategy(MarketingStrategyVO vo) {
		if(vo!=null)
			return true;
		else
			return false;
	}

    /**
     * 返回营销人员所指定的促销策略
     * @param id
     * @return 返回策略信息列表
     */
    public List<MarketingStrategyVO> getMarketingStrategy(String id) {
		MarketingStrategyVO vo=new MarketingStrategyVO();
		List<MarketingStrategyVO> list=new ArrayList<MarketingStrategyVO>();
		list.add(vo);
		return list;
	}

    /**
     * 删除网站营销人员制定的促销策略
     * @param vo
     * @return 返回是否删除成功
     */
    public boolean deleteMarketingStrategy(MarketingStrategyVO vo) {
    	if(vo!=null)
			return true;
		else
			return false;
	}

    /**
     * 根据酒店ID返回该酒店的促销策略
     * @param hotelID
     * @return 返回该酒店的促销策略列表
     */
    public List<HotelStrategyVO> getHotelStrategy(String hotelID) {
    	HotelStrategyVO vo=new HotelStrategyVO();
		List<HotelStrategyVO> list=new ArrayList<HotelStrategyVO>();
		list.add(vo);
		return list;
	}

    /**
     * 更新酒店制定的促销策略
     * @param vo
     * @return 返回是否更新成功
     */
    public boolean updateHotelStrategy(HotelStrategyVO vo) {
    	if(vo!=null)
			return true;
		else
			return false;
	}

    /**
     * 增加会员福利信息
     * @param vo
     * @return 返回是否增加成功
     */
    public  boolean addPrivilege(PrivilegeVO vo) {
    	if(vo!=null)
			return true;
		else
			return false;
	}

    /**
     * 根据VIPType返回该类型VIP的福利优惠信息
     * @param VIPType
     * @return 返回福利信息列表
     */
    public List<PrivilegeVO> findAllPrivilege(VIPType type) {
		List<PrivilegeVO> list=new ArrayList<PrivilegeVO>();
		PrivilegeVO vo=new PrivilegeVO();
        list.add(vo);
        return list;
	}

    /**
     * 删除会员福利信息
     * @param vo
     * @return 返回是否删除成功
     */
    public boolean delete(PrivilegeVO vo) {
    	if(vo!=null)
			return true;
		else
			return false;
	}
}
