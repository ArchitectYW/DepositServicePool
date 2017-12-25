package com.yewei.model.interceptor.aop.log;

import java.io.StringReader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.aspectj.lang.reflect.MethodSignature;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Aspect
@Component
public class LogInterceptor {

    private final int coreThreadPoolSize =5;

    private ExecutorService asyncTaskExecutor = Executors.newFixedThreadPool(coreThreadPoolSize);

    private Long time;

    @Pointcut("@annotation(com.yewei.model.interceptor.aop.log.AutoLog)")
    public void autologAction() {
    }

    @Before("autologAction()")
    public void beforeAutologAction(JoinPoint jp) throws JsonProcessingException {
    	time = System.currentTimeMillis();
    }

    @After("autologAction()")
    public void afterAutologAction(JoinPoint jp) throws JsonProcessingException, NoSuchMethodException, InterruptedException, Exception {
        try {
        	
            Signature signature = jp.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            Method method = methodSignature.getMethod();

            AutoLog annotation = method.getAnnotation(AutoLog.class);

            String value = annotation.value();

            System.out.println("value:" + value);
            
            LogSaveBean bean = new LogSaveBean();
            
            bean.setMethod(jp.getSignature().getName());
            bean.setProject("myTest");

            Map<String, Object> templateData = new HashMap<>();
            

            Object[] args = jp.getArgs();
            for (int i = 0; i < args.length; ++i) {
                templateData.put("arg" + i, args[i]);
            }

            Template template = new Template(bean.getProject() + "-" + bean.getMethod(), new StringReader(value), new Configuration());

            String processTemplateIntoString = FreeMarkerTemplateUtils.processTemplateIntoString(template, templateData);

            bean.setOperationDetail(processTemplateIntoString);
            
            

            bean.setMethod(signature.getName());

            //²Ù×÷Ê±¼ä
            bean.setOperationTime(System.currentTimeMillis() - time);
            
            System.out.println(bean.toString());

            asyncTaskExecutor.submit(new Callable<String>() {

				@Override
				public String call() throws Exception {
					// TODO Auto-generated method stub
					System.out.println(bean.toString());
					return null;
				}
            });

        } catch (Exception e) {
        }
    }
    
}
