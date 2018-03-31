package commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author chuyunfei
 * @date: 2018/3/30
 * @description:：用于转发请求失败的页面，比如 404 500 页面
 */
@ControllerAdvice
public class ControllerExceptionHandler {

	/**
	 * 拦截所有的错误信息，然后对错误信息进行转发
	 * 
	 * @param exception
	 */
	@ExceptionHandler({ RequestStatusException.class })
	public String dispatcherMethod(RequestStatusException exception) {
		// 对错误页面进行转发
		return String.valueOf(exception.getErrorCode());
	}
}
