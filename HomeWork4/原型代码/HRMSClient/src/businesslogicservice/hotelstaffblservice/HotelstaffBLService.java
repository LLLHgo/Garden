package businesslogicservice.hotelstaffblservice;

import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelstaffVO.HotelstaffBasicinfoVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.orderVO.HotelOrderVO;
import vo.strategyVO.HotelStrategyVO;

public interface HotelstaffBLService {
	/**
	 * 获得酒店工作人员信息
	 * @param hotelID
	 * @return 获得酒店工作人员信息
	 */
	public HotelstaffBasicinfoVO getBasicinfo(String hotelID);
	/**
	 * 将新密码持久化保存
	 * @param password
	 * @return 是否将新密码持久化保存
	 */
	public ResultMessage setPassword(String hotelID,String password);
	/**
	 * 将酒店促销策略持久化保存
	 * @param vo
	 * @return 是否将酒店促销策略持久化保存
	 */
	public ResultMessage updatehotelStrategy(String hotelID,HotelStrategyVO vo);
	/**
	 * 获得酒店促销策略信息
	 * @param hotelID
	 * @return 酒店促销策略信息
	 */
	public HotelStrategyVO gethotelStrategy(String hotelID);
	/**
	 * 删除酒店策略
	 * @param hotelID
	 * @param StrategyID
	 * @return 是否删除酒店策略
	 */
	public ResultMessage deletehotelStrategy(String hotelID , HotelStrategyVO hotelStrategy);
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
	public ResultMessage updateroominfo(HotelinfoVO vo);
	/**
	 * 获得酒店订单列表
	 * @param hotelID
	 * @return 酒店订单列表
	 */
	public List<HotelOrderVO> gethotelOrderList(String hotelID);
	/**
	 * 将订单状态持久化保存
	 * @param orderID
	 * @param state
	 * @return 是否将订单状态持久化保存
	 */
	public ResultMessage updateOrderState(String orderID,OrderType orderType);
	/**
	 * (网站管理人员请求)将酒店工作人员信息的修改持久化保存
	 * @param vo
	 * @return 是否将酒店工作人员信息的修改持久化保存
	 */
	public boolean saveSitemanagerUpdate(HotelstaffVO vo);
	/**
	 *  (网站管理人员)请求返回酒店工作人员信息
	 * @param hotelID
	 * @return 酒店工作人员信息
	 */
	public HotelstaffVO returnSitemanagerAccount(String hotelID);
	/**
	 * 登录时检测账号密码
	 * @param hotelID
	 * @param password
	 * @return 账号密码是否匹配
	 */
	public boolean checkAccount(String hotelID,String password);
}
