package controller.homepage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import commons.Status;

public interface HomePageController {

	/*
	 * 观看历史
	 */
	public Status getWatched(HttpSession session);
	
	/*
	 * 轮播
	 */
	public Status getPlayRound();
	
	/*
	 * 根据电影类型查找电影，并返回电影详细信息集合
	 */
	public Status getMovieByType(String movieType);
	
	/*
	 * 通过电影类型返回电影名
	 */
    public Status getMovieName(String movieType);
	
	/*
	 * 今日热门，并返回电影集合
	 */
	public Status getHotOfToday();
	
	/*
	 * 登录检测
	 */
	public Status logincheck(HttpSession session,String user_name,String user_password);
	
	/*
	 * 用户注册
	 */
	public Status register(String user_name,String user_password);
	
	/*
	 * 判断是否存在此用户
	 */
	public Status containsUser(HttpServletRequest request,String user_name,String VerificationCode);
	
	/*
	 * 获得验证码
	 */
	public Status VerificationCode(String code,HttpSession session);
	
	/*
	 * 修改密码
	 */
	public Status updatePassword(HttpSession session,String user_password);
	
	/*
	 * 退出登录
	 */
	public Status signout(HttpSession session);
}
