package businesslogicservice.marketinblservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Enum.ResultMessage;
import Enum.VIPType;
import Enum.marketingStrategy;
import javafx.scene.image.Image;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.MarketingStrategyVO;
import vo.strategyVO.PrivilegeVO;

public class MarketingBLService_Stub implements MarketingBLService {
	//折扣
	double discount;
	//酒店信息列表
    ArrayList<HotelinfoVO> hotels;

    public MarketingBLService_Stub(double discount){
       this.discount=discount;
	}

    /**
     * 增加网站营销人员制定的促销信息
     * @param vo
     * @return 是否增加网站营销人员制定的促销信息成功
     */
	public ResultMessage addMarketingStrategy(MarketingStrategyVO vo) {
		if(vo.getType()==marketingStrategy.DOUBLE11)
		    return ResultMessage.FAIL;
		else
			return ResultMessage.SUCCESS;
	}


	/**
	 * 返回网站营销人员制定的促销信息列表
	 * @param id
	 * @return 是否返回网站营销人员制定的促销信息列表成功
	 */
	public List<MarketingStrategyVO> getMarketingStrategy(String id) {
        marketingStrategy type=marketingStrategy.CRATEDE;
        Date startTime=new Date();
        Date endTime=new Date();
        HotelinfoVO hotel=new HotelinfoVO();
        hotels.add(hotel);
        Image image=new Image(id);
        String position="North";
        MarketingStrategyVO vo=new MarketingStrategyVO(type,startTime,endTime,discount,hotels,image,position);
        List<MarketingStrategyVO> msVO=new ArrayList<MarketingStrategyVO>();
        msVO.add(vo);
		return msVO;
	}

	/**
	 * 删除网站营销人员策略
	 * @param vo
	 * @return 是否删除成功
	 */
	public ResultMessage deleteMarketingStrategy(MarketingStrategyVO vo) {
		if(vo.getDiscount()>=0.9)
			return ResultMessage.FAIL;
		else
			return ResultMessage.SUCCESS;
	}

    /**
     * 界面返回特定订单信息
     * @param id
     * @return 返回特定订单信息
     */
	public OrderVO findSpecificAbnormalOrder(String id) {
		OrderVO vo=new OrderVO();
		return vo;
	}

    /**
     * 处理异常订单状态
     * @param vo
     * @return 返回是否处理异常订单状态
     */
	public ResultMessage handleAbnormal(OrderVO vo) {
		if(vo.getPrice()>=200)
			return ResultMessage.FAIL;
		else
			return ResultMessage.SUCCESS;
	}

    /**
     * 界面返回客户信息
     * @param clientID
     * @return 返回客户信息
     */
	public ClientVO getClient(String clientID) {
        ClientVO vo=new ClientVO();
        return vo;
	}

    /**
     * 设置客户信用值
     * @param clientID
     * @param recharge
     * @return 返回是否设置客户信用值成功
     */
	public ResultMessage setCredit(String clientID, int recharge) {
		if(recharge>0)
			return ResultMessage.FAIL;
		else
			return ResultMessage.SUCCESS;
	}

    /**
     * 增加等级信息
     * @param vo
     * @return 是否增加等级信息
     */
	public ResultMessage addLevel(LevelVO vo) {
	    if(vo.getCreditNeeded()>2000)
	    	return ResultMessage.FAIL;
	    else
	    	return ResultMessage.SUCCESS;
	}

	/**
	 * 返回所有等级信息
	 * @return 返回所有等级信息列表
	 */
	public List<LevelVO> findAllLevel() {
		List<LevelVO> levels=new ArrayList<LevelVO>();
		LevelVO vo=new LevelVO(1,"铜牌",2000);
		levels.add(vo);
		return levels;
	}

    /**
     * 删除等级信息
     * @param vo
     * @return 是否删除等级信息成功
     */
	public ResultMessage deleteLevel(LevelVO vo) {
		if(vo.getLevel()>0)
			return ResultMessage.FAIL;
	    else
	    	return ResultMessage.SUCCESS;
	}

    /**
     * 增加会员福利
     * @param vo
     * @return 是否增加会员福利成功
     */
	public ResultMessage addPrivilege(PrivilegeVO vo) {
		if(vo.getDiscount()>0.8)
			return ResultMessage.FAIL;
	    else
	    	return ResultMessage.SUCCESS;
	}

    /**
     * 删除会员福利信息
     * @param vo
     * @return 是否删除会员福利信息成功
     */
	public ResultMessage deletePrivilege(PrivilegeVO vo) {
		if(vo.getDiscount()>0.8)
			return ResultMessage.FAIL;
	    else
	    	return ResultMessage.SUCCESS;
	}

    /**
     * 修改网站营销人员信息
     * @param vo
     * @return 返回是否修改网站营销人员信息成功
     */
	public ResultMessage update(MarketingVO vo) {
		if(vo.getMarketingID()=="M0001")
			return ResultMessage.FAIL;
	    else
	    	return ResultMessage.SUCCESS;
	}

    /**
     * 网站管理人员修改营销人员信息
     * @param vo
     * @return 返回是否网站管理人员修改营销人员信息成功
     */
	public ResultMessage siteManagerUpdate(MarketingVO vo) {
		if(vo.getMarketingID()=="M0001")
			return ResultMessage.FAIL;
	    else
	    	return ResultMessage.SUCCESS;
	}

    /**
     * 网站管理人员增加营销人员信息
     * @param vo
     * @return 返回是否网站管理人员增加营销人员信息成功
     */
	public boolean saveSitemanagerAdd(MarketingVO vo) {
		if(vo.getMarketingID()=="M0001")
			return true;
	    else
	    	return false;
	}

    /**
     * 网站管理人员删除营销人员信息
     * @param vo
     * @return 返回是否网站管理人员删除营销人员信息成功
     */
	public boolean saveSitemanagerDelete(MarketingVO vo) {
		if(vo.getMarketingID()=="M0001")
			return true;
	    else
	    	return false;
	}

    /**
     * 网站营销人员登录验证
     * @param marketingID
     * @param password
     * @return 返回是否网站营销人员登录验证成功
     */
	public boolean checkAccount(String marketingID, String password) {
		if(marketingID==password)
			return true;
	    else
	    	return false;
	}

    /**
     * 返回网站营销人员个人信息
     * @param id
     * @return 返回网站营销人员个人信息
     */
	public MarketingVO init(String id) {
		MarketingVO vo=new MarketingVO("营销人员一号","1029384756","M0002","13380009000");
		return vo;
	}

    /**
     * 界面显示当日未执行订单列表
     * @param date
     * @return 返回显示当日未执行订单列表
     */
	public List<OrderVO> showAbnormal(Date date) {
		List<OrderVO> orders=new ArrayList<OrderVO>();
		OrderVO order=new OrderVO();
		orders.add(order);
		return orders;
	}

    /**
     * 返回所有会员福利信息
     * @param vipType
     * @return 返回所有会员福利信息列表
     */
	public List<PrivilegeVO> findAllPrivilege(VIPType vipType) {
		List<PrivilegeVO> privileges=new ArrayList<PrivilegeVO>();
		privileges.add(new PrivilegeVO());
		return privileges;
	}

    /**
     * 根据marketingID返回给网站管理人员网站营销人员的信息
     * @param marketingID
     * @return
     */
	public MarketingVO returnSitemanagerAccount(String marketingID) {
		MarketingVO vo=new MarketingVO("网站营销人员","password","M0001001","15077685563");
		return vo;
	}
}