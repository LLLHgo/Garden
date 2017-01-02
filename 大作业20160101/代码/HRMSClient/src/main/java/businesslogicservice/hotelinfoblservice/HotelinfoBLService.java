package businesslogicservice.hotelinfoblservice;

import java.util.ArrayList;
import java.util.List;

import Enum.ResultMessage;
import vo.areaVO.AreaVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelinfoVO.SitemanagerAddVO;
import vo.hotelstaffVO.HotelstaffVO;

public interface HotelinfoBLService {
	/**
	 * 客户获取酒店信息，其中包括房间信息
	 * 实际上。。。并没有用到
	 * @param hotelID
	 * @return
	 */
	//public HotelinfoVO clientgetBasicinfo(String hotelID);
	/**
	 * 客户评价酒店
	 * @param star
	 * @param remark
	 * @param hotelID
	 * @return
	 */
	public boolean setEvaluate(int star,String remark,String clientID,String hotelID);
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
	//public ArrayList<HotelinfoVO> getBasicinfoList(String area);
	public ArrayList<HotelinfoVO> getBasicinfoList(String area,String hotelname,int hotelstar,String roomType);
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
	 * 获得当前酒店的可用房间类型和数量，中间已逗号作为分隔符，例“标准间，3”
	 * @param hotelID
	 * @return ArrayList<String>
	 */
	public  ArrayList<String> getAvailableRooms(String hotelID);
	/**
	 * 新增房间
	 * @param vo
	 * @return 布尔值表示是否新增房间成功
	 */
	boolean addroominfo(RoominfoVO vo);
	/**
	 * 删除房间信息
	 * @param hotelID
	 * @param roomID
	 * @return 布尔值
	 */
	boolean deleteroom(String hotelID,String roomID);
	
	/**
	 * 根据酒店星级排序
	 * @param list
	* @return
	*/
	public ArrayList<HotelinfoVO> rankHotelAccordingtoHotelStar(ArrayList<HotelinfoVO> list);
	
	/**
	 * 根据酒店星级排序
	 * @param list
	* @return
	*/
	public ArrayList<HotelinfoVO> rankHotelAccordingtoRemarkStar(ArrayList<HotelinfoVO> list);
	
	/**
	 * 根据酒店星级排序
	 * @param list
	* @return
	*/
	public ArrayList<HotelinfoVO> rankHotelAccordingtoMinPrice(ArrayList<HotelinfoVO> list);
	
}
