package dao.certification;

import org.springframework.stereotype.Component;
import pojo.certification.CertificationItem;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chuyunfei
 * @date: 2018/3/30
 * @description: 认证中心的数据上下文对象，是进行数据认证的凭证：实现增删改查的功能
 */
@Component
public class CertificationContext {

	/**
	 * 1、认证中心的数据集， 键为IP地址， 值为：该IP地址的最后活跃时间，该活跃时间将被作为认证信息清理的依据
	 * ：来认证的网页，将对其进行转发到原来的网页去
	 */
	private Map<String, CertificationItem> certificationContext = new ConcurrentHashMap<>();

	/**
	 * 1、这个是认证中心里面的key值的备份，用于定时的清理过期的认证数据 2、数据类型是IP地址的hash值，在认证数据中心的键和这个数据集同步更新
	 * 3、将这个链表的操作进行同步，防止在大量用户进行同时注销的情况下出现数组下标越界问题
	 */
	private List<String> ipKeys = Collections.synchronizedList(new ArrayList<>());

	/**
	 * 查询功能 1、判断该IP地址是否已经被认证过了
	 * 
	 * @param item
	 * @return
	 */
	public boolean isContains(CertificationItem item) {
		return certificationContext.containsKey(item.getIpAddress());
	}

	/**
	 * 获取一个认证信息，便于修改或者转发请求的原地址
	 * 
	 * @param ip
	 * @return
	 */
	public CertificationItem getCertificationItem(String ip) {
		return certificationContext.get(ip);
	}

	/**
	 * 增加功能 1、添加新的认证信息
	 * 
	 * @param item
	 */
	public void addCertification(CertificationItem item) {
		// 将IP地址进行备份
		ipKeys.add(item.getIpAddress());
		certificationContext.put(item.getIpAddress(), item);
	}

	/**
	 * 修改功能 1、更新已有的认证信息，更新最后活跃时间
	 * 
	 * @param item
	 */
	public void updateCertification(CertificationItem item) {
		certificationContext.get(item.getIpAddress()).setLastActiveTime(item.getLastActiveTime());
	}

	/**
	 * 删除功能 1、移除认证的信息，用于用户注销和过期的认证信息清理：用户注销的接口
	 * 
	 * @param item
	 */
	public void removeCertification(CertificationItem item) {
		certificationContext.remove(item.getIpAddress());
	}

	/**
	 * 删除功能 1、移除认证的信息，用于用户注销和过期的认证信息清理：认证信息的清理接口
	 * 
	 * @param ipKey
	 */
	public void removeCertification(String ipKey) {
		certificationContext.remove(ipKey);
	}

	public Map<String, CertificationItem> getCertificationContext() {
		return certificationContext;
	}

	public void setCertificationContext(Map<String, CertificationItem> certificationContext) {
		this.certificationContext = certificationContext;
	}

	public List<String> getIpKeys() {
		return ipKeys;
	}

	public void setIpKeys(List<String> ipKeys) {
		this.ipKeys = ipKeys;
	}
}
