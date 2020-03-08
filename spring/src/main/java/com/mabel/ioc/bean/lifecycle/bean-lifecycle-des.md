## com.mabel.ioc.bean.lifecycle 这个包下介绍Spring Bean的生命周期

### Spring 元信息配置
1. 基于xml文件或者property文件的配置
2. 基于注解的配置，如 @Configuration @Component（@Repository @Service @Controller） @Bean
3. 基于API的配置

### Spring Bean 元信息解析
1. AnnotatedBeanDefinitionReader

### Spring Bean 注册
1. register 方法
2. BeanDefinition
3. DefaultListableBeanFactory#beanDefinitionMap 保存 BeanDefinition 的一个 ConcurrentHashMap（它保证了线程安全，但是是无序的）
4. DefaultListableBeanFactory#beanDefinitionNames 保存 BeanDefinition 名称的一个 ArrayList，它记住了Spring Bean 注册的顺序