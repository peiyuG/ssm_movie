package controller.homepage;

import java.util.List;

import javax.servlet.http.HttpSession;

import commons.Status;

public interface HomePageController {

	/*
	 * 观看历史
	 */
	public Status getWatched(HttpSession session,int userID);
	
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
	public Status logincheck(String user_name,String user_password);
	
	/*
	 * 用户注册
	 */
	public Status register(String user_name,String user_password);
	
}
