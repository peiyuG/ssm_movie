package ssm_movie;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import commons.RequestStatusException;
import commons.Status;
import controller.demo.Demo;
import controller.demo.impl.DemoImpl;
import pojo.demo.DemoPojo;
import service.certification.CertificationService;
import service.certification.impl.CertificationServiceImpl;
import service.demo.DemoService;
import service.demo.impl.DemoServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class ImplTest {

	@Resource
	private CertificationService Impl;

	public ImplTest() {
		Impl = new CertificationServiceImpl();
	}

	@Test
	public void test() throws RequestStatusException {
		// System.out.println(serviceImpl.selectFilm());
		Impl.update("444");
	}
}
