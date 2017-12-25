package test.interceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.yewei.service.aop.log.MyLogService;
public class Test extends AbstractTransactionalJUnit4SpringContextTests {  

	
	// main ���ڲ鿴spring����bean,�Դ˿��Լ��spring�����Ƿ���ȷ��ʼ��
    public static void main(String[] args) throws Exception {
        // ������ʹ�õ��Ǿ���·�������������Ŀ��·�������ã����·���ڲ�����-OUT�ˣ�
    	
    	ApplicationContext ctx=new FileSystemXmlApplicationContext("D:/eclipWorkspace/DepositServicePool/WebContent/WEB-INF/applicationContext-web.xml");  
    	MyLogService eventService=(MyLogService) ctx.getBean("myLogService");  
    	
    	eventService.log1("Ҷ�");
    	eventService.log2("Ҷ�","�Է�");
    }
	
}
