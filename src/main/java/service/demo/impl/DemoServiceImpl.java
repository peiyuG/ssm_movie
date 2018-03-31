package service.demo.impl;

import dao.demo.DemoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.demo.DemoPojo;
import service.demo.DemoService;

import javax.annotation.Resource;

/**
 * : chuyunfei : 2018/3/1
 */
@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	private DemoDao demoDao;

	public DemoPojo getDemoById(int id) {

		DemoPojo demo = demoDao.getDemoById(id);

		return demo;
	}
}
