package test.interceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.yewei.service.aop.log.MyLogService;
public class Test extends AbstractTransactionalJUnit4SpringContextTests {  

	
	// main 用于查看spring所有bean,以此可以检测spring容器是否正确初始化
    public static void main(String[] args) throws Exception {
        // 我这里使用的是绝对路径，请根据你项目的路径来配置（相对路径挖不出来-OUT了）
    	
    	ApplicationContext ctx=new FileSystemXmlApplicationContext("D:/eclipWorkspace/DepositServicePool/WebContent/WEB-INF/applicationContext-web.xml");  
    	MyLogService eventService=(MyLogService) ctx.getBean("myLogService");  
    	
    	eventService.log1("叶炜");
    	eventService.log2("叶炜","吃饭");
    }
	
}
