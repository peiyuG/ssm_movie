package service.homepage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.movie.MoviePojo;
import pojo.user.User;
import pojo.user.UserNameAndPwd;

public interface HomePageService {

	//轮播
	List<MoviePojo> getPlayRound();	
		
	//通过电影类型查找推荐电影名
	List<MoviePojo> getMovieByType(String movieType);
	
	//通过电影类型返回电影名
	List<String> getMovieName(String movieType);
		
	//今日热门
	List<MoviePojo> getHotOfToday();
	
	//登录
	User logincheck(UserNameAndPwd userNameAndPwd);
			
	//注册
	int register(UserNameAndPwd userNameAndPwd);
		
	//根据user的id返回历史观看记录，电影名集合
	List<String> getWatched(int userID);
	
	//判断是否存在用户名为user_name的用户
	int IscontainsThisUser(String user_name);
		
	//修改密码
	int updatePassword(String user_password,String user_name);
}
