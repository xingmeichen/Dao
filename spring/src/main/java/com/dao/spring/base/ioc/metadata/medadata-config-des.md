## ioc.metadata 包下介绍Spring对于元数据的配置有哪些方式，它们分别是怎么做的
### 基于文件的配置
1. 基于xml文件的配置
2. 基于property文件的配置

### 基于注解的配置
1. @Configuration
2. @Component (继承了它的常用的注解还有@Repository @Service @Controller)
3. @Bean
#### 基于注解的配置相关的代码实现支持
1. ClassPathScanningCandidateComponentProvider

### 基于API的配置 (如下列出的是在实现过程中用到的相关的类)
1. BeanDefinition
2. BeanDefinitionBuilder
