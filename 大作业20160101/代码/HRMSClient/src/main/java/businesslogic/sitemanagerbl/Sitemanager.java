package businesslogic.sitemanagerbl;
/**
 * 网站管理人员类
 * @author yilu
 *
 */
public class Sitemanager {
	 // 网站管理人员帐号
	private String sitemanagerId;
	// 网站管理人员手机号
	private String servicePhoneNumber;
	// 网站管理人员密码
	private String password;

	public Sitemanager(){
		
	}
	public Sitemanager(String sitemanagerId,String servicePhoneNumber,String password){
		this.sitemanagerId=sitemanagerId;
		this.servicePhoneNumber=servicePhoneNumber;
		this.password=password;
	}
	public String getSitemanagerId() {
		return sitemanagerId;
	}
	public void setSitemanagerId(String sitemanagerId) {
		this.sitemanagerId = sitemanagerId;
	}
	public String getSitemanagerPhoneNumber() {
		return servicePhoneNumber;
	}
	public void setSitemanagerPhoneNumber(String sitemanagerPhoneNumber) {
		this.servicePhoneNumber = sitemanagerPhoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
