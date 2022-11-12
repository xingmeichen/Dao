## com.dao.ioc.bean.gc 包下介绍Spring Bean 被 GC
1. 销毁BeanFactory中的单例Bean
ConfigurableBeanFactory#destroySingletons
2. 强制GC
System#gc()