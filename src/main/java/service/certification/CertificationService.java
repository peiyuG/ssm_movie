package service.certification;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chuyunfei
 * @date: 2018/3/30
 * @description: 认证中心的核心服务对象，为其他模块提供用户认证服务
 */
public interface CertificationService {
	/**
	 * 1、移除一条认证信息，仅仅用于用户的主动注销 2、注销的用户将被转发到登录界面
	 * 
	 * @param request：注销的用户请求
	 * @return
	 */
	boolean deleteCertification(HttpServletRequest request);

	/**
	 * 1、检查该IP地址是否已经在认证信息里面认证 2、用于模块检查其他是否已经为这个IP地址进行了认证
	 * 
	 * @param ipKey
	 *            ：请求的IP地址
	 * @return
	 */
	boolean checkCertification(String ipKey);

	/**
	 * 1、添加一条认证信息，在这个IP地址没有被认证的时候进行认证信息的添加 2、必须是阻塞执行
	 * 
	 * @param request
	 *            ； 用于获取IP地址、用于登录转发的请求对象，用于请求回调的原始url请求地址
	 */
	void addCertification(HttpServletRequest request);

	/**
	 * 1、已经登录的用户，每隔一段时间都必须进行在线状态信息的确认 2、确认信息的流程是非阻塞的，认证状态的更新不会阻塞正常的访问
	 * 3、异步任务，会开启异步任务的支持，和线程池
	 * 
	 * @param ipKey
	 */
	void update(String ipKey);
}
