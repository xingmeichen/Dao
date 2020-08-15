## com.mabel.ioc.annotation 这个包下介绍注解
### 用于配置元信息的注解
1. @Component @Repository @Service @Controller @ RestController
2. @Configuration 
3. @Bean
与以上注解相关的类
AnnotatedBeanDefinitionReader.java
ClassPathScanningCandidateComponentProvider.java 
 

### 用于注入的注解
1. @Autowired （AutowiredAnnotationBeanPostProcessor.java）
2. @Resource (CommonAnnotationBeanPostProcessor.java)

### 
1. @PostConstruct ()
2. @PreDestroy

### @Configuration 和 @Component的一点区别
1. @Configuration 注解相当于 xml文件里的 </beans>, 
添加了@Configuration注解的类，同一类型的Bean是在Spring上下文中是唯一的，
而 @Component注解的类则不是，详情请看 ConfigurationAnnotationDemo, 
ComponentAnnotationDemo这两个类的结果
具体原因如下：