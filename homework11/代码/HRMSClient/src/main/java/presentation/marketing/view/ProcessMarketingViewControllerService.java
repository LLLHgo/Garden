package presentation.marketing.view;


import java.util.List;

import Enum.ResultMessage;
import vo.areaVO.AreaVO;
import vo.clientVO.ClientVO;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.MarketingStrategyVO;

public interface ProcessMarketingViewControllerService {
    /**
     *
     * @return 网站营销人员的ID
     */
	public String getMarketingID();
    /**
     * 更新等级信息
     * @param vo
     * @return 是否增加成功
     */
	public ResultMessage updateLevel(List<LevelVO> vo);

	/**
	 * 返回所有等级信息
	 * @return 返回所有等级信息列表
	 */
    public List<LevelVO> findAllLevel();



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
    public ResultMessage deleteMarketingStrategy(String vo);


	/**
	 * 查找具体某天的异常订单
	 * @param date
	 * @return 具体某天的所有订单列表
	 */
	public List<OrderVO> findAbnormalOrderList (String date);

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

	public boolean setCredit(String clientID,double amount);


	/**
	 * 对异常订单的设置客户信用值，保存日志的操作
	 * @param order
	 * @param price
	 * @param log
	 * @return
	 */
	public ResultMessage operateOnAbnormalOrder(OrderVO order, double price, StringBuilder log);


	public List<AreaVO> getDistricts();
	public String[] getDistrictNames();



	public void setView(ProcessMarketingView view);
	public void profileButtonClicked();
	public void abnormalButtonClicked();
	public void strategyButtonClicked();
	public void creditButtonClicked();
	public void VIPButtonClicked();



}
