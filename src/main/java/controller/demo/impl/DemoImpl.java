package controller.demo.impl;

import commons.RequestStatusException;
import commons.Status;
import controller.demo.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pojo.demo.DemoPojo;
import service.demo.DemoService;

/**
 * : chuyunfei : 2018/3/2
 */
@Controller
@RequestMapping("/demo")
public class DemoImpl implements Demo {

	private DemoService demoService;

	@RequestMapping("/getDemoById")
	@ResponseBody
	public Status getDemoById(int id) {
		System.out.println(id);

		DemoPojo demoPojo = demoService.getDemoById(id);

		return new Status(1, "获取成功", demoPojo);
	}

	@RequestMapping("/fileUpload")
	@ResponseBody
	public Status fileUpload(@RequestParam MultipartFile file) {

		if (file.getSize() > 0) {
			System.out.println(file.getOriginalFilename());
			return new Status(1, "上传成功", null);
		} else {
			return new Status(0, "文件不能为空", null);
		}
	}

	@RequestMapping("/error")
	@ResponseBody
	public Status error() throws RequestStatusException {

		System.out.println("11");
		throw new RequestStatusException("资源找不到！", 404);
	}

	@Autowired
	public void setDemoService(DemoService demoService) {
		this.demoService = demoService;
	}
}
