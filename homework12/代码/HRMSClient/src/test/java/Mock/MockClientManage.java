package Mock;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import Enum.OrderType;
import Enum.ResultMessage;
import Enum.VIPType;
import datatool.ClientDataTool;
import datatool.OrderDataTool;
import datatool.SitemanagerDataTool;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.levelVO.LevelVO;
import vo.orderVO.OrderVO;
import vo.sitemanager.SitemanagerVO;

public class MockClientManage {
	//用户编号
		 String client_id;
	//用户密码
		 String password;
	//用户姓名
		 String client_name;
	//用户手机号
		 String client_tel;
	//用户会员类型
		 VIPType vip_type;
	//用户会员等级
		 int vip_level;
	//用户生日
		 Date client_birth;
	//用户所属企业
		 String client_firm;
	//用户信用记录
		ArrayList<String> creditRecord=null;
		ClientVO clientVO;
		ClientVO clientVO1=ClientDataTool.clientVO1;
		ClientVO clientVO2=ClientDataTool.clientVO2;
		ClientVO clientVO3=ClientDataTool.clientVO3;
		public MockClientManage(){
		}
		public MockClientManage(String id,String password){
			this.client_id=id;
			this.password=password;
			if(id==clientVO1.client_id)
				this.clientVO=clientVO1;
			else if(id==clientVO2.client_id)
				this.clientVO=clientVO2;
			else
				this.clientVO=clientVO3;
		}
		public MockClientManage(String name){
			this.client_name=name;
			if(name==clientVO1.client_name)
				this.clientVO=clientVO1;
			else if(name==clientVO2.client_name)
				this.clientVO=clientVO2;
			else
				this.clientVO=clientVO3;
		}
		public MockClientManage(ClientVO clientVO){
			this.clientVO=clientVO;
		}
		@SuppressWarnings("deprecation")
		Date day=new Date(1996,2,29);
		File file=new File("c.txt");
		ClientVO client=new ClientVO("C00000001","justfun","ErgouWang","13747474741",
				 VIPType.ORDINARYVIP,2,"1996-02-29","",100,creditRecord);
		public boolean checkAccount (ClientVO accountVO){

			if(accountVO.client_id==ClientDataTool.clientVO1.client_id&&
					accountVO.password==ClientDataTool.clientVO1.password)
				return true;
			else
				return false;
		}
		/**
		 *通过客户ID得到客户个人信息
		 * @param clientID
		 * @return 客户的个人信息
		 */
		public ClientVO getclient (String clientID){
			if(clientID==clientVO1.client_id)
				this.clientVO=clientVO1;
			else if(clientID==clientVO2.client_id)
				this.clientVO=clientVO2;
			else
				this.clientVO=clientVO3;
			return clientVO;
		}

		/**
		 *增加新客户
		 * @param vo
		 * @return 增加新用户成功与否
		 */
		public ResultMessage createClient(ClientVO vo){
			if(vo.getID() != null)
				return ResultMessage.SUCCESS;
			else
				return ResultMessage.FAIL;
		}
		/**
		 *删除客户
		 * @param vo
		 * @return 删除用户成功与否
		 */
		public ResultMessage saveSitemanagerDelete(String clientId){
			if(clientId!= null)
				return ResultMessage.SUCCESS;
			else
				return ResultMessage.FAIL;
		}
		/**
		 *设置（修改）某一客户信用值
		 * @param clientID
		 * @param recharge
		 * @return 修改信用值成功与否
		 */
		public boolean setCredit(String clientID,int recharge){
			if(recharge==0)
				return false;
			else{
				return true;
			}
		}
		/**
		 * 根据新的会员等级制度修改所有客户的会员等级
		 * @param vo
		 * @return 修改会员等级成功与否
		 */
		public boolean setAllClientLevel(LevelVO vo){
			if(vo!=null)
				return true;
			else
				return false;
		}
		/**
		 *修改客户基本信息
		 * @param vo
		 * @return 修改个人信息成功与否提示信息
		 */
		public  ResultMessage updateInfo(ClientVO vo){
			if(vo!=null)
				return ResultMessage.SUCCESS;
			else
				return ResultMessage.FAIL;
		}
		/**
		 *撤销订单
		 * @param orderID
		 * @return 撤销成功与否
		 */
		public boolean repealOrder(String orderID){
			if(orderID!=null)
				return true;
			else
				return false;
		}
		/**
		 *得到客户的信用记录
		 * @param clientID
		 * @return 信用记录
		 */
		public File getCreditRecord(String clientID){
			File file=new File("credit");
			if(clientID!=null)
				return file;
			else
				return null;
		}

}
