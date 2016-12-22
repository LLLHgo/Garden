package vo.levelVO;

public class LevelVO {
	//等级层次
    private int level;
    //等级名称
    private String name;
    //上升到该等级所需的信用值
    private double creditNeeded;
    //该等级享受的折扣
    private double discount;

    /**
     * LevelVO的构造函数
     * @param level
     * @param name
     * @param creditNeeded
     */
    public LevelVO(int level,String name,double creditNeeded,double discount){
    	this.setLevel(level);
    	this.setName(name);
    	this.setCreditNeeded(creditNeeded);
    	this.discount=discount;
    }
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCreditNeeded() {
		return creditNeeded;
	}
	public void setCreditNeeded(double creditNeeded) {
		this.creditNeeded = creditNeeded;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
}
