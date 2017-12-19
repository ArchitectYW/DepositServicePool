package com.yewei.core;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.yewei.utils.YeweiReflectionUtils;
import com.yewei.utils.YeweiStringUtils;

/**
 *
 * @author lucy
 */
public abstract class YeweiServicePoolBase<Tp> implements BeanPostProcessor {
	public YeweiServicePoolBase() {  
        super();  
        System.out.println("这是YeweiServicePoolBase实现类构造器！！");          
     }  
	
	
    protected final Map<String, Tp> servicePool = new ConcurrentHashMap<>();

	@SuppressWarnings("unchecked")
	private final Class<Tp> serviceClass = 
			(Class<Tp>) ((ParameterizedType) YeweiReflectionUtils.
					getOriginalClassWithoutProxy(this).
					getGenericSuperclass()).
					getActualTypeArguments()[0];

    public List<Tp> getAllServices(){
        return new ArrayList<>(servicePool.values());
    }

    public List<String> getAllServiceKeys(){
        return new ArrayList<>(servicePool.keySet());
    }

    public Tp getServiceFromPool(String tp) {
        return servicePool.get(tp);
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    	if (serviceClass.isAssignableFrom(bean.getClass())) {
            Tp theServiceBean = (Tp) bean;
            String theBeanName = getServiceBeanName(theServiceBean);
            if (YeweiStringUtils.isNotEmpty(theBeanName)) {
                servicePool.put(theBeanName, theServiceBean);
            }
        }
        return bean;
    }

    public abstract String getServiceBeanName(Tp theServiceBean);
    
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    	System.out.println("bean处理器：bean创建之后.."+beanName); 
    	System.out.println("pool"+servicePool.toString()); 
    	return bean;
    }
    
}

