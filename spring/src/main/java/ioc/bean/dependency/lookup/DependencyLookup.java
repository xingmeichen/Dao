package ioc.bean.dependency.lookup;

import common.Person;
import common.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.UserFactory;

/**
 * @project: JavaLearning
 * @description:  依赖查找
 * @author: Mabel.Chen
 * @create: 2020-02-13 12:15
 **/
public class DependencyLookup {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(UserFactory.class).getBeanDefinition();
        applicationContext.registerBeanDefinition("userFactory", beanDefinition);
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        reader.loadBeanDefinitions("classpath:/META-INFO/dependency-lookup.xml");
        // 手动启动应用上下文
        applicationContext.refresh();

        /**
         * 对于 xml 文件中的 bean 的 lookup-method属性说明：
         * 它用来指示Spring去注入/重写该方法，以便从容器中返回特定的bean，
         * 一般这种情况下，需要被返回的这个bean的作用域是是non-singleton
         *
         * 注意看 dependency-lookup.xml 配置文件，配置了lookup也就是依赖查找之后，UserFactory被增强（Enhance）了，
         * createUser实际上并没有被调用，也就是createUser被覆盖掉了，对与user这个Bean的创建交给了Spring容器去做，
         * 所以如下的结果中，因为user这个Bean的作用域是singleton, 故而 user == user1 是 true
         * 如果没有为UserFactory配置lookup,那么UserFactory没有被增强，user 分别调用了 user1
         * */
        UserFactory userFactory = (UserFactory) applicationContext.getBean("userFactory");
        User user = userFactory.createUser();
        User user1 = userFactory.createUser();
        System.out.println(user == user1);

        // 手动关闭应用上下文
        applicationContext.close();
    }
}