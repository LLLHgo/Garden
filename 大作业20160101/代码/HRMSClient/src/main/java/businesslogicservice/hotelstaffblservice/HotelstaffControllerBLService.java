package businesslogicservice.hotelstaffblservice;

import java.util.ArrayList;

import Enum.OrderType;
import Enum.ResultMessage;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;

public interface HotelstaffControllerBLService {

	/**
	 * 请求获得hotelID对应的酒店信息
	 * @param hotelID
	 * @return 酒店信息
	 */
	public HotelinfoVO getHotelBasicinfo(String hotelID);
	/**
	 * 获得符合客户条件的酒店列表信息
	 * @param vo
	 * @return 酒店信息列表
	 */
	public ArrayList<HotelinfoVO> getHotelBasicinfoList(String area,String hotelname,int hotelstar,String roomType);
	
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
	public ArrayList<RoominfoVO> getRoominfoList(String hotelID);
	/**
	 * 将酒店促销策略持久化保存
	 * @param vo
	 * @return 是否将酒店促销策略持久化保存
	 */
	public ResultMessage updatehotelStrategy(HotelStrategyVO vo);
	/**
	 * 获得酒店促销策略信息
	 * @param hotelID
	 * @return 酒店促销策略信息
	 */
	public ArrayList<HotelStrategyVO> gethotelStrategy(String hotelID);

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
	public ResultMessage updateroominfo(RoominfoVO vo,String hotelID);
	/**
	 * 获得酒店所有订单列表
	 * @param hotelID,OrderType
	 * @return 酒店订单列表
	 */
	public ArrayList<OrderVO> getALLHotelOrderList(String hotelID,OrderType ALL);

	/**
	 * 获得酒店已入住订单列表
	 * @param hotelID,OrderType
	 * @return 酒店订单列表
	 */
	public ArrayList<OrderVO> getUnexecutedHotelOrderList(String hotelID,OrderType NORMALEXEC);

	/**
	 * 获得酒店未入住订单列表
	 * @param hotelID,OrderType
	 * @return 酒店订单列表
	 */
	public ArrayList<OrderVO> getExecutedHotelOrderList(String hotelID,OrderType NORMALNONEXEC);

	/**
	 * 获得酒店取消订单列表
	 * @param hotelID,OrderType
	 * @return 酒店订单列表
	 */
	public ArrayList<OrderVO> getCancleHotelOrderList(String hotelID,OrderType ABNORMALCANCEL);

	/**
	 * 获得酒店异常订单列表
	 * @param hotelID,OrderType
	 * @return 酒店订单列表
	 */
	public ArrayList<OrderVO> getAbnormalHotelOrderList(String hotelID,OrderType ABNORMALCANCEL);
	/**
	 * 获得某客户的酒店订单列表
	 * @param hotelID,clientID
	 * @return 酒店订单列表
	 */
	public ArrayList<OrderVO> getExecutedHotelOrderList(String hotelID,String clientID);
	/**
	 * 将订单状态持久化保存
	 * @param OrderVO
	 * @param state
	 * @return 是否将订单状态持久化保存
	 */
	public ResultMessage updateOrderState(OrderVO vo);

	/**
	 * 获得酒店工作人员信息
	 * @param hotelID
	 * @return 获得酒店工作人员信息
	 */
	public String getHotelstaffBasicinfo(String hotelID);
	/**
	 * 将新密码持久化保存
	 * @param password
	 * @return 是否将新密码持久化保存
	 */
	public ResultMessage setPassword(String hotelID,String password);

	/**
	 * 登录时检测账号密码
	 * @param hotelID
	 * @param password
	 * @return 账号密码是否匹配
	 */
	public boolean checkAccount(String hotelID,String password);


	/**
	 * 新增商圈
	 * @param area
	 * @return ResultMessage
	 */
	public ResultMessage addArea(String area);

	/**
	 * 获得所有商圈名
	 * @return String[]
	 */
	public String[] getArea();

	/**
	 * 增加房间类型
	 * @param type
	 * @return ResultMessage
	 */
	public ResultMessage addRoomType(String type);

	/**
	 * 获得所有房间类型
	 * @return String[]
	 */
	public String[] getRoomType();
	/**
	 * 根据酒店界面搜索框输入的ID查找订单列表
	 * @param hotelID
	 * @param text
	 * @return ArrayList<OrderVO>
	 */
	public ArrayList<OrderVO> searchOrderFromHotelUI(String hotelID,String text);
	/**
	 * 添加日志
	 * @param s
	 * @return boolean
	 */
	public boolean addLog(String s);
	/**
	 * 新增房间信息
	 * @param vo
	 * @return 布尔值
	 */
	public boolean addroominfo(RoominfoVO vo);

	/**
	 * 删除房间信息
	 * @param hotelID
	 * @param roomID
	 * @return 布尔值
	 */
	public boolean deleteroom(String hotelID,String roomID);
	/**
	 * 将异常订单执行后自动恢复信用值
	 * @param clientID
	 * @param recharge
	 * @param date
	 * @param reason
	 * @return布尔值
	 */
	public boolean reviewCrediet(String clientID,int recharge,String date,String reason);
	/**
	 * 刷新酒店房间状态
	 * @return
	 */
	public boolean refreshroomstate();
	
}
