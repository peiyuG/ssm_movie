package commons;

import java.util.List;

import com.github.pagehelper.PageInfo;

import pojo.movie.MoviePojo;

public class PageStatus extends Status{

	//将用于返回数据的总量
	private int totalData;	
	
	public int getTotalData() {
		return totalData;
	}

	public void setTotalData(int totalData) {
		this.totalData = totalData;
	}
	
	public PageStatus(){};
	
	public PageStatus(Integer statue, String message, Object data,int totalData) {
		super.setStatue(statue);
		super.setMessage(message);
		super.setData(data);
	    this.totalData=totalData;
	}
	
	//用于分类查询电影数据为空检查与返回
		public PageStatus MovieCheck(List<MoviePojo> movieList){
			PageInfo page = new PageInfo(movieList);
			totalData=(int) page.getTotal();
			System.out.println(totalData);
			if(totalData!=0){
				return new PageStatus(1,"获取成功",movieList,totalData);
			}else{
				return new PageStatus(0,"获取失败",null,0);
			}
		}
}
