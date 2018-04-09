package service.homepage.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.homepage.HomePageDao;
import pojo.movie.MoviePojo;
import pojo.user.User;
import pojo.user.UserNameAndPwd;
import service.homepage.HomePageService;

@Service
public class HomePageServiceImpl implements HomePageService {
	
	@Autowired
	private HomePageDao homePageDao;

	/*
	 * 获得轮播的电影集合
	 */
	@Override
	public List<MoviePojo> getPlayRound() {
		List<MoviePojo> list=new ArrayList<>();
		try{
			list=homePageDao.getPlayRound();
		}catch (Exception e) {
			return null;
		}
		return list;
	}

	/*
     * 根据电影类型返回推荐的电影集合
     */
	@Override
	public List<MoviePojo> getMovieByType(String movieType) {
		List<MoviePojo> list=new ArrayList<>();
		try{
			list=homePageDao.getMovieByType(movieType);
		}catch (Exception e) {
			return null;
		}
		return list;
	}

	@Override
	public List<String> getMovieName(String movieType) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * 获取今日热门的电影集合
	 */
	@Override
	public List<MoviePojo> getHotOfToday() {
		List<MoviePojo> list=new ArrayList<>();
		try{
			list=homePageDao.getHotOfToday();
		}catch (Exception e) {
			return null;
		}
		return list;
	}

	/*
	 * 登录检测
	 *
	 */
	@Override
	public User logincheck(UserNameAndPwd userNameAndPwd) {
		User user = new User();
		try{
			user=homePageDao.logincheck(userNameAndPwd);
		}catch (Exception e) {
			return null;
		}
		return user;
	}

	/*
	 * 用户注册
	 *
	 */
	@Override
	public int register(UserNameAndPwd userNameAndPwd) {
		int result=0;
		try{
			result=homePageDao.register(userNameAndPwd);
		}catch (Exception e) {
			return 0;
		}
		return result;
	}

	/*
	 * 根据userID获取user的观看历史
	 *
	 */
	@Override
	public List<String> getWatched(int userID) {
		List<String> list=new ArrayList<>();
		try{
			list=homePageDao.getWatched(userID);
		}catch (Exception e) {
			return null;
		}
		return list;
	}

	/*
	 * 是否存在此用户
	 * 
	 */
	@Override
	public int IscontainsThisUser(String user_name) {
		int result=0;
		try{
			result=homePageDao.IscontainsThisUser(user_name);
		}catch (Exception e) {
			return 0;
		}
		return result;
	}
	
	/*
	 * 更新用户密码，用于密码找回
	 * 
	 */
	@Override
	public int updatePassword(String user_password,String user_name) {
		int result=0;
		try{
			result=homePageDao.updatePassword(user_password,user_name);
		}catch (Exception e) {
			return 0;
		}
		return result;
	}

}
