# SpingBoot Starter

## To create a SpringBoot starter
1. create a maven project
2. add spring-boot-starter dependency in pom.xml file
3. create auto configuration java file eg. MyAutoConfiguration.java
4. config auto configuration java file in resources/META_INFO/spring.factories
eg. org.springframework.boot.autoconfigure.EnableAutoConfiguration=MyAutoConfiguration
5. build & publish your starter