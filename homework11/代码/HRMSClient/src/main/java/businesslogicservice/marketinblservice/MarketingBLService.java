package businesslogicservice.marketinblservice;

import java.util.List;
import Enum.ResultMessage;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;

public interface MarketingBLService {
    /**
     * 增加等级信息
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
	public ResultMessage MarketingAccountDelete (MarketingVO marketingVO);

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

}
