package presentation.client.view;

import java.io.File;
import java.sql.Date;
import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import datatool.ClientDataTool;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.levelVO.LevelVO;
import vo.orderVO.OrderVO;

public interface ProcessClientViewControllerService {
	public boolean checkAccount (String clientID,String password);
	/**
	 *通过客户ID得到客户个人信息
	 * @param clientID
	 * @return 客户的个人信息
	 */
	public ClientVO getclient (String clientID);
	/**
	 *增加新客户
	 * @param vo
	 * @return 增加新用户成功与否
	 */
	public ResultMessage createClient(ClientVO vo);
	/**
	 *设置（修改）某一客户信用值
	 * @param clientID
	 * @param recharge
	 * @return 修改信用值成功与否
	 */
	/**
	 *删除客户
	 * @param vo
	 * @return 删除用户成功与否
	 */
	public ResultMessage saveSitemanagerDelete(String clientId);
	public boolean setCredit(String clientID,int recharge);
	/**
	 * 根据新的会员等级制度修改所有客户的会员等级
	 * @param vo
	 * @return 修改会员等级成功与否
	 */
	public boolean setAllClientLevel(LevelVO vo);
	/**
	 * 通过完整正确的酒店关键词得到相关酒店列表
	 * @param vo
	 * @return符合关键词的酒店列表
	 */
	public List<HotelinfoVO> getSearchHotel(String str);
	/**
	 *得到具体日期的客户订单
	 * @param clientID
	 * @param date
	 * @return 该日期的客户订单
	 */
	public List<OrderVO> getSearchDateOrder(String clientID,Date date);
	/**
	 *得到具体酒店的客户订单
	 * @param clientID
	 * @param hotelID
	 * @return 该酒店的客户订单
	 */
	public List<OrderVO> getSearchHotelOrder( String clientID,String hotelID);
	/**
	 *修改客户基本信息
	 * @param vo
	 * @return 修改个人信息成功与否提示信息
	 */
	public  ResultMessage updateInfo(ClientVO vo);
	/**
	 *创建订单
	 * @param orderID
	 * @return 创建成功与否
	 */
	public boolean Order(OrderVO vo);
	/**
	 *撤销订单
	 * @param orderID
	 * @return 撤销成功与否
	 */
	public boolean repealOrder(String orderID);
	/**
	 *得到客户的所有订单
	 * @param clientID
	 * @param order_type
	 * @return 所有订单列表
	 */
	public List<OrderVO> getAllOrderList(String clientID,OrderType order_type);
	/**
	 *得到客户某一类型的订单
	 * @param clientID
	 * @param order_type
	 * @return 类型订单列表
	 */
	public List<OrderVO> getOrderList(String clientID,OrderType order_type);
	/**
	 *得到客户的信用记录
	 * @param clientID
	 * @return 信用记录
	 */
	public File getCreditRecord(String clientID);
	/**
	 *得到客户的历史预订酒店列表
	 * @param clientID
	 * @return 历史预订酒店列表
	 */
	public List<HotelinfoVO> getHistoryList(String clientID);
}
