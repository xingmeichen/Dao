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