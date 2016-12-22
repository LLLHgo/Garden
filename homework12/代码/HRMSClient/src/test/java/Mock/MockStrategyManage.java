package Mock;

import java.util.ArrayList;
import java.util.List;

import datatool.HotelStrategyDataTool;
import datatool.MarketingStrategyDataTool;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class MockStrategyManage {

	public MockStrategyManage(){
	}

   /**
    * 增加网站营销人员指定的额促销策略
    * @param vo
    * @return 是否增加成功
    */
	public boolean addMarketingStrategy(MarketingStrategyVO vo) {
        return true;
	}
    /**
     * 获得网站营销人员的策略列表
     * @param id
     * @return 返回网站营销人员的策略列表
     */
	public List<MarketingStrategyVO> getMarketingStrategy(String id) {
		List<MarketingStrategyVO> list=new ArrayList<MarketingStrategyVO>();
		    list.add(MarketingStrategyDataTool.V1);
		    list.add(MarketingStrategyDataTool.V2);
		    list.add(MarketingStrategyDataTool.V3);
		return list;
	}

    /**
     * 删除策略
     * @param vo
     * @return 是否删除成功
     */
	public boolean deleteMarketingStrategy(MarketingStrategyVO vo) {
        return true;
	}
	 /**
     * 删除策略
     * @param vo
     * @return 是否删除成功
     */
	public boolean deleteHotelStrategy(HotelStrategyVO vo) {
        return true;
	}
    /**
     * 获得酒店策略列表
     * @param hotelID
     * @return 酒店策略列表
     */
	public List<HotelStrategyVO> getHotelStrategy(String hotelID) {
		List<HotelStrategyVO> list=new ArrayList<HotelStrategyVO>();
		if(hotelID=="H00000001"){
			list.add( HotelStrategyDataTool.V1);
			list.add( HotelStrategyDataTool.V2);
			list.add( HotelStrategyDataTool.V3);
			list.add( HotelStrategyDataTool.V4);
			list.add( HotelStrategyDataTool.V1);
			list.add( HotelStrategyDataTool.V2);
			list.add( HotelStrategyDataTool.V3);
			list.add( HotelStrategyDataTool.V4);
			list.add( HotelStrategyDataTool.V1);
			list.add( HotelStrategyDataTool.V1);
			list.add( HotelStrategyDataTool.V1);
		}
		else if(hotelID=="H00000031")
			list.add( HotelStrategyDataTool.V2);
		else if(hotelID=="H00000003")
			list.add(HotelStrategyDataTool.V3);
		else if(hotelID=="H00000093")
			list.add(HotelStrategyDataTool.V4);
		return list;
	}

    /**
     * 更新酒店策略
     * @param vo
     * @return 是否更新成功
     */
	public boolean updateHotelStrategy(HotelStrategyVO vo) {
		if(vo!=null)
		    return true;
		else
			return false;

	}

}
