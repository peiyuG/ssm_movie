package service.movie.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import commons.Status;
import dao.movie.MovieDao;
import pojo.movie.MoviePojo;
import service.movie.MovieService;

/**
 * @author wujia 
 * @since 2018/4/5 16:03
 * @description:电影模块服务层impl，用于连接dao层和controller层，异常处理等逻辑处理
 * @return:Status
 */
@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDao movieDao;
	
	private MoviePojo moviePojo;
	private List<MoviePojo> movieList;

	public Status getMovieByDifferentType(String category, String country, String release_time,
			int is_vip_movie,String otherType) {

		movieList = movieDao.getMovieByDifferentType(category, country, release_time, is_vip_movie,otherType);
		return new Status().check(movieList);
	}

	public Status getMovieByname(String name) {
		movieList=movieDao.getMovieByname(name);
		return new Status().check(movieList);
	}

	public Status getRanklist() {
		movieList=movieDao.getRanklist();
		return new Status().check(movieList);
	}

	public Status getMovieByID(int id) {
		moviePojo=movieDao.getMovieByID(id);
		return new Status().check(moviePojo);
	}

}
