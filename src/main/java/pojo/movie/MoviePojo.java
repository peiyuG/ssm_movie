package pojo.movie;

/**
 * @author wujia 
 * @since 2018/4/5 16:03
 * @description:电影的实体类，属性对应数据库t_movie表中字段
 */
public class MoviePojo {

	String name;
	double score;
	String category;
	String intro;
	String url;
	int id;
	String country;
	String release_time;
	int is_vip_movie;
	int click_volume;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the score
	 */
	public double getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(double score) {
		this.score = score;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the intro
	 */
	public String getIntro() {
		return intro;
	}

	/**
	 * @param intro
	 *            the intro to set
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the release_time
	 */
	public String getRelease_time() {
		return release_time;
	}

	/**
	 * @param release_time
	 *            the release_time to set
	 */
	public void setRelease_time(String release_time) {
		this.release_time = release_time;
	}

	/**
	 * @return the is_vip_movie
	 */
	public int getIs_vip_movie() {
		return is_vip_movie;
	}

	/**
	 * @param is_vip_movie
	 *            the is_vip_movie to set
	 */
	public void setIs_vip_movie(int is_vip_movie) {
		this.is_vip_movie = is_vip_movie;
	}

	/**
	 * @return the click_volume
	 */
	public int getClick_volume() {
		return click_volume;
	}

	/**
	 * @param click_volume
	 *            the click_volume to set
	 */
	public void setClick_volume(int click_volume) {
		this.click_volume = click_volume;
	}

	@Override
	public String toString() {
		return "MoviePojo [name=" + name + ", score=" + score + ", category=" + category + ", intro=" + intro + ", url="
				+ url + ", id=" + id + ", country=" + country + ", release_time=" + release_time + ", is_vip_movie="
				+ is_vip_movie + ", click_volume=" + click_volume + "]";
	}
	
	

}
