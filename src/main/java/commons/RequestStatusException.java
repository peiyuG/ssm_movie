package commons;

/**
 * @author chuyunfei
 * @date: 2018/3/30
 * @description: 自定义的一个异常，用于实现错误页面的转发
 */
public class RequestStatusException extends Exception {
	/* 用于在 controlleradvice里面解析错误页面转发的 */
	private Integer errorCode;

	/**
	 * 错误信息 + 错误的标准码
	 * 
	 * @param message
	 * @param errorCode
	 */
	public RequestStatusException(String message, Integer errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
}
