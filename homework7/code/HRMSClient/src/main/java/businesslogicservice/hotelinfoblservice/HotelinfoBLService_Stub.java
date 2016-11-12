package businesslogicservice.hotelinfoblservice;

import java.util.ArrayList;
import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import Enum.RoomState;
import Enum.Star;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.ClientRequirementVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class HotelinfoBLService_Stub implements HotelinfoBLService{

	HotelinfoVO hotelinfovo;
	RoominfoVO roominfovo;

	public HotelinfoBLService_Stub(){
		roominfovo = new RoominfoVO("四人间","413-3",666.6,RoomState.Usable);

		ArrayList<RoominfoVO> roominfoList = new ArrayList<RoominfoVO>();
		roominfoList.add(roominfovo);
		ArrayList<String> remark = new ArrayList<String>();
		remark.add("超级棒！");
		remark.add("一个很温馨的地方，么么哒~");
		String introduction = "一个可以让大家一起愉快地写大作业的地方哈哈哈哈";
		String hotelID = "H00000000";
		hotelinfovo = new HotelinfoVO("LLLH酒店","仙林大道163号","栖霞区商圈","025-12345678",
			roominfoList,Star.SEVEN,remark,introduction,hotelID);

	}

	/**
	 * 请求获得hotelID对应的酒店信息
	 * @param hotelID
	 * @return 酒店信息
	 */
	public HotelinfoVO getBasicinfo(String hotelID) {
		return hotelinfovo;
	}

	/**
	 * 获得符合客户条件的酒店列表信息
	 * @param vo
	 * @return 酒店信息列表
	 */
	public List<HotelinfoVO> getBasicinfoList(ClientRequirementVO vo) {
		ArrayList<HotelinfoVO> list = new ArrayList<HotelinfoVO>();
		list.add(hotelinfovo);
		return list;
	}

	/**
	 * 持久化保存酒店信息
	 * @param VO
	 * @return 保存成功或失败
	 */
	public ResultMessage updateBassicinfo(HotelinfoVO vo) {
		return ResultMessage.SUCCESS;
	}

	/**
	 * 获得某酒店某类型的房间信息
	 * @param hotelID
	 * @param roomtype
	 * @return 房间信息
	 */
	public RoominfoVO getRoominfo(String hotelID, String roomtype) {
		return roominfovo;
	}

	/**
	 * 获得酒店的房间信息列表
	 * @param hotelID
	 * @return 房间信息列表
	 */
	public List<RoominfoVO> getRoominfoList(String hotelID) {
		ArrayList<RoominfoVO> list = new ArrayList<RoominfoVO>();
		list.add(roominfovo);
		return list;
	}

	/**
	 * 计算打折后的价格
	 * @return 最终价格
	 */
	public double calculatePrice(List<HotelStrategyVO> hotelStrategylist,
			List<MarketingStrategyVO> marketingStrategyList, ClientVO vo, double originalPrice) {
		return 666;
	}

	/**
	 * 请求持久化保存网站管理人员添加的酒店信息
	 * @param vo
	 * @return 保存是否成功
	 */
	public boolean saveSitemanagerAdd(HotelinfoVO vo) {
		return true;
	}
	/**
	 * 将酒店促销策略持久化保存
	 * @param vo
	 * @return 是否将酒店促销策略持久化保存
	 */
	public ResultMessage updatehotelStrategy(String hotelID,HotelStrategyVO vo) {
		return ResultMessage.SUCCESS;
	}

	/**
	 * 获得酒店促销策略信息
	 * @param hotelID
	 * @return 酒店促销策略信息
	 */
	public HotelStrategyVO gethotelStrategy(String hotelID) {
		return new HotelStrategyVO();
	}

	/**
	 * 获得酒店基本信息
	 * @param vo
	 * @return 酒店信息
	 */
	public HotelinfoVO gethotelinfoVO(String hotelID) {
		return hotelinfovo;
	}

	/**
	 * 获得房间信息
	 * @param roomID
	 * @return 房间信息
	 */
	public RoominfoVO getroominfo(String hotelID,String roomID) {
		RoominfoVO roominfovo = new RoominfoVO("四人间","413-3",666.6,RoomState.Usable);
		return roominfovo;
	}
	/**
	 * 将房间信息持久化保存
	 * @param vo
	 * @return 是否将房间信息持久化保存
	 */
	public ResultMessage updateroominfo(HotelinfoVO vo) {
		return ResultMessage.SUCCESS;
	}

//	/**
//	 * 获得酒店订单列表
//	 * @param hotelID
//	 * @return 酒店订单列表
//	 */
//	public List<OrderVO> gethotelOrderList(String hotelID) {
//		//TODO
//		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
//		return list;
//	}

//	/**
//	 * 将订单状态持久化保存
//	 * @param orderID
//	 * @param state
//	 * @return 是否将订单状态持久化保存
//	 */
//	public ResultMessage updateOrderState(String orderID, OrderType orderType) {
//		return ResultMessage.SUCCESS;
//	}

	/**
	 * (网站管理人员请求)将酒店工作人员信息的修改持久化保存
	 * @param vo
	 * @return 是否将酒店工作人员信息的修改持久化保存
	 */
	public boolean saveSitemanagerUpdate(HotelstaffVO vo) {
		return true;
	}


//	/**
//	 * 删除酒店策略
//	 * @param hotelID
//	 * @param StrategyID
//	 * @return 是否删除酒店策略
//	 */
//	public ResultMessage deletehotelStrategy(String hotelID, HotelStrategyVO hotelStrategy) {
//		return ResultMessage.SUCCESS;
//	}
}
