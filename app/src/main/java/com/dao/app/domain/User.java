package com.dao.app.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-20
 **/
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    private Long id;
    private String userName;
}