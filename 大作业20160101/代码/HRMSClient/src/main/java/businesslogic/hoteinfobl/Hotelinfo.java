package businesslogic.hoteinfobl;

import java.util.ArrayList;
import java.util.List;

import Enum.ResultMessage;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService;
import vo.areaVO.AreaVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelinfoVO.SitemanagerAddVO;
import vo.hotelstaffVO.HotelstaffVO;
/**
 *
 * 因为hotelinfoBLService接口定义得比较大，而实现类分为Hotelinfo和Roominfo时并不都需要，所以使用了接口适配器模式
 * @version 1
 * @author liuyu
 *
 */
public class Hotelinfo implements HotelinfoBLService{

	HotelinfoManage hotel = new HotelinfoManage();
	RoominfoManage room = new RoominfoManage();

	/**
	 * 请求获得hotelID对应的酒店信息
	 * @param hotelID
	 * @return 酒店信息
	 */
	public HotelinfoVO getBasicinfo(String hotelID){
		return hotel.getBasicinfo(hotelID);
	}
	/**
	 * 获得符合客户条件的酒店列表信息
	 * @param vo
	 * @return 酒店信息列表
	 */
	public ArrayList<HotelinfoVO> getBasicinfoList(String area,String hotelname,int hotelstar,String roomType){
		return hotel.getBasicinfoList(area,hotelname,hotelstar,roomType);
	};
	/**
	 * 持久化保存酒店信息
	 * @param VO
	 * @return 保存成功或失败
	 */
	public ResultMessage updateBassicinfo(HotelinfoVO VO){
		return hotel.updateBassicinfo(VO);
	}
	/**
	 * 获得系统内所有商圈名
	 * @return String[]
	 */
	public String[] getArea(){
		return hotel.getArea();
	}

	/**
	 *添加商圈名
	 * @return boolean
	 */
	public boolean addArea(String area){
		return hotel.addArea(area);
	}
	/**
	 * 请求持久化保存网站管理人员添加的酒店信息
	 * @param sitemanagerAddVO
	 * @param hotelstaffVO
	 * @return 保存成功或失败
	 */
	public ResultMessage saveSitemanagerAdd(SitemanagerAddVO sitemanagerAddVO, HotelstaffVO hotelstaffVO){
		return hotel.saveSitemanagerAdd(sitemanagerAddVO, hotelstaffVO);
	}

	/**
	 * 获得商圈里面的酒店列表
	 * @return ArrayList<AreaVO>
	 */
	public List<AreaVO> getAreaHotels(){
		return hotel.getAreaHotels();
	}
	/**
	 * 获得房间信息
	 * @param roomID
	 * @return 房间信息
	 */
	public RoominfoVO getroominfo(String hotelID,String roomID){
		return room.getroominfo(hotelID, roomID);
	}
	/**
	 * 将房间信息持久化保存
	 * @param vo
	 * @return 是否将房间信息持久化保存
	 */
	public boolean updateroominfo(RoominfoVO vo,String hotelID){
		return room.updateroominfo(vo, hotelID);
	}

	/**
	 * 获得系统内所有房间类型
	 * @return String[]
	 */
	public String[] getRoomType(){
		return room.getRoomType();
	}

	/**
	 *添加房间类型
	 * @return boolean
	 */
	public boolean addRoomType(String type){
		return room.addRoomType(type);
	}
	/**
	 * 获得酒店所包含的所有房间列表
	 * @param hotelID
	 * @return
	 */
	public ArrayList<RoominfoVO> getRoominfoList(String hotelID){
		return room.getRoominfoList(hotelID);
	}

	/**
	 * 根据酒店ID获得可用的房间类型和数量
	 * @param hotelID
	 * @return ArrayList<String>
	 */
	public  ArrayList<String> getAvailableRooms(String hotelID){
		return room.getAvailableRooms(hotelID);
	}
	@Override
	public boolean setEvaluate(int star, String remark, String clientID,String hotelID) {
		return hotel.SetEvaluate(star, remark, clientID,hotelID);
	}
	//@Override
	//public HotelinfoVO clientgetBasicinfo(String hotelID) {
	//	return hotel.clientgetBasicinfo(hotelID);
	//}
	@Override
	public boolean addroominfo(RoominfoVO vo) {
		return room.addroominfo(vo);
	}
	@Override
	public boolean deleteroom(String hotelID, String roomID) {
		return room.deleteroom(hotelID,roomID);
	}
	@Override
	public ArrayList<HotelinfoVO> rankHotelAccordingtoHotelStar(ArrayList<HotelinfoVO> list) {
		return hotel.rankHotelAccordingtoHotelStar(list);
	}
	@Override
	public ArrayList<HotelinfoVO> rankHotelAccordingtoRemarkStar(ArrayList<HotelinfoVO> list) {
		return hotel.rankHotelAccordingtoRemarkStar(list);
	}
	@Override
	public ArrayList<HotelinfoVO> rankHotelAccordingtoMinPrice(ArrayList<HotelinfoVO> list) {
		return hotel.rankHotelAccordingtoMinPrice(list);
	}

}
