package com.dao.base.feature;

import com.dao.base.common.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

/**
 * @project: dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-07
 **/
// since 15
public class BlockText {

    public static void main(String[] args) throws Exception {
        String json = """
                {
                    "id": "111111",
                    "userName": "Testing",
                    "birthday": 1717692673644
                }
                """;
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(json, User.class);
        System.out.println(user);
        String s = objectMapper.writeValueAsString(new Date());
    }
}