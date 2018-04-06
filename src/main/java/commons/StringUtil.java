package commons;

public class StringUtil {

	/**
	 * 产生n位的随机数字验证码
	 * 
	 * @param length
	 *            数字长度
	 * @return 返回随机验证码
	 */
	public static String getRandomCode(int length) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append((int) (Math.random() * 10));
		}
		return sb.toString();
	}
	
}
