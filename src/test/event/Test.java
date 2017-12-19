package test.event;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.yewei.service.event.EventService;
public class Test extends AbstractTransactionalJUnit4SpringContextTests {  
	@org.junit.Test
	public void test2() throws Exception {
		 
	}
	 // main 用于查看spring所有bean,以此可以检测spring容器是否正确初始化
    public static void main(String[] args) throws Exception {
        // 我这里使用的是绝对路径，请根据你项目的路径来配置（相对路径挖不出来-OUT了）
    	
    	ApplicationContext ctx=new FileSystemXmlApplicationContext("D:/eclipWorkspace/DepositServicePool/WebContent/WEB-INF/springmvc.xml");  
    	EventService eventService=(EventService) ctx.getBean("eventService");  
    	
    	eventService.userRegister("叶炜");
    }
	
}
