package po;

public class MarketingPO {
	//网站营销人员姓名
    private String name;
    //网站营销人员登录密码
    private String password;
    //网站营销人员账号
    private String marketingID;
    //网站营销人员电话
    private String telephone;

    public MarketingPO(){
    }

    /**
     * MarketingPO构造函数
     * @param name
     * @param password
     * @param marketingID
     * @param telephone
     */
    public MarketingPO(String name,String password,String marketingID,String telephone){
    	this.setName(name);
    	this.setPassword(password);
    	this.setMarketingID(marketingID);
    	this.setTelephone(telephone);
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMarketingID() {
		return marketingID;
	}
	public void setMarketingID(String marketingID) {
		this.marketingID = marketingID;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
    }
}
