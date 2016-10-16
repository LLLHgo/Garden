package businesslogicservice.sitemanagerblservice;

import java.io.File;

import Enum.ResultMessage;
import businesslogicservice.sitemanagerblservice.SitemanagerBLService;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.marketingVO.MarketingVO;
import vo.sitemanager.SitemanagerVO;
import Enum.VIPType;

public class SitemanagerBLService_Stub implements SitemanagerBLService{
	MarketingVO marketingVO;
	public SitemanagerBLService_Stub(MarketingVO marketingVO){
		this.marketingVO=marketingVO;
	}
	/**
	 * 修改客户账户
	 * @param clientId
	 * @return 修改客户账户成功或失败的ResultMessage的enum值
	 */
	@Override
	public ResultMessage clientAccountUpdate(ClientVO clientVO) {
		// TODO Auto-generated method stub
		return ResultMessage.FAIL;
	}
	/**
	 * 删除客户账户
	 * @param clientId
	 * @return 删除客户成功或失败的ResultMessage的enum值
	 */
	@Override
	public ResultMessage accountDelete(String userId) {
		// TODO Auto-generated method stub
		return ResultMessage.FAIL;
	}
	/**
     * 管理界面得到客户账户信息
     * @param findInfo
     * @return 该客户账户
     */
	@Override
	public ClientVO clientAccountFind(String clientId) {
		// TODO Auto-generated method stub
		return new ClientVO("C00000009","000","Kerry","17999982876",VIPType.ENTERPRISEVIP,2,null,"SAP",new File("C00000009"));
	}
	/**
	 * 添加网站营销人员
	 * @param marketing
	 * @return 添加网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	@Override
	public ResultMessage MarketingAccountAdd(MarketingVO marketing) {
		// TODO Auto-generated method stub
		return ResultMessage.FAIL;
	}
	/**
	 * 修改网站营销人员账户
	 * @param marketingId
	 * @return 修改网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	@Override
	public ResultMessage MarketingAccountUpdate(MarketingVO marketing) {
		// TODO Auto-generated method stub
		return ResultMessage.FAIL;
	}
	/**
	 * 管理界面得到网站营销人员账户信息
	 * @param findInfo
	 * @return 网站营销人员帐户
	 */
	@Override
	public MarketingVO MarketingAccountFind(String findInfo) {
		// TODO Auto-generated method stub
		return new MarketingVO("Lily","m123456","M000000011","17719239008");
	}
	/**
	 * 添加酒店
	 * @param hotelinfo
	 * @return 添加网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	@Override
	public ResultMessage MarketingAccountAdd(HotelinfoVO hotelinfo) {
		// TODO Auto-generated method stub
		return ResultMessage.FAIL;
	}
	/**
	 * 管理界面得到酒店工作人员账户信息
	 * @param hotelId
	 * @return 酒店工作人员账户
	 */
	@Override
	public HotelstaffVO HotelStaffAccountFind(String hotelId) {
		// TODO Auto-generated method stub
		return new HotelstaffVO("H00000010","123456","025-12345678");
	}
	/**
	 * 修改酒店工作人员账户
	 * @param hotelId
	 * @return 修改网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	@Override
	public ResultMessage HotelStaffAccountUpdate(HotelstaffVO hotelstaffVO) {
		// TODO Auto-generated method stub
		return ResultMessage.FAIL;
	}

	/**
	 * 检查登录的网站管理人员账户密码是否正确
	 * @param account
	 * @return 登录帐号或密码正确（true）或错误（false）的布尔值
	 */
	@Override
	public ResultMessage checkAccount(SitemanagerVO account) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}
	
}
