package presentation.marketing.view;


import java.util.Date;
import java.util.List;

import Enum.ResultMessage;
import Enum.VIPType;
import vo.clientVO.ClientVO;
import vo.districtVO.DistrictVO;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;
import vo.strategyVO.PrivilegeVO;

public interface ProcessMarketingViewControllerService {
    /**
     *
     * @return 网站营销人员的ID
     */
	public String getMarketingID();
    /**
     * 增加等级信息
     * @param vo
     * @return 是否增加成功
     */
	public ResultMessage addLevel(LevelVO vo);

	/**
	 * 返回所有等级信息
	 * @return 返回所有等级信息列表
	 */
    public List<LevelVO> findAllLevel();

    /**
     * 删除等级信息
     * @param vo
     * @return 是否删除等级信息成功
     */
    public ResultMessage deleteLevel(LevelVO vo);

    /**
     * 修改网站营销人员信息
     * @param vo
     * @return 返回是否修改网站营销人员信息成功
     */
    public ResultMessage MarketingAccountAdd (MarketingVO marketing);

	/**
	 * 修改网站营销人员账户
	 * @param marketingId
	 * @return 修改网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	public ResultMessage MarketingAccountUpdate (MarketingVO marketing);
	/**
	 * 删除网站营销人员账户
	 * @param marketingId
	 * @return 删除网站营销人员账户成功或失败的ResultMessage的enum值
	 */
	public ResultMessage MarketingAccountDelete (MarketingVO marketing);

	/**
	 * 管理界面得到网站营销人员账户信息
	 * @param findInfo
	 * @return 网站营销人员帐户
	 */
	public MarketingVO MarketingAccountFind (String marketingID);

    /**
     * 网站营销人员登录验证
     * @param marketingID
     * @param password
     * @return 返回是否网站营销人员登录验证成功
     */
    public boolean checkAccount(String marketingID,String password);

    /**
     * 返回网站营销人员个人信息
     * @param id
     * @return 返回网站营销人员个人信息
     */
    public MarketingVO init(String id);


	/**
	 * 增加网站营销人员所制定的策略
	 * @param vo
	 * @return 返回是否增加成功
	 */
    public ResultMessage  addMarketingStrategy(MarketingStrategyVO vo);

    /**
     * 返回营销人员所指定的促销策略
     * @param id
     * @return 返回策略信息列表
     */
    public List<MarketingStrategyVO> getMarketingStrategy(String id);

    /**
     * 删除网站营销人员制定的促销策略
     * @param vo
     * @return 返回是否删除成功
     */
    public ResultMessage deleteMarketingStrategy(MarketingStrategyVO vo);

    /**
     * 根据酒店ID返回该酒店的促销策略
     * @param hotelID
     * @return 返回该酒店的促销策略列表
     */
    public List<HotelStrategyVO> getHotelStrategy(String hotelID);

    /**
     * 更新酒店制定的促销策略
     * @param vo
     * @return 返回是否更新成功
     */
    public ResultMessage updateHotelStrategy(String hotelID,HotelStrategyVO vo);

    /**
     * 增加会员福利信息
     * @param vo
     * @return 返回是否增加成功
     */
    public  ResultMessage addPrivilege(PrivilegeVO vo);

    /**
     * 根据VIPType返回该类型VIP的福利优惠信息
     * @param VIPType
     * @return 返回福利信息列表
     */
    public List<PrivilegeVO> findAllPrivilege(VIPType type);

    /**
     * 删除会员福利信息
     * @param vo
     * @return 返回是否删除成功
     */
    public ResultMessage deletePrivilege(PrivilegeVO vo);

	/**
	 * 保存订单
	 * @param order
	 * @return 保存订单成功（Success）或是失败（fail）的ResultMessage值
	 */
	public ResultMessage saveOrder (OrderVO order);

	/**
	 * 查找具体某天的异常订单
	 * @param date
	 * @return 具体某天的所有订单列表
	 */
	public List<OrderVO> findAbnormalOrderList (Date date);

	/**
	 * 查找具体订单
	 * @param orderID
	 * @return 具体订单
	 */
	public OrderVO  findSpecificOrder(String orderID);

	/**
	 *通过客户ID得到客户个人信息
	 * @param clientID
	 * @return 客户的个人信息
	 */
	public ClientVO getclient (String clientID);

	/**
	 *设置（修改）某一客户信用值
	 * @param clientID
	 * @param recharge
	 * @return 修改信用值成功与否
	 */

	public boolean setCredit(String clientID,double recharge);
	/**
	 * 根据新的会员等级制度修改所有客户的会员等级
	 * @param vo
	 * @return 修改会员等级成功与否
	 */
	public boolean setAllClientLevel(LevelVO vo);

	public void setView(ProcessMarketingView view);

	public void profileButtonClicked();
	public void abnormalButtonClicked();
	public void addLog(String log);
	public void strategyButtonClicked();
	public List<DistrictVO> getDistricts();
	public List<String> getDistrictNames();

}
