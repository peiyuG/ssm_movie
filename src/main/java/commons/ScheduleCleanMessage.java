package commons;

import dao.certification.CertificationContext;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pojo.certification.CertificationItem;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author chuyunfei
 * @date: 2018/3/30
 * @description: 用于实现认证中心的数据清理工作：定时任务
 */
@Component
public class ScheduleCleanMessage {

	/* 清理的时间间隔，也是认证信息的失效时间 */
	private Long timeDelay;
	@Autowired
	private CertificationContext certificationContext;

	@Scheduled(fixedDelay = 1000 * 2) // 这个注解必须要有fixedRate，或者fixedDelay注解
	public void cleanDateOutMessage() {
		// todo 对认证中心里面的过期数据进行清理
		// 获取出元数据
		List<String> ipKeys = certificationContext.getIpKeys();
		Map<String, CertificationItem> context = certificationContext.getCertificationContext();

		try {
			// 获取注解元数据，确定过期时间
			Scheduled message = this.getClass().getDeclaredMethod("cleanDateOutMessage", null)
					.getAnnotation(Scheduled.class);
			long fixedRate = message.fixedRate();
			long fixedDelay = message.fixedDelay();
			timeDelay = fixedDelay > 0 ? fixedDelay : fixedRate;
			// 当前时间
			long now = new Date().getTime();

			String ipKey;
			CertificationItem item;
			// 确保数组下标越界不会出现异常
			for (int keysLength = ipKeys.size(), i = 0; i < keysLength; i++) {
				ipKey = ipKeys.get(i);
				item = context.get(ipKey);
				// 时间超时，或者键是空的
				if (item == null || now - item.getLastActiveTime() > timeDelay) {
					// 移除数据
					ipKeys.remove(ipKey);
					CertificationItem removed = context.remove(ipKey);
					System.out.println("被移除的数据：" + ipKey + ": " + removed);
					// 长度 -1，防止数组下标越界
					keysLength--;
				}
			}
		} catch (IndexOutOfBoundsException exception) {
			System.out.println("数组下标越界，数组元素减少，元素遍历完成！");
			exception.printStackTrace();
		} catch (Exception exception) {
			System.out.println("检测到其他不可预料的错误，但是数据清理工作已经完成！");
			exception.printStackTrace();
		}
	}
}
