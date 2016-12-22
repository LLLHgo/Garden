package businesslogicservice.marketinblservice;

import java.util.List;

import Enum.ResultMessage;
import vo.areaVO.AreaVO;
import vo.clientVO.ClientVO;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.MarketingStrategyVO;

public interface MarketingBLControllerService {

	public ResultMessage updateLevel(List<LevelVO> vo);

	public List<LevelVO> findAllLevel();

	public ResultMessage MarketingAccountAdd(MarketingVO marketing);

	public ResultMessage MarketingAccountUpdate(MarketingVO marketing);

	public ResultMessage MarketingAccountDelete(MarketingVO marketingVO);

	public MarketingVO MarketingAccountFind(String marketingID);

	public boolean checkAccount(String marketingID, String password);

	public MarketingVO init(String id);

	public boolean setCredit(String clientID, int amount);


	public OrderVO findSpecificOrder(String marketingID, String orderID);

	public List<OrderVO> findAbnormalOrderList(String date);


	public ClientVO getclient(String clientID);

	public ResultMessage deleteMarketingStrategy(String vo);

	public List<MarketingStrategyVO> getMarketingStrategy();

	public ResultMessage addMarketingStrategy(MarketingStrategyVO vo);

	public List<AreaVO> getDistricts();

	public String[] getDistrictNames();

	public ResultMessage operateOnAbnormalOrder(OrderVO order, double price, StringBuilder log);

}
