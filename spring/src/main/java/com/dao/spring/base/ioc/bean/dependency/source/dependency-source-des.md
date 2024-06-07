## ioc.bean.dependency.source 这个包下介绍依赖涞源
### 依赖查找的涞源
1. Spring BeanDefinition （xml元数据配置 或者 @Bean 实现）
2. 单例对象 （通过API实现）

### 依赖注入的涞源
1. Spring BeanDefinition
2. 单例对象 （通过API实现）
3. 非Spring容器管理对象 （ResolvableDependency）