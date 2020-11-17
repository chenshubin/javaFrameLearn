package cn.murphy.springbootLearning.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * spring工具类，为了更方便的获取spring的applicationContext  直接实现接口ApplicationContextAware
 */
@Component
public class SpringUtils implements ApplicationContextAware {

    private Logger logger = Logger.getLogger("SpringUtils.class");
    
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtils.applicationContext == null) {
            SpringUtils.applicationContext = applicationContext;
        }
        logger.info(
                "========ApplicationContext配置成功,在普通类可以通过调用" +
                        "SpringUtils.getApplicationContext()获取applicationContext对象,applicationContext="
                        + SpringUtils.applicationContext + "========");

    }


    /**
     * 获取spring上下午
     *
     * @return
     */
    public static ApplicationContext getApplicationContext()  {
        return applicationContext;
    }

    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

    public static <T> Object getBean(Class<T> class1) {
        return applicationContext.getBean(class1);
    }

    public static <T> Object getBean(Class<T> class1, String beanName) {

        return applicationContext.getBean(class1, beanName);
    }

}
