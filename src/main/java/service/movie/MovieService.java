package service.movie;

import commons.PageStatus;
import commons.Status;

/**
 * @author wujia 
 * @since 2018/4/5 16:03
 * @description:电影模块服务层接口
 */
public interface MovieService {

	/*
	 * 根据不同类型返回电影pojo集合
	 */
	public PageStatus getMovieByDifferentType(Integer pageNum,Integer pageSize,String category, 
			String country, String release_time, int is_vip_movie,String otherType);
   
	/*
	 * 根据电影名返回同名的该类电影的pojo集合
	 */
	public Status getMovieByname(String name);
	/*
	 * 返回点击量最大的部分电影pojo集合
	 */
	public Status getRanklist();
    
    /*
	 * 根据电影ID返回该电影的单个pojo
	 */
	public Status getMovieByID(int id);
	
	/*
	 * 返回部分国家电影点击量最大的前8个电影数据，用于“热播榜”
	 */
	public Status getMovieByType();
}
