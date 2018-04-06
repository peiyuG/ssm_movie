package movie;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import commons.RequestStatusException;
import commons.Status;
import service.movie.MovieService;
import service.movie.impl.MovieServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class ServiceImplTest {

	@Resource
	private MovieService movieService;

	public ServiceImplTest() {
		movieService=new MovieServiceImpl();
	}

	@Test
	public void test() throws RequestStatusException {
		// System.out.println(serviceImpl.selectFilm());
		Status status =movieService.getMovieByID(1);
		System.out.println(status.toString());
	}
}
