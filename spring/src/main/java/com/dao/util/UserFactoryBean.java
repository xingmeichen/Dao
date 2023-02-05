package com.dao.util;

import com.dao.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @project: Dao
 * @description: {@link org.springframework.beans.factory.FactoryBean}
 * @author: Mabel.Chen
 * @create: 2020-02-15 10:39
 **/
public class UserFactoryBean implements FactoryBean {

    @Override
    public User getObject() {
        return User.createUser();
    }

    @Override
    public Class<User> getObjectType() {
        return User.class;
    }
}