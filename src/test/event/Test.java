package test.event;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.yewei.service.event.EventService;
public class Test extends AbstractTransactionalJUnit4SpringContextTests {  
	@org.junit.Test
	public void test2() throws Exception {
		 
	}
	 // main ���ڲ鿴spring����bean,�Դ˿��Լ��spring�����Ƿ���ȷ��ʼ��
    public static void main(String[] args) throws Exception {
        // ������ʹ�õ��Ǿ���·�������������Ŀ��·�������ã����·���ڲ�����-OUT�ˣ�
    	
    	ApplicationContext ctx=new FileSystemXmlApplicationContext("D:/eclipWorkspace/DepositServicePool/WebContent/WEB-INF/springmvc.xml");  
    	EventService eventService=(EventService) ctx.getBean("eventService");  
    	
    	eventService.userRegister("Ҷ�");
    }
	
}
