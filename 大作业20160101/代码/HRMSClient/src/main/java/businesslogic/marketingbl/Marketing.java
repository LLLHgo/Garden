package businesslogic.marketingbl;

import java.awt.Image;

public class Marketing {
	//网站营销人员姓名
    private String name;
    //网站营销人员登录密码
    private String password;
    //网站营销人员账号
    private String marketingID;
    //网站营销人员电话
    private String telephone;
    //网站营销人员头像
    private Image image;

    public Marketing(){
    }

    /**
     * Marketing构造函数
     * @param name
     * @param password
     * @param marketingID
     * @param telephone
     */
    public Marketing(String name,String marketingID,String telephone){
    	this.setName(name);
    	this.setMarketingID(marketingID);
    	this.setTelephone(telephone);
    }
    public Marketing(String name,String password,String marketingID,String telephone){
    	this.setName(name);
    	this.password=password;
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

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
