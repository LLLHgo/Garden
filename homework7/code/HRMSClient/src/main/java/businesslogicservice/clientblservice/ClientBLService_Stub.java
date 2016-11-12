package businesslogicservice.clientblservice;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import Enum.VIPType;
import vo.hotelinfoVO.HotelinfoVO;
import vo.levelVO.LevelVO;
import vo.hotelinfoVO.ClientRequirementVO;
import vo.clientVO.ClientVO;
import vo.orderVO.OrderVO;

public class ClientBLService_Stub implements ClientBLService {
	//用户编号
	 String client_id;
//用户密码
	 String password;
//用户姓名
	 String client_name;
//用户手机号
	 String client_tel;
//用户会员类型
	 VIPType vip_type;
//用户会员等级
	 int vip_level;
//用户生日
	 Date client_birth;
//用户所属企业
	 String client_firm;
//用户信用记录
	File creditRecord;
	public ClientBLService_Stub(String client_id,String password,String client_name,String client_tel,
			VIPType vip_type,int vip_level,Date client_birth,String client_firm,File creditRecord){
		this.client_id=client_id;
		this.password=password;
		this.client_name=client_name;
		this.client_tel=client_tel;
		this.vip_type=vip_type;
		this.client_birth=client_birth;
		this.vip_level=vip_level;
		this.client_firm=client_firm;
		this.creditRecord=creditRecord;
	}
	/**
	 *通过客户ID得到客户个人信息
	 * @param clientID
	 * @return 客户的个人信息
	 */
	public ClientVO getclient (String clientID){
		return new ClientVO();
	}

	/**
	 *增加新客户
	 * @param vo
	 * @return 增加新用户成功与否
	 */
	public ResultMessage createClient(ClientVO vo){
		if(vo.getID() != null)
			return ResultMessage.SUCCESS;
		else
			return ResultMessage.FAIL;
	}
	/**
	 *删除客户
	 * @param vo
	 * @return 删除用户成功与否
	 */
	public ResultMessage saveSitemanagerDelete(String clientId){
		if(clientId!= null)
			return ResultMessage.SUCCESS;
		else
			return ResultMessage.FAIL;
	}
	/**
	 *设置（修改）某一客户信用值
	 * @param clientID
	 * @param recharge
	 * @return 修改信用值成功与否
	 */
	public boolean setCredit(String clientID,int recharge){
		if(recharge==0)
			return false;
		else
			return true;
	}
	/**
	 * 根据新的会员等级制度修改所有客户的会员等级
	 * @param vo
	 * @return 修改会员等级成功与否
	 */
	public boolean setAllClientLevel(LevelVO vo){
		if(vo!=null)
			return true;
		else
			return false;
	}
	/**
	 * 通过完整正确的酒店关键词得到相关酒店列表
	 * @param vo
	 * @return符合关键词的酒店列表
	 */
	public List<HotelinfoVO> getSearchHotel(ClientRequirementVO vo){
		List<HotelinfoVO> hotel=new ArrayList<HotelinfoVO>();
		return hotel;
	}
	/**
	 *得到具体日期的客户订单
	 * @param clientID
	 * @param date
	 * @return 该日期的客户订单
	 */
	public List<OrderVO> getSearchDateOrder(String clientID,Date date){
		List<OrderVO> order=new ArrayList<OrderVO>();
		return order;
	}
	/**
	 *得到具体酒店的客户订单
	 * @param clientID
	 * @param hotelID
	 * @return 该酒店的客户订单
	 */
	public List<OrderVO> getSearchHotelOrder( String clientID,String hotelID){
		List<OrderVO> order=new ArrayList<OrderVO>();
		return order;
	}
	/**
	 *修改客户基本信息
	 * @param vo
	 * @return 修改个人信息成功与否提示信息
	 */
	public  ResultMessage updateInfo(ClientVO vo){
		if(vo!=null)
			return ResultMessage.SUCCESS;
		else
			return ResultMessage.FAIL;
	}
	/**
	 *创建订单
	 * @param orderID
	 * @return 创建成功与否
	 */
	public boolean createOrder(OrderVO vo){
		if(vo!=null)
			return true;
		else
			return false;
	}
	/**
	 *撤销订单
	 * @param orderID
	 * @return 撤销成功与否
	 */
	public boolean repealOrder(String orderID){
		if(orderID!=null)
			return true;
		else
			return false;
	}
	/**
	 *得到客户的所有订单
	 * @param clientID
	 * @param order_type
	 * @return 所有订单列表
	 */
	public List<OrderVO> getAllOrderList(String clientID,OrderType order_type){
		List<OrderVO> order=new ArrayList<OrderVO>();
		return order;
	}
	/**
	 *得到客户某一类型的订单
	 * @param clientID
	 * @param order_type
	 * @return 类型订单列表
	 */
	public List<OrderVO> getOrderList(String clientID,OrderType order_type){
		List<OrderVO> order=new ArrayList<OrderVO>();
		return order;
	}
	/**
	 *得到客户的信用记录
	 * @param clientID
	 * @return 信用记录
	 */
	public File getCreditRecord(String clientID){
		if(clientID!=null)
			return new File(clientID);
		else
			return null;
	}
	/**
	 *得到客户的历史预订酒店列表
	 * @param clientID
	 * @return 历史预订酒店列表
	 */
	public List<HotelinfoVO> getHistoryList(String clientID){
		List<HotelinfoVO> hotel=new ArrayList<HotelinfoVO>();
		return hotel;
	}
	@Override
	public boolean Order(OrderVO vo) {
		// TODO Auto-generated method stub
		return false;
	}


}
