package pojo.certification;

import javax.swing.text.StyledEditorKit.BoldAction;
import javax.validation.constraints.NotNull;

/**
 * @author chuyunfei
 * @date: 2018/3/30
 * @description: 认证的必要信息
 */
public class CertificationItem {
	/* 待认证的IP地址信息 */
	@NotNull
	private String ipAddress;
	/* 那个页面发起的认证请求，用于在认证后将其转发到原来的页面去 */
	private String originUrl;
	/* 什么时候开始登陆整个系统的 */
	private Long beginTime;
	/* 最后一次的活跃时间，用于数据的清理 */
	private Long lastActiveTime;
	/* 是否已经认证完毕，用于在登陆后跳转到原来的请求地址 */
	private Boolean provided;

	public CertificationItem() {
	}

	public CertificationItem(String ipAddress, String originUrl, Long beginTime, Long lastActiveTime,
			Boolean provided) {
		this.ipAddress = ipAddress;
		this.originUrl = originUrl;
		this.beginTime = beginTime;
		this.lastActiveTime = lastActiveTime;
		this.provided = provided;
	}

	public String getOriginUrl() {
		return originUrl;
	}

	public void setOriginUrl(String originUrl) {
		this.originUrl = originUrl;
	}

	public Long getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Long beginTime) {
		this.beginTime = beginTime;
	}

	public Long getLastActiveTime() {
		return lastActiveTime;
	}

	public void setLastActiveTime(Long lastActiveTime) {
		this.lastActiveTime = lastActiveTime;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Boolean getProvided() {
		return provided;
	}

	public void setProvided(Boolean provided) {
		this.provided = provided;
	}

	@Override
	public String toString() {
		return "CertificationItem{" + "ipAddress='" + ipAddress + '\'' + ", originUrl='" + originUrl + '\''
				+ ", beginTime=" + beginTime + ", lastActiveTime=" + lastActiveTime + ", provided=" + provided + '}';
	}
}
