package controller.homepage.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import commons.Status;
import controller.homepage.HomePageController;
import pojo.movie.MoviePojo;
import pojo.user.User;
import pojo.user.UserNameAndPwd;
import service.homepage.HomePageService;

@Controller
@RequestMapping(value="/homepage")
public class HomePageControllerImpl implements HomePageController {
	
	@Autowired
	private HomePageService homePageService;
	
	/*
	 * 生产一个随机数作为验证码
	 */
	public int getVerificationCode(){
		int x=1000+(int)(Math.random()*10000);
		return x;
	}

	/*
	 * 观看历史
	 */
	@RequestMapping(value="/Watched")
	@ResponseBody
	public Status getWatched(HttpSession session,int userID){
		User user=(User)session.getAttribute("user");		
		if(user==null){
			return new Status(0,"请先登录",null);
		}
		List<String> list=homePageService.getWatched(userID);		
		if(list!=null){
			return new Status(1,"获取成功",list);
		}
		else{
			return new Status(0,"获取失败",null);
		}
	}

	/*
	 * 轮播
	 */
	@RequestMapping(value="/PlayRound")
	@ResponseBody
	public Status getPlayRound(){
		List<MoviePojo> list=homePageService.getPlayRound();
		if(list!=null){
			return new Status(1,"获取成功",list);
		}
		else{
			return new Status(0,"获取失败",null);
		}
	}

	/*
	 * 根据电影类型查找电影，并返回电影集合
	 */
	@RequestMapping(value="/MovieNameByType")
	@ResponseBody
	public Status getMovieByType(String movieType){
		List<MoviePojo> list=homePageService.getMovieByType(movieType);
		if(list!=null){
			return new Status(1,"获取成功",list);
		}
		else{
			return new Status(0,"获取失败",null);
		}		
	}

	/*
	 * 通过电影类型返回电影名
	 */
	@Override
	public Status getMovieName(String movieType) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * 今日热门，并返回电影集合
	 */
	@RequestMapping(value="/HotOfToday")
	@ResponseBody
	public Status getHotOfToday(){
		List<MoviePojo> list=homePageService.getHotOfToday();
        if(list!=null){
        	return new Status(1,"获取成功",list);
        }
        else{
        	return new Status(0,"获取失败",null);
        }
	}

	/*
	 * 登录检测
	 */
	@RequestMapping(value="/logincheck")
	@ResponseBody
	public Status logincheck(String user_name,String user_password){
		UserNameAndPwd userNameAndPwd=new UserNameAndPwd();
		userNameAndPwd.setUser_name(user_name);
		userNameAndPwd.setUser_password(user_password);
		if(user_name==null||" ".equals(user_name)||user_password==null||" ".equals(user_password)){
			return new Status(0,"用户名或密码为空",null);
		}
		if(homePageService.logincheck(userNameAndPwd)!=null){
			return new Status(1,"登录成功",homePageService.logincheck(userNameAndPwd));
		}
		if(homePageService.logincheck(userNameAndPwd)==null){
			return new Status(0,"查无此人",null);
		}
		return new Status(0,"登录失败,亲",null);
	}

	/*
	 * 用户注册
	 */
	@RequestMapping(value="/register")
	@ResponseBody
	public Status register(String user_name,String user_password){
		UserNameAndPwd userNameAndPwd=new UserNameAndPwd();
		userNameAndPwd.setUser_name(user_name);
		userNameAndPwd.setUser_password(user_password);
		if(user_name==null||"".equals(user_name)||user_password==null||"".equals(user_password)){
			return new Status(0,"用户名或密码为空",null);
		}
		if(homePageService.register(userNameAndPwd)==1){
			return new Status(1,"注册成功",null);
		}
		return new Status(0,"注册失败,亲",null);
	}

}
