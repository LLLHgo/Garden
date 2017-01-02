package presentation.sitemanager.view;

import java.util.ArrayList;

import Enum.ResultMessage;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.SitemanagerAddVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.logVO.LogVO;
import vo.marketingVO.MarketingVO;
import vo.sitemanagerVO.SitemanagerVO;

public interface ProcessSitemanagerViewControllerService {
	
	public void setView(ProcessSitemanagerView view);
	
	public String getSitemanagerId();
	
	public SitemanagerVO init();
	/**
	 * 修改客户账户
	 * @param clientId
	 * @return 修改客户账户成功或失败的ResultMessage的enum值
	 */
	public ResultMessage clientAccountUpdate (ClientVO clientVO);
	
	/**
	 * 删除网站营销人员账户
	 * @param userId
	 * @return 删除账户成功或失败的ResultMessage的enum值
	 */
	public ResultMessage marketingAccountDelete (MarketingVO vo);
	/**
	 * 删除客户账户
	 * @param userId
	 * @return 删除账户成功或失败的ResultMessage的enum值
	 */
	public ResultMessage clientAccountDelete(String userId);
	
    /**
     * 管理界面得到客户账户信息
     * @param findInfo
     * @return 该客户账户
     */
	public ClientVO clientAccountFind (String findInfo);
	
	/**
	 * 添加网站营销人员
	 * @param marketing
	 * @return 添加网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	public ResultMessage MarketingAccountAdd (MarketingVO marketing);
	/**
	 * 修改网站营销人员账户
	 * @param marketingId
	 * @return 修改网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	public ResultMessage MarketingAccountUpdate (MarketingVO marketing);
	
	/**
	 * 管理界面得到网站营销人员账户信息
	 * @param findInfo
	 * @return 网站营销人员帐户
	 */
	public MarketingVO MarketingAccountFind (String findInfo);
	
	
	/**
	 * 添加酒店
	 * @param sitemanagerAddVO
	 * @param hotelstaffVO
	 * @return
	 */
	public ResultMessage HotelAccountAdd (SitemanagerAddVO sitemanagerAddVO,HotelstaffVO hotelstaffVO);
	
	/**
	 * 管理界面得到酒店工作人员账户信息
	 * @param findInfo
	 * @return 酒店工作人员账户
	 */
	public  HotelstaffVO HotelStaffAccountFind(String hotelId);
	
	/**
	 * 管理界面得到酒店信息
	 * @param hotelId
	 * @return 酒店信息账户
	 */
	public HotelinfoVO HotelinfoAccountFind(String hotelId);
	/**
	 * 修改酒店工作人员账户
	 * @param hotelId
	 * @return 修改网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	public ResultMessage HotelStaffAccountUpdate(HotelstaffVO hotelstaffVO);
	
	/**
	 * 管理界面得到网站管理人员账户信息
	 * @return SitemanagerVO
	 */
	public SitemanagerVO sitemanagerAcountShow();
	
	/**
	 * 修改网站管理人员账户
	 * @param accountVO
	 * @return
	 */
	public ResultMessage sitemanagerAccountUpdate(SitemanagerVO accountVO);
	
	/**
	 * 得到最新添加的网站营销人员帐号
	 * @return 帐号
	 */
	public String getMarketingID();
	/**
	 * 得到最新添加的酒店工作人员帐号
	 * @return 帐号
	 */
	public String getHotelID();
	
	/**
	 * 添加日志
	 * @param logInfo
	 * @return 添加日志成功或失败的ResultMessage值
	 */
	public ResultMessage addLog(String logInfo);
	
	/**
	 * 进入网站管理人员账户管理
	 */
	public void jbSitemanagerManageButtonClicked();
	/**
	 * 进入网站营销人员账户管理
	 */
	public void jbMarketingManageButtonClicked();
	/**
	 * 进入客户账户管理
	 */
	public void jbClientManageButtonClicked();
	/**
	 * 退出当前账号
	 */
	public void jbExitButtonClicked();
	/**
	 * 进入酒店账户管理
	 */
	public void jbHotelManageButtonClicked();
	/**
	 * 进入查看日志界面
	 */
	public void jbShowLogButtonClicked();
	/**
	 * 管理界面得到日志列表
	 * @return ArrayList<LogVO>
	 */
	ArrayList<LogVO> findLog(String year, String month, String day);
}
