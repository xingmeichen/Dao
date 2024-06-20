## maven repository
https://mvnrepository.com/

## Command
### To skip test
mvn clean install -Dmaven.test.skip=true
mvn clean install -DskipTests

### show maven version (can view which jdk has been bundled also)
mvn -version

### build with profiles
mvn clean package -Pdev (dev means profile)

### run spring-boot
mvn spring-boot:run

### run spring-boot with profile
mvn spring-boot:run -Dspring-boot.run.profiles=local (local means profile)




