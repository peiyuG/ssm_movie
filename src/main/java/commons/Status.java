package commons;

import java.util.List;

import pojo.movie.MoviePojo;

/**
 * @author chuyunfei
 * @date: 2018/3/30
 * @description: 用于返回数据使用，一个固定的格式，便于实现接口的交互
 */
public class Status {
	/* 0：失败，1：成功 用于快速判断该请求是否成功以及处理显示错误信息 */
	private Integer statue;
	/* 用于描述状态信息，比如如果请求出错用于描述错误信息等 */
	private String message;
	/* 将用于返回的信息，如果需要返回的话 */
	private Object data;

	public Status() {
	}

	public Status(Integer statue, String message, Object data) {
		this.statue = statue;
		this.message = message;
		this.data = data;
	}

	public Integer getStatue() {
		return statue;
	}

	public void setStatue(Integer statue) {
		this.statue = statue;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public Status check(Object object){
		if (object != null&&object.equals("")) {
			return new Status(1, "获取成功", object);
		} else {
			return new Status(0, "获取失败", null);
		}
	}

	@Override
	public String toString() {
		return "Status{" + "statue=" + statue + ", message='" + message + '\'' + ", data=" + data + '}';
	}
}
