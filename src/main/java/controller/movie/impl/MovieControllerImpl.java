package controller.movie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;

import commons.PageStatus;
import commons.RequestStatusException;
import commons.Status;
import controller.movie.MovieController;
import service.movie.MovieService;

/**
 * @author wujia 
 * @since 2018/4/5 16:03
 * @description:电影模块控制层impl，用于电影数据查询
 */
@Controller
@RequestMapping("/movie")
public class MovieControllerImpl implements MovieController {

	private MovieService movieService;
	private Status status;

	@RequestMapping("/error")
	@ResponseBody
	public Status error() throws RequestStatusException {

		throw new RequestStatusException("资源找不到！", 404);
	}

	@Autowired
	public void setMovieService(MovieService movieService) {
		this.movieService = movieService;
	}


	@RequestMapping("/getMovieByDifferentType")
	@ResponseBody
	public PageStatus getMovieByDifferentType(Integer pageNum, Integer pageSize, String category, String country,
			String release_time, int is_vip_movie, String otherType) {
        
		//分页插件的使用
		PageHelper.startPage(pageNum, pageSize);
		PageStatus pageStatus = movieService.getMovieByDifferentType(pageNum,pageSize,category, country, release_time, is_vip_movie, otherType);
		return pageStatus;
		
	}

	@RequestMapping("/getMovieByname")
	@ResponseBody
	public Status getMovieByname(String name) {
		status = movieService.getMovieByname(name);
		return status;
	}

	@RequestMapping("/getRanklist")
	@ResponseBody
	public Status getRanklist() {
		status = movieService.getRanklist();
		return status;
	}

	@RequestMapping("/getMovieByID")
	@ResponseBody
	public Status getMovieByID(int id) {
		status = movieService.getMovieByID(id);
		return status;
	}
	
	@RequestMapping("/getMovieByType")
	@ResponseBody
	public Status getMovieByType() {
		status = movieService.getMovieByType();
		return status;
	}

}
