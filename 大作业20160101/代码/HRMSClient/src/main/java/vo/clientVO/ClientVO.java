package vo.clientVO;

import java.util.ArrayList;

import Enum.VIPType;
/**
 * client的vo类
 * @author ClaraLee
 *
 */
public class ClientVO {
		//用户编号
			public String client_id;
		//用户密码
			public String password;
		//用户姓名
			public String client_name;
		//用户手机号
			public String client_tel;
		//用户会员类型
			public VIPType vip_type;
		//用户会员等级
			public int vip_level;
		//用户生日
			public String client_birth;
		//用户所属企业
			public String client_firm;
		//用户信用记录
			public ArrayList<String> creditRecord;
		//用户信用值
			public int credit;
			public int getCredit() {
				return credit;
			}

			public void setCredit(int credit) {
				this.credit = credit;
			}

			public ClientVO(){
			}

				public ClientVO(String client_id,String password,String client_name,String client_tel,
				 VIPType vip_type,int vip_level,String client_birth,String client_firm,int credit,ArrayList<String> creditRecord){
				this.client_id=client_id;
				this.password=password;
				this.client_name=client_name;
				this.client_tel=client_tel;
				this.vip_type=vip_type;
				this.client_birth=client_birth;
				this.vip_level=vip_level;
				this.client_firm=client_firm;
				this.creditRecord=creditRecord;
				this.credit=credit;
			}
				public ClientVO(String tel,String password){
					this.client_id="";
					this.password=password;
					this.client_name="";
					this.client_tel=tel;
					this.vip_type=VIPType.NONVIP;
					this.client_birth="";
					this.vip_level=0;
					this.client_firm="";
					this.creditRecord=new ArrayList<String>();
					this.credit=0;
				}
				/*public ClientVO(Client c){
					this.client_id=c.client_id;
					this.password=c.password;
					this.client_name=c.client_name;
					this.client_tel=c.client_tel;
					this.vip_type=c.vip_type;
					this.client_birth=c.client_birth;
					this.vip_level=c.vip_level;
					this.client_firm=c.client_firm;
					this.creditRecord=c.creditRecord;
				}*/
				public String getID(){
					return client_id;
				}
				public String getPassword(){
					return password;
				}
				public String getName(){
					return client_name;
				}
				public String getTel(){
					return client_tel;
				}
				public VIPType getType(){
					return vip_type;
				}
				public String getBirth(){
					return client_birth;
				}
				public int getLevel(){
					return vip_level;
				}

				public String getFirm(){
					return client_firm;
				}
				public ArrayList<String> getCreditRecord(){
					 ArrayList<String> list=new ArrayList<String>();
	            	  list.add(" ");
					if(creditRecord!=null)
					return creditRecord;
					else
						return list;


				}
				public void setID(String id){
					this.client_id=id;
				}
				public void setPassword(String password){
					this.password=password;
				}
				public void setName(String name){
					this.client_name=name;
				}
				public void setTel(String tel){
					this.client_tel=tel;
				}
				public void setType(VIPType vip_type){
					this.vip_type=vip_type;
				}
				public void setBirth(String birth){
					this.client_birth=birth;
				}
				public void setLevel(int level){
					this.vip_level=level;
				}

				public void setFirm(String firm){
					this.client_firm=firm;
				}
				public void setCreditRecord(ArrayList<String> record){
					this.creditRecord=record;
				}
}
