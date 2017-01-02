package Mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Enum.ResultMessage;
import businesslogic.marketingbl.MarketingManage;
import datatool.MarketingDataTool;
import vo.clientVO.ClientVO;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;

public class MockMarketingManage extends MarketingManage{
	//网站营销人员制定的会员等级1
	private LevelVO lv1;
	//网站营销人员制定的会员等级2
	private LevelVO lv2;
	//订单1
	private OrderVO ov1;
	//订单2
	private OrderVO ov2;
	//客户
	private ClientVO cv;
	//网站营销人员VO
	private MarketingVO mv;

	MarketingDataTool marketingdatatool=new MarketingDataTool();
	public MockMarketingManage(){
    }

    public MockMarketingManage(LevelVO vo){
        this.lv1=vo;
    }

    public MockMarketingManage(LevelVO v1,LevelVO v2){
        this.lv1=v1;
        this.lv2=v2;
    }

    public MockMarketingManage(OrderVO vo){
        this.ov1=vo;
    }

    public MockMarketingManage(OrderVO v1,OrderVO v2){
        this.ov1=v1;
        this.ov2=v2;
    }

    public MockMarketingManage(ClientVO vo){
        this.cv=vo;
    }
   /**
     * 增加会员等级信息
     * @param vo
     * @return 返回是否增加会员等级信息
     */
	public ResultMessage addLevel(LevelVO vo) {
		return ResultMessage.SUCCESS;
	}

	/**
     * 查找所有等级信息
     * @return 返回等级信息列表
     */
	public List<LevelVO> findAllLevel() {
		List<LevelVO> list=new ArrayList<LevelVO>();
		list.add(lv1);
		list.add(lv2);
		return list;
	}

    /**
     * 删除等级
     * @param vo
     * @return 返回是否删除
     */
	public ResultMessage deleteLevel(LevelVO vo) {
		return ResultMessage.SUCCESS;
	}


    /**
     * 显示未异常订单列表
     * @param date
     * @return 返回异常订单列表
     */
	public List<OrderVO> showAbnormal(Date date) {
		List<OrderVO> list=new ArrayList<OrderVO>();
		list.add(ov1);
		list.add(ov2);
		return list;
	}

    /**
     * 查找异常订单
     * @param id
     * @return 异常订单信息
     */
	public OrderVO findSpecificAbnormalOrder(String id) {
		return this.ov1;
	}

    /**
     * 处理异常订单
     * @param vo
     * @return 是否处理成功
     */
	public ResultMessage handleAbnormal(OrderVO vo) {
		return ResultMessage.SUCCESS;
	}

    /**
     * 获取客户信息
     * @param clientID
     * @return 客户信息
     */
	public ClientVO getClient(String clientID) {
		return this.cv;
	}

    /**
     * 设置客户信用值
     * @param clientID
     * @param recharge
     * @return 是否设置成功
     */
	public ResultMessage setCredit(String clientID, int recharge) {
		return ResultMessage.SUCCESS;
	}

    /**
     * 更新网站营销人员信息
     * @param vo
     * @return 是否更新成功
     */
	public ResultMessage update(MarketingVO vo) {
		return ResultMessage.SUCCESS;
	}

    /**
     * 网站管理人员更新基本信息
     * @param vo
     * @return 是否更新成功
     */
	public ResultMessage siteManagerUpdate(MarketingVO vo) {
		return ResultMessage.SUCCESS;
	}

    /**
     * 保存网站管理人员增加的网站营销人员信息
     * @param vo
     * @return 是否增加成功
     */
	public boolean saveSitemanagerAdd(MarketingVO vo) {

		return true;
	}

    /**
     * 网站管理人员删除网站营销人员账户
     * @param vo
     * @return 是佛删除成功
     */
	public boolean saveSitemanagerDelete(MarketingVO vo) {
		return true;
	}

    /**
     * 验证登录信息
     * @param marketingID
     * @param password
     * @return 登录信息是否匹配
     */
	public boolean checkAccount(String marketingID, String password) {
		return true;
	}

    /**
     * 获得网站营销人员基本信息
     * @param id
     * @return 网站营销人员基本信息
     */
	public MarketingVO init(String id) {
		return this.mv;
	}

    /**
     * 获得网站营销人员基本信息
     * @param marketingID
     * @return 获得网站营销人员基本信息
     */
	public MarketingVO returnSitemanagerAccount(String marketingID) {
		return MarketingDataTool.V1;
	}

}
