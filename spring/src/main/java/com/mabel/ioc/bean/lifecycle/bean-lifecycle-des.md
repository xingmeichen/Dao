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

### Spring Bean Definition 合并
1. RootBeanDefinition
2. GenericBeanDefinition
3. 

### Spring Bean Class 加载
1. ClassLoader

### Spring Bean 实例化前
1. InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation
### Spring Bean 实例化
1. 传统实例化方法
实例化策略 InstantiationStrategy，它又包括两种实现方式 SimpleInstantiationStrategy, CglibSubclassingInstantiationStrategy 
BeanWrapper
2. 构造器依赖注入
构造器注入是按照类型注入，resolveDependency
### Spring Bean 实例化后
1. InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation  
   ---> 返回值表示是否忽略配置元信息的时候拥有的属性值,也就是否进行属性赋值，该方法返回false则不进行属性赋值
   
### 属性赋值前
1. PropertyValues
2. InstantiationAwareBeanPostProcessor#postProcessProperties

### Aware接口回调 (以下按执行的顺序列出)
1. BeanNameAware
2. BeanClassLoaderAware
3. BeanFactoryAware
4. EnvironmentAware
5. EmbeddedValueResolverAware
6. 