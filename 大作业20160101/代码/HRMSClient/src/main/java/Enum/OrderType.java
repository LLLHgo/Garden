package Enum;
/**
 * 订单种类的enum值
 * @author yilu
 *
 */
public enum OrderType {
	NORMALNONEXEC,NORMALEXEC,CANCEL,ABNORMAL,ALL,ABNORMALCANCEL;

	//ABNORMALCANCEL是指被网站营销人员撤销了的异常订单
}
