package test.servicepool;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yewei.service.adapter.DepositVendorService;
public class Test extends AbstractTransactionalJUnit4SpringContextTests {  
	@org.junit.Test
	public void test2() throws Exception {
		 
	}
	 // main 用于查看spring所有bean,以此可以检测spring容器是否正确初始化
    public static void main(String[] args) throws Exception {
        // 我这里使用的是绝对路径，请根据你项目的路径来配置（相对路径挖不出来-OUT了）
    	
//        String []  path = {"D:/eclipWorkspace/DepositServicePool/WebContent/WEB-INF/springmvc.xml"};
//        ApplicationContext ac = new FileSystemXmlApplicationContext(path);
//        String[] beans = ac.getBeanDefinitionNames();
//       
//        System.out.println("main");
//        for(String s : beans) {
//        	System.out.println(s);    // 打印bean的name
//        }
    	
    	ApplicationContext ctx=new FileSystemXmlApplicationContext("D:/eclipWorkspace/DepositServicePool/WebContent/WEB-INF/applicationContext-springmvc.xml");  
    	DepositVendorService depositVendorService=(DepositVendorService) ctx.getBean("depositVendorService");  
    	
    	depositVendorService.deposit("wechat");
    	depositVendorService.deposit("pingpp");
    	depositVendorService.deposit("unionpay");
    }
	
}
