package businesslogicservice.hotelinfoblservice;

import java.util.ArrayList;
import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.ClientRequirementVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelinfoVO.SitemanagerAddVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public interface HotelinfoBLService {
	/**
	 * 请求获得hotelID对应的酒店信息
	 * @param hotelID
	 * @return 酒店信息
	 */
	public HotelinfoVO getBasicinfo(String hotelID);
	/**
	 * 获得符合客户条件的酒店列表信息
	 * @param vo
	 * @return 酒店信息列表
	 */
	public List<HotelinfoVO> getBasicinfoList(ClientRequirementVO vo);
	/**
	 * 持久化保存酒店信息
	 * @param VO
	 * @return 保存成功或失败
	 */
	public ResultMessage updateBassicinfo(HotelinfoVO VO);
	/**
	 * 获得某酒店某类型的房间信息
	 * @param hotelID
	 * @param roomtype
	 * @return 房间信息
	 */
	public RoominfoVO getRoominfo(String hotelID,String roomtype);
	/**
	 * 获得酒店的房间信息列表
	 * @param hotelID
	 * @return 房间信息列表
	 */
	public List<RoominfoVO> getRoominfoList(String hotelID);
	/**
	 * 计算打折后的价格
	 * @return 最终价格
	 */
	public double calculatePrice(List<HotelStrategyVO> hotelStrategylist,
			List<MarketingStrategyVO> marketingStrategyList,ClientVO vo,double originalPrice);

	/**
	 * 获得酒店基本信息
	 * @param vo
	 * @return 酒店信息
	 */
	public HotelinfoVO gethotelinfoVO(String hotelID);
	/**
	 * 获得房间信息
	 * @param roomID
	 * @return 房间信息
	 */
	public RoominfoVO getroominfo(String hotelID,String roomID);
	/**
	 * 将房间信息持久化保存
	 * @param vo
	 * @return 是否将房间信息持久化保存
	 */
	public boolean updateroominfo(RoominfoVO vo,String hotelID);
	/**
	 * 请求持久化保存网站管理人员添加的酒店信息
	 * @param sitemanagerAddVO
	 * @param hotelstaffVO
	 * @return 保存成功或失败
	 */
	ResultMessage saveSitemanagerAdd(SitemanagerAddVO sitemanagerAddVO, HotelstaffVO hotelstaffVO);
	
	/**
	 * 获得系统内所有商圈名
	 * @return String[]
	 */
	public String[] getArea();
	
	/**
	 *添加商圈名 
	 * @return boolean
	 */
	public boolean addArea(String area);
}
