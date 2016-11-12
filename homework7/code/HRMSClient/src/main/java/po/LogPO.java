package po;

public class LogPO {
	// 日志信息
	private String logInfo;
	
	public LogPO(){
	}
	public LogPO(String logInfo){
		this.logInfo=logInfo;
	} 
	public String getLogInfo() {
		return logInfo;
	}
	public void setLogInfo(String logInfo) {
		this.logInfo = logInfo;
	}
}
