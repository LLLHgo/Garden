package vo.levelVO;

public class LevelVO {
	//等级层次
    private int level;
    //等级名称
    private String name;
    //从上一等级上升到此等级所需的信用值
    private int creditNeeded;

    /**
     * LevelVO的构造函数
     * @param level
     * @param name
     * @param creditNeeded
     */
    public LevelVO(int level,String name,int creditNeeded){
    	this.setLevel(level);
    	this.setName(name);
    	this.setCreditNeeded(creditNeeded);
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
	public int getCreditNeeded() {
		return creditNeeded;
	}
	public void setCreditNeeded(int creditNeeded) {
		this.creditNeeded = creditNeeded;
	}
}
