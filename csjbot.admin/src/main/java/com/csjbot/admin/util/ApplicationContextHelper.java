package com.csjbot.admin.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

  
/**          
 * Description 非controller调用spring注入方法
 * @author CJay       
 * @created 2017年3月23日 下午2:47:34    
 */

public class ApplicationContextHelper implements ApplicationContextAware {

    private static ApplicationContext appCtx;

    @Override
    public void setApplicationContext( ApplicationContext applicationContext ) throws BeansException {
        appCtx = applicationContext;
    }

    public static Object getBean( String beanName ) {
        return appCtx.getBean( beanName );
    }

    public static <T> T getBean(Class<T> clz) {
        return (T)appCtx.getBean(clz);
    }

}