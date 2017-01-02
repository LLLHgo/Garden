package vo.logVO;
/**
 * logVO包
 * @author yilu
 *
 */
public class LogVO {
     // 日志信息
    private String logInfo;
    public LogVO(){
	}
	public LogVO(String logInfo){
		this.logInfo=logInfo;
	} 
	public String getLogInfo() {
		return logInfo;
	}
	public void setLogInfo(String logInfo) {
		this.logInfo = logInfo;
	}
}
