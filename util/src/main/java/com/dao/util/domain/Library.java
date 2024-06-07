package com.dao.util.domain;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.List;

/**
 * @project: dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-07
 **/
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Library {

    @XmlElement
    private List<Book> books;
}