package businesslogicservice.hotelinfoblservice;

import java.util.ArrayList;
import java.util.List;

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
/**
 * 
 * 因为hotelinfoBLService接口定义得比较大，而实现类分为Hotelinfo和Roominfo时并不都需要，所以使用了接口适配器模式
 * @version 1
 * @since 16.12.3
 * @author liuyu
 *
 */
public abstract class HotelinfoAbstract implements HotelinfoBLService{
	/**
	 * 请求获得hotelID对应的酒店信息
	 * @param hotelID
	 * @return 酒店信息
	 */
	public HotelinfoVO getBasicinfo(String hotelID){
		return null;
	}
	/**
	 * 获得符合客户条件的酒店列表信息
	 * @param vo
	 * @return 酒店信息列表
	 */
	public ArrayList<HotelinfoVO> getBasicinfoList(String area){
		return null;
	};
	/**
	 * 持久化保存酒店信息
	 * @param VO
	 * @return 保存成功或失败
	 */
	public ResultMessage updateBassicinfo(HotelinfoVO VO){
		return null;
	}
	/**
	 * 获得系统内所有商圈名
	 * @return String[]
	 */
	public String[] getArea(){
		return null;
	}
	
	/**
	 *添加商圈名 
	 * @return boolean
	 */
	public boolean addArea(String area){
		return false;
	}
	/**
	 * 请求持久化保存网站管理人员添加的酒店信息
	 * @param sitemanagerAddVO
	 * @param hotelstaffVO
	 * @return 保存成功或失败
	 */
	public ResultMessage saveSitemanagerAdd(SitemanagerAddVO sitemanagerAddVO, HotelstaffVO hotelstaffVO){
		return null;
	}
	
	/**
	 * 获得商圈里面的酒店列表
	 * @return ArrayList<AreaVO>
	 */
	public List<AreaVO> getAreaHotels(){
		return null;
	}
	/**
	 * 获得房间信息
	 * @param roomID
	 * @return 房间信息
	 */
	public RoominfoVO getroominfo(String hotelID,String roomID){
		return null;
	}
	/**
	 * 将房间信息持久化保存
	 * @param vo
	 * @return 是否将房间信息持久化保存
	 */
	public boolean updateroominfo(RoominfoVO vo,String hotelID){
		return false;
	}
	
	/**
	 * 获得系统内所有房间类型
	 * @return String[]
	 */
	public String[] getRoomType(){
		return null;
	}
	
	/**
	 *添加房间类型
	 * @return boolean
	 */
	public boolean addRoomType(String type){
		return false;
	}
	/**
	 * 获得酒店所包含的所有房间列表
	 * @param hotelID
	 * @return
	 */
	public ArrayList<RoominfoVO> getRoominfoList(String hotelID){
		return null;
	}
	/**
	 * 计算打折后的价格
	 * @return 最终价格
	 */
	public double calculatePrice(ArrayList<HotelStrategyVO> hotelStrategyList,
			ArrayList<MarketingStrategyVO> marketingStrategyList, ClientVO vo,String hotelID,RoominfoVO roomVO,int num){
		return 0;
	}
	/**
	 * 根据酒店界面输入订单ID或客户ID搜索订单
	 * @param hotelID
	 * @param text
	 * @return
	 */
	public ArrayList<OrderVO> searchOrderFromHotelUI(String hotelID,String text) {
		return null;
	}
}
