package dao.demo;

import org.springframework.stereotype.Repository;
import pojo.demo.DemoPojo;

public interface DemoDao {

	DemoPojo getDemoById(int id);
}
