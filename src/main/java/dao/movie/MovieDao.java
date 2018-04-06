package dao.movie;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.movie.MoviePojo;

/**
 * @author wujia 
 * @since 2018/4/5 16:03
 * @description:mapper映射类
 */
public interface MovieDao {

	/*
	 * 根据不同类型返回电影pojo集合
	 */
	List<MoviePojo> getMovieByDifferentType(
			@Param("category")String category,
			@Param("country")String country,
			@Param("release_time")String release_time,
			@Param("is_vip_movie")int is_vip_movie,
			@Param("otherType")String otherType);

	/*
	 * 根据电影名返回同名的该类电影的pojo集合
	 */
	List<MoviePojo> getMovieByname(@Param("name")String name);
	
	/*
	 * 返回点击量最大的部分电影pojo集合
	 */
	
	List<MoviePojo> getRanklist();
	/*
	 * 根据电影ID返回该电影的单个pojo
	 */
	
	MoviePojo getMovieByID(@Param("id")int id);
}
