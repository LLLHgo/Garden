package businesslogicservice.hotelstaffblservice;

import Enum.ResultMessage;
import vo.hotelstaffVO.HotelstaffVO;

public interface HotelstaffBLService {
	/**
	 * 获得酒店工作人员信息
	 * @param hotelID
	 * @return 获得酒店工作人员信息,这里是密码
	 */
	public String getBasicinfo(String hotelID);
	/**
	 * 将新密码持久化保存
	 * @param password
	 * @return 是否将新密码持久化保存
	 */
	public ResultMessage setPassword(String hotelID,String password);
	/**（修改）
	 * (网站管理人员请求)将酒店工作人员信息的修改持久化保存
	 * @param vo
	 * @return 是否将酒店工作人员信息的修改持久化保存
	 */
	public ResultMessage saveSitemanagerUpdate(HotelstaffVO vo);

	/**(新增)
	 ** (网站管理人员请求)将酒店工作人员信息的新增的信息持久化保存
	 * @param vo
	 * @return 是否将酒店工作人员信息的新增的信息持久化保存
	 */
	public ResultMessage saveSitemanagerAdd(HotelstaffVO vo);
	/**
	 *  (网站管理人员)请求返回酒店工作人员信息
	 * @param hotelID
	 * @return 酒店工作人员信息
	 */
	public HotelstaffVO returnSitemanagerAccount(String hotelID);
	/**
	 * 
	 * @return
	 */
	public String getNewAddHotelID();
	/**
	 * 登录时检测账号密码
	 * @param hotelID
	 * @param password
	 * @return 账号密码是否匹配
	 */
	public boolean checkAccount(String hotelID,String password);
}
