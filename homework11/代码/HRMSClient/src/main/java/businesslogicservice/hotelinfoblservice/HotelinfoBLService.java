package businesslogicservice.hotelinfoblservice;

import java.util.ArrayList;
import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import vo.areaVO.AreaVO;
import vo.clientVO.ClientVO;
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
	public ArrayList<HotelinfoVO> getBasicinfoList(String area);
	/**
	 * 持久化保存酒店信息
	 * @param VO
	 * @return 保存成功或失败
	 */
	public ResultMessage updateBassicinfo(HotelinfoVO VO);
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
	/**
	 * 请求持久化保存网站管理人员添加的酒店信息
	 * @param sitemanagerAddVO
	 * @param hotelstaffVO
	 * @return 保存成功或失败
	 */
	ResultMessage saveSitemanagerAdd(SitemanagerAddVO sitemanagerAddVO, HotelstaffVO hotelstaffVO);
	
	/**
	 * 获得商圈里面的酒店列表
	 * @return ArrayList<AreaVO>
	 */
	public List<AreaVO> getAreaHotels();
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
	 * 获得系统内所有房间类型
	 * @return String[]
	 */
	public String[] getRoomType();
	
	/**
	 *添加房间类型
	 * @return boolean
	 */
	public boolean addRoomType(String type);
	/**
	 * 获得酒店所包含的所有房间列表
	 * @param hotelID
	 * @return
	 */
	ArrayList<RoominfoVO> getRoominfoList(String hotelID);
	/**
	 * 计算打折后的价格
	 * @param roomVO 
	 * @param hotelID 
	 * @return 最终价格
	 */
	public double calculatePrice(ArrayList<HotelStrategyVO> hotelStrategyList,
			ArrayList<MarketingStrategyVO> marketingStrategyList, ClientVO vo,String hotelID,RoominfoVO roomVO,int num);

	/**
	 * 根据酒店界面输入订单ID或客户ID搜索订单
	 * @param hotelID
	 * @param text
	 * @return
	 */
	public ArrayList<OrderVO> searchOrderFromHotelUI(String hotelID,String text);

}
