package po;

import java.io.Serializable;
/**
 * logPO包
 * @author yilu
 *
 */
public class LogPO implements Serializable{
	private static final long serialVersionUID = 1L;
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
