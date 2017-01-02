package businesslogic.logbl;
/**
 * 日志类
 * @author yilu
 *
 */
public class Log {
	 private String logInfo;
    public Log(){
	}
	public Log(String logInfo){
		this.logInfo=logInfo;
	} 
	public String getLogInfo() {
		return logInfo;
	}
	public void setLogInfo(String logInfo) {
		this.logInfo = logInfo;
	}
}
