package domain.repository;

import domain.User;
import lombok.Data;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2020-02-14 11:23
 **/
@Data
public class UserRepository {

    private Collection<User> users;

    /**
     * 内建非Bean对象（依赖）
     * */
    private BeanFactory beanFactory;

    private ObjectFactory<ApplicationContext> applicationContext;
}