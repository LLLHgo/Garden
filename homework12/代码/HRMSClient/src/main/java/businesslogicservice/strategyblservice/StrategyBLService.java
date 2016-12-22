package businesslogicservice.strategyblservice;

import java.util.List;

import Enum.ResultMessage;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.priceVO.PriceVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public interface StrategyBLService {
	/**
	 * 增加网站营销人员所制定的策略
	 * @param vo
	 * @return 返回是否增加成功
	 */
    public ResultMessage  addMarketingStrategy(MarketingStrategyVO vo);

    /**
     * 返回营销人员所指定的促销策略
     * @param id
     * @return 返回策略信息列表
     */
    public List<MarketingStrategyVO> getMarketingStrategy();

    /**
     * 删除网站营销人员制定的促销策略
     * @param vo
     * @return 返回是否删除成功
     */
    public ResultMessage deleteMarketingStrategy(String vo);
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
    public ResultMessage updateHotelStrategy(HotelStrategyVO vo);

    /**
     * 计算价格
     * @param clientVO
     * @param roomInfoVO
     * @param hotelInfoVO
     * @param num
     * @return 价格
     */
    public PriceVO calculatePrice(ClientVO clientVO,RoominfoVO roomInfoVO,HotelinfoVO hotelInfoVO,int num);


}
