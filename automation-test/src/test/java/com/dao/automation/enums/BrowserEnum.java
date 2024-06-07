package com.dao.automation.enums;

import java.util.Arrays;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2021-10-12 15:45
 **/
public enum BrowserEnum {

    CHROME("chrome"),
    INTERNET_EXPLORER("ie"),
    EDGE("edge"),
    UNKNOWN("");

    private String name;

    BrowserEnum(String name) {
        this.name = name;
    }

    public static BrowserEnum getEnumByName(String name) {
        return Arrays.stream(BrowserEnum.values())
                .filter(item -> item.name.equals(name)).findFirst().orElse(UNKNOWN);
    }
}