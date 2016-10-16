package po;

import java.util.List;

import Enum.PrivilegeWay;
import Enum.VIPType;

public class PrivilegePO {
	//会员种类，包括ORDINARYVIP,ENTERPRISEVIP
    private VIPType type;
    //活动折扣
    private double discount;
    //福利方式，包括日常折扣DAILY，生日特惠BIRTHDAY，企业福利ENTERPRISE
    private PrivilegeWay privilegeWay;
    //参与企业福利的企业
    private List<String> enterprises;

    public PrivilegePO(){

    }

    /**
     * 为普通会员制定的福利
     * @param type
     * @param discount
     * @param privilegeWay
     */
    public PrivilegePO(VIPType type,double discount,PrivilegeWay privilegeWay){
    	this.setType(type);
    	this.setDiscount(discount);
    	this.setPrivilegeWay(privilegeWay);
    }
    /**
     * 为企业会员制定的福利
     * @param type
     * @param discount
     * @param privilegeWay
     * @param enterprises
     */
    public PrivilegePO(VIPType type,double discount,PrivilegeWay privilegeWay,List<String> enterprises){
    	this.setType(type);
    	this.setDiscount(discount);
    	this.setPrivilegeWay(privilegeWay);
    	this.setEnterprises(enterprises);
    }

	public VIPType getType() {
		return type;
	}

	public void setType(VIPType type) {
		this.type = type;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public PrivilegeWay getPrivilegeWay() {
		return privilegeWay;
	}

	public void setPrivilegeWay(PrivilegeWay privilegeWay) {
		this.privilegeWay = privilegeWay;
	}

	public List<String> getEnterprises() {
		return enterprises;
	}

	public void setEnterprises(List<String> enterprises) {
		this.enterprises = enterprises;
	}
}

