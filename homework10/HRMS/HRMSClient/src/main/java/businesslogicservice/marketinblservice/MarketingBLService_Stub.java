package businesslogicservice.marketinblservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Enum.ResultMessage;
import vo.hotelinfoVO.HotelinfoVO;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;

public class MarketingBLService_Stub implements MarketingBLService {
	//折扣
	double discount;
	//酒店信息列表
    ArrayList<HotelinfoVO> hotels;

    public MarketingBLService_Stub(double discount){
       this.discount=discount;
	}
    public MarketingBLService_Stub(){

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
     * 修改网站营销人员信息
     * @param vo
     * @return 返回是否修改网站营销人员信息成功
     */
	public ResultMessage update(MarketingVO vo) {
		if(vo.getMarketingID()=="M0000001")
			return ResultMessage.FAIL;
	    else
	    	return ResultMessage.SUCCESS;
	}

    /**
     * 网站管理人员修改营销人员信息
     * @param vo
     * @return 返回是否网站管理人员修改营销人员信息成功
     */
	public ResultMessage MarketingAccountUpdate(String userId) {
		if(userId.charAt(0)=='M')
			return ResultMessage.SUCCESS;
	    else
	    	return ResultMessage.FAIL;
	}

    /**
     * 网站管理人员增加营销人员信息
     * @param vo
     * @return 返回是否网站管理人员增加营销人员信息成功
     */
	public ResultMessage MarketingAccountAdd(MarketingVO vo) {
		if(vo.getName().equals("xiaohua"))
			return ResultMessage.DUPLICATENAME;
	    else
	    	return ResultMessage.SUCCESS;
	}

    /**
     * 网站管理人员删除营销人员信息
     * @param vo
     * @return 返回是否网站管理人员删除营销人员信息成功
     */
	public ResultMessage saveSitemanagerDelete(String id) {
		if(id.charAt(0)=='M')
			return ResultMessage.SUCCESS;
	    else
	    	return ResultMessage.FAIL;
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
		MarketingVO vo=new MarketingVO("营销人员一号","1029384756","M0000002","13380009000");
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
     * 根据marketingID返回给网站管理人员网站营销人员的信息
     * @param marketingID
     * @return
     */
	public MarketingVO MarketingAccountFind(String marketingID) {
		MarketingVO vo=new MarketingVO("网站营销人员","password","M0000001","15077685563");
		return vo;
	}

	@Override
	public ResultMessage MarketingAccountUpdate(MarketingVO marketing) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage MarketingAccountDelete(MarketingVO marketingVO) {
		// TODO Auto-generated method stub
		return null;
	}


}