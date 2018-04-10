package controller.homepage.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import commons.Status;
import commons.StringUtil;
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
	
//	/*
//	 * 生产一个随机数作为验证码
//	 */
//	public int getVerificationCode(){
//		int x=1000+(int)(Math.random()*10000);
//		return x;
//	}

	/*
	 * 观看历史
	 */
	@RequestMapping(value="/Watched")
	@ResponseBody
	public Status getWatched(HttpSession session){
		User user=(User)session.getAttribute("user");		
		if(user==null){
			return new Status(0,"请先登录",null);
		}
		List<String> list=homePageService.getWatched(user.getUserID());		
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
	@RequestMapping(value="/MovieByType")
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
	public Status logincheck(HttpSession session,String user_name,String user_password){
		UserNameAndPwd userNameAndPwd=new UserNameAndPwd();
		userNameAndPwd.setUser_name(user_name);
		userNameAndPwd.setUser_password(user_password);
		if(user_name==null||" ".equals(user_name)||user_password==null||" ".equals(user_password)){
			return new Status(0,"用户名或密码为空",null);
		}
		User user=homePageService.logincheck(userNameAndPwd);
		if(user!=null){
			session.setAttribute("user", user);
			return new Status(1,"登录成功",null);
		}
		else{
			return new Status(0,"查无此人",null);
		}
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
		if(homePageService.IscontainsThisUser(user_name)==1){
			return new Status(0,"该用户名已经被注册",null);
		}
		if(homePageService.register(userNameAndPwd)==1){
			return new Status(1,"注册成功",null);
		}
		return new Status(0,"注册失败,亲",null);
	}

	/*
	 * 找回密码的功能
	 */
	/*
	 * 判断是否存在此用户
	 */
	@RequestMapping(value="/containsUser")
	@ResponseBody
	public Status containsUser(HttpServletRequest request,String user_name,String VerificationCode){
		if(user_name==null||"".equals(user_name)){
			return new Status(0,"用户名不能为空",null);
		}
		HttpSession session=request.getSession();
		String code= StringUtil.getRandomCode(4);
		if(homePageService.IscontainsThisUser(user_name)!=0){
			session.setAttribute("VerificationCode",code);	
			session.setAttribute("user_name", user_name);
			return new Status(1,"验证码发送成功",code);
		}
		if(homePageService.IscontainsThisUser(user_name)==0){
			return new Status(0,"该用户不存在",null);
		}	
		return new Status(0,"未知错误发生了",null);
	}
	
	/*
	 * 获得验证码
	 */
	@RequestMapping(value="/getVerificationCode")
	@ResponseBody
	public Status VerificationCode(String code,HttpSession session){
		if (code == null || "".equals(code)) {
			return new Status(0, "验证码未知错误", null);
		}
		String session_VerificationCode=session.getAttribute("VerificationCode").toString();
		if(session_VerificationCode.equals(code)){
			session.removeAttribute("VerificationCode");
			return new Status(1,"验证成功",null);
		}
		else{
			return new Status(0,"验证失败",null);
		}
	}

	/*
	 * 修改密码
	 */
	@RequestMapping(value="/updatePassword")
	@ResponseBody
	public Status updatePassword(HttpSession session,String user_password){
		if(user_password==null||" ".equals(user_password)){
			return new Status(0,"密码不能为空",null);
		}
		String user_name=session.getAttribute("user_name").toString();
		if(homePageService.updatePassword(user_password,user_name)==1){
			session.removeAttribute("user_name");
			return new Status(1,"修改成功",null);
		}
		if(homePageService.updatePassword(user_password,user_name)==0){
			return new Status(0,"对不起,修改失败",null);
		}
		return new Status(0,"未知错误发生了",null);
	}
	
	/*
	 * 退出登录
	 */
	@RequestMapping(value="/signout")
	@ResponseBody
	public Status signout(HttpSession session){
		try{
			session.removeAttribute("user");
			return new Status(1,"成功退出",null);
		}catch (Exception e) {
			return new Status(0,"系统错误",null);
		}
		
	}
}
