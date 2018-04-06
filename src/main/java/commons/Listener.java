package commons;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author wujia 
 * @since 2018/4/5 16:03
 * @description:暂时无多大用处
 */
@WebListener
public class Listener implements ServletContextListener {

	private Date d;
	private SimpleDateFormat sdf;

	public Listener() {
		d = new Date();
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {

		System.out.println("开始监听！");
		System.out.println("当前时间为：" + sdf.format(d));

	}

}
