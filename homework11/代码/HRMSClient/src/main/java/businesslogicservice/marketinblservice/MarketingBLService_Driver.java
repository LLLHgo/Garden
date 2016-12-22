package businesslogicservice.marketinblservice;

import java.util.ArrayList;
import java.util.List;
import Enum.ResultMessage;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;

public class MarketingBLService_Driver {
    public void drive(MarketingBLService marketingBLService){

    	//建立LevelVO
    	LevelVO Lvo1=new LevelVO(2,"银牌",2000,0.97);
    	LevelVO Lvo2=new LevelVO(1,"铜牌",1000,0.98);
    	LevelVO Lvo3=new LevelVO(3,"金牌",3000,0.9);
    	List<LevelVO> levelList=new ArrayList<LevelVO>();
    	levelList.add(Lvo1);
    	levelList.add(Lvo2);
    	levelList.add(Lvo3);
    	ResultMessage addLevelResult=marketingBLService.updateLevel(levelList);
    	if(addLevelResult==ResultMessage.SUCCESS)System.out.println("建立LevelVO成功");

    	//返回Level等级
    	List<LevelVO> levellist=marketingBLService.findAllLevel();
    	if(levellist.size()>0)System.out.println("返回Level等级成功");

    	//修改网站营销人员信息
    	MarketingVO Mvo=new MarketingVO();
    	ResultMessage updateResult=marketingBLService.MarketingAccountUpdate(Mvo);
    	if(updateResult==ResultMessage.SUCCESS)System.out.println("修改网站营销人员信息成功");


    	//网站管理人员增加营销人员信息
    	ResultMessage addBool=marketingBLService.MarketingAccountAdd(Mvo);
    	if(addBool==ResultMessage.SUCCESS)System.out.println("网站管理人员增加营销人员信息成功");

    	//网站管理人员删除营销人员信息
    	ResultMessage deleteBool=marketingBLService.MarketingAccountDelete(Mvo);
    	if(deleteBool==ResultMessage.SUCCESS)System.out.println("网站管理人员删除营销人员信息成功");

    	//网站营销人员验证登录密码
    	boolean checkBool=marketingBLService.checkAccount("M0001","password");
    	if(checkBool)System.out.println("网站营销人员验证登录成功");

    	//获得网站营销人员信息
    	MarketingVO mvo=marketingBLService.init("M0001");
    	if(mvo!=null)System.out.println("得到网站营销人员信息成功");

    	//返回网站营销人员的个人信息
    	MarketingVO MVO=marketingBLService.MarketingAccountFind("M00010001");
    	if(MVO!=null){System.out.println("已成功返回网站营销人员的个人信息");
    	}
    }
}
