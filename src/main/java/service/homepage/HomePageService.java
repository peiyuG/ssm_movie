package service.homepage;

import java.util.List;

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
}
