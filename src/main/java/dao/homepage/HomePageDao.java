package dao.homepage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.user.User;
import pojo.user.UserNameAndPwd;
import pojo.movie.MoviePojo;

public interface HomePageDao {

	//轮播
	List<MoviePojo> getPlayRound();
	
	//通过电影类型返回电影名
	List<String> getMovieName(String movieType);
	
	//通过电影类型查找推荐电影详细信息
	List<MoviePojo> getMovieByType(@Param("movieType") String movieType);
	
	//今日热门
	List<MoviePojo> getHotOfToday();
	
	//登录
	User logincheck(UserNameAndPwd userNameAndPwd);
		
	//注册
	int register(UserNameAndPwd userNameAndPwd);
	
	//根据user的id返回历史观看记录，电影名集合
	List<String> getWatched(int userID);
	
	//判断是否存在用户名为user_name的用户
	int IscontainsThisUser(@Param("user_name") String user_name);
	
	//修改密码
	int updatePassword(@Param("user_password") String user_password, @Param("user_name") String user_name);
}
