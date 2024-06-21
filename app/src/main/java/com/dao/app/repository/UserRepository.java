package com.dao.app.repository;

import com.dao.app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-21
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(name = "select * from user where userName = :userName limit 1", nativeQuery=true)
    User queryByUserName(String userName);
}