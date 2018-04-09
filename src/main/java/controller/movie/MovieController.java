package controller.movie;


import commons.RequestStatusException;
import commons.Status;
import service.movie.MovieService;

/**
 * Created by wujia on 2018/4/1.
 * @description:电影数据控制层接口
 */
public interface MovieController {

	/*
	 * 根据不同类别进行判断，返回该组类别所有电影信息（用于片库）
	 */
	Status getMovieByDifferentType(Integer startPage, Integer PageSize, String category, String country,
			String release_time, int is_vip_movie, String otherType);

	/*
	 * 根据电影名搜索（全网搜先实现站内搜索）
	 */
	Status getMovieByname(String name);

	/*
	 * 返回点击量最大的前十条，用于（最近热搜）
	 */
	Status getRanklist();

	/*
	 * 根据电影ID返回该电影所有信息
	 */
	Status getMovieByID(int id);

	Status error() throws RequestStatusException;

	void setMovieService(MovieService movieService);
}
