package ioc.bean.dependency.source;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ResourceLoader;

/**
 * @project: JavaLearning
 * @description: Bean 依赖
 * @author: Mabel.Chen
 * @create: 2020-02-13 11:19
 **/
public class BeanDependency {

    /***
     *  @Autowired 注入在 postProcessProperty方法执行，早于setter注入，也早于@PostConstruct注入
     * */
    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private ResourceLoader resourceLoader;


    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(BeanDependency.class);
        annotationConfigApplicationContext.refresh();

        // 该语句会报 NoSuchBeanDefinitionException 异常
        BeanFactory bean = annotationConfigApplicationContext.getBean(BeanFactory.class);
        System.out.println(bean);



        annotationConfigApplicationContext.close();
    }

}