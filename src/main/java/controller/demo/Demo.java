package controller.demo;

import commons.RequestStatusException;
import commons.Status;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pojo.demo.DemoPojo;
import service.demo.DemoService;

/**
 * : chuyunfei : 2018/3/1
 */
public interface Demo {

	public Status getDemoById(int id);

	public Status fileUpload(@RequestParam MultipartFile file);

	public Status error() throws RequestStatusException;

	public void setDemoService(DemoService demoService);

}
