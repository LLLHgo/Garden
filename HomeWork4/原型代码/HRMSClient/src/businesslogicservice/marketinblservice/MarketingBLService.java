package businesslogicservice.marketinblservice;

import java.util.Date;
import java.util.List;
import Enum.ResultMessage;
import Enum.VIPType;
import vo.clientVO.ClientVO;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.MarketingStrategyVO;
import vo.strategyVO.PrivilegeVO;

public interface MarketingBLService {
    /**
     * 增加网站营销人员制定的促销信息
     * @param vo
     * @return 是否增加网站营销人员制定的促销信息成功
     */
	public ResultMessage addMarketingStrategy(MarketingStrategyVO  vo);

	/**
	 * 返回网站营销人员制定的促销信息列表
	 * @param id
	 * @return 是否返回网站营销人员制定的促销信息列表成功
	 */

	public List<MarketingStrategyVO> getMarketingStrategy(String id);

	/**
	 * 删除网站营销人员策略
	 * @param vo
	 * @return 是否删除成功
	 */
    public ResultMessage deleteMarketingStrategy(MarketingStrategyVO vo);

    /**
     * 增加等级信息
     * @param vo
     * @return 是否增加等级信息
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
     * 增加会员福利
     * @param vo
     * @return 是否增加会员福利成功
     */
    public ResultMessage addPrivilege(PrivilegeVO vo);

    /**
     * 返回所有会员福利信息
     * @param vipType
     * @return 返回所有会员福利信息列表
     */
    public List<PrivilegeVO> findAllPrivilege(VIPType vipType);

    /**
     * 删除会员福利信息
     * @param vo
     * @return 是否删除会员福利信息成功
     */
    public ResultMessage deletePrivilege(PrivilegeVO vo);

    /**
     * 界面显示当日未执行订单列表
     * @param date
     * @return 返回显示当日未执行订单列表
     */
    public List<OrderVO> showAbnormal(Date date);

    /**
     * 界面返回特定订单信息
     * @param id
     * @return 返回特定订单信息
     */
    public OrderVO findSpecificAbnormalOrder(String id);

    /**
     * 处理异常订单状态
     * @param vo
     * @return 返回是否处理异常订单状态
     */
    public ResultMessage handleAbnormal(OrderVO vo);

    /**
     * 界面返回客户信息
     * @param clientID
     * @return 返回客户信息
     */
    public ClientVO getClient(String clientID);

    /**
     * 设置客户信用值
     * @param clientID
     * @param recharge
     * @return 返回是否设置客户信用值成功
     */
    public ResultMessage setCredit(String clientID,int recharge);

    /**
     * 修改网站营销人员信息
     * @param vo
     * @return 返回是否修改网站营销人员信息成功
     */
    public ResultMessage update(MarketingVO vo);

    /**
     * 网站管理人员修改营销人员信息
     * @param vo
     * @return 返回是否网站管理人员修改营销人员信息成功
     */
    public ResultMessage siteManagerUpdate(MarketingVO vo);

    /**
     * 网站管理人员增加营销人员信息
     * @param vo
     * @return 返回是否网站管理人员增加营销人员信息成功
     */
    public boolean saveSitemanagerAdd(MarketingVO vo);

    /**
     * 网站管理人员删除营销人员信息
     * @param vo
     * @return 返回是否网站管理人员删除营销人员信息成功
     */
    public boolean saveSitemanagerDelete(MarketingVO vo);

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
     * 根据marketingID返回给网站管理人员网站营销人员的信息
     * @param marketingID
     * @return
     */
    public MarketingVO returnSitemanagerAccount(String marketingID);
}
